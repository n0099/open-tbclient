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
    public FrameLayout f51218b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51219c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.l0.a.w2.c> f51217a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f51220d = false;

    public c(@NonNull FrameLayout frameLayout) {
        this.f51218b = frameLayout;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean a(View view, d.a.l0.a.l1.e.a.a aVar) {
        if (d(view)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
            layoutParams.leftMargin = aVar.e();
            layoutParams.topMargin = aVar.f();
            this.f51218b.updateViewLayout(view, layoutParams);
            return true;
        }
        return false;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean b() {
        return this.f51219c;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean c(View view, d.a.l0.a.l1.e.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        layoutParams.leftMargin = aVar.e();
        layoutParams.topMargin = aVar.f();
        this.f51218b.addView(view, layoutParams);
        return true;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean d(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = this.f51218b;
        return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
    }

    @Override // d.a.l0.a.p.b.a.n
    public synchronized void e(d.a.l0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f51217a.contains(cVar)) {
            this.f51217a.add(cVar);
        }
    }

    @Override // d.a.l0.a.p.b.a.n
    public synchronized void f(d.a.l0.a.w2.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f51217a.remove(cVar);
    }

    @Override // d.a.l0.a.p.b.a.n
    public void g(boolean z) {
        this.f51220d = z;
    }

    @Override // d.a.l0.a.p.b.a.n
    public Context getContext() {
        return this.f51218b.getContext();
    }

    @Override // d.a.l0.a.p.b.a.n
    public FrameLayout getRootView() {
        return this.f51218b;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean h() {
        return this.f51220d;
    }

    public final synchronized void i() {
        this.f51217a.clear();
    }

    public final synchronized d.a.l0.a.w2.c[] j() {
        if (this.f51217a.isEmpty()) {
            return null;
        }
        d.a.l0.a.w2.c[] cVarArr = new d.a.l0.a.w2.c[this.f51217a.size()];
        this.f51217a.toArray(cVarArr);
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
        this.f51219c = z;
    }

    @Override // d.a.l0.a.p.b.a.n
    public boolean removeView(View view) {
        if (d(view)) {
            this.f51218b.removeView(view);
            return true;
        }
        return false;
    }
}
