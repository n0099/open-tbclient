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
    public ImageView f60452a;

    /* renamed from: b  reason: collision with root package name */
    public View f60453b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60454c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f60455d;

    /* renamed from: e  reason: collision with root package name */
    public Context f60456e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f60457f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f60458g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60459h = true;

    /* renamed from: i  reason: collision with root package name */
    public d f60460i = new C1469a();

    /* renamed from: d.a.n0.k1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1469a extends d {
        public C1469a() {
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f60454c == null) {
                return;
            }
            if (animation == a.this.f60457f) {
                a.this.f60454c.setVisibility(0);
                a.this.f60454c.setClickable(true);
            } else if (animation == a.this.f60458g) {
                a.this.f60454c.setVisibility(8);
                a.this.f60454c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f60453b = view;
        this.f60456e = context;
        this.f60454c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f60452a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f60455d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f60459h = true;
        TextView textView = this.f60454c;
        if (textView != null) {
            textView.clearAnimation();
            this.f60454c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f60452a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f60457f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f60456e, R.anim.fade_in);
            this.f60457f = loadAnimation;
            loadAnimation.setAnimationListener(this.f60460i);
        }
        return this.f60457f;
    }

    public final Animation f() {
        if (this.f60458g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f60456e, R.anim.fade_out);
            this.f60458g = loadAnimation;
            loadAnimation.setAnimationListener(this.f60460i);
        }
        return this.f60458g;
    }

    public void g(int i2) {
        SkinManager.setBackgroundColor(this.f60453b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f60454c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f60454c, R.color.CAM_X0106, 1);
        if (this.f60459h) {
            SkinManager.setImageResource(this.f60452a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f60452a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f60452a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f60455d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f60452a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout = this.f60455d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i2);
        }
    }

    public void j() {
        this.f60459h = false;
        TextView textView = this.f60454c;
        if (textView != null) {
            textView.clearAnimation();
            this.f60454c.setVisibility(0);
            this.f60454c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f60452a, R.drawable.lego_icon_triangle_up_normal);
    }
}
