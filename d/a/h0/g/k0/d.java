package d.a.h0.g.k0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f46437b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46438c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f46436a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f46439d = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.f46437b = frameLayout;
    }

    public final synchronized void a() {
        this.f46436a.clear();
    }

    public final synchronized a[] b() {
        if (this.f46436a.isEmpty()) {
            return null;
        }
        a[] aVarArr = new a[this.f46436a.size()];
        this.f46436a.toArray(aVarArr);
        return aVarArr;
    }

    public Context c() {
        return this.f46437b.getContext();
    }

    public boolean d() {
        return this.f46439d;
    }

    public FrameLayout e() {
        return this.f46437b;
    }

    public boolean f(View view, d.a.h0.a.e1.d.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        layoutParams.leftMargin = aVar.e();
        layoutParams.topMargin = aVar.f();
        this.f46437b.addView(view, layoutParams);
        return true;
    }

    public boolean g(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = this.f46437b;
        return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
    }

    public boolean h() {
        return this.f46438c;
    }

    public void i() {
        a[] b2 = b();
        if (b2 != null) {
            for (a aVar : b2) {
                aVar.f();
            }
        }
    }

    public void j() {
        a[] b2 = b();
        if (b2 != null) {
            for (a aVar : b2) {
                aVar.j();
            }
        }
        a();
    }

    public void k() {
        a[] b2 = b();
        if (b2 != null) {
            for (a aVar : b2) {
                aVar.m();
            }
        }
    }

    public synchronized void l(a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.f46436a.contains(aVar)) {
            this.f46436a.add(aVar);
        }
    }

    public boolean m(View view) {
        if (g(view)) {
            this.f46437b.removeView(view);
            return true;
        }
        return false;
    }

    public void n(boolean z) {
        this.f46439d = z;
    }

    public void o(boolean z) {
        this.f46438c = z;
    }

    public synchronized void p(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f46436a.remove(aVar);
    }

    public boolean q(View view, d.a.h0.a.e1.d.a.a aVar) {
        if (g(view)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
            layoutParams.leftMargin = aVar.e();
            layoutParams.topMargin = aVar.f();
            this.f46437b.updateViewLayout(view, layoutParams);
            return true;
        }
        return false;
    }
}
