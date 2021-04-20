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
    public static final String f38873a = "com.sdk.mobile.b.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f38874b = Boolean.valueOf(f.f38809b);

    /* renamed from: c  reason: collision with root package name */
    public d f38875c;

    /* renamed from: d  reason: collision with root package name */
    public Context f38876d;

    /* renamed from: e  reason: collision with root package name */
    public com.sdk.base.framework.a.f f38877e;

    /* renamed from: f  reason: collision with root package name */
    public int f38878f;

    /* renamed from: g  reason: collision with root package name */
    public CallBack<T> f38879g;

    public a(Context context, int i, CallBack<T> callBack) {
        this.f38876d = context;
        this.f38879g = callBack;
        i = i <= 0 ? 30 : i;
        this.f38878f = i;
        d dVar = new d(this, i * 1000);
        this.f38875c = dVar;
        dVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        String a2 = com.sdk.base.framework.f.f.a.b().a();
        if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
            a2 = com.sdk.base.framework.f.i.a.a(20);
        }
        d dVar = this.f38875c;
        if (dVar != null) {
            dVar.b();
        }
        CallBack<T> callBack = this.f38879g;
        if (callBack != null) {
            callBack.onFailed(i, i2, str, a2);
            this.f38879g = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f38876d, i2, str, a2, this.f38878f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, T t, String str2) {
        if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
            str2 = com.sdk.base.framework.f.i.a.a(20);
        }
        d dVar = this.f38875c;
        if (dVar != null) {
            dVar.b();
        }
        CallBack<T> callBack = this.f38879g;
        if (callBack != null) {
            callBack.onSuccess(i, str, i2, t, str2);
            this.f38879g = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f38876d, i2, str, str2, this.f38878f);
    }

    public final void a(int i) {
        String a2 = com.sdk.base.framework.a.a.a.a(this.f38876d, i, g.f38844b.a());
        if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
        } else if (!com.sdk.base.framework.f.i.b.a(this.f38876d)) {
            a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
        } else {
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f38876d, new b(this, i));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(LightInvokerImpl.LIVENESS_SERVIVETYPE, Integer.valueOf(i));
            this.f38877e = aVar.a(aVar.f38818b, "/dro/netm/v1.0/gctcbs", dataInfo, aVar.a(), 0, j.f38771b);
        }
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.a.a.a.b(this.f38876d);
        new com.sdk.mobile.a.a();
        com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f38876d, new c(this, str2));
        DataInfo dataInfo = new DataInfo();
        dataInfo.putData("accessCode", str);
        dataInfo.putData("mobile", str2);
        this.f38877e = aVar.a(aVar.f38818b, "/dro/netm/v1.0/gmctc", dataInfo, aVar.a(), 0, j.f38771b);
    }
}
