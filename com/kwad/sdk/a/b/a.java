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
    public ViewGroup f31680b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31681c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31682d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31683e = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.a.1
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
        if (this.f31680b.getVisibility() != 0) {
            return;
        }
        this.f31680b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.d.b.a(this.f31680b.getContext()) || com.ksad.download.d.b.b(this.f31680b.getContext())) {
            this.f31680b.setVisibility(8);
            ((com.kwad.sdk.a.a.a) this).f31665a.f31669d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f31682d.setText(ai.a(com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.a.a.a) this).f31665a.f31669d)) * 1000));
            this.f31681c.setOnClickListener(this);
            ((com.kwad.sdk.a.a.a) this).f31665a.f31669d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f31680b.setVisibility(0);
        }
        ((com.kwad.sdk.a.a.a) this).f31665a.f31671f.a(this.f31683e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31665a.f31671f.b(this.f31683e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31680b = (ViewGroup) b(R.id.ksad_data_flow_container);
        this.f31681c = (ImageView) b(R.id.ksad_data_flow_play_btn);
        this.f31682d = (TextView) b(R.id.ksad_data_flow_play_tip);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31681c) {
            ((com.kwad.sdk.a.a.a) this).f31665a.f31671f.f();
        }
    }
}
