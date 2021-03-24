package d.b.i0.i0.m;

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
import d.b.b.e.m.g;
import d.b.b.e.p.l;
import d.b.i0.i0.d.h;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public Context f55742a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55743b;

    /* renamed from: c  reason: collision with root package name */
    public d f55744c;

    /* renamed from: d  reason: collision with root package name */
    public View f55745d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55746e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55747f;

    /* renamed from: g  reason: collision with root package name */
    public int f55748g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f55749h;
    public final View.OnClickListener i;

    /* renamed from: d.b.i0.i0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1293a implements View.OnClickListener {
        public View$OnClickListenerC1293a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f55746e) {
                if (a.this.f55744c != null) {
                    a.this.f55744c.onItemClick(1);
                }
            } else if (view == a.this.f55747f && a.this.f55744c != null) {
                a.this.f55744c.onItemClick(2);
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
        this.f55749h = new View$OnClickListenerC1293a();
        this.i = new b();
        this.f55742a = context;
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
        View inflate = LayoutInflater.from(this.f55742a).inflate(R.layout.layout_sort_select, (ViewGroup) null);
        this.f55745d = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.sort_type_level_text);
        this.f55746e = textView;
        d.b.h0.r.u.c.a(textView).s(R.string.F_X01);
        TextView textView2 = (TextView) this.f55745d.findViewById(R.id.sort_type_update_text);
        this.f55747f = textView2;
        d.b.h0.r.u.c.a(textView2).s(R.string.F_X01);
        this.f55746e.setOnClickListener(this.f55749h);
        this.f55747f.setOnClickListener(this.f55749h);
    }

    public final View f() {
        e();
        FrameLayout frameLayout = new FrameLayout(this.f55742a);
        FrameLayout frameLayout2 = new FrameLayout(this.f55742a);
        this.f55743b = frameLayout2;
        frameLayout.addView(frameLayout2);
        frameLayout.addView(this.f55745d);
        this.f55743b.setOnClickListener(this.i);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f55742a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f55742a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f55742a, R.dimen.tbds4)).into(this.f55745d);
        return frameLayout;
    }

    public final void g() {
        super.dismiss();
    }

    public final void h() {
        if (d.b.h0.z0.l.a()) {
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
        this.f55745d.startAnimation(translateAnimation);
        this.f55743b.startAnimation(alphaAnimation);
    }

    public void i() {
        h();
    }

    public void j() {
        if (this.f55748g == 1) {
            SkinManager.setViewTextColor(this.f55746e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f55747f, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.f55747f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f55746e, R.color.CAM_X0108);
        }
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f55742a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f55742a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f55742a, R.dimen.tbds4)).into(this.f55745d);
    }

    public void k(List<h> list, int i) {
        if (list == null) {
            return;
        }
        this.f55748g = i;
        View f2 = f();
        for (h hVar : list) {
            if (hVar.f55492b == 1) {
                this.f55746e.setText(hVar.f55491a);
            } else {
                this.f55747f.setText(hVar.f55491a);
            }
            if (i == 1) {
                SkinManager.setViewTextColor(this.f55746e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f55747f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f55747f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f55746e, R.color.CAM_X0108);
            }
        }
        setContentView(f2);
    }

    public void l(d dVar) {
        this.f55744c = dVar;
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
        this.f55745d.startAnimation(translateAnimation);
        this.f55743b.startAnimation(alphaAnimation);
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
        if (g.m(this, view, 0, iArr[0] - this.f55742a.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.f55742a.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
            n();
        }
    }
}
