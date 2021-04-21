package d.b.j0.i0.m;

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
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import d.b.j0.i0.d.h;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Context f57287a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57288b;

    /* renamed from: c  reason: collision with root package name */
    public d f57289c;

    /* renamed from: d  reason: collision with root package name */
    public View f57290d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57291e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57292f;

    /* renamed from: g  reason: collision with root package name */
    public int f57293g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57294h;
    public final View.OnClickListener i;

    /* renamed from: d.b.j0.i0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1355a implements View.OnClickListener {
        public View$OnClickListenerC1355a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f57291e) {
                if (a.this.f57289c != null) {
                    a.this.f57289c.onItemClick(1);
                }
            } else if (view == a.this.f57292f && a.this.f57289c != null) {
                a.this.f57289c.onItemClick(2);
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
        void onItemClick(int i);
    }

    public a(Context context) {
        super(context);
        this.f57294h = new View$OnClickListenerC1355a();
        this.i = new b();
        this.f57287a = context;
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
        View inflate = LayoutInflater.from(this.f57287a).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.f57290d = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.sort_type_level_text);
        this.f57291e = textView;
        d.b.i0.r.u.c.d(textView).v(R.string.F_X01);
        TextView textView2 = (TextView) this.f57290d.findViewById(R.id.sort_type_update_text);
        this.f57292f = textView2;
        d.b.i0.r.u.c.d(textView2).v(R.string.F_X01);
        this.f57291e.setOnClickListener(this.f57294h);
        this.f57292f.setOnClickListener(this.f57294h);
    }

    public final View f() {
        e();
        FrameLayout frameLayout = new FrameLayout(this.f57287a);
        FrameLayout frameLayout2 = new FrameLayout(this.f57287a);
        this.f57288b = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.f57290d);
        this.f57288b.setOnClickListener(this.i);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f57287a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f57287a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f57287a, R.dimen.tbds4)).into(this.f57290d);
        return frameLayout;
    }

    public final void g() {
        super.dismiss();
    }

    public final void h() {
        if (d.b.i0.z0.l.a()) {
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
        this.f57290d.startAnimation(translateAnimation);
        this.f57288b.startAnimation(alphaAnimation);
    }

    public void i() {
        h();
    }

    public void j() {
        if (this.f57293g == 1) {
            SkinManager.setViewTextColor(this.f57291e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f57292f, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.f57292f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f57291e, R.color.CAM_X0108);
        }
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f57287a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f57287a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f57287a, R.dimen.tbds4)).into(this.f57290d);
    }

    public void k(List<h> list, int i) {
        if (list == null) {
            return;
        }
        this.f57293g = i;
        View f2 = f();
        for (h hVar : list) {
            if (hVar.f57037b == 1) {
                this.f57291e.setText(hVar.f57036a);
            } else {
                this.f57292f.setText(hVar.f57036a);
            }
            if (i == 1) {
                SkinManager.setViewTextColor(this.f57291e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f57292f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f57292f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f57291e, R.color.CAM_X0108);
            }
        }
        setContentView(f2);
    }

    public void l(d dVar) {
        this.f57289c = dVar;
    }

    public void m(int i) {
    }

    public final void n() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.f57290d.startAnimation(translateAnimation);
        this.f57288b.startAnimation(alphaAnimation);
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
        if (g.m(this, view, 0, iArr[0] - this.f57287a.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.f57287a.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
            n();
        }
    }
}
