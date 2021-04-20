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
/* loaded from: classes6.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    public View f35236b;

    /* renamed from: c  reason: collision with root package name */
    public final ap f35237c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f35238d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35239e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35240f;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f35237c = new ap(this);
        this.f35238d = new AtomicBoolean(true);
        this.f35240f = true;
        this.f35236b = this;
    }

    private void n() {
        if (this.f35238d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewAttached");
            this.f35237c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 1) {
            if (!ao.a(this.f35236b, 30)) {
                e();
            } else if (!this.f35239e) {
                d();
            }
            this.f35237c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void j() {
        if (this.f35238d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewDetached");
        this.f35237c.removeCallbacksAndMessages(null);
        if (this.f35240f) {
            f();
        } else {
            this.f34440a.c();
        }
    }

    public void k() {
        this.f34440a.c();
        this.f35239e = true;
    }

    public void l() {
        d();
        this.f35239e = false;
    }

    public void m() {
        this.f35239e = false;
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
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setAutoRelease(boolean z) {
        this.f35240f = z;
    }
}
