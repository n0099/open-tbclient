package d.a.m0.h.o0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import d.a.m0.a.p.b.a.n;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c implements n {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f51326b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51327c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.m0.a.w2.c> f51325a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f51328d = false;

    public c(@NonNull FrameLayout frameLayout) {
        this.f51326b = frameLayout;
    }

    @Override // d.a.m0.a.p.b.a.n
    public boolean a(View view, d.a.m0.a.l1.e.a.a aVar) {
        if (d(view)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
            layoutParams.leftMargin = aVar.e();
            layoutParams.topMargin = aVar.f();
            this.f51326b.updateViewLayout(view, layoutParams);
            return true;
        }
        return false;
    }

    @Override // d.a.m0.a.p.b.a.n
    public boolean b() {
        return this.f51327c;
    }

    @Override // d.a.m0.a.p.b.a.n
    public boolean c(View view, d.a.m0.a.l1.e.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        layoutParams.leftMargin = aVar.e();
        layoutParams.topMargin = aVar.f();
        this.f51326b.addView(view, layoutParams);
        return true;
    }

    @Override // d.a.m0.a.p.b.a.n
    public boolean d(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = this.f51326b;
        return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
    }

    @Override // d.a.m0.a.p.b.a.n
    public synchronized void e(d.a.m0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f51325a.contains(cVar)) {
            this.f51325a.add(cVar);
        }
    }

    @Override // d.a.m0.a.p.b.a.n
    public synchronized void f(d.a.m0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f51325a.remove(cVar);
    }

    @Override // d.a.m0.a.p.b.a.n
    public void g(boolean z) {
        this.f51328d = z;
    }

    @Override // d.a.m0.a.p.b.a.n
    public Context getContext() {
        return this.f51326b.getContext();
    }

    @Override // d.a.m0.a.p.b.a.n
    public FrameLayout getRootView() {
        return this.f51326b;
    }

    @Override // d.a.m0.a.p.b.a.n
    public boolean h() {
        return this.f51328d;
    }

    public final synchronized void i() {
        this.f51325a.clear();
    }

    public final synchronized d.a.m0.a.w2.c[] j() {
        if (this.f51325a.isEmpty()) {
            return null;
        }
        d.a.m0.a.w2.c[] cVarArr = new d.a.m0.a.w2.c[this.f51325a.size()];
        this.f51325a.toArray(cVarArr);
        return cVarArr;
    }

    public void k() {
        d.a.m0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.m0.a.w2.c cVar : j) {
                cVar.f();
            }
        }
    }

    public void l() {
        d.a.m0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.m0.a.w2.c cVar : j) {
                cVar.k();
            }
        }
        i();
    }

    public void m() {
        d.a.m0.a.w2.c[] j = j();
        if (j != null) {
            for (d.a.m0.a.w2.c cVar : j) {
                cVar.n();
            }
        }
    }

    public void n(boolean z) {
        this.f51327c = z;
    }

    @Override // d.a.m0.a.p.b.a.n
    public boolean removeView(View view) {
        if (d(view)) {
            this.f51326b.removeView(view);
            return true;
        }
        return false;
    }
}
