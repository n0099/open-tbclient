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
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public class ActionBarAppPortrait extends LinearLayout implements c {
    public KsAppDownloadListener br;
    public ImageView cw;
    public TextView cx;
    public TextView cz;
    public TextView dh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public AppScoreView wH;
    public TextProgressBar wI;
    public View wJ;
    public a wM;

    /* loaded from: classes10.dex */
    public interface a {
        void R(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void b(View view2, final boolean z) {
        com.kwad.components.core.c.a.a.a(new a.C0619a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.wI).ae(view2 == this.wJ ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.wM != null) {
                    ActionBarAppPortrait.this.wM.R(z);
                }
            }
        }));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.br == null) {
            this.br = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.wI.f(com.kwad.sdk.core.response.a.a.al(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.wJ.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.wI.f(com.kwad.sdk.core.response.a.a.aJ(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.wJ.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.wI.f(com.kwad.sdk.core.response.a.a.al(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.wJ.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.wI.f(com.kwad.sdk.core.response.a.a.P(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.wJ.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    ActionBarAppPortrait.this.wI.f(com.kwad.sdk.core.response.a.a.aX(i), i);
                    ActionBarAppPortrait.this.wJ.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.wI.f(com.kwad.sdk.core.response.a.a.aW(i), i);
                    ActionBarAppPortrait.this.wJ.setVisibility(8);
                }
            };
        }
        return this.br;
    }

    private void initView() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04f8, this);
        this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091292);
        this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f091296);
        this.dh = (TextView) findViewById(R.id.obfuscated_res_0x7f09128e);
        this.wH = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091295);
        this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f091291);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091290);
        this.wI = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
        this.wI.setTextColor(-1);
        this.wJ = findViewById(R.id.obfuscated_res_0x7f0912c9);
    }

    private void jg() {
        String ah = com.kwad.sdk.core.response.a.a.ah(this.mAdInfo);
        boolean z = !TextUtils.isEmpty(ah);
        float ai = com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
        boolean z2 = ai >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.cx.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.wH.getLayoutParams()).bottomMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 1.0f);
            this.cz.setText(ah);
            this.cz.setVisibility(0);
            this.wH.setVisibility(0);
            this.wH.setScore(ai);
            this.dh.setVisibility(8);
        } else if (z) {
            this.cz.setText(ah);
            this.cz.setVisibility(0);
            this.wH.setVisibility(8);
            this.dh.setVisibility(8);
        } else if (z2) {
            this.cz.setVisibility(8);
            this.wH.setScore(ai);
            this.wH.setVisibility(0);
            this.dh.setVisibility(8);
        } else {
            this.dh.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
            this.cz.setVisibility(8);
            this.wH.setVisibility(8);
            this.dh.setVisibility(0);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = d.bQ(adTemplate);
        this.mAdInfo = bQ;
        this.wM = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(bQ), adTemplate, 12);
        this.cx.setText(com.kwad.sdk.core.response.a.a.bl(this.mAdInfo));
        jg();
        this.wI.f(com.kwad.sdk.core.response.a.a.al(this.mAdInfo), 0);
        com.kwad.components.core.c.a.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.wJ, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }
}
