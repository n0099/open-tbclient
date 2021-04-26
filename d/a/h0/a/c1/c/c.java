package d.a.h0.a.c1.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.menu.fontsize.FontSizeSettingMenuView;
import com.baidu.swan.apps.res.ui.SliderBar;
import com.baidu.swan.menu.PopupWindow;
import d.a.h0.a.f;
import d.a.h0.a.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends PopupWindow implements View.OnClickListener {
    public Context U;
    public View V;
    public d.a.h0.i.a W;
    public ViewGroup X;
    public View Y;
    public FontSizeSettingMenuView Z;
    public d a0;

    /* loaded from: classes3.dex */
    public class a implements SliderBar.c {
        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.SliderBar.c
        public void a(SliderBar sliderBar, int i2) {
            if (c.this.a0 != null) {
                c.this.a0.a(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f41763e;

        public b(View view) {
            this.f41763e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.this.Z.a(this.f41763e.getHeight());
            c.this.Z();
            this.f41763e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: d.a.h0.a.c1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0603c extends AnimatorListenerAdapter {
        public C0603c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Context context = c.this.U;
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            c.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i2);
    }

    public c(Context context, View view, @Nullable d.a.h0.i.a aVar) {
        super(context);
        this.U = context;
        this.V = view;
        this.W = aVar;
        z(false);
        B(true);
        H(true);
        y(new ColorDrawable(0));
        J(-1);
        F(-1);
        X();
    }

    public void V() {
        d.a.h0.i.a aVar = this.W;
        if (aVar != null) {
            aVar.a(this.Z);
        }
    }

    public void W(boolean z) {
        if (!z) {
            super.n();
        } else if (t()) {
            ObjectAnimator c2 = d.a.h0.i.c.c(this.Y);
            ObjectAnimator e2 = d.a.h0.i.c.e(this.Z);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new C0603c());
            animatorSet.playTogether(c2, e2);
            animatorSet.start();
        }
    }

    public final void X() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.U).inflate(g.swan_app_font_setting_layout, (ViewGroup) null);
        this.X = frameLayout;
        this.Y = frameLayout.findViewById(f.mask);
        this.Z = (FontSizeSettingMenuView) this.X.findViewById(f.font_size_setting);
        this.Y.setOnClickListener(this);
        this.Z.setClickListener(this);
        this.Z.setOnSliderBarChangeListener(new a());
        this.X.measure(0, 0);
        A(this.X);
    }

    public void Y(d dVar) {
        this.a0 = dVar;
    }

    public final void Z() {
        this.Y.setAlpha(0.0f);
        FontSizeSettingMenuView fontSizeSettingMenuView = this.Z;
        fontSizeSettingMenuView.setTranslationY(fontSizeSettingMenuView.getHeight());
        ObjectAnimator d2 = d.a.h0.i.c.d(this.Y, this.Z);
        ObjectAnimator b2 = d.a.h0.i.c.b(this.Z);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void a0() {
        if (t()) {
            return;
        }
        V();
        Activity activity = (Activity) this.U;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.Z.setMode();
        L(this.V, 81, 0, 0);
        r().setSystemUiVisibility(5120);
        B(true);
        N();
        View contentView = this.Z.getContentView();
        if (contentView.getHeight() == 0) {
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new b(contentView));
        } else {
            Z();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.cancel || id == f.mask) {
            W(true);
        }
    }
}
