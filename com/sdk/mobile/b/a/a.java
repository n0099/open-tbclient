package com.sdk.mobile.b.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.tbadk.pay.PayHelper;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.i;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import com.sdk.base.framework.f.h.g;
/* loaded from: classes9.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4286a = a.class.getName();
    private static Boolean b = Boolean.valueOf(f.b);
    private a<T>.d c;
    private Context d;
    private com.sdk.base.framework.a.f e;
    private int f;
    private CallBack<T> g;

    /* loaded from: classes9.dex */
    public final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Handler f4289a = new Handler(Looper.getMainLooper());
        private long b;

        d(long j) {
            this.b = j;
        }

        public final void a() {
            this.f4289a.postDelayed(this, this.b);
        }

        public final void b() {
            this.f4289a.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.e != null) {
                com.sdk.base.framework.a.a.c.c(a.f4286a, "超时，已取消请求", a.b);
                a.this.e.a();
            }
            a.this.a(1, PayHelper.STATUS_TIMEOUT_DESC, 101005, null, com.sdk.base.framework.f.g.a.b().a());
        }
    }

    public a(Context context, int i, CallBack<T> callBack) {
        this.d = context;
        this.g = callBack;
        i = i <= 0 ? 30 : i;
        this.f = i;
        this.c = new d(i * 1000);
        this.c.a();
        com.sdk.base.framework.f.g.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        String a2 = com.sdk.base.framework.f.g.a.b().a();
        if (com.sdk.base.framework.a.a.c.a(a2).booleanValue()) {
            a2 = com.sdk.base.framework.f.j.a.a(20);
        }
        if (this.c != null) {
            this.c.b();
        }
        if (this.g != null) {
            this.g.onFailed(i, i2, str, a2);
            this.g = null;
        }
        com.sdk.base.framework.f.l.a.a(this.d, i2, str, a2, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, T t, String str2) {
        String a2 = com.sdk.base.framework.a.a.c.a(str2).booleanValue() ? com.sdk.base.framework.f.j.a.a(20) : str2;
        if (this.c != null) {
            this.c.b();
        }
        if (this.g != null) {
            this.g.onSuccess(i, str, i2, t, a2);
            this.g = null;
        }
        com.sdk.base.framework.f.l.a.a(this.d, i2, str, a2, this.f);
    }

    public final void a(int i) {
        String b2 = com.sdk.base.framework.a.a.a.b(this.d, i, g.c.a());
        if (com.sdk.base.framework.a.a.c.b(b2).booleanValue()) {
            a(0, "成功", 100, com.sdk.base.framework.a.a.a.a(b2), com.sdk.base.framework.a.a.a.b(b2));
        } else if (!com.sdk.base.framework.f.j.b.a(this.d)) {
            a(1, IMTrack.CrashBuilder.CRASH_TYPE_CATCH, "操作频繁请,稍后再试");
        } else {
            new com.sdk.mobile.a.a();
            com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.d, new b(this, i));
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData("serviceType", Integer.valueOf(i));
            this.e = aVar.a(aVar.b, "/dro/netm/v1.0/gctcbs", dataInfo, aVar.a(), 0, i.b);
        }
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.a.a.a.b(this.d);
        new com.sdk.mobile.a.a();
        com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(this.d, new c(this, str2));
        DataInfo dataInfo = new DataInfo();
        dataInfo.putData("accessCode", str);
        dataInfo.putData("mobile", str2);
        this.e = aVar.a(aVar.b, "/dro/netm/v1.0/gmctc", dataInfo, aVar.a(), 0, i.b);
    }
}
