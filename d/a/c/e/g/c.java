package d.a.c.e.g;

import android.app.Activity;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.guide.Configuration;
import com.baidu.adp.lib.guide.MaskView;
import d.a.c.e.g.d;
/* loaded from: classes.dex */
public class c implements View.OnKeyListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Configuration f39667e;

    /* renamed from: f  reason: collision with root package name */
    public MaskView f39668f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.e.g.b[] f39669g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39670h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39671i = false;
    public d.a j;

    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.j != null) {
                c.this.j.onShown();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f39673a;

        public b(ViewGroup viewGroup) {
            this.f39673a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f39673a.removeAllViews();
            if (c.this.j != null) {
                c.this.j.onDismiss();
            }
            c.this.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: d.a.c.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class animation.Animation$AnimationListenerC0512c implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC0512c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.j != null) {
                c.this.j.onShown();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f39676a;

        public d(ViewGroup viewGroup) {
            this.f39676a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f39676a.removeView(c.this.f39668f);
            if (c.this.j != null) {
                c.this.j.onDismiss();
            }
            c.this.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void d() {
        MaskView maskView = this.f39668f;
        if (maskView == null || !(maskView.getParent() instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f39668f.getParent();
        if (this.f39667e.n != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f39668f.getContext(), this.f39667e.n);
            loadAnimation.setAnimationListener(new d(viewGroup));
            this.f39668f.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeView(this.f39668f);
        d.a aVar = this.j;
        if (aVar != null) {
            aVar.onDismiss();
        }
        g();
    }

    public void e(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f39667e.n != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(viewGroup.getContext(), this.f39667e.n);
            loadAnimation.setAnimationListener(new b(viewGroup));
            viewGroup.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeAllViews();
        d.a aVar = this.j;
        if (aVar != null) {
            aVar.onDismiss();
        }
        g();
    }

    public final MaskView f(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.e(activity.getResources().getColor(this.f39667e.j));
        maskView.d(this.f39667e.f2160g);
        maskView.g(this.f39667e.l);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i2 = iArr[1];
        if (this.f39670h && i2 == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                i2 = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            } catch (IllegalArgumentException e5) {
                e5.printStackTrace();
            } catch (InstantiationException e6) {
                e6.printStackTrace();
            } catch (NoSuchFieldException e7) {
                e7.printStackTrace();
            } catch (SecurityException e8) {
                e8.printStackTrace();
            }
        }
        Configuration configuration = this.f39667e;
        View view = configuration.f2158e;
        if (view != null) {
            maskView.h(d.a.c.e.g.a.b(view, 0, i2));
        } else {
            View findViewById = activity.findViewById(configuration.f2162i);
            if (findViewById != null) {
                maskView.h(d.a.c.e.g.a.b(findViewById, 0, i2));
            }
        }
        View findViewById2 = activity.findViewById(this.f39667e.f2161h);
        if (findViewById2 != null) {
            maskView.f(d.a.c.e.g.a.b(findViewById2, 0, i2));
        }
        if (this.f39667e.f2159f) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (d.a.c.e.g.b bVar : this.f39669g) {
            maskView.addView(d.a.c.e.g.a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    public final void g() {
        this.f39667e = null;
        this.f39669g = null;
        this.j = null;
    }

    public void h(d.a aVar) {
        this.j = aVar;
    }

    public void i(d.a.c.e.g.b[] bVarArr) {
        this.f39669g = bVarArr;
    }

    public void j(Configuration configuration) {
        this.f39667e = configuration;
    }

    public void k(boolean z) {
        this.f39670h = z;
    }

    public void l(boolean z) {
        this.f39671i = z;
    }

    public void m(Activity activity) {
        n(activity, true);
    }

    public void n(Activity activity, boolean z) {
        o((ViewGroup) activity.findViewById(16908290), activity, z);
    }

    public final void o(ViewGroup viewGroup, Activity activity, boolean z) {
        if (this.f39668f == null) {
            MaskView f2 = f(activity);
            this.f39668f = f2;
            f2.i(this.f39671i);
            if (!z) {
                this.f39668f.setFocusable(false);
                this.f39668f.setFocusableInTouchMode(false);
                this.f39668f.clearFocus();
            }
        }
        if (this.f39668f.getParent() == null) {
            viewGroup.addView(this.f39668f);
            int i2 = this.f39667e.m;
            if (i2 != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, i2);
                loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0512c());
                this.f39668f.startAnimation(loadAnimation);
                return;
            }
            d.a aVar = this.j;
            if (aVar != null) {
                aVar.onShown();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration = this.f39667e;
        if (configuration == null || !configuration.k) {
            return;
        }
        d();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        Configuration configuration;
        if (i2 == 4 && keyEvent.getAction() == 1 && (configuration = this.f39667e) != null && configuration.k) {
            d();
            return true;
        }
        return false;
    }

    public void p(Activity activity) {
        o((ViewGroup) activity.getWindow().getDecorView(), activity, true);
    }

    public void q(Activity activity, ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        if (!z) {
            viewGroup.setFocusable(false);
            viewGroup.setFocusableInTouchMode(false);
            viewGroup.clearFocus();
        }
        for (d.a.c.e.g.b bVar : this.f39669g) {
            View c2 = bVar.c(activity.getLayoutInflater());
            if (c2.getParent() == null) {
                viewGroup.addView(c2);
            }
        }
        int i2 = this.f39667e.m;
        if (i2 == -1) {
            d.a aVar = this.j;
            if (aVar != null) {
                aVar.onShown();
                return;
            }
            return;
        }
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(activity, i2);
        } catch (Resources.NotFoundException unused) {
        }
        if (animation == null) {
            d.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.onShown();
                return;
            }
            return;
        }
        animation.setAnimationListener(new a());
        viewGroup.startAnimation(animation);
    }
}
