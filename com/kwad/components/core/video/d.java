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
import com.kwad.sdk.utils.bg;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.core.video.a implements bg.a {
    public View Kr;
    public final bg Ks;
    public final AtomicBoolean Kt;
    public boolean Kw;
    public boolean zA;

    /* loaded from: classes10.dex */
    public interface a extends a.b {
        void onVideoPlayError(int i, int i2);
    }

    public d(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.Ks = new bg(this);
        this.Kt = new AtomicBoolean(true);
        this.zA = false;
        this.Kw = false;
        this.Kr = this;
    }

    private void am() {
        if (this.Kt.getAndSet(false)) {
            com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onViewAttached");
            this.Ks.sendEmptyMessage(1);
        }
    }

    private void an() {
        if (this.Kt.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onViewDetached");
        this.Ks.removeCallbacksAndMessages(null);
        release();
    }

    private void pf() {
        this.zA = false;
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        if (!this.zA && message.what == 1) {
            if (com.kwad.sdk.b.kwai.a.g(this.Kr, 70)) {
                oO();
            } else {
                oQ();
            }
            this.Ks.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void er() {
        if (this.Kw) {
            super.er();
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void oI() {
        super.oI();
        ImageView imageView = this.jQ;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080e4b);
        }
        TextView textView = this.jR;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        pf();
        am();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        an();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        am();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.b.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
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

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.zA = true;
    }
}
