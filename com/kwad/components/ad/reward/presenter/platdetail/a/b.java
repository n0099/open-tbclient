package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    public l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.g(j2);
        }
    };
    public TextView hl;
    public long hn;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    private void ca() {
        this.mApkDownloadHelper = this.qn.mApkDownloadHelper;
        this.hn = com.kwad.sdk.core.response.b.d.dB(this.mAdTemplate);
        this.qn.oI.a(this.gO);
    }

    private void cb() {
        if (this.hl.getVisibility() == 0) {
            return;
        }
        this.hl.setText(com.kwad.sdk.core.response.b.d.dC(this.mAdTemplate));
        this.hl.setVisibility(0);
        this.hl.setOnClickListener(this);
        this.hl.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.this.cc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        this.qn.x("native_id");
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091347);
        this.hl = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.gO);
        this.hl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        if (j >= this.hn) {
            cb();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.hl) {
            this.qn.a(1, view2.getContext(), 40, 1, this.qn.oI.getPlayDuration());
        }
    }
}
