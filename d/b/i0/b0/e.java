package d.b.i0.b0;

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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f51968c;

    /* renamed from: d  reason: collision with root package name */
    public View f51969d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51970e;

    /* renamed from: f  reason: collision with root package name */
    public String f51971f;

    /* renamed from: g  reason: collision with root package name */
    public String f51972g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51973h;
    public int r;
    public int s;
    public int t;
    public int u;
    public View.OnClickListener x;
    public boolean y;

    /* renamed from: a  reason: collision with root package name */
    public Handler f51966a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.e.g.c f51967b = null;
    public int i = R.drawable.pic_sign_tip;
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

        /* renamed from: d.b.i0.b0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1125a implements d.b.b.e.g.b {
            public C1125a() {
            }

            @Override // d.b.b.e.g.b
            public int a() {
                return e.this.w;
            }

            @Override // d.b.b.e.g.b
            public View b(LayoutInflater layoutInflater) {
                Drawable drawable;
                int i;
                TextView textView = new TextView(e.this.f51968c.getPageActivity());
                textView.setText(e.this.f51971f);
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
                textView.setTextSize(0, e.this.f51968c.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                if (e.this.B != 0) {
                    textView.setHeight(e.this.B);
                } else {
                    textView.setHeight(e.this.f51968c.getResources().getDimensionPixelSize(R.dimen.ds76));
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
                            i = e.this.E;
                        } else {
                            i = R.color.CAM_X0101;
                        }
                        drawable = WebPManager.getPureDrawable(e.this.G, SkinManager.getColor(i), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(e.this.G);
                    }
                    int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g2, g2);
                    textView.setCompoundDrawablePadding(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                SkinManager.setBackgroundResource(textView, e.this.i);
                if (e.this.x != null) {
                    textView.setOnClickListener(e.this.x);
                }
                return textView;
            }

            @Override // d.b.b.e.g.b
            public int c() {
                return e.this.v;
            }

            @Override // d.b.b.e.g.b
            public int getXOffset() {
                return e.this.p;
            }

            @Override // d.b.b.e.g.b
            public int getYOffset() {
                return e.this.q;
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f51967b == null && !StringUtils.isNull(e.this.f51971f)) {
                if (!e.this.y || e.this.G()) {
                    d.b.b.e.g.d dVar = new d.b.b.e.g.d();
                    dVar.j(e.this.f51969d);
                    dVar.c(0);
                    dVar.i(true);
                    dVar.h(true);
                    dVar.a(new C1125a());
                    e.this.f51967b = dVar.b();
                    e.this.f51967b.l(false);
                    e.this.f51967b.m(e.this.z);
                    e.this.f51967b.o(e.this.f51968c.getPageActivity(), e.this.o);
                    e.this.f51970e = true;
                    e.this.J();
                    e.this.f51973h = true;
                    e.this.f51966a.postDelayed(e.this.J, e.this.n);
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
        this.f51968c = tbPageContext;
        this.f51969d = view;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.s = this.f51968c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.t = this.f51968c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.u = this.f51968c.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public boolean G() {
        View view = this.f51969d;
        return view != null && view.getVisibility() == 0 && ((double) this.f51969d.getAlpha()) >= 0.4d;
    }

    public void H() {
        d.b.b.e.g.c cVar = this.f51967b;
        if (cVar != null) {
            cVar.d();
            this.f51967b = null;
        }
        Handler handler = this.f51966a;
        if (handler != null) {
            handler.removeCallbacks(this.I);
            this.f51966a.removeCallbacks(this.J);
        }
        this.f51973h = false;
    }

    public boolean I() {
        return this.f51973h;
    }

    public final void J() {
        if (this.k) {
            return;
        }
        d.b.h0.r.d0.b.i().u(this.f51972g, this.j + 1);
    }

    public void K(int i) {
        this.w = i;
    }

    public void L(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void M(int i) {
        if (i > 0) {
            this.n = i;
        }
    }

    public void N(int i) {
        this.v = i;
    }

    public void O(@DimenRes int i) {
        this.B = this.f51968c.getResources().getDimensionPixelSize(i);
    }

    public void P(boolean z) {
        this.D = z;
    }

    public void Q(boolean z) {
        this.H = z;
    }

    public void R(int i) {
        this.A = i;
    }

    public void S(int i) {
        if (i > 0) {
            this.l = i;
        }
    }

    public void T(boolean z) {
        this.y = z;
    }

    public void U(boolean z) {
        this.o = z;
    }

    public void V(int i) {
        if (i > 0) {
            this.m = i;
        }
    }

    public void W(@ColorRes int i) {
        this.E = i;
    }

    public void X(int i) {
        this.G = i;
    }

    public void Y(int i, int i2, int i3, int i4) {
        this.r = i;
        this.s = i2;
        this.t = i3;
        this.u = i4;
    }

    public void Z(int i) {
        this.u = i;
    }

    public void a0(int i) {
        this.s = i;
    }

    public void b0(int i) {
        this.F = i;
    }

    public void c0(int i) {
        if (i > 0) {
            this.i = i;
        }
    }

    public void d0(boolean z) {
        this.z = z;
    }

    public void e0(@DimenRes int i) {
        this.C = this.f51968c.getResources().getDimensionPixelSize(i);
    }

    public void f0(int i) {
        this.p = i;
    }

    public void g0(int i) {
        this.q = i;
    }

    public void h0(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f51971f = str;
        if (this.f51966a == null) {
            this.f51966a = new Handler();
        }
        this.f51966a.postDelayed(this.I, this.m);
    }

    public void i0(String str, String str2) {
        j0(str, str2, false);
    }

    public boolean j0(String str, String str2, boolean z) {
        return k0(str, str2, z, false);
    }

    public boolean k0(String str, String str2, boolean z, boolean z2) {
        View view;
        if (this.f51970e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view = this.f51969d) == null || view.getVisibility() != 0) {
            return false;
        }
        this.f51971f = str;
        this.f51972g = str2;
        this.k = z2;
        int j = d.b.h0.r.d0.b.i().j(str2, 0);
        this.j = j;
        if (j < this.l || this.k) {
            if (z) {
                J();
                this.f51970e = true;
            }
            if (this.f51966a == null) {
                this.f51966a = new Handler();
            }
            this.f51966a.postDelayed(this.I, this.m);
            return true;
        }
        return false;
    }
}
