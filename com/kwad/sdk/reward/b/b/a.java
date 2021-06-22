package com.kwad.sdk.reward.b.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f37086b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37087c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f37088d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37089e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37090f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f37091g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f37086b.getContext(), a.this.f37089e, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    a.this.e();
                }
            }, a.this.f37090f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f37089e, 35, ((d) this).f37299a.f37055h.getTouchCoords(), ((d) this).f37299a.f37051d);
        ((d) this).f37299a.f37049b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f37299a;
        this.f37089e = aVar.f37053f;
        this.f37090f = aVar.j;
        this.f37086b.setOnClickListener(this);
        this.f37088d.a(this.f37089e);
        this.f37087c.setOnClickListener(this);
        this.f37088d.setOnClickListener(this);
        this.f37086b.setClickListener(this.f37091g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f37086b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37086b = (DetailVideoView) b(R.id.ksad_video_player);
        this.f37088d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f37087c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
