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
    public ViewGroup f59019b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59020c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59021d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59022e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.a.1
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
        if (this.f59019b.getVisibility() != 0) {
            return;
        }
        this.f59019b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.c.b.a(this.f59019b.getContext()) || com.ksad.download.c.b.b(this.f59019b.getContext())) {
            this.f59019b.setVisibility(8);
            ((com.kwad.sdk.f.kwai.a) this).a.f59084d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f59021d.setText(aw.a(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f59084d)) * 1000));
            this.f59020c.setOnClickListener(this);
            ((com.kwad.sdk.f.kwai.a) this).a.f59084d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f59019b.setVisibility(0);
        }
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.a(this.f59022e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.b(this.f59022e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59019b = (ViewGroup) a(R.id.ksad_data_flow_container);
        this.f59020c = (ImageView) a(R.id.ksad_data_flow_play_btn);
        this.f59021d = (TextView) a(R.id.ksad_data_flow_play_tip);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59020c) {
            ((com.kwad.sdk.f.kwai.a) this).a.f59086f.f();
        }
    }
}
