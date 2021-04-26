package d.a.c.e.m;

import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class d implements Animation.AnimationListener {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Animation f39813e;

        public a(Animation animation) {
            this.f39813e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c(this.f39813e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Animation f39815e;

        public b(Animation animation) {
            this.f39815e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f39815e);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Animation f39817e;

        public c(Animation animation) {
            this.f39817e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(this.f39817e);
        }
    }

    public void a(Animation animation) {
    }

    public void b(Animation animation) {
    }

    public void c(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        e.a().post(new b(animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        e.a().post(new c(animation));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        e.a().post(new a(animation));
    }
}
