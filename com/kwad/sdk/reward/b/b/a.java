package com.kwad.sdk.reward.b.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f36637b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36638c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f36639d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36640e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36641f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f36642g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f36637b.getContext(), a.this.f36640e, new a.InterfaceC0396a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    a.this.e();
                }
            }, a.this.f36641f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36640e, 35, ((d) this).f36842a.f36608h.getTouchCoords(), ((d) this).f36842a.f36604d);
        ((d) this).f36842a.f36602b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36842a;
        this.f36640e = aVar.f36606f;
        this.f36641f = aVar.j;
        this.f36637b.setOnClickListener(this);
        this.f36639d.a(this.f36640e);
        this.f36638c.setOnClickListener(this);
        this.f36639d.setOnClickListener(this);
        this.f36637b.setClickListener(this.f36642g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36637b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36637b = (DetailVideoView) b(R.id.ksad_video_player);
        this.f36639d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f36638c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
