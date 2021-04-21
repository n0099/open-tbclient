package d.b.j0.c1.f.f;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.indicator.SlidingTabLayout;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f54027a;

    /* renamed from: b  reason: collision with root package name */
    public View f54028b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54029c;

    /* renamed from: d  reason: collision with root package name */
    public View f54030d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f54031e;

    /* renamed from: f  reason: collision with root package name */
    public Context f54032f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f54033g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f54034h;
    public boolean i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1216a();

    /* renamed from: d.b.j0.c1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1216a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1216a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f54029c == null) {
                return;
            }
            if (animation == a.this.f54033g) {
                a.this.f54029c.setVisibility(0);
                a.this.f54029c.setClickable(true);
            } else if (animation == a.this.f54034h) {
                a.this.f54029c.setVisibility(8);
                a.this.f54029c.setClickable(false);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public a(Context context, View view) {
        this.f54032f = context;
        this.f54028b = view;
        this.f54029c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f54030d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f54027a = imageView;
        imageView.setContentDescription("展开");
        this.f54031e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.i = true;
        TextView textView = this.f54029c;
        if (textView != null) {
            textView.clearAnimation();
            this.f54029c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f54027a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f54027a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f54031e.setDrawBottomLine(true);
        this.f54030d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f54033g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f54032f, R.anim.fade_in);
            this.f54033g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f54033g;
    }

    public final Animation f() {
        if (this.f54034h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f54032f, R.anim.fade_out);
            this.f54034h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f54034h;
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f54028b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f54029c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f54029c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f54030d, R.color.CAM_X0204);
        if (this.i) {
            if (1 != i && 4 != i) {
                this.f54027a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f54027a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i && 4 != i) {
            this.f54027a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f54027a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f54031e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f54027a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f54031e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i) {
        View view = this.f54028b;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void k() {
        this.i = false;
        TextView textView = this.f54029c;
        if (textView != null) {
            textView.clearAnimation();
            this.f54029c.setVisibility(0);
            this.f54029c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f54027a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f54027a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f54027a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f54031e.setDrawBottomLine(false);
        this.f54030d.setVisibility(8);
    }
}
