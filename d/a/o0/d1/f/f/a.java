package d.a.o0.d1.f.f;

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
    public ImageView f56490a;

    /* renamed from: b  reason: collision with root package name */
    public View f56491b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56492c;

    /* renamed from: d  reason: collision with root package name */
    public View f56493d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f56494e;

    /* renamed from: f  reason: collision with root package name */
    public Context f56495f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56496g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f56497h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56498i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1304a();

    /* renamed from: d.a.o0.d1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1304a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1304a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f56492c == null) {
                return;
            }
            if (animation == a.this.f56496g) {
                a.this.f56492c.setVisibility(0);
                a.this.f56492c.setClickable(true);
            } else if (animation == a.this.f56497h) {
                a.this.f56492c.setVisibility(8);
                a.this.f56492c.setClickable(false);
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
        this.f56495f = context;
        this.f56491b = view;
        this.f56492c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f56493d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f56490a = imageView;
        imageView.setContentDescription("展开");
        this.f56494e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.f56498i = true;
        TextView textView = this.f56492c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56492c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f56490a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f56490a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f56494e.setDrawBottomLine(true);
        this.f56493d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f56496g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56495f, R.anim.fade_in);
            this.f56496g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f56496g;
    }

    public final Animation f() {
        if (this.f56497h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56495f, R.anim.fade_out);
            this.f56497h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f56497h;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f56491b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f56492c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f56492c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f56493d, R.color.CAM_X0204);
        if (this.f56498i) {
            if (1 != i2 && 4 != i2) {
                this.f56490a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f56490a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i2 && 4 != i2) {
            this.f56490a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f56490a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f56494e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f56490a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f56494e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i2) {
        View view = this.f56491b;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void k() {
        this.f56498i = false;
        TextView textView = this.f56492c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56492c.setVisibility(0);
            this.f56492c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f56490a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f56490a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f56490a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f56494e.setDrawBottomLine(false);
        this.f56493d.setVisibility(8);
    }
}
