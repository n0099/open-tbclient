package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.id;
import com.xiaomi.push.ii;
import com.xiaomi.push.ir;
import com.xiaomi.push.ix;
/* loaded from: classes10.dex */
public class n {
    public static ii a(id idVar) {
        byte[] m631a = idVar.m631a();
        ii iiVar = new ii();
        try {
            ir.a(iiVar, m631a);
            return iiVar;
        } catch (ix unused) {
            return null;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] b = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (b != null) {
                ak.m762a(context, y.a(b), b);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m181a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ", th);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m181a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.b(com.xiaomi.push.bl.m297a(str), bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("encryption error. ", e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m181a("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.push.h.a(com.xiaomi.push.bl.m297a(str), bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("dencryption error. ", e);
            return null;
        }
    }
}
