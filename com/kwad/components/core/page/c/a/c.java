package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class c extends a {
    public LinearLayout OF;
    public TextView OG;
    public TextView OH;
    public TextView OI;
    public TextView OJ;
    public int OK;
    public boolean OL = false;
    public boolean OM = false;
    public Runnable ON = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.OL) {
                bn.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.OK > 0) {
                c.this.pl();
                bn.runOnUiThreadDelay(this, 1000L);
            } else {
                c.this.OG.setText("任务已完成");
                c.this.OH.setVisibility(8);
                c.this.OI.setVisibility(8);
                c.this.OJ.setVisibility(8);
                com.kwad.components.ad.b.g gVar = (com.kwad.components.ad.b.g) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.g.class);
                if (gVar != null && !c.this.OM) {
                    gVar.notifyRewardVerify();
                }
            }
            c.i(c.this);
        }
    };
    public final com.kwad.sdk.core.c.c wS = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.OL = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.OL = false;
        }
    };

    private void pk() {
        this.OF.setVisibility(0);
        if (this.Oy.mAdTemplate.mRewardVerifyCalled) {
            this.OG.setText("任务已完成");
            this.OH.setVisibility(8);
            this.OI.setVisibility(8);
            this.OJ.setVisibility(8);
            return;
        }
        pl();
        bn.runOnUiThreadDelay(this.ON, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl() {
        this.OH.setText(pm());
        this.OJ.setText(pn());
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v1 int)] */
    private String pm() {
        int i = this.OK / 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v1 int)] */
    private String pn() {
        int i = this.OK % 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(this.wS);
        this.OK = com.kwad.sdk.core.config.d.AW();
        pk();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.b(this.wS);
        bn.c(this.ON);
    }

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.OK;
        cVar.OK = i - 1;
        return i;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.OF = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091449);
        this.OG = (TextView) findViewById(R.id.obfuscated_res_0x7f091446);
        this.OH = (TextView) findViewById(R.id.obfuscated_res_0x7f091447);
        this.OI = (TextView) findViewById(R.id.obfuscated_res_0x7f091445);
        this.OJ = (TextView) findViewById(R.id.obfuscated_res_0x7f091448);
    }
}
