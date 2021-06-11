package d.a.m0.r.s;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.m0.z0.i0;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Activity f53921e;

    /* renamed from: f  reason: collision with root package name */
    public View f53922f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f53923g;

    /* renamed from: h  reason: collision with root package name */
    public View f53924h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53925i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public int p;
    public int q;
    public int r;
    public Drawable s;
    public View.OnClickListener t;
    public float n = 1.0f;
    public int o = 5000;
    public final Runnable u = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.e();
        }
    }

    public g(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f53921e = activity;
        this.r = d.a.c.e.p.l.g(activity, R.dimen.tbds114);
        this.p = d.a.c.e.p.l.g(activity, R.dimen.tbds84);
        this.q = d.a.c.e.p.l.g(activity, R.dimen.tbds44);
        this.m = d.a.c.e.p.l.g(activity, R.dimen.tbds222);
        this.l = d.a.c.e.p.l.g(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.f53923g = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.f53924h = inflate.findViewById(R.id.background);
        this.f53925i = (TextView) inflate.findViewById(R.id.toast_tv);
        this.f53922f = inflate;
        this.f53924h.setBackgroundDrawable(b());
        this.f53925i.setMaxLines(1);
        this.f53925i.setGravity(17);
        this.f53925i.setTextSize(0, d.a.c.e.p.l.g(activity, R.dimen.tbfontsize40));
        this.f53925i.setTextColor(this.f53921e.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.f53925i;
        int i2 = this.q;
        textView.setPadding(i2, 0, i2, 0);
        this.j = (WindowManager) this.f53921e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = d.a.c.e.p.l.k(this.f53921e) - (this.l * 2);
        WindowManager.LayoutParams layoutParams2 = this.k;
        layoutParams2.height = this.r;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.ToastAnimation;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.k.alpha = this.n;
    }

    public static g f(Activity activity, String str) {
        g gVar = new g(activity);
        gVar.a(str);
        return gVar;
    }

    public final g a(String str) {
        if (this.f53921e != null && !TextUtils.isEmpty(str)) {
            String e2 = i0.e(str, 34);
            int t = d.a.c.e.p.l.t(this.f53925i.getPaint(), e2);
            ViewGroup.LayoutParams layoutParams = this.f53923g.getLayoutParams();
            layoutParams.width = t + (this.q * 2);
            this.f53923g.setLayoutParams(layoutParams);
            this.f53925i.setText(e2);
        }
        return this;
    }

    public final Drawable b() {
        if (this.s == null) {
            this.s = c();
        }
        return this.s;
    }

    public final GradientDrawable c() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{d.a.n0.k1.o.k.b.b("#FF722B"), d.a.n0.k1.o.k.b.b("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.p);
        return gradientDrawable;
    }

    public final int d() {
        return this.m + UtilHelper.getNavigationBarHeight(this.f53921e);
    }

    public void e() {
        d.a.c.e.m.e.a().removeCallbacks(this.u);
        if (this.f53922f.getWindowToken() != null) {
            this.j.removeView(this.f53922f);
        }
    }

    public g g(int i2) {
        if (i2 > 0) {
            this.o = i2 * 1000;
        }
        return this;
    }

    public void h(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void i(Object obj) {
        this.f53923g.setTag(obj);
        this.f53923g.setOnClickListener(this);
    }

    public g j() {
        d.a.c.e.m.e.a().removeCallbacks(this.u);
        View view = this.f53922f;
        if (view != null && view.getWindowToken() != null) {
            this.j.removeView(this.f53922f);
        }
        this.j.addView(this.f53922f, this.k);
        d.a.c.e.m.e.a().postDelayed(this.u, this.o);
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.t;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        e();
    }
}
