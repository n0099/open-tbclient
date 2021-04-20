package d.b.i0.j1.q;

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
import d.b.c.e.m.d;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f57483a;

    /* renamed from: b  reason: collision with root package name */
    public View f57484b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57485c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f57486d;

    /* renamed from: e  reason: collision with root package name */
    public Context f57487e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f57488f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f57489g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57490h = true;
    public d i = new C1361a();

    /* renamed from: d.b.i0.j1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1361a extends d {
        public C1361a() {
        }

        @Override // d.b.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f57485c == null) {
                return;
            }
            if (animation == a.this.f57488f) {
                a.this.f57485c.setVisibility(0);
                a.this.f57485c.setClickable(true);
            } else if (animation == a.this.f57489g) {
                a.this.f57485c.setVisibility(8);
                a.this.f57485c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f57484b = view;
        this.f57487e = context;
        this.f57485c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f57483a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f57486d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f57490h = true;
        TextView textView = this.f57485c;
        if (textView != null) {
            textView.clearAnimation();
            this.f57485c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f57483a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f57488f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f57487e, R.anim.fade_in);
            this.f57488f = loadAnimation;
            loadAnimation.setAnimationListener(this.i);
        }
        return this.f57488f;
    }

    public final Animation f() {
        if (this.f57489g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f57487e, R.anim.fade_out);
            this.f57489g = loadAnimation;
            loadAnimation.setAnimationListener(this.i);
        }
        return this.f57489g;
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f57484b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f57485c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f57485c, R.color.CAM_X0106, 1);
        if (this.f57490h) {
            SkinManager.setImageResource(this.f57483a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f57483a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f57483a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f57486d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f57483a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i) {
        SlidingTabLayout slidingTabLayout = this.f57486d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i);
        }
    }

    public void j() {
        this.f57490h = false;
        TextView textView = this.f57485c;
        if (textView != null) {
            textView.clearAnimation();
            this.f57485c.setVisibility(0);
            this.f57485c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f57483a, R.drawable.lego_icon_triangle_up_normal);
    }
}
