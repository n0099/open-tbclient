package d.b.f0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.b.f0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f43200a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43201b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43202c;

    /* renamed from: d.b.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0591a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43203e;

        public b(Context context) {
            this.f43203e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f43203e);
                d.b.f0.e.c.i().d(this.f43203e);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43206f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0591a f43207g;

        public c(a aVar, Context context, long j, InterfaceC0591a interfaceC0591a) {
            this.f43205e = context;
            this.f43206f = j;
            this.f43207g = interfaceC0591a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().e(this.f43205e, 0, null, this.f43206f, this.f43207g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43209f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0591a f43210g;

        public d(a aVar, Context context, long j, InterfaceC0591a interfaceC0591a) {
            this.f43208e = context;
            this.f43209f = j;
            this.f43210g = interfaceC0591a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().f(this.f43208e, this.f43209f, this.f43210g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43212f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0591a f43213g;

        public e(a aVar, Context context, long j, InterfaceC0591a interfaceC0591a) {
            this.f43211e = context;
            this.f43212f = j;
            this.f43213g = interfaceC0591a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().k(this.f43211e, this.f43212f, this.f43213g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f43200a == null) {
            synchronized (a.class) {
                if (f43200a == null) {
                    f43200a = new a();
                }
            }
        }
        return f43200a;
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
            f43201b = str;
            f43202c = str2;
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
        f43201b = split[0];
        f43202c = split[1];
    }

    public void f(Context context, long j, InterfaceC0591a interfaceC0591a) {
        try {
            d.b.f0.k.b.a().post(new d(this, context, j, interfaceC0591a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0591a interfaceC0591a) {
        try {
            d.b.f0.k.b.a().post(new c(this, context, j, interfaceC0591a));
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

    public void i(Context context, long j, InterfaceC0591a interfaceC0591a) {
        try {
            d.b.f0.k.b.a().post(new e(this, context, j, interfaceC0591a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }
}
