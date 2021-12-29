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
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58978b;

    /* renamed from: c  reason: collision with root package name */
    public a f58979c;

    /* renamed from: d  reason: collision with root package name */
    public int f58980d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f58981e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58982f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58983g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f58984h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f58985i;

    /* loaded from: classes3.dex */
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

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(int i2, int i3) {
        d();
        ValueAnimator a2 = az.a(this, i2, i3);
        this.f58985i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f58985i.setDuration(300L);
        this.f58985i.start();
    }

    private void a(Context context) {
        this.a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f58981e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f58982f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f58983g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f58984h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f58985i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f58985i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f58978b = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        this.f58979c = aVar;
        this.f58982f.setText(com.kwad.sdk.core.response.a.a.s(j2));
        this.f58983g.setText(com.kwad.sdk.core.response.a.a.A(j2));
        this.f58981e.setOnClickListener(this);
        this.f58983g.setOnClickListener(this);
        this.f58984h.a(adTemplate);
        setOnClickListener(this);
        this.f58982f.measure(View.MeasureSpec.makeMeasureSpec((av.n(this.a) - (com.kwad.sdk.a.kwai.a.a(this.a, 16.0f) * 2)) - (com.kwad.sdk.a.kwai.a.a(this.a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f58980d = com.kwad.sdk.a.kwai.a.a(this.a, 100.0f) + this.f58982f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f58980d);
    }

    public void c() {
        a(this.f58980d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f58981e) {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(getContext()).a(this.f58978b).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardH5.this.f58979c != null) {
                        DrawCardH5.this.f58979c.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.f58979c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
