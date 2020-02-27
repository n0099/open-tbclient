package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.bw;
/* loaded from: classes8.dex */
public class bt extends bw.e {
    private String a;

    public bt(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = "MessageInsertJob";
        this.a = str2;
    }

    public static bt a(Context context, String str, hk hkVar) {
        byte[] a = iq.a(hkVar);
        if (a == null || a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hkVar.d());
        contentValues.put("messageItem", a);
        contentValues.put("appId", bk.a(context).b());
        contentValues.put("packageName", bk.a(context).m166a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new bt(str, contentValues, "a job build to insert message to db");
    }
}
