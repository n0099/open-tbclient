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
    public DetailVideoView f36988b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36989c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f36990d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36991e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36992f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f36993g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f36988b.getContext(), a.this.f36991e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.e();
                }
            }, a.this.f36992f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36991e, 35, ((d) this).f37201a.f36957h.getTouchCoords(), ((d) this).f37201a.f36953d);
        ((d) this).f37201a.f36951b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        this.f36991e = aVar.f36955f;
        this.f36992f = aVar.j;
        this.f36988b.setOnClickListener(this);
        this.f36990d.a(this.f36991e);
        this.f36989c.setOnClickListener(this);
        this.f36990d.setOnClickListener(this);
        this.f36988b.setClickListener(this.f36993g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36988b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36988b = (DetailVideoView) b(R.id.ksad_video_player);
        this.f36990d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f36989c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
