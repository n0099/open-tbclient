package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes7.dex */
public class ActionBarH5 extends FrameLayout implements d {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f41128b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f41129c;

    /* renamed from: d  reason: collision with root package name */
    public a f41130d;

    /* loaded from: classes7.dex */
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

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d047a, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091089);
        this.f41128b = (TextView) findViewById(R.id.obfuscated_res_0x7f09108d);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41129c).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarH5.this.f41130d != null) {
                    ActionBarH5.this.f41130d.a(z);
                }
            }
        }));
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.f41129c = adTemplate;
        this.f41130d = aVar;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(j));
        this.f41128b.setText(com.kwad.sdk.core.response.a.a.A(j));
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (c.g(this.f41129c)) {
            a(view, false);
        }
    }
}
