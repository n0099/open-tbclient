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
    public AdTemplate f56801b;

    /* renamed from: c  reason: collision with root package name */
    public a f56802c;

    /* renamed from: d  reason: collision with root package name */
    public int f56803d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56804e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56805f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56806g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f56807h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f56808i;

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
        this.f56808i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f56808i.setDuration(300L);
        this.f56808i.start();
    }

    private void a(Context context) {
        this.a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f56804e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f56805f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f56806g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f56807h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f56808i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f56808i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f56801b = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        this.f56802c = aVar;
        this.f56805f.setText(com.kwad.sdk.core.response.a.a.s(j2));
        this.f56806g.setText(com.kwad.sdk.core.response.a.a.A(j2));
        this.f56804e.setOnClickListener(this);
        this.f56806g.setOnClickListener(this);
        this.f56807h.a(adTemplate);
        setOnClickListener(this);
        this.f56805f.measure(View.MeasureSpec.makeMeasureSpec((av.n(this.a) - (com.kwad.sdk.a.kwai.a.a(this.a, 16.0f) * 2)) - (com.kwad.sdk.a.kwai.a.a(this.a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f56803d = com.kwad.sdk.a.kwai.a.a(this.a, 100.0f) + this.f56805f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f56803d);
    }

    public void c() {
        a(this.f56803d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f56804e) {
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(getContext()).a(this.f56801b).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardH5.this.f56802c != null) {
                        DrawCardH5.this.f56802c.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.f56802c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
