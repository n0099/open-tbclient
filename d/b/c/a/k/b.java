package d.b.c.a.k;

import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.a.k.a;
import java.sql.SQLException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f41973a = null;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0549a f41974b = null;

    /* renamed from: c  reason: collision with root package name */
    public a f41975c;

    public b(a aVar) {
        this.f41975c = aVar;
    }

    public void a() {
        try {
            if (this.f41973a != null) {
                this.f41973a.close();
                this.f41973a = null;
            }
        } catch (Exception e2) {
            BdLog.e("closeDatabase：" + e2.getMessage());
        }
    }

    public boolean b() {
        boolean dropDatabase;
        synchronized (b.class) {
            a();
            try {
                dropDatabase = this.f41975c.dropDatabase(BdBaseApplication.getInst().getContext());
            } catch (Exception e2) {
                BdLog.e("deleteDatabase：" + e2.getMessage());
                this.f41973a = null;
                return false;
            }
        }
        return dropDatabase;
    }

    public final void c(boolean z) {
        synchronized (b.class) {
            if (this.f41973a == null || !this.f41973a.isOpen()) {
                try {
                    this.f41975c.setOnCreateCallback(this.f41974b);
                    this.f41973a = this.f41975c.getWritableDatabase();
                } catch (RuntimeException e2) {
                    if (z) {
                        i(e2, "ensureDatabaseReady");
                    } else {
                        throw e2;
                    }
                }
            }
        }
    }

    public boolean d(String str) {
        SQLiteDatabase f2 = f();
        if (f2 != null) {
            try {
                f2.execSQL(str);
                return true;
            } catch (Throwable th) {
                i(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public boolean e(String str, Object[] objArr) {
        SQLiteDatabase f2 = f();
        if (f2 != null) {
            try {
                f2.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                i(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return false;
    }

    public SQLiteDatabase f() {
        return g(true);
    }

    public SQLiteDatabase g(boolean z) {
        c(z);
        return this.f41973a;
    }

    public void h(String str, int i, String str2, Object... objArr) {
        try {
            BdStatisticsManager.getInstance().db(str, "", i, str2, objArr);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void i(Throwable th, String str) {
        if (th != null && (th instanceof SQLiteException)) {
            int i = -17;
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    b();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.f41973a = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.f41973a = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.f41973a = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.f41973a = null;
            } else if (!(th instanceof SQLiteMisuseException)) {
                this.f41973a = null;
            }
            h(str, i, th.getMessage(), new Object[0]);
        }
    }

    public Cursor j(String str, String[] strArr) throws Exception {
        SQLiteDatabase g2 = g(false);
        if (g2 != null) {
            return g2.rawQuery(str, strArr);
        }
        throw new SQLException("unable to open database.");
    }

    public void k(a.InterfaceC0549a interfaceC0549a) {
        this.f41974b = interfaceC0549a;
    }
}
