package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public class ActionBarAppLandscape extends LinearLayout implements c {
    public AppScoreView Bq;
    public TextProgressBar Br;
    public View Bs;
    public a Bt;
    public KsAppDownloadListener cx;
    public ImageView dE;
    public TextView dF;
    public TextView dH;
    public TextView eF;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: classes10.dex */
    public interface a {
        void N(boolean z);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void b(View view2, final boolean z) {
        int i;
        boolean z2 = true;
        if (view2 == this.Bs) {
            i = 1;
        } else {
            i = 2;
        }
        a.C0644a b = new a.C0644a(view2.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper);
        if (view2 != this.Br) {
            z2 = false;
        }
        com.kwad.components.core.e.d.a.a(b.ao(z2).an(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.Bt != null) {
                    ActionBarAppLandscape.this.Bt.N(z);
                }
            }
        }));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppLandscape.this.Br.e(com.kwad.sdk.core.response.b.a.cR(i), i);
                    ActionBarAppLandscape.this.Bs.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.Br.e(com.kwad.sdk.core.response.b.a.cQ(i), i);
                    ActionBarAppLandscape.this.Bs.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.Br.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Bs.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.Br.e(com.kwad.sdk.core.response.b.a.bX(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.Bs.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.Br.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Bs.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.Br.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Bs.setVisibility(0);
                }
            };
        }
        return this.cx;
    }

    private void initView() {
        l.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0521, this);
        this.dE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091306);
        this.dF = (TextView) findViewById(R.id.obfuscated_res_0x7f09130a);
        this.eF = (TextView) findViewById(R.id.obfuscated_res_0x7f091302);
        this.Bq = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091309);
        this.dH = (TextView) findViewById(R.id.obfuscated_res_0x7f091305);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091304);
        this.Br = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 16.0f));
        this.Br.setTextColor(-1);
        this.Bs = findViewById(R.id.obfuscated_res_0x7f09134c);
    }

    private void kf() {
        boolean z;
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        if (aA >= 3.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.Bq.setScore(aA);
            this.Bq.setVisibility(0);
        }
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean isEmpty = true ^ TextUtils.isEmpty(az);
        if (isEmpty) {
            this.dH.setText(az);
            this.dH.setVisibility(0);
        }
        if (!isEmpty && !z) {
            this.eF.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.Bq.setVisibility(8);
            this.dH.setVisibility(8);
            this.eF.setVisibility(0);
            return;
        }
        this.eF.setVisibility(8);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (d.dE(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo dP = e.dP(adTemplate);
        this.mAdInfo = dP;
        this.Bt = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(dP), adTemplate, 12);
        this.dF.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
        kf();
        this.Br.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), 0);
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.Bs, this);
    }
}
