package d.b.i0.b1.f.f;

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
    public ImageView f52204a;

    /* renamed from: b  reason: collision with root package name */
    public View f52205b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52206c;

    /* renamed from: d  reason: collision with root package name */
    public View f52207d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f52208e;

    /* renamed from: f  reason: collision with root package name */
    public Context f52209f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52210g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52211h;
    public boolean i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1133a();

    /* renamed from: d.b.i0.b1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1133a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1133a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f52206c == null) {
                return;
            }
            if (animation == a.this.f52210g) {
                a.this.f52206c.setVisibility(0);
                a.this.f52206c.setClickable(true);
            } else if (animation == a.this.f52211h) {
                a.this.f52206c.setVisibility(8);
                a.this.f52206c.setClickable(false);
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
        this.f52209f = context;
        this.f52205b = view;
        this.f52206c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f52207d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f52204a = imageView;
        imageView.setContentDescription("展开");
        this.f52208e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.i = true;
        TextView textView = this.f52206c;
        if (textView != null) {
            textView.clearAnimation();
            this.f52206c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f52204a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f52204a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f52208e.setDrawBottomLine(true);
        this.f52207d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f52210g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f52209f, R.anim.fade_in);
            this.f52210g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f52210g;
    }

    public final Animation f() {
        if (this.f52211h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f52209f, R.anim.fade_out);
            this.f52211h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f52211h;
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f52205b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f52206c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f52206c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f52207d, R.color.CAM_X0204);
        if (this.i) {
            if (1 != i && 4 != i) {
                this.f52204a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f52204a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i && 4 != i) {
            this.f52204a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f52204a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f52208e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f52204a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f52208e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i) {
        View view = this.f52205b;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void k() {
        this.i = false;
        TextView textView = this.f52206c;
        if (textView != null) {
            textView.clearAnimation();
            this.f52206c.setVisibility(0);
            this.f52206c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f52204a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f52204a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f52204a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f52208e.setDrawBottomLine(false);
        this.f52207d.setVisibility(8);
    }
}
