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
/* loaded from: classes7.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40375b;

    /* renamed from: c  reason: collision with root package name */
    public a f40376c;

    /* renamed from: d  reason: collision with root package name */
    public int f40377d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f40378e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40379f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40380g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f40381h;
    public ValueAnimator i;

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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d042f, this);
        this.f40378e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091052);
        this.f40379f = (TextView) findViewById(R.id.obfuscated_res_0x7f091048);
        this.f40380g = (TextView) findViewById(R.id.obfuscated_res_0x7f091054);
        this.f40381h = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091079);
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
        this.f40375b = adTemplate;
        AdInfo j = d.j(adTemplate);
        this.f40376c = aVar;
        this.f40379f.setText(com.kwad.sdk.core.response.a.a.s(j));
        this.f40380g.setText(com.kwad.sdk.core.response.a.a.A(j));
        this.f40378e.setOnClickListener(this);
        this.f40380g.setOnClickListener(this);
        this.f40381h.a(adTemplate);
        setOnClickListener(this);
        this.f40379f.measure(View.MeasureSpec.makeMeasureSpec((av.n(this.a) - (com.kwad.sdk.a.kwai.a.a(this.a, 16.0f) * 2)) - (com.kwad.sdk.a.kwai.a.a(this.a, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f40377d = com.kwad.sdk.a.kwai.a.a(this.a, 100.0f) + this.f40379f.getMeasuredHeight();
    }

    public void b() {
        a(0, this.f40377d);
    }

    public void c() {
        a(this.f40377d, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f40378e) {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(getContext()).a(this.f40375b).a(new a.b() { // from class: com.kwad.sdk.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (DrawCardH5.this.f40376c != null) {
                        DrawCardH5.this.f40376c.b();
                    }
                }
            }));
            return;
        }
        c();
        a aVar = this.f40376c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
