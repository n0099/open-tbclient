package d.a.n0.d1.f.f;

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
    public ImageView f52676a;

    /* renamed from: b  reason: collision with root package name */
    public View f52677b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52678c;

    /* renamed from: d  reason: collision with root package name */
    public View f52679d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f52680e;

    /* renamed from: f  reason: collision with root package name */
    public Context f52681f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52682g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52683h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52684i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1244a();

    /* renamed from: d.a.n0.d1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1244a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1244a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f52678c == null) {
                return;
            }
            if (animation == a.this.f52682g) {
                a.this.f52678c.setVisibility(0);
                a.this.f52678c.setClickable(true);
            } else if (animation == a.this.f52683h) {
                a.this.f52678c.setVisibility(8);
                a.this.f52678c.setClickable(false);
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
        this.f52681f = context;
        this.f52677b = view;
        this.f52678c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f52679d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f52676a = imageView;
        imageView.setContentDescription("展开");
        this.f52680e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.f52684i = true;
        TextView textView = this.f52678c;
        if (textView != null) {
            textView.clearAnimation();
            this.f52678c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f52676a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f52676a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f52680e.setDrawBottomLine(true);
        this.f52679d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f52682g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f52681f, R.anim.fade_in);
            this.f52682g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f52682g;
    }

    public final Animation f() {
        if (this.f52683h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f52681f, R.anim.fade_out);
            this.f52683h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f52683h;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f52677b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f52678c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f52678c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f52679d, R.color.CAM_X0204);
        if (this.f52684i) {
            if (1 != i2 && 4 != i2) {
                this.f52676a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f52676a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i2 && 4 != i2) {
            this.f52676a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f52676a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f52680e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f52676a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f52680e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i2) {
        View view = this.f52677b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void k() {
        this.f52684i = false;
        TextView textView = this.f52678c;
        if (textView != null) {
            textView.clearAnimation();
            this.f52678c.setVisibility(0);
            this.f52678c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f52676a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f52676a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f52676a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f52680e.setDrawBottomLine(false);
        this.f52679d.setVisibility(8);
    }
}
