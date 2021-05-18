package d.a.i0.a.z1.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import d.a.i0.a.i;
import d.a.i0.a.k;
import d.a.i0.a.z1.b.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f45971a;

    /* renamed from: b  reason: collision with root package name */
    public Context f45972b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f45973c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.z1.b.e.c f45975e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f45976f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f45977g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f45978h;
    public View j;
    public f l;
    public boolean k = true;
    public boolean m = false;
    public float n = 0.5f;
    public boolean o = false;
    public int p = i.swan_app_pop_window_anim;
    public Runnable r = new e();

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.i0.a.z1.b.e.b> f45974d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public int f45979i = -2;
    public boolean q = d.a.i0.a.c1.a.H().a();

    /* renamed from: d.a.i0.a.z1.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0925a implements b.a {
        public C0925a() {
        }

        @Override // d.a.i0.a.z1.b.e.b.a
        public void a(d.a.i0.a.z1.b.e.b bVar) {
            if (bVar.f()) {
                a.this.k(bVar.a());
            }
            b.a aVar = a.this.f45976f;
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
                    View.OnKeyListener onKeyListener = a.this.f45978h;
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
            d.a.i0.a.z1.b.e.c cVar = a.this.f45975e;
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
                a.this.u(a.this.f45977g);
            } catch (Exception e2) {
                if (k.f43025a) {
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
        void a(List<d.a.i0.a.z1.b.e.b> list);
    }

    /* loaded from: classes3.dex */
    public interface g {
    }

    public a(View view) {
        this.f45971a = view;
        this.f45972b = view.getContext();
        this.f45973c = this.f45971a.getResources();
        o(this.f45972b);
    }

    public d.a.i0.a.z1.b.e.b e(int i2, int i3) {
        return f(i2, this.f45973c.getString(i3), null);
    }

    public d.a.i0.a.z1.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        d.a.i0.a.z1.b.e.b bVar = new d.a.i0.a.z1.b.e.b(this.f45972b, i2, charSequence, drawable);
        g(bVar);
        return bVar;
    }

    public d.a.i0.a.z1.b.e.b g(d.a.i0.a.z1.b.e.b bVar) {
        bVar.g(this);
        if (this.k) {
            bVar.h(new C0925a());
        } else {
            bVar.h(this.f45976f);
        }
        this.f45974d.add(bVar);
        return bVar;
    }

    public final void h() {
        View view = this.f45971a;
        if (view != null) {
            ((ViewGroup) view.getRootView()).getOverlay().clear();
        }
    }

    public final void i(float f2) {
        View view = this.f45971a;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(-16777216);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (f2 * 255.0f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    public void j() {
        PopupWindow popupWindow = this.f45977g;
        if (popupWindow != null) {
            try {
                popupWindow.dismiss();
            } catch (Exception e2) {
                if (k.f43025a) {
                    Log.w("PopupWindow", "Exception", e2);
                }
            }
        }
    }

    public void k(long j) {
        View view = this.f45971a;
        if (view != null) {
            view.removeCallbacks(this.r);
            if (j > 0) {
                this.f45971a.postDelayed(this.r, j);
            } else {
                j();
            }
        }
    }

    public abstract void l(View view, List<d.a.i0.a.z1.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        PopupWindow popupWindow = this.f45977g;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void o(Context context) {
        View m = m(context);
        this.j = m;
        m.setFocusable(true);
        this.j.setFocusableInTouchMode(true);
        if (!(this.j instanceof g) && k.f43025a) {
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
        this.f45976f = aVar;
    }

    public void s(int i2) {
        this.f45979i = i2;
    }

    public void t() {
        if (d.a.i0.a.c1.a.H().a() != this.q) {
            o(this.f45972b);
            this.f45977g = null;
        }
        v(true);
        this.q = d.a.i0.a.c1.a.H().a();
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        d.a.i0.a.z1.b.e.c cVar = this.f45975e;
        if (cVar != null) {
            cVar.onShowMenu();
        }
        w(this.f45974d);
        l(this.j, this.f45974d);
        j();
        if (this.f45977g == null) {
            PopupWindow popupWindow = new PopupWindow(this.j, this.f45979i, -2, true);
            this.f45977g = popupWindow;
            if (this.o) {
                popupWindow.setAnimationStyle(this.p);
            }
            if (z) {
                this.f45977g.setBackgroundDrawable(this.f45973c.getDrawable(d.a.i0.a.e.aiapps_pop_transparent_bg));
                this.f45977g.setTouchable(true);
            } else {
                this.f45977g.setTouchable(false);
            }
            this.f45977g.setOnDismissListener(new c());
        }
        View view = this.f45971a;
        if (view == null) {
            d.a.i0.a.z1.b.e.c cVar2 = this.f45975e;
            if (cVar2 != null) {
                cVar2.onDismissMenu();
                return;
            }
            return;
        }
        view.post(new d());
        this.j.postInvalidate();
    }

    public void w(List<d.a.i0.a.z1.b.e.b> list) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(list);
        }
    }
}
