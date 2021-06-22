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
    public com.kwad.sdk.core.i.a f33477a;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.PageListener f33478b;

    /* renamed from: c  reason: collision with root package name */
    public KsContentPage.VideoListener f33479c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public LiveSlidHomeParam f33480d;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f33483g;

    /* renamed from: h  reason: collision with root package name */
    public i f33484h;
    public SceneImpl k;
    public volatile boolean l;

    /* renamed from: e  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.trends.view.c> f33481e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.detail.photo.comment.g> f33482f = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f33485i = false;
    public boolean j = false;

    public void a() {
        com.kwad.sdk.core.i.a aVar = this.f33477a;
        if (aVar != null) {
            aVar.b();
            this.f33477a.f();
        }
        List<com.kwad.sdk.contentalliance.trends.view.c> list = this.f33481e;
        if (list != null) {
            list.clear();
        }
        List<com.kwad.sdk.contentalliance.detail.photo.comment.g> list2 = this.f33482f;
        if (list2 != null) {
            list2.clear();
        }
    }

    public void b() {
        this.f33481e.clear();
    }
}
