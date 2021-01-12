package com.bytedance.sdk.openadsdk.preload.geckox.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f7448a;

    private b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static b a(Context context) {
        if (f7448a == null) {
            synchronized (b.class) {
                if (f7448a == null) {
                    f7448a = new b(context.getApplicationContext(), "geckox_clean_statistic" + com.bytedance.sdk.openadsdk.preload.geckox.utils.a.c(context) + ".db", null, 1);
                }
            }
        }
        return f7448a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists geckox_clean_statistic (id integer primary key autoincrement,access_key text,channel text,clean_type integer,status integer,pkg_id integer,err_code integer,clean_strategy integer,clean_duration integer,err_msg text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i, int i2, long j, int i3, String str3, long j2, int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("access_key", str);
        contentValues.put("channel", str2);
        contentValues.put("clean_type", Integer.valueOf(i));
        contentValues.put("status", Integer.valueOf(i2));
        contentValues.put("pkg_id", Long.valueOf(j));
        contentValues.put("err_code", Integer.valueOf(i3));
        contentValues.put("err_msg", str3);
        contentValues.put("clean_duration", Long.valueOf(j2));
        contentValues.put("clean_strategy", Integer.valueOf(i4));
        try {
            getWritableDatabase().insert("geckox_clean_statistic", null, contentValues);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "insert failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<StatisticModel.PackageStatisticModel> a() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = getWritableDatabase().query("geckox_clean_statistic", null, null, null, null, null, null);
        } catch (Exception e) {
            e = e;
            cursor = null;
        }
        if (cursor == null) {
            return arrayList;
        }
        while (cursor.moveToNext()) {
            try {
                String string = cursor.getString(cursor.getColumnIndex("access_key"));
                String string2 = cursor.getString(cursor.getColumnIndex("channel"));
                int i = cursor.getInt(cursor.getColumnIndex("clean_type"));
                int i2 = cursor.getInt(cursor.getColumnIndex("status"));
                long j = cursor.getInt(cursor.getColumnIndex("pkg_id"));
                int i3 = cursor.getInt(cursor.getColumnIndex("err_code"));
                String string3 = cursor.getString(cursor.getColumnIndex("err_msg"));
                int i4 = cursor.getInt(cursor.getColumnIndex("clean_strategy"));
                long j2 = cursor.getLong(cursor.getColumnIndex("clean_duration"));
                StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                packageStatisticModel.accessKey = string;
                packageStatisticModel.channel = string2;
                packageStatisticModel.statsType = Integer.valueOf(i2);
                packageStatisticModel.id = Long.valueOf(j);
                packageStatisticModel.errCode = i3 == 0 ? null : i3 + "";
                packageStatisticModel.errMsg = string3;
                packageStatisticModel.cleanType = Integer.valueOf(i);
                packageStatisticModel.cleanDuration = Long.valueOf(j2);
                packageStatisticModel.cleanStrategy = Integer.valueOf(i4);
                arrayList.add(packageStatisticModel);
            } catch (Exception e2) {
                e = e2;
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "get all statistic failed!", e);
                com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(cursor);
                return arrayList;
            }
        }
        getWritableDatabase().delete("geckox_clean_statistic", null, null);
        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(cursor);
        return arrayList;
    }
}
