package com.kwad.sdk.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.request.model.j;
import com.kwad.sdk.core.request.model.k;
import com.kwad.sdk.core.request.model.l;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.d {

    /* renamed from: b  reason: collision with root package name */
    public f f56070b;

    /* renamed from: c  reason: collision with root package name */
    public int f56071c;

    public a(f fVar) {
        this(fVar, null);
    }

    public a(f fVar, k kVar) {
        this(fVar, null, false, kVar, null);
    }

    public a(f fVar, @Nullable List<String> list, boolean z, k kVar, j jVar) {
        super(a(fVar));
        DevelopMangerPlugin.DevelopValue a;
        this.f56070b = fVar;
        com.kwad.sdk.internal.api.a a2 = fVar.a();
        if (a2 != null && !a2.b()) {
            a(com.kwad.sdk.core.request.model.b.a(), a2);
        }
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
        a("universePhotoInfo", kVar);
        int i2 = this.f56071c;
        if (i2 > 0) {
            a("calledUnionType", i2);
        }
        if (((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_MODIFY_CREATEID") != null) {
            list = new ArrayList<>();
            list.add("creativeId_" + a.getValue());
        }
        if (list != null) {
            a("preloadIdList", new JSONArray((Collection) list));
            a("preloadCheck", z);
        }
        b("appTag", as.d(KsAdSDKImpl.get().getContext()));
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_CAMPAIGNTYPE");
        if (a3 != null) {
            a("campaignType", ((Integer) a3.getValue()).intValue());
        }
        String a4 = this.f56070b.a("thirdUserId");
        l a5 = l.a();
        if (a4 != null) {
            a5.a(a4);
        }
        if (a2 != null && !a2.a()) {
            a(a5, a2);
        }
        a("userInfo", a5);
        if (jVar != null) {
            a("statusInfo", jVar);
        }
    }

    public static int a(f fVar) {
        try {
            return fVar.a.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private void a(l lVar, com.kwad.sdk.internal.api.a aVar) {
        int i2 = aVar.a;
        if (i2 != 0) {
            lVar.a = i2;
        }
        int i3 = aVar.f56993b;
        if (i3 != 0) {
            lVar.f56183b = i3;
        }
        if (TextUtils.isEmpty(aVar.f56994c)) {
            return;
        }
        lVar.f56184c = aVar.f56994c;
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(aVar.f56995d)) {
            t.a(jSONObject2, "prevTitle", aVar.f56995d);
        }
        if (!TextUtils.isEmpty(aVar.f56996e)) {
            t.a(jSONObject2, "postTitle", aVar.f56996e);
        }
        if (!TextUtils.isEmpty(aVar.f56997f)) {
            t.a(jSONObject2, "historyTitle", aVar.f56997f);
        }
        if (!TextUtils.isEmpty(aVar.f56998g)) {
            t.a(jSONObject2, "channel", aVar.f56998g);
        }
        t.a(jSONObject, "content", jSONObject2);
        a(DI.APP_INFO_NAME, jSONObject);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.c();
    }

    public void a(int i2) {
        this.f56071c = i2;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl b() {
        f fVar = this.f56070b;
        if (fVar != null) {
            return fVar.a;
        }
        return null;
    }
}
