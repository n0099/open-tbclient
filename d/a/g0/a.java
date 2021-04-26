package d.a.g0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.a.g0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f40742a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40743b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40744c;

    /* renamed from: d.a.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0549a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40745e;

        public b(Context context) {
            this.f40745e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f40745e);
                d.a.g0.e.c.i().d(this.f40745e);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f40748f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0549a f40749g;

        public c(a aVar, Context context, long j, InterfaceC0549a interfaceC0549a) {
            this.f40747e = context;
            this.f40748f = j;
            this.f40749g = interfaceC0549a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.g0.e.c.i().e(this.f40747e, 0, null, this.f40748f, this.f40749g);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40750e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f40751f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0549a f40752g;

        public d(a aVar, Context context, long j, InterfaceC0549a interfaceC0549a) {
            this.f40750e = context;
            this.f40751f = j;
            this.f40752g = interfaceC0549a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.g0.e.c.i().f(this.f40750e, this.f40751f, this.f40752g);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40753e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f40754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0549a f40755g;

        public e(a aVar, Context context, long j, InterfaceC0549a interfaceC0549a) {
            this.f40753e = context;
            this.f40754f = j;
            this.f40755g = interfaceC0549a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.g0.e.c.i().k(this.f40753e, this.f40754f, this.f40755g);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f40742a == null) {
            synchronized (a.class) {
                if (f40742a == null) {
                    f40742a = new a();
                }
            }
        }
        return f40742a;
    }

    public String b(Context context) {
        int intValue = ((Integer) k.b(context).second).intValue();
        if (intValue == 1) {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
        }
        if (intValue == 3) {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_TELECOM;
        }
        if (intValue == 2) {
            return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
        }
        return null;
    }

    public synchronized void d(Context context, String str, String str2) {
        try {
            f40743b = str;
            f40744c = str2;
            d.a.g0.k.b.a().post(new b(context));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public final void e(Context context) {
        String i0 = d.a.g0.b.a.g(context).i0();
        if (TextUtils.isEmpty(i0)) {
            return;
        }
        String[] split = i0.split("_");
        if (split.length != 2) {
            d.a.g0.b.a.g(context).i();
        }
        f40743b = split[0];
        f40744c = split[1];
    }

    public void f(Context context, long j, InterfaceC0549a interfaceC0549a) {
        try {
            d.a.g0.k.b.a().post(new d(this, context, j, interfaceC0549a));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0549a interfaceC0549a) {
        try {
            d.a.g0.k.b.a().post(new c(this, context, j, interfaceC0549a));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public void h(Context context, boolean z) {
        try {
            d.a.g0.b.a.g(context).P(z);
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public void i(Context context, long j, InterfaceC0549a interfaceC0549a) {
        try {
            d.a.g0.k.b.a().post(new e(this, context, j, interfaceC0549a));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }
}
