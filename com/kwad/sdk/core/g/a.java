package com.kwad.sdk.core.g;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.a.k;
import com.kwad.sdk.core.g.a.l;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.network.d {

    /* renamed from: c  reason: collision with root package name */
    public f f32290c;

    public a(f fVar, @Nullable List<String> list, boolean z, k kVar) {
        int i2;
        DevelopMangerPlugin.DevelopValue a2;
        try {
            i2 = fVar.f32313a.getScreenOrientation();
        } catch (Throwable unused) {
            i2 = 0;
        }
        super.a(i2);
        this.f32290c = fVar;
        JSONArray jSONArray = new JSONArray();
        o.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
        a("universePhotoInfo", kVar);
        if (((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_MODIFY_CREATEID") != null) {
            list = new ArrayList<>();
            list.add("creativeId_" + a2.getValue());
        }
        if (list != null) {
            a("preloadIdList", new JSONArray((Collection) list));
            a("preloadCheck", z);
        }
        b("appTag", af.c(KsAdSDKImpl.get().getContext()));
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_CAMPAIGNTYPE");
        if (a3 != null) {
            a("campaignType", ((Integer) a3.getValue()).intValue());
        }
        String a4 = this.f32290c.a("thirdUserId");
        if (a4 != null) {
            l a5 = l.a();
            a5.a(a4);
            a("userInfo", a5);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.b();
    }
}
