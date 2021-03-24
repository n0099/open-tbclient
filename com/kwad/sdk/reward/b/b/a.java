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
    public DetailVideoView f36252b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36253c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f36254d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36255e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36256f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f36257g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f36252b.getContext(), a.this.f36255e, new a.InterfaceC0378a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                public void a() {
                    a.this.e();
                }
            }, a.this.f36256f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36255e, 35, ((d) this).f36457a.f36223h.getTouchCoords(), ((d) this).f36457a.f36219d);
        ((d) this).f36457a.f36217b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36457a;
        this.f36255e = aVar.f36221f;
        this.f36256f = aVar.j;
        this.f36252b.setOnClickListener(this);
        this.f36254d.a(this.f36255e);
        this.f36253c.setOnClickListener(this);
        this.f36254d.setOnClickListener(this);
        this.f36252b.setClickListener(this.f36257g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36252b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36252b = (DetailVideoView) b(R.id.ksad_video_player);
        this.f36254d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f36253c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
