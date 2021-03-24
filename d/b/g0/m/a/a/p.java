package d.b.g0.m.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.loader.app.LoaderManagerImpl;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.b.g0.m.a.a.o;
import d.b.g0.m.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class p extends o {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f49129g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.b.g0.m.a.c.g<a> f49130a = new d.b.g0.m.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.m.a.c.g<a> f49131b = new d.b.g0.m.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f49132c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49133d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49134e;

    /* renamed from: f  reason: collision with root package name */
    public j f49135f;

    /* loaded from: classes3.dex */
    public final class a implements d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f49136a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f49137b;

        /* renamed from: c  reason: collision with root package name */
        public o.a<Object> f49138c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.g0.m.a.b.d<Object> f49139d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f49140e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f49141f;

        /* renamed from: g  reason: collision with root package name */
        public Object f49142g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f49143h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ p o;

        public void a(d.b.g0.m.a.b.d<Object> dVar, Object obj) {
            String str;
            if (this.f49138c != null) {
                if (this.o.f49135f != null) {
                    str = this.o.f49135f.f49096d.s;
                    this.o.f49135f.f49096d.s = "onLoadFinished";
                } else {
                    str = null;
                }
                try {
                    if (!p.f49129g) {
                        this.f49138c.b(dVar, obj);
                        this.f49141f = true;
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("  onLoadFinished in ");
                    sb.append(dVar);
                    sb.append(": ");
                    dVar.a(obj);
                    throw null;
                } finally {
                    if (this.o.f49135f != null) {
                        this.o.f49135f.f49096d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (p.f49129g) {
                Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f49141f;
            this.f49141f = false;
            if (this.f49138c != null && this.f49139d != null && this.f49140e && z) {
                if (p.f49129g) {
                    Log.v(LoaderManagerImpl.TAG, "  Reseting: " + this);
                }
                if (this.o.f49135f != null) {
                    str = this.o.f49135f.f49096d.s;
                    this.o.f49135f.f49096d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f49138c.a(this.f49139d);
                } finally {
                    if (this.o.f49135f != null) {
                        this.o.f49135f.f49096d.s = str;
                    }
                }
            }
            this.f49138c = null;
            this.f49142g = null;
            this.f49140e = false;
            d.b.g0.m.a.b.d<Object> dVar = this.f49139d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.f(this);
                    throw null;
                }
                dVar.d();
                throw null;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f49136a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f49137b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f49138c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f49139d);
            d.b.g0.m.a.b.d<Object> dVar = this.f49139d;
            if (dVar == null) {
                if (this.f49140e || this.f49141f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f49140e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f49141f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f49142g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f49143h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.i);
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
                    return;
                }
                return;
            }
            dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            throw null;
        }

        public void d() {
            if (this.i) {
                if (p.f49129g) {
                    Log.v(LoaderManagerImpl.TAG, "  Finished Retaining: " + this);
                }
                this.i = false;
                boolean z = this.f49143h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f49143h && this.f49140e && !this.k) {
                a(this.f49139d, this.f49142g);
            }
        }

        public void e() {
            if (this.f49143h && this.k) {
                this.k = false;
                if (this.f49140e) {
                    a(this.f49139d, this.f49142g);
                }
            }
        }

        public void f() {
            if (p.f49129g) {
                Log.v(LoaderManagerImpl.TAG, "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.f49143h;
            this.f49143h = false;
            this.f49138c = null;
        }

        public void g() {
            o.a<Object> aVar;
            if (this.i && this.j) {
                this.f49143h = true;
            } else if (this.f49143h) {
            } else {
                this.f49143h = true;
                if (p.f49129g) {
                    Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
                }
                if (this.f49139d == null && (aVar = this.f49138c) != null) {
                    this.f49139d = aVar.onCreateLoader(this.f49136a, this.f49137b);
                }
                d.b.g0.m.a.b.d<Object> dVar = this.f49139d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f49139d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f49139d);
                    } else if (!this.m) {
                        this.f49139d.c(this.f49136a, this);
                        throw null;
                    } else {
                        this.f49139d.e();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            d.b.g0.m.a.b.d<Object> dVar;
            if (p.f49129g) {
                Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.f49143h = false;
            if (this.i || (dVar = this.f49139d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.f(this);
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f49136a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.b.g0.m.a.c.c.a(this.f49139d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public p(String str, j jVar, boolean z) {
        this.f49132c = str;
        this.f49135f = jVar;
        this.f49133d = z;
    }

    public void b() {
        if (!this.f49134e) {
            if (f49129g) {
                Log.v(LoaderManagerImpl.TAG, "Destroying Active in " + this);
            }
            for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
                this.f49130a.g(f2).b();
            }
            this.f49130a.b();
        }
        if (f49129g) {
            Log.v(LoaderManagerImpl.TAG, "Destroying Inactive in " + this);
        }
        for (int f3 = this.f49131b.f() - 1; f3 >= 0; f3--) {
            this.f49131b.g(f3).b();
        }
        this.f49131b.b();
    }

    public void c() {
        for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
            this.f49130a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
            this.f49130a.g(f2).e();
        }
    }

    public void e() {
        if (f49129g) {
            Log.v(LoaderManagerImpl.TAG, "Retaining in " + this);
        }
        if (!this.f49133d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f49134e = true;
        this.f49133d = false;
        for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
            this.f49130a.g(f2).f();
        }
    }

    public void f() {
        if (f49129g) {
            Log.v(LoaderManagerImpl.TAG, "Starting in " + this);
        }
        if (this.f49133d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f49133d = true;
        for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
            this.f49130a.g(f2).g();
        }
    }

    public void g() {
        if (f49129g) {
            Log.v(LoaderManagerImpl.TAG, "Stopping in " + this);
        }
        if (!this.f49133d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
            this.f49130a.g(f2).h();
        }
        this.f49133d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f49130a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f49130a.f(); i++) {
                a g2 = this.f49130a.g(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f49130a.e(i));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f49131b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f49131b.f(); i2++) {
                a g3 = this.f49131b.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f49131b.e(i2));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f49134e) {
            if (f49129g) {
                Log.v(LoaderManagerImpl.TAG, "Finished Retaining in " + this);
            }
            this.f49134e = false;
            for (int f2 = this.f49130a.f() - 1; f2 >= 0; f2--) {
                this.f49130a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f49130a.f();
        boolean z = false;
        for (int i = 0; i < f2; i++) {
            a g2 = this.f49130a.g(i);
            z |= g2.f49143h && !g2.f49141f;
        }
        return z;
    }

    public void k(j jVar) {
        this.f49135f = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.b.g0.m.a.c.c.a(this.f49135f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
