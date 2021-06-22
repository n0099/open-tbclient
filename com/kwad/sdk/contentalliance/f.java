package com.kwad.sdk.contentalliance;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.AbstractKsContentPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends AbstractKsContentPage {

    /* renamed from: a  reason: collision with root package name */
    public KsScene f33227a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<g> f33228b;

    /* renamed from: c  reason: collision with root package name */
    public KsContentPage.PageListener f33229c;

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.VideoListener f33230d;

    /* renamed from: e  reason: collision with root package name */
    public List<KsContentPage.SubShowItem> f33231e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public a f33232f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33233g;

    /* renamed from: h  reason: collision with root package name */
    public String f33234h;

    /* loaded from: classes6.dex */
    public static class a implements com.kwad.sdk.contentalliance.home.a.d {

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.OnPageLoadListener f33235a;

        /* renamed from: b  reason: collision with root package name */
        public final KsContentPage f33236b;

        public a(KsContentPage.OnPageLoadListener onPageLoadListener, KsContentPage ksContentPage) {
            this.f33235a = onPageLoadListener;
            this.f33236b = ksContentPage;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.f33235a;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadError(this.f33236b);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.f33235a;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadFinish(this.f33236b, i2);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i2, int i3) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.f33235a;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadStart(this.f33236b, i3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements KsContentPage.PageListener {

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.PageListener f33237a;

        public b(KsContentPage.PageListener pageListener) {
            this.f33237a = pageListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageEnter(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f33237a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPageEnter(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageLeave(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f33237a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPageLeave(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPagePause(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f33237a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPagePause(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageResume(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f33237a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPageResume(contentItem);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements KsContentPage.VideoListener {

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.VideoListener f33238a;

        public c(KsContentPage.VideoListener videoListener) {
            this.f33238a = videoListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayCompleted(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f33238a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayCompleted(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayError(KsContentPage.ContentItem contentItem, int i2, int i3) {
            KsContentPage.VideoListener videoListener = this.f33238a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayError(contentItem, i2, i3);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayPaused(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f33238a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayPaused(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayResume(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f33238a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayResume(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayStart(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f33238a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayStart(contentItem);
        }
    }

    public f(KsScene ksScene) {
        this.f33227a = ksScene;
    }

    private void a(@NonNull g gVar) {
        KsContentPage.PageListener pageListener = this.f33229c;
        if (pageListener != null) {
            gVar.a(new b(pageListener));
        } else {
            com.kwad.sdk.core.d.a.c("KsContentPage", "mPageListener is null");
        }
        KsContentPage.VideoListener videoListener = this.f33230d;
        if (videoListener != null) {
            gVar.a(new c(videoListener));
        } else {
            com.kwad.sdk.core.d.a.c("KsContentPage", "mVideoListener is null");
        }
    }

    public void a(String str) {
        this.f33234h = str;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addPageLoadListener(KsContentPage.OnPageLoadListener onPageLoadListener) {
        a aVar = new a(onPageLoadListener, this);
        WeakReference<g> weakReference = this.f33228b;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(aVar);
        } else {
            this.f33232f = aVar;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addSubItem(List<KsContentPage.SubShowItem> list) {
        WeakReference<g> weakReference = this.f33228b;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(list);
        } else {
            this.f33231e.addAll(list);
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentPage
    @NonNull
    public KsFragment getFragment2() {
        g a2 = g.a(this.f33227a);
        this.f33228b = new WeakReference<>(a2);
        a(a2);
        if (!this.f33231e.isEmpty()) {
            a2.a(this.f33231e);
            this.f33231e.clear();
        }
        a aVar = this.f33232f;
        if (aVar != null) {
            a2.a(aVar);
        }
        Bundle arguments = a2.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBoolean("KEY_INSERTAD_ENABLE", this.f33233g);
        arguments.putString("KEY_PushLINK", this.f33234h);
        return a2;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public int getSubCountInPage() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_SUBCOUNT");
        return a2 != null ? ((Integer) a2.getValue()).intValue() : com.kwad.sdk.core.config.c.a(this.f33227a.getPosId());
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setAddSubEnable(boolean z) {
        this.f33233g = z;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setPageListener(KsContentPage.PageListener pageListener) {
        this.f33229c = pageListener;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.f33230d = videoListener;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void tryToRefresh() {
        g gVar;
        WeakReference<g> weakReference = this.f33228b;
        if (weakReference == null || (gVar = weakReference.get()) == null) {
            return;
        }
        gVar.a();
    }
}
