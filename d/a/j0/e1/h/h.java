package d.a.j0.e1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static h f53598a;

    public static h e() {
        if (f53598a == null) {
            synchronized (h.class) {
                if (f53598a == null) {
                    f53598a = new h();
                }
            }
        }
        return f53598a;
    }

    public SQLiteStatement a(String str) {
        SQLiteDatabase c2;
        if (TextUtils.isEmpty(str) || (c2 = g.c()) == null) {
            return null;
        }
        try {
            return c2.compileStatement(str);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase c2 = g.c();
        if (c2 == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return c2.delete(str, str2, strArr) > 0;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        SQLiteDatabase c2 = g.c();
        if (c2 == null) {
            return;
        }
        BdLog.i("begin commit transaction");
        if (c2.inTransaction()) {
            try {
                c2.setTransactionSuccessful();
                c2.endTransaction();
                return;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "endTransaction", new Object[0]);
                BdLog.e(e2.getMessage());
                return;
            }
        }
        BdLog.e("there is no current transaction");
    }

    public boolean d(String str) {
        SQLiteDatabase c2 = g.c();
        if (c2 == null) {
            return false;
        }
        try {
            c2.execSQL(str);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public long f(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return -1L;
        }
        try {
            return sQLiteStatement.executeInsert();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return -1L;
        }
    }

    public long g(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase c2 = g.c();
        if (c2 == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return c2.insert(str, str2, contentValues);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return -1L;
        }
    }

    public Cursor h(String str, String[] strArr) {
        SQLiteDatabase c2 = g.c();
        if (c2 == null) {
            return null;
        }
        try {
            return c2.rawQuery(str, strArr);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage() + str);
            return null;
        }
    }

    public void i() {
        SQLiteDatabase c2 = g.c();
        if (c2 == null) {
            return;
        }
        if (c2.inTransaction()) {
            BdLog.e("there is exist transaction");
            return;
        }
        try {
            c2.beginTransaction();
            BdLog.i("db.beginTransaction");
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "startTransaction", new Object[0]);
            BdLog.e(e2.getMessage());
        }
    }

    public int j(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase c2 = g.c();
        if (c2 == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return c2.update(str, contentValues, str2, strArr);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return -1;
        }
    }
}
