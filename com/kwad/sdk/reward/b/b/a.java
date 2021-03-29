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
    public DetailVideoView f36253b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36254c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f36255d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36256e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36257f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f36258g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f36253b.getContext(), a.this.f36256e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.e();
                }
            }, a.this.f36257f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36256e, 35, ((d) this).f36458a.f36224h.getTouchCoords(), ((d) this).f36458a.f36220d);
        ((d) this).f36458a.f36218b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36458a;
        this.f36256e = aVar.f36222f;
        this.f36257f = aVar.j;
        this.f36253b.setOnClickListener(this);
        this.f36255d.a(this.f36256e);
        this.f36254c.setOnClickListener(this);
        this.f36255d.setOnClickListener(this);
        this.f36253b.setClickListener(this.f36258g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36253b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36253b = (DetailVideoView) b(R.id.ksad_video_player);
        this.f36255d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f36254c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
