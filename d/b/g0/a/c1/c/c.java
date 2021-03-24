package d.b.g0.a.c1.c;

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
import d.b.g0.a.f;
import d.b.g0.a.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends PopupWindow implements View.OnClickListener {
    public Context U;
    public View V;
    public d.b.g0.i.a W;
    public ViewGroup X;
    public View Y;
    public FontSizeSettingMenuView Z;
    public d a0;

    /* loaded from: classes3.dex */
    public class a implements SliderBar.c {
        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.SliderBar.c
        public void a(SliderBar sliderBar, int i) {
            if (c.this.a0 != null) {
                c.this.a0.a(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43750e;

        public b(View view) {
            this.f43750e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.this.Z.a(this.f43750e.getHeight());
            c.this.c0();
            this.f43750e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: d.b.g0.a.c1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0631c extends AnimatorListenerAdapter {
        public C0631c() {
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
        void a(int i);
    }

    public c(Context context, View view, @Nullable d.b.g0.i.a aVar) {
        super(context);
        this.U = context;
        this.V = view;
        this.W = aVar;
        A(false);
        E(true);
        I(true);
        z(new ColorDrawable(0));
        K(-1);
        F(-1);
        Y();
    }

    public void W() {
        d.b.g0.i.a aVar = this.W;
        if (aVar != null) {
            aVar.a(this.Z);
        }
    }

    public void X(boolean z) {
        if (!z) {
            super.n();
        } else if (u()) {
            ObjectAnimator c2 = d.b.g0.i.c.c(this.Y);
            ObjectAnimator e2 = d.b.g0.i.c.e(this.Z);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new C0631c());
            animatorSet.playTogether(c2, e2);
            animatorSet.start();
        }
    }

    public final void Y() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.U).inflate(g.swan_app_font_setting_layout, (ViewGroup) null);
        this.X = frameLayout;
        this.Y = frameLayout.findViewById(f.mask);
        this.Z = (FontSizeSettingMenuView) this.X.findViewById(f.font_size_setting);
        this.Y.setOnClickListener(this);
        this.Z.setClickListener(this);
        this.Z.setOnSliderBarChangeListener(new a());
        this.X.measure(0, 0);
        B(this.X);
    }

    public void b0(d dVar) {
        this.a0 = dVar;
    }

    public final void c0() {
        this.Y.setAlpha(0.0f);
        FontSizeSettingMenuView fontSizeSettingMenuView = this.Z;
        fontSizeSettingMenuView.setTranslationY(fontSizeSettingMenuView.getHeight());
        ObjectAnimator d2 = d.b.g0.i.c.d(this.Y, this.Z);
        ObjectAnimator b2 = d.b.g0.i.c.b(this.Z);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public void d0() {
        if (u()) {
            return;
        }
        W();
        Activity activity = (Activity) this.U;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.Z.setMode();
        M(this.V, 81, 0, 0);
        r().setSystemUiVisibility(5120);
        E(true);
        P();
        View contentView = this.Z.getContentView();
        if (contentView.getHeight() == 0) {
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new b(contentView));
        } else {
            c0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.cancel || id == f.mask) {
            X(true);
        }
    }
}
