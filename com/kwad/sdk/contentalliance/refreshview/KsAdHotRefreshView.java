package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class KsAdHotRefreshView extends e {

    /* renamed from: g  reason: collision with root package name */
    public static final float f32944g = ao.a(KsAdSDKImpl.get().getContext(), 37.5f);

    /* renamed from: h  reason: collision with root package name */
    public RefreshLayout.b f32945h;
    public LottieAnimationView i;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<KsAdHotRefreshView> f32948a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f32949b;

        public a(KsAdHotRefreshView ksAdHotRefreshView, boolean z) {
            this.f32948a = new WeakReference<>(ksAdHotRefreshView);
            this.f32949b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            KsAdHotRefreshView ksAdHotRefreshView = this.f32948a.get();
            if (ksAdHotRefreshView != null) {
                if (!ksAdHotRefreshView.e() && (dVar = ksAdHotRefreshView.f32960e) != null) {
                    dVar.c();
                }
                ksAdHotRefreshView.a(this.f32949b);
            }
        }
    }

    public KsAdHotRefreshView(Context context) {
        this(context, null);
    }

    public KsAdHotRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setRefreshTargetOffset(f32944g - 1.0f);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public int a(int i) {
        return i;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(int i, Animation.AnimationListener animationListener) {
        if (this.f32959d.getTop() != 0 && this.f32959d.getTop() != getRefreshTargetOffset()) {
            super.a(i, animationListener);
            return;
        }
        this.f32959d.setTop(0);
        clearAnimation();
        this.i.d();
        animationListener.onAnimationStart(null);
        animationListener.onAnimationEnd(null);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.e, com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_hot_shoot_refresh_view_2, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ksad_shoot_refresh_view);
        this.f32959d = findViewById;
        findViewById.setVisibility(8);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
        this.i = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_detail_loading_amin_new);
        View view = this.f32959d;
        if (!(view instanceof d)) {
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
        this.f32960e = (d) view;
    }

    public void a(boolean z) {
        super.setRefreshing(z);
    }

    public boolean a() {
        return this.f32959d.getVisibility() == 0 && this.f32959d.getAlpha() != 0.0f;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.e, com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public b b() {
        return new b() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView.2
            @Override // com.kwad.sdk.contentalliance.refreshview.b
            public float a(float f2, float f3) {
                return Math.min(KsAdHotRefreshView.f32944g, 200.0f - (80000.0f / (f2 + 400.0f)));
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.f32945h = bVar;
        super.setOnRefreshListener(new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView.1
            @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
            public void a() {
                KsAdHotRefreshView ksAdHotRefreshView = KsAdHotRefreshView.this;
                View view = ksAdHotRefreshView.f32959d;
                if (view instanceof KsAdHotShootRefreshView) {
                    ((KsAdHotShootRefreshView) view).setOnRefreshListener(ksAdHotRefreshView.f32945h);
                }
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void setRefreshing(boolean z) {
        if (z) {
            super.setRefreshing(z);
        } else {
            postDelayed(new a(this, z), 600L);
        }
    }
}
