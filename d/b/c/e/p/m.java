package d.b.c.e.p;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.adp.lib.util.BdLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes.dex */
public class m {
    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void c(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                sQLiteStatement.close();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void e(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void f(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void g(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void h(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
