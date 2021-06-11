package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.cg;
/* loaded from: classes7.dex */
public class cd extends cg.e {

    /* renamed from: a  reason: collision with root package name */
    public String f41060a;

    public cd(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f41060a = "MessageInsertJob";
        this.f41060a = str2;
    }

    public static cd a(Context context, String str, hj hjVar) {
        byte[] a2 = ip.a(hjVar);
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put(MiPushMessage.KEY_MESSAGE_ID, "");
        contentValues.put("messageItemId", hjVar.d());
        contentValues.put("messageItem", a2);
        contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bu.a(context).b());
        contentValues.put("packageName", bu.a(context).m178a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new cd(str, contentValues, "a job build to insert message to db");
    }
}
