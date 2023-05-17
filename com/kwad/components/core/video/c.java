package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public final class c extends a implements bg.a {
    public View Kr;
    public final bg Ks;
    public final AtomicBoolean Kt;
    public boolean Ku;
    public boolean Kv;
    public final KsAdVideoPlayConfig cN;

    public c(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.Ks = new bg(this);
        this.Kt = new AtomicBoolean(true);
        this.Kv = true;
        this.Kr = this;
        this.cN = ksAdVideoPlayConfig;
    }

    private void am() {
        if (this.Kt.getAndSet(false)) {
            com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onViewAttached");
            this.Ks.sendEmptyMessage(1);
        }
    }

    private void an() {
        if (this.Kt.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onViewDetached");
        this.Ks.removeCallbacksAndMessages(null);
        if (this.Kv) {
            release();
        } else {
            this.aef.pause();
        }
    }

    private boolean pb() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ae.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ae.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? ae.isNetworkConnected(this.mContext) : ae.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.a.a.bi(this.mAdInfo)) {
            return ae.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.a.a.bj(this.mAdInfo)) {
            return ae.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        if (!this.Jm && message.what == 1) {
            if (!com.kwad.sdk.b.kwai.a.g(this.Kr, 30)) {
                oQ();
            } else if (!this.Ku) {
                oO();
            }
            this.Ks.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void oO() {
        if (!this.aef.isIdle()) {
            if (this.aef.isPaused() || this.aef.vE()) {
                oP();
                this.aef.restart();
            }
        } else if (!ae.isNetworkConnected(this.mContext)) {
            oK();
        } else {
            oL();
            if (!this.Jm && !pb() && !this.Jk) {
                oM();
                return;
            }
            oP();
            this.aef.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onAttachedToWindow");
        am();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onDetachedFromWindow");
        an();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        am();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.b.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        an();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public final void pc() {
        this.aef.pause();
        this.Ku = true;
    }

    public final void pd() {
        oO();
        this.Ku = false;
    }

    public final void pe() {
        this.Ku = false;
    }

    public final void setAutoRelease(boolean z) {
        this.Kv = z;
    }
}
