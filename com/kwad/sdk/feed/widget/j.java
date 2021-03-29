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
    public View f34947b;

    /* renamed from: c  reason: collision with root package name */
    public final ap f34948c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f34949d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34950e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34951f;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f34948c = new ap(this);
        this.f34949d = new AtomicBoolean(true);
        this.f34951f = true;
        this.f34947b = this;
    }

    private void n() {
        if (this.f34949d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewAttached");
            this.f34948c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 1) {
            if (!ao.a(this.f34947b, 30)) {
                e();
            } else if (!this.f34950e) {
                d();
            }
            this.f34948c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void j() {
        if (this.f34949d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewDetached");
        this.f34948c.removeCallbacksAndMessages(null);
        if (this.f34951f) {
            f();
        } else {
            this.f34151a.c();
        }
    }

    public void k() {
        this.f34151a.c();
        this.f34950e = true;
    }

    public void l() {
        d();
        this.f34950e = false;
    }

    public void m() {
        this.f34950e = false;
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
        this.f34951f = z;
    }
}
