package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.aw;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {
    public ViewGroup b;
    public ImageView c;
    public TextView d;
    public com.kwad.sdk.contentalliance.detail.video.d e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.a.1
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
        if (this.b.getVisibility() != 0) {
            return;
        }
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (!com.ksad.download.c.b.a(this.b.getContext()) || com.ksad.download.c.b.b(this.b.getContext())) {
            this.b.setVisibility(8);
            ((com.kwad.sdk.f.kwai.a) this).a.d.mVideoPlayerStatus.mVideoPlayerBehavior = 1;
        } else {
            this.d.setText(aw.a(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.f.kwai.a) this).a.d)) * 1000));
            this.c.setOnClickListener(this);
            ((com.kwad.sdk.f.kwai.a) this).a.d.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.b.setVisibility(0);
        }
        ((com.kwad.sdk.f.kwai.a) this).a.f.a(this.e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f09102c);
        this.c = (ImageView) a(R.id.obfuscated_res_0x7f09102d);
        this.d = (TextView) a(R.id.obfuscated_res_0x7f09102e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.c) {
            ((com.kwad.sdk.f.kwai.a) this).a.f.f();
        }
    }
}
