package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public class ActionBarH5 extends FrameLayout implements c {
    public TextView cE;
    public AdTemplate mAdTemplate;
    public TextView wQ;
    public a wR;
    public View wS;

    /* loaded from: classes10.dex */
    public interface a {
        void R(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        E(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        E(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        E(context);
    }

    private void E(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04fe, this);
        this.wQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ce);
        this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f0912d2);
        this.wS = findViewById(R.id.obfuscated_res_0x7f0912b0);
    }

    private void b(View view2, final boolean z) {
        com.kwad.components.core.c.a.a.a(new a.C0636a(view2.getContext()).L(this.mAdTemplate).ae(view2 == this.wS ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.wR != null) {
                    ActionBarH5.this.wR.R(z);
                }
            }
        }));
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.wR = aVar;
        AdInfo bQ = d.bQ(adTemplate);
        this.wQ.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
        this.cE.setText(com.kwad.sdk.core.response.a.a.al(bQ));
        setClickable(true);
        this.wS.setClickable(true);
        new f(this.wS, this);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }
}
