package d.b.g0.h.a.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import d.b.g0.a.i2.h0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    public static final int f48774f = h0.f(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f48775a;

    /* renamed from: b  reason: collision with root package name */
    public View f48776b;

    /* renamed from: c  reason: collision with root package name */
    public View f48777c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48778d;

    /* renamed from: e  reason: collision with root package name */
    public b f48779e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48781f;

        public a(boolean z, int i) {
            this.f48780e = z;
            this.f48781f = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f48780e) {
                d.this.c(this.f48781f);
            }
            if (d.this.f48779e != null) {
                d.this.f48779e.b(this.f48780e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f48775a = view;
        this.f48776b = frameLayout;
        this.f48777c = view2;
    }

    public final void c(int i) {
        ViewGroup.LayoutParams layoutParams = this.f48775a.getLayoutParams();
        layoutParams.height = this.f48775a.getHeight() - (i * 2);
        this.f48775a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f48778d;
    }

    public void e(boolean z) {
        b bVar = this.f48779e;
        if (bVar != null) {
            bVar.a(z);
        }
        this.f48778d = z;
        int i = f48774f;
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f48776b, "translationY", fArr), ObjectAnimator.ofFloat(this.f48775a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f48777c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i));
        if (z) {
            c(i);
        }
    }
}
