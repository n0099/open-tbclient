package com.bytedance.sdk.openadsdk.preload.geckox.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f30208a;

    public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static b a(Context context) {
        if (f30208a == null) {
            synchronized (b.class) {
                if (f30208a == null) {
                    Context applicationContext = context.getApplicationContext();
                    f30208a = new b(applicationContext, "geckox_clean_statistic" + com.bytedance.sdk.openadsdk.preload.geckox.utils.a.c(context) + ".db", null, 1);
                }
            }
        }
        return f30208a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists geckox_clean_statistic (id integer primary key autoincrement,access_key text,channel text,clean_type integer,status integer,pkg_id integer,err_code integer,clean_strategy integer,clean_duration integer,err_msg text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void a(String str, String str2, int i, int i2, long j, int i3, String str3, long j2, int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("access_key", str);
        contentValues.put("channel", str2);
        contentValues.put("clean_type", Integer.valueOf(i));
        contentValues.put("status", Integer.valueOf(i2));
        contentValues.put(IntentConfig.PKG_ID, Long.valueOf(j));
        contentValues.put(PmsConstant.Statistic.STATISTIC_ERRCODE, Integer.valueOf(i3));
        contentValues.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str3);
        contentValues.put("clean_duration", Long.valueOf(j2));
        contentValues.put("clean_strategy", Integer.valueOf(i4));
        try {
            getWritableDatabase().insert("geckox_clean_statistic", null, contentValues);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "insert failed", e2);
        }
    }

    public List<StatisticModel.PackageStatisticModel> a() {
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = getWritableDatabase().query("geckox_clean_statistic", null, null, null, null, null, null);
        } catch (Exception e2) {
            e = e2;
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
                int i3 = cursor.getInt(cursor.getColumnIndex(PmsConstant.Statistic.STATISTIC_ERRCODE));
                String string3 = cursor.getString(cursor.getColumnIndex(PmsConstant.Statistic.STATISTIC_ERRMSG));
                int i4 = cursor.getInt(cursor.getColumnIndex("clean_strategy"));
                long j = cursor.getLong(cursor.getColumnIndex("clean_duration"));
                StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                packageStatisticModel.accessKey = string;
                packageStatisticModel.channel = string2;
                packageStatisticModel.statsType = Integer.valueOf(i2);
                packageStatisticModel.id = Long.valueOf(cursor.getInt(cursor.getColumnIndex(IntentConfig.PKG_ID)));
                if (i3 == 0) {
                    str = null;
                } else {
                    str = i3 + "";
                }
                packageStatisticModel.errCode = str;
                packageStatisticModel.errMsg = string3;
                packageStatisticModel.cleanType = Integer.valueOf(i);
                packageStatisticModel.cleanDuration = Long.valueOf(j);
                packageStatisticModel.cleanStrategy = Integer.valueOf(i4);
                arrayList.add(packageStatisticModel);
            } catch (Exception e3) {
                e = e3;
                cursor2 = cursor;
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "get all statistic failed!", e);
                cursor = cursor2;
                com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(cursor);
                return arrayList;
            }
        }
        getWritableDatabase().delete("geckox_clean_statistic", null, null);
        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(cursor);
        return arrayList;
    }
}
