package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public class ActionBarH5 extends FrameLayout implements c {
    public TextView Bx;
    public a By;
    public View Bz;
    public TextView dM;
    public AdTemplate mAdTemplate;

    /* loaded from: classes10.dex */
    public interface a {
        void N(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d0523, this);
        this.Bx = (TextView) findViewById(R.id.obfuscated_res_0x7f09136e);
        this.dM = (TextView) findViewById(R.id.obfuscated_res_0x7f091372);
        this.Bz = findViewById(R.id.obfuscated_res_0x7f09134d);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (d.dE(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    private void b(View view2, final boolean z) {
        int i;
        if (view2 == this.Bz) {
            i = 1;
        } else {
            i = 2;
        }
        com.kwad.components.core.e.d.a.a(new a.C0644a(view2.getContext()).aq(this.mAdTemplate).an(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.By != null) {
                    ActionBarH5.this.By.N(z);
                }
            }
        }));
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.By = aVar;
        AdInfo dP = e.dP(adTemplate);
        this.Bx.setText(com.kwad.sdk.core.response.b.a.au(dP));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(dP));
        setClickable(true);
        this.Bz.setClickable(true);
        new f(this.Bz, this);
        new f(this, this);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        b(view2, true);
    }
}
