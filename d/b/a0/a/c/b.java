package d.b.a0.a.c;

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
        public final /* synthetic */ f f41818a;

        public a(b bVar, f fVar) {
            this.f41818a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f41818a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* renamed from: d.b.a0.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0545b implements d.a.a.h<d.a.a.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f41819a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f41820b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f41821c;

        /* renamed from: d.b.a0.a.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = C0545b.this.f41821c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = C0545b.this.f41821c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = C0545b.this.f41821c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = C0545b.this.f41821c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public C0545b(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f41819a = fVar;
            this.f41820b = lottieAnimationView;
            this.f41821c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            if (dVar != null) {
                f fVar = this.f41819a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f41820b.setVisibility(0);
                this.f41820b.setComposition(dVar);
                this.f41820b.playAnimation();
                this.f41820b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.a.h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f41823a;

        public c(b bVar, f fVar) {
            this.f41823a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f41823a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.a.h<d.a.a.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f41824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f41825b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f41826c;

        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f41826c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f41826c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f41826c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f41826c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public d(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f41824a = fVar;
            this.f41825b = lottieAnimationView;
            this.f41826c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            if (dVar != null) {
                f fVar = this.f41824a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f41825b.setVisibility(0);
                this.f41825b.setComposition(dVar);
                this.f41825b.playAnimation();
                this.f41825b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static b f41828a = new b(null);
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
        return e.f41828a;
    }

    public void a(File file, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        if (file == null || !file.exists() || lottieAnimationView == null) {
            return;
        }
        try {
            m<d.a.a.d> s = d.a.a.e.s(new ZipInputStream(new FileInputStream(file.getPath())), null);
            s.f(new C0545b(this, fVar, lottieAnimationView, animatorListener));
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
        File m = d.b.a0.b.f.f.m(str);
        if (m != null && m.exists()) {
            a(m, lottieAnimationView, animatorListener, fVar);
            return;
        }
        try {
            m<d.a.a.d> q = d.a.a.e.q(d.b.a0.a.b.a.f41817a.get().y(), str);
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
