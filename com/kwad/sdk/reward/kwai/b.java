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
/* loaded from: classes3.dex */
public class b extends e implements a.b {
    public com.kwad.sdk.reward.kwai.a a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f59568b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f59569c;

    /* renamed from: d  reason: collision with root package name */
    public a f59570d;

    /* loaded from: classes3.dex */
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
        com.kwad.sdk.reward.kwai.a aVar = new com.kwad.sdk.reward.kwai.a(layoutInflater.getContext(), viewGroup, this.f59568b);
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
        this.a.a(this.f59569c);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.sdk.reward.kwai.b.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4 && keyEvent.getAction() == 0;
            }
        });
        return this.a.a();
    }

    @Override // com.kwad.sdk.reward.kwai.a.b
    public void a() {
        dismiss();
        a aVar = this.f59570d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a(a aVar) {
        this.f59570d = aVar;
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
                    this.f59569c = adTemplate;
                    adTemplate.parseJson(new JSONObject(string));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            if (arguments.containsKey("key_end_location")) {
                this.f59568b = arguments.getIntArray("key_end_location");
            }
        }
    }
}
