package d.a.m0.o.a.a;

import android.os.Bundle;
import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.a.m0.o.a.a.p;
import d.a.m0.o.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class q extends p {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f52048g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.m0.o.a.c.g<a> f52049a = new d.a.m0.o.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.m0.o.a.c.g<a> f52050b = new d.a.m0.o.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f52051c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52052d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52053e;

    /* renamed from: f  reason: collision with root package name */
    public k f52054f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f52055a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f52056b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f52057c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.m0.o.a.b.d<Object> f52058d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52059e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f52060f;

        /* renamed from: g  reason: collision with root package name */
        public Object f52061g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f52062h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f52063i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.m0.o.a.b.d<Object> dVar, Object obj) {
            if (this.f52057c != null) {
                String str = null;
                if (this.o.f52054f != null) {
                    str = this.o.f52054f.f52009d.s;
                    this.o.f52054f.f52009d.s = "onLoadFinished";
                }
                try {
                    if (q.f52048g) {
                        Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                    }
                    this.f52057c.b(dVar, obj);
                    this.f52060f = true;
                } finally {
                    if (this.o.f52054f != null) {
                        this.o.f52054f.f52009d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (q.f52048g) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f52060f;
            this.f52060f = false;
            if (this.f52057c != null && this.f52058d != null && this.f52059e && z) {
                if (q.f52048g) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.o.f52054f != null) {
                    str = this.o.f52054f.f52009d.s;
                    this.o.f52054f.f52009d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f52057c.a(this.f52058d);
                } finally {
                    if (this.o.f52054f != null) {
                        this.o.f52054f.f52009d.s = str;
                    }
                }
            }
            this.f52057c = null;
            this.f52061g = null;
            this.f52059e = false;
            d.a.m0.o.a.b.d<Object> dVar = this.f52058d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.h(this);
                    this.f52058d.i(this);
                }
                this.f52058d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f52055a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f52056b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f52057c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f52058d);
            d.a.m0.o.a.b.d<Object> dVar = this.f52058d;
            if (dVar != null) {
                dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.f52059e || this.f52060f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f52059e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f52060f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f52061g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f52062h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f52063i);
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
            if (this.f52063i) {
                if (q.f52048g) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f52063i = false;
                boolean z = this.f52062h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f52062h && this.f52059e && !this.k) {
                a(this.f52058d, this.f52061g);
            }
        }

        public void e() {
            if (this.f52062h && this.k) {
                this.k = false;
                if (this.f52059e) {
                    a(this.f52058d, this.f52061g);
                }
            }
        }

        public void f() {
            if (q.f52048g) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f52063i = true;
            this.j = this.f52062h;
            this.f52062h = false;
            this.f52057c = null;
        }

        public void g() {
            p.a<Object> aVar;
            if (this.f52063i && this.j) {
                this.f52062h = true;
            } else if (this.f52062h) {
            } else {
                this.f52062h = true;
                if (q.f52048g) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f52058d == null && (aVar = this.f52057c) != null) {
                    this.f52058d = aVar.onCreateLoader(this.f52055a, this.f52056b);
                }
                d.a.m0.o.a.b.d<Object> dVar = this.f52058d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f52058d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f52058d);
                    }
                    if (!this.m) {
                        this.f52058d.c(this.f52055a, this);
                        this.f52058d.d(this);
                        this.m = true;
                    }
                    this.f52058d.f();
                    throw null;
                }
            }
        }

        public void h() {
            d.a.m0.o.a.b.d<Object> dVar;
            if (q.f52048g) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f52062h = false;
            if (this.f52063i || (dVar = this.f52058d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.h(this);
            this.f52058d.i(this);
            this.f52058d.g();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f52055a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.a.m0.o.a.c.c.a(this.f52058d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public q(String str, k kVar, boolean z) {
        this.f52051c = str;
        this.f52054f = kVar;
        this.f52052d = z;
    }

    public void b() {
        if (!this.f52053e) {
            if (f52048g) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
                this.f52049a.g(f2).b();
            }
            this.f52049a.b();
        }
        if (f52048g) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int f3 = this.f52050b.f() - 1; f3 >= 0; f3--) {
            this.f52050b.g(f3).b();
        }
        this.f52050b.b();
    }

    public void c() {
        for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
            this.f52049a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
            this.f52049a.g(f2).e();
        }
    }

    public void e() {
        if (f52048g) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f52052d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f52053e = true;
        this.f52052d = false;
        for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
            this.f52049a.g(f2).f();
        }
    }

    public void f() {
        if (f52048g) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f52052d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f52052d = true;
        for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
            this.f52049a.g(f2).g();
        }
    }

    public void g() {
        if (f52048g) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f52052d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
            this.f52049a.g(f2).h();
        }
        this.f52052d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f52049a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f52049a.f(); i2++) {
                a g2 = this.f52049a.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f52049a.e(i2));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f52050b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i3 = 0; i3 < this.f52050b.f(); i3++) {
                a g3 = this.f52050b.g(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f52050b.e(i3));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f52053e) {
            if (f52048g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f52053e = false;
            for (int f2 = this.f52049a.f() - 1; f2 >= 0; f2--) {
                this.f52049a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f52049a.f();
        boolean z = false;
        for (int i2 = 0; i2 < f2; i2++) {
            a g2 = this.f52049a.g(i2);
            z |= g2.f52062h && !g2.f52060f;
        }
        return z;
    }

    public void k(k kVar) {
        this.f52054f = kVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a.m0.o.a.c.c.a(this.f52054f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
