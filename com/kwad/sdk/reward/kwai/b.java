package com.kwad.sdk.reward.kwai;

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
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.h.e;
import com.kwad.sdk.reward.kwai.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends e implements a.b {
    public com.kwad.sdk.reward.kwai.a a;
    public int[] b;
    public AdTemplate c;
    public a d;

    /* loaded from: classes5.dex */
    public interface a {
        void b();
    }

    public static void a(Activity activity, AdTemplate adTemplate, a aVar, int[] iArr) {
        if (adTemplate == null || activity == null) {
            return;
        }
        String jSONObject = adTemplate.toJson().toString();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", jSONObject);
        bundle.putIntArray("key_end_location", iArr);
        b bVar = new b();
        bVar.a(aVar);
        bVar.setArguments(bundle);
        bVar.show(activity.getFragmentManager(), "rewardCoupon");
    }

    @Override // com.kwad.sdk.h.e
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        com.kwad.sdk.reward.kwai.a aVar = new com.kwad.sdk.reward.kwai.a(layoutInflater.getContext(), viewGroup, this.b);
        this.a = aVar;
        aVar.a(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.a.a(this.c);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.sdk.reward.kwai.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.a.a();
    }

    @Override // com.kwad.sdk.reward.kwai.a.b
    public void a() {
        dismiss();
        a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    @Override // com.kwad.sdk.reward.kwai.a.b
    public void b() {
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("key_template_json")) {
                try {
                    String string = arguments.getString("key_template_json");
                    AdTemplate adTemplate = new AdTemplate();
                    this.c = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.b(e);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.b = arguments.getIntArray("key_end_location");
            }
        }
    }
}
