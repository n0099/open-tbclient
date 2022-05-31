package com.kwad.sdk.draw.view.playcard;

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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public Context a;
    public AdTemplate b;
    public a c;
    public int d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public KsLogoView h;
    public ValueAnimator i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public DrawCardH5(Context context) {
        super(context);
        a(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(int i, int i2) {
        d();
        ValueAnimator a2 = az.a(this, i, i2);
        this.i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.i.setDuration(300L);
        this.i.start();
    }

    private void a(Context context) {
        this.a = context;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0414, this);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f09101d);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091013);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09101f);
        this.h = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091044);
    }

    private void d() {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.b = adTemplate;
        AdInfo j = d.j(adTemplate);
        this.c = aVar;
        this.f.setText(com.kwad.sdk.core.response.a.a.s(j));
        this.g.setText(com.kwad.sdk.core.response.a.a.A(j));
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.a(adTemplate);
        setOnClickListener(this);
        this.f.measure(View.MeasureSpec.makeMeasureSpec((av.n(this.a) - (com.kwad.sdk.a.kwai.a.a(this.a, 16.0f) * 2)) - (com.kwad.sdk.a.kwai.a.a(this.a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.d = com.kwad.sdk.a.kwai.a.a(this.a, 100.0f) + this.f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.d);
    }

    public void c() {
        a(this.d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != this.e) {
            com.kwad.sdk.core.download.a.a.a(new a.C0296a(getContext()).a(this.b).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardH5.this.c != null) {
                        DrawCardH5.this.c.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
