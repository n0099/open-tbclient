package com.kwad.components.ad.interstitial.g;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.proxy.g;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends g implements View.OnClickListener {
    public static boolean lz;
    public TextView hz;
    public com.kwad.components.ad.interstitial.e.c jK;
    public KSCornerImageView lu;
    public TextView lv;
    public TextView lw;
    public TextView lx;
    public TextView ly;
    public AdTemplate mAdTemplate;

    public static void e(com.kwad.components.ad.interstitial.e.c cVar) {
        if (lz) {
            return;
        }
        lz = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.f(cVar);
        bVar.show(cVar.io.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void f(com.kwad.components.ad.interstitial.e.c cVar) {
        this.jK = cVar;
    }

    private void i(View view2) {
        this.lu = (KSCornerImageView) view2.findViewById(R.id.obfuscated_res_0x7f091389);
        this.hz = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09138a);
        this.lv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09138d);
        this.lw = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09138e);
        this.lx = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09138b);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09138c);
        this.ly = textView;
        com.kwad.sdk.d.a.a.a(this, this.lu, this.hz, this.lv, this.lw, this.lx, textView);
    }

    private void initData() {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.lu, com.kwad.sdk.core.response.b.a.cf(dP), this.mAdTemplate, 12);
        this.hz.setText(com.kwad.sdk.core.response.b.a.cc(dP));
        this.lv.setText(com.kwad.sdk.core.response.b.a.au(dP));
        if (com.kwad.sdk.core.response.b.a.ca(this.mAdTemplate)) {
            this.lw.setText(com.kwad.sdk.core.response.b.a.aE(dP));
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04e0, viewGroup);
        i(inflate);
        initData();
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new j().cC(149).cH(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (this.jK != null) {
            if (view2.equals(this.lu)) {
                com.kwad.components.ad.interstitial.e.c cVar = this.jK;
                cVar.a(cVar.io.getContext(), 127, 2, 9);
            } else if (view2.equals(this.hz)) {
                com.kwad.components.ad.interstitial.e.c cVar2 = this.jK;
                cVar2.a(cVar2.io.getContext(), 128, 2, 9);
            } else if (view2.equals(this.lv)) {
                com.kwad.components.ad.interstitial.e.c cVar3 = this.jK;
                cVar3.a(cVar3.io.getContext(), 129, 2, 9);
            } else if (view2.equals(this.lw)) {
                com.kwad.components.ad.interstitial.e.c cVar4 = this.jK;
                cVar4.a(cVar4.io.getContext(), 131, 2, 9);
            } else if (view2.equals(this.lx)) {
                com.kwad.sdk.core.report.a.c(this.jK.mAdTemplate, (JSONObject) null, new j().cH(9));
            } else if (view2.equals(this.ly)) {
                com.kwad.components.ad.interstitial.e.c cVar5 = this.jK;
                cVar5.a(false, -1, cVar5.eN);
                this.jK.io.dismiss();
                com.kwad.sdk.core.report.a.e(this.jK.mAdTemplate, (JSONObject) null, new j().cC(Cea708Decoder.COMMAND_SWA).cH(9));
            }
        }
        dismiss();
        lz = false;
    }
}
