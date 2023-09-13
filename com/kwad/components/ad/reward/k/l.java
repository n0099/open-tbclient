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
/* loaded from: classes10.dex */
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
        this.nL = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04c1, viewGroup, false);
        initView();
    }

    private void initView() {
        this.vy = this.nL.findViewById(R.id.obfuscated_res_0x7f091315);
        this.eQ = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f09131a);
        this.nC = (ImageView) this.nL.findViewById(R.id.obfuscated_res_0x7f091319);
        this.vz = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f091318);
        this.vj = this.nL.findViewById(R.id.obfuscated_res_0x7f091316);
        this.vB = this.nL.findViewById(R.id.obfuscated_res_0x7f091317);
        this.vA = this.nL.findViewById(R.id.obfuscated_res_0x7f09131b);
        this.vy.setOnClickListener(this);
        this.vj.setOnClickListener(this);
        this.vB.setOnClickListener(this);
        this.vA.setOnClickListener(this);
    }

    public final void a(l.c cVar) {
        KSImageLoader.loadCircleIcon(this.nC, cVar.eL(), this.nL.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e62));
        String title = cVar.getTitle();
        if (this.eQ != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = fR().getResources().getColor(R.color.obfuscated_res_0x7f0607a6);
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
