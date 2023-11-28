package com.kwad.components.ad.splashscreen.c.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.splashscreen.c.e implements View.OnClickListener, com.kwad.sdk.widget.c {
    public CloseCountDownView EA;
    public ViewGroup EB;
    public ViewGroup ED;
    public ImageView EE;
    public TextView EF;
    public TextView EG;
    public CloseCountDownView.a EH = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.c.a.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void df() {
            y.a aVar = new y.a();
            com.kwad.components.ad.splashscreen.monitor.a.kM().l(c.this.Df.mAdTemplate);
            if (c.this.Df.mTimerHelper != null) {
                aVar.duration = c.this.Df.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.report.a.b(c.this.Df.mAdTemplate, new j().cB(1).a(aVar).cJ(6), (JSONObject) null);
            c.this.Df.kH();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void kU() {
            y.a aVar = new y.a();
            if (c.this.Df.mTimerHelper != null) {
                aVar.duration = c.this.Df.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.report.a.b(c.this.Df.mAdTemplate, new j().cB(14).a(aVar).cJ(6), (JSONObject) null);
            c.this.Df.kL();
        }
    };

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        t(view2);
    }

    private void t(View view2) {
        if (view2 == this.EB) {
            this.Df.c(2, view2.getContext(), 104, 2);
        } else if (view2 == this.ED) {
            this.Df.c(2, view2.getContext(), 26, 1);
        } else if (view2 == this.EE) {
            this.Df.c(2, view2.getContext(), 15, 2);
        } else if (view2 == this.EF) {
            this.Df.c(2, view2.getContext(), 16, 2);
        } else if (view2 == this.EG) {
            this.Df.c(2, view2.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        t(view2);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EA.setOnViewClickListener(this.EH);
        this.ED.setOnClickListener(this);
        new com.kwad.sdk.widget.f(this.ED.getContext(), this.ED, this);
        if (com.kwad.sdk.core.response.b.b.dc(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate))) {
            this.EB.setOnClickListener(this);
            this.EE.setOnClickListener(this);
            this.EF.setOnClickListener(this);
            this.EG.setOnClickListener(this);
            new com.kwad.sdk.widget.f(this.ED.getContext(), this.EB, this);
            new com.kwad.sdk.widget.f(this.ED.getContext(), this.EE, this);
            new com.kwad.sdk.widget.f(this.ED.getContext(), this.EF, this);
            new com.kwad.sdk.widget.f(this.ED.getContext(), this.EG, this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.EA = (CloseCountDownView) findViewById(R.id.obfuscated_res_0x7f0912e8);
        this.EB = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914ba);
        this.ED = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914bf);
        this.EE = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912e9);
        this.EF = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e6);
        this.EG = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e5);
    }
}
