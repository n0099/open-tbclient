package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.ci;
/* loaded from: classes10.dex */
public class cf extends ci.e {
    public String a;

    public cf(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = "MessageInsertJob";
        this.a = str2;
    }

    public static cf a(Context context, String str, hl hlVar) {
        byte[] a = ir.a(hlVar);
        if (a == null || a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put(MiPushMessage.KEY_MESSAGE_ID, "");
        contentValues.put("messageItemId", hlVar.d());
        contentValues.put("messageItem", a);
        contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bw.a(context).b());
        contentValues.put("packageName", bw.a(context).m305a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new cf(str, contentValues, "a job build to insert message to db");
    }
}
