package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.cb;
/* loaded from: classes8.dex */
public class by extends cb.e {
    private String a;

    public by(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = "MessageInsertJob";
        this.a = str2;
    }

    public static by a(Context context, String str, hq hqVar) {
        byte[] a = iw.a(hqVar);
        if (a == null || a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hqVar.d());
        contentValues.put("messageItem", a);
        contentValues.put("appId", bp.a(context).b());
        contentValues.put("packageName", bp.a(context).m169a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new by(str, contentValues, "a job build to insert message to db");
    }
}
