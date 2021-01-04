package com.kwad.sdk.contentalliance.home;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.slide.LiveSlidHomeParam;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f9041a;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.PageListener f9042b;
    public KsContentPage.VideoListener c;
    @Nullable
    public LiveSlidHomeParam d;
    public com.kwad.sdk.contentalliance.home.swipe.c g;
    public i h;
    public SceneImpl k;
    public volatile boolean l;
    public List<com.kwad.sdk.contentalliance.trends.view.c> e = new ArrayList();
    public List<com.kwad.sdk.contentalliance.detail.photo.comment.g> f = new ArrayList();
    public boolean i = false;
    public boolean j = false;

    public void a() {
        if (this.f9041a != null) {
            this.f9041a.b();
            this.f9041a.f();
        }
        if (this.e != null) {
            this.e.clear();
        }
        if (this.f != null) {
            this.f.clear();
        }
    }

    public void b() {
        this.e.clear();
    }
}
