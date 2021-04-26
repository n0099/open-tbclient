package d.a.j0.c1.f.f;

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
    public ImageView f51797a;

    /* renamed from: b  reason: collision with root package name */
    public View f51798b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51799c;

    /* renamed from: d  reason: collision with root package name */
    public View f51800d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f51801e;

    /* renamed from: f  reason: collision with root package name */
    public Context f51802f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f51803g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f51804h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51805i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1155a();

    /* renamed from: d.a.j0.c1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1155a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1155a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f51799c == null) {
                return;
            }
            if (animation == a.this.f51803g) {
                a.this.f51799c.setVisibility(0);
                a.this.f51799c.setClickable(true);
            } else if (animation == a.this.f51804h) {
                a.this.f51799c.setVisibility(8);
                a.this.f51799c.setClickable(false);
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
        this.f51802f = context;
        this.f51798b = view;
        this.f51799c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f51800d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f51797a = imageView;
        imageView.setContentDescription("展开");
        this.f51801e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.f51805i = true;
        TextView textView = this.f51799c;
        if (textView != null) {
            textView.clearAnimation();
            this.f51799c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f51797a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f51797a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f51801e.setDrawBottomLine(true);
        this.f51800d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f51803g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f51802f, R.anim.fade_in);
            this.f51803g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f51803g;
    }

    public final Animation f() {
        if (this.f51804h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f51802f, R.anim.fade_out);
            this.f51804h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f51804h;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f51798b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f51799c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f51799c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f51800d, R.color.CAM_X0204);
        if (this.f51805i) {
            if (1 != i2 && 4 != i2) {
                this.f51797a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f51797a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i2 && 4 != i2) {
            this.f51797a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f51797a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f51801e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f51797a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f51801e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i2) {
        View view = this.f51798b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void k() {
        this.f51805i = false;
        TextView textView = this.f51799c;
        if (textView != null) {
            textView.clearAnimation();
            this.f51799c.setVisibility(0);
            this.f51799c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f51797a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f51797a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f51797a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f51801e.setDrawBottomLine(false);
        this.f51800d.setVisibility(8);
    }
}
