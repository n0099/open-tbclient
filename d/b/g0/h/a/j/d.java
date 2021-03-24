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
    public static final int f48773f = h0.f(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f48774a;

    /* renamed from: b  reason: collision with root package name */
    public View f48775b;

    /* renamed from: c  reason: collision with root package name */
    public View f48776c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48777d;

    /* renamed from: e  reason: collision with root package name */
    public b f48778e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48780f;

        public a(boolean z, int i) {
            this.f48779e = z;
            this.f48780f = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f48779e) {
                d.this.c(this.f48780f);
            }
            if (d.this.f48778e != null) {
                d.this.f48778e.b(this.f48779e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f48774a = view;
        this.f48775b = frameLayout;
        this.f48776c = view2;
    }

    public final void c(int i) {
        ViewGroup.LayoutParams layoutParams = this.f48774a.getLayoutParams();
        layoutParams.height = this.f48774a.getHeight() - (i * 2);
        this.f48774a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f48777d;
    }

    public void e(boolean z) {
        b bVar = this.f48778e;
        if (bVar != null) {
            bVar.a(z);
        }
        this.f48777d = z;
        int i = f48773f;
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f48775b, "translationY", fArr), ObjectAnimator.ofFloat(this.f48774a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f48776c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i));
        if (z) {
            c(i);
        }
    }
}
