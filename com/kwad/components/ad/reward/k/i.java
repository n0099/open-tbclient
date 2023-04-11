package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class i extends d implements View.OnClickListener {
    public AdTemplate adTemplate;
    public TextView eQ;
    public KSCornerImageView it;
    public TextView iu;
    public View kP;
    public l.a nf;
    public ViewGroup pV;
    public DialogFragment vf;
    public TextView vg;
    public View vh;

    /* renamed from: vi  reason: collision with root package name */
    public View f1080vi;
    public View vj;

    public i(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, l.a aVar) {
        this.vf = dialogFragment;
        this.adTemplate = adTemplate;
        this.nf = aVar;
        this.pV = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0491, viewGroup, false);
        initView();
    }

    private void initView() {
        this.it = (KSCornerImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f0912e0);
        this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f0912e2);
        this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f0912de);
        this.vg = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f0912e1);
        this.vh = this.pV.findViewById(R.id.obfuscated_res_0x7f0912df);
        this.kP = this.pV.findViewById(R.id.obfuscated_res_0x7f0912db);
        this.f1080vi = this.pV.findViewById(R.id.obfuscated_res_0x7f0912dd);
        this.vj = this.pV.findViewById(R.id.obfuscated_res_0x7f0912dc);
        this.kP.setOnClickListener(this);
        this.f1080vi.setOnClickListener(this);
        this.vj.setOnClickListener(this);
        this.it.setOnClickListener(this);
        this.eQ.setOnClickListener(this);
        this.iu.setOnClickListener(this);
        this.vh.setOnClickListener(this);
    }

    public final void a(l.c cVar) {
        KSImageLoader.loadAppIcon(this.it, cVar.eL(), this.adTemplate, 4);
        this.eQ.setText(cVar.getTitle());
        this.iu.setText(cVar.fO());
        this.vg.setText(cVar.fP());
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.pV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        l.a aVar;
        if (view2.equals(this.kP)) {
            this.vf.dismiss();
            l.a aVar2 = this.nf;
            if (aVar2 != null) {
                aVar2.fI();
            }
        } else if (view2.equals(this.f1080vi)) {
            this.vf.dismiss();
            l.a aVar3 = this.nf;
            if (aVar3 != null) {
                aVar3.G(false);
            }
        } else if (view2.equals(this.vj)) {
            this.vf.dismiss();
            l.a aVar4 = this.nf;
            if (aVar4 != null) {
                aVar4.fI();
            }
        } else if (view2.equals(this.it)) {
            l.a aVar5 = this.nf;
            if (aVar5 != null) {
                aVar5.g(127, 2);
            }
        } else if (view2.equals(this.eQ)) {
            l.a aVar6 = this.nf;
            if (aVar6 != null) {
                aVar6.g(128, 2);
            }
        } else if (view2.equals(this.iu)) {
            l.a aVar7 = this.nf;
            if (aVar7 != null) {
                aVar7.g(129, 2);
            }
        } else if (!view2.equals(this.vh) || (aVar = this.nf) == null) {
        } else {
            aVar.g(131, 2);
        }
    }
}
