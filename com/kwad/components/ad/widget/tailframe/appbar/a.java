package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a extends LinearLayout {
    public TextProgressBar BG;
    public AppScoreView Bq;
    public View Hg;
    public TextView Iq;
    public TextView dH;
    public ValueAnimator jo;
    public ImageView kS;
    public TextView kT;
    public View xZ;
    public Button ya;
    public Button yb;
    public KsAppTagsView yh;
    public com.kwad.components.ad.i.a yk;
    public Runnable yl;

    @LayoutRes
    public abstract int getLayoutId();

    public a(Context context) {
        this(context, null);
    }

    public final void D(@NonNull AdInfo adInfo) {
        int i = adInfo.status;
        if (i != 1 && i != 2 && i != 3) {
            mj();
        } else {
            kk();
        }
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        initView();
    }

    private void initView() {
        this.Hg = l.inflate(getContext(), getLayoutId(), this);
        this.kS = (ImageView) findViewById(R.id.obfuscated_res_0x7f091307);
        this.kT = (TextView) findViewById(R.id.obfuscated_res_0x7f091309);
        this.Bq = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f09130a);
        this.dH = (TextView) findViewById(R.id.obfuscated_res_0x7f091306);
        this.Iq = (TextView) findViewById(R.id.obfuscated_res_0x7f091308);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09134c);
        this.BG = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.d.a.a.a(getContext(), 16.0f));
        this.BG.setTextColor(-1);
        this.yh = (KsAppTagsView) findViewById(R.id.obfuscated_res_0x7f09141d);
        this.ya = (Button) findViewById(R.id.obfuscated_res_0x7f091417);
        this.yb = (Button) findViewById(R.id.obfuscated_res_0x7f091419);
        this.xZ = findViewById(R.id.obfuscated_res_0x7f091418);
        this.yk = new com.kwad.components.ad.i.a(this.Hg);
    }

    private void mj() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.jo = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.jo.setRepeatCount(-1);
        this.jo.setRepeatMode(1);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                a.this.BG.setScaleY(floatValue);
                a.this.BG.setScaleX(floatValue);
            }
        });
        this.jo.start();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0094: INVOKE  (r5v0 int A[REMOVE]) =  type: STATIC call: com.kwad.sdk.core.config.d.AW():int)] */
    public void b(@NonNull AdTemplate adTemplate) {
        boolean z;
        AdInfo dP = e.dP(adTemplate);
        if (e.F(adTemplate)) {
            KSImageLoader.loadAppIcon(this.kS, com.kwad.sdk.core.response.b.a.cG(dP), adTemplate, 12);
        } else {
            KSImageLoader.loadAppIcon(this.kS, com.kwad.sdk.core.response.b.a.cf(dP), adTemplate, 12);
        }
        this.kT.setText(com.kwad.sdk.core.response.b.a.cc(dP));
        if (!e.F(adTemplate)) {
            float aA = com.kwad.sdk.core.response.b.a.aA(dP);
            if (aA >= 3.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.Bq.setScore(aA);
                this.Bq.setVisibility(0);
            } else {
                this.Bq.setVisibility(8);
            }
            String az = com.kwad.sdk.core.response.b.a.az(dP);
            if (!TextUtils.isEmpty(az)) {
                this.dH.setText(az);
                this.dH.setVisibility(0);
            } else {
                this.dH.setVisibility(8);
            }
        }
        this.Iq.setText(com.kwad.sdk.core.response.b.a.au(dP));
        if (e.F(adTemplate)) {
            this.BG.setVisibility(8);
            this.xZ.setVisibility(0);
            this.yb.setText("查看详情");
            Button button = this.ya;
            StringBuilder sb = new StringBuilder();
            sb.append(d.AW());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.yl == null) {
                    this.yl = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.yk.hR();
                        }
                    };
                }
                this.xZ.postDelayed(this.yl, 1600L);
            }
        } else {
            this.BG.setVisibility(0);
            this.xZ.setVisibility(8);
            Runnable runnable = this.yl;
            if (runnable != null) {
                this.xZ.removeCallbacks(runnable);
                this.yl = null;
            }
            D(e.dP(adTemplate));
        }
        if (e.F(adTemplate)) {
            List<String> dG = com.kwad.sdk.core.response.b.d.dG(adTemplate);
            if (dG.size() > 0) {
                this.yh.setVisibility(0);
            } else {
                this.yh.setVisibility(8);
            }
            this.yh.setAppTags(dG);
        }
    }

    public View getBtnInstallContainer() {
        return this.xZ;
    }

    public TextProgressBar getTextProgressBar() {
        return this.BG;
    }

    public final void kk() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.jo.cancel();
            this.jo.end();
        }
        Runnable runnable = this.yl;
        if (runnable != null) {
            this.xZ.removeCallbacks(runnable);
            this.yl = null;
        }
        this.yk.lU();
    }
}
