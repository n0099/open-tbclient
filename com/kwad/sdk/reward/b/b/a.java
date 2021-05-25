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
    public DetailVideoView f33533b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33534c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f33535d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33536e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33537f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f33538g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f33533b.getContext(), a.this.f33536e, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    a.this.e();
                }
            }, a.this.f33537f, false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f33536e, 35, ((d) this).f33768a.f33497h.getTouchCoords(), ((d) this).f33768a.f33493d);
        ((d) this).f33768a.f33491b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        this.f33536e = aVar.f33495f;
        this.f33537f = aVar.j;
        this.f33533b.setOnClickListener(this);
        this.f33535d.a(this.f33536e);
        this.f33534c.setOnClickListener(this);
        this.f33535d.setOnClickListener(this);
        this.f33533b.setClickListener(this.f33538g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33533b = (DetailVideoView) a(R.id.ksad_video_player);
        this.f33535d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        this.f33534c = (TextView) a(R.id.ksad_video_count_down);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33533b.setClickListener(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
