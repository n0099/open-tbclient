package com.xiaomi.push.service;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class h extends SQLiteOpenHelper {
    private static h d;
    private static final String[] f = {"name", "TEXT NOT NULL", "appId", "INTEGER NOT NULL", Constants.PACKAGE_NAME, "TEXT NOT NULL", "create_time", "INTEGER NOT NULL", "type", "TEXT NOT NULL", "center_longtitude", "TEXT", "center_lantitude", "TEXT", "circle_radius", "REAL", "polygon_point", "TEXT", "coordinate_provider", "TEXT NOT NULL", "current_status", "TEXT NOT NULL"};
    private static final String[] g = {MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, "TEXT NOT NULL", "geo_id", "TEXT NOT NULL", "content", "BLOB NOT NULL", "action", "INTEGER NOT NULL", "deadline", "INTEGER NOT NULL"};
    public final Object a;
    private final String b;
    private AtomicInteger c;
    private SQLiteDatabase e;

    public h(Context context) {
        super(context, "geofencing.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.b = "GeoFenceDatabaseHelper.";
        this.a = new Object();
        this.c = new AtomicInteger();
    }

    public static h a(Context context) {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h(context);
                }
            }
        }
        return d;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder("CREATE TABLE geofence(id TEXT PRIMARY KEY ,");
            for (int i = 0; i < f.length - 1; i += 2) {
                if (i != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(f[i]).append(HanziToPinyin.Token.SEPARATOR).append(f[i + 1]);
            }
            sb.append(");");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (SQLException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder("CREATE TABLE geoMessage(");
            for (int i = 0; i < g.length - 1; i += 2) {
                if (i != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(g[i]).append(HanziToPinyin.Token.SEPARATOR).append(f[i + 1]);
            }
            sb.append(",PRIMARY KEY(message_id,geo_id));");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (SQLException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        }
    }

    public synchronized SQLiteDatabase a() {
        if (this.c.incrementAndGet() == 1) {
            this.e = getWritableDatabase();
        }
        return this.e;
    }

    public synchronized void b() {
        if (this.c.decrementAndGet() == 0) {
            this.e.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (this.a) {
            try {
                a(sQLiteDatabase);
                b(sQLiteDatabase);
                com.xiaomi.channel.commonutils.logger.b.c("GeoFenceDatabaseHelper. create tables");
            } catch (SQLException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
