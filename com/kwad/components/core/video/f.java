package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class f extends com.kwad.components.core.video.a implements br.a {
    public boolean El;
    public boolean UB;
    public boolean UC;
    public View Ux;
    public final AtomicBoolean Uy;
    public final br hh;

    /* loaded from: classes10.dex */
    public interface a extends a.c {
        void onVideoPlayError(int i, int i2);
    }

    public f(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.hh = new br(this);
        this.Uy = new AtomicBoolean(true);
        this.El = false;
        this.UB = false;
        this.UC = false;
        this.Ux = this;
    }

    private void ac() {
        if (this.Uy.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    private void ad() {
        if (!this.Uy.getAndSet(true)) {
            com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onViewDetached");
            this.hh.removeCallbacksAndMessages(null);
            release();
        }
    }

    private void rA() {
        this.El = false;
    }

    @Override // com.kwad.components.core.video.a
    public final void ew() {
        if (this.UB) {
            super.ew();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        rA();
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        ad();
    }

    @Override // com.kwad.components.core.video.a
    public final void qU() {
        super.qU();
        ImageView imageView = this.mR;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080e9d);
        }
        TextView textView = this.mS;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ra() {
        super.ra();
    }

    @Override // com.kwad.components.core.video.a
    public final void rc() {
        super.rc();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.El = true;
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (!this.El && message.what == 1) {
            if (this.UC) {
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (bq.o(this.Ux, 70)) {
                ra();
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

    public final void setShowLandingPage(boolean z) {
        this.UC = z;
    }
}
