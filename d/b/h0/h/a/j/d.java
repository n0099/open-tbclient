package d.b.h0.h.a.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.b.h0.a.i2.h0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static final int f49495f = h0.f(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f49496a;

    /* renamed from: b  reason: collision with root package name */
    public View f49497b;

    /* renamed from: c  reason: collision with root package name */
    public View f49498c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49499d;

    /* renamed from: e  reason: collision with root package name */
    public b f49500e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49502f;

        public a(boolean z, int i) {
            this.f49501e = z;
            this.f49502f = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f49501e) {
                d.this.c(this.f49502f);
            }
            if (d.this.f49500e != null) {
                d.this.f49500e.b(this.f49501e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f49496a = view;
        this.f49497b = frameLayout;
        this.f49498c = view2;
    }

    public final void c(int i) {
        ViewGroup.LayoutParams layoutParams = this.f49496a.getLayoutParams();
        layoutParams.height = this.f49496a.getHeight() - (i * 2);
        this.f49496a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f49499d;
    }

    public void e(boolean z) {
        b bVar = this.f49500e;
        if (bVar != null) {
            bVar.a(z);
        }
        this.f49499d = z;
        int i = f49495f;
        if (z) {
            i = -i;
        }
        float[] fArr = new float[2];
        if (z) {
            fArr[0] = 0.0f;
            fArr[1] = i;
        } else {
            fArr[0] = -i;
            fArr[1] = 0.0f;
        }
        float[] fArr2 = new float[2];
        if (z) {
            fArr2[0] = 0.0f;
            fArr2[1] = i * 2;
        } else {
            fArr2[0] = (-i) * 2;
            fArr2[1] = 0.0f;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f49497b, "translationY", fArr), ObjectAnimator.ofFloat(this.f49496a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f49498c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i));
        if (z) {
            c(i);
        }
    }
}
