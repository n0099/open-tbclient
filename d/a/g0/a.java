package d.a.g0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.a.g0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f39987a;

    /* renamed from: b  reason: collision with root package name */
    public static String f39988b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39989c;

    /* renamed from: d.a.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0536a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39990e;

        public b(Context context) {
            this.f39990e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f39990e);
                d.a.g0.e.c.i().d(this.f39990e);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39992e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f39993f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0536a f39994g;

        public c(a aVar, Context context, long j, InterfaceC0536a interfaceC0536a) {
            this.f39992e = context;
            this.f39993f = j;
            this.f39994g = interfaceC0536a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.g0.e.c.i().e(this.f39992e, 0, null, this.f39993f, this.f39994g);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39995e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f39996f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0536a f39997g;

        public d(a aVar, Context context, long j, InterfaceC0536a interfaceC0536a) {
            this.f39995e = context;
            this.f39996f = j;
            this.f39997g = interfaceC0536a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.g0.e.c.i().f(this.f39995e, this.f39996f, this.f39997g);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f39999f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0536a f40000g;

        public e(a aVar, Context context, long j, InterfaceC0536a interfaceC0536a) {
            this.f39998e = context;
            this.f39999f = j;
            this.f40000g = interfaceC0536a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.g0.e.c.i().k(this.f39998e, this.f39999f, this.f40000g);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f39987a == null) {
            synchronized (a.class) {
                if (f39987a == null) {
                    f39987a = new a();
                }
            }
        }
        return f39987a;
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
            f39988b = str;
            f39989c = str2;
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
        f39988b = split[0];
        f39989c = split[1];
    }

    public void f(Context context, long j, InterfaceC0536a interfaceC0536a) {
        try {
            d.a.g0.k.b.a().post(new d(this, context, j, interfaceC0536a));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0536a interfaceC0536a) {
        try {
            d.a.g0.k.b.a().post(new c(this, context, j, interfaceC0536a));
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

    public void i(Context context, long j, InterfaceC0536a interfaceC0536a) {
        try {
            d.a.g0.k.b.a().post(new e(this, context, j, interfaceC0536a));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }
}
