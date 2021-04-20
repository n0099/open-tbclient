package com.kwad.sdk.contentalliance.refreshview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class KsAdHotShootRefreshView extends RelativeLayout implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final float f33239a = ao.a(KsAdSDKImpl.get().getContext(), 10.0f);

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33240b;

    /* renamed from: c  reason: collision with root package name */
    public RefreshLayout.b f33241c;

    public KsAdHotShootRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a(float f2, float f3) {
        if (f2 < f33239a) {
            setAlpha(0.0f);
            if (this.f33240b.c()) {
                this.f33240b.d();
                return;
            }
            return;
        }
        if (!this.f33240b.c()) {
            this.f33240b.b();
        }
        float f4 = f33239a;
        setAlpha(Math.min(1.0f, (f2 - f4) / (f4 * 2.0f)));
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(getTop(), 0);
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotShootRefreshView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                KsAdHotShootRefreshView.this.setTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotShootRefreshView.2
            private void a() {
                if (KsAdHotShootRefreshView.this.f33240b != null) {
                    KsAdHotShootRefreshView.this.f33240b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotShootRefreshView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (KsAdHotShootRefreshView.this.f33241c != null) {
                                KsAdHotShootRefreshView.this.f33241c.a();
                            }
                        }
                    });
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (KsAdHotShootRefreshView.this.f33241c != null) {
                    KsAdHotShootRefreshView.this.f33241c.a();
                } else {
                    a();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.start();
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void c() {
        setAlpha(0.0f);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void d() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void e() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public int f() {
        return 200;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
        this.f33240b = lottieAnimationView;
        int i = R.raw.ksad_detail_loading_amin_new;
        lottieAnimationView.setVisibility(0);
        this.f33240b.setAnimation(i);
        this.f33240b.setRepeatMode(1);
        this.f33240b.setRepeatCount(-1);
        this.f33240b.setAnimation(i);
    }

    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.f33241c = bVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
