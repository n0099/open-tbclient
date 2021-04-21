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
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f35001a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35002b;

    /* renamed from: c  reason: collision with root package name */
    public a f35003c;

    /* renamed from: d  reason: collision with root package name */
    public int f35004d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35005e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35006f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35007g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f35008h;
    public ValueAnimator i;

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

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(int i, int i2) {
        d();
        ValueAnimator a2 = am.a(this, i, i2);
        this.i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.i.setDuration(300L);
        this.i.start();
    }

    private void a(Context context) {
        this.f35001a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f35005e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f35006f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f35007g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f35008h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
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
        this.f35002b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f35003c = aVar;
        this.f35006f.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.f35007g.setText(com.kwad.sdk.core.response.b.a.w(j));
        this.f35005e.setOnClickListener(this);
        this.f35007g.setOnClickListener(this);
        this.f35008h.a(adTemplate);
        setOnClickListener(this);
        this.f35006f.measure(View.MeasureSpec.makeMeasureSpec((ah.g(this.f35001a) - (ao.a(this.f35001a, 16.0f) * 2)) - (ao.a(this.f35001a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f35004d = ao.a(this.f35001a, 100.0f) + this.f35006f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f35004d);
    }

    public void c() {
        a(this.f35004d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f35005e) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f35002b, new a.InterfaceC0396a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    if (DrawCardH5.this.f35003c != null) {
                        DrawCardH5.this.f35003c.b();
                    }
                }
            }, null);
            return;
        }
        c();
        a aVar = this.f35003c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
