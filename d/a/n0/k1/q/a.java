package d.a.n0.k1.q;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.SlidingTabLayout;
import d.a.c.e.m.d;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f56763a;

    /* renamed from: b  reason: collision with root package name */
    public View f56764b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56765c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f56766d;

    /* renamed from: e  reason: collision with root package name */
    public Context f56767e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f56768f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56769g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56770h = true;

    /* renamed from: i  reason: collision with root package name */
    public d f56771i = new C1413a();

    /* renamed from: d.a.n0.k1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1413a extends d {
        public C1413a() {
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f56765c == null) {
                return;
            }
            if (animation == a.this.f56768f) {
                a.this.f56765c.setVisibility(0);
                a.this.f56765c.setClickable(true);
            } else if (animation == a.this.f56769g) {
                a.this.f56765c.setVisibility(8);
                a.this.f56765c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f56764b = view;
        this.f56767e = context;
        this.f56765c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f56763a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f56766d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f56770h = true;
        TextView textView = this.f56765c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56765c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f56763a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f56768f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56767e, R.anim.fade_in);
            this.f56768f = loadAnimation;
            loadAnimation.setAnimationListener(this.f56771i);
        }
        return this.f56768f;
    }

    public final Animation f() {
        if (this.f56769g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56767e, R.anim.fade_out);
            this.f56769g = loadAnimation;
            loadAnimation.setAnimationListener(this.f56771i);
        }
        return this.f56769g;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f56764b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f56765c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f56765c, R.color.CAM_X0106, 1);
        if (this.f56770h) {
            SkinManager.setImageResource(this.f56763a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f56763a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f56763a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f56766d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f56763a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout = this.f56766d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i2);
        }
    }

    public void j() {
        this.f56770h = false;
        TextView textView = this.f56765c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56765c.setVisibility(0);
            this.f56765c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f56763a, R.drawable.lego_icon_triangle_up_normal);
    }
}
