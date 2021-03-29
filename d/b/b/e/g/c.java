package d.b.b.e.g;

import android.app.Activity;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.guide.Configuration;
import com.baidu.adp.lib.guide.MaskView;
import d.b.b.e.g.d;
/* loaded from: classes.dex */
public class c implements View.OnKeyListener, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Configuration f41736e;

    /* renamed from: f  reason: collision with root package name */
    public MaskView f41737f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.e.g.b[] f41738g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41739h = true;
    public boolean i = false;
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
        public final /* synthetic */ ViewGroup f41741a;

        public b(ViewGroup viewGroup) {
            this.f41741a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f41741a.removeAllViews();
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

    /* renamed from: d.b.b.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class animation.Animation$AnimationListenerC0536c implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC0536c() {
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
        public final /* synthetic */ ViewGroup f41744a;

        public d(ViewGroup viewGroup) {
            this.f41744a = viewGroup;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f41744a.removeView(c.this.f41737f);
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
        MaskView maskView = this.f41737f;
        if (maskView == null || !(maskView.getParent() instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f41737f.getParent();
        if (this.f41736e.n != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f41737f.getContext(), this.f41736e.n);
            loadAnimation.setAnimationListener(new d(viewGroup));
            this.f41737f.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeView(this.f41737f);
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
        if (this.f41736e.n != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(viewGroup.getContext(), this.f41736e.n);
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
        maskView.e(activity.getResources().getColor(this.f41736e.j));
        maskView.d(this.f41736e.f2161g);
        maskView.g(this.f41736e.l);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i = iArr[1];
        if (this.f41739h && i == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                i = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
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
        Configuration configuration = this.f41736e;
        View view = configuration.f2159e;
        if (view != null) {
            maskView.h(d.b.b.e.g.a.b(view, 0, i));
        } else {
            View findViewById = activity.findViewById(configuration.i);
            if (findViewById != null) {
                maskView.h(d.b.b.e.g.a.b(findViewById, 0, i));
            }
        }
        View findViewById2 = activity.findViewById(this.f41736e.f2162h);
        if (findViewById2 != null) {
            maskView.f(d.b.b.e.g.a.b(findViewById2, 0, i));
        }
        if (this.f41736e.f2160f) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (d.b.b.e.g.b bVar : this.f41738g) {
            maskView.addView(d.b.b.e.g.a.a(activity.getLayoutInflater(), bVar));
        }
        return maskView;
    }

    public final void h() {
        this.f41736e = null;
        this.f41738g = null;
        this.j = null;
    }

    public void i(d.a aVar) {
        this.j = aVar;
    }

    public void j(d.b.b.e.g.b[] bVarArr) {
        this.f41738g = bVarArr;
    }

    public void k(Configuration configuration) {
        this.f41736e = configuration;
    }

    public void l(boolean z) {
        this.f41739h = z;
    }

    public void m(boolean z) {
        this.i = z;
    }

    public void n(Activity activity) {
        o(activity, true);
    }

    public void o(Activity activity, boolean z) {
        p((ViewGroup) activity.findViewById(16908290), activity, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration = this.f41736e;
        if (configuration == null || !configuration.k) {
            return;
        }
        d();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Configuration configuration;
        if (i == 4 && keyEvent.getAction() == 1 && (configuration = this.f41736e) != null && configuration.k) {
            d();
            return true;
        }
        return false;
    }

    public final void p(ViewGroup viewGroup, Activity activity, boolean z) {
        if (this.f41737f == null) {
            MaskView f2 = f(activity);
            this.f41737f = f2;
            f2.i(this.i);
            if (!z) {
                this.f41737f.setFocusable(false);
                this.f41737f.setFocusableInTouchMode(false);
                this.f41737f.clearFocus();
            }
        }
        if (this.f41737f.getParent() == null) {
            viewGroup.addView(this.f41737f);
            int i = this.f41736e.m;
            if (i != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, i);
                loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0536c());
                this.f41737f.startAnimation(loadAnimation);
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
        for (d.b.b.e.g.b bVar : this.f41738g) {
            View b2 = bVar.b(activity.getLayoutInflater());
            if (b2.getParent() == null) {
                viewGroup.addView(b2);
            }
        }
        int i = this.f41736e.m;
        if (i == -1) {
            d.a aVar = this.j;
            if (aVar != null) {
                aVar.onShown();
                return;
            }
            return;
        }
        Animation animation = null;
        try {
            animation = AnimationUtils.loadAnimation(activity, i);
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
