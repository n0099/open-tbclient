package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class hk {
    private static volatile hk a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f438a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, hl> f439a = new HashMap();

    private hk(Context context) {
        this.f438a = context;
    }

    public static hk a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (hk.class) {
                if (a == null) {
                    a = new hk(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hq hqVar = new hq();
        hqVar.d(str3);
        hqVar.c(str4);
        hqVar.a(j);
        hqVar.b(str5);
        hqVar.a(true);
        hqVar.a("push_sdk_channel");
        hqVar.e(str2);
        return a(hqVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hl a() {
        hl hlVar = this.f439a.get("UPLOADER_PUSH_CHANNEL");
        if (hlVar != null) {
            return hlVar;
        }
        hl hlVar2 = this.f439a.get("UPLOADER_HTTP");
        if (hlVar2 == null) {
            return null;
        }
        return hlVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    Map<String, hl> m337a() {
        return this.f439a;
    }

    public void a(hl hlVar, String str) {
        if (hlVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m337a().put(str, hlVar);
        }
    }

    public boolean a(hq hqVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m49a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.bi.a(hqVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hqVar.d())) {
                hqVar.f(com.xiaomi.push.service.bi.a());
            }
            hqVar.g(str);
            com.xiaomi.push.service.bj.a(this.f438a, hqVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f438a.getPackageName(), this.f438a.getPackageName(), str, str2, j, str3);
    }
}
