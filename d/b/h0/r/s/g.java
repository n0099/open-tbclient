package d.b.h0.r.s;

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
import d.b.h0.z0.i0;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Activity f50996e;

    /* renamed from: f  reason: collision with root package name */
    public View f50997f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f50998g;

    /* renamed from: h  reason: collision with root package name */
    public View f50999h;
    public TextView i;
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
        this.f50996e = activity;
        this.r = d.b.b.e.p.l.g(activity, R.dimen.tbds114);
        this.p = d.b.b.e.p.l.g(activity, R.dimen.tbds84);
        this.q = d.b.b.e.p.l.g(activity, R.dimen.tbds44);
        this.m = d.b.b.e.p.l.g(activity, R.dimen.tbds222);
        this.l = d.b.b.e.p.l.g(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.f50998g = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.f50999h = inflate.findViewById(R.id.background);
        this.i = (TextView) inflate.findViewById(R.id.toast_tv);
        this.f50997f = inflate;
        this.f50999h.setBackgroundDrawable(b());
        this.i.setMaxLines(1);
        this.i.setGravity(17);
        this.i.setTextSize(0, d.b.b.e.p.l.g(activity, R.dimen.tbfontsize40));
        this.i.setTextColor(this.f50996e.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.i;
        int i = this.q;
        textView.setPadding(i, 0, i, 0);
        this.j = (WindowManager) this.f50996e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = d.b.b.e.p.l.k(this.f50996e) - (this.l * 2);
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
        if (this.f50996e != null && !TextUtils.isEmpty(str)) {
            String e2 = i0.e(str, 34);
            int t = d.b.b.e.p.l.t(this.i.getPaint(), e2);
            ViewGroup.LayoutParams layoutParams = this.f50998g.getLayoutParams();
            layoutParams.width = t + (this.q * 2);
            this.f50998g.setLayoutParams(layoutParams);
            this.i.setText(e2);
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
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{d.b.i0.i1.o.k.b.b("#FF722B"), d.b.i0.i1.o.k.b.b("#FF2b5D")});
        gradientDrawable.setCornerRadius(this.p);
        return gradientDrawable;
    }

    public final int d() {
        return this.m + UtilHelper.getNavigationBarHeight(this.f50996e);
    }

    public void e() {
        d.b.b.e.m.e.a().removeCallbacks(this.u);
        if (this.f50997f.getWindowToken() != null) {
            this.j.removeView(this.f50997f);
        }
    }

    public g g(int i) {
        if (i > 0) {
            this.o = i * 1000;
        }
        return this;
    }

    public void h(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void i(Object obj) {
        this.f50998g.setTag(obj);
        this.f50998g.setOnClickListener(this);
    }

    public g j() {
        d.b.b.e.m.e.a().removeCallbacks(this.u);
        View view = this.f50997f;
        if (view != null && view.getWindowToken() != null) {
            this.j.removeView(this.f50997f);
        }
        this.j.addView(this.f50997f, this.k);
        d.b.b.e.m.e.a().postDelayed(this.u, this.o);
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
