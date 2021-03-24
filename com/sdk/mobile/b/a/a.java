package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.g.g;
/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38583a = "com.sdk.mobile.b.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f38584b = Boolean.valueOf(f.f38519b);

    /* renamed from: c  reason: collision with root package name */
    public d f38585c;

    /* renamed from: d  reason: collision with root package name */
    public Context f38586d;

    /* renamed from: e  reason: collision with root package name */
    public com.sdk.base.framework.a.f f38587e;

    /* renamed from: f  reason: collision with root package name */
    public int f38588f;

    /* renamed from: g  reason: collision with root package name */
    public CallBack<T> f38589g;

    public a(Context context, int i, CallBack<T> callBack) {
        this.f38586d = context;
        this.f38589g = callBack;
        i = i <= 0 ? 30 : i;
        this.f38588f = i;
        d dVar = new d(this, i * 1000);
        this.f38585c = dVar;
        dVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        String a2 = com.sdk.base.framework.f.f.a.b().a();
        if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
            a2 = com.sdk.base.framework.f.i.a.a(20);
        }
        d dVar = this.f38585c;
        if (dVar != null) {
            dVar.b();
        }
        CallBack<T> callBack = this.f38589g;
        if (callBack != null) {
            callBack.onFailed(i, i2, str, a2);
            this.f38589g = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f38586d, i2, str, a2, this.f38588f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, T t, String str2) {
        if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
            str2 = com.sdk.base.framework.f.i.a.a(20);
        }
        d dVar = this.f38585c;
        if (dVar != null) {
            dVar.b();
        }
        CallBack<T> callBack = this.f38589g;
        if (callBack != null) {
            callBack.onSuccess(i, str, i2, t, str2);
            this.f38589g = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f38586d, i2, str, str2, this.f38588f);
    }

    public final void a(int i) {
        String a2 = com.sdk.base.framework.a.a.a.a(this.f38586d, i, g.f38554b.a());
        if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
        } else if (!com.sdk.base.framework.f.i.b.a(this.f38586d)) {
            a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
        } else {
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f38586d, new b(this, i));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(LightInvokerImpl.LIVENESS_SERVIVETYPE, Integer.valueOf(i));
            this.f38587e = aVar.a(aVar.f38528b, "/dro/netm/v1.0/gctcbs", dataInfo, aVar.a(), 0, j.f38481b);
        }
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.a.a.a.b(this.f38586d);
        new com.sdk.mobile.a.a();
        com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f38586d, new c(this, str2));
        DataInfo dataInfo = new DataInfo();
        dataInfo.putData("accessCode", str);
        dataInfo.putData("mobile", str2);
        this.f38587e = aVar.a(aVar.f38528b, "/dro/netm/v1.0/gmctc", dataInfo, aVar.a(), 0, j.f38481b);
    }
}
