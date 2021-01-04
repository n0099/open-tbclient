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
/* loaded from: classes5.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    private View f10172b;
    private final ap c;
    private final AtomicBoolean d;
    private boolean e;
    private boolean f;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.c = new ap(this);
        this.d = new AtomicBoolean(true);
        this.f = true;
        this.f10172b = this;
    }

    private void n() {
        if (this.d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewAttached");
            this.c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 1) {
            if (!ao.a(this.f10172b, 30)) {
                e();
            } else if (!this.e) {
                d();
            }
            this.c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    protected void j() {
        if (this.d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onViewDetached");
        this.c.removeCallbacksAndMessages(null);
        if (this.f) {
            f();
        } else {
            this.f9768a.c();
        }
    }

    public void k() {
        this.f9768a.c();
        this.e = true;
    }

    public void l() {
        d();
        this.e = false;
    }

    public void m() {
        this.e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.b("FeedVideoPlayerController", "onAttachedToWindow");
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
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
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoRelease(boolean z) {
        this.f = z;
    }
}
