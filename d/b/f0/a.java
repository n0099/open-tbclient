package d.b.f0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import d.b.f0.l.k;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42808a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42809b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42810c;

    /* renamed from: d.b.f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0579a {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42811e;

        public b(Context context) {
            this.f42811e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.e(this.f42811e);
                d.b.f0.e.c.i().d(this.f42811e);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42814f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0579a f42815g;

        public c(a aVar, Context context, long j, InterfaceC0579a interfaceC0579a) {
            this.f42813e = context;
            this.f42814f = j;
            this.f42815g = interfaceC0579a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().e(this.f42813e, 0, null, this.f42814f, this.f42815g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42817f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0579a f42818g;

        public d(a aVar, Context context, long j, InterfaceC0579a interfaceC0579a) {
            this.f42816e = context;
            this.f42817f = j;
            this.f42818g = interfaceC0579a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().f(this.f42816e, this.f42817f, this.f42818g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42819e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f42820f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0579a f42821g;

        public e(a aVar, Context context, long j, InterfaceC0579a interfaceC0579a) {
            this.f42819e = context;
            this.f42820f = j;
            this.f42821g = interfaceC0579a;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.b.f0.e.c.i().k(this.f42819e, this.f42820f, this.f42821g);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    public static a c() {
        if (f42808a == null) {
            synchronized (a.class) {
                if (f42808a == null) {
                    f42808a = new a();
                }
            }
        }
        return f42808a;
    }

    public String b(Context context) {
        int intValue = ((Integer) k.b(context).second).intValue();
        if (intValue == 1) {
            return OneKeyLoginSdkCall.f11264b;
        }
        if (intValue == 3) {
            return OneKeyLoginSdkCall.f11266d;
        }
        if (intValue == 2) {
            return OneKeyLoginSdkCall.f11265c;
        }
        return null;
    }

    public synchronized void d(Context context, String str, String str2) {
        try {
            f42809b = str;
            f42810c = str2;
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
        f42809b = split[0];
        f42810c = split[1];
    }

    public void f(Context context, long j, InterfaceC0579a interfaceC0579a) {
        try {
            d.b.f0.k.b.a().post(new d(this, context, j, interfaceC0579a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public void g(Context context, long j, InterfaceC0579a interfaceC0579a) {
        try {
            d.b.f0.k.b.a().post(new c(this, context, j, interfaceC0579a));
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

    public void i(Context context, long j, InterfaceC0579a interfaceC0579a) {
        try {
            d.b.f0.k.b.a().post(new e(this, context, j, interfaceC0579a));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }
}
