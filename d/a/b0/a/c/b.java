package d.a.b0.a.c;

import android.animation.Animator;
import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public class a implements LottieListener<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f39289a;

        public a(b bVar, f fVar) {
            this.f39289a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f39289a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* renamed from: d.a.b0.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0503b implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f39290a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f39291b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f39292c;

        /* renamed from: d.a.b0.a.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = C0503b.this.f39292c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = C0503b.this.f39292c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = C0503b.this.f39292c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = C0503b.this.f39292c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public C0503b(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f39290a = fVar;
            this.f39291b = lottieAnimationView;
            this.f39292c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            if (lottieComposition != null) {
                f fVar = this.f39290a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f39291b.setVisibility(0);
                this.f39291b.setComposition(lottieComposition);
                this.f39291b.playAnimation();
                this.f39291b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements LottieListener<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f39294a;

        public c(b bVar, f fVar) {
            this.f39294a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f39294a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f39295a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f39296b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f39297c;

        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f39297c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f39297c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f39297c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f39297c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public d(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f39295a = fVar;
            this.f39296b = lottieAnimationView;
            this.f39297c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            if (lottieComposition != null) {
                f fVar = this.f39295a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f39296b.setVisibility(0);
                this.f39296b.setComposition(lottieComposition);
                this.f39296b.playAnimation();
                this.f39296b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static b f39299a = new b(null);
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
        return e.f39299a;
    }

    public void a(File file, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        if (file == null || !file.exists() || lottieAnimationView == null) {
            return;
        }
        try {
            LottieCompositionFactory.fromZipStream(new ZipInputStream(new FileInputStream(file.getPath())), null).addListener(new C0503b(this, fVar, lottieAnimationView, animatorListener)).addFailureListener(new a(this, fVar));
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
        File m = d.a.b0.b.f.f.m(str);
        if (m != null && m.exists()) {
            a(m, lottieAnimationView, animatorListener, fVar);
            return;
        }
        try {
            LottieCompositionFactory.fromUrl(d.a.b0.a.b.a.f39288a.get().o(), str).addListener(new d(this, fVar, lottieAnimationView, animatorListener)).addFailureListener(new c(this, fVar));
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
