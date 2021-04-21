package com.kwad.sdk.contentalliance.profile.home.c;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.b;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSProfilePageLoadingView;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Set;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public View f33259b;

    /* renamed from: c  reason: collision with root package name */
    public KSProfilePageLoadingView f33260c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.b f33261d;

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f33262e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView.a f33263f = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f33261d != null) {
                a.this.f33261d.a();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public b.a f33264g = new b.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.2
        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a() {
            a.this.f33260c.b();
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(int i, String str) {
            a.this.f33260c.a();
            if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                a.this.f33260c.c();
            } else {
                a.this.f33260c.d();
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(UserProfile userProfile) {
            a.this.f33260c.a();
            a.this.f33259b.setVisibility(0);
            for (com.kwad.sdk.contentalliance.profile.home.a.a aVar : a.this.f33262e) {
                aVar.a(userProfile);
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void b() {
        }
    };

    private void e() {
        this.f33261d.a();
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a;
        this.f33262e = bVar.f33258f;
        ProfileHomeParam profileHomeParam = bVar.f33256d;
        SceneImpl sceneImpl = bVar.f33254b;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
        fVar.f34036b = sceneImpl.getPageScene();
        this.f33261d = new com.kwad.sdk.contentalliance.profile.home.b(fVar, profileHomeParam.mAuthorId, this.f33264g);
        e();
        this.f33260c.setRetryClickListener(this.f33263f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33261d.b();
        this.f33260c.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33259b = b(R.id.ksad_profile_view_pager);
        this.f33260c = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
    }
}
