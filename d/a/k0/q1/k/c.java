package d.a.k0.q1.k;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.like.ILiveLikeView;
import com.baidu.searchbox.live.interfaces.like.LiveLikeAnimatorCallback;
import com.baidu.tieba.medialive.like.HeartSurfaceView;
/* loaded from: classes3.dex */
public class c implements ILiveLikeView {

    /* renamed from: a  reason: collision with root package name */
    public float f59754a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public int f59755b = 500;

    /* renamed from: c  reason: collision with root package name */
    public float f59756c = 0.4f;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f59757e;

        public a(c cVar, LottieAnimationView lottieAnimationView) {
            this.f59757e = lottieAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f59757e.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements HeartSurfaceView.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveLikeAnimatorCallback f59758a;

        public b(c cVar, LiveLikeAnimatorCallback liveLikeAnimatorCallback) {
            this.f59758a = liveLikeAnimatorCallback;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.e
        public void a(int i2, int i3) {
            LiveLikeAnimatorCallback liveLikeAnimatorCallback = this.f59758a;
            if (liveLikeAnimatorCallback != null) {
                liveLikeAnimatorCallback.onAnimLocation(0, i2, i3);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void addLikeAnimation(View view, int i2) {
        if (view instanceof HeartSurfaceView) {
            ((HeartSurfaceView) view).p(i2);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeAnimatorView() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(AppRuntime.getAppContext());
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lottieAnimationView.setAnimation("lottie/liveshow_video_like_explosion.json");
        return lottieAnimationView;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeRippleView() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(AppRuntime.getAppContext());
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lottieAnimationView.setAnimation("lottie/liveshow_video_like_bg.json");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f59756c, this.f59754a);
        ofFloat.setDuration(this.f59755b);
        ofFloat.addUpdateListener(new a(this, lottieAnimationView));
        lottieAnimationView.setTag(ofFloat);
        return lottieAnimationView;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeView() {
        HeartSurfaceView heartSurfaceView = new HeartSurfaceView(AppRuntime.getAppContext());
        heartSurfaceView.setUpResNormalMode();
        heartSurfaceView.setZOrderOnTop(true);
        heartSurfaceView.getHolder().setFormat(-3);
        return heartSurfaceView;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void playAnimation(View view) {
        if (view instanceof LottieAnimationView) {
            ((LottieAnimationView) view).playAnimation();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void setAnimatorListener(View view, Animator.AnimatorListener animatorListener) {
        if (view instanceof LottieAnimationView) {
            ((LottieAnimationView) view).addAnimatorListener(animatorListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void setLikeAnimatorListener(View view, LiveLikeAnimatorCallback liveLikeAnimatorCallback) {
        if (view instanceof LottieAnimationView) {
            ((HeartSurfaceView) view).setAnimateEndListener(new b(this, liveLikeAnimatorCallback));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void startRipple(View view) {
        Object tag;
        if ((view instanceof LottieAnimationView) && (tag = view.getTag()) != null && (tag instanceof ValueAnimator)) {
            ((ValueAnimator) tag).start();
        }
    }
}
