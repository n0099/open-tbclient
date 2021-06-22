package d.a.o0.r0.o2;

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
public class b implements d.a.o0.r0.n1.e.c, d.a.o0.r0.k2.c {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f63020a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f63021b;

    /* renamed from: d  reason: collision with root package name */
    public Animation f63023d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f63024e;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f63027h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f63028i;
    public EntelechyPullUpRefreshView j;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f63022c = null;

    /* renamed from: f  reason: collision with root package name */
    public int f63025f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63026g = false;
    public boolean k = true;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f63020a == null) {
                return;
            }
            if (view == b.this.f63028i) {
                TiebaStatic.eventStat(b.this.f63020a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (b.this.f63020a.w2() || b.this.f63020a.B0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", b.this.f63020a.G()).param("obj_locate", "3"));
                b.this.f63020a.B0().K1();
            } else if (view != b.this.j || b.this.f63020a.B0() == null || b.this.f63020a.B0().Z() == null) {
            } else {
                b.this.f63020a.B0().Z().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.a.o0.r0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1588b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f63030a;

        public animation.Animation$AnimationListenerC1588b(View view) {
            this.f63030a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f63030a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f63030a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f63030a;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f63031a;

        public c(View view) {
            this.f63031a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f63031a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f63031a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f63031a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f63027h = null;
        this.f63028i = null;
        this.j = null;
        this.f63020a = frsFragment;
        this.f63021b = noPressedRelativeLayout;
        i();
        this.f63027h = (LinearLayout) this.f63021b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f63021b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f63028i = (EntelechyPullUpRefreshView) this.f63021b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f63028i.setOnClickListener(this.l);
        onChangeSkinType(this.f63025f);
    }

    @Override // d.a.o0.r0.n1.e.c
    public void a(boolean z) {
        this.f63026g = z;
        if (this.f63028i != null) {
            if (z) {
                LinearLayout linearLayout = this.f63027h;
                if (linearLayout == null || linearLayout.getVisibility() != 0) {
                    return;
                }
                l();
                return;
            }
            m();
        }
    }

    @Override // d.a.o0.r0.n1.e.c
    public void b(boolean z, boolean z2) {
        if (this.f63026g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f63027h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f63027h.setVisibility(8);
        }
    }

    @Override // d.a.o0.r0.n1.e.c
    public boolean c() {
        if (this.f63028i == null) {
            return false;
        }
        return this.k;
    }

    @Override // d.a.o0.r0.k2.c
    public void d() {
        TbImageView tbImageView = this.f63022c;
        if (tbImageView == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f63022c.setImageDrawable(null);
        this.f63022c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout = this.f63027h;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
        }
    }

    public final void i() {
        this.f63022c = new TbImageView(this.f63020a.getPageContext().getPageActivity());
        int g2 = d.a.c.e.p.l.g(this.f63020a.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g2;
        this.f63022c.setLayoutParams(layoutParams);
        this.f63021b.addView(this.f63022c);
        this.f63022c.setVisibility(8);
    }

    public final void j() {
        if (this.f63020a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f63020a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f63023d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1588b(this.f63027h));
        }
    }

    public final void k() {
        if (this.f63020a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f63020a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f63024e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f63027h));
        }
    }

    public final void l() {
        h();
        if (this.f63023d == null) {
            j();
        }
        Animation animation = this.f63023d;
        if (animation == null) {
            return;
        }
        this.f63027h.startAnimation(animation);
    }

    public final void m() {
        h();
        if (this.f63024e == null) {
            k();
        }
        if (this.f63024e == null) {
            return;
        }
        this.f63027h.setVisibility(0);
        this.f63027h.startAnimation(this.f63024e);
    }

    @Override // d.a.o0.r0.n1.e.c
    public void onChangeSkinType(int i2) {
        if (this.f63025f != i2) {
            EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f63028i;
            if (entelechyPullUpRefreshView != null) {
                entelechyPullUpRefreshView.b(i2);
            }
            EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
            if (entelechyPullUpRefreshView2 != null) {
                entelechyPullUpRefreshView2.b(i2);
            }
            this.f63025f = i2;
        }
    }
}
