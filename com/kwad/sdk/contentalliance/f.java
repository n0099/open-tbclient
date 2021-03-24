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
    public KsScene f32547a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<g> f32548b;

    /* renamed from: c  reason: collision with root package name */
    public KsContentPage.PageListener f32549c;

    /* renamed from: d  reason: collision with root package name */
    public KsContentPage.VideoListener f32550d;

    /* renamed from: e  reason: collision with root package name */
    public List<KsContentPage.SubShowItem> f32551e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public a f32552f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32553g;

    /* renamed from: h  reason: collision with root package name */
    public String f32554h;

    /* loaded from: classes6.dex */
    public static class a implements com.kwad.sdk.contentalliance.home.a.d {

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.OnPageLoadListener f32555a;

        /* renamed from: b  reason: collision with root package name */
        public final KsContentPage f32556b;

        public a(KsContentPage.OnPageLoadListener onPageLoadListener, KsContentPage ksContentPage) {
            this.f32555a = onPageLoadListener;
            this.f32556b = ksContentPage;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.f32555a;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadError(this.f32556b);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.f32555a;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadFinish(this.f32556b, i);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.f32555a;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadStart(this.f32556b, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements KsContentPage.PageListener {

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.PageListener f32557a;

        public b(KsContentPage.PageListener pageListener) {
            this.f32557a = pageListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageEnter(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f32557a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPageEnter(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageLeave(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f32557a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPageLeave(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPagePause(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f32557a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPagePause(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageResume(KsContentPage.ContentItem contentItem) {
            KsContentPage.PageListener pageListener = this.f32557a;
            if (pageListener == null) {
                return;
            }
            pageListener.onPageResume(contentItem);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements KsContentPage.VideoListener {

        /* renamed from: a  reason: collision with root package name */
        public final KsContentPage.VideoListener f32558a;

        public c(KsContentPage.VideoListener videoListener) {
            this.f32558a = videoListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayCompleted(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f32558a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayCompleted(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayError(KsContentPage.ContentItem contentItem, int i, int i2) {
            KsContentPage.VideoListener videoListener = this.f32558a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayError(contentItem, i, i2);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayPaused(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f32558a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayPaused(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayResume(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f32558a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayResume(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayStart(KsContentPage.ContentItem contentItem) {
            KsContentPage.VideoListener videoListener = this.f32558a;
            if (videoListener == null) {
                return;
            }
            videoListener.onVideoPlayStart(contentItem);
        }
    }

    public f(KsScene ksScene) {
        this.f32547a = ksScene;
    }

    private void a(@NonNull g gVar) {
        KsContentPage.PageListener pageListener = this.f32549c;
        if (pageListener != null) {
            gVar.a(new b(pageListener));
        } else {
            com.kwad.sdk.core.d.a.c("KsContentPage", "mPageListener is null");
        }
        KsContentPage.VideoListener videoListener = this.f32550d;
        if (videoListener != null) {
            gVar.a(new c(videoListener));
        } else {
            com.kwad.sdk.core.d.a.c("KsContentPage", "mVideoListener is null");
        }
    }

    public void a(String str) {
        this.f32554h = str;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addPageLoadListener(KsContentPage.OnPageLoadListener onPageLoadListener) {
        a aVar = new a(onPageLoadListener, this);
        WeakReference<g> weakReference = this.f32548b;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(aVar);
        } else {
            this.f32552f = aVar;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addSubItem(List<KsContentPage.SubShowItem> list) {
        WeakReference<g> weakReference = this.f32548b;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(list);
        } else {
            this.f32551e.addAll(list);
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentPage
    @NonNull
    public KsFragment getFragment2() {
        g a2 = g.a(this.f32547a);
        this.f32548b = new WeakReference<>(a2);
        a(a2);
        if (!this.f32551e.isEmpty()) {
            a2.a(this.f32551e);
            this.f32551e.clear();
        }
        a aVar = this.f32552f;
        if (aVar != null) {
            a2.a(aVar);
        }
        Bundle arguments = a2.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBoolean("KEY_INSERTAD_ENABLE", this.f32553g);
        arguments.putString("KEY_PushLINK", this.f32554h);
        return a2;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public int getSubCountInPage() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_SUBCOUNT");
        return a2 != null ? ((Integer) a2.getValue()).intValue() : com.kwad.sdk.core.config.c.a(this.f32547a.getPosId());
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setAddSubEnable(boolean z) {
        this.f32553g = z;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setPageListener(KsContentPage.PageListener pageListener) {
        this.f32549c = pageListener;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.f32550d = videoListener;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void tryToRefresh() {
        g gVar;
        WeakReference<g> weakReference = this.f32548b;
        if (weakReference == null || (gVar = weakReference.get()) == null) {
            return;
        }
        gVar.a();
    }
}
