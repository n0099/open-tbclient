package com.kwad.sdk.contentalliance.tube.a;

import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f9207b;
    private TextView c;
    private TextView d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (this.f8693a.j.mIsTubeEpisodeList) {
            this.f9207b.setVisibility(0);
        } else {
            this.f9207b.setVisibility(8);
        }
        this.c.setText(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(this.f8693a.j)));
        this.d.setText(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(this.f8693a.j)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9207b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9207b = (ViewGroup) b(R.id.ksad_photo_tube_title_container);
        this.c = (TextView) b(R.id.ksad_content_alliance_tube_title);
        this.d = (TextView) b(R.id.ksad_content_alliance_tube_episode_name);
    }
}
