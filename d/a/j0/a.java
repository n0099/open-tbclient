package d.a.j0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.a.j0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f43929a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43930b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43931c;

    /* renamed from: d.a.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0605a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43932e;

        public b(Context context) {
            this.f43932e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f43932e);
                d.a.j0.e.c.j().d(this.f43932e);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43935f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0605a f43936g;

        public c(a aVar, Context context, long j, InterfaceC0605a interfaceC0605a) {
            this.f43934e = context;
            this.f43935f = j;
            this.f43936g = interfaceC0605a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.j0.e.c.j().e(this.f43934e, 0, null, this.f43935f, this.f43936g);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43938f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0605a f43939g;

        public d(a aVar, Context context, long j, InterfaceC0605a interfaceC0605a) {
            this.f43937e = context;
            this.f43938f = j;
            this.f43939g = interfaceC0605a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.j0.e.c.j().f(this.f43937e, this.f43938f, this.f43939g);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43941f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0605a f43942g;

        public e(a aVar, Context context, long j, InterfaceC0605a interfaceC0605a) {
            this.f43940e = context;
            this.f43941f = j;
            this.f43942g = interfaceC0605a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.j0.e.c.j().l(this.f43940e, this.f43941f, this.f43942g);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f43929a == null) {
            synchronized (a.class) {
                if (f43929a == null) {
                    f43929a = new a();
                }
            }
        }
        return f43929a;
    }

    public String b(Context context) {
        int intValue = ((Integer) k.d(context).second).intValue();
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
            f43930b = str;
            f43931c = str2;
            d.a.j0.k.b.a().post(new b(context));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public final void e(Context context) {
        String l0 = d.a.j0.b.a.h(context).l0();
        if (TextUtils.isEmpty(l0)) {
            return;
        }
        String[] split = l0.split("_");
        if (split.length != 2) {
            d.a.j0.b.a.h(context).j();
        }
        f43930b = split[0];
        f43931c = split[1];
    }

    public void f(Context context, long j, InterfaceC0605a interfaceC0605a) {
        try {
            d.a.j0.k.b.a().post(new d(this, context, j, interfaceC0605a));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0605a interfaceC0605a) {
        try {
            d.a.j0.k.b.a().post(new c(this, context, j, interfaceC0605a));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public void h(Context context, boolean z) {
        try {
            d.a.j0.b.a.h(context).R(z);
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public void i(Context context, long j, InterfaceC0605a interfaceC0605a) {
        try {
            d.a.j0.k.b.a().post(new e(this, context, j, interfaceC0605a));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }
}
