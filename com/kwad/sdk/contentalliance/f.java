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
/* loaded from: classes4.dex */
public class f extends AbstractKsContentPage {

    /* renamed from: a  reason: collision with root package name */
    private KsScene f8614a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<g> f8615b;
    private KsContentPage.PageListener c;
    private KsContentPage.VideoListener d;
    private List<KsContentPage.SubShowItem> e = new ArrayList();
    private a f;
    private boolean g;
    private String h;

    /* loaded from: classes4.dex */
    private static class a implements com.kwad.sdk.contentalliance.home.a.d {

        /* renamed from: a  reason: collision with root package name */
        private final KsContentPage.OnPageLoadListener f8616a;

        /* renamed from: b  reason: collision with root package name */
        private final KsContentPage f8617b;

        a(KsContentPage.OnPageLoadListener onPageLoadListener, KsContentPage ksContentPage) {
            this.f8616a = onPageLoadListener;
            this.f8617b = ksContentPage;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            if (this.f8616a != null) {
                this.f8616a.onLoadError(this.f8617b);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (this.f8616a != null) {
                this.f8616a.onLoadFinish(this.f8617b, i);
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            if (this.f8616a != null) {
                this.f8616a.onLoadStart(this.f8617b, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements KsContentPage.PageListener {

        /* renamed from: a  reason: collision with root package name */
        private final KsContentPage.PageListener f8618a;

        b(KsContentPage.PageListener pageListener) {
            this.f8618a = pageListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageEnter(KsContentPage.ContentItem contentItem) {
            if (this.f8618a == null) {
                return;
            }
            this.f8618a.onPageEnter(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageLeave(KsContentPage.ContentItem contentItem) {
            if (this.f8618a == null) {
                return;
            }
            this.f8618a.onPageLeave(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPagePause(KsContentPage.ContentItem contentItem) {
            if (this.f8618a == null) {
                return;
            }
            this.f8618a.onPagePause(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.PageListener
        public void onPageResume(KsContentPage.ContentItem contentItem) {
            if (this.f8618a == null) {
                return;
            }
            this.f8618a.onPageResume(contentItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements KsContentPage.VideoListener {

        /* renamed from: a  reason: collision with root package name */
        private final KsContentPage.VideoListener f8619a;

        private c(KsContentPage.VideoListener videoListener) {
            this.f8619a = videoListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayCompleted(KsContentPage.ContentItem contentItem) {
            if (this.f8619a == null) {
                return;
            }
            this.f8619a.onVideoPlayCompleted(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayError(KsContentPage.ContentItem contentItem, int i, int i2) {
            if (this.f8619a == null) {
                return;
            }
            this.f8619a.onVideoPlayError(contentItem, i, i2);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayPaused(KsContentPage.ContentItem contentItem) {
            if (this.f8619a == null) {
                return;
            }
            this.f8619a.onVideoPlayPaused(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayResume(KsContentPage.ContentItem contentItem) {
            if (this.f8619a == null) {
                return;
            }
            this.f8619a.onVideoPlayResume(contentItem);
        }

        @Override // com.kwad.sdk.api.KsContentPage.VideoListener
        public void onVideoPlayStart(KsContentPage.ContentItem contentItem) {
            if (this.f8619a == null) {
                return;
            }
            this.f8619a.onVideoPlayStart(contentItem);
        }
    }

    public f(KsScene ksScene) {
        this.f8614a = ksScene;
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
        g gVar = this.f8615b != null ? this.f8615b.get() : null;
        if (gVar != null) {
            gVar.a(aVar);
        } else {
            this.f = aVar;
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addSubItem(List<KsContentPage.SubShowItem> list) {
        g gVar = this.f8615b != null ? this.f8615b.get() : null;
        if (gVar != null) {
            gVar.a(list);
        } else {
            this.e.addAll(list);
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentPage
    @NonNull
    public KsFragment getFragment2() {
        g a2 = g.a(this.f8614a);
        this.f8615b = new WeakReference<>(a2);
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
        return a2 != null ? ((Integer) a2.getValue()).intValue() : com.kwad.sdk.core.config.c.a(this.f8614a.getPosId());
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
        if (this.f8615b == null || (gVar = this.f8615b.get()) == null) {
            return;
        }
        gVar.a();
    }
}
