package d.a.i0.h.o0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import d.a.i0.a.p.b.a.n;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements n {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f47368b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47369c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.i0.a.w2.c> f47367a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f47370d = false;

    public c(@NonNull FrameLayout frameLayout) {
        this.f47368b = frameLayout;
    }

    @Override // d.a.i0.a.p.b.a.n
    public boolean a(View view, d.a.i0.a.l1.e.a.a aVar) {
        if (d(view)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
            layoutParams.leftMargin = aVar.e();
            layoutParams.topMargin = aVar.f();
            this.f47368b.updateViewLayout(view, layoutParams);
            return true;
        }
        return false;
    }

    @Override // d.a.i0.a.p.b.a.n
    public boolean b() {
        return this.f47369c;
    }

    @Override // d.a.i0.a.p.b.a.n
    public boolean c(View view, d.a.i0.a.l1.e.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        layoutParams.leftMargin = aVar.e();
        layoutParams.topMargin = aVar.f();
        this.f47368b.addView(view, layoutParams);
        return true;
    }

    @Override // d.a.i0.a.p.b.a.n
    public boolean d(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = this.f47368b;
        return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
    }

    @Override // d.a.i0.a.p.b.a.n
    public synchronized void e(d.a.i0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f47367a.contains(cVar)) {
            this.f47367a.add(cVar);
        }
    }

    @Override // d.a.i0.a.p.b.a.n
    public synchronized void f(d.a.i0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f47367a.remove(cVar);
    }

    @Override // d.a.i0.a.p.b.a.n
    public void g(boolean z) {
        this.f47370d = z;
    }

    @Override // d.a.i0.a.p.b.a.n
    public Context getContext() {
        return this.f47368b.getContext();
    }

    @Override // d.a.i0.a.p.b.a.n
    public FrameLayout getRootView() {
        return this.f47368b;
    }

    @Override // d.a.i0.a.p.b.a.n
    public boolean h() {
        return this.f47370d;
    }

    public final synchronized void i() {
        this.f47367a.clear();
    }

    public final synchronized d.a.i0.a.w2.c[] j() {
        if (this.f47367a.isEmpty()) {
            return null;
        }
        d.a.i0.a.w2.c[] cVarArr = new d.a.i0.a.w2.c[this.f47367a.size()];
        this.f47367a.toArray(cVarArr);
        return cVarArr;
    }

    public void k() {
        d.a.i0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.i0.a.w2.c cVar : j) {
                cVar.f();
            }
        }
    }

    public void l() {
        d.a.i0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.i0.a.w2.c cVar : j) {
                cVar.k();
            }
        }
        i();
    }

    public void m() {
        d.a.i0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.i0.a.w2.c cVar : j) {
                cVar.n();
            }
        }
    }

    public void n(boolean z) {
        this.f47369c = z;
    }

    @Override // d.a.i0.a.p.b.a.n
    public boolean removeView(View view) {
        if (d(view)) {
            this.f47368b.removeView(view);
            return true;
        }
        return false;
    }
}
