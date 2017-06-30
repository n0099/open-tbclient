package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.service.aw;
/* loaded from: classes2.dex */
public class MiTinyDataClient {
    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("MiTinyDataClient.init(Context, String). Context can not be null");
        } else if (str == null) {
            com.xiaomi.channel.commonutils.logger.b.d("MiTinyDataClient.init(Context, String). Channel can not be null.");
        } else {
            aw.a().a(str);
        }
    }

    public static boolean upload(int i, String str, String str2, long j, String str3) {
        return aw.a().a(i, str, str2, j, str3, false);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        return upload(0, str, str2, j, str3);
    }
}
