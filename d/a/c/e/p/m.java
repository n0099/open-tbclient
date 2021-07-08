package d.a.c.e.p;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes7.dex */
public class m {
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

    public static void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void c(SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, sQLiteStatement) == null) || sQLiteStatement == null) {
            return;
        }
        try {
            sQLiteStatement.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void d(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static void e(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream) == null) || inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void f(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, outputStream) == null) || outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void g(Reader reader) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, reader) == null) || reader == null) {
            return;
        }
        try {
            reader.close();
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void h(Writer writer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, writer) == null) || writer == null) {
            return;
        }
        try {
            writer.close();
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
