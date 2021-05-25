package d.a.l0.o.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.loader.app.LoaderManagerImpl;
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
    public static boolean f48266g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.l0.o.a.c.g<a> f48267a = new d.a.l0.o.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.l0.o.a.c.g<a> f48268b = new d.a.l0.o.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f48269c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48270d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48271e;

    /* renamed from: f  reason: collision with root package name */
    public k f48272f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f48273a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f48274b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f48275c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.l0.o.a.b.d<Object> f48276d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48277e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f48278f;

        /* renamed from: g  reason: collision with root package name */
        public Object f48279g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f48280h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f48281i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.l0.o.a.b.d<Object> dVar, Object obj) {
            if (this.f48275c != null) {
                String str = null;
                if (this.o.f48272f != null) {
                    str = this.o.f48272f.f48227d.s;
                    this.o.f48272f.f48227d.s = "onLoadFinished";
                }
                try {
                    if (q.f48266g) {
                        Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                    }
                    this.f48275c.b(dVar, obj);
                    this.f48278f = true;
                } finally {
                    if (this.o.f48272f != null) {
                        this.o.f48272f.f48227d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (q.f48266g) {
                Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f48278f;
            this.f48278f = false;
            if (this.f48275c != null && this.f48276d != null && this.f48277e && z) {
                if (q.f48266g) {
                    Log.v(LoaderManagerImpl.TAG, "  Reseting: " + this);
                }
                if (this.o.f48272f != null) {
                    str = this.o.f48272f.f48227d.s;
                    this.o.f48272f.f48227d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f48275c.a(this.f48276d);
                } finally {
                    if (this.o.f48272f != null) {
                        this.o.f48272f.f48227d.s = str;
                    }
                }
            }
            this.f48275c = null;
            this.f48279g = null;
            this.f48277e = false;
            d.a.l0.o.a.b.d<Object> dVar = this.f48276d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.h(this);
                    this.f48276d.i(this);
                }
                this.f48276d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f48273a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f48274b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f48275c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f48276d);
            d.a.l0.o.a.b.d<Object> dVar = this.f48276d;
            if (dVar != null) {
                dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.f48277e || this.f48278f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f48277e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f48278f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f48279g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f48280h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f48281i);
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
            if (this.f48281i) {
                if (q.f48266g) {
                    Log.v(LoaderManagerImpl.TAG, "  Finished Retaining: " + this);
                }
                this.f48281i = false;
                boolean z = this.f48280h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f48280h && this.f48277e && !this.k) {
                a(this.f48276d, this.f48279g);
            }
        }

        public void e() {
            if (this.f48280h && this.k) {
                this.k = false;
                if (this.f48277e) {
                    a(this.f48276d, this.f48279g);
                }
            }
        }

        public void f() {
            if (q.f48266g) {
                Log.v(LoaderManagerImpl.TAG, "  Retaining: " + this);
            }
            this.f48281i = true;
            this.j = this.f48280h;
            this.f48280h = false;
            this.f48275c = null;
        }

        public void g() {
            p.a<Object> aVar;
            if (this.f48281i && this.j) {
                this.f48280h = true;
            } else if (this.f48280h) {
            } else {
                this.f48280h = true;
                if (q.f48266g) {
                    Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
                }
                if (this.f48276d == null && (aVar = this.f48275c) != null) {
                    this.f48276d = aVar.onCreateLoader(this.f48273a, this.f48274b);
                }
                d.a.l0.o.a.b.d<Object> dVar = this.f48276d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f48276d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f48276d);
                    }
                    if (!this.m) {
                        this.f48276d.c(this.f48273a, this);
                        this.f48276d.d(this);
                        this.m = true;
                    }
                    this.f48276d.f();
                    throw null;
                }
            }
        }

        public void h() {
            d.a.l0.o.a.b.d<Object> dVar;
            if (q.f48266g) {
                Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.f48280h = false;
            if (this.f48281i || (dVar = this.f48276d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.h(this);
            this.f48276d.i(this);
            this.f48276d.g();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f48273a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.a.l0.o.a.c.c.a(this.f48276d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public q(String str, k kVar, boolean z) {
        this.f48269c = str;
        this.f48272f = kVar;
        this.f48270d = z;
    }

    public void b() {
        if (!this.f48271e) {
            if (f48266g) {
                Log.v(LoaderManagerImpl.TAG, "Destroying Active in " + this);
            }
            for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
                this.f48267a.g(f2).b();
            }
            this.f48267a.b();
        }
        if (f48266g) {
            Log.v(LoaderManagerImpl.TAG, "Destroying Inactive in " + this);
        }
        for (int f3 = this.f48268b.f() - 1; f3 >= 0; f3--) {
            this.f48268b.g(f3).b();
        }
        this.f48268b.b();
    }

    public void c() {
        for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
            this.f48267a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
            this.f48267a.g(f2).e();
        }
    }

    public void e() {
        if (f48266g) {
            Log.v(LoaderManagerImpl.TAG, "Retaining in " + this);
        }
        if (!this.f48270d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f48271e = true;
        this.f48270d = false;
        for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
            this.f48267a.g(f2).f();
        }
    }

    public void f() {
        if (f48266g) {
            Log.v(LoaderManagerImpl.TAG, "Starting in " + this);
        }
        if (this.f48270d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f48270d = true;
        for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
            this.f48267a.g(f2).g();
        }
    }

    public void g() {
        if (f48266g) {
            Log.v(LoaderManagerImpl.TAG, "Stopping in " + this);
        }
        if (!this.f48270d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
            this.f48267a.g(f2).h();
        }
        this.f48270d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f48267a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f48267a.f(); i2++) {
                a g2 = this.f48267a.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f48267a.e(i2));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f48268b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i3 = 0; i3 < this.f48268b.f(); i3++) {
                a g3 = this.f48268b.g(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f48268b.e(i3));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f48271e) {
            if (f48266g) {
                Log.v(LoaderManagerImpl.TAG, "Finished Retaining in " + this);
            }
            this.f48271e = false;
            for (int f2 = this.f48267a.f() - 1; f2 >= 0; f2--) {
                this.f48267a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f48267a.f();
        boolean z = false;
        for (int i2 = 0; i2 < f2; i2++) {
            a g2 = this.f48267a.g(i2);
            z |= g2.f48280h && !g2.f48278f;
        }
        return z;
    }

    public void k(k kVar) {
        this.f48272f = kVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a.l0.o.a.c.c.a(this.f48272f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
