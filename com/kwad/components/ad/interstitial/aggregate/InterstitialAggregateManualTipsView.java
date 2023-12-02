package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.location.BDLocation;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    public ImageView iR;
    public ImageView iS;
    public ImageView iT;
    public int iU;
    public int iV;
    public final ViewPager.OnPageChangeListener iW;
    public TransViewPager iv;
    public AdTemplate mAdTemplate;
    public final Context mContext;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iW = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                InterstitialAggregateManualTipsView.this.iU = i2;
                if (InterstitialAggregateManualTipsView.this.iU == InterstitialAggregateManualTipsView.this.iV - 1) {
                    InterstitialAggregateManualTipsView.this.iR.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.iS.setAlpha(0.5f);
                    return;
                }
                InterstitialAggregateManualTipsView.this.iR.setAlpha(1.0f);
                InterstitialAggregateManualTipsView.this.iS.setAlpha(1.0f);
            }
        };
        this.mContext = context;
        initView();
    }

    private void cz() {
        int i = this.iU;
        if (i < this.iV - 1) {
            this.iv.setCurrentItem(i + 1, true);
        }
    }

    private void initView() {
        l.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04de, this);
        this.iR = (ImageView) findViewById(R.id.obfuscated_res_0x7f091381);
        this.iS = (ImageView) findViewById(R.id.obfuscated_res_0x7f091382);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091380);
        this.iT = imageView;
        com.kwad.sdk.d.a.a.a(this, this.iR, this.iS, imageView);
    }

    public final void a(@NonNull AdTemplate adTemplate, @NonNull TransViewPager transViewPager) {
        this.mAdTemplate = adTemplate;
        this.iv = transViewPager;
        this.iU = transViewPager.getCurrentItem();
        a aVar = (a) transViewPager.getAdapter();
        if (aVar == null) {
            return;
        }
        this.iV = aVar.getCount();
        new d(this.iv.getContext()).a(this.iv);
        this.iv.addOnPageChangeListener(this.iW);
        AdInfo dP = e.dP(adTemplate);
        String dm = com.kwad.sdk.core.response.b.b.dm(dP);
        String dn = com.kwad.sdk.core.response.b.b.dn(dP);
        String m182do = com.kwad.sdk.core.response.b.b.m182do(dP);
        if (!TextUtils.isEmpty(dm) && !TextUtils.isEmpty(dn) && !TextUtils.isEmpty(m182do)) {
            KSImageLoader.loadImage(this.iR, dm);
            KSImageLoader.loadImage(this.iS, dn);
            KSImageLoader.loadImage(this.iT, m182do);
            com.kwad.sdk.core.report.a.b(adTemplate, (int) BDLocation.TypeServerDecryptError, (JSONObject) null);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        com.kwad.components.ad.interstitial.g.c y;
        if (view2.equals(this.iR)) {
            cz();
            com.kwad.sdk.core.report.a.s(this.mAdTemplate, BDLocation.TypeServerDecryptError);
        } else if (view2.equals(this.iS)) {
            cz();
            com.kwad.sdk.core.report.a.s(this.mAdTemplate, 36);
        } else if (view2.equals(this.iT) && (y = this.iv.y(this.iU)) != null) {
            y.eb();
        }
    }
}
