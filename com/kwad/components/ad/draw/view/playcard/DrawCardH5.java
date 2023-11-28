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
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.k;
/* loaded from: classes10.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public ValueAnimator du;
    public a dw;
    public ImageView dx;
    public TextView dy;
    public TextView dz;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public int mHeight;
    public KsLogoView mLogoView;

    /* loaded from: classes10.dex */
    public interface a {
        void av();

        void aw();
    }

    public DrawCardH5(Context context) {
        super(context);
        B(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.dx) {
            aQ();
            a aVar = this.dw;
            if (aVar != null) {
                aVar.av();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0644a(getContext()).aq(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardH5.this.dw != null) {
                    DrawCardH5.this.dw.aw();
                }
            }
        }));
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    private void d(int i, int i2) {
        aG();
        ValueAnimator b = n.b(this, i, i2);
        this.du = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.du.setDuration(300L);
        this.du.start();
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04c1, this);
        this.dx = (ImageView) findViewById(R.id.obfuscated_res_0x7f091323);
        this.dy = (TextView) findViewById(R.id.obfuscated_res_0x7f091319);
        this.dz = (TextView) findViewById(R.id.obfuscated_res_0x7f091325);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09135b);
    }

    private void aG() {
        ValueAnimator valueAnimator = this.du;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.du.cancel();
        }
    }

    private void aQ() {
        d(this.mHeight, 0);
    }

    public final void aO() {
        d(0, this.mHeight);
    }

    public final void release() {
        aG();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo dP = e.dP(adTemplate);
        this.dw = aVar;
        this.dy.setText(com.kwad.sdk.core.response.b.a.au(dP));
        this.dz.setText(com.kwad.sdk.core.response.b.a.aE(dP));
        this.dx.setOnClickListener(this);
        this.dz.setOnClickListener(this);
        this.mLogoView.aD(adTemplate);
        setOnClickListener(this);
        this.dy.measure(View.MeasureSpec.makeMeasureSpec((k.getScreenWidth(this.mContext) - (com.kwad.sdk.d.a.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.d.a.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.d.a.a.a(this.mContext, 100.0f) + this.dy.getMeasuredHeight();
    }
}
