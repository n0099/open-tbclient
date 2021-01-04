package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.cb;
/* loaded from: classes6.dex */
public class by extends cb.e {

    /* renamed from: a  reason: collision with root package name */
    private String f14196a;

    public by(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f14196a = "MessageInsertJob";
        this.f14196a = str2;
    }

    public static by a(Context context, String str, hq hqVar) {
        byte[] a2 = iw.a(hqVar);
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hqVar.d());
        contentValues.put("messageItem", a2);
        contentValues.put("appId", bp.a(context).b());
        contentValues.put("packageName", bp.a(context).m194a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new by(str, contentValues, "a job build to insert message to db");
    }
}
