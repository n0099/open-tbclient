package d.b.c.e.m;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
public class a {
    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void d(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void e(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
