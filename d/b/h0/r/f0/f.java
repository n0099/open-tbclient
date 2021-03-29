package d.b.h0.r.f0;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
/* loaded from: classes3.dex */
public class f extends d.b.b.j.e.c {
    public boolean A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public final Animator.AnimatorListener D;
    public View k;
    public LinearLayout l;
    public ImageView m;
    public g n;
    public InterfaceC1075f o;
    public h p;
    public e q;
    public AnimationDrawable r;
    public ContinuousAnimationView s;
    public int t;
    public boolean u;
    public SmartBubbleAnimatedView v;
    public j w;
    public i x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.B != null) {
                f.this.B.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimationDrawable animationDrawable = f.this.r;
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (f.this.A) {
                return;
            }
            f.this.A = true;
            f.this.s.setSpeed(1.0f);
            f.this.s.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements SmartBubbleAnimatedView.e {
        public d() {
        }

        @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.e
        public void a() {
            if (f.this.w != null) {
                f.this.w.onAnimationEnd();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    /* renamed from: d.b.h0.r.f0.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1075f {
        void a(View view, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f50509a;

        /* renamed from: b  reason: collision with root package name */
        public int f50510b;

        public i(String str, int i) {
            this.f50509a = str;
            this.f50510b = i;
        }

        public int a() {
            return this.f50510b;
        }

        public String b() {
            return this.f50509a;
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(int i);

        void onAnimationEnd();
    }

    public f(Context context) {
        super(context);
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.t = Integer.MIN_VALUE;
        this.u = false;
        this.y = true;
        this.z = true;
        this.A = false;
        this.B = null;
        this.C = new a();
        this.D = new c();
    }

    public void I(int i2) {
        ContinuousAnimationView continuousAnimationView;
        if (L() && this.t != i2 && (continuousAnimationView = this.s) != null && !continuousAnimationView.isAnimating()) {
            this.t = i2;
            SkinManager.setLottieAnimation(this.s, R.raw.lottie_common_pull_refresh);
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.v;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
    }

    public void J() {
        SmartBubbleAnimatedView smartBubbleAnimatedView;
        if (this.l == null || (smartBubbleAnimatedView = this.v) == null || smartBubbleAnimatedView.getParent() == null) {
            return;
        }
        this.l.removeView(this.v);
    }

    public final void K() {
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.v;
        if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
            this.l.removeView(this.v);
        }
        if (L()) {
            ImageView imageView = this.m;
            if (imageView == null || this.s == null) {
                return;
            }
            if (imageView.getVisibility() != 8) {
                this.m.setVisibility(8);
            }
            if (this.s.getVisibility() != 0) {
                this.s.setVisibility(0);
            }
            if (this.s.isAnimating()) {
                this.s.cancelAnimation();
            }
            this.s.setMinAndMaxProgress(0.0f, 1.0f);
            this.s.setFrame(0);
            this.s.setSpeed(1.3f);
            return;
        }
        ImageView imageView2 = this.m;
        if (imageView2 == null || this.s == null) {
            return;
        }
        if (imageView2.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
        if (this.s.getVisibility() != 8) {
            this.s.setVisibility(8);
        }
    }

    public boolean L() {
        return PullViewHelper.getInstance().isShouldShowLoadingView();
    }

    public boolean M() {
        return this.u;
    }

    public final void N() {
        AnimationDrawable animationDrawable;
        if (!L() || (animationDrawable = this.r) == null) {
            return;
        }
        animationDrawable.stop();
        this.r = null;
    }

    public void O(boolean z) {
        this.y = z;
    }

    public void P(int i2) {
        ContinuousAnimationView continuousAnimationView = this.s;
        if (continuousAnimationView != null) {
            SkinManager.setLottieAnimation(continuousAnimationView, i2);
        }
    }

    public void Q(i iVar) {
        this.x = iVar;
    }

    public void R(View.OnClickListener onClickListener) {
        this.B = onClickListener;
    }

    public void S(j jVar) {
        this.w = jVar;
    }

    public boolean T() {
        if (M() && this.y && this.x != null && this.l != null) {
            this.m.setVisibility(8);
            this.s.setVisibility(8);
            if (this.v == null) {
                SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(p());
                this.v = smartBubbleAnimatedView;
                smartBubbleAnimatedView.setExtrusionRemind(true);
            }
            this.v.f16110e = this.x.b();
            this.v.f16111f = this.x.a();
            if (this.v.getParent() != null) {
                this.l.removeView(this.v);
            }
            this.l.addView(this.v);
            this.v.setOnBubbleAnimateListener(new d());
            j jVar = this.w;
            if (jVar != null) {
                jVar.a(this.v.getTipViewHeight());
            }
            this.v.g();
            return true;
        }
        return false;
    }

    public final void U() {
        ContinuousAnimationView continuousAnimationView;
        if (!L() || (continuousAnimationView = this.s) == null) {
            return;
        }
        continuousAnimationView.loop(false);
    }

    public final void V() {
        ContinuousAnimationView continuousAnimationView = this.s;
        if (continuousAnimationView != null) {
            if (continuousAnimationView.isAnimating()) {
                this.s.cancelAnimation();
            }
            this.A = false;
            this.s.loop(true);
            this.s.setMinFrame(27);
            this.s.setRepeatMode(1);
            this.s.removeAllAnimatorListeners();
            this.s.addAnimatorListener(this.D);
            this.s.playAnimation();
        }
    }

    public void a(e eVar) {
        this.q = eVar;
    }

    public void b(g gVar) {
        this.n = gVar;
    }

    public void c(h hVar) {
        this.p = hVar;
    }

    @Override // d.b.b.j.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void f(float f2, float f3) {
        super.f(f2, f3);
        if (L()) {
            this.s.setAlpha(f2);
            this.s.setFrame((int) Math.min(27.0f, ((f2 * 27.0f) * 5.0f) / 3.0f));
        }
    }

    public void g(InterfaceC1075f interfaceC1075f) {
        this.o = interfaceC1075f;
    }

    @Override // d.b.b.j.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        return 600L;
    }

    @Override // d.b.b.j.e.c
    public View n() {
        View inflate = LayoutInflater.from(p()).inflate(R.layout.tb_pull_view, (ViewGroup) null);
        this.k = inflate;
        this.l = (LinearLayout) inflate.findViewById(R.id.pull_root);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.k.findViewById(R.id.continuous_loading_view);
        this.s = continuousAnimationView;
        SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_common_pull_refresh);
        this.s.setOnClickListener(this.C);
        ImageView imageView = (ImageView) this.k.findViewById(R.id.pull_image);
        this.m = imageView;
        imageView.setOnClickListener(this.C);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i2 = this.t;
        if (i2 != Integer.MIN_VALUE) {
            skinType = i2;
        }
        if (!L()) {
            this.r = PullViewHelper.getInstance().getDefaultAnimationDrawable(skinType);
        }
        this.m.setBackgroundDrawable(this.r);
        K();
        return this.k;
    }

    @Override // d.b.b.j.e.c
    public void o(boolean z) {
        this.z = true;
        if (L() && this.s.isAnimating()) {
            this.s.cancelAnimation();
        } else {
            AnimationDrawable animationDrawable = this.r;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
        N();
        InterfaceC1075f interfaceC1075f = this.o;
        if (interfaceC1075f != null) {
            interfaceC1075f.a(this.k, z);
        }
    }

    @Override // d.b.b.j.e.c
    public void u() {
        if (s()) {
            return;
        }
        e eVar = this.q;
        if (eVar != null) {
            eVar.a();
        }
        if (!T()) {
            U();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.s;
        if (continuousAnimationView == null || !continuousAnimationView.isAnimating()) {
            return;
        }
        this.s.cancelAnimation();
    }

    @Override // d.b.b.j.e.c
    public void v(boolean z) {
        if (s()) {
            return;
        }
        g gVar = this.n;
        if (gVar != null && this.z) {
            gVar.onListPullRefresh(z);
        }
        this.z = true;
    }

    @Override // d.b.b.j.e.c
    public void x(boolean z) {
        AnimationDrawable animationDrawable;
        h hVar = this.p;
        if (hVar != null) {
            hVar.a(z);
        }
        K();
        if (L() || (animationDrawable = this.r) == null || this.m == null) {
            return;
        }
        animationDrawable.stop();
        this.m.setBackgroundDrawable(this.r.getFrame(0));
    }

    @Override // d.b.b.j.e.c
    public void y() {
        K();
        if (L()) {
            if (s()) {
                return;
            }
            V();
            return;
        }
        AnimationDrawable animationDrawable = this.r;
        if (animationDrawable == null || this.m == null) {
            return;
        }
        animationDrawable.stop();
        this.m.setBackgroundDrawable(this.r);
        this.m.post(new b());
    }

    @Override // d.b.b.j.e.c
    public void z() {
        AnimationDrawable animationDrawable;
        if (L() || (animationDrawable = this.r) == null || this.m == null) {
            return;
        }
        animationDrawable.stop();
        this.m.setBackgroundDrawable(this.r.getFrame(0));
    }
}
