package d.a.c.e.m;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, cursor) == null) || cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void b(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, inputStream) == null) || inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void d(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, outputStream) == null) || outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void e(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
