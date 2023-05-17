package com.kwad.components.core.k;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.w;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.kwad.sdk.core.network.d {
    public com.kwad.components.core.k.kwai.b EI;
    public int HI;

    public a(com.kwad.components.core.k.kwai.a aVar) {
        this(aVar.EI, aVar.HO, aVar.HP, aVar.HR);
        this.HI = aVar.HQ ? 1 : 0;
    }

    public a(com.kwad.components.core.k.kwai.b bVar) {
        this(bVar, null);
    }

    public a(com.kwad.components.core.k.kwai.b bVar, com.kwad.components.core.k.kwai.d dVar) {
        this(bVar, null, false, null);
    }

    public a(com.kwad.components.core.k.kwai.b bVar, @Nullable List<String> list, boolean z, com.kwad.components.core.k.kwai.d dVar) {
        super(b(bVar), a(bVar), bVar != null ? bVar.HS : null);
        putBody("timestamp", System.currentTimeMillis());
        this.EI = bVar;
        com.kwad.sdk.internal.api.a op = bVar.op();
        if (op != null && !op.xq()) {
            a(com.kwad.sdk.core.request.model.a.uM(), op);
        }
        JSONArray jSONArray = new JSONArray();
        r.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", dVar);
        int i = this.HI;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (!TextUtils.isEmpty("")) {
            putBody("universeDebugParam", "");
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", w.zD());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String av = this.EI.av("thirdUserId");
        com.kwad.sdk.core.request.model.g uT = com.kwad.sdk.core.request.model.g.uT();
        if (av != null) {
            uT.cu(av);
        }
        if (op != null && !op.xp()) {
            a(uT, op);
        }
        putBody("userInfo", uT);
    }

    public static int a(com.kwad.components.core.k.kwai.b bVar) {
        try {
            return bVar.HS.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void a(com.kwad.sdk.core.request.model.g gVar, com.kwad.sdk.internal.api.a aVar) {
        int i = aVar.acZ;
        if (i != 0) {
            gVar.acZ = i;
        }
        int i2 = aVar.ada;
        if (i2 != 0) {
            gVar.ada = i2;
        }
        if (TextUtils.isEmpty(aVar.adb)) {
            return;
        }
        gVar.adb = aVar.adb;
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(aVar.aiz)) {
            r.putValue(jSONObject2, "prevTitle", aVar.aiz);
        }
        if (!TextUtils.isEmpty(aVar.aiA)) {
            r.putValue(jSONObject2, "postTitle", aVar.aiA);
        }
        if (!TextUtils.isEmpty(aVar.aiB)) {
            r.putValue(jSONObject2, "historyTitle", aVar.aiB);
        }
        if (!TextUtils.isEmpty(aVar.agM)) {
            r.putValue(jSONObject2, "channel", aVar.agM);
        }
        r.putValue(jSONObject, "content", jSONObject2);
        putBody(DI.APP_INFO_NAME, jSONObject);
    }

    public static long b(com.kwad.components.core.k.kwai.b bVar) {
        return bVar.HS.getPosId();
    }

    public final void ao(int i) {
        this.HI = i;
    }

    public final int getAdNum() {
        return this.EI.HS.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl getScene() {
        com.kwad.components.core.k.kwai.b bVar = this.EI;
        if (bVar != null) {
            return bVar.HS;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        return com.kwad.sdk.b.qK();
    }
}
