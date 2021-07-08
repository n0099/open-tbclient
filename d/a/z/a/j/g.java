package d.a.z.a.j;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String b(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) ? c(inputStream, null) : (String) invokeL.objValue;
    }

    public static String c(InputStream inputStream, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, str)) == null) {
            if (inputStream != null) {
                if (TextUtils.isEmpty(str)) {
                    str = System.getProperty("file.encoding", "utf-8");
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[4096];
                for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
                    stringWriter.write(cArr, 0, read);
                }
                String stringWriter2 = stringWriter.toString();
                inputStreamReader.close();
                stringWriter.close();
                return ("utf-8".equalsIgnoreCase(str) && stringWriter2.startsWith(ResultParser.BYTE_ORDER_MARK)) ? stringWriter2.substring(1) : stringWriter2;
            }
            throw new IllegalArgumentException("stream may not be null.");
        }
        return (String) invokeLL.objValue;
    }
}
