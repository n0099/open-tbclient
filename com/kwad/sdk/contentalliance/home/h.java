package com.kwad.sdk.contentalliance.home;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.slide.LiveSlidHomeParam;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32788a;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.PageListener f32789b;

    /* renamed from: c  reason: collision with root package name */
    public KsContentPage.VideoListener f32790c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public LiveSlidHomeParam f32791d;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f32794g;

    /* renamed from: h  reason: collision with root package name */
    public i f32795h;
    public SceneImpl k;
    public volatile boolean l;

    /* renamed from: e  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.trends.view.c> f32792e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.detail.photo.comment.g> f32793f = new ArrayList();
    public boolean i = false;
    public boolean j = false;

    public void a() {
        com.kwad.sdk.core.i.a aVar = this.f32788a;
        if (aVar != null) {
            aVar.b();
            this.f32788a.f();
        }
        List<com.kwad.sdk.contentalliance.trends.view.c> list = this.f32792e;
        if (list != null) {
            list.clear();
        }
        List<com.kwad.sdk.contentalliance.detail.photo.comment.g> list2 = this.f32793f;
        if (list2 != null) {
            list2.clear();
        }
    }

    public void b() {
        this.f32792e.clear();
    }
}
