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
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class a extends LinearLayout {
    public View BA;
    public TextView CI;
    public TextView cz;
    public ImageView hF;
    public TextView hG;
    public ValueAnimator ju;
    public View un;
    public Button uo;
    public Button up;
    public KsAppTagsView uu;
    public com.kwad.components.ad.g.a ux;
    public Runnable uy;
    public AppScoreView wH;
    public TextProgressBar wZ;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.BA = LinearLayout.inflate(getContext(), getLayoutId(), this);
        this.hF = (ImageView) findViewById(R.id.obfuscated_res_0x7f091279);
        this.hG = (TextView) findViewById(R.id.obfuscated_res_0x7f09127b);
        this.wH = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f09127c);
        this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f091278);
        this.CI = (TextView) findViewById(R.id.obfuscated_res_0x7f09127a);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f0912af);
        this.wZ = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
        this.wZ.setTextColor(-1);
        this.uu = (KsAppTagsView) findViewById(R.id.obfuscated_res_0x7f091374);
        this.uo = (Button) findViewById(R.id.obfuscated_res_0x7f09136e);
        this.up = (Button) findViewById(R.id.obfuscated_res_0x7f091370);
        this.un = findViewById(R.id.obfuscated_res_0x7f09136f);
        this.ux = new com.kwad.components.ad.g.a(this.BA);
    }

    private void ld() {
        ValueAnimator valueAnimator = this.ju;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.ju = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.ju.setRepeatCount(-1);
            this.ju.setRepeatMode(1);
            this.ju.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    a.this.wZ.setScaleY(floatValue);
                    a.this.wZ.setScaleX(floatValue);
                }
            });
            this.ju.start();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0091: INVOKE  (r5v0 int A[REMOVE]) =  type: STATIC call: com.kwad.sdk.core.config.d.sf():int)] */
    public void c(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String bn;
        AdInfo bQ = d.bQ(adTemplate);
        if (d.p(adTemplate)) {
            imageView = this.hF;
            bn = com.kwad.sdk.core.response.a.a.bI(bQ);
        } else {
            imageView = this.hF;
            bn = com.kwad.sdk.core.response.a.a.bn(bQ);
        }
        KSImageLoader.loadAppIcon(imageView, bn, adTemplate, 12);
        this.hG.setText(com.kwad.sdk.core.response.a.a.bl(bQ));
        if (!d.p(adTemplate)) {
            float ai = com.kwad.sdk.core.response.a.a.ai(bQ);
            if (ai >= 3.0f) {
                this.wH.setScore(ai);
                this.wH.setVisibility(0);
            } else {
                this.wH.setVisibility(8);
            }
            String ah = com.kwad.sdk.core.response.a.a.ah(bQ);
            if (TextUtils.isEmpty(ah)) {
                this.cz.setVisibility(8);
            } else {
                this.cz.setText(ah);
                this.cz.setVisibility(0);
            }
        }
        this.CI.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
        if (d.p(adTemplate)) {
            this.wZ.setVisibility(8);
            this.un.setVisibility(0);
            this.up.setText("查看详情");
            Button button = this.uo;
            StringBuilder sb = new StringBuilder();
            sb.append(com.kwad.sdk.core.config.d.sf());
            button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
            if (!adTemplate.mRewardVerifyCalled) {
                if (this.uy == null) {
                    this.uy = new Runnable() { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.ux.kL();
                        }
                    };
                }
                this.un.postDelayed(this.uy, 1600L);
            }
        } else {
            this.wZ.setVisibility(0);
            this.un.setVisibility(8);
            Runnable runnable = this.uy;
            if (runnable != null) {
                this.un.removeCallbacks(runnable);
                this.uy = null;
            }
            u(d.bQ(adTemplate));
        }
        if (d.p(adTemplate)) {
            List<String> bH = c.bH(adTemplate);
            if (bH.size() > 0) {
                this.uu.setVisibility(0);
            } else {
                this.uu.setVisibility(8);
            }
            this.uu.setAppTags(bH);
        }
    }

    public View getBtnInstallContainer() {
        return this.un;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        return this.wZ;
    }

    public final void jl() {
        ValueAnimator valueAnimator = this.ju;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ju.cancel();
            this.ju.end();
        }
        Runnable runnable = this.uy;
        if (runnable != null) {
            this.un.removeCallbacks(runnable);
            this.uy = null;
        }
        this.ux.kM();
    }

    public final void u(@NonNull AdInfo adInfo) {
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            jl();
        } else {
            ld();
        }
    }
}
