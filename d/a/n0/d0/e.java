package d.a.n0.d0;

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
    public TbPageContext f52420c;

    /* renamed from: d  reason: collision with root package name */
    public View f52421d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52422e;

    /* renamed from: f  reason: collision with root package name */
    public String f52423f;

    /* renamed from: g  reason: collision with root package name */
    public String f52424g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52425h;
    public int r;
    public int s;
    public int t;
    public int u;
    public View.OnClickListener x;
    public boolean y;

    /* renamed from: a  reason: collision with root package name */
    public Handler f52418a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.g.c f52419b = null;

    /* renamed from: i  reason: collision with root package name */
    public int f52426i = R.drawable.pic_sign_tip;
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
    public int H = 0;
    public boolean I = false;
    public Runnable J = new a();
    public Runnable K = new b();

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: d.a.n0.d0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1236a implements d.a.c.e.g.b {
            public C1236a() {
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
                TextView textView = new TextView(e.this.f52420c.getPageActivity());
                textView.setText(e.this.f52423f);
                if (e.this.G != 0) {
                    textView.setGravity(e.this.G);
                } else {
                    textView.setGravity(17);
                }
                if (e.this.E != 0) {
                    SkinManager.setViewTextColor(textView, e.this.E);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                }
                if (e.this.F != 0) {
                    textView.setTextSize(0, e.this.F);
                } else {
                    textView.setTextSize(0, e.this.f52420c.getResources().getDimensionPixelSize(R.dimen.fontsize28));
                }
                if (e.this.B != 0) {
                    textView.setHeight(e.this.B);
                } else {
                    textView.setHeight(e.this.f52420c.getResources().getDimensionPixelSize(R.dimen.ds76));
                }
                if (e.this.C != 0) {
                    textView.setWidth(e.this.C);
                }
                textView.setPadding(e.this.r, e.this.s, e.this.t, e.this.u);
                textView.setLines(e.this.A);
                if (e.this.D) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                if (e.this.H != 0) {
                    if (e.this.I) {
                        if (e.this.E != 0) {
                            i2 = e.this.E;
                        } else {
                            i2 = R.color.CAM_X0101;
                        }
                        drawable = WebPManager.getPureDrawable(e.this.H, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(e.this.H);
                    }
                    int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g2, g2);
                    textView.setCompoundDrawablePadding(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                SkinManager.setBackgroundResource(textView, e.this.f52426i);
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
            if (e.this.f52419b == null && !StringUtils.isNull(e.this.f52423f)) {
                if (!e.this.y || e.this.H()) {
                    d.a.c.e.g.d dVar = new d.a.c.e.g.d();
                    dVar.j(e.this.f52421d);
                    dVar.c(0);
                    dVar.i(true);
                    dVar.h(true);
                    dVar.a(new C1236a());
                    e.this.f52419b = dVar.b();
                    e.this.f52419b.k(false);
                    e.this.f52419b.l(e.this.z);
                    e.this.f52419b.n(e.this.f52420c.getPageActivity(), e.this.o);
                    e.this.f52422e = true;
                    e.this.K();
                    e.this.f52425h = true;
                    e.this.f52418a.postDelayed(e.this.K, e.this.n);
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
            e.this.I();
        }
    }

    public e(TbPageContext tbPageContext, View view) {
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.f52420c = tbPageContext;
        this.f52421d = view;
        this.r = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.s = this.f52420c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.t = this.f52420c.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.u = this.f52420c.getResources().getDimensionPixelSize(R.dimen.ds10);
    }

    public boolean H() {
        View view = this.f52421d;
        return view != null && view.getVisibility() == 0 && ((double) this.f52421d.getAlpha()) >= 0.4d;
    }

    public void I() {
        d.a.c.e.g.c cVar = this.f52419b;
        if (cVar != null) {
            cVar.d();
            this.f52419b = null;
        }
        Handler handler = this.f52418a;
        if (handler != null) {
            handler.removeCallbacks(this.J);
            this.f52418a.removeCallbacks(this.K);
        }
        this.f52425h = false;
    }

    public boolean J() {
        return this.f52425h;
    }

    public final void K() {
        if (this.k) {
            return;
        }
        d.a.m0.r.d0.b.j().v(this.f52424g, this.j + 1);
    }

    public void L(int i2) {
        this.w = i2;
    }

    public void M(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void N(int i2) {
        if (i2 > 0) {
            this.n = i2;
        }
    }

    public void O(int i2) {
        this.v = i2;
    }

    public void P(@DimenRes int i2) {
        this.B = this.f52420c.getResources().getDimensionPixelSize(i2);
    }

    public void Q(boolean z) {
        this.D = z;
    }

    public void R(boolean z) {
        this.I = z;
    }

    public void S(int i2) {
        this.A = i2;
    }

    public void T(int i2) {
        if (i2 > 0) {
            this.l = i2;
        }
    }

    public void U(boolean z) {
        this.y = z;
    }

    public void V(boolean z) {
        this.o = z;
    }

    public void W(int i2) {
        if (i2 > 0) {
            this.m = i2;
        }
    }

    public void X(@ColorRes int i2) {
        this.E = i2;
    }

    public void Y(int i2) {
        this.H = i2;
    }

    public void Z(int i2, int i3, int i4, int i5) {
        this.r = i2;
        this.s = i3;
        this.t = i4;
        this.u = i5;
    }

    public void a0(int i2) {
        this.u = i2;
    }

    public void b0(int i2) {
        this.r = i2;
    }

    public void c0(int i2) {
        this.t = i2;
    }

    public void d0(int i2) {
        this.s = i2;
    }

    public void e0(@DimenRes int i2) {
        this.F = this.f52420c.getResources().getDimensionPixelSize(i2);
    }

    public void f0(int i2) {
        this.G = i2;
    }

    public void g0(int i2) {
        if (i2 > 0) {
            this.f52426i = i2;
        }
    }

    public void h0(boolean z) {
        this.z = z;
    }

    public void i0(@DimenRes int i2) {
        this.C = this.f52420c.getResources().getDimensionPixelSize(i2);
    }

    public void j0(int i2) {
        this.p = i2;
    }

    public void k0(int i2) {
        this.q = i2;
    }

    public void l0(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f52423f = str;
        if (this.f52418a == null) {
            this.f52418a = new Handler();
        }
        this.f52418a.postDelayed(this.J, this.m);
    }

    public void m0(String str, String str2) {
        n0(str, str2, false);
    }

    public boolean n0(String str, String str2, boolean z) {
        return o0(str, str2, z, false);
    }

    public boolean o0(String str, String str2, boolean z, boolean z2) {
        View view;
        if (this.f52422e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view = this.f52421d) == null || view.getVisibility() != 0) {
            return false;
        }
        this.f52423f = str;
        this.f52424g = str2;
        this.k = z2;
        int k = d.a.m0.r.d0.b.j().k(str2, 0);
        this.j = k;
        if (k < this.l || this.k) {
            if (z) {
                K();
                this.f52422e = true;
            }
            if (this.f52418a == null) {
                this.f52418a = new Handler();
            }
            this.f52418a.postDelayed(this.J, this.m);
            return true;
        }
        return false;
    }
}
