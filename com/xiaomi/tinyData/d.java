package com.xiaomi.tinyData;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.bj;
import com.xiaomi.push.service.bk;
import com.xiaomi.xmpush.thrift.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    private static d a;
    private final Context b;
    private Map<String, e> c = new HashMap();

    private d(Context context) {
        this.b = context;
    }

    public static d a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j, String str5) {
        f fVar = new f();
        fVar.d(str3);
        fVar.c(str4);
        fVar.a(j);
        fVar.b(str5);
        fVar.c(true);
        fVar.a("push_sdk_channel");
        fVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataManager.upload item:" + fVar.m() + "   ts:" + System.currentTimeMillis());
        return a(fVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a() {
        e eVar = this.c.get("UPLOADER_PUSH_CHANNEL");
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = this.c.get("UPLOADER_HTTP");
        if (eVar2 == null) {
            return null;
        }
        return eVar2;
    }

    public void a(e eVar, String str) {
        if (eVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            b().put(str, eVar);
        }
    }

    public boolean a(f fVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (bj.a(fVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(fVar.m())) {
                fVar.f(bj.a());
            }
            fVar.g(str);
            bk.a(this.b, fVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(this.b.getPackageName(), this.b.getPackageName(), str, str2, j, str3);
    }

    Map<String, e> b() {
        return this.c;
    }
}
