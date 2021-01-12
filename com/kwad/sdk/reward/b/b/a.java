package com.kwad.sdk.reward.b.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes4.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private DetailVideoView f10538b;
    private TextView c;
    private KsLogoView d;
    private AdTemplate e;
    private com.kwad.sdk.core.download.b.b f;
    private DetailVideoView.a g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f10538b.getContext(), a.this.e, new a.InterfaceC1088a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
                public void a() {
                    a.this.e();
                }
            }, a.this.f);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.e, 35, this.f10650a.h.getTouchCoords(), this.f10650a.d);
        this.f10650a.f10525b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f10650a.f;
        this.f = this.f10650a.j;
        this.f10538b.setOnClickListener(this);
        this.d.a(this.e);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f10538b.setClickListener(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10538b.setClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10538b = (DetailVideoView) b(R.id.ksad_video_player);
        this.d = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
        this.c = (TextView) b(R.id.ksad_video_count_down);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
