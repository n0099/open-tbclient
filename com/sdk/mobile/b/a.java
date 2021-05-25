package com.sdk.mobile.b;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.g.g;
/* loaded from: classes7.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35720a = "com.sdk.mobile.b.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f35721b = Boolean.valueOf(f.f35662b);

    /* renamed from: c  reason: collision with root package name */
    public CallBack<T> f35722c;

    /* renamed from: d  reason: collision with root package name */
    public Context f35723d;

    /* renamed from: e  reason: collision with root package name */
    public e f35724e;

    /* renamed from: f  reason: collision with root package name */
    public com.sdk.base.framework.a.f f35725f;

    /* renamed from: g  reason: collision with root package name */
    public int f35726g;

    public a(Context context, int i2, CallBack<T> callBack) {
        this.f35722c = callBack;
        this.f35723d = context;
        i2 = i2 <= 0 ? 30 : i2;
        this.f35726g = i2;
        e eVar = new e(this, i2 * 1000);
        this.f35724e = eVar;
        eVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str) {
        String a2 = com.sdk.base.framework.f.f.a.b().a();
        if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
            a2 = com.sdk.base.framework.f.i.a.a(20);
        }
        e eVar = this.f35724e;
        if (eVar != null) {
            eVar.b();
        }
        CallBack<T> callBack = this.f35722c;
        if (callBack != null) {
            callBack.onFailed(i2, i3, str, a2);
            this.f35722c = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f35723d, i3, str, a2, this.f35726g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, int i3, T t, String str2) {
        if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
            str2 = com.sdk.base.framework.f.i.a.a(20);
        }
        e eVar = this.f35724e;
        if (eVar != null) {
            eVar.b();
        }
        CallBack<T> callBack = this.f35722c;
        if (callBack != null) {
            callBack.onSuccess(i2, str, i3, t, str2);
            this.f35722c = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f35723d, i3, str, str2, this.f35726g);
    }

    public final void a(int i2) {
        String a2 = com.sdk.base.framework.a.a.a.a(this.f35723d, i2, g.f35697a.a());
        if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
        } else if (!com.sdk.base.framework.f.i.b.a(this.f35723d)) {
            a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
        } else {
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f35723d, new b(this, i2));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(LightInvokerImpl.LIVENESS_SERVIVETYPE, Integer.valueOf(i2));
            dataInfo.putData("privateIp", com.sdk.base.framework.f.a.a.a());
            dataInfo.putData("newVersion", "10");
            this.f35725f = aVar.a(aVar.f35671b, "/dro/netm/v1.0/qc", dataInfo, aVar.a(), 0, j.f35622b);
        }
    }

    public final void a(String str) {
        com.sdk.base.framework.a.a.a.a(this.f35723d);
        new com.sdk.mobile.a.a();
        this.f35725f = com.sdk.mobile.a.a.a(this.f35723d, str, null, new d(this));
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.a.a.a.b(this.f35723d);
        new com.sdk.mobile.a.a();
        this.f35725f = com.sdk.mobile.a.a.a(this.f35723d, str, str2, new c(this));
    }
}
