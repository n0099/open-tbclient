package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class e extends a implements br.a {
    public boolean UA;
    public View Ux;
    public final AtomicBoolean Uy;
    public boolean Uz;
    public final KsAdVideoPlayConfig dU;
    public final br hh;

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.hh = new br(this);
        this.Uy = new AtomicBoolean(true);
        this.UA = true;
        this.Ux = this;
        this.dU = ksAdVideoPlayConfig;
    }

    private void ac() {
        if (this.Uy.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    public final void ad() {
        if (!this.Uy.getAndSet(true)) {
            com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewDetached");
            this.hh.removeCallbacksAndMessages(null);
            if (this.UA) {
                release();
            } else {
                this.aAB.pause();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        ad();
    }

    public final void rv() {
        this.hh.removeCallbacksAndMessages(null);
        if (this.UA) {
            release();
        } else {
            this.aAB.pause();
        }
    }

    public final void rx() {
        this.aAB.pause();
        this.Uz = true;
    }

    public final void ry() {
        ra();
        this.Uz = false;
    }

    public final void rz() {
        this.Uz = false;
    }

    private boolean rw() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return ag.isNetworkConnected(this.mContext);
                }
                return ag.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.bU(this.mAdInfo)) {
            return ag.isNetworkConnected(this.mContext);
        }
        if (!com.kwad.sdk.core.response.b.a.bV(this.mAdInfo)) {
            return false;
        }
        return ag.isWifiConnected(this.mContext);
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (!this.Tk && message.what == 1) {
            if (bq.o(this.Ux, 30)) {
                if (!this.Uz) {
                    ra();
                }
            } else {
                rc();
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public final void setAutoRelease(boolean z) {
        this.UA = z;
    }

    @Override // com.kwad.components.core.video.a
    public final void ra() {
        if (this.aAB.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.Ty;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ag.isNetworkConnected(this.mContext)) {
                qW();
                return;
            }
            qX();
            if (this.Tk) {
                rb();
                this.aAB.start();
            } else if (rw()) {
                rb();
                this.aAB.start();
            } else if (this.Ti) {
                rb();
                this.aAB.start();
            } else {
                qY();
            }
        } else if (this.aAB.isPaused() || this.aAB.Fa()) {
            rb();
            this.aAB.restart();
        }
    }
}
