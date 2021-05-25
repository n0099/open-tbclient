package d.a.l0.j.o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.l0.a.v2.n0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static final int f47898f = n0.g(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f47899a;

    /* renamed from: b  reason: collision with root package name */
    public View f47900b;

    /* renamed from: c  reason: collision with root package name */
    public View f47901c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47902d;

    /* renamed from: e  reason: collision with root package name */
    public b f47903e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47905f;

        public a(boolean z, int i2) {
            this.f47904e = z;
            this.f47905f = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f47904e) {
                d.this.c(this.f47905f);
            }
            if (d.this.f47903e != null) {
                d.this.f47903e.a(this.f47904e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f47899a = view;
        this.f47900b = frameLayout;
        this.f47901c = view2;
    }

    public final void c(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f47899a.getLayoutParams();
        layoutParams.height = this.f47899a.getHeight() - (i2 * 2);
        this.f47899a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f47902d;
    }

    public void e(boolean z) {
        b bVar = this.f47903e;
        if (bVar != null) {
            bVar.b(z);
        }
        this.f47902d = z;
        int i2 = f47898f;
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f47900b, "translationY", fArr), ObjectAnimator.ofFloat(this.f47899a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f47901c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i2));
        if (z) {
            c(i2);
        }
    }
}
