package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.h;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class j extends d implements View.OnClickListener {
    public AdTemplate adTemplate;
    public TextView hz;
    public KSCornerImageView lu;
    public TextView lv;
    public TextView lw;
    public h.a pO;
    public ViewGroup sy;
    public View vn;
    public DialogFragment za;
    public TextView zb;
    public View zc;
    public View zd;

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.za = dialogFragment;
        this.adTemplate = adTemplate;
        this.pO = aVar;
        this.sy = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0501, viewGroup, false);
        initView();
    }

    private void initView() {
        this.lu = (KSCornerImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f091432);
        this.hz = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091434);
        this.lv = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091430);
        this.zb = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091433);
        this.lw = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091431);
        this.vn = this.sy.findViewById(R.id.obfuscated_res_0x7f09142d);
        this.zc = this.sy.findViewById(R.id.obfuscated_res_0x7f09142f);
        this.zd = this.sy.findViewById(R.id.obfuscated_res_0x7f09142e);
        this.vn.setOnClickListener(this);
        this.zc.setOnClickListener(this);
        this.zd.setOnClickListener(this);
        this.lu.setOnClickListener(this);
        this.hz.setOnClickListener(this);
        this.lv.setOnClickListener(this);
        this.lw.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadAppIcon(this.lu, cVar.gd(), this.adTemplate, 4);
        this.hz.setText(cVar.getTitle());
        this.lv.setText(cVar.ge());
        this.zb.setText(cVar.gg());
        if (com.kwad.sdk.core.response.b.a.ca(this.adTemplate)) {
            this.lw.setText(String.format("%s >", com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.sy;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        h.a aVar;
        if (view2.equals(this.vn)) {
            this.za.dismiss();
            h.a aVar2 = this.pO;
            if (aVar2 != null) {
                aVar2.fY();
            }
        } else if (view2.equals(this.zc)) {
            this.za.dismiss();
            h.a aVar3 = this.pO;
            if (aVar3 != null) {
                aVar3.F(false);
            }
        } else if (view2.equals(this.zd)) {
            this.za.dismiss();
            h.a aVar4 = this.pO;
            if (aVar4 != null) {
                aVar4.fY();
            }
        } else if (view2.equals(this.lu)) {
            h.a aVar5 = this.pO;
            if (aVar5 != null) {
                aVar5.i(127, 2);
            }
        } else if (view2.equals(this.hz)) {
            h.a aVar6 = this.pO;
            if (aVar6 != null) {
                aVar6.i(128, 2);
            }
        } else if (view2.equals(this.lv)) {
            h.a aVar7 = this.pO;
            if (aVar7 != null) {
                aVar7.i(129, 2);
            }
        } else if (view2.equals(this.lw) && (aVar = this.pO) != null) {
            aVar.i(131, 2);
        }
    }
}
