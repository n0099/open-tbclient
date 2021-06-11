package d.a.n0.r0.o2;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* loaded from: classes4.dex */
public class b implements d.a.n0.r0.n1.e.c, d.a.n0.r0.k2.c {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f62895a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f62896b;

    /* renamed from: d  reason: collision with root package name */
    public Animation f62898d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f62899e;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f62902h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f62903i;
    public EntelechyPullUpRefreshView j;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f62897c = null;

    /* renamed from: f  reason: collision with root package name */
    public int f62900f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62901g = false;
    public boolean k = true;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f62895a == null) {
                return;
            }
            if (view == b.this.f62903i) {
                TiebaStatic.eventStat(b.this.f62895a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (b.this.f62895a.w2() || b.this.f62895a.B0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", b.this.f62895a.G()).param("obj_locate", "3"));
                b.this.f62895a.B0().K1();
            } else if (view != b.this.j || b.this.f62895a.B0() == null || b.this.f62895a.B0().Z() == null) {
            } else {
                b.this.f62895a.B0().Z().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.a.n0.r0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1584b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f62905a;

        public animation.Animation$AnimationListenerC1584b(View view) {
            this.f62905a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f62905a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f62905a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f62905a;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f62906a;

        public c(View view) {
            this.f62906a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f62906a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f62906a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f62906a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f62902h = null;
        this.f62903i = null;
        this.j = null;
        this.f62895a = frsFragment;
        this.f62896b = noPressedRelativeLayout;
        i();
        this.f62902h = (LinearLayout) this.f62896b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f62896b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f62903i = (EntelechyPullUpRefreshView) this.f62896b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f62903i.setOnClickListener(this.l);
        onChangeSkinType(this.f62900f);
    }

    @Override // d.a.n0.r0.n1.e.c
    public void a(boolean z) {
        this.f62901g = z;
        if (this.f62903i != null) {
            if (z) {
                LinearLayout linearLayout = this.f62902h;
                if (linearLayout == null || linearLayout.getVisibility() != 0) {
                    return;
                }
                l();
                return;
            }
            m();
        }
    }

    @Override // d.a.n0.r0.n1.e.c
    public void b(boolean z, boolean z2) {
        if (this.f62901g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f62902h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f62902h.setVisibility(8);
        }
    }

    @Override // d.a.n0.r0.n1.e.c
    public boolean c() {
        if (this.f62903i == null) {
            return false;
        }
        return this.k;
    }

    @Override // d.a.n0.r0.k2.c
    public void d() {
        TbImageView tbImageView = this.f62897c;
        if (tbImageView == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f62897c.setImageDrawable(null);
        this.f62897c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout = this.f62902h;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
        }
    }

    public final void i() {
        this.f62897c = new TbImageView(this.f62895a.getPageContext().getPageActivity());
        int g2 = d.a.c.e.p.l.g(this.f62895a.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g2;
        this.f62897c.setLayoutParams(layoutParams);
        this.f62896b.addView(this.f62897c);
        this.f62897c.setVisibility(8);
    }

    public final void j() {
        if (this.f62895a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f62895a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f62898d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1584b(this.f62902h));
        }
    }

    public final void k() {
        if (this.f62895a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f62895a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f62899e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f62902h));
        }
    }

    public final void l() {
        h();
        if (this.f62898d == null) {
            j();
        }
        Animation animation = this.f62898d;
        if (animation == null) {
            return;
        }
        this.f62902h.startAnimation(animation);
    }

    public final void m() {
        h();
        if (this.f62899e == null) {
            k();
        }
        if (this.f62899e == null) {
            return;
        }
        this.f62902h.setVisibility(0);
        this.f62902h.startAnimation(this.f62899e);
    }

    @Override // d.a.n0.r0.n1.e.c
    public void onChangeSkinType(int i2) {
        if (this.f62900f != i2) {
            EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f62903i;
            if (entelechyPullUpRefreshView != null) {
                entelechyPullUpRefreshView.b(i2);
            }
            EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
            if (entelechyPullUpRefreshView2 != null) {
                entelechyPullUpRefreshView2.b(i2);
            }
            this.f62900f = i2;
        }
    }
}
