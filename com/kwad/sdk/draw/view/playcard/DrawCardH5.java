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
    public Context f35271a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35272b;

    /* renamed from: c  reason: collision with root package name */
    public a f35273c;

    /* renamed from: d  reason: collision with root package name */
    public int f35274d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35275e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35276f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35277g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f35278h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f35279i;

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
        this.f35279i = a2;
        a2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f35279i.setDuration(300L);
        this.f35279i.start();
    }

    private void a(Context context) {
        this.f35271a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f35275e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f35276f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f35277g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f35278h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f35279i;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f35279i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f35272b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f35273c = aVar;
        this.f35276f.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.f35277g.setText(com.kwad.sdk.core.response.b.a.w(j));
        this.f35275e.setOnClickListener(this);
        this.f35277g.setOnClickListener(this);
        this.f35278h.a(adTemplate);
        setOnClickListener(this);
        this.f35276f.measure(View.MeasureSpec.makeMeasureSpec((ah.g(this.f35271a) - (ao.a(this.f35271a, 16.0f) * 2)) - (ao.a(this.f35271a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f35274d = ao.a(this.f35271a, 100.0f) + this.f35276f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f35274d);
    }

    public void c() {
        a(this.f35274d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f35275e) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f35272b, new a.InterfaceC0379a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    if (DrawCardH5.this.f35273c != null) {
                        DrawCardH5.this.f35273c.b();
                    }
                }
            }, null);
            return;
        }
        c();
        a aVar = this.f35273c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
