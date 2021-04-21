package d.b.h0.m.a.a;

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
    public final Activity f49815a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f49816b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f49817c;

    /* renamed from: d  reason: collision with root package name */
    public final l f49818d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.m.a.c.f<String, o> f49819e;

    /* renamed from: f  reason: collision with root package name */
    public p f49820f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49821g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49822h;

    public j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    public void c() {
        p pVar = this.f49820f;
        if (pVar == null) {
            return;
        }
        pVar.b();
    }

    public void d() {
        if (this.f49822h) {
            return;
        }
        this.f49822h = true;
        p pVar = this.f49820f;
        if (pVar != null) {
            pVar.f();
        } else if (!this.f49821g) {
            p k = k("(root)", true, false);
            this.f49820f = k;
            if (k != null && !k.f49855d) {
                k.f();
            }
        }
        this.f49821g = true;
    }

    public void e(boolean z) {
        p pVar = this.f49820f;
        if (pVar != null && this.f49822h) {
            this.f49822h = false;
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
        printWriter.println(this.f49822h);
        if (this.f49820f != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f49820f)));
            printWriter.println(":");
            p pVar = this.f49820f;
            pVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public Activity g() {
        return this.f49815a;
    }

    public Context h() {
        return this.f49816b;
    }

    public l i() {
        return this.f49818d;
    }

    public Handler j() {
        return this.f49817c;
    }

    public p k(String str, boolean z, boolean z2) {
        if (this.f49819e == null) {
            this.f49819e = new d.b.h0.m.a.c.f<>();
        }
        p pVar = (p) this.f49819e.get(str);
        if (pVar != null) {
            pVar.k(this);
            return pVar;
        } else if (z2) {
            p pVar2 = new p(str, this, z);
            this.f49819e.put(str, pVar2);
            return pVar2;
        } else {
            return pVar;
        }
    }

    public p l() {
        p pVar = this.f49820f;
        if (pVar != null) {
            return pVar;
        }
        this.f49821g = true;
        p k = k("(root)", this.f49822h, true);
        this.f49820f = k;
        return k;
    }

    public void m(String str) {
        p pVar;
        d.b.h0.m.a.c.f<String, o> fVar = this.f49819e;
        if (fVar == null || (pVar = (p) fVar.get(str)) == null || pVar.f49856e) {
            return;
        }
        pVar.b();
        this.f49819e.remove(str);
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
        d.b.h0.m.a.c.f<String, o> fVar = this.f49819e;
        if (fVar != null) {
            int size = fVar.size();
            p[] pVarArr = new p[size];
            for (int i = size - 1; i >= 0; i--) {
                pVarArr[i] = (p) this.f49819e.k(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = pVarArr[i2];
                pVar.i();
                pVar.d();
            }
        }
    }

    public void w(d.b.h0.m.a.c.f<String, o> fVar) {
        this.f49819e = fVar;
    }

    public d.b.h0.m.a.c.f<String, o> x() {
        d.b.h0.m.a.c.f<String, o> fVar = this.f49819e;
        int i = 0;
        if (fVar != null) {
            int size = fVar.size();
            p[] pVarArr = new p[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                pVarArr[i2] = (p) this.f49819e.k(i2);
            }
            int i3 = 0;
            while (i < size) {
                p pVar = pVarArr[i];
                if (pVar.f49856e) {
                    i3 = 1;
                } else {
                    pVar.b();
                    this.f49819e.remove(pVar.f49854c);
                }
                i++;
            }
            i = i3;
        }
        if (i != 0) {
            return this.f49819e;
        }
        return null;
    }

    public j(Activity activity, Context context, Handler handler, int i) {
        this.f49818d = new l();
        this.f49815a = activity;
        this.f49816b = context;
        this.f49817c = handler;
    }
}
