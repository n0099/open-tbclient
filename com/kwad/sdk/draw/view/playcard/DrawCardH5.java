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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f33218a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f33219b;

    /* renamed from: c  reason: collision with root package name */
    public a f33220c;

    /* renamed from: d  reason: collision with root package name */
    public int f33221d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33222e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33223f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33224g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f33225h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f33226i;

    /* loaded from: classes6.dex */
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
        ValueAnimator a2 = am.a(this, i2, i3);
        this.f33226i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f33226i.setDuration(300L);
        this.f33226i.start();
    }

    private void a(Context context) {
        this.f33218a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f33222e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f33223f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f33224g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f33225h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f33226i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f33226i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f33219b = adTemplate;
        AdInfo g2 = c.g(adTemplate);
        this.f33220c = aVar;
        this.f33223f.setText(com.kwad.sdk.core.response.b.a.m(g2));
        this.f33224g.setText(com.kwad.sdk.core.response.b.a.u(g2));
        this.f33222e.setOnClickListener(this);
        this.f33224g.setOnClickListener(this);
        this.f33225h.a(adTemplate);
        setOnClickListener(this);
        this.f33223f.measure(View.MeasureSpec.makeMeasureSpec((ai.i(this.f33218a) - (an.a(this.f33218a, 16.0f) * 2)) - (an.a(this.f33218a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f33221d = an.a(this.f33218a, 100.0f) + this.f33223f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f33221d);
    }

    public void c() {
        a(this.f33221d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f33222e) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f33219b, new a.InterfaceC0363a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
                public void a() {
                    if (DrawCardH5.this.f33220c != null) {
                        DrawCardH5.this.f33220c.b();
                    }
                }
            }, null, view == this.f33224g);
            return;
        }
        c();
        a aVar = this.f33220c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
