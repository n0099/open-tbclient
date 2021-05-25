package d.a.l0.h.o0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import d.a.l0.a.p.b.a.n;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements n {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f47544b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47545c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.l0.a.w2.c> f47543a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f47546d = false;

    public c(@NonNull FrameLayout frameLayout) {
        this.f47544b = frameLayout;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean a(View view, d.a.l0.a.l1.e.a.a aVar) {
        if (d(view)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
            layoutParams.leftMargin = aVar.e();
            layoutParams.topMargin = aVar.f();
            this.f47544b.updateViewLayout(view, layoutParams);
            return true;
        }
        return false;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean b() {
        return this.f47545c;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean c(View view, d.a.l0.a.l1.e.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        layoutParams.leftMargin = aVar.e();
        layoutParams.topMargin = aVar.f();
        this.f47544b.addView(view, layoutParams);
        return true;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean d(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = this.f47544b;
        return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
    }

    @Override // d.a.l0.a.p.b.a.n
    public synchronized void e(d.a.l0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f47543a.contains(cVar)) {
            this.f47543a.add(cVar);
        }
    }

    @Override // d.a.l0.a.p.b.a.n
    public synchronized void f(d.a.l0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f47543a.remove(cVar);
    }

    @Override // d.a.l0.a.p.b.a.n
    public void g(boolean z) {
        this.f47546d = z;
    }

    @Override // d.a.l0.a.p.b.a.n
    public Context getContext() {
        return this.f47544b.getContext();
    }

    @Override // d.a.l0.a.p.b.a.n
    public FrameLayout getRootView() {
        return this.f47544b;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean h() {
        return this.f47546d;
    }

    public final synchronized void i() {
        this.f47543a.clear();
    }

    public final synchronized d.a.l0.a.w2.c[] j() {
        if (this.f47543a.isEmpty()) {
            return null;
        }
        d.a.l0.a.w2.c[] cVarArr = new d.a.l0.a.w2.c[this.f47543a.size()];
        this.f47543a.toArray(cVarArr);
        return cVarArr;
    }

    public void k() {
        d.a.l0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.l0.a.w2.c cVar : j) {
                cVar.f();
            }
        }
    }

    public void l() {
        d.a.l0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.l0.a.w2.c cVar : j) {
                cVar.k();
            }
        }
        i();
    }

    public void m() {
        d.a.l0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.l0.a.w2.c cVar : j) {
                cVar.n();
            }
        }
    }

    public void n(boolean z) {
        this.f47545c = z;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean removeView(View view) {
        if (d(view)) {
            this.f47544b.removeView(view);
            return true;
        }
        return false;
    }
}
