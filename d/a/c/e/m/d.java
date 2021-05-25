package d.a.c.e.m;

import android.view.animation.Animation;
/* loaded from: classes.dex */
public abstract class d implements Animation.AnimationListener {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Animation f38722e;

        public a(Animation animation) {
            this.f38722e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c(this.f38722e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Animation f38724e;

        public b(Animation animation) {
            this.f38724e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f38724e);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Animation f38726e;

        public c(Animation animation) {
            this.f38726e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(this.f38726e);
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
