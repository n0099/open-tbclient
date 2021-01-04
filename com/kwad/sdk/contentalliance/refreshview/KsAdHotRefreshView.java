package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.utils.ao;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class KsAdHotRefreshView extends e {
    private static final float g = ao.a(KsAdSDKImpl.get().getContext(), 37.5f);
    private RefreshLayout.b h;
    private LottieAnimationView i;

    /* loaded from: classes5.dex */
    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<KsAdHotRefreshView> f9113a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9114b;

        a(KsAdHotRefreshView ksAdHotRefreshView, boolean z) {
            this.f9113a = new WeakReference<>(ksAdHotRefreshView);
            this.f9114b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            KsAdHotRefreshView ksAdHotRefreshView = this.f9113a.get();
            if (ksAdHotRefreshView != null) {
                if (!ksAdHotRefreshView.e() && ksAdHotRefreshView.e != null) {
                    ksAdHotRefreshView.e.c();
                }
                ksAdHotRefreshView.a(this.f9114b);
            }
        }
    }

    public KsAdHotRefreshView(Context context) {
        this(context, null);
    }

    public KsAdHotRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setRefreshTargetOffset(g - 1.0f);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    protected int a(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void a(int i, Animation.AnimationListener animationListener) {
        if (this.d.getTop() != 0 && this.d.getTop() != getRefreshTargetOffset()) {
            super.a(i, animationListener);
            return;
        }
        this.d.setTop(0);
        clearAnimation();
        this.i.d();
        animationListener.onAnimationStart(null);
        animationListener.onAnimationEnd(null);
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.e, com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    protected void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_hot_shoot_refresh_view_2, (ViewGroup) this, true);
        this.d = findViewById(R.id.ksad_shoot_refresh_view);
        this.d.setVisibility(8);
        this.i = (LottieAnimationView) findViewById(R.id.ksad_pull_to_refresh_animation_view);
        this.i.setAnimation(R.raw.ksad_detail_loading_amin_new);
        if (!(this.d instanceof d)) {
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
        this.e = (d) this.d;
    }

    public void a(boolean z) {
        super.setRefreshing(z);
    }

    public boolean a() {
        return this.d.getVisibility() == 0 && this.d.getAlpha() != 0.0f;
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.e, com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    protected b b() {
        return new b() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView.2
            @Override // com.kwad.sdk.contentalliance.refreshview.b
            public float a(float f, float f2) {
                return Math.min(KsAdHotRefreshView.g, 200.0f - (((200.0f * 200.0f) * 2.0f) / ((2.0f * 200.0f) + f)));
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout
    public void setOnRefreshListener(RefreshLayout.b bVar) {
        this.h = bVar;
        super.setOnRefreshListener(new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView.1
            @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
            public void a() {
                if (KsAdHotRefreshView.this.d instanceof KsAdHotShootRefreshView) {
                    ((KsAdHotShootRefreshView) KsAdHotRefreshView.this.d).setOnRefreshListener(KsAdHotRefreshView.this.h);
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
