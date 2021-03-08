package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.a.a.a implements View.OnClickListener {
    private ViewGroup b;
    private ImageView c;
    private TextView d;
    private com.kwad.sdk.contentalliance.detail.video.e e = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            a.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.b.getVisibility() != 0) {
            return;
        }
        this.b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.d.b.a(this.b.getContext()) || com.ksad.download.d.b.b(this.b.getContext())) {
            this.b.setVisibility(8);
            this.f5425a.d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.d.setText(ai.a(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f5425a.d)) * 1000));
            this.c.setOnClickListener(this);
            this.f5425a.d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.b.setVisibility(0);
        }
        this.f5425a.f.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5425a.f.b(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ViewGroup) b(R.id.ksad_data_flow_container);
        this.c = (ImageView) b(R.id.ksad_data_flow_play_btn);
        this.d = (TextView) b(R.id.ksad_data_flow_play_tip);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c) {
            this.f5425a.f.f();
        }
    }
}
