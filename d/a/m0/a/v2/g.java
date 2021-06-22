package d.a.m0.a.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49192e;

        public a(View view) {
            this.f49192e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f49192e.setTranslationX(0.0f);
        }
    }

    public static void a(d.a.m0.a.h0.g.g gVar, Context context) {
        b(gVar, context, 2);
    }

    public static void b(d.a.m0.a.h0.g.g gVar, Context context, int i2) {
        View b0;
        if (gVar == null || gVar.k() < i2) {
            return;
        }
        d.a.m0.a.h0.g.d j = gVar.j(gVar.k() - i2);
        float o = n0.o(context) >> 2;
        if (j == null || (b0 = j.b0()) == null) {
            return;
        }
        ObjectAnimator.ofFloat(b0, "translationX", -o, 0.0f).setDuration(300L).start();
    }

    public static void c(d.a.m0.a.h0.g.g gVar, Context context) {
        View b0;
        if (gVar == null || gVar.k() < 2) {
            return;
        }
        d.a.m0.a.h0.g.d j = gVar.j(gVar.k() - 2);
        float o = n0.o(context) >> 2;
        if (j == null || (b0 = j.b0()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b0, "translationX", 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(b0));
    }
}
