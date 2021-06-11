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
    public ImageView f56365a;

    /* renamed from: b  reason: collision with root package name */
    public View f56366b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56367c;

    /* renamed from: d  reason: collision with root package name */
    public View f56368d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f56369e;

    /* renamed from: f  reason: collision with root package name */
    public Context f56370f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56371g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f56372h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56373i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1300a();

    /* renamed from: d.a.n0.d1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1300a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1300a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f56367c == null) {
                return;
            }
            if (animation == a.this.f56371g) {
                a.this.f56367c.setVisibility(0);
                a.this.f56367c.setClickable(true);
            } else if (animation == a.this.f56372h) {
                a.this.f56367c.setVisibility(8);
                a.this.f56367c.setClickable(false);
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
        this.f56370f = context;
        this.f56366b = view;
        this.f56367c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f56368d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f56365a = imageView;
        imageView.setContentDescription("展开");
        this.f56369e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.f56373i = true;
        TextView textView = this.f56367c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56367c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f56365a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f56365a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f56369e.setDrawBottomLine(true);
        this.f56368d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f56371g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56370f, R.anim.fade_in);
            this.f56371g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f56371g;
    }

    public final Animation f() {
        if (this.f56372h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56370f, R.anim.fade_out);
            this.f56372h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f56372h;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f56366b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f56367c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f56367c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f56368d, R.color.CAM_X0204);
        if (this.f56373i) {
            if (1 != i2 && 4 != i2) {
                this.f56365a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f56365a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i2 && 4 != i2) {
            this.f56365a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f56365a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f56369e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f56365a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f56369e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i2) {
        View view = this.f56366b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void k() {
        this.f56373i = false;
        TextView textView = this.f56367c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56367c.setVisibility(0);
            this.f56367c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f56365a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f56365a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f56365a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f56369e.setDrawBottomLine(false);
        this.f56368d.setVisibility(8);
    }
}
