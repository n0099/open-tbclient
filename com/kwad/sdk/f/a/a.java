package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.aw;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40412b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f40413c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40414d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f40415e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.a.1
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
        if (this.f40412b.getVisibility() != 0) {
            return;
        }
        this.f40412b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.c.b.a(this.f40412b.getContext()) || com.ksad.download.c.b.b(this.f40412b.getContext())) {
            this.f40412b.setVisibility(8);
            ((com.kwad.sdk.f.kwai.a) this).a.f40469d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.f40414d.setText(aw.a(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.f40469d)) * 1000));
            this.f40413c.setOnClickListener(this);
            ((com.kwad.sdk.f.kwai.a) this).a.f40469d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f40412b.setVisibility(0);
        }
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.a(this.f40415e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f40471f.b(this.f40415e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40412b = (ViewGroup) a(R.id.obfuscated_res_0x7f091061);
        this.f40413c = (ImageView) a(R.id.obfuscated_res_0x7f091062);
        this.f40414d = (TextView) a(R.id.obfuscated_res_0x7f091063);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40413c) {
            ((com.kwad.sdk.f.kwai.a) this).a.f40471f.f();
        }
    }
}
