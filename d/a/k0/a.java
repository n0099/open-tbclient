package d.a.k0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.a.k0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f44069a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44070b;

    /* renamed from: c  reason: collision with root package name */
    public static String f44071c;

    /* renamed from: d.a.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0609a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44072e;

        public b(Context context) {
            this.f44072e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f44072e);
                d.a.k0.e.c.j().d(this.f44072e);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f44075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0609a f44076g;

        public c(a aVar, Context context, long j, InterfaceC0609a interfaceC0609a) {
            this.f44074e = context;
            this.f44075f = j;
            this.f44076g = interfaceC0609a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.k0.e.c.j().e(this.f44074e, 0, null, this.f44075f, this.f44076g);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f44078f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0609a f44079g;

        public d(a aVar, Context context, long j, InterfaceC0609a interfaceC0609a) {
            this.f44077e = context;
            this.f44078f = j;
            this.f44079g = interfaceC0609a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.k0.e.c.j().f(this.f44077e, this.f44078f, this.f44079g);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44080e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f44081f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0609a f44082g;

        public e(a aVar, Context context, long j, InterfaceC0609a interfaceC0609a) {
            this.f44080e = context;
            this.f44081f = j;
            this.f44082g = interfaceC0609a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.k0.e.c.j().l(this.f44080e, this.f44081f, this.f44082g);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f44069a == null) {
            synchronized (a.class) {
                if (f44069a == null) {
                    f44069a = new a();
                }
            }
        }
        return f44069a;
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
            f44070b = str;
            f44071c = str2;
            d.a.k0.k.b.a().post(new b(context));
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }

    public final void e(Context context) {
        String l0 = d.a.k0.b.a.h(context).l0();
        if (TextUtils.isEmpty(l0)) {
            return;
        }
        String[] split = l0.split("_");
        if (split.length != 2) {
            d.a.k0.b.a.h(context).j();
        }
        f44070b = split[0];
        f44071c = split[1];
    }

    public void f(Context context, long j, InterfaceC0609a interfaceC0609a) {
        try {
            d.a.k0.k.b.a().post(new d(this, context, j, interfaceC0609a));
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0609a interfaceC0609a) {
        try {
            d.a.k0.k.b.a().post(new c(this, context, j, interfaceC0609a));
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }

    public void h(Context context, boolean z) {
        try {
            d.a.k0.b.a.h(context).R(z);
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }

    public void i(Context context, long j, InterfaceC0609a interfaceC0609a) {
        try {
            d.a.k0.k.b.a().post(new e(this, context, j, interfaceC0609a));
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
        }
    }
}
