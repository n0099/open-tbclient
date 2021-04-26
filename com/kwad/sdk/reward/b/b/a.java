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
    public DetailVideoView f34359b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34360c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f34361d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34362e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34363f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f34364g = new DetailVideoView.a() { // from class: com.kwad.sdk.reward.b.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
        public void b() {
            com.kwad.sdk.core.download.b.a.a(a.this.f34359b.getContext(), a.this.f34362e, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.b.b.a.1.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                public void a() {
                    a.this.e();
                }
            }, a.this.f34363f, false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f34362e, 35, ((d) this).f34594a.f34323h.getTouchCoords(), ((d) this).f34594a.f34319d);
        ((d) this).f34594a.f34317b.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        this.f34362e = aVar.f34321f;
        this.f34363f = aVar.j;
        this.f34359b.setOnClickListener(this);
        this.f34361d.a(this.f34362e);
        this.f34360c.setOnClickListener(this);
        this.f34361d.setOnClickListener(this);
        this.f34359b.setClickListener(this.f34364g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34359b = (DetailVideoView) a(R.id.ksad_video_player);
        this.f34361d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        this.f34360c = (TextView) a(R.id.ksad_video_count_down);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34359b.setClickListener(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
