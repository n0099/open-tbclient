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
    public View f33571b;

    /* renamed from: c  reason: collision with root package name */
    public KSProfilePageLoadingView f33572c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.b f33573d;

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f33574e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView.a f33575f = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f33573d != null) {
                a.this.f33573d.a();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public b.a f33576g = new b.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.a.2
        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a() {
            a.this.f33572c.b();
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(int i2, String str) {
            a.this.f33572c.a();
            if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                a.this.f33572c.c();
            } else {
                a.this.f33572c.d();
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void a(UserProfile userProfile) {
            a.this.f33572c.a();
            a.this.f33571b.setVisibility(0);
            for (com.kwad.sdk.contentalliance.profile.home.a.a aVar : a.this.f33574e) {
                aVar.a(userProfile);
            }
        }

        @Override // com.kwad.sdk.contentalliance.profile.home.b.a
        public void b() {
        }
    };

    private void e() {
        this.f33573d.a();
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33563a;
        this.f33574e = bVar.f33569f;
        ProfileHomeParam profileHomeParam = bVar.f33567d;
        SceneImpl sceneImpl = bVar.f33565b;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
        fVar.f34376b = sceneImpl.getPageScene();
        this.f33573d = new com.kwad.sdk.contentalliance.profile.home.b(fVar, profileHomeParam.mAuthorId, this.f33576g);
        e();
        this.f33572c.setRetryClickListener(this.f33575f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33573d.b();
        this.f33572c.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33571b = b(R.id.ksad_profile_view_pager);
        this.f33572c = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
    }
}
