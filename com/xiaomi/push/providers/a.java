package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.channel.commonutils.logger.b;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {
    private static int b = 1;
    public static final Object a = new Object();
    private static final String[] c = {ETAG.KEY_PACKAGE_NAME, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", HttpConstants.NETWORK_TYPE, " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, b);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < c.length - 1; i += 2) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(c[i]).append(" ").append(c[i + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e) {
                b.a(e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
