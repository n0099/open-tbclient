package d.b.g0.i;

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
    public d.b.g0.i.a a0;
    public boolean b0;
    public int c0;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48869e;

        public a(View view) {
            this.f48869e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            p.this.Y.a(this.f48869e.getHeight());
            p.this.g0();
            this.f48869e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
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

    public p(Context context, View view, @Nullable d.b.g0.i.a aVar) {
        super(context);
        this.b0 = true;
        this.c0 = 0;
        this.W = context;
        this.X = view;
        this.a0 = aVar;
        A(false);
        E(true);
        I(true);
        z(new ColorDrawable(0));
        K(-1);
        F(-1);
        b0();
    }

    public void X() {
        d.b.g0.i.a aVar = this.a0;
        if (aVar != null) {
            aVar.a(this.Y);
        }
    }

    public void Y(boolean z) {
        if (!z) {
            super.n();
        } else if (u()) {
            ObjectAnimator c2 = c.c(this.U);
            ObjectAnimator e2 = c.e(this.V);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new b());
            animatorSet.playTogether(c2, e2);
            animatorSet.start();
        }
    }

    public final void b0() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.W).inflate(j.aiapp_menu_layout, (ViewGroup) null);
        this.Z = frameLayout;
        this.U = frameLayout.findViewById(i.mask);
        this.Y = (MainMenuView) this.Z.findViewById(i.aiapp_menu_body);
        this.U.setOnClickListener(this);
        this.Y.setClickListener(this);
        this.Z.measure(0, 0);
        B(this.Z);
    }

    public void c0() {
        this.Y.f();
    }

    public void d0(int i) {
        this.c0 = i;
    }

    public void f0(List<List<o>> list, View view, boolean z, int i) {
        this.Y.h(list, view, z, i);
        h0();
    }

    public final void g0() {
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

    public final void h0() {
        if (u()) {
            return;
        }
        X();
        this.Y.g();
        this.V = this.Y;
        if (this.b0) {
            E(false);
        }
        Activity activity = (Activity) this.W;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        M(this.X, 81, 0, 0);
        if (this.b0) {
            r().setSystemUiVisibility(this.c0 | 1024 | 4096);
            E(true);
            P();
        }
        View contentView = this.Y.getContentView();
        if (contentView.getHeight() == 0) {
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new a(contentView));
        } else {
            g0();
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void n() {
        Y(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == i.cancel || id == i.mask) {
            Y(true);
        }
    }
}
