package d.a.h0.a.i2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f42723e;

        public a(View view) {
            this.f42723e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f42723e.setTranslationX(0.0f);
        }
    }

    public static void a(d.a.h0.a.e0.l.f fVar, Context context) {
        b(fVar, context, 2);
    }

    public static void b(d.a.h0.a.e0.l.f fVar, Context context, int i2) {
        View P;
        if (fVar == null || fVar.k() < i2) {
            return;
        }
        d.a.h0.a.e0.l.c j = fVar.j(fVar.k() - i2);
        float m = h0.m(context) >> 2;
        if (j == null || (P = j.P()) == null) {
            return;
        }
        ObjectAnimator.ofFloat(P, "translationX", -m, 0.0f).setDuration(300L).start();
    }

    public static void c(d.a.h0.a.e0.l.f fVar, Context context) {
        View P;
        if (fVar == null || fVar.k() < 2) {
            return;
        }
        d.a.h0.a.e0.l.c j = fVar.j(fVar.k() - 2);
        float m = h0.m(context) >> 2;
        if (j == null || (P = j.P()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(P, "translationX", 0.0f, -m);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(P));
    }
}
