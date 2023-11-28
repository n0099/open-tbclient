package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class m extends d implements View.OnClickListener {
    public ImageView fq;
    public TextView hz;
    public h.a pO;
    public DialogFragment za;
    public View zd;
    public ViewGroup zs;
    public View zt;
    public TextView zu;
    public TextView zv;
    public TextView zw;
    public View zx;

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.za = dialogFragment;
        this.pO = aVar;
        if (com.kwad.sdk.core.response.b.a.cJ(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            this.zs = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04e9, viewGroup, false);
            s(true);
            return;
        }
        this.zs = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04eb, viewGroup, false);
        s(false);
    }

    private void s(boolean z) {
        this.zt = this.zs.findViewById(R.id.obfuscated_res_0x7f0913c2);
        this.hz = (TextView) this.zs.findViewById(R.id.obfuscated_res_0x7f0913c8);
        this.fq = (ImageView) this.zs.findViewById(R.id.obfuscated_res_0x7f0913c7);
        this.zv = (TextView) this.zs.findViewById(R.id.obfuscated_res_0x7f0913c6);
        this.zu = (TextView) this.zs.findViewById(R.id.obfuscated_res_0x7f0913c5);
        this.zd = this.zs.findViewById(R.id.obfuscated_res_0x7f0913c3);
        this.zx = this.zs.findViewById(R.id.obfuscated_res_0x7f0913c4);
        this.zw = (TextView) this.zs.findViewById(R.id.obfuscated_res_0x7f0913c9);
        if (z) {
            this.zt.setVisibility(8);
        }
        this.zt.setOnClickListener(this);
        this.zd.setOnClickListener(this);
        this.zx.setOnClickListener(this);
        this.zw.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadCircleIcon(this.fq, cVar.gd(), this.zs.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e7e));
        String title = cVar.getTitle();
        if (this.hz != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = gD().getResources().getColor(R.color.obfuscated_res_0x7f0607a6);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.hz.setText(spannableString);
        }
        this.zu.setText(cVar.ge());
        this.zv.setText(cVar.gf());
        this.zw.setText(String.format("%s", cVar.pX));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.zs;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        h.a aVar;
        if (view2.equals(this.zt)) {
            this.za.dismiss();
            h.a aVar2 = this.pO;
            if (aVar2 != null) {
                aVar2.fY();
            }
        } else if (view2.equals(this.zd)) {
            this.za.dismiss();
            h.a aVar3 = this.pO;
            if (aVar3 != null) {
                aVar3.fY();
            }
        } else if (view2.equals(this.zx)) {
            this.za.dismiss();
            h.a aVar4 = this.pO;
            if (aVar4 != null) {
                aVar4.F(false);
            }
        } else if (view2.equals(this.zw) && (aVar = this.pO) != null) {
            aVar.i(131, 2);
        }
    }
}
