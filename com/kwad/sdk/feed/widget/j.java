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
/* loaded from: classes3.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements bc.a {

    /* renamed from: e  reason: collision with root package name */
    public View f56955e;

    /* renamed from: f  reason: collision with root package name */
    public final bc f56956f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f56957g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56958h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56959i;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f56956f = new bc(this);
        this.f56957g = new AtomicBoolean(true);
        this.f56959i = true;
        this.f56955e = this;
    }

    private void q() {
        if (this.f56957g.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewAttached");
            this.f56956f.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        if (!this.a && message.what == 1) {
            if (!bb.a(this.f56955e, 30)) {
                g();
            } else if (!this.f56958h) {
                f();
            }
            this.f56956f.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void m() {
        if (this.f56957g.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewDetached");
        this.f56956f.removeCallbacksAndMessages(null);
        if (this.f56959i) {
            h();
        } else {
            this.f56306d.c();
        }
    }

    public void n() {
        this.f56306d.c();
        this.f56958h = true;
    }

    public void o() {
        f();
        this.f56958h = false;
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
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void p() {
        this.f56958h = false;
    }

    public void setAutoRelease(boolean z) {
        this.f56959i = z;
    }
}
