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
    public DetailVideoView f36542b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36543c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f36544d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36545e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36546f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f36547g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f36542b.getContext(), a.this.f36545e, new a.InterfaceC0393a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    a.this.e();
                }
            }, a.this.f36546f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f36545e, 35, ((d) this).f36747a.f36513h.getTouchCoords(), ((d) this).f36747a.f36509d);
        ((d) this).f36747a.f36507b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36747a;
        this.f36545e = aVar.f36511f;
        this.f36546f = aVar.j;
        this.f36542b.setOnClickListener(this);
        this.f36544d.a(this.f36545e);
        this.f36543c.setOnClickListener(this);
        this.f36544d.setOnClickListener(this);
        this.f36542b.setClickListener(this.f36547g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36542b.setClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36542b = (DetailVideoView) b(R.id.ksad_video_player);
        this.f36544d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.f36543c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
