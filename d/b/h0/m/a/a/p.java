package d.b.h0.m.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.loader.app.LoaderManagerImpl;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.b.h0.m.a.a.o;
import d.b.h0.m.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class p extends o {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f49851g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.b.h0.m.a.c.g<a> f49852a = new d.b.h0.m.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.b.h0.m.a.c.g<a> f49853b = new d.b.h0.m.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f49854c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49855d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49856e;

    /* renamed from: f  reason: collision with root package name */
    public j f49857f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f49858a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f49859b;

        /* renamed from: c  reason: collision with root package name */
        public o.a<Object> f49860c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.h0.m.a.b.d<Object> f49861d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f49862e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f49863f;

        /* renamed from: g  reason: collision with root package name */
        public Object f49864g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f49865h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ p o;

        public void a(d.b.h0.m.a.b.d<Object> dVar, Object obj) {
            if (this.f49860c != null) {
                String str = null;
                if (this.o.f49857f != null) {
                    str = this.o.f49857f.f49818d.s;
                    this.o.f49857f.f49818d.s = "onLoadFinished";
                }
                try {
                    if (p.f49851g) {
                        Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                    }
                    this.f49860c.b(dVar, obj);
                    this.f49863f = true;
                } finally {
                    if (this.o.f49857f != null) {
                        this.o.f49857f.f49818d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (p.f49851g) {
                Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f49863f;
            this.f49863f = false;
            if (this.f49860c != null && this.f49861d != null && this.f49862e && z) {
                if (p.f49851g) {
                    Log.v(LoaderManagerImpl.TAG, "  Reseting: " + this);
                }
                if (this.o.f49857f != null) {
                    str = this.o.f49857f.f49818d.s;
                    this.o.f49857f.f49818d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f49860c.a(this.f49861d);
                } finally {
                    if (this.o.f49857f != null) {
                        this.o.f49857f.f49818d.s = str;
                    }
                }
            }
            this.f49860c = null;
            this.f49864g = null;
            this.f49862e = false;
            d.b.h0.m.a.b.d<Object> dVar = this.f49861d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.h(this);
                    this.f49861d.i(this);
                }
                this.f49861d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f49858a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f49859b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f49860c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f49861d);
            d.b.h0.m.a.b.d<Object> dVar = this.f49861d;
            if (dVar != null) {
                dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.f49862e || this.f49863f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f49862e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f49863f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f49864g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f49865h);
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
            }
        }

        public void d() {
            if (this.i) {
                if (p.f49851g) {
                    Log.v(LoaderManagerImpl.TAG, "  Finished Retaining: " + this);
                }
                this.i = false;
                boolean z = this.f49865h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f49865h && this.f49862e && !this.k) {
                a(this.f49861d, this.f49864g);
            }
        }

        public void e() {
            if (this.f49865h && this.k) {
                this.k = false;
                if (this.f49862e) {
                    a(this.f49861d, this.f49864g);
                }
            }
        }

        public void f() {
            if (p.f49851g) {
                Log.v(LoaderManagerImpl.TAG, "  Retaining: " + this);
            }
            this.i = true;
            this.j = this.f49865h;
            this.f49865h = false;
            this.f49860c = null;
        }

        public void g() {
            o.a<Object> aVar;
            if (this.i && this.j) {
                this.f49865h = true;
            } else if (this.f49865h) {
            } else {
                this.f49865h = true;
                if (p.f49851g) {
                    Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
                }
                if (this.f49861d == null && (aVar = this.f49860c) != null) {
                    this.f49861d = aVar.onCreateLoader(this.f49858a, this.f49859b);
                }
                d.b.h0.m.a.b.d<Object> dVar = this.f49861d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f49861d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f49861d);
                    }
                    if (!this.m) {
                        this.f49861d.c(this.f49858a, this);
                        this.f49861d.d(this);
                        this.m = true;
                    }
                    this.f49861d.f();
                    throw null;
                }
            }
        }

        public void h() {
            d.b.h0.m.a.b.d<Object> dVar;
            if (p.f49851g) {
                Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.f49865h = false;
            if (this.i || (dVar = this.f49861d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.h(this);
            this.f49861d.i(this);
            this.f49861d.g();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f49858a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.b.h0.m.a.c.c.a(this.f49861d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public p(String str, j jVar, boolean z) {
        this.f49854c = str;
        this.f49857f = jVar;
        this.f49855d = z;
    }

    public void b() {
        if (!this.f49856e) {
            if (f49851g) {
                Log.v(LoaderManagerImpl.TAG, "Destroying Active in " + this);
            }
            for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
                this.f49852a.g(f2).b();
            }
            this.f49852a.b();
        }
        if (f49851g) {
            Log.v(LoaderManagerImpl.TAG, "Destroying Inactive in " + this);
        }
        for (int f3 = this.f49853b.f() - 1; f3 >= 0; f3--) {
            this.f49853b.g(f3).b();
        }
        this.f49853b.b();
    }

    public void c() {
        for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
            this.f49852a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
            this.f49852a.g(f2).e();
        }
    }

    public void e() {
        if (f49851g) {
            Log.v(LoaderManagerImpl.TAG, "Retaining in " + this);
        }
        if (!this.f49855d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f49856e = true;
        this.f49855d = false;
        for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
            this.f49852a.g(f2).f();
        }
    }

    public void f() {
        if (f49851g) {
            Log.v(LoaderManagerImpl.TAG, "Starting in " + this);
        }
        if (this.f49855d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f49855d = true;
        for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
            this.f49852a.g(f2).g();
        }
    }

    public void g() {
        if (f49851g) {
            Log.v(LoaderManagerImpl.TAG, "Stopping in " + this);
        }
        if (!this.f49855d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
            this.f49852a.g(f2).h();
        }
        this.f49855d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f49852a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.f49852a.f(); i++) {
                a g2 = this.f49852a.g(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f49852a.e(i));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f49853b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.f49853b.f(); i2++) {
                a g3 = this.f49853b.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f49853b.e(i2));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f49856e) {
            if (f49851g) {
                Log.v(LoaderManagerImpl.TAG, "Finished Retaining in " + this);
            }
            this.f49856e = false;
            for (int f2 = this.f49852a.f() - 1; f2 >= 0; f2--) {
                this.f49852a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f49852a.f();
        boolean z = false;
        for (int i = 0; i < f2; i++) {
            a g2 = this.f49852a.g(i);
            z |= g2.f49865h && !g2.f49863f;
        }
        return z;
    }

    public void k(j jVar) {
        this.f49857f = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.b.h0.m.a.c.c.a(this.f49857f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
