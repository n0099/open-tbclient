package d.a.o0.k1.q;

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
    public ImageView f60577a;

    /* renamed from: b  reason: collision with root package name */
    public View f60578b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60579c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f60580d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60581e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f60582f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f60583g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60584h = true;

    /* renamed from: i  reason: collision with root package name */
    public d f60585i = new C1473a();

    /* renamed from: d.a.o0.k1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1473a extends d {
        public C1473a() {
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f60579c == null) {
                return;
            }
            if (animation == a.this.f60582f) {
                a.this.f60579c.setVisibility(0);
                a.this.f60579c.setClickable(true);
            } else if (animation == a.this.f60583g) {
                a.this.f60579c.setVisibility(8);
                a.this.f60579c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f60578b = view;
        this.f60581e = context;
        this.f60579c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f60577a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f60580d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f60584h = true;
        TextView textView = this.f60579c;
        if (textView != null) {
            textView.clearAnimation();
            this.f60579c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f60577a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f60582f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f60581e, R.anim.fade_in);
            this.f60582f = loadAnimation;
            loadAnimation.setAnimationListener(this.f60585i);
        }
        return this.f60582f;
    }

    public final Animation f() {
        if (this.f60583g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f60581e, R.anim.fade_out);
            this.f60583g = loadAnimation;
            loadAnimation.setAnimationListener(this.f60585i);
        }
        return this.f60583g;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f60578b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f60579c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f60579c, R.color.CAM_X0106, 1);
        if (this.f60584h) {
            SkinManager.setImageResource(this.f60577a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f60577a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f60577a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f60580d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f60577a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout = this.f60580d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i2);
        }
    }

    public void j() {
        this.f60584h = false;
        TextView textView = this.f60579c;
        if (textView != null) {
            textView.clearAnimation();
            this.f60579c.setVisibility(0);
            this.f60579c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f60577a, R.drawable.lego_icon_triangle_up_normal);
    }
}
