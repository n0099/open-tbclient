package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
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
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.core.i.e implements View.OnClickListener {
    public static boolean iy;
    public TextView eQ;
    public com.kwad.components.ad.interstitial.b.c gh;
    public KSCornerImageView it;
    public TextView iu;
    public TextView iv;
    public TextView iw;
    public TextView ix;
    public AdTemplate mAdTemplate;

    public static void d(com.kwad.components.ad.interstitial.b.c cVar) {
        if (iy) {
            return;
        }
        iy = true;
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        dVar.setArguments(bundle);
        dVar.e(cVar);
        dVar.show(cVar.gi.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void dT() {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.it, com.kwad.sdk.core.response.a.a.bn(bQ), this.mAdTemplate, 12);
        this.eQ.setText(com.kwad.sdk.core.response.a.a.bl(bQ));
        this.iu.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
    }

    private void e(com.kwad.components.ad.interstitial.b.c cVar) {
        this.gh = cVar;
    }

    private void h(View view2) {
        this.it = (KSCornerImageView) view2.findViewById(R.id.obfuscated_res_0x7f0912ef);
        this.eQ = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f0);
        this.iu = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f3);
        this.iv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f4);
        this.iw = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f1);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912f2);
        this.ix = textView;
        com.kwad.sdk.b.kwai.a.a(this, this.it, this.eQ, this.iu, this.iv, this.iw, textView);
    }

    @Override // com.kwad.components.core.i.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04b0, viewGroup, false);
        h(inflate);
        dT();
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
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.report.f().aK(149).aM(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.components.ad.interstitial.b.c cVar;
        Context context;
        int i;
        if (this.gh != null) {
            if (view2.equals(this.it)) {
                cVar = this.gh;
                context = cVar.gi.getContext();
                i = 127;
            } else if (view2.equals(this.eQ)) {
                cVar = this.gh;
                context = cVar.gi.getContext();
                i = 128;
            } else if (view2.equals(this.iu)) {
                cVar = this.gh;
                context = cVar.gi.getContext();
                i = 129;
            } else if (view2.equals(this.iv)) {
                cVar = this.gh;
                context = cVar.gi.getContext();
                i = 131;
            } else if (view2.equals(this.iw)) {
                com.kwad.sdk.core.report.a.c(this.gh.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.f().aM(9));
            } else if (view2.equals(this.ix)) {
                this.gh.gi.dismiss();
                com.kwad.sdk.core.report.a.a(this.gh.mAdTemplate, new com.kwad.sdk.core.report.f().aK(Cea708Decoder.COMMAND_SWA).aM(9));
            }
            cVar.a(context, i, 2, 9);
        }
        dismiss();
        iy = false;
    }
}
