package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ExecuteAround {
    /**
     * 环绕执行模式
     * 对于不同的行为需要不同的代码
     */
    public String processFile(String file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine();
        }
    }

    /**
     * 考虑将行为参数化
     */
    public String processFile2(BufferedReaderProcess process, String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return process.process(br);
        }
    }
}

@FunctionalInterface
interface BufferedReaderProcess {
    String process(BufferedReader b) throws IOException;
}