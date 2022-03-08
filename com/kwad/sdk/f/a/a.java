package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.aw;
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55358b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f55359c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55360d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55361e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.a.1
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
        if (this.f55358b.getVisibility() != 0) {
            return;
        }
        this.f55358b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.c.b.a(this.f55358b.getContext()) || com.ksad.download.c.b.b(this.f55358b.getContext())) {
            this.f55358b.setVisibility(8);
            ((com.kwad.sdk.f.kwai.a) this).a.f55421d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f55360d.setText(aw.a(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f55421d)) * 1000));
            this.f55359c.setOnClickListener(this);
            ((com.kwad.sdk.f.kwai.a) this).a.f55421d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f55358b.setVisibility(0);
        }
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.a(this.f55361e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55361e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55358b = (ViewGroup) a(R.id.ksad_data_flow_container);
        this.f55359c = (ImageView) a(R.id.ksad_data_flow_play_btn);
        this.f55360d = (TextView) a(R.id.ksad_data_flow_play_tip);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55359c) {
            ((com.kwad.sdk.f.kwai.a) this).a.f55423f.f();
        }
    }
}
