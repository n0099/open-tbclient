package d.b.i0.p0.n2;

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
public class b implements d.b.i0.p0.n1.e.c, d.b.i0.p0.k2.c {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f58118a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f58119b;

    /* renamed from: d  reason: collision with root package name */
    public Animation f58121d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f58122e;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f58125h;
    public EntelechyPullUpRefreshView i;
    public EntelechyPullUpRefreshView j;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f58120c = null;

    /* renamed from: f  reason: collision with root package name */
    public int f58123f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58124g = false;
    public boolean k = true;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f58118a == null) {
                return;
            }
            if (view == b.this.i) {
                TiebaStatic.eventStat(b.this.f58118a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (b.this.f58118a.u2() || b.this.f58118a.x0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", b.this.f58118a.V()).param("obj_locate", "3"));
                b.this.f58118a.x0().K1();
            } else if (view != b.this.j || b.this.f58118a.x0() == null || b.this.f58118a.x0().Z() == null) {
            } else {
                b.this.f58118a.x0().Z().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.b.i0.p0.n2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1412b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f58127a;

        public animation.Animation$AnimationListenerC1412b(View view) {
            this.f58127a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f58127a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f58127a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f58127a;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f58128a;

        public c(View view) {
            this.f58128a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f58128a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f58128a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f58128a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f58125h = null;
        this.i = null;
        this.j = null;
        this.f58118a = frsFragment;
        this.f58119b = noPressedRelativeLayout;
        i();
        this.f58125h = (LinearLayout) this.f58119b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f58119b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.i = (EntelechyPullUpRefreshView) this.f58119b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.i.setOnClickListener(this.l);
        onChangeSkinType(this.f58123f);
    }

    @Override // d.b.i0.p0.k2.c
    public void a() {
        TbImageView tbImageView = this.f58120c;
        if (tbImageView == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f58120c.setImageDrawable(null);
        this.f58120c.setVisibility(8);
    }

    @Override // d.b.i0.p0.n1.e.c
    public void b(boolean z) {
        this.f58124g = z;
        if (this.i != null) {
            if (z) {
                LinearLayout linearLayout = this.f58125h;
                if (linearLayout == null || linearLayout.getVisibility() != 0) {
                    return;
                }
                l();
                return;
            }
            m();
        }
    }

    @Override // d.b.i0.p0.n1.e.c
    public void c(boolean z, boolean z2) {
        if (this.f58124g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f58125h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f58125h.setVisibility(8);
        }
    }

    @Override // d.b.i0.p0.n1.e.c
    public boolean d() {
        if (this.i == null) {
            return false;
        }
        return this.k;
    }

    public final void h() {
        LinearLayout linearLayout = this.f58125h;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
        }
    }

    public final void i() {
        this.f58120c = new TbImageView(this.f58118a.getPageContext().getPageActivity());
        int g2 = d.b.b.e.p.l.g(this.f58118a.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g2;
        this.f58120c.setLayoutParams(layoutParams);
        this.f58119b.addView(this.f58120c);
        this.f58120c.setVisibility(8);
    }

    public final void j() {
        if (this.f58118a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f58118a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f58121d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1412b(this.f58125h));
        }
    }

    public final void k() {
        if (this.f58118a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f58118a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f58122e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f58125h));
        }
    }

    public final void l() {
        h();
        if (this.f58121d == null) {
            j();
        }
        Animation animation = this.f58121d;
        if (animation == null) {
            return;
        }
        this.f58125h.startAnimation(animation);
    }

    public final void m() {
        h();
        if (this.f58122e == null) {
            k();
        }
        if (this.f58122e == null) {
            return;
        }
        this.f58125h.setVisibility(0);
        this.f58125h.startAnimation(this.f58122e);
    }

    @Override // d.b.i0.p0.n1.e.c
    public void onChangeSkinType(int i) {
        if (this.f58123f != i) {
            EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.i;
            if (entelechyPullUpRefreshView != null) {
                entelechyPullUpRefreshView.b(i);
            }
            EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
            if (entelechyPullUpRefreshView2 != null) {
                entelechyPullUpRefreshView2.b(i);
            }
            this.f58123f = i;
        }
    }
}
