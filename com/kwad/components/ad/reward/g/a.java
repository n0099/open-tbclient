package com.kwad.components.ad.reward.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.baidu.location.BDLocation;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.core.i.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends e implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, b {
    public static a pv;
    public AdTemplate mAdTemplate;
    public o pu;
    @Nullable
    public b pw;

    public static void a(Activity activity, b bVar, AdTemplate adTemplate) {
        pv = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        pv.setArguments(bundle);
        pv.a(bVar);
        pv.show(activity.getFragmentManager(), "playAgainDialog");
    }

    private void a(@Nullable b bVar) {
        this.pw = bVar;
    }

    private void gQ() {
        try {
            String string = getArguments().getString("key_template_json", null);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(string));
            this.mAdTemplate = adTemplate;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.components.core.i.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        getDialog().setOnKeyListener(this);
        gQ();
        if (this.pu == null) {
            o oVar = new o(layoutInflater, viewGroup);
            this.pu = oVar;
            oVar.b(this);
        }
        return this.pu.fR();
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void bK() {
        dismiss();
        b bVar = this.pw;
        if (bVar != null) {
            bVar.bK();
        }
        com.kwad.sdk.core.report.a.r(this.mAdTemplate, MatroskaExtractor.ID_SIMPLE_BLOCK);
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
        getDialog().setOnShowListener(this);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            dismiss();
            b bVar = this.pw;
            if (bVar != null) {
                bVar.bK();
            }
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.ad.reward.g.c
    public final void onPlayAgainClick() {
        dismiss();
        b bVar = this.pw;
        if (bVar != null) {
            bVar.onPlayAgainClick();
        }
        com.kwad.sdk.core.report.a.r(this.mAdTemplate, BDLocation.TypeServerDecryptError);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        u.b bVar = new u.b();
        bVar.aca = 205;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, (int) BDLocation.TypeServerDecryptError, bVar, (JSONObject) null);
    }
}
