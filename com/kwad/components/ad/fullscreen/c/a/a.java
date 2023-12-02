package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.br;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements br.a {
    public l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (!a.this.hi) {
                a.this.hh.sendEmptyMessageDelayed(1, 500L);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            if (a.this.qn.oI.jK()) {
                if (j2 > 800) {
                    a.this.hj = j2;
                    if (a.this.hj > j) {
                        a.this.hf.setVisibility(8);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.hg.getLayoutParams();
                        marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(a.this.getContext(), 0.0f);
                        a.this.hg.setLayoutParams(marginLayoutParams);
                    }
                    a.this.a(j, j2);
                    a.a(a.this, true);
                    return;
                }
                return;
            }
            a.this.a(j, j2);
            a.this.hj = j2;
        }
    };
    public TextView hf;
    public View hg;
    public br hh;
    public boolean hi;
    public long hj;
    public AdInfo mAdInfo;

    private void ca() {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        this.mAdInfo = dP;
        this.hf.setText(String.valueOf(com.kwad.sdk.core.response.b.a.L(dP)));
        this.hf.setVisibility(0);
        this.qn.oI.a(this.gO);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.hh = new br(this);
        ca();
        if (this.qn.oI.jK()) {
            x(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hf = (TextView) findViewById(R.id.obfuscated_res_0x7f0914f2);
        this.hg = findViewById(R.id.obfuscated_res_0x7f091503);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.gO);
        this.hi = false;
        this.hh.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        x(Math.max((int) ((((float) (j - j2)) / 1000.0f) + 0.5f), 0));
    }

    private void x(int i) {
        this.hf.setText(String.valueOf(i));
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.hi = true;
        return true;
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.qn.fK() && !this.qn.fJ()) {
                long j = this.hj + 500;
                this.hj = j;
                if (j > 30000) {
                    this.hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hg.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(getContext(), 0.0f);
                    this.hg.setLayoutParams(marginLayoutParams);
                    return;
                }
                a(30000L, j);
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
