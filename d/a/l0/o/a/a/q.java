package d.a.l0.o.a.a;

import android.os.Bundle;
import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.a.l0.o.a.a.p;
import d.a.l0.o.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class q extends p {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f51940g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.l0.o.a.c.g<a> f51941a = new d.a.l0.o.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.l0.o.a.c.g<a> f51942b = new d.a.l0.o.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f51943c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51944d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51945e;

    /* renamed from: f  reason: collision with root package name */
    public k f51946f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f51947a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f51948b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f51949c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.l0.o.a.b.d<Object> f51950d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f51951e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f51952f;

        /* renamed from: g  reason: collision with root package name */
        public Object f51953g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f51954h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f51955i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.l0.o.a.b.d<Object> dVar, Object obj) {
            if (this.f51949c != null) {
                String str = null;
                if (this.o.f51946f != null) {
                    str = this.o.f51946f.f51901d.s;
                    this.o.f51946f.f51901d.s = "onLoadFinished";
                }
                try {
                    if (q.f51940g) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                    }
                    this.f51949c.b(dVar, obj);
                    this.f51952f = true;
                } finally {
                    if (this.o.f51946f != null) {
                        this.o.f51946f.f51901d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (q.f51940g) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f51952f;
            this.f51952f = false;
            if (this.f51949c != null && this.f51950d != null && this.f51951e && z) {
                if (q.f51940g) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.o.f51946f != null) {
                    str = this.o.f51946f.f51901d.s;
                    this.o.f51946f.f51901d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f51949c.a(this.f51950d);
                } finally {
                    if (this.o.f51946f != null) {
                        this.o.f51946f.f51901d.s = str;
                    }
                }
            }
            this.f51949c = null;
            this.f51953g = null;
            this.f51951e = false;
            d.a.l0.o.a.b.d<Object> dVar = this.f51950d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.h(this);
                    this.f51950d.i(this);
                }
                this.f51950d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f51947a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f51948b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f51949c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f51950d);
            d.a.l0.o.a.b.d<Object> dVar = this.f51950d;
            if (dVar != null) {
                dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.f51951e || this.f51952f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f51951e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f51952f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f51953g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f51954h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f51955i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.m);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.n);
                printWriter.println(":");
                a aVar = this.n;
                aVar.c(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }

        public void d() {
            if (this.f51955i) {
                if (q.f51940g) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f51955i = false;
                boolean z = this.f51954h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f51954h && this.f51951e && !this.k) {
                a(this.f51950d, this.f51953g);
            }
        }

        public void e() {
            if (this.f51954h && this.k) {
                this.k = false;
                if (this.f51951e) {
                    a(this.f51950d, this.f51953g);
                }
            }
        }

        public void f() {
            if (q.f51940g) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f51955i = true;
            this.j = this.f51954h;
            this.f51954h = false;
            this.f51949c = null;
        }

        public void g() {
            p.a<Object> aVar;
            if (this.f51955i && this.j) {
                this.f51954h = true;
            } else if (this.f51954h) {
            } else {
                this.f51954h = true;
                if (q.f51940g) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f51950d == null && (aVar = this.f51949c) != null) {
                    this.f51950d = aVar.onCreateLoader(this.f51947a, this.f51948b);
                }
                d.a.l0.o.a.b.d<Object> dVar = this.f51950d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f51950d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f51950d);
                    }
                    if (!this.m) {
                        this.f51950d.c(this.f51947a, this);
                        this.f51950d.d(this);
                        this.m = true;
                    }
                    this.f51950d.f();
                    throw null;
                }
            }
        }

        public void h() {
            d.a.l0.o.a.b.d<Object> dVar;
            if (q.f51940g) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f51954h = false;
            if (this.f51955i || (dVar = this.f51950d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.h(this);
            this.f51950d.i(this);
            this.f51950d.g();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f51947a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.a.l0.o.a.c.c.a(this.f51950d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public q(String str, k kVar, boolean z) {
        this.f51943c = str;
        this.f51946f = kVar;
        this.f51944d = z;
    }

    public void b() {
        if (!this.f51945e) {
            if (f51940g) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
                this.f51941a.g(f2).b();
            }
            this.f51941a.b();
        }
        if (f51940g) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int f3 = this.f51942b.f() - 1; f3 >= 0; f3--) {
            this.f51942b.g(f3).b();
        }
        this.f51942b.b();
    }

    public void c() {
        for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
            this.f51941a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
            this.f51941a.g(f2).e();
        }
    }

    public void e() {
        if (f51940g) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f51944d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f51945e = true;
        this.f51944d = false;
        for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
            this.f51941a.g(f2).f();
        }
    }

    public void f() {
        if (f51940g) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f51944d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f51944d = true;
        for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
            this.f51941a.g(f2).g();
        }
    }

    public void g() {
        if (f51940g) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f51944d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
            this.f51941a.g(f2).h();
        }
        this.f51944d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f51941a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f51941a.f(); i2++) {
                a g2 = this.f51941a.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f51941a.e(i2));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f51942b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i3 = 0; i3 < this.f51942b.f(); i3++) {
                a g3 = this.f51942b.g(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f51942b.e(i3));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f51945e) {
            if (f51940g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f51945e = false;
            for (int f2 = this.f51941a.f() - 1; f2 >= 0; f2--) {
                this.f51941a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f51941a.f();
        boolean z = false;
        for (int i2 = 0; i2 < f2; i2++) {
            a g2 = this.f51941a.g(i2);
            z |= g2.f51954h && !g2.f51952f;
        }
        return z;
    }

    public void k(k kVar) {
        this.f51946f = kVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a.l0.o.a.c.c.a(this.f51946f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
