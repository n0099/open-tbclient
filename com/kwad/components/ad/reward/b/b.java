package com.kwad.components.ad.reward.b;

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
import com.kwad.components.ad.reward.b.a;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends g implements a.b {
    public AdTemplate mAdTemplate;
    public int[] qK;
    public com.kwad.components.ad.reward.b.a ra;
    public a rb;

    /* loaded from: classes10.dex */
    public interface a {
        void gH();
    }

    @Override // com.kwad.components.ad.reward.b.a.b
    public final void gH() {
        dismiss();
        a aVar = this.rb;
        if (aVar != null) {
            aVar.gH();
        }
    }

    @Override // com.kwad.components.ad.reward.b.a.b
    public final void gI() {
        dismiss();
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        if (adTemplate != null && activity != null) {
            String jSONObject = adTemplate.toJson().toString();
            Bundle bundle = new Bundle();
            bundle.putString("key_template_json", jSONObject);
            bundle.putIntArray("key_end_location", iArr);
            b bVar = new b();
            bVar.a(aVar);
            bVar.setArguments(bundle);
            bVar.show(activity.getFragmentManager(), "rewardCoupon");
        }
    }

    private void a(a aVar) {
        this.rb = aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        com.kwad.components.ad.reward.b.a aVar = new com.kwad.components.ad.reward.b.a(layoutInflater.getContext(), viewGroup, this.qK);
        this.ra = aVar;
        aVar.a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.ra.b(r.R(this.mAdTemplate));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.b.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 0) {
                    return true;
                }
                return false;
            }
        });
        return this.ra.gD();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    AdTemplate adTemplate = new AdTemplate();
                    this.mAdTemplate = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.qK = arguments.getIntArray("key_end_location");
            }
        }
    }
}
