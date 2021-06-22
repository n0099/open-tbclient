package d.a.m0.o.a.a;

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
public abstract class k<E> extends i {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f52006a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f52007b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f52008c;

    /* renamed from: d  reason: collision with root package name */
    public final m f52009d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.o.a.c.f<String, p> f52010e;

    /* renamed from: f  reason: collision with root package name */
    public q f52011f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52012g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52013h;

    public k(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    public void c() {
        q qVar = this.f52011f;
        if (qVar == null) {
            return;
        }
        qVar.b();
    }

    public void d() {
        if (this.f52013h) {
            return;
        }
        this.f52013h = true;
        q qVar = this.f52011f;
        if (qVar != null) {
            qVar.f();
        } else if (!this.f52012g) {
            q k = k("(root)", true, false);
            this.f52011f = k;
            if (k != null && !k.f52052d) {
                k.f();
            }
        }
        this.f52012g = true;
    }

    public void e(boolean z) {
        q qVar = this.f52011f;
        if (qVar != null && this.f52013h) {
            this.f52013h = false;
            if (z) {
                qVar.e();
            } else {
                qVar.g();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f52013h);
        if (this.f52011f != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f52011f)));
            printWriter.println(":");
            q qVar = this.f52011f;
            qVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
        }
    }

    public Activity g() {
        return this.f52006a;
    }

    public Context h() {
        return this.f52007b;
    }

    public m i() {
        return this.f52009d;
    }

    public Handler j() {
        return this.f52008c;
    }

    public q k(String str, boolean z, boolean z2) {
        if (this.f52010e == null) {
            this.f52010e = new d.a.m0.o.a.c.f<>();
        }
        q qVar = (q) this.f52010e.get(str);
        if (qVar != null) {
            qVar.k(this);
            return qVar;
        } else if (z2) {
            q qVar2 = new q(str, this, z);
            this.f52010e.put(str, qVar2);
            return qVar2;
        } else {
            return qVar;
        }
    }

    public q l() {
        q qVar = this.f52011f;
        if (qVar != null) {
            return qVar;
        }
        this.f52012g = true;
        q k = k("(root)", this.f52013h, true);
        this.f52011f = k;
        return k;
    }

    public void m(String str) {
        q qVar;
        d.a.m0.o.a.c.f<String, p> fVar = this.f52010e;
        if (fVar == null || (qVar = (q) fVar.get(str)) == null || qVar.f52053e) {
            return;
        }
        qVar.b();
        this.f52010e.remove(str);
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
        d.a.m0.o.a.c.f<String, p> fVar = this.f52010e;
        if (fVar != null) {
            int size = fVar.size();
            q[] qVarArr = new q[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                qVarArr[i2] = (q) this.f52010e.k(i2);
            }
            for (int i3 = 0; i3 < size; i3++) {
                q qVar = qVarArr[i3];
                qVar.i();
                qVar.d();
            }
        }
    }

    public void w(d.a.m0.o.a.c.f<String, p> fVar) {
        this.f52010e = fVar;
    }

    public d.a.m0.o.a.c.f<String, p> x() {
        d.a.m0.o.a.c.f<String, p> fVar = this.f52010e;
        int i2 = 0;
        if (fVar != null) {
            int size = fVar.size();
            q[] qVarArr = new q[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                qVarArr[i3] = (q) this.f52010e.k(i3);
            }
            int i4 = 0;
            while (i2 < size) {
                q qVar = qVarArr[i2];
                if (qVar.f52053e) {
                    i4 = 1;
                } else {
                    qVar.b();
                    this.f52010e.remove(qVar.f52051c);
                }
                i2++;
            }
            i2 = i4;
        }
        if (i2 != 0) {
            return this.f52010e;
        }
        return null;
    }

    public k(Activity activity, Context context, Handler handler, int i2) {
        this.f52009d = new m();
        this.f52006a = activity;
        this.f52007b = context;
        this.f52008c = handler;
    }
}
