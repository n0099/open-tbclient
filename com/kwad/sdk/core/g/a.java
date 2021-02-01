package com.kwad.sdk.core.g;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.d {

    /* renamed from: b  reason: collision with root package name */
    com.kwad.sdk.core.g.a.f f9156b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.kwad.sdk.core.g.a.f fVar, com.kwad.sdk.core.g.a.l lVar) {
        this(fVar, null, false, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.kwad.sdk.core.g.a.f fVar, @Nullable List<String> list, boolean z, com.kwad.sdk.core.g.a.l lVar) {
        DevelopMangerPlugin.DevelopValue a2;
        this.f9156b = fVar;
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
        a("universePhotoInfo", lVar);
        if (((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_MODIFY_CREATEID") != null) {
            list = new ArrayList<>();
            list.add("creativeId_" + a2.getValue());
        }
        if (list != null) {
            a("preloadIdList", new JSONArray((Collection) list));
            a("preloadCheck", z);
        }
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.b();
    }
}
