package d.a.h0.h.a.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static final int f46997f = h0.f(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f46998a;

    /* renamed from: b  reason: collision with root package name */
    public View f46999b;

    /* renamed from: c  reason: collision with root package name */
    public View f47000c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47001d;

    /* renamed from: e  reason: collision with root package name */
    public b f47002e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f47004f;

        public a(boolean z, int i2) {
            this.f47003e = z;
            this.f47004f = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f47003e) {
                d.this.c(this.f47004f);
            }
            if (d.this.f47002e != null) {
                d.this.f47002e.a(this.f47003e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f46998a = view;
        this.f46999b = frameLayout;
        this.f47000c = view2;
    }

    public final void c(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f46998a.getLayoutParams();
        layoutParams.height = this.f46998a.getHeight() - (i2 * 2);
        this.f46998a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f47001d;
    }

    public void e(boolean z) {
        b bVar = this.f47002e;
        if (bVar != null) {
            bVar.b(z);
        }
        this.f47001d = z;
        int i2 = f46997f;
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f46999b, "translationY", fArr), ObjectAnimator.ofFloat(this.f46998a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f47000c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i2));
        if (z) {
            c(i2);
        }
    }
}
