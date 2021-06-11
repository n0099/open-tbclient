package com.kwad.sdk.contentalliance.tube.a;

import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33741b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33742c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33743d;

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i2;
        super.a();
        if (((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j.mIsTubeEpisodeList) {
            viewGroup = this.f33741b;
            i2 = 0;
        } else {
            viewGroup = this.f33741b;
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
        this.f33742c.setText(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j)));
        this.f33743d.setText(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33741b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33741b = (ViewGroup) b(R.id.ksad_photo_tube_title_container);
        this.f33742c = (TextView) b(R.id.ksad_content_alliance_tube_title);
        this.f33743d = (TextView) b(R.id.ksad_content_alliance_tube_episode_name);
    }
}
