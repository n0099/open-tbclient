package d.b.i0.q0.o2;

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
public class b implements d.b.i0.q0.n1.e.c, d.b.i0.q0.k2.c {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59815a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f59816b;

    /* renamed from: d  reason: collision with root package name */
    public Animation f59818d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f59819e;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59822h;
    public EntelechyPullUpRefreshView i;
    public EntelechyPullUpRefreshView j;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f59817c = null;

    /* renamed from: f  reason: collision with root package name */
    public int f59820f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59821g = false;
    public boolean k = true;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f59815a == null) {
                return;
            }
            if (view == b.this.i) {
                TiebaStatic.eventStat(b.this.f59815a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (b.this.f59815a.u2() || b.this.f59815a.x0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", b.this.f59815a.V()).param("obj_locate", "3"));
                b.this.f59815a.x0().K1();
            } else if (view != b.this.j || b.this.f59815a.x0() == null || b.this.f59815a.x0().Z() == null) {
            } else {
                b.this.f59815a.x0().Z().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.b.i0.q0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1479b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f59824a;

        public animation.Animation$AnimationListenerC1479b(View view) {
            this.f59824a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f59824a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f59824a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f59824a;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f59825a;

        public c(View view) {
            this.f59825a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f59825a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f59825a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f59825a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f59822h = null;
        this.i = null;
        this.j = null;
        this.f59815a = frsFragment;
        this.f59816b = noPressedRelativeLayout;
        i();
        this.f59822h = (LinearLayout) this.f59816b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f59816b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.i = (EntelechyPullUpRefreshView) this.f59816b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.i.setOnClickListener(this.l);
        onChangeSkinType(this.f59820f);
    }

    @Override // d.b.i0.q0.k2.c
    public void a() {
        TbImageView tbImageView = this.f59817c;
        if (tbImageView == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f59817c.setImageDrawable(null);
        this.f59817c.setVisibility(8);
    }

    @Override // d.b.i0.q0.n1.e.c
    public void b(boolean z) {
        this.f59821g = z;
        if (this.i != null) {
            if (z) {
                LinearLayout linearLayout = this.f59822h;
                if (linearLayout == null || linearLayout.getVisibility() != 0) {
                    return;
                }
                l();
                return;
            }
            m();
        }
    }

    @Override // d.b.i0.q0.n1.e.c
    public void c(boolean z, boolean z2) {
        if (this.f59821g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f59822h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f59822h.setVisibility(8);
        }
    }

    @Override // d.b.i0.q0.n1.e.c
    public boolean d() {
        if (this.i == null) {
            return false;
        }
        return this.k;
    }

    public final void h() {
        LinearLayout linearLayout = this.f59822h;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
        }
    }

    public final void i() {
        this.f59817c = new TbImageView(this.f59815a.getPageContext().getPageActivity());
        int g2 = d.b.c.e.p.l.g(this.f59815a.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g2;
        this.f59817c.setLayoutParams(layoutParams);
        this.f59816b.addView(this.f59817c);
        this.f59817c.setVisibility(8);
    }

    public final void j() {
        if (this.f59815a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f59815a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f59818d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1479b(this.f59822h));
        }
    }

    public final void k() {
        if (this.f59815a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f59815a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f59819e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f59822h));
        }
    }

    public final void l() {
        h();
        if (this.f59818d == null) {
            j();
        }
        Animation animation = this.f59818d;
        if (animation == null) {
            return;
        }
        this.f59822h.startAnimation(animation);
    }

    public final void m() {
        h();
        if (this.f59819e == null) {
            k();
        }
        if (this.f59819e == null) {
            return;
        }
        this.f59822h.setVisibility(0);
        this.f59822h.startAnimation(this.f59819e);
    }

    @Override // d.b.i0.q0.n1.e.c
    public void onChangeSkinType(int i) {
        if (this.f59820f != i) {
            EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.i;
            if (entelechyPullUpRefreshView != null) {
                entelechyPullUpRefreshView.b(i);
            }
            EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
            if (entelechyPullUpRefreshView2 != null) {
                entelechyPullUpRefreshView2.b(i);
            }
            this.f59820f = i;
        }
    }
}
