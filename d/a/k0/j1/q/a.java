package d.a.k0.j1.q;

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
    public ImageView f56583a;

    /* renamed from: b  reason: collision with root package name */
    public View f56584b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56585c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f56586d;

    /* renamed from: e  reason: collision with root package name */
    public Context f56587e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f56588f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56589g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56590h = true;

    /* renamed from: i  reason: collision with root package name */
    public d f56591i = new C1395a();

    /* renamed from: d.a.k0.j1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1395a extends d {
        public C1395a() {
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f56585c == null) {
                return;
            }
            if (animation == a.this.f56588f) {
                a.this.f56585c.setVisibility(0);
                a.this.f56585c.setClickable(true);
            } else if (animation == a.this.f56589g) {
                a.this.f56585c.setVisibility(8);
                a.this.f56585c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f56584b = view;
        this.f56587e = context;
        this.f56585c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f56583a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f56586d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f56590h = true;
        TextView textView = this.f56585c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56585c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f56583a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f56588f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56587e, R.anim.fade_in);
            this.f56588f = loadAnimation;
            loadAnimation.setAnimationListener(this.f56591i);
        }
        return this.f56588f;
    }

    public final Animation f() {
        if (this.f56589g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56587e, R.anim.fade_out);
            this.f56589g = loadAnimation;
            loadAnimation.setAnimationListener(this.f56591i);
        }
        return this.f56589g;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f56584b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f56585c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f56585c, R.color.CAM_X0106, 1);
        if (this.f56590h) {
            SkinManager.setImageResource(this.f56583a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f56583a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f56583a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f56586d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f56583a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout = this.f56586d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i2);
        }
    }

    public void j() {
        this.f56590h = false;
        TextView textView = this.f56585c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56585c.setVisibility(0);
            this.f56585c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f56583a, R.drawable.lego_icon_triangle_up_normal);
    }
}
