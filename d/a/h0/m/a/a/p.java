package d.a.h0.m.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.loader.app.LoaderManagerImpl;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import d.a.h0.m.a.a.o;
import d.a.h0.m.a.b.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class p extends o {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f47372g = false;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.h0.m.a.c.g<a> f47373a = new d.a.h0.m.a.c.g<>();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.h0.m.a.c.g<a> f47374b = new d.a.h0.m.a.c.g<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f47375c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47376d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47377e;

    /* renamed from: f  reason: collision with root package name */
    public j f47378f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final int f47379a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f47380b;

        /* renamed from: c  reason: collision with root package name */
        public o.a<Object> f47381c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.h0.m.a.b.d<Object> f47382d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47383e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f47384f;

        /* renamed from: g  reason: collision with root package name */
        public Object f47385g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f47386h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f47387i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ p o;

        public void a(d.a.h0.m.a.b.d<Object> dVar, Object obj) {
            if (this.f47381c != null) {
                String str = null;
                if (this.o.f47378f != null) {
                    str = this.o.f47378f.f47336d.s;
                    this.o.f47378f.f47336d.s = "onLoadFinished";
                }
                try {
                    if (p.f47372g) {
                        Log.v(LoaderManagerImpl.TAG, "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                    }
                    this.f47381c.b(dVar, obj);
                    this.f47384f = true;
                } finally {
                    if (this.o.f47378f != null) {
                        this.o.f47378f.f47336d.s = str;
                    }
                }
            }
        }

        public void b() {
            String str;
            if (p.f47372g) {
                Log.v(LoaderManagerImpl.TAG, "  Destroying: " + this);
            }
            this.l = true;
            boolean z = this.f47384f;
            this.f47384f = false;
            if (this.f47381c != null && this.f47382d != null && this.f47383e && z) {
                if (p.f47372g) {
                    Log.v(LoaderManagerImpl.TAG, "  Reseting: " + this);
                }
                if (this.o.f47378f != null) {
                    str = this.o.f47378f.f47336d.s;
                    this.o.f47378f.f47336d.s = "onLoaderReset";
                } else {
                    str = null;
                }
                try {
                    this.f47381c.a(this.f47382d);
                } finally {
                    if (this.o.f47378f != null) {
                        this.o.f47378f.f47336d.s = str;
                    }
                }
            }
            this.f47381c = null;
            this.f47385g = null;
            this.f47383e = false;
            d.a.h0.m.a.b.d<Object> dVar = this.f47382d;
            if (dVar != null) {
                if (this.m) {
                    this.m = false;
                    dVar.h(this);
                    this.f47382d.i(this);
                }
                this.f47382d.e();
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f47379a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f47380b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f47381c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f47382d);
            d.a.h0.m.a.b.d<Object> dVar = this.f47382d;
            if (dVar != null) {
                dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.f47383e || this.f47384f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f47383e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f47384f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f47385g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f47386h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f47387i);
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
            if (this.f47387i) {
                if (p.f47372g) {
                    Log.v(LoaderManagerImpl.TAG, "  Finished Retaining: " + this);
                }
                this.f47387i = false;
                boolean z = this.f47386h;
                if (z != this.j && !z) {
                    h();
                }
            }
            if (this.f47386h && this.f47383e && !this.k) {
                a(this.f47382d, this.f47385g);
            }
        }

        public void e() {
            if (this.f47386h && this.k) {
                this.k = false;
                if (this.f47383e) {
                    a(this.f47382d, this.f47385g);
                }
            }
        }

        public void f() {
            if (p.f47372g) {
                Log.v(LoaderManagerImpl.TAG, "  Retaining: " + this);
            }
            this.f47387i = true;
            this.j = this.f47386h;
            this.f47386h = false;
            this.f47381c = null;
        }

        public void g() {
            o.a<Object> aVar;
            if (this.f47387i && this.j) {
                this.f47386h = true;
            } else if (this.f47386h) {
            } else {
                this.f47386h = true;
                if (p.f47372g) {
                    Log.v(LoaderManagerImpl.TAG, "  Starting: " + this);
                }
                if (this.f47382d == null && (aVar = this.f47381c) != null) {
                    this.f47382d = aVar.onCreateLoader(this.f47379a, this.f47380b);
                }
                d.a.h0.m.a.b.d<Object> dVar = this.f47382d;
                if (dVar != null) {
                    if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f47382d.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f47382d);
                    }
                    if (!this.m) {
                        this.f47382d.c(this.f47379a, this);
                        this.f47382d.d(this);
                        this.m = true;
                    }
                    this.f47382d.f();
                    throw null;
                }
            }
        }

        public void h() {
            d.a.h0.m.a.b.d<Object> dVar;
            if (p.f47372g) {
                Log.v(LoaderManagerImpl.TAG, "  Stopping: " + this);
            }
            this.f47386h = false;
            if (this.f47387i || (dVar = this.f47382d) == null || !this.m) {
                return;
            }
            this.m = false;
            dVar.h(this);
            this.f47382d.i(this);
            this.f47382d.g();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f47379a);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            d.a.h0.m.a.c.c.a(this.f47382d, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    public p(String str, j jVar, boolean z) {
        this.f47375c = str;
        this.f47378f = jVar;
        this.f47376d = z;
    }

    public void b() {
        if (!this.f47377e) {
            if (f47372g) {
                Log.v(LoaderManagerImpl.TAG, "Destroying Active in " + this);
            }
            for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
                this.f47373a.g(f2).b();
            }
            this.f47373a.b();
        }
        if (f47372g) {
            Log.v(LoaderManagerImpl.TAG, "Destroying Inactive in " + this);
        }
        for (int f3 = this.f47374b.f() - 1; f3 >= 0; f3--) {
            this.f47374b.g(f3).b();
        }
        this.f47374b.b();
    }

    public void c() {
        for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
            this.f47373a.g(f2).k = true;
        }
    }

    public void d() {
        for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
            this.f47373a.g(f2).e();
        }
    }

    public void e() {
        if (f47372g) {
            Log.v(LoaderManagerImpl.TAG, "Retaining in " + this);
        }
        if (!this.f47376d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doRetain when not started: " + this, runtimeException);
            return;
        }
        this.f47377e = true;
        this.f47376d = false;
        for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
            this.f47373a.g(f2).f();
        }
    }

    public void f() {
        if (f47372g) {
            Log.v(LoaderManagerImpl.TAG, "Starting in " + this);
        }
        if (this.f47376d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f47376d = true;
        for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
            this.f47373a.g(f2).g();
        }
    }

    public void g() {
        if (f47372g) {
            Log.v(LoaderManagerImpl.TAG, "Stopping in " + this);
        }
        if (!this.f47376d) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w(LoaderManagerImpl.TAG, "Called doStop when not started: " + this, runtimeException);
            return;
        }
        for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
            this.f47373a.g(f2).h();
        }
        this.f47376d = false;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.f47373a.f() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f47373a.f(); i2++) {
                a g2 = this.f47373a.g(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f47373a.e(i2));
                printWriter.print(": ");
                printWriter.println(g2.toString());
                g2.c(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f47374b.f() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i3 = 0; i3 < this.f47374b.f(); i3++) {
                a g3 = this.f47374b.g(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f47374b.e(i3));
                printWriter.print(": ");
                printWriter.println(g3.toString());
                g3.c(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i() {
        if (this.f47377e) {
            if (f47372g) {
                Log.v(LoaderManagerImpl.TAG, "Finished Retaining in " + this);
            }
            this.f47377e = false;
            for (int f2 = this.f47373a.f() - 1; f2 >= 0; f2--) {
                this.f47373a.g(f2).d();
            }
        }
    }

    public boolean j() {
        int f2 = this.f47373a.f();
        boolean z = false;
        for (int i2 = 0; i2 < f2; i2++) {
            a g2 = this.f47373a.g(i2);
            z |= g2.f47386h && !g2.f47384f;
        }
        return z;
    }

    public void k(j jVar) {
        this.f47378f = jVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a.h0.m.a.c.c.a(this.f47378f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
