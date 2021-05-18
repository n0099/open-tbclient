package d.a.k0.q0.r2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.j.e.w;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.k;
import d.a.k0.q0.o2.f;
import d.a.k0.q0.o2.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import tbclient.SignActivityInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class b {
    public static HashMap<Integer, String> m0 = new HashMap<>();
    public static HashSet<Integer> n0 = new HashSet<>();
    public FrsTopView A;
    public View B;
    public View C;
    public EMTextView D;
    public boolean E;
    public SignActivityInfo F;
    public PopupWindow G;
    public View H;
    public TextView I;
    public TextView J;
    public ImageView K;
    public PopupWindow L;
    public BarImageView M;
    public UserIconBox N;
    public ArrayList<k> O;
    public g P;
    public f Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public FrsViewData V;
    public a2 W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59411a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f59412b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public Handler f59413c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f59414d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59415e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59416f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59417g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f59418h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f59419i;
    public boolean i0;
    public TextView j;
    public float j0;
    public ImageView k;
    public ImageView l;
    public View m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public RelativeLayout q;
    public View r;
    public TextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public LinearGradientView v;
    public TbImageView w;
    public ServiceAreaView x;
    public FrameLayout y;
    public d.a.k0.q0.h1.g z;
    public boolean k0 = false;
    public final Runnable l0 = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow = b.this.G;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            b bVar = b.this;
            if (bVar.f0) {
                return;
            }
            d.a.c.e.m.g.d(bVar.G, bVar.f59411a.getPageActivity());
        }
    }

    /* renamed from: d.a.k0.q0.r2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1534b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f59421e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f59422f;

        /* renamed from: d.a.k0.q0.r2.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1534b c1534b = C1534b.this;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c1534b.f59421e, "scaleX", 0.0f, c1534b.f59422f);
                ofFloat.setDuration(300L);
                ofFloat.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public C1534b(b bVar, View view, float f2) {
            this.f59421e = view;
            this.f59422f = f2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = new a();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f59421e, "scaleX", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addListener(aVar);
            ofFloat.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    static {
        m0.put(1, "c0117");
        m0.put(2, "c0124");
        m0.put(3, "c0125");
        m0.put(4, "c0126");
        m0.put(5, "c0127");
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(ForumData forumData, FrsViewData frsViewData);

    public void C(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.b0));
        String string = this.f59411a.getString(R.string.experience_divider);
        String string2 = this.f59411a.getString(R.string.member_count_unit);
        int i2 = this.c0;
        if (i2 >= 10000) {
            if (i2 % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.c0 / 10000) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(i2 / 10000.0f) + string2);
            return;
        }
        textView2.setText(string + String.valueOf(this.c0));
    }

    public void D(int i2) {
        if (i2 == 0) {
            this.e0 = false;
            this.k0 = false;
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.f59418h.setVisibility(0);
            this.f59419i.setVisibility(8);
            return;
        }
        this.e0 = true;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.f59418h.setVisibility(8);
        this.f59419i.setVisibility(0);
    }

    public void E(int i2, String str, int i3, float f2, boolean z) {
        this.T = str;
        this.X = i3;
        if (i2 == 0) {
            this.e0 = false;
            this.k0 = false;
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.f59418h.setVisibility(0);
            this.f59419i.setVisibility(8);
            return;
        }
        this.e0 = true;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.f59418h.setVisibility(8);
        this.f59419i.setVisibility(0);
        if (!z || this.k0) {
            return;
        }
        Q();
        this.k0 = true;
    }

    public void F(int i2) {
        if (i2 == 0) {
            this.g0 = false;
            this.f59419i.setText(this.f59411a.getString(R.string.sign));
            z();
            return;
        }
        this.g0 = true;
        this.f59419i.setText(this.f59411a.getString(R.string.signed));
        y();
    }

    public void G(SignData signData) {
        if (signData != null) {
            F(signData.is_signed);
            if (signData.forum_rank == -2) {
                a(false);
                return;
            }
            a(true);
            F(signData.is_signed);
        }
    }

    public void H(boolean z) {
    }

    public void I(f fVar) {
        if (fVar != null) {
            this.Q = fVar;
            fVar.j(this.f59418h);
        }
    }

    public void J(int i2) {
        this.d0 = i2;
    }

    public void K(g gVar) {
        if (gVar != null) {
            this.P = gVar;
            gVar.i(this.f59419i);
        }
    }

    public void L(w wVar) {
    }

    public abstract void M(View view, boolean z);

    public abstract void N();

    public abstract void O();

    public void P(View view, float f2, float f3) {
        view.setPivotX(0.0f);
        C1534b c1534b = new C1534b(this, view, f3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addListener(c1534b);
        ofFloat.start();
    }

    public abstract void Q();

    public void R(View view, float f2, float f3) {
        if (f2 == f3) {
            return;
        }
        view.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, f3);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void S();

    public void a(boolean z) {
        g gVar = this.P;
        if (gVar != null) {
            gVar.j(z);
        }
    }

    public abstract void b();

    public abstract void c(int i2);

    public abstract String d();

    public BarImageView e() {
        return this.M;
    }

    public TextView f() {
        return this.f59417g;
    }

    public View g() {
        return this.m;
    }

    public boolean h() {
        return this.g0;
    }

    public TextView i() {
        return this.n;
    }

    public abstract SignActivityInfo j();

    public View k() {
        return this.f59414d;
    }

    public boolean l() {
        return this.e0;
    }

    public abstract void m();

    public final void n() {
        PopupWindow popupWindow = this.L;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.L.dismiss();
        }
        PopupWindow popupWindow2 = this.G;
        if (popupWindow2 == null || !popupWindow2.isShowing()) {
            return;
        }
        this.G.dismiss();
    }

    public boolean o() {
        return this.h0;
    }

    public abstract boolean p();

    public boolean q() {
        int[] iArr = new int[2];
        try {
            this.K.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public void r() {
        this.f0 = true;
        n0.clear();
    }

    public void s(boolean z) {
        if (z) {
            return;
        }
        n();
        m();
    }

    public void t() {
        n();
        m();
    }

    public void u(float f2) {
        v(false, f2);
    }

    public abstract void v(boolean z, float f2);

    public abstract void w();

    public abstract void x();

    public abstract void y();

    public abstract void z();
}
