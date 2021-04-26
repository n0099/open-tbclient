package d.a.h0.m.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes3.dex */
public abstract class j<E> extends h {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f47333a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f47334b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f47335c;

    /* renamed from: d  reason: collision with root package name */
    public final l f47336d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.m.a.c.f<String, o> f47337e;

    /* renamed from: f  reason: collision with root package name */
    public p f47338f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47339g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47340h;

    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    public void c() {
        p pVar = this.f47338f;
        if (pVar == null) {
            return;
        }
        pVar.b();
    }

    public void d() {
        if (this.f47340h) {
            return;
        }
        this.f47340h = true;
        p pVar = this.f47338f;
        if (pVar != null) {
            pVar.f();
        } else if (!this.f47339g) {
            p k = k("(root)", true, false);
            this.f47338f = k;
            if (k != null && !k.f47376d) {
                k.f();
            }
        }
        this.f47339g = true;
    }

    public void e(boolean z) {
        p pVar = this.f47338f;
        if (pVar != null && this.f47340h) {
            this.f47340h = false;
            if (z) {
                pVar.e();
            } else {
                pVar.g();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f47340h);
        if (this.f47338f != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f47338f)));
            printWriter.println(":");
            p pVar = this.f47338f;
            pVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public Activity g() {
        return this.f47333a;
    }

    public Context h() {
        return this.f47334b;
    }

    public l i() {
        return this.f47336d;
    }

    public Handler j() {
        return this.f47335c;
    }

    public p k(String str, boolean z, boolean z2) {
        if (this.f47337e == null) {
            this.f47337e = new d.a.h0.m.a.c.f<>();
        }
        p pVar = (p) this.f47337e.get(str);
        if (pVar != null) {
            pVar.k(this);
            return pVar;
        } else if (z2) {
            p pVar2 = new p(str, this, z);
            this.f47337e.put(str, pVar2);
            return pVar2;
        } else {
            return pVar;
        }
    }

    public p l() {
        p pVar = this.f47338f;
        if (pVar != null) {
            return pVar;
        }
        this.f47339g = true;
        p k = k("(root)", this.f47340h, true);
        this.f47338f = k;
        return k;
    }

    public void m(String str) {
        p pVar;
        d.a.h0.m.a.c.f<String, o> fVar = this.f47337e;
        if (fVar == null || (pVar = (p) fVar.get(str)) == null || pVar.f47377e) {
            return;
        }
        pVar.b();
        this.f47337e.remove(str);
    }

    public abstract void n(Fragment fragment);

    public abstract void o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract LayoutInflater p();

    public abstract int q();

    public abstract boolean r();

    public abstract void s(@NonNull Fragment fragment, @NonNull String[] strArr, int i2);

    public abstract boolean t(Fragment fragment);

    public abstract void u();

    public void v() {
        d.a.h0.m.a.c.f<String, o> fVar = this.f47337e;
        if (fVar != null) {
            int size = fVar.size();
            p[] pVarArr = new p[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                pVarArr[i2] = (p) this.f47337e.k(i2);
            }
            for (int i3 = 0; i3 < size; i3++) {
                p pVar = pVarArr[i3];
                pVar.i();
                pVar.d();
            }
        }
    }

    public void w(d.a.h0.m.a.c.f<String, o> fVar) {
        this.f47337e = fVar;
    }

    public d.a.h0.m.a.c.f<String, o> x() {
        d.a.h0.m.a.c.f<String, o> fVar = this.f47337e;
        int i2 = 0;
        if (fVar != null) {
            int size = fVar.size();
            p[] pVarArr = new p[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                pVarArr[i3] = (p) this.f47337e.k(i3);
            }
            int i4 = 0;
            while (i2 < size) {
                p pVar = pVarArr[i2];
                if (pVar.f47377e) {
                    i4 = 1;
                } else {
                    pVar.b();
                    this.f47337e.remove(pVar.f47375c);
                }
                i2++;
            }
            i2 = i4;
        }
        if (i2 != 0) {
            return this.f47337e;
        }
        return null;
    }

    public j(Activity activity, Context context, Handler handler, int i2) {
        this.f47336d = new l();
        this.f47333a = activity;
        this.f47334b = context;
        this.f47335c = handler;
    }
}
