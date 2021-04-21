package d.b.j0.j1.q;

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
    public ImageView f57904a;

    /* renamed from: b  reason: collision with root package name */
    public View f57905b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57906c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f57907d;

    /* renamed from: e  reason: collision with root package name */
    public Context f57908e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f57909f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f57910g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57911h = true;
    public d i = new C1384a();

    /* renamed from: d.b.j0.j1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1384a extends d {
        public C1384a() {
        }

        @Override // d.b.c.e.m.d
        public void a(Animation animation) {
            if (a.this.f57906c == null) {
                return;
            }
            if (animation == a.this.f57909f) {
                a.this.f57906c.setVisibility(0);
                a.this.f57906c.setClickable(true);
            } else if (animation == a.this.f57910g) {
                a.this.f57906c.setVisibility(8);
                a.this.f57906c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f57905b = view;
        this.f57908e = context;
        this.f57906c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f57904a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f57907d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f57911h = true;
        TextView textView = this.f57906c;
        if (textView != null) {
            textView.clearAnimation();
            this.f57906c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f57904a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f57909f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f57908e, R.anim.fade_in);
            this.f57909f = loadAnimation;
            loadAnimation.setAnimationListener(this.i);
        }
        return this.f57909f;
    }

    public final Animation f() {
        if (this.f57910g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f57908e, R.anim.fade_out);
            this.f57910g = loadAnimation;
            loadAnimation.setAnimationListener(this.i);
        }
        return this.f57910g;
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f57905b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f57906c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f57906c, R.color.CAM_X0106, 1);
        if (this.f57911h) {
            SkinManager.setImageResource(this.f57904a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f57904a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f57904a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f57907d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f57904a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i) {
        SlidingTabLayout slidingTabLayout = this.f57907d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i);
        }
    }

    public void j() {
        this.f57911h = false;
        TextView textView = this.f57906c;
        if (textView != null) {
            textView.clearAnimation();
            this.f57906c.setVisibility(0);
            this.f57906c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f57904a, R.drawable.lego_icon_triangle_up_normal);
    }
}
