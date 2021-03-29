package com.kwad.sdk.contentalliance.tube.a;

import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33131b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33132c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33133d;

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i;
        super.a();
        if (((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j.mIsTubeEpisodeList) {
            viewGroup = this.f33131b;
            i = 0;
        } else {
            viewGroup = this.f33131b;
            i = 8;
        }
        viewGroup.setVisibility(i);
        this.f33132c.setText(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j)));
        this.f33133d.setText(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33131b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33131b = (ViewGroup) b(R.id.ksad_photo_tube_title_container);
        this.f33132c = (TextView) b(R.id.ksad_content_alliance_tube_title);
        this.f33133d = (TextView) b(R.id.ksad_content_alliance_tube_episode_name);
    }
}
