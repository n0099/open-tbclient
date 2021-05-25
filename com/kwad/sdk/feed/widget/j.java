package com.kwad.sdk.feed.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ao;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class j extends com.kwad.sdk.core.video.videoview.a implements ao.a {

    /* renamed from: b  reason: collision with root package name */
    public View f33232b;

    /* renamed from: c  reason: collision with root package name */
    public final ao f33233c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f33234d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33235e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33236f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33237g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f33238h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33239i;
    public String j;

    public j(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.d dVar) {
        super(context, adTemplate, dVar);
        this.f33233c = new ao(this);
        this.f33234d = new AtomicBoolean(true);
        this.f33236f = true;
        this.j = null;
        this.f33232b = this;
        this.f33238h = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33237g = g2;
        if (com.kwad.sdk.core.response.b.a.v(g2)) {
            this.f33239i = new com.kwad.sdk.core.download.b.b(this.f33238h, new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.j.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    j.this.j = com.kwad.sdk.core.response.b.a.b(i2);
                    j jVar = j.this;
                    jVar.a(jVar.j);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    j jVar = j.this;
                    jVar.j = com.kwad.sdk.core.response.b.a.u(jVar.f33237g);
                    j jVar2 = j.this;
                    jVar2.a(jVar2.j);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    j jVar = j.this;
                    jVar.j = com.kwad.sdk.core.response.b.a.a(jVar.f33238h);
                    j jVar2 = j.this;
                    jVar2.a(jVar2.j);
                }

                @Override // com.kwad.sdk.core.download.b.c, com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadStarted() {
                    j.this.j = com.kwad.sdk.core.response.b.a.a(0);
                    j jVar = j.this;
                    jVar.a(jVar.j);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    j jVar = j.this;
                    jVar.j = com.kwad.sdk.core.response.b.a.u(jVar.f33237g);
                    j jVar2 = j.this;
                    jVar2.a(jVar2.j);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    j jVar = j.this;
                    jVar.j = com.kwad.sdk.core.response.b.a.j(jVar.f33237g);
                    j jVar2 = j.this;
                    jVar2.a(jVar2.j);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    j.this.j = com.kwad.sdk.core.response.b.a.a(i2);
                    j jVar = j.this;
                    jVar.a(jVar.j);
                }
            });
        }
    }

    private void o() {
        if (this.f33234d.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewAttached");
            this.f33233c.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a
    public void a() {
        super.a();
        String str = this.j;
        if (str != null) {
            a(str);
        }
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        if (message.what == 1) {
            if (!an.a(this.f33232b, 30)) {
                f();
            } else if (!this.f33235e) {
                e();
            }
            this.f33233c.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public void k() {
        if (this.f33234d.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onViewDetached");
        this.f33233c.removeCallbacksAndMessages(null);
        if (this.f33236f) {
            g();
        } else {
            this.f32699a.c();
        }
    }

    public void l() {
        this.f32699a.c();
        this.f33235e = true;
    }

    public void m() {
        e();
        this.f33235e = false;
    }

    public void n() {
        this.f33235e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onAttachedToWindow");
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onDetachedFromWindow");
        k();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onFinishTemporaryDetach");
        o();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.a.c("FeedVideoPlayerController", "onStartTemporaryDetach");
        k();
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
        this.f33236f = z;
    }
}
