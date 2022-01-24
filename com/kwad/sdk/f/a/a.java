package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aw;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56841b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f56842c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56843d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56844e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f56841b.getVisibility() != 0) {
            return;
        }
        this.f56841b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.c.b.a(this.f56841b.getContext()) || com.ksad.download.c.b.b(this.f56841b.getContext())) {
            this.f56841b.setVisibility(8);
            ((com.kwad.sdk.f.kwai.a) this).a.f56904d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f56843d.setText(aw.a(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f56904d)) * 1000));
            this.f56842c.setOnClickListener(this);
            ((com.kwad.sdk.f.kwai.a) this).a.f56904d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f56841b.setVisibility(0);
        }
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.a(this.f56844e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.b(this.f56844e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56841b = (ViewGroup) a(R.id.ksad_data_flow_container);
        this.f56842c = (ImageView) a(R.id.ksad_data_flow_play_btn);
        this.f56843d = (TextView) a(R.id.ksad_data_flow_play_tip);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56842c) {
            ((com.kwad.sdk.f.kwai.a) this).a.f56906f.f();
        }
    }
}
