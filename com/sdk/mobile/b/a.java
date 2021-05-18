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
    public static final String f35791a = "com.sdk.mobile.b.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f35792b = Boolean.valueOf(f.f35733b);

    /* renamed from: c  reason: collision with root package name */
    public CallBack<T> f35793c;

    /* renamed from: d  reason: collision with root package name */
    public Context f35794d;

    /* renamed from: e  reason: collision with root package name */
    public e f35795e;

    /* renamed from: f  reason: collision with root package name */
    public com.sdk.base.framework.a.f f35796f;

    /* renamed from: g  reason: collision with root package name */
    public int f35797g;

    public a(Context context, int i2, CallBack<T> callBack) {
        this.f35793c = callBack;
        this.f35794d = context;
        i2 = i2 <= 0 ? 30 : i2;
        this.f35797g = i2;
        e eVar = new e(this, i2 * 1000);
        this.f35795e = eVar;
        eVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str) {
        String a2 = com.sdk.base.framework.f.f.a.b().a();
        if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
            a2 = com.sdk.base.framework.f.i.a.a(20);
        }
        e eVar = this.f35795e;
        if (eVar != null) {
            eVar.b();
        }
        CallBack<T> callBack = this.f35793c;
        if (callBack != null) {
            callBack.onFailed(i2, i3, str, a2);
            this.f35793c = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f35794d, i3, str, a2, this.f35797g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, int i3, T t, String str2) {
        if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
            str2 = com.sdk.base.framework.f.i.a.a(20);
        }
        e eVar = this.f35795e;
        if (eVar != null) {
            eVar.b();
        }
        CallBack<T> callBack = this.f35793c;
        if (callBack != null) {
            callBack.onSuccess(i2, str, i3, t, str2);
            this.f35793c = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f35794d, i3, str, str2, this.f35797g);
    }

    public final void a(int i2) {
        String a2 = com.sdk.base.framework.a.a.a.a(this.f35794d, i2, g.f35768a.a());
        if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
        } else if (!com.sdk.base.framework.f.i.b.a(this.f35794d)) {
            a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
        } else {
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f35794d, new b(this, i2));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(LightInvokerImpl.LIVENESS_SERVIVETYPE, Integer.valueOf(i2));
            dataInfo.putData("privateIp", com.sdk.base.framework.f.a.a.a());
            dataInfo.putData("newVersion", "10");
            this.f35796f = aVar.a(aVar.f35742b, "/dro/netm/v1.0/qc", dataInfo, aVar.a(), 0, j.f35693b);
        }
    }

    public final void a(String str) {
        com.sdk.base.framework.a.a.a.a(this.f35794d);
        new com.sdk.mobile.a.a();
        this.f35796f = com.sdk.mobile.a.a.a(this.f35794d, str, null, new d(this));
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.a.a.a.b(this.f35794d);
        new com.sdk.mobile.a.a();
        this.f35796f = com.sdk.mobile.a.a.a(this.f35794d, str, str2, new c(this));
    }
}
