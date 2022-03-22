package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements bc.a {

    /* renamed from: e  reason: collision with root package name */
    public View f40508e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f40509f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f40510g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40511h;
    public boolean i;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f40509f = new bc(this);
        this.f40510g = new AtomicBoolean(true);
        this.i = true;
        this.f40508e = this;
    }

    private void q() {
        if (this.f40510g.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewAttached");
            this.f40509f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        if (!this.a && message.what == 1) {
            if (!bb.a(this.f40508e, 30)) {
                g();
            } else if (!this.f40511h) {
                f();
            }
            this.f40509f.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void m() {
        if (this.f40510g.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewDetached");
        this.f40509f.removeCallbacksAndMessages(null);
        if (this.i) {
            h();
        } else {
            this.f39918d.c();
        }
    }

    public void n() {
        this.f39918d.c();
        this.f40511h = true;
    }

    public void o() {
        f();
        this.f40511h = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onAttachedToWindow");
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onDetachedFromWindow");
        m();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onFinishTemporaryDetach");
        q();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onStartTemporaryDetach");
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

    public void p() {
        this.f40511h = false;
    }

    public void setAutoRelease(boolean z) {
        this.i = z;
    }
}
