package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class hd {

    /* renamed from: a  reason: collision with root package name */
    public static volatile hd f37781a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f466a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, he> f467a = new HashMap();

    public hd(Context context) {
        this.f466a = context;
    }

    public static hd a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f37781a == null) {
            synchronized (hd.class) {
                if (f37781a == null) {
                    f37781a = new hd(context);
                }
            }
        }
        return f37781a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        hj hjVar = new hj();
        hjVar.d(str3);
        hjVar.c(str4);
        hjVar.a(j);
        hjVar.b(str5);
        hjVar.a(true);
        hjVar.a("push_sdk_channel");
        hjVar.e(str2);
        return a(hjVar, str);
    }

    public he a() {
        he heVar = this.f467a.get("UPLOADER_PUSH_CHANNEL");
        if (heVar != null) {
            return heVar;
        }
        he heVar2 = this.f467a.get("UPLOADER_HTTP");
        if (heVar2 != null) {
            return heVar2;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, he> m358a() {
        return this.f467a;
    }

    public void a(he heVar, String str) {
        if (heVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m358a().put(str, heVar);
        }
    }

    public boolean a(hj hjVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.bm.a(hjVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(hjVar.d())) {
                hjVar.f(com.xiaomi.push.service.bm.a());
            }
            hjVar.g(str);
            com.xiaomi.push.service.bn.a(this.f466a, hjVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.f466a.getPackageName(), this.f466a.getPackageName(), str, str2, j, str3);
    }
}
