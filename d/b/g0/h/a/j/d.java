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
    public static final int f49166f = h0.f(58.0f);

    /* renamed from: a  reason: collision with root package name */
    public View f49167a;

    /* renamed from: b  reason: collision with root package name */
    public View f49168b;

    /* renamed from: c  reason: collision with root package name */
    public View f49169c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49170d;

    /* renamed from: e  reason: collision with root package name */
    public b f49171e;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49173f;

        public a(boolean z, int i) {
            this.f49172e = z;
            this.f49173f = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            animator.removeAllListeners();
            if (!this.f49172e) {
                d.this.c(this.f49173f);
            }
            if (d.this.f49171e != null) {
                d.this.f49171e.b(this.f49172e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);

        void b(boolean z);
    }

    public d(View view, FrameLayout frameLayout, View view2) {
        this.f49167a = view;
        this.f49168b = frameLayout;
        this.f49169c = view2;
    }

    public final void c(int i) {
        ViewGroup.LayoutParams layoutParams = this.f49167a.getLayoutParams();
        layoutParams.height = this.f49167a.getHeight() - (i * 2);
        this.f49167a.setLayoutParams(layoutParams);
    }

    public boolean d() {
        return this.f49170d;
    }

    public void e(boolean z) {
        b bVar = this.f49171e;
        if (bVar != null) {
            bVar.a(z);
        }
        this.f49170d = z;
        int i = f49166f;
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f49168b, "translationY", fArr), ObjectAnimator.ofFloat(this.f49167a, "translationY", fArr2), ObjectAnimator.ofFloat(this.f49169c, "translationY", fArr2));
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new a(z, i));
        if (z) {
            c(i);
        }
    }
}
