package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes3.dex */
public class ActionBarH5 extends FrameLayout implements d {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57638b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57639c;

    /* renamed from: d  reason: collision with root package name */
    public a f57640d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        a(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.a = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.f57638b = (TextView) findViewById(R.id.ksad_h5_open_btn);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(this.f57639c).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarH5.this.f57640d != null) {
                    ActionBarH5.this.f57640d.a(z);
                }
            }
        }));
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f57639c = adTemplate;
        this.f57640d = aVar;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(j2));
        this.f57638b.setText(com.kwad.sdk.core.response.a.a.A(j2));
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (c.g(this.f57639c)) {
            a(view, false);
        }
    }
}
