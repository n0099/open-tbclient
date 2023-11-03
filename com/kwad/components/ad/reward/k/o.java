package com.kwad.components.ad.reward.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.widget.KsStyledTextButton;
/* loaded from: classes10.dex */
public final class o extends d implements View.OnClickListener {
    public KsStyledTextButton vU;
    public View vV;
    @Nullable
    public com.kwad.components.ad.reward.g.b vW;
    public ViewGroup vl;

    public o(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.vl = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04da, viewGroup, false);
        initView();
    }

    private void initView() {
        this.vU = (KsStyledTextButton) this.vl.findViewById(R.id.obfuscated_res_0x7f09137a);
        this.vV = this.vl.findViewById(R.id.obfuscated_res_0x7f09137b);
        this.vU.setOnClickListener(this);
        this.vV.setOnClickListener(this);
    }

    public final void b(@Nullable com.kwad.components.ad.reward.g.b bVar) {
        this.vW = bVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.vl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (this.vW == null) {
            return;
        }
        if (view2.equals(this.vU)) {
            this.vW.onPlayAgainClick();
        } else if (view2.equals(this.vV)) {
            this.vW.bK();
        }
    }
}
