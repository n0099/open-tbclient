package d.b.g0.m.a.a;

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
    public final Activity f49093a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f49094b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f49095c;

    /* renamed from: d  reason: collision with root package name */
    public final l f49096d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.m.a.c.f<String, o> f49097e;

    /* renamed from: f  reason: collision with root package name */
    public p f49098f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49099g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49100h;

    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    public void c() {
        p pVar = this.f49098f;
        if (pVar == null) {
            return;
        }
        pVar.b();
    }

    public void d() {
        if (this.f49100h) {
            return;
        }
        this.f49100h = true;
        p pVar = this.f49098f;
        if (pVar != null) {
            pVar.f();
        } else if (!this.f49099g) {
            p k = k("(root)", true, false);
            this.f49098f = k;
            if (k != null && !k.f49133d) {
                k.f();
            }
        }
        this.f49099g = true;
    }

    public void e(boolean z) {
        p pVar = this.f49098f;
        if (pVar != null && this.f49100h) {
            this.f49100h = false;
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
        printWriter.println(this.f49100h);
        if (this.f49098f != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f49098f)));
            printWriter.println(":");
            p pVar = this.f49098f;
            pVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public Activity g() {
        return this.f49093a;
    }

    public Context h() {
        return this.f49094b;
    }

    public l i() {
        return this.f49096d;
    }

    public Handler j() {
        return this.f49095c;
    }

    public p k(String str, boolean z, boolean z2) {
        if (this.f49097e == null) {
            this.f49097e = new d.b.g0.m.a.c.f<>();
        }
        p pVar = (p) this.f49097e.get(str);
        if (pVar != null) {
            pVar.k(this);
            return pVar;
        } else if (z2) {
            p pVar2 = new p(str, this, z);
            this.f49097e.put(str, pVar2);
            return pVar2;
        } else {
            return pVar;
        }
    }

    public p l() {
        p pVar = this.f49098f;
        if (pVar != null) {
            return pVar;
        }
        this.f49099g = true;
        p k = k("(root)", this.f49100h, true);
        this.f49098f = k;
        return k;
    }

    public void m(String str) {
        p pVar;
        d.b.g0.m.a.c.f<String, o> fVar = this.f49097e;
        if (fVar == null || (pVar = (p) fVar.get(str)) == null || pVar.f49134e) {
            return;
        }
        pVar.b();
        this.f49097e.remove(str);
    }

    public abstract void n(Fragment fragment);

    public abstract void o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract LayoutInflater p();

    public abstract int q();

    public abstract boolean r();

    public abstract void s(@NonNull Fragment fragment, @NonNull String[] strArr, int i);

    public abstract boolean t(Fragment fragment);

    public abstract void u();

    public void v() {
        d.b.g0.m.a.c.f<String, o> fVar = this.f49097e;
        if (fVar != null) {
            int size = fVar.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.f49097e.k(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.i();
                pVar.d();
            }
        }
    }

    public void w(d.b.g0.m.a.c.f<String, o> fVar) {
        this.f49097e = fVar;
    }

    public d.b.g0.m.a.c.f<String, o> x() {
        d.b.g0.m.a.c.f<String, o> fVar = this.f49097e;
        int i = 0;
        if (fVar != null) {
            int size = fVar.size();
            p[] pVarArr = new p[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                pVarArr[i2] = (p) this.f49097e.k(i2);
            }
            int i3 = 0;
            while (i < size) {
                p pVar = pVarArr[i];
                if (pVar.f49134e) {
                    i3 = 1;
                } else {
                    pVar.b();
                    this.f49097e.remove(pVar.f49132c);
                }
                i++;
            }
            i = i3;
        }
        if (i != 0) {
            return this.f49097e;
        }
        return null;
    }

    public j(Activity activity, Context context, Handler handler, int i) {
        this.f49096d = new l();
        this.f49093a = activity;
        this.f49094b = context;
        this.f49095c = handler;
    }
}
