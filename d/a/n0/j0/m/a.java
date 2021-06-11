package d.a.n0.j0.m;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.n0.j0.d.h;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Context f59801a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59802b;

    /* renamed from: c  reason: collision with root package name */
    public d f59803c;

    /* renamed from: d  reason: collision with root package name */
    public View f59804d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59805e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59806f;

    /* renamed from: g  reason: collision with root package name */
    public int f59807g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59808h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f59809i;

    /* renamed from: d.a.n0.j0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1440a implements View.OnClickListener {
        public View$OnClickListenerC1440a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f59805e) {
                if (a.this.f59803c != null) {
                    a.this.f59803c.onItemClick(1);
                }
            } else if (view == a.this.f59806f && a.this.f59803c != null) {
                a.this.f59803c.onItemClick(2);
            }
            a.this.i();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.i();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onItemClick(int i2);
    }

    public a(Context context) {
        super(context);
        this.f59808h = new View$OnClickListenerC1440a();
        this.f59809i = new b();
        this.f59801a = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        i();
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f59801a).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.f59804d = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.sort_type_level_text);
        this.f59805e = textView;
        d.a.m0.r.u.c.d(textView).x(R.string.F_X01);
        TextView textView2 = (TextView) this.f59804d.findViewById(R.id.sort_type_update_text);
        this.f59806f = textView2;
        d.a.m0.r.u.c.d(textView2).x(R.string.F_X01);
        this.f59805e.setOnClickListener(this.f59808h);
        this.f59806f.setOnClickListener(this.f59808h);
    }

    public final View f() {
        e();
        FrameLayout frameLayout = new FrameLayout(this.f59801a);
        FrameLayout frameLayout2 = new FrameLayout(this.f59801a);
        this.f59802b = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.f59804d);
        this.f59802b.setOnClickListener(this.f59809i);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f59801a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f59801a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f59801a, R.dimen.tbds4)).into(this.f59804d);
        return frameLayout;
    }

    public final void g() {
        super.dismiss();
    }

    public final void h() {
        if (d.a.m0.z0.l.a()) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(240L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new c());
        this.f59804d.startAnimation(translateAnimation);
        this.f59802b.startAnimation(alphaAnimation);
    }

    public void i() {
        h();
    }

    public void j() {
        if (this.f59807g == 1) {
            SkinManager.setViewTextColor(this.f59805e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f59806f, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.f59806f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f59805e, R.color.CAM_X0108);
        }
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f59801a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f59801a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f59801a, R.dimen.tbds4)).into(this.f59804d);
    }

    public void k(List<h> list, int i2) {
        if (list == null) {
            return;
        }
        this.f59807g = i2;
        View f2 = f();
        for (h hVar : list) {
            if (hVar.f59543b == 1) {
                this.f59805e.setText(hVar.f59542a);
            } else {
                this.f59806f.setText(hVar.f59542a);
            }
            if (i2 == 1) {
                SkinManager.setViewTextColor(this.f59805e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f59806f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f59806f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f59805e, R.color.CAM_X0108);
            }
        }
        setContentView(f2);
    }

    public void l(d dVar) {
        this.f59803c = dVar;
    }

    public void m(int i2) {
    }

    public final void n() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f59804d.startAnimation(translateAnimation);
        this.f59802b.startAnimation(alphaAnimation);
    }

    public void o(View view) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 24) {
            if (g.k(this, view)) {
                n();
                return;
            }
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (g.m(this, view, 0, iArr[0] - this.f59801a.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.f59801a.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
            n();
        }
    }
}
