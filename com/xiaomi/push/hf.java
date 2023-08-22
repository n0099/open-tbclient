package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class hf {
    public static volatile hf a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f469a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, hg> f470a = new HashMap();

    public hf(Context context) {
        this.f469a = context;
    }

    public static hf a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (hf.class) {
                if (a == null) {
                    a = new hf(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hl hlVar = new hl();
        hlVar.d(str3);
        hlVar.c(str4);
        hlVar.a(j);
        hlVar.b(str5);
        hlVar.a(true);
        hlVar.a("push_sdk_channel");
        hlVar.e(str2);
        return a(hlVar, str);
    }

    public hg a() {
        hg hgVar = this.f470a.get("UPLOADER_PUSH_CHANNEL");
        if (hgVar != null) {
            return hgVar;
        }
        hg hgVar2 = this.f470a.get("UPLOADER_HTTP");
        if (hgVar2 != null) {
            return hgVar2;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, hg> m548a() {
        return this.f470a;
    }

    public void a(hg hgVar, String str) {
        if (hgVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m548a().put(str, hgVar);
        }
    }

    public boolean a(hl hlVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m180a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.bz.a(hlVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hlVar.d())) {
                hlVar.f(com.xiaomi.push.service.bz.a());
            }
            hlVar.g(str);
            com.xiaomi.push.service.ca.a(this.f469a, hlVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f469a.getPackageName(), this.f469a.getPackageName(), str, str2, j, str3);
    }
}
