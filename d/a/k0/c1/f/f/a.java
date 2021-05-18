package d.a.k0.c1.f.f;

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
    public ImageView f52496a;

    /* renamed from: b  reason: collision with root package name */
    public View f52497b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52498c;

    /* renamed from: d  reason: collision with root package name */
    public View f52499d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f52500e;

    /* renamed from: f  reason: collision with root package name */
    public Context f52501f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52502g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52503h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52504i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1227a();

    /* renamed from: d.a.k0.c1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1227a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1227a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f52498c == null) {
                return;
            }
            if (animation == a.this.f52502g) {
                a.this.f52498c.setVisibility(0);
                a.this.f52498c.setClickable(true);
            } else if (animation == a.this.f52503h) {
                a.this.f52498c.setVisibility(8);
                a.this.f52498c.setClickable(false);
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
        this.f52501f = context;
        this.f52497b = view;
        this.f52498c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f52499d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f52496a = imageView;
        imageView.setContentDescription("展开");
        this.f52500e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.f52504i = true;
        TextView textView = this.f52498c;
        if (textView != null) {
            textView.clearAnimation();
            this.f52498c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f52496a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f52496a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f52500e.setDrawBottomLine(true);
        this.f52499d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f52502g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f52501f, R.anim.fade_in);
            this.f52502g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f52502g;
    }

    public final Animation f() {
        if (this.f52503h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f52501f, R.anim.fade_out);
            this.f52503h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f52503h;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f52497b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f52498c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f52498c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f52499d, R.color.CAM_X0204);
        if (this.f52504i) {
            if (1 != i2 && 4 != i2) {
                this.f52496a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f52496a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i2 && 4 != i2) {
            this.f52496a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f52496a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f52500e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f52496a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f52500e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i2) {
        View view = this.f52497b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void k() {
        this.f52504i = false;
        TextView textView = this.f52498c;
        if (textView != null) {
            textView.clearAnimation();
            this.f52498c.setVisibility(0);
            this.f52498c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f52496a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f52496a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f52496a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f52500e.setDrawBottomLine(false);
        this.f52499d.setVisibility(8);
    }
}
