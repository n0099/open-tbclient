package com.kwad.sdk.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class c extends com.kwad.sdk.core.video.videoview.a implements bc.a {

    /* renamed from: e  reason: collision with root package name */
    public View f55168e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f55169f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f55170g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55171h;

    public c(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f55169f = new bc(this);
        this.f55170g = new AtomicBoolean(true);
        this.f55171h = false;
        this.f55168e = this;
    }

    private void n() {
        this.f55171h = false;
    }

    private void o() {
        if (this.f55170g.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewAttached");
            this.f55169f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void a() {
        super.a();
        ImageView imageView = ((com.kwad.sdk.core.video.videoview.a) this).f54803b;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        TextView textView = ((com.kwad.sdk.core.video.videoview.a) this).f54804c;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        if (!this.f55171h && message.what == 1) {
            if (bb.a(this.f55168e, 30)) {
                f();
            } else {
                g();
            }
            this.f55169f.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void b() {
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void h() {
        super.h();
        this.f55171h = true;
    }

    public void m() {
        if (this.f55170g.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewDetached");
        this.f55169f.removeCallbacksAndMessages(null);
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onAttachedToWindow");
        n();
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onDetachedFromWindow");
        m();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        o();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        m();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }
}
