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
    public Configuration f42332e;

    /* renamed from: f  reason: collision with root package name */
    public MaskView f42333f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.e.g.b[] f42334g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42335h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42336i = false;
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
        public final /* synthetic */ ViewGroup f42338a;

        public b(ViewGroup viewGroup) {
            this.f42338a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f42338a.removeAllViews();
            if (c.this.j != null) {
                c.this.j.onDismiss();
            }
            c.this.h();
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
    public class animation.Animation$AnimationListenerC0542c implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC0542c() {
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
        public final /* synthetic */ ViewGroup f42341a;

        public d(ViewGroup viewGroup) {
            this.f42341a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f42341a.removeView(c.this.f42333f);
            if (c.this.j != null) {
                c.this.j.onDismiss();
            }
            c.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void d() {
        MaskView maskView = this.f42333f;
        if (maskView == null || !(maskView.getParent() instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f42333f.getParent();
        if (this.f42332e.n != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f42333f.getContext(), this.f42332e.n);
            loadAnimation.setAnimationListener(new d(viewGroup));
            this.f42333f.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeView(this.f42333f);
        d.a aVar = this.j;
        if (aVar != null) {
            aVar.onDismiss();
        }
        h();
    }

    public void e(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f42332e.n != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(viewGroup.getContext(), this.f42332e.n);
            loadAnimation.setAnimationListener(new b(viewGroup));
            viewGroup.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeAllViews();
        d.a aVar = this.j;
        if (aVar != null) {
            aVar.onDismiss();
        }
        h();
    }

    public final MaskView f(Activity activity) {
        MaskView maskView = new MaskView(activity);
        maskView.e(activity.getResources().getColor(this.f42332e.j));
        maskView.d(this.f42332e.f2178g);
        maskView.g(this.f42332e.l);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i2 = iArr[1];
        if (this.f42335h && i2 == 0) {
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
        Configuration configuration = this.f42332e;
        View view = configuration.f2176e;
        if (view != null) {
            maskView.h(d.a.c.e.g.a.b(view, 0, i2));
        } else {
            View findViewById = activity.findViewById(configuration.f2180i);
            if (findViewById != null) {
                maskView.h(d.a.c.e.g.a.b(findViewById, 0, i2));
            }
        }
        View findViewById2 = activity.findViewById(this.f42332e.f2179h);
        if (findViewById2 != null) {
            maskView.f(d.a.c.e.g.a.b(findViewById2, 0, i2));
        }
        if (this.f42332e.f2177f) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (d.a.c.e.g.b bVar : this.f42334g) {
            maskView.addView(d.a.c.e.g.a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    public final void h() {
        this.f42332e = null;
        this.f42334g = null;
        this.j = null;
    }

    public void i(d.a aVar) {
        this.j = aVar;
    }

    public void j(d.a.c.e.g.b[] bVarArr) {
        this.f42334g = bVarArr;
    }

    public void k(Configuration configuration) {
        this.f42332e = configuration;
    }

    public void l(boolean z) {
        this.f42335h = z;
    }

    public void m(boolean z) {
        this.f42336i = z;
    }

    public void n(Activity activity) {
        o(activity, true);
    }

    public void o(Activity activity, boolean z) {
        p((ViewGroup) activity.findViewById(16908290), activity, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration = this.f42332e;
        if (configuration == null || !configuration.k) {
            return;
        }
        d();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        Configuration configuration;
        if (i2 == 4 && keyEvent.getAction() == 1 && (configuration = this.f42332e) != null && configuration.k) {
            d();
            return true;
        }
        return false;
    }

    public final void p(ViewGroup viewGroup, Activity activity, boolean z) {
        if (this.f42333f == null) {
            MaskView f2 = f(activity);
            this.f42333f = f2;
            f2.i(this.f42336i);
            if (!z) {
                this.f42333f.setFocusable(false);
                this.f42333f.setFocusableInTouchMode(false);
                this.f42333f.clearFocus();
            }
        }
        if (this.f42333f.getParent() == null) {
            viewGroup.addView(this.f42333f);
            int i2 = this.f42332e.m;
            if (i2 != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, i2);
                loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0542c());
                this.f42333f.startAnimation(loadAnimation);
                return;
            }
            d.a aVar = this.j;
            if (aVar != null) {
                aVar.onShown();
            }
        }
    }

    public void q(Activity activity) {
        p((ViewGroup) activity.getWindow().getDecorView(), activity, true);
    }

    public void r(Activity activity, ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        if (!z) {
            viewGroup.setFocusable(false);
            viewGroup.setFocusableInTouchMode(false);
            viewGroup.clearFocus();
        }
        for (d.a.c.e.g.b bVar : this.f42334g) {
            View c2 = bVar.c(activity.getLayoutInflater());
            if (c2.getParent() == null) {
                viewGroup.addView(c2);
            }
        }
        int i2 = this.f42332e.m;
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
