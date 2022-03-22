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
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.core.video.videoview.a implements bc.a {

    /* renamed from: e  reason: collision with root package name */
    public View f40239e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f40240f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f40241g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40242h;

    public c(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f40240f = new bc(this);
        this.f40241g = new AtomicBoolean(true);
        this.f40242h = false;
        this.f40239e = this;
    }

    private void n() {
        this.f40242h = false;
    }

    private void o() {
        if (this.f40241g.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewAttached");
            this.f40240f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void a() {
        super.a();
        ImageView imageView = ((com.kwad.sdk.core.video.videoview.a) this).f39902b;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080bbe);
        }
        TextView textView = ((com.kwad.sdk.core.video.videoview.a) this).f39903c;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        if (!this.f40242h && message.what == 1) {
            if (bb.a(this.f40239e, 30)) {
                f();
            } else {
                g();
            }
            this.f40240f.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void b() {
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void h() {
        super.h();
        this.f40242h = true;
    }

    public void m() {
        if (this.f40241g.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("InterstitialVideoPlayerController", "onViewDetached");
        this.f40240f.removeCallbacksAndMessages(null);
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
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
