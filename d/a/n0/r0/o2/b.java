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
    public FrsFragment f59204a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f59205b;

    /* renamed from: d  reason: collision with root package name */
    public Animation f59207d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f59208e;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59211h;

    /* renamed from: i  reason: collision with root package name */
    public EntelechyPullUpRefreshView f59212i;
    public EntelechyPullUpRefreshView j;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f59206c = null;

    /* renamed from: f  reason: collision with root package name */
    public int f59209f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59210g = false;
    public boolean k = true;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f59204a == null) {
                return;
            }
            if (view == b.this.f59212i) {
                TiebaStatic.eventStat(b.this.f59204a.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
                if (b.this.f59204a.t2() || b.this.f59204a.y0() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c11752").param("fid", b.this.f59204a.F()).param("obj_locate", "3"));
                b.this.f59204a.y0().K1();
            } else if (view != b.this.j || b.this.f59204a.y0() == null || b.this.f59204a.y0().Z() == null) {
            } else {
                b.this.f59204a.y0().Z().smoothScrollToPosition(0);
            }
        }
    }

    /* renamed from: d.a.n0.r0.o2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1528b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f59214a;

        public animation.Animation$AnimationListenerC1528b(View view) {
            this.f59214a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f59214a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f59214a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f59214a;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public View f59215a;

        public c(View view) {
            this.f59215a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f59215a;
            if (view == null || view.getAnimation() != animation) {
                return;
            }
            this.f59215a.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = this.f59215a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public b(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f59211h = null;
        this.f59212i = null;
        this.j = null;
        this.f59204a = frsFragment;
        this.f59205b = noPressedRelativeLayout;
        i();
        this.f59211h = (LinearLayout) this.f59205b.findViewById(R.id.frs_stick_bottom_holder);
        this.j = (EntelechyPullUpRefreshView) this.f59205b.findViewById(R.id.frs_stick_bottom_goto_top);
        this.f59212i = (EntelechyPullUpRefreshView) this.f59205b.findViewById(R.id.frs_stick_bottom_reload);
        this.j.setOnClickListener(this.l);
        this.f59212i.setOnClickListener(this.l);
        onChangeSkinType(this.f59209f);
    }

    @Override // d.a.n0.r0.n1.e.c
    public void a(boolean z) {
        this.f59210g = z;
        if (this.f59212i != null) {
            if (z) {
                LinearLayout linearLayout = this.f59211h;
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
        if (this.f59210g) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                m();
            } else {
                this.f59211h.setVisibility(0);
            }
        } else if (z2) {
            l();
        } else {
            this.f59211h.setVisibility(8);
        }
    }

    @Override // d.a.n0.r0.n1.e.c
    public boolean c() {
        if (this.f59212i == null) {
            return false;
        }
        return this.k;
    }

    @Override // d.a.n0.r0.k2.c
    public void d() {
        TbImageView tbImageView = this.f59206c;
        if (tbImageView == null) {
            return;
        }
        tbImageView.clearAnimation();
        this.f59206c.setImageDrawable(null);
        this.f59206c.setVisibility(8);
    }

    public final void h() {
        LinearLayout linearLayout = this.f59211h;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
        }
    }

    public final void i() {
        this.f59206c = new TbImageView(this.f59204a.getPageContext().getPageActivity());
        int g2 = d.a.c.e.p.l.g(this.f59204a.getPageContext().getPageActivity(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = g2;
        this.f59206c.setLayoutParams(layoutParams);
        this.f59205b.addView(this.f59206c);
        this.f59206c.setVisibility(8);
    }

    public final void j() {
        if (this.f59204a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f59204a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_out);
            this.f59207d = loadAnimation;
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1528b(this.f59211h));
        }
    }

    public final void k() {
        if (this.f59204a.isAdded()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f59204a.getPageContext().getPageActivity(), R.anim.frs_pull_up_refresh_in);
            this.f59208e = loadAnimation;
            loadAnimation.setAnimationListener(new c(this.f59211h));
        }
    }

    public final void l() {
        h();
        if (this.f59207d == null) {
            j();
        }
        Animation animation = this.f59207d;
        if (animation == null) {
            return;
        }
        this.f59211h.startAnimation(animation);
    }

    public final void m() {
        h();
        if (this.f59208e == null) {
            k();
        }
        if (this.f59208e == null) {
            return;
        }
        this.f59211h.setVisibility(0);
        this.f59211h.startAnimation(this.f59208e);
    }

    @Override // d.a.n0.r0.n1.e.c
    public void onChangeSkinType(int i2) {
        if (this.f59209f != i2) {
            EntelechyPullUpRefreshView entelechyPullUpRefreshView = this.f59212i;
            if (entelechyPullUpRefreshView != null) {
                entelechyPullUpRefreshView.b(i2);
            }
            EntelechyPullUpRefreshView entelechyPullUpRefreshView2 = this.j;
            if (entelechyPullUpRefreshView2 != null) {
                entelechyPullUpRefreshView2.b(i2);
            }
            this.f59209f = i2;
        }
    }
}
