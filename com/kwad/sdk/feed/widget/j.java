package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes7.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    public View f35715b;

    /* renamed from: c  reason: collision with root package name */
    public final ap f35716c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f35717d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35718e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35719f;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f35716c = new ap(this);
        this.f35717d = new AtomicBoolean(true);
        this.f35719f = true;
        this.f35715b = this;
    }

    private void n() {
        if (this.f35717d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewAttached");
            this.f35716c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 1) {
            if (!ao.a(this.f35715b, 30)) {
                e();
            } else if (!this.f35718e) {
                d();
            }
            this.f35716c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void j() {
        if (this.f35717d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewDetached");
        this.f35716c.removeCallbacksAndMessages(null);
        if (this.f35719f) {
            f();
        } else {
            this.f34889a.c();
        }
    }

    public void k() {
        this.f34889a.c();
        this.f35718e = true;
    }

    public void l() {
        d();
        this.f35718e = false;
    }

    public void m() {
        this.f35718e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onAttachedToWindow");
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onDetachedFromWindow");
        j();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onFinishTemporaryDetach");
        n();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onStartTemporaryDetach");
        j();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setAutoRelease(boolean z) {
        this.f35719f = z;
    }
}
