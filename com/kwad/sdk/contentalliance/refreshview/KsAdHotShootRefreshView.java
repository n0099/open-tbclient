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
    public static final float f33334a = ao.a(KsAdSDKImpl.get().getContext(), 10.0f);

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33335b;

    /* renamed from: c  reason: collision with root package name */
    public RefreshLayout.b f33336c;

    public KsAdHotShootRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a(float f2, float f3) {
        if (f2 < f33334a) {
            setAlpha(0.0f);
            if (this.f33335b.c()) {
                this.f33335b.d();
                return;
            }
            return;
        }
        if (!this.f33335b.c()) {
            this.f33335b.b();
        }
        float f4 = f33334a;
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
                if (KsAdHotShootRefreshView.this.f33335b != null) {
                    KsAdHotShootRefreshView.this.f33335b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotShootRefreshView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (KsAdHotShootRefreshView.this.f33336c != null) {
                                KsAdHotShootRefreshView.this.f33336c.a();
                            }
                        }
                    });
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (KsAdHotShootRefreshView.this.f33336c != null) {
                    KsAdHotShootRefreshView.this.f33336c.a();
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
        this.f33335b = lottieAnimationView;
        int i = R.raw.ksad_detail_loading_amin_new;
        lottieAnimationView.setVisibility(0);
        this.f33335b.setAnimation(i);
        this.f33335b.setRepeatMode(1);
        this.f33335b.setRepeatCount(-1);
        this.f33335b.setAnimation(i);
    }

    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.f33336c = bVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
