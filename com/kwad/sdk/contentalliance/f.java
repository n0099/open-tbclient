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
/* loaded from: classes5.dex */
public class f extends AbstractKsContentPage {

    /* renamed from: a  reason: collision with root package name */
    private KsScene f8914a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<g> f8915b;
    private KsContentPage.PageListener c;
    private KsContentPage.VideoListener d;
    private List<KsContentPage.SubShowItem> e = new ArrayList();
    private a f;
    private boolean g;
    private String h;

    /* loaded from: classes5.dex */
    private static class a implements com.kwad.sdk.contentalliance.home.a.d {

        /* renamed from: a  reason: collision with root package name */
        private final KsContentPage.OnPageLoadListener f8916a;

        /* renamed from: b  reason: collision with root package name */
        private final KsContentPage f8917b;

        a(KsContentPage.OnPageLoadListener onPageLoadListener, KsContentPage ksContentPage) {
            this.f8916a = onPageLoadListener;
            this.f8917b = ksContentPage;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            if (this.f8916a != null) {
                this.f8916a.onLoadError(this.f8917b);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (this.f8916a != null) {
                this.f8916a.onLoadFinish(this.f8917b, i);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            if (this.f8916a != null) {
                this.f8916a.onLoadStart(this.f8917b, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements KsContentPage.PageListener {

        /* renamed from: a  reason: collision with root package name */
        private final KsContentPage.PageListener f8918a;

        b(KsContentPage.PageListener pageListener) {
            this.f8918a = pageListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageEnter(KsContentPage.ContentItem contentItem) {
            if (this.f8918a == null) {
                return;
            }
            this.f8918a.onPageEnter(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageLeave(KsContentPage.ContentItem contentItem) {
            if (this.f8918a == null) {
                return;
            }
            this.f8918a.onPageLeave(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPagePause(KsContentPage.ContentItem contentItem) {
            if (this.f8918a == null) {
                return;
            }
            this.f8918a.onPagePause(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageResume(KsContentPage.ContentItem contentItem) {
            if (this.f8918a == null) {
                return;
            }
            this.f8918a.onPageResume(contentItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c implements KsContentPage.VideoListener {

        /* renamed from: a  reason: collision with root package name */
        private final KsContentPage.VideoListener f8919a;

        private c(KsContentPage.VideoListener videoListener) {
            this.f8919a = videoListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayCompleted(KsContentPage.ContentItem contentItem) {
            if (this.f8919a == null) {
                return;
            }
            this.f8919a.onVideoPlayCompleted(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayError(KsContentPage.ContentItem contentItem, int i, int i2) {
            if (this.f8919a == null) {
                return;
            }
            this.f8919a.onVideoPlayError(contentItem, i, i2);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayPaused(KsContentPage.ContentItem contentItem) {
            if (this.f8919a == null) {
                return;
            }
            this.f8919a.onVideoPlayPaused(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayResume(KsContentPage.ContentItem contentItem) {
            if (this.f8919a == null) {
                return;
            }
            this.f8919a.onVideoPlayResume(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayStart(KsContentPage.ContentItem contentItem) {
            if (this.f8919a == null) {
                return;
            }
            this.f8919a.onVideoPlayStart(contentItem);
        }
    }

    public f(KsScene ksScene) {
        this.f8914a = ksScene;
    }

    private void a(@NonNull g gVar) {
        if (this.c != null) {
            gVar.a(new b(this.c));
        } else {
            com.kwad.sdk.core.d.a.c("KsContentPage", "mPageListener is null");
        }
        if (this.d != null) {
            gVar.a(new c(this.d));
        } else {
            com.kwad.sdk.core.d.a.c("KsContentPage", "mVideoListener is null");
        }
    }

    public void a(String str) {
        this.h = str;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addPageLoadListener(KsContentPage.OnPageLoadListener onPageLoadListener) {
        a aVar = new a(onPageLoadListener, this);
        g gVar = this.f8915b != null ? this.f8915b.get() : null;
        if (gVar != null) {
            gVar.a(aVar);
        } else {
            this.f = aVar;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addSubItem(List<KsContentPage.SubShowItem> list) {
        g gVar = this.f8915b != null ? this.f8915b.get() : null;
        if (gVar != null) {
            gVar.a(list);
        } else {
            this.e.addAll(list);
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentPage
    @NonNull
    public KsFragment getFragment2() {
        g a2 = g.a(this.f8914a);
        this.f8915b = new WeakReference<>(a2);
        a(a2);
        if (!this.e.isEmpty()) {
            a2.a(this.e);
            this.e.clear();
        }
        if (this.f != null) {
            a2.a(this.f);
        }
        Bundle arguments = a2.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBoolean("KEY_INSERTAD_ENABLE", this.g);
        arguments.putString("KEY_PushLINK", this.h);
        return a2;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public int getSubCountInPage() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_SUBCOUNT");
        return a2 != null ? ((Integer) a2.getValue()).intValue() : com.kwad.sdk.core.config.c.a(this.f8914a.getPosId());
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setAddSubEnable(boolean z) {
        this.g = z;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setPageListener(KsContentPage.PageListener pageListener) {
        this.c = pageListener;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.d = videoListener;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void tryToRefresh() {
        g gVar;
        if (this.f8915b == null || (gVar = this.f8915b.get()) == null) {
            return;
        }
        gVar.a();
    }
}
