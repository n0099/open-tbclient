package d.b.h0.g.k0;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f48962b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48963c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f48961a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f48964d = false;

    public d(@NonNull FrameLayout frameLayout) {
        this.f48962b = frameLayout;
    }

    public final synchronized void a() {
        this.f48961a.clear();
    }

    public final synchronized a[] b() {
        if (this.f48961a.isEmpty()) {
            return null;
        }
        a[] aVarArr = new a[this.f48961a.size()];
        this.f48961a.toArray(aVarArr);
        return aVarArr;
    }

    public Context c() {
        return this.f48962b.getContext();
    }

    public boolean d() {
        return this.f48964d;
    }

    public FrameLayout e() {
        return this.f48962b;
    }

    public boolean f(View view, d.b.h0.a.e1.d.a.a aVar) {
        if (view == null || aVar == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        layoutParams.leftMargin = aVar.e();
        layoutParams.topMargin = aVar.f();
        this.f48962b.addView(view, layoutParams);
        return true;
    }

    public boolean g(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = this.f48962b;
        return parent == frameLayout && frameLayout.indexOfChild(view) >= 0;
    }

    public boolean h() {
        return this.f48963c;
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
                aVar.k();
            }
        }
        a();
    }

    public void k() {
        a[] b2 = b();
        if (b2 != null) {
            for (a aVar : b2) {
                aVar.q();
            }
        }
    }

    public synchronized void l(a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.f48961a.contains(aVar)) {
            this.f48961a.add(aVar);
        }
    }

    public boolean m(View view) {
        if (g(view)) {
            this.f48962b.removeView(view);
            return true;
        }
        return false;
    }

    public void n(boolean z) {
        this.f48964d = z;
    }

    public void o(boolean z) {
        this.f48963c = z;
    }

    public synchronized void p(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f48961a.remove(aVar);
    }

    public boolean q(View view, d.b.h0.a.e1.d.a.a aVar) {
        if (g(view)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
            layoutParams.leftMargin = aVar.e();
            layoutParams.topMargin = aVar.f();
            this.f48962b.updateViewLayout(view, layoutParams);
            return true;
        }
        return false;
    }
}
