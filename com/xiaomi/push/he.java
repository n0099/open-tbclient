package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class he {
    private static he a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f454a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, hf> f455a = new HashMap();

    private he(Context context) {
        this.f454a = context;
    }

    public static he a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (he.class) {
                if (a == null) {
                    a = new he(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hk hkVar = new hk();
        hkVar.d(str3);
        hkVar.c(str4);
        hkVar.a(j);
        hkVar.b(str5);
        hkVar.a(true);
        hkVar.a("push_sdk_channel");
        hkVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.m33a("TinyData TinyDataManager.upload item:" + hkVar.d() + "   ts:" + System.currentTimeMillis());
        return a(hkVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hf a() {
        hf hfVar = this.f455a.get("UPLOADER_PUSH_CHANNEL");
        if (hfVar != null) {
            return hfVar;
        }
        hf hfVar2 = this.f455a.get("UPLOADER_HTTP");
        if (hfVar2 == null) {
            return null;
        }
        return hfVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    Map<String, hf> m317a() {
        return this.f455a;
    }

    public void a(hf hfVar, String str) {
        if (hfVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m317a().put(str, hfVar);
        }
    }

    public boolean a(hk hkVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m33a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.be.a(hkVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hkVar.d())) {
                hkVar.f(com.xiaomi.push.service.be.a());
            }
            hkVar.g(str);
            com.xiaomi.push.service.bf.a(this.f454a, hkVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f454a.getPackageName(), this.f454a.getPackageName(), str, str2, j, str3);
    }
}
