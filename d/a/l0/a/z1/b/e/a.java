package d.a.l0.a.z1.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import d.a.l0.a.i;
import d.a.l0.a.k;
import d.a.l0.a.z1.b.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f49821a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49822b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f49823c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.z1.b.e.c f49825e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f49826f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f49827g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f49828h;
    public View j;
    public f l;
    public boolean k = true;
    public boolean m = false;
    public float n = 0.5f;
    public boolean o = false;
    public int p = i.swan_app_pop_window_anim;
    public Runnable r = new e();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.l0.a.z1.b.e.b> f49824d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public int f49829i = -2;
    public boolean q = d.a.l0.a.c1.a.H().a();

    /* renamed from: d.a.l0.a.z1.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0992a implements b.a {
        public C0992a() {
        }

        @Override // d.a.l0.a.z1.b.e.b.a
        public void a(d.a.l0.a.z1.b.e.b bVar) {
            if (bVar.f()) {
                a.this.k(bVar.a());
            }
            b.a aVar = a.this.f49826f;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1) {
                if (i2 == 4 || i2 == 82) {
                    a.this.j();
                    View.OnKeyListener onKeyListener = a.this.f49828h;
                    if (onKeyListener != null) {
                        onKeyListener.onKey(view, i2, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.m) {
                a.this.h();
            }
            d.a.l0.a.z1.b.e.c cVar = a.this.f49825e;
            if (cVar != null) {
                cVar.onDismissMenu();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.m) {
                    a.this.i(a.this.n);
                }
                a.this.u(a.this.f49827g);
            } catch (Exception e2) {
                if (k.f46875a) {
                    Log.w("PopupWindow", "Exception", e2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(List<d.a.l0.a.z1.b.e.b> list);
    }

    /* loaded from: classes3.dex */
    public interface g {
    }

    public a(View view) {
        this.f49821a = view;
        this.f49822b = view.getContext();
        this.f49823c = this.f49821a.getResources();
        o(this.f49822b);
    }

    public d.a.l0.a.z1.b.e.b e(int i2, int i3) {
        return f(i2, this.f49823c.getString(i3), null);
    }

    public d.a.l0.a.z1.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        d.a.l0.a.z1.b.e.b bVar = new d.a.l0.a.z1.b.e.b(this.f49822b, i2, charSequence, drawable);
        g(bVar);
        return bVar;
    }

    public d.a.l0.a.z1.b.e.b g(d.a.l0.a.z1.b.e.b bVar) {
        bVar.g(this);
        if (this.k) {
            bVar.h(new C0992a());
        } else {
            bVar.h(this.f49826f);
        }
        this.f49824d.add(bVar);
        return bVar;
    }

    public final void h() {
        View view = this.f49821a;
        if (view != null) {
            ((ViewGroup) view.getRootView()).getOverlay().clear();
        }
    }

    public final void i(float f2) {
        View view = this.f49821a;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(-16777216);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (f2 * 255.0f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    public void j() {
        PopupWindow popupWindow = this.f49827g;
        if (popupWindow != null) {
            try {
                popupWindow.dismiss();
            } catch (Exception e2) {
                if (k.f46875a) {
                    Log.w("PopupWindow", "Exception", e2);
                }
            }
        }
    }

    public void k(long j) {
        View view = this.f49821a;
        if (view != null) {
            view.removeCallbacks(this.r);
            if (j > 0) {
                this.f49821a.postDelayed(this.r, j);
            } else {
                j();
            }
        }
    }

    public abstract void l(View view, List<d.a.l0.a.z1.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        PopupWindow popupWindow = this.f49827g;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void o(Context context) {
        View m = m(context);
        this.j = m;
        m.setFocusable(true);
        this.j.setFocusableInTouchMode(true);
        if (!(this.j instanceof g) && k.f46875a) {
            throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
        }
        this.j.setOnKeyListener(new b());
    }

    public void p(boolean z) {
        this.m = z;
    }

    public void q(boolean z) {
        this.o = z;
    }

    public void r(b.a aVar) {
        this.f49826f = aVar;
    }

    public void s(int i2) {
        this.f49829i = i2;
    }

    public void t() {
        if (d.a.l0.a.c1.a.H().a() != this.q) {
            o(this.f49822b);
            this.f49827g = null;
        }
        v(true);
        this.q = d.a.l0.a.c1.a.H().a();
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        d.a.l0.a.z1.b.e.c cVar = this.f49825e;
        if (cVar != null) {
            cVar.onShowMenu();
        }
        w(this.f49824d);
        l(this.j, this.f49824d);
        j();
        if (this.f49827g == null) {
            PopupWindow popupWindow = new PopupWindow(this.j, this.f49829i, -2, true);
            this.f49827g = popupWindow;
            if (this.o) {
                popupWindow.setAnimationStyle(this.p);
            }
            if (z) {
                this.f49827g.setBackgroundDrawable(this.f49823c.getDrawable(d.a.l0.a.e.aiapps_pop_transparent_bg));
                this.f49827g.setTouchable(true);
            } else {
                this.f49827g.setTouchable(false);
            }
            this.f49827g.setOnDismissListener(new c());
        }
        View view = this.f49821a;
        if (view == null) {
            d.a.l0.a.z1.b.e.c cVar2 = this.f49825e;
            if (cVar2 != null) {
                cVar2.onDismissMenu();
                return;
            }
            return;
        }
        view.post(new d());
        this.j.postInvalidate();
    }

    public void w(List<d.a.l0.a.z1.b.e.b> list) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(list);
        }
    }
}
