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
    public View f33164b;

    /* renamed from: c  reason: collision with root package name */
    public KSProfilePageLoadingView f33165c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.b f33166d;

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f33167e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView.a f33168f = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f33166d != null) {
                a.this.f33166d.a();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public b.a f33169g = new b.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.2
        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a() {
            a.this.f33165c.b();
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(int i, String str) {
            a.this.f33165c.a();
            if (com.kwad.sdk.core.network.f.f34158a.k == i) {
                a.this.f33165c.c();
            } else {
                a.this.f33165c.d();
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(UserProfile userProfile) {
            a.this.f33165c.a();
            a.this.f33164b.setVisibility(0);
            for (com.kwad.sdk.contentalliance.profile.home.a.a aVar : a.this.f33167e) {
                aVar.a(userProfile);
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void b() {
        }
    };

    private void e() {
        this.f33166d.a();
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a;
        this.f33167e = bVar.f33163f;
        ProfileHomeParam profileHomeParam = bVar.f33161d;
        SceneImpl sceneImpl = bVar.f33159b;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
        fVar.f33941b = sceneImpl.getPageScene();
        this.f33166d = new com.kwad.sdk.contentalliance.profile.home.b(fVar, profileHomeParam.mAuthorId, this.f33169g);
        e();
        this.f33165c.setRetryClickListener(this.f33168f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33166d.b();
        this.f33165c.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33164b = b(R.id.ksad_profile_view_pager);
        this.f33165c = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
    }
}
