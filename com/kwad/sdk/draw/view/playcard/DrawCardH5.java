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
/* loaded from: classes3.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f9722a;

    /* renamed from: b  reason: collision with root package name */
    private AdTemplate f9723b;
    private a c;
    private int d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private KsLogoView h;
    private ValueAnimator i;

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

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(int i, int i2) {
        d();
        this.i = am.a(this, i, i2);
        this.i.setInterpolator(new DecelerateInterpolator(2.0f));
        this.i.setDuration(300L);
        this.i.start();
    }

    private void a(Context context) {
        this.f9722a = context;
        inflate(context, R.layout.ksad_draw_card_h5, this);
        this.e = (ImageView) findViewById(R.id.ksad_card_close);
        this.f = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.g = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.h = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void d() {
        if (this.i != null) {
            this.i.removeAllListeners();
            this.i.cancel();
        }
    }

    public void a() {
        d();
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f9723b = adTemplate;
        AdInfo j = c.j(this.f9723b);
        this.c = aVar;
        this.f.setText(com.kwad.sdk.core.response.b.a.n(j));
        this.g.setText(com.kwad.sdk.core.response.b.a.w(j));
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.a(adTemplate);
        setOnClickListener(this);
        this.f.measure(View.MeasureSpec.makeMeasureSpec((ah.g(this.f9722a) - (ao.a(this.f9722a, 16.0f) * 2)) - (ao.a(this.f9722a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.d = ao.a(this.f9722a, 100.0f) + this.f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.d);
    }

    public void c() {
        a(this.d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.e) {
            com.kwad.sdk.core.download.b.a.a(getContext(), this.f9723b, new a.InterfaceC1092a() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1092a
                public void a() {
                    if (DrawCardH5.this.c != null) {
                        DrawCardH5.this.c.b();
                    }
                }
            }, null);
            return;
        }
        c();
        if (this.c != null) {
            this.c.a();
        }
    }
}
