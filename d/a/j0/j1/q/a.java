package d.a.j0.j1.q;

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
    public ImageView f55876a;

    /* renamed from: b  reason: collision with root package name */
    public View f55877b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55878c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f55879d;

    /* renamed from: e  reason: collision with root package name */
    public Context f55880e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f55881f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f55882g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55883h = true;

    /* renamed from: i  reason: collision with root package name */
    public d f55884i = new C1323a();

    /* renamed from: d.a.j0.j1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1323a extends d {
        public C1323a() {
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f55878c == null) {
                return;
            }
            if (animation == a.this.f55881f) {
                a.this.f55878c.setVisibility(0);
                a.this.f55878c.setClickable(true);
            } else if (animation == a.this.f55882g) {
                a.this.f55878c.setVisibility(8);
                a.this.f55878c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f55877b = view;
        this.f55880e = context;
        this.f55878c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f55876a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f55879d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f55883h = true;
        TextView textView = this.f55878c;
        if (textView != null) {
            textView.clearAnimation();
            this.f55878c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f55876a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f55881f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f55880e, R.anim.fade_in);
            this.f55881f = loadAnimation;
            loadAnimation.setAnimationListener(this.f55884i);
        }
        return this.f55881f;
    }

    public final Animation f() {
        if (this.f55882g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f55880e, R.anim.fade_out);
            this.f55882g = loadAnimation;
            loadAnimation.setAnimationListener(this.f55884i);
        }
        return this.f55882g;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f55877b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f55878c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f55878c, R.color.CAM_X0106, 1);
        if (this.f55883h) {
            SkinManager.setImageResource(this.f55876a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f55876a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f55876a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f55879d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f55876a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout = this.f55879d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i2);
        }
    }

    public void j() {
        this.f55883h = false;
        TextView textView = this.f55878c;
        if (textView != null) {
            textView.clearAnimation();
            this.f55878c.setVisibility(0);
            this.f55878c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f55876a, R.drawable.lego_icon_triangle_up_normal);
    }
}
