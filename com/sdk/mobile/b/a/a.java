package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.g.g;
/* loaded from: classes7.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39504a = "com.sdk.mobile.b.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f39505b = Boolean.valueOf(f.f39439b);

    /* renamed from: c  reason: collision with root package name */
    public d f39506c;

    /* renamed from: d  reason: collision with root package name */
    public Context f39507d;

    /* renamed from: e  reason: collision with root package name */
    public com.sdk.base.framework.a.f f39508e;

    /* renamed from: f  reason: collision with root package name */
    public int f39509f;

    /* renamed from: g  reason: collision with root package name */
    public CallBack<T> f39510g;

    public a(Context context, int i2, CallBack<T> callBack) {
        this.f39507d = context;
        this.f39510g = callBack;
        i2 = i2 <= 0 ? 30 : i2;
        this.f39509f = i2;
        d dVar = new d(this, i2 * 1000);
        this.f39506c = dVar;
        dVar.a();
        com.sdk.base.framework.f.f.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str) {
        String a2 = com.sdk.base.framework.f.f.a.b().a();
        if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
            a2 = com.sdk.base.framework.f.i.a.a(20);
        }
        d dVar = this.f39506c;
        if (dVar != null) {
            dVar.b();
        }
        CallBack<T> callBack = this.f39510g;
        if (callBack != null) {
            callBack.onFailed(i2, i3, str, a2);
            this.f39510g = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f39507d, i3, str, a2, this.f39509f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, int i3, T t, String str2) {
        if (com.sdk.base.framework.a.a.c.a(str2).booleanValue()) {
            str2 = com.sdk.base.framework.f.i.a.a(20);
        }
        d dVar = this.f39506c;
        if (dVar != null) {
            dVar.b();
        }
        CallBack<T> callBack = this.f39510g;
        if (callBack != null) {
            callBack.onSuccess(i2, str, i3, t, str2);
            this.f39510g = null;
        }
        com.sdk.base.framework.f.k.a.a(this.f39507d, i3, str, str2, this.f39509f);
    }

    public final void a(int i2) {
        String a2 = com.sdk.base.framework.a.a.a.a(this.f39507d, i2, g.f39475b.a());
        if (com.sdk.base.framework.a.a.c.b(a2).booleanValue()) {
            a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(a2), com.sdk.base.framework.a.a.a.b(a2));
        } else if (!com.sdk.base.framework.f.i.b.a(this.f39507d)) {
            a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
        } else {
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f39507d, new b(this, i2));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(LightInvokerImpl.LIVENESS_SERVIVETYPE, Integer.valueOf(i2));
            this.f39508e = aVar.a(aVar.f39448b, "/dro/netm/v1.0/gctcbs", dataInfo, aVar.a(), 0, j.f39399b);
        }
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.a.a.a.b(this.f39507d);
        new com.sdk.mobile.a.a();
        com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.f39507d, new c(this, str2));
        DataInfo dataInfo = new DataInfo();
        dataInfo.putData(YYInnerSSOLoginActivity.o, str);
        dataInfo.putData("mobile", str2);
        this.f39508e = aVar.a(aVar.f39448b, "/dro/netm/v1.0/gmctc", dataInfo, aVar.a(), 0, j.f39399b);
    }
}
