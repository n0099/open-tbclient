package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aj;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f31717b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31718c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31719d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31720e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.a.1
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
        if (this.f31717b.getVisibility() != 0) {
            return;
        }
        this.f31717b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.d.b.a(this.f31717b.getContext()) || com.ksad.download.d.b.b(this.f31717b.getContext())) {
            this.f31717b.setVisibility(8);
            ((com.kwad.sdk.a.a.a) this).f31701a.f31705d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f31719d.setText(aj.a(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.a.a.a) this).f31701a.f31705d)) * 1000));
            this.f31718c.setOnClickListener(this);
            ((com.kwad.sdk.a.a.a) this).f31701a.f31705d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f31717b.setVisibility(0);
        }
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.a(this.f31720e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31717b = (ViewGroup) a(R.id.ksad_data_flow_container);
        this.f31718c = (ImageView) a(R.id.ksad_data_flow_play_btn);
        this.f31719d = (TextView) a(R.id.ksad_data_flow_play_tip);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31720e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31718c) {
            ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.f();
        }
    }
}
