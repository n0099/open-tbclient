package d.b.i0.q0.r2;

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
import d.b.c.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.k;
import d.b.i0.q0.o2.f;
import d.b.i0.q0.o2.g;
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
    public TbPageContext f60145a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f60146b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public Handler f60147c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f60148d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60149e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60150f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60151g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f60152h;
    public boolean h0;
    public TBSpecificationBtn i;
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
    public d.b.i0.q0.h1.g z;
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
            d.b.c.e.m.g.d(bVar.G, bVar.f60145a.getPageActivity());
        }
    }

    /* renamed from: d.b.i0.q0.r2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1498b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f60154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f60155f;

        /* renamed from: d.b.i0.q0.r2.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1498b c1498b = C1498b.this;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c1498b.f60154e, "scaleX", 0.0f, c1498b.f60155f);
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

        public C1498b(b bVar, View view, float f2) {
            this.f60154e = view;
            this.f60155f = f2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = new a();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f60154e, "scaleX", 1.0f, 0.0f);
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
        String string = this.f60145a.getString(R.string.experience_divider);
        String string2 = this.f60145a.getString(R.string.member_count_unit);
        int i = this.c0;
        if (i >= 10000) {
            if (i % 10000 == 0) {
                textView2.setText(string + String.valueOf(this.c0 / 10000) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(i / 10000.0f) + string2);
            return;
        }
        textView2.setText(string + String.valueOf(this.c0));
    }

    public void D(int i) {
        if (i == 0) {
            this.e0 = false;
            this.k0 = false;
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.f60152h.setVisibility(0);
            this.i.setVisibility(8);
            return;
        }
        this.e0 = true;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.f60152h.setVisibility(8);
        this.i.setVisibility(0);
    }

    public void E(int i, String str, int i2, float f2, boolean z) {
        this.T = str;
        this.X = i2;
        if (i == 0) {
            this.e0 = false;
            this.k0 = false;
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.f60152h.setVisibility(0);
            this.i.setVisibility(8);
            return;
        }
        this.e0 = true;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.f60152h.setVisibility(8);
        this.i.setVisibility(0);
        if (!z || this.k0) {
            return;
        }
        Q();
        this.k0 = true;
    }

    public void F(int i) {
        if (i == 0) {
            this.g0 = false;
            this.i.setText(this.f60145a.getString(R.string.sign));
            z();
            return;
        }
        this.g0 = true;
        this.i.setText(this.f60145a.getString(R.string.signed));
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
            fVar.j(this.f60152h);
        }
    }

    public void J(int i) {
        this.d0 = i;
    }

    public void K(g gVar) {
        if (gVar != null) {
            this.P = gVar;
            gVar.i(this.i);
        }
    }

    public void L(w wVar) {
    }

    public abstract void M(View view, boolean z);

    public abstract void N();

    public abstract void O();

    public void P(View view, float f2, float f3) {
        view.setPivotX(0.0f);
        C1498b c1498b = new C1498b(this, view, f3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addListener(c1498b);
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

    public abstract void c(int i);

    public abstract String d();

    public BarImageView e() {
        return this.M;
    }

    public TextView f() {
        return this.f60151g;
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
        return this.f60148d;
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
