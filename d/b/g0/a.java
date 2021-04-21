package d.b.g0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.b.g0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f43497a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43498b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43499c;

    /* renamed from: d.b.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0610a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43500e;

        public b(Context context) {
            this.f43500e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f43500e);
                d.b.g0.e.c.i().d(this.f43500e);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43503f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0610a f43504g;

        public c(a aVar, Context context, long j, InterfaceC0610a interfaceC0610a) {
            this.f43502e = context;
            this.f43503f = j;
            this.f43504g = interfaceC0610a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.g0.e.c.i().e(this.f43502e, 0, null, this.f43503f, this.f43504g);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43506f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0610a f43507g;

        public d(a aVar, Context context, long j, InterfaceC0610a interfaceC0610a) {
            this.f43505e = context;
            this.f43506f = j;
            this.f43507g = interfaceC0610a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.g0.e.c.i().f(this.f43505e, this.f43506f, this.f43507g);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43509f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0610a f43510g;

        public e(a aVar, Context context, long j, InterfaceC0610a interfaceC0610a) {
            this.f43508e = context;
            this.f43509f = j;
            this.f43510g = interfaceC0610a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.g0.e.c.i().k(this.f43508e, this.f43509f, this.f43510g);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f43497a == null) {
            synchronized (a.class) {
                if (f43497a == null) {
                    f43497a = new a();
                }
            }
        }
        return f43497a;
    }

    public String b(Context context) {
        int intValue = ((Integer) k.b(context).second).intValue();
        if (intValue == 1) {
            return OneKeyLoginSdkCall.f10848b;
        }
        if (intValue == 3) {
            return OneKeyLoginSdkCall.f10850d;
        }
        if (intValue == 2) {
            return OneKeyLoginSdkCall.f10849c;
        }
        return null;
    }

    public synchronized void d(Context context, String str, String str2) {
        try {
            f43498b = str;
            f43499c = str2;
            d.b.g0.k.b.a().post(new b(context));
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }

    public final void e(Context context) {
        String i0 = d.b.g0.b.a.g(context).i0();
        if (TextUtils.isEmpty(i0)) {
            return;
        }
        String[] split = i0.split("_");
        if (split.length != 2) {
            d.b.g0.b.a.g(context).i();
        }
        f43498b = split[0];
        f43499c = split[1];
    }

    public void f(Context context, long j, InterfaceC0610a interfaceC0610a) {
        try {
            d.b.g0.k.b.a().post(new d(this, context, j, interfaceC0610a));
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0610a interfaceC0610a) {
        try {
            d.b.g0.k.b.a().post(new c(this, context, j, interfaceC0610a));
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }

    public void h(Context context, boolean z) {
        try {
            d.b.g0.b.a.g(context).P(z);
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }

    public void i(Context context, long j, InterfaceC0610a interfaceC0610a) {
        try {
            d.b.g0.k.b.a().post(new e(this, context, j, interfaceC0610a));
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
    }
}
