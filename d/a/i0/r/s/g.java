package d.a.i0.r.s;

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
import d.a.i0.z0.i0;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Activity f49382e;

    /* renamed from: f  reason: collision with root package name */
    public View f49383f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f49384g;

    /* renamed from: h  reason: collision with root package name */
    public View f49385h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49386i;
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
        this.f49382e = activity;
        this.r = d.a.c.e.p.l.g(activity, R.dimen.tbds114);
        this.p = d.a.c.e.p.l.g(activity, R.dimen.tbds84);
        this.q = d.a.c.e.p.l.g(activity, R.dimen.tbds44);
        this.m = d.a.c.e.p.l.g(activity, R.dimen.tbds222);
        this.l = d.a.c.e.p.l.g(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.f49384g = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.f49385h = inflate.findViewById(R.id.background);
        this.f49386i = (TextView) inflate.findViewById(R.id.toast_tv);
        this.f49383f = inflate;
        this.f49385h.setBackgroundDrawable(b());
        this.f49386i.setMaxLines(1);
        this.f49386i.setGravity(17);
        this.f49386i.setTextSize(0, d.a.c.e.p.l.g(activity, R.dimen.tbfontsize40));
        this.f49386i.setTextColor(this.f49382e.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.f49386i;
        int i2 = this.q;
        textView.setPadding(i2, 0, i2, 0);
        this.j = (WindowManager) this.f49382e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = d.a.c.e.p.l.k(this.f49382e) - (this.l * 2);
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
        if (this.f49382e != null && !TextUtils.isEmpty(str)) {
            String e2 = i0.e(str, 34);
            int t = d.a.c.e.p.l.t(this.f49386i.getPaint(), e2);
            ViewGroup.LayoutParams layoutParams = this.f49384g.getLayoutParams();
            layoutParams.width = t + (this.q * 2);
            this.f49384g.setLayoutParams(layoutParams);
            this.f49386i.setText(e2);
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
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{d.a.j0.j1.o.k.b.b("#FF722B"), d.a.j0.j1.o.k.b.b("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.p);
        return gradientDrawable;
    }

    public final int d() {
        return this.m + UtilHelper.getNavigationBarHeight(this.f49382e);
    }

    public void e() {
        d.a.c.e.m.e.a().removeCallbacks(this.u);
        if (this.f49383f.getWindowToken() != null) {
            this.j.removeView(this.f49383f);
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
        this.f49384g.setTag(obj);
        this.f49384g.setOnClickListener(this);
    }

    public g j() {
        d.a.c.e.m.e.a().removeCallbacks(this.u);
        View view = this.f49383f;
        if (view != null && view.getWindowToken() != null) {
            this.j.removeView(this.f49383f);
        }
        this.j.addView(this.f49383f, this.k);
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
