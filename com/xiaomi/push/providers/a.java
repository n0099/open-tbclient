package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.xiaomi.channel.commonutils.logger.b;
/* loaded from: classes7.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f38826a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f823a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f824a = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", PmsConstant.Statistic.STATISTIC_NETWORK, " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f38826a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i2 = 0; i2 < f824a.length - 1; i2 += 2) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(f824a[i2]);
            sb.append(" ");
            sb.append(f824a[i2 + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f823a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                b.a(e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
