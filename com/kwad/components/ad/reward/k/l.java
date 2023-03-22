package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.l;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes8.dex */
public final class l extends d implements View.OnClickListener {
    public TextView eQ;
    public ImageView nC;
    public ViewGroup nL;
    public l.a nf;
    public View vA;
    public View vB;
    public DialogFragment vf;
    public View vj;
    public View vy;
    public TextView vz;

    public l(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, l.a aVar) {
        this.vf = dialogFragment;
        this.nf = aVar;
        this.nL = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0473, viewGroup, false);
        initView();
    }

    private void initView() {
        this.vy = this.nL.findViewById(R.id.obfuscated_res_0x7f091258);
        this.eQ = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f09125d);
        this.nC = (ImageView) this.nL.findViewById(R.id.obfuscated_res_0x7f09125c);
        this.vz = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f09125b);
        this.vj = this.nL.findViewById(R.id.obfuscated_res_0x7f091259);
        this.vB = this.nL.findViewById(R.id.obfuscated_res_0x7f09125a);
        this.vA = this.nL.findViewById(R.id.obfuscated_res_0x7f09125e);
        this.vy.setOnClickListener(this);
        this.vj.setOnClickListener(this);
        this.vB.setOnClickListener(this);
        this.vA.setOnClickListener(this);
    }

    public final void a(l.c cVar) {
        KSImageLoader.loadCircleIcon(this.nC, cVar.eL(), this.nL.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c9a));
        String title = cVar.getTitle();
        if (this.eQ != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = fR().getResources().getColor(R.color.obfuscated_res_0x7f060622);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.eQ.setText(spannableString);
        }
        this.vz.setText(cVar.fO());
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.nL;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        l.a aVar;
        if (view2.equals(this.vy)) {
            this.vf.dismiss();
            l.a aVar2 = this.nf;
            if (aVar2 != null) {
                aVar2.fI();
            }
        } else if (view2.equals(this.vj)) {
            this.vf.dismiss();
            l.a aVar3 = this.nf;
            if (aVar3 != null) {
                aVar3.fI();
            }
        } else if (!view2.equals(this.vB)) {
            if (!view2.equals(this.vA) || (aVar = this.nf) == null) {
                return;
            }
            aVar.g(131, 2);
        } else {
            this.vf.dismiss();
            l.a aVar4 = this.nf;
            if (aVar4 != null) {
                aVar4.G(false);
            }
        }
    }
}
