package d.a.i0.o.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.loader.app.LoaderManagerImpl;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.a.i0.o.a.a.p;
import d.a.i0.o.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class q extends p {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f48090g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.i0.o.a.c.g<a> f48091a = new d.a.i0.o.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.i0.o.a.c.g<a> f48092b = new d.a.i0.o.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f48093c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48094d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48095e;

    /* renamed from: f  reason: collision with root package name */
    public k f48096f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f48097a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f48098b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f48099c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.i0.o.a.b.d<Object> f48100d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48101e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f48102f;

        /* renamed from: g  reason: collision with root package name */
        public Object f48103g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f48104h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f48105i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(d.a.i0.o.a.b.d<Object> dVar, Object obj) {
            if (this.f48099c != null) {
                String str = null;
                if (this.o.f48096f != null) {
                    str = this.o.f48096f.f48051d.s;
                    this.o.f48096f.f48051d.s = "onLoadFinished";
                }
                try {
                    if (q.f48090g) {
                        Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                    }
                    this.f48099c.b(dVar, obj);
                    this.f48102f = true;
                } finally {
                    if (this.o.f48096f != null) {
                        this.o.f48096f.f48051d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (q.f48090g) {
                Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f48102f;
            this.f48102f = false;
            if (this.f48099c != null && this.f48100d != null && this.f48101e && z) {
                if (q.f48090g) {
                    Log.v(LoaderManagerImpl.TAG, "  Reseting: " + this);
                }
                if (this.o.f48096f != null) {
                    str = this.o.f48096f.f48051d.s;
                    this.o.f48096f.f48051d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f48099c.a(this.f48100d);
                } finally {
                    if (this.o.f48096f != null) {
                        this.o.f48096f.f48051d.s = str;
                    }
                }
            }
            this.f48099c = null;
            this.f48103g = null;
            this.f48101e = false;
            d.a.i0.o.a.b.d<Object> dVar = this.f48100d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.h(this);
                    this.f48100d.i(this);
                }
                this.f48100d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f48097a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f48098b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f48099c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f48100d);
            d.a.i0.o.a.b.d<Object> dVar = this.f48100d;
            if (dVar != null) {
                dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.f48101e || this.f48102f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f48101e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f48102f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f48103g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f48104h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f48105i);
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
            if (this.f48105i) {
                if (q.f48090g) {
                    Log.v(LoaderManagerImpl.TAG, "  Finished Retaining: " + this);
                }
                this.f48105i = false;
                boolean z = this.f48104h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f48104h && this.f48101e && !this.k) {
                a(this.f48100d, this.f48103g);
            }
        }

        public void e() {
            if (this.f48104h && this.k) {
                this.k = false;
                if (this.f48101e) {
                    a(this.f48100d, this.f48103g);
                }
            }
        }

        public void f() {
            if (q.f48090g) {
                Log.v(LoaderManagerImpl.TAG, "  Retaining: " + this);
            }
            this.f48105i = true;
            this.j = this.f48104h;
            this.f48104h = false;
            this.f48099c = null;
        }

        public void g() {
            p.a<Object> aVar;
            if (this.f48105i && this.j) {
                this.f48104h = true;
            } else if (this.f48104h) {
            } else {
                this.f48104h = true;
                if (q.f48090g) {
                    Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
                }
                if (this.f48100d == null && (aVar = this.f48099c) != null) {
                    this.f48100d = aVar.onCreateLoader(this.f48097a, this.f48098b);
                }
                d.a.i0.o.a.b.d<Object> dVar = this.f48100d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f48100d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f48100d);
                    }
                    if (!this.m) {
                        this.f48100d.c(this.f48097a, this);
                        this.f48100d.d(this);
                        this.m = true;
                    }
                    this.f48100d.f();
                    throw null;
                }
            }
        }

        public void h() {
            d.a.i0.o.a.b.d<Object> dVar;
            if (q.f48090g) {
                Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.f48104h = false;
            if (this.f48105i || (dVar = this.f48100d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.h(this);
            this.f48100d.i(this);
            this.f48100d.g();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f48097a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.a.i0.o.a.c.c.a(this.f48100d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public q(String str, k kVar, boolean z) {
        this.f48093c = str;
        this.f48096f = kVar;
        this.f48094d = z;
    }

    public void b() {
        if (!this.f48095e) {
            if (f48090g) {
                Log.v(LoaderManagerImpl.TAG, "Destroying Active in " + this);
            }
            for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
                this.f48091a.g(f2).b();
            }
            this.f48091a.b();
        }
        if (f48090g) {
            Log.v(LoaderManagerImpl.TAG, "Destroying Inactive in " + this);
        }
        for (int f3 = this.f48092b.f() - 1; f3 >= 0; f3--) {
            this.f48092b.g(f3).b();
        }
        this.f48092b.b();
    }

    public void c() {
        for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
            this.f48091a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
            this.f48091a.g(f2).e();
        }
    }

    public void e() {
        if (f48090g) {
            Log.v(LoaderManagerImpl.TAG, "Retaining in " + this);
        }
        if (!this.f48094d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f48095e = true;
        this.f48094d = false;
        for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
            this.f48091a.g(f2).f();
        }
    }

    public void f() {
        if (f48090g) {
            Log.v(LoaderManagerImpl.TAG, "Starting in " + this);
        }
        if (this.f48094d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f48094d = true;
        for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
            this.f48091a.g(f2).g();
        }
    }

    public void g() {
        if (f48090g) {
            Log.v(LoaderManagerImpl.TAG, "Stopping in " + this);
        }
        if (!this.f48094d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
            this.f48091a.g(f2).h();
        }
        this.f48094d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f48091a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f48091a.f(); i2++) {
                a g2 = this.f48091a.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f48091a.e(i2));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f48092b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i3 = 0; i3 < this.f48092b.f(); i3++) {
                a g3 = this.f48092b.g(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f48092b.e(i3));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f48095e) {
            if (f48090g) {
                Log.v(LoaderManagerImpl.TAG, "Finished Retaining in " + this);
            }
            this.f48095e = false;
            for (int f2 = this.f48091a.f() - 1; f2 >= 0; f2--) {
                this.f48091a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f48091a.f();
        boolean z = false;
        for (int i2 = 0; i2 < f2; i2++) {
            a g2 = this.f48091a.g(i2);
            z |= g2.f48104h && !g2.f48102f;
        }
        return z;
    }

    public void k(k kVar) {
        this.f48096f = kVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a.i0.o.a.c.c.a(this.f48096f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
