package d.b.i0.c1.f.f;

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
    public ImageView f53606a;

    /* renamed from: b  reason: collision with root package name */
    public View f53607b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53608c;

    /* renamed from: d  reason: collision with root package name */
    public View f53609d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f53610e;

    /* renamed from: f  reason: collision with root package name */
    public Context f53611f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f53612g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f53613h;
    public boolean i = true;
    public Animation.AnimationListener j = new animation.Animation$AnimationListenerC1193a();

    /* renamed from: d.b.i0.c1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1193a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1193a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.f53608c == null) {
                return;
            }
            if (animation == a.this.f53612g) {
                a.this.f53608c.setVisibility(0);
                a.this.f53608c.setClickable(true);
            } else if (animation == a.this.f53613h) {
                a.this.f53608c.setVisibility(8);
                a.this.f53608c.setClickable(false);
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
        this.f53611f = context;
        this.f53607b = view;
        this.f53608c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f53609d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f53606a = imageView;
        imageView.setContentDescription("展开");
        this.f53610e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        this.i = true;
        TextView textView = this.f53608c;
        if (textView != null) {
            textView.clearAnimation();
            this.f53608c.startAnimation(f());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f53606a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
            this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
        } else {
            this.f53606a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
            this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
        }
        this.f53610e.setDrawBottomLine(true);
        this.f53609d.setVisibility(0);
    }

    public final Animation e() {
        if (this.f53612g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f53611f, R.anim.fade_in);
            this.f53612g = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f53612g;
    }

    public final Animation f() {
        if (this.f53613h == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f53611f, R.anim.fade_out);
            this.f53613h = loadAnimation;
            loadAnimation.setAnimationListener(this.j);
        }
        return this.f53613h;
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f53607b, R.color.common_color_10274);
        SkinManager.setBackgroundColor(this.f53608c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f53608c, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.f53609d, R.color.CAM_X0204);
        if (this.i) {
            if (1 != i && 4 != i) {
                this.f53606a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f53606a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
        } else if (1 != i && 4 != i) {
            this.f53606a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f53606a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        SlidingTabLayout slidingTabLayout = this.f53610e;
        if (slidingTabLayout != null) {
            slidingTabLayout.j(i);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f53606a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout = this.f53610e;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager);
        }
    }

    public void j(int i) {
        View view = this.f53607b;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void k() {
        this.i = false;
        TextView textView = this.f53608c;
        if (textView != null) {
            textView.clearAnimation();
            this.f53608c.setVisibility(0);
            this.f53608c.startAnimation(e());
        }
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f53606a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
            this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
        } else {
            this.f53606a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
            this.f53606a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
        }
        this.f53610e.setDrawBottomLine(false);
        this.f53609d.setVisibility(8);
    }
}
