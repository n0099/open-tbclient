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
    public Context f56112a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56113b;

    /* renamed from: c  reason: collision with root package name */
    public d f56114c;

    /* renamed from: d  reason: collision with root package name */
    public View f56115d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56116e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56117f;

    /* renamed from: g  reason: collision with root package name */
    public int f56118g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56119h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f56120i;

    /* renamed from: d.a.n0.j0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1384a implements View.OnClickListener {
        public View$OnClickListenerC1384a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f56116e) {
                if (a.this.f56114c != null) {
                    a.this.f56114c.onItemClick(1);
                }
            } else if (view == a.this.f56117f && a.this.f56114c != null) {
                a.this.f56114c.onItemClick(2);
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
        this.f56119h = new View$OnClickListenerC1384a();
        this.f56120i = new b();
        this.f56112a = context;
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
        View inflate = LayoutInflater.from(this.f56112a).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.f56115d = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.sort_type_level_text);
        this.f56116e = textView;
        d.a.m0.r.u.c.d(textView).x(R.string.F_X01);
        TextView textView2 = (TextView) this.f56115d.findViewById(R.id.sort_type_update_text);
        this.f56117f = textView2;
        d.a.m0.r.u.c.d(textView2).x(R.string.F_X01);
        this.f56116e.setOnClickListener(this.f56119h);
        this.f56117f.setOnClickListener(this.f56119h);
    }

    public final View f() {
        e();
        FrameLayout frameLayout = new FrameLayout(this.f56112a);
        FrameLayout frameLayout2 = new FrameLayout(this.f56112a);
        this.f56113b = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.f56115d);
        this.f56113b.setOnClickListener(this.f56120i);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f56112a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f56112a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f56112a, R.dimen.tbds4)).into(this.f56115d);
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
        this.f56115d.startAnimation(translateAnimation);
        this.f56113b.startAnimation(alphaAnimation);
    }

    public void i() {
        h();
    }

    public void j() {
        if (this.f56118g == 1) {
            SkinManager.setViewTextColor(this.f56116e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f56117f, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.f56117f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f56116e, R.color.CAM_X0108);
        }
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f56112a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f56112a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f56112a, R.dimen.tbds4)).into(this.f56115d);
    }

    public void k(List<h> list, int i2) {
        if (list == null) {
            return;
        }
        this.f56118g = i2;
        View f2 = f();
        for (h hVar : list) {
            if (hVar.f55854b == 1) {
                this.f56116e.setText(hVar.f55853a);
            } else {
                this.f56117f.setText(hVar.f55853a);
            }
            if (i2 == 1) {
                SkinManager.setViewTextColor(this.f56116e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f56117f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f56117f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f56116e, R.color.CAM_X0108);
            }
        }
        setContentView(f2);
    }

    public void l(d dVar) {
        this.f56114c = dVar;
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
        this.f56115d.startAnimation(translateAnimation);
        this.f56113b.startAnimation(alphaAnimation);
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
        if (g.m(this, view, 0, iArr[0] - this.f56112a.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.f56112a.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
            n();
        }
    }
}
