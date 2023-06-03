package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.j;
/* loaded from: classes9.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public KsLogoView bq;
    public ValueAnimator cm;
    public a co;
    public ImageView cp;
    public TextView cq;
    public TextView cr;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public int mHeight;

    /* loaded from: classes9.dex */
    public interface a {
        void aC();

        void aD();
    }

    public DrawCardH5(Context context) {
        super(context);
        E(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        E(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        E(context);
    }

    private void E(Context context) {
        this.mContext = context;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0481, this);
        this.cp = (ImageView) findViewById(R.id.obfuscated_res_0x7f09124c);
        this.cq = (TextView) findViewById(R.id.obfuscated_res_0x7f091242);
        this.cr = (TextView) findViewById(R.id.obfuscated_res_0x7f09124e);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091277);
    }

    private void aL() {
        ValueAnimator valueAnimator = this.cm;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cm.cancel();
        }
    }

    private void aV() {
        d(this.mHeight, 0);
    }

    private void d(int i, int i2) {
        aL();
        ValueAnimator b = n.b(this, i, i2);
        this.cm = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cm.setDuration(300L);
        this.cm.start();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = d.bQ(adTemplate);
        this.co = aVar;
        this.cq.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
        this.cr.setText(com.kwad.sdk.core.response.a.a.al(bQ));
        this.cp.setOnClickListener(this);
        this.cr.setOnClickListener(this);
        this.bq.T(adTemplate);
        setOnClickListener(this);
        this.cq.measure(View.MeasureSpec.makeMeasureSpec((j.getScreenWidth(this.mContext) - (com.kwad.sdk.b.kwai.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.b.kwai.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.b.kwai.a.a(this.mContext, 100.0f) + this.cq.getMeasuredHeight();
    }

    public final void aT() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != this.cp) {
            com.kwad.components.core.c.a.a.a(new a.C0630a(getContext()).L(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    if (DrawCardH5.this.co != null) {
                        DrawCardH5.this.co.aD();
                    }
                }
            }));
            return;
        }
        aV();
        a aVar = this.co;
        if (aVar != null) {
            aVar.aC();
        }
    }

    public final void release() {
        aL();
    }
}
