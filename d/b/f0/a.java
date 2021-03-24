package d.b.f0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.b.f0.l.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42807a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42808b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42809c;

    /* renamed from: d.b.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0578a {
        void onFinish(String str);
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42810e;

        public b(Context context) {
            this.f42810e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f42810e);
                d.b.f0.e.c.i().d(this.f42810e);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0578a f42814g;

        public c(a aVar, Context context, long j, InterfaceC0578a interfaceC0578a) {
            this.f42812e = context;
            this.f42813f = j;
            this.f42814g = interfaceC0578a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().e(this.f42812e, 0, null, this.f42813f, this.f42814g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42815e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42816f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0578a f42817g;

        public d(a aVar, Context context, long j, InterfaceC0578a interfaceC0578a) {
            this.f42815e = context;
            this.f42816f = j;
            this.f42817g = interfaceC0578a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().f(this.f42815e, this.f42816f, this.f42817g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42819f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0578a f42820g;

        public e(a aVar, Context context, long j, InterfaceC0578a interfaceC0578a) {
            this.f42818e = context;
            this.f42819f = j;
            this.f42820g = interfaceC0578a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().k(this.f42818e, this.f42819f, this.f42820g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f42807a == null) {
            synchronized (a.class) {
                if (f42807a == null) {
                    f42807a = new a();
                }
            }
        }
        return f42807a;
    }

    public String b(Context context) {
        int intValue = ((Integer) k.b(context).second).intValue();
        if (intValue == 1) {
            return OneKeyLoginSdkCall.f11263b;
        }
        if (intValue == 3) {
            return OneKeyLoginSdkCall.f11265d;
        }
        if (intValue == 2) {
            return OneKeyLoginSdkCall.f11264c;
        }
        return null;
    }

    public synchronized void d(Context context, String str, String str2) {
        try {
            f42808b = str;
            f42809c = str2;
            d.b.f0.k.b.a().post(new b(context));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public final void e(Context context) {
        String i0 = d.b.f0.b.a.g(context).i0();
        if (TextUtils.isEmpty(i0)) {
            return;
        }
        String[] split = i0.split("_");
        if (split.length != 2) {
            d.b.f0.b.a.g(context).i();
        }
        f42808b = split[0];
        f42809c = split[1];
    }

    public void f(Context context, long j, InterfaceC0578a interfaceC0578a) {
        try {
            d.b.f0.k.b.a().post(new d(this, context, j, interfaceC0578a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0578a interfaceC0578a) {
        try {
            d.b.f0.k.b.a().post(new c(this, context, j, interfaceC0578a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public void h(Context context, boolean z) {
        try {
            d.b.f0.b.a.g(context).P(z);
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public void i(Context context, long j, InterfaceC0578a interfaceC0578a) {
        try {
            d.b.f0.k.b.a().post(new e(this, context, j, interfaceC0578a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }
}
