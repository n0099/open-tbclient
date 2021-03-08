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
/* loaded from: classes3.dex */
public class KsAdHotShootRefreshView extends RelativeLayout implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final float f5872a = ao.a(KsAdSDKImpl.get().getContext(), 10.0f);
    private LottieAnimationView b;
    private RefreshLayout.b c;

    public KsAdHotShootRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a() {
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a(float f, float f2) {
        if (f >= f5872a) {
            if (!this.b.c()) {
                this.b.b();
            }
            setAlpha(Math.min(1.0f, (f - f5872a) / (f5872a * 2.0f)));
            return;
        }
        setAlpha(0.0f);
        if (this.b.c()) {
            this.b.d();
        }
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
                if (KsAdHotShootRefreshView.this.b != null) {
                    KsAdHotShootRefreshView.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotShootRefreshView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (KsAdHotShootRefreshView.this.c != null) {
                                KsAdHotShootRefreshView.this.c.a();
                            }
                        }
                    });
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (KsAdHotShootRefreshView.this.c != null) {
                    KsAdHotShootRefreshView.this.c.a();
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
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.b.setVisibility(0);
        this.b.setAnimation(i);
        this.b.setRepeatMode(1);
        this.b.setRepeatCount(-1);
        this.b.setAnimation(i);
    }

    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.c = bVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
