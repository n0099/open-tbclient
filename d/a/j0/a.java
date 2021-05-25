package d.a.j0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.a.j0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f40248a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40249b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40250c;

    /* renamed from: d.a.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0549a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40251e;

        public b(Context context) {
            this.f40251e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f40251e);
                d.a.j0.e.c.i().d(this.f40251e);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40253e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f40254f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0549a f40255g;

        public c(a aVar, Context context, long j, InterfaceC0549a interfaceC0549a) {
            this.f40253e = context;
            this.f40254f = j;
            this.f40255g = interfaceC0549a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.j0.e.c.i().e(this.f40253e, 0, null, this.f40254f, this.f40255g);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f40257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0549a f40258g;

        public d(a aVar, Context context, long j, InterfaceC0549a interfaceC0549a) {
            this.f40256e = context;
            this.f40257f = j;
            this.f40258g = interfaceC0549a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.j0.e.c.i().f(this.f40256e, this.f40257f, this.f40258g);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f40259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f40260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0549a f40261g;

        public e(a aVar, Context context, long j, InterfaceC0549a interfaceC0549a) {
            this.f40259e = context;
            this.f40260f = j;
            this.f40261g = interfaceC0549a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.j0.e.c.i().k(this.f40259e, this.f40260f, this.f40261g);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f40248a == null) {
            synchronized (a.class) {
                if (f40248a == null) {
                    f40248a = new a();
                }
            }
        }
        return f40248a;
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
            f40249b = str;
            f40250c = str2;
            d.a.j0.k.b.a().post(new b(context));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public final void e(Context context) {
        String i0 = d.a.j0.b.a.g(context).i0();
        if (TextUtils.isEmpty(i0)) {
            return;
        }
        String[] split = i0.split("_");
        if (split.length != 2) {
            d.a.j0.b.a.g(context).i();
        }
        f40249b = split[0];
        f40250c = split[1];
    }

    public void f(Context context, long j, InterfaceC0549a interfaceC0549a) {
        try {
            d.a.j0.k.b.a().post(new d(this, context, j, interfaceC0549a));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0549a interfaceC0549a) {
        try {
            d.a.j0.k.b.a().post(new c(this, context, j, interfaceC0549a));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public void h(Context context, boolean z) {
        try {
            d.a.j0.b.a.g(context).P(z);
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }

    public void i(Context context, long j, InterfaceC0549a interfaceC0549a) {
        try {
            d.a.j0.k.b.a().post(new e(this, context, j, interfaceC0549a));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }
}
