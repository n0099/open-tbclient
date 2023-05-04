package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class s extends d implements View.OnClickListener {
    public AdTemplate adTemplate;
    public TextView eQ;
    public KSCornerImageView it;
    public TextView iu;
    public TextView iv;
    public Context mContext;
    public l.a nf;
    public ViewGroup pV;
    public DialogFragment vf;
    public TextView vg;

    /* renamed from: vi  reason: collision with root package name */
    public View f1081vi;
    public View vj;
    public LayoutInflater wi;
    public ViewGroup wj;
    public ImageView wk;

    public s(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, l.a aVar) {
        this.vf = dialogFragment;
        this.wi = layoutInflater;
        this.wj = viewGroup;
        this.adTemplate = adTemplate;
        this.nf = aVar;
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04a3, viewGroup, false);
        this.pV = viewGroup2;
        this.mContext = viewGroup2.getContext();
        initView();
    }

    private SpannableString V(String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060625));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.obfuscated_res_0x7f060625));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    private void initView() {
        this.it = (KSCornerImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091348);
        this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09134a);
        this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091346);
        this.vg = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091349);
        this.iv = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091347);
        this.wk = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f09133a);
        this.f1081vi = this.pV.findViewById(R.id.obfuscated_res_0x7f091345);
        this.vj = this.pV.findViewById(R.id.obfuscated_res_0x7f091344);
        this.f1081vi.setOnClickListener(this);
        this.vj.setOnClickListener(this);
        this.it.setOnClickListener(this);
        this.eQ.setOnClickListener(this);
        this.iu.setOnClickListener(this);
        this.iv.setOnClickListener(this);
        this.wk.setOnClickListener(this);
    }

    public final void a(l.c cVar) {
        KSImageLoader.loadAppIcon(this.it, cVar.eL(), this.adTemplate, 12);
        this.eQ.setText(cVar.getTitle());
        this.iu.setText(cVar.fO());
        this.vg.setText(V(cVar.nq));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.pV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        l.a aVar;
        if (view2.equals(this.f1081vi)) {
            this.vf.dismiss();
            l.a aVar2 = this.nf;
            if (aVar2 != null) {
                aVar2.G(false);
            }
        } else if (view2.equals(this.vj)) {
            this.vf.dismiss();
            l.a aVar3 = this.nf;
            if (aVar3 != null) {
                aVar3.fI();
            }
        } else if ((view2.equals(this.iv) || view2.equals(this.wk)) && (aVar = this.nf) != null) {
            aVar.g(131, 2);
        }
    }
}
