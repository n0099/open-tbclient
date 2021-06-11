package d.a.d0.a.c;

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
        public final /* synthetic */ f f43272a;

        public a(b bVar, f fVar) {
            this.f43272a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f43272a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* renamed from: d.a.d0.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0575b implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f43273a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f43274b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f43275c;

        /* renamed from: d.a.d0.a.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = C0575b.this.f43275c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = C0575b.this.f43275c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = C0575b.this.f43275c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = C0575b.this.f43275c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public C0575b(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f43273a = fVar;
            this.f43274b = lottieAnimationView;
            this.f43275c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            if (lottieComposition != null) {
                f fVar = this.f43273a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f43274b.setVisibility(0);
                this.f43274b.setComposition(lottieComposition);
                this.f43274b.playAnimation();
                this.f43274b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements LottieListener<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f43277a;

        public c(b bVar, f fVar) {
            this.f43277a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            f fVar = this.f43277a;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f43278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f43279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f43280c;

        /* loaded from: classes2.dex */
        public class a implements Animator.AnimatorListener {
            public a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f43280c;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f43280c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f43280c;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Animator.AnimatorListener animatorListener = d.this.f43280c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        public d(b bVar, f fVar, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener) {
            this.f43278a = fVar;
            this.f43279b = lottieAnimationView;
            this.f43280c = animatorListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            if (lottieComposition != null) {
                f fVar = this.f43278a;
                if (fVar != null) {
                    fVar.a();
                }
                this.f43279b.setVisibility(0);
                this.f43279b.setComposition(lottieComposition);
                this.f43279b.playAnimation();
                this.f43279b.addAnimatorListener(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static b f43282a = new b(null);
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
        return e.f43282a;
    }

    public void a(File file, LottieAnimationView lottieAnimationView, Animator.AnimatorListener animatorListener, f fVar) {
        if (file == null || !file.exists() || lottieAnimationView == null) {
            return;
        }
        try {
            LottieCompositionFactory.fromZipStream(new ZipInputStream(new FileInputStream(file.getPath())), null).addListener(new C0575b(this, fVar, lottieAnimationView, animatorListener)).addFailureListener(new a(this, fVar));
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
        File o = d.a.d0.b.g.f.o(str);
        if (o != null && o.exists()) {
            a(o, lottieAnimationView, animatorListener, fVar);
            return;
        }
        try {
            LottieCompositionFactory.fromUrl(d.a.d0.a.b.a.f43271a.get().o(), str).addListener(new d(this, fVar, lottieAnimationView, animatorListener)).addFailureListener(new c(this, fVar));
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
