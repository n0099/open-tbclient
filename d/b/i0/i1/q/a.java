package d.b.i0.i1.q;

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
import d.b.b.e.m.d;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f56035a;

    /* renamed from: b  reason: collision with root package name */
    public View f56036b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56037c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f56038d;

    /* renamed from: e  reason: collision with root package name */
    public Context f56039e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f56040f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56041g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56042h = true;
    public d i = new C1304a();

    /* renamed from: d.b.i0.i1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1304a extends d {
        public C1304a() {
        }

        @Override // d.b.b.e.m.d
        public void a(Animation animation) {
            if (a.this.f56037c == null) {
                return;
            }
            if (animation == a.this.f56040f) {
                a.this.f56037c.setVisibility(0);
                a.this.f56037c.setClickable(true);
            } else if (animation == a.this.f56041g) {
                a.this.f56037c.setVisibility(8);
                a.this.f56037c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        this.f56036b = view;
        this.f56039e = context;
        this.f56037c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f56035a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f56038d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        this.f56042h = true;
        TextView textView = this.f56037c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56037c.startAnimation(f());
        }
        SkinManager.setImageResource(this.f56035a, R.drawable.lego_icon_triangle_down_normal);
    }

    public final Animation e() {
        if (this.f56040f == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56039e, R.anim.fade_in);
            this.f56040f = loadAnimation;
            loadAnimation.setAnimationListener(this.i);
        }
        return this.f56040f;
    }

    public final Animation f() {
        if (this.f56041g == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f56039e, R.anim.fade_out);
            this.f56041g = loadAnimation;
            loadAnimation.setAnimationListener(this.i);
        }
        return this.f56041g;
    }

    public void g(int i) {
        SkinManager.setBackgroundColor(this.f56036b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f56037c, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.f56037c, R.color.CAM_X0106, 1);
        if (this.f56042h) {
            SkinManager.setImageResource(this.f56035a, R.drawable.lego_icon_triangle_down_normal);
        } else {
            SkinManager.setImageResource(this.f56035a, R.drawable.lego_icon_triangle_up_normal);
        }
        SkinManager.setBackgroundResource(this.f56035a, R.drawable.lego_btn_more_selector);
        SlidingTabLayout slidingTabLayout = this.f56038d;
        if (slidingTabLayout != null) {
            slidingTabLayout.onChangeSkinType(i);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView = this.f56035a;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void i(ViewPager viewPager, int i) {
        SlidingTabLayout slidingTabLayout = this.f56038d;
        if (slidingTabLayout != null) {
            slidingTabLayout.setViewPager(viewPager, i);
        }
    }

    public void j() {
        this.f56042h = false;
        TextView textView = this.f56037c;
        if (textView != null) {
            textView.clearAnimation();
            this.f56037c.setVisibility(0);
            this.f56037c.startAnimation(e());
        }
        SkinManager.setImageResource(this.f56035a, R.drawable.lego_icon_triangle_up_normal);
    }
}
