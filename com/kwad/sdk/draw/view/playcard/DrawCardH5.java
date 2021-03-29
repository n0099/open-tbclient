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
    public Context f34617a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34618b;

    /* renamed from: c  reason: collision with root package name */
    public a f34619c;

    /* renamed from: d  reason: collision with root package name */
    public int f34620d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f34621e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34622f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34623g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f34624h;
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
        this.f34617a = context;
        FrameLayout.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.f34621e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f34622f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.f34623g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.f34624h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
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
        this.f34618b = adTemplate;
        AdInfo j = c.j(adTemplate);
        this.f34619c = aVar;
        this.f34622f.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.f34623g.setText(com.kwad.sdk.core.response.b.a.w(j));
        this.f34621e.setOnClickListener(this);
        this.f34623g.setOnClickListener(this);
        this.f34624h.a(adTemplate);
        setOnClickListener(this);
        this.f34622f.measure(View.MeasureSpec.makeMeasureSpec((ah.g(this.f34617a) - (ao.a(this.f34617a, 16.0f) * 2)) - (ao.a(this.f34617a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f34620d = ao.a(this.f34617a, 100.0f) + this.f34622f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f34620d);
    }

    public void c() {
        a(this.f34620d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f34621e) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f34618b, new a.InterfaceC0379a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    if (DrawCardH5.this.f34619c != null) {
                        DrawCardH5.this.f34619c.b();
                    }
                }
            }, null);
            return;
        }
        c();
        a aVar = this.f34619c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
