package d.a.m0.j.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.m0.a.v2.n0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static final int f51680f = n0.g(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f51681a;

    /* renamed from: b  reason: collision with root package name */
    public View f51682b;

    /* renamed from: c  reason: collision with root package name */
    public View f51683c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51684d;

    /* renamed from: e  reason: collision with root package name */
    public b f51685e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51686e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51687f;

        public a(boolean z, int i2) {
            this.f51686e = z;
            this.f51687f = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f51686e) {
                d.this.c(this.f51687f);
            }
            if (d.this.f51685e != null) {
                d.this.f51685e.a(this.f51686e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f51681a = view;
        this.f51682b = frameLayout;
        this.f51683c = view2;
    }

    public final void c(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f51681a.getLayoutParams();
        layoutParams.height = this.f51681a.getHeight() - (i2 * 2);
        this.f51681a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f51684d;
    }

    public void e(boolean z) {
        b bVar = this.f51685e;
        if (bVar != null) {
            bVar.b(z);
        }
        this.f51684d = z;
        int i2 = f51680f;
        if (z) {
            i2 = -i2;
        }
        float[] fArr = new float[2];
        if (z) {
            fArr[0] = 0.0f;
            fArr[1] = i2;
        } else {
            fArr[0] = -i2;
            fArr[1] = 0.0f;
        }
        float[] fArr2 = new float[2];
        if (z) {
            fArr2[0] = 0.0f;
            fArr2[1] = i2 * 2;
        } else {
            fArr2[0] = (-i2) * 2;
            fArr2[1] = 0.0f;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f51682b, "translationY", fArr), ObjectAnimator.ofFloat(this.f51681a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f51683c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i2));
        if (z) {
            c(i2);
        }
    }
}
