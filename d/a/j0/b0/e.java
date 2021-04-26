package d.a.j0.b0;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f51418c;

    /* renamed from: d  reason: collision with root package name */
    public View f51419d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51420e;

    /* renamed from: f  reason: collision with root package name */
    public String f51421f;

    /* renamed from: g  reason: collision with root package name */
    public String f51422g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51423h;
    public int r;
    public int s;
    public int t;
    public int u;
    public View.OnClickListener x;
    public boolean y;

    /* renamed from: a  reason: collision with root package name */
    public Handler f51416a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.g.c f51417b = null;

    /* renamed from: i  reason: collision with root package name */
    public int f51424i = R.drawable.pic_sign_tip;
    public int j = 0;
    public boolean k = false;
    public int l = 1;
    public int m = 1000;
    public int n = 3000;
    public boolean o = true;
    public int p = 5;
    public int q = 0;
    public int v = 48;
    public int w = 4;
    public boolean z = false;
    public int A = 1;
    public int B = 0;
    public int C = 0;
    public boolean D = false;
    public int E = 0;
    public int F = 0;
    public int G = 0;
    public boolean H = false;
    public Runnable I = new a();
    public Runnable J = new b();

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: d.a.j0.b0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1140a implements d.a.c.e.g.b {
            public C1140a() {
            }

            @Override // d.a.c.e.g.b
            public int a() {
                return e.this.w;
            }

            @Override // d.a.c.e.g.b
            public int b() {
                return e.this.v;
            }

            @Override // d.a.c.e.g.b
            public View c(LayoutInflater layoutInflater) {
                Drawable drawable;
                int i2;
                TextView textView = new TextView(e.this.f51418c.getPageActivity());
                textView.setText(e.this.f51421f);
                if (e.this.F != 0) {
                    textView.setGravity(e.this.F);
                } else {
                    textView.setGravity(17);
                }
                if (e.this.E != 0) {
                    SkinManager.setViewTextColor(textView, e.this.E);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                }
                textView.setTextSize(0, e.this.f51418c.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (e.this.B != 0) {
                    textView.setHeight(e.this.B);
                } else {
                    textView.setHeight(e.this.f51418c.getResources().getDimensionPixelSize(R.dimen.ds76));
                }
                if (e.this.C != 0) {
                    textView.setWidth(e.this.C);
                }
                textView.setPadding(e.this.r, e.this.s, e.this.t, e.this.u);
                textView.setLines(e.this.A);
                if (e.this.D) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                if (e.this.G != 0) {
                    if (e.this.H) {
                        if (e.this.E != 0) {
                            i2 = e.this.E;
                        } else {
                            i2 = R.color.CAM_X0101;
                        }
                        drawable = WebPManager.getPureDrawable(e.this.G, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(e.this.G);
                    }
                    int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g2, g2);
                    textView.setCompoundDrawablePadding(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                SkinManager.setBackgroundResource(textView, e.this.f51424i);
                if (e.this.x != null) {
                    textView.setOnClickListener(e.this.x);
                }
                return textView;
            }

            @Override // d.a.c.e.g.b
            public int getXOffset() {
                return e.this.p;
            }

            @Override // d.a.c.e.g.b
            public int getYOffset() {
                return e.this.q;
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f51417b == null && !StringUtils.isNull(e.this.f51421f)) {
                if (!e.this.y || e.this.G()) {
                    d.a.c.e.g.d dVar = new d.a.c.e.g.d();
                    dVar.j(e.this.f51419d);
                    dVar.c(0);
                    dVar.i(true);
                    dVar.h(true);
                    dVar.a(new C1140a());
                    e.this.f51417b = dVar.b();
                    e.this.f51417b.k(false);
                    e.this.f51417b.l(e.this.z);
                    e.this.f51417b.n(e.this.f51418c.getPageActivity(), e.this.o);
                    e.this.f51420e = true;
                    e.this.J();
                    e.this.f51423h = true;
                    e.this.f51416a.postDelayed(e.this.J, e.this.n);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.H();
        }
    }

    public e(TbPageContext tbPageContext, View view) {
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.f51418c = tbPageContext;
        this.f51419d = view;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.s = this.f51418c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.t = this.f51418c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.u = this.f51418c.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public boolean G() {
        View view = this.f51419d;
        return view != null && view.getVisibility() == 0 && ((double) this.f51419d.getAlpha()) >= 0.4d;
    }

    public void H() {
        d.a.c.e.g.c cVar = this.f51417b;
        if (cVar != null) {
            cVar.d();
            this.f51417b = null;
        }
        Handler handler = this.f51416a;
        if (handler != null) {
            handler.removeCallbacks(this.I);
            this.f51416a.removeCallbacks(this.J);
        }
        this.f51423h = false;
    }

    public boolean I() {
        return this.f51423h;
    }

    public final void J() {
        if (this.k) {
            return;
        }
        d.a.i0.r.d0.b.j().v(this.f51422g, this.j + 1);
    }

    public void K(int i2) {
        this.w = i2;
    }

    public void L(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void M(int i2) {
        if (i2 > 0) {
            this.n = i2;
        }
    }

    public void N(int i2) {
        this.v = i2;
    }

    public void O(@DimenRes int i2) {
        this.B = this.f51418c.getResources().getDimensionPixelSize(i2);
    }

    public void P(boolean z) {
        this.D = z;
    }

    public void Q(boolean z) {
        this.H = z;
    }

    public void R(int i2) {
        this.A = i2;
    }

    public void S(int i2) {
        if (i2 > 0) {
            this.l = i2;
        }
    }

    public void T(boolean z) {
        this.y = z;
    }

    public void U(boolean z) {
        this.o = z;
    }

    public void V(int i2) {
        if (i2 > 0) {
            this.m = i2;
        }
    }

    public void W(@ColorRes int i2) {
        this.E = i2;
    }

    public void X(int i2) {
        this.G = i2;
    }

    public void Y(int i2, int i3, int i4, int i5) {
        this.r = i2;
        this.s = i3;
        this.t = i4;
        this.u = i5;
    }

    public void Z(int i2) {
        this.u = i2;
    }

    public void a0(int i2) {
        this.s = i2;
    }

    public void b0(int i2) {
        this.F = i2;
    }

    public void c0(int i2) {
        if (i2 > 0) {
            this.f51424i = i2;
        }
    }

    public void d0(boolean z) {
        this.z = z;
    }

    public void e0(@DimenRes int i2) {
        this.C = this.f51418c.getResources().getDimensionPixelSize(i2);
    }

    public void f0(int i2) {
        this.p = i2;
    }

    public void g0(int i2) {
        this.q = i2;
    }

    public void h0(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f51421f = str;
        if (this.f51416a == null) {
            this.f51416a = new Handler();
        }
        this.f51416a.postDelayed(this.I, this.m);
    }

    public void i0(String str, String str2) {
        j0(str, str2, false);
    }

    public boolean j0(String str, String str2, boolean z) {
        return k0(str, str2, z, false);
    }

    public boolean k0(String str, String str2, boolean z, boolean z2) {
        View view;
        if (this.f51420e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view = this.f51419d) == null || view.getVisibility() != 0) {
            return false;
        }
        this.f51421f = str;
        this.f51422g = str2;
        this.k = z2;
        int k = d.a.i0.r.d0.b.j().k(str2, 0);
        this.j = k;
        if (k < this.l || this.k) {
            if (z) {
                J();
                this.f51420e = true;
            }
            if (this.f51416a == null) {
                this.f51416a = new Handler();
            }
            this.f51416a.postDelayed(this.I, this.m);
            return true;
        }
        return false;
    }
}
