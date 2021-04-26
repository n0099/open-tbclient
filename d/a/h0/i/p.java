package d.a.h0.i;

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
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.PopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p extends PopupWindow implements View.OnClickListener {
    public View U;
    public BaseMenuView V;
    public Context W;
    public View X;
    public MainMenuView Y;
    public FrameLayout Z;
    public d.a.h0.i.a a0;
    public boolean b0;
    public int c0;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47097e;

        public a(View view) {
            this.f47097e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            p.this.Y.a(this.f47097e.getHeight());
            p.this.d0();
            this.f47097e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Context context = p.this.W;
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            p.super.n();
            if (p.this.V != p.this.Y) {
                p.this.V.setVisibility(8);
            }
        }
    }

    public p(Context context, View view, @Nullable d.a.h0.i.a aVar) {
        super(context);
        this.b0 = true;
        this.c0 = 0;
        this.W = context;
        this.X = view;
        this.a0 = aVar;
        z(false);
        B(true);
        H(true);
        y(new ColorDrawable(0));
        J(-1);
        F(-1);
        Y();
    }

    public void W() {
        d.a.h0.i.a aVar = this.a0;
        if (aVar != null) {
            aVar.a(this.Y);
        }
    }

    public void X(boolean z) {
        if (!z) {
            super.n();
        } else if (t()) {
            ObjectAnimator c2 = c.c(this.U);
            ObjectAnimator e2 = c.e(this.V);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new b());
            animatorSet.playTogether(c2, e2);
            animatorSet.start();
        }
    }

    public final void Y() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.W).inflate(j.aiapp_menu_layout, (ViewGroup) null);
        this.Z = frameLayout;
        this.U = frameLayout.findViewById(i.mask);
        this.Y = (MainMenuView) this.Z.findViewById(i.aiapp_menu_body);
        this.U.setOnClickListener(this);
        this.Y.setClickListener(this);
        this.Z.measure(0, 0);
        A(this.Z);
    }

    public void Z() {
        this.Y.f();
    }

    public void a0(int i2) {
        this.c0 = i2;
    }

    public void b0(List<List<o>> list, View view, boolean z, int i2) {
        this.Y.h(list, view, z, i2);
        e0();
    }

    public final void d0() {
        this.U.setAlpha(0.0f);
        MainMenuView mainMenuView = this.Y;
        mainMenuView.setTranslationY(mainMenuView.getHeight());
        ObjectAnimator d2 = c.d(this.U, this.Y);
        ObjectAnimator b2 = c.b(this.Y);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d2);
        arrayList.add(b2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public final void e0() {
        if (t()) {
            return;
        }
        W();
        this.Y.g();
        this.V = this.Y;
        if (this.b0) {
            B(false);
        }
        Activity activity = (Activity) this.W;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        L(this.X, 81, 0, 0);
        if (this.b0) {
            r().setSystemUiVisibility(this.c0 | 1024 | 4096);
            B(true);
            N();
        }
        View contentView = this.Y.getContentView();
        if (contentView.getHeight() == 0) {
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new a(contentView));
        } else {
            d0();
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void n() {
        X(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == i.cancel || id == i.mask) {
            X(true);
        }
    }
}
