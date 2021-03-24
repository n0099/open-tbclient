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
    public View f32874b;

    /* renamed from: c  reason: collision with root package name */
    public KSProfilePageLoadingView f32875c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.b f32876d;

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f32877e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView.a f32878f = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f32876d != null) {
                a.this.f32876d.a();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public b.a f32879g = new b.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.2
        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a() {
            a.this.f32875c.b();
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(int i, String str) {
            a.this.f32875c.a();
            if (com.kwad.sdk.core.network.f.f33868a.k == i) {
                a.this.f32875c.c();
            } else {
                a.this.f32875c.d();
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(UserProfile userProfile) {
            a.this.f32875c.a();
            a.this.f32874b.setVisibility(0);
            for (com.kwad.sdk.contentalliance.profile.home.a.a aVar : a.this.f32877e) {
                aVar.a(userProfile);
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void b() {
        }
    };

    private void e() {
        this.f32876d.a();
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a;
        this.f32877e = bVar.f32873f;
        ProfileHomeParam profileHomeParam = bVar.f32871d;
        SceneImpl sceneImpl = bVar.f32869b;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
        fVar.f33651b = sceneImpl.getPageScene();
        this.f32876d = new com.kwad.sdk.contentalliance.profile.home.b(fVar, profileHomeParam.mAuthorId, this.f32879g);
        e();
        this.f32875c.setRetryClickListener(this.f32878f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32876d.b();
        this.f32875c.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32874b = b(R.id.ksad_profile_view_pager);
        this.f32875c = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
    }
}
