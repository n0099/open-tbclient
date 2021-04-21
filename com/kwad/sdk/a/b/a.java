package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ai;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32064b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32065c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32066d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32067e = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.a.1
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
        if (this.f32064b.getVisibility() != 0) {
            return;
        }
        this.f32064b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.d.b.a(this.f32064b.getContext()) || com.ksad.download.d.b.b(this.f32064b.getContext())) {
            this.f32064b.setVisibility(8);
            ((com.kwad.sdk.a.a.a) this).f32049a.f32053d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f32066d.setText(ai.a(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f32049a.f32053d)) * 1000));
            this.f32065c.setOnClickListener(this);
            ((com.kwad.sdk.a.a.a) this).f32049a.f32053d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f32064b.setVisibility(0);
        }
        ((com.kwad.sdk.a.a.a) this).f32049a.f32055f.a(this.f32067e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32049a.f32055f.b(this.f32067e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32064b = (ViewGroup) b(R.id.ksad_data_flow_container);
        this.f32065c = (ImageView) b(R.id.ksad_data_flow_play_btn);
        this.f32066d = (TextView) b(R.id.ksad_data_flow_play_tip);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32065c) {
            ((com.kwad.sdk.a.a.a) this).f32049a.f32055f.f();
        }
    }
}
