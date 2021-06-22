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
/* loaded from: classes7.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f35369a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35370b;

    /* renamed from: c  reason: collision with root package name */
    public a f35371c;

    /* renamed from: d  reason: collision with root package name */
    public int f35372d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35373e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35374f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35375g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f35376h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f35377i;

    /* loaded from: classes7.dex */
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
        this.f35377i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f35377i.setDuration(300L);
        this.f35377i.start();
    }

    private void a(Context context) {
        this.f35369a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f35373e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f35374f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f35375g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f35376h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f35377i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f35377i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f35370b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f35371c = aVar;
        this.f35374f.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.f35375g.setText(com.kwad.sdk.core.response.b.a.w(j));
        this.f35373e.setOnClickListener(this);
        this.f35375g.setOnClickListener(this);
        this.f35376h.a(adTemplate);
        setOnClickListener(this);
        this.f35374f.measure(View.MeasureSpec.makeMeasureSpec((ah.g(this.f35369a) - (ao.a(this.f35369a, 16.0f) * 2)) - (ao.a(this.f35369a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f35372d = ao.a(this.f35369a, 100.0f) + this.f35374f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f35372d);
    }

    public void c() {
        a(this.f35372d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f35373e) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f35370b, new a.InterfaceC0382a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                    if (DrawCardH5.this.f35371c != null) {
                        DrawCardH5.this.f35371c.b();
                    }
                }
            }, null);
            return;
        }
        c();
        a aVar = this.f35371c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
