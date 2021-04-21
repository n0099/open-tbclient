package d.b.b0.a.c;

import android.animation.Animator;
import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import d.a.a.m;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public class a implements d.a.a.h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42107a;

        public a(b bVar, f fVar) {
            this.f42107a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f42107a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* renamed from: d.b.b0.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0564b implements d.a.a.h<d.a.a.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f42109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f42110c;

        /* renamed from: d.b.b0.a.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = C0564b.this.f42110c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = C0564b.this.f42110c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = C0564b.this.f42110c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = C0564b.this.f42110c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public C0564b(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f42108a = fVar;
            this.f42109b = lottieAnimationView;
            this.f42110c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            if (dVar != null) {
                f fVar = this.f42108a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f42109b.setVisibility(0);
                this.f42109b.setComposition(dVar);
                this.f42109b.playAnimation();
                this.f42109b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.a.h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42112a;

        public c(b bVar, f fVar) {
            this.f42112a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f42112a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.a.h<d.a.a.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f42113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f42114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f42115c;

        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f42115c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f42115c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f42115c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f42115c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public d(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f42113a = fVar;
            this.f42114b = lottieAnimationView;
            this.f42115c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            if (dVar != null) {
                f fVar = this.f42113a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f42114b.setVisibility(0);
                this.f42114b.setComposition(dVar);
                this.f42114b.playAnimation();
                this.f42114b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static b f42117a = new b(null);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return e.f42117a;
    }

    public void a(File file, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        if (file == null || !file.exists() || lottieAnimationView == null) {
            return;
        }
        try {
            m<d.a.a.d> s = d.a.a.e.s(new ZipInputStream(new FileInputStream(file.getPath())), null);
            s.f(new C0564b(this, fVar, lottieAnimationView, animatorListener));
            s.e(new a(this, fVar));
        } catch (Exception unused) {
            lottieAnimationView.setVisibility(8);
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public void b(String str, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        if (TextUtils.isEmpty(str) || lottieAnimationView == null) {
            return;
        }
        File m = d.b.b0.b.f.f.m(str);
        if (m != null && m.exists()) {
            a(m, lottieAnimationView, animatorListener, fVar);
            return;
        }
        try {
            m<d.a.a.d> q = d.a.a.e.q(d.b.b0.a.b.a.f42106a.get().y(), str);
            q.f(new d(this, fVar, lottieAnimationView, animatorListener));
            q.e(new c(this, fVar));
        } catch (Exception unused) {
            lottieAnimationView.setVisibility(8);
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    public b() {
    }
}
