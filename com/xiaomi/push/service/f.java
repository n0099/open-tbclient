package com.xiaomi.push.service;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class f extends SQLiteOpenHelper {
    private static final String[] c = {"name", "TEXT NOT NULL", "appId", "INTEGER NOT NULL", "package_name", "TEXT NOT NULL", WBConstants.GAME_PARAMS_GAME_CREATE_TIME, "INTEGER NOT NULL", "type", "TEXT NOT NULL", "center_longtitude", "TEXT", "center_lantitude", "TEXT", "circle_radius", "REAL", "polygon_point", "TEXT", "coordinate_provider", "TEXT NOT NULL", "current_status", "TEXT NOT NULL"};
    private static final String[] d = {"message_id", "TEXT NOT NULL", "geo_id", "TEXT NOT NULL", "content", "BLOB NOT NULL", AuthActivity.ACTION_KEY, "INTEGER NOT NULL", "deadline", "INTEGER NOT NULL"};
    public final Object a;
    private final String b;

    public f(Context context) {
        super(context, "geofencing.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.b = "GeoFenceDatabaseHelper.";
        this.a = new Object();
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder("CREATE TABLE geofence(id TEXT PRIMARY KEY ,");
            for (int i = 0; i < c.length - 1; i += 2) {
                if (i != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(c[i]).append(" ").append(c[i + 1]);
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
            for (int i = 0; i < d.length - 1; i += 2) {
                if (i != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(d[i]).append(" ").append(c[i + 1]);
            }
            sb.append(",PRIMARY KEY(message_id,geo_id));");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (SQLException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
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
