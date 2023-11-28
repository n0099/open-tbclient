package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    public c xG = new c();
    public C0615a xH = new C0615a();
    public final b xI = new b(com.kwad.components.ad.reward.a.b.gp());

    /* renamed from: com.kwad.components.ad.reward.l.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0615a extends com.kwad.components.ad.reward.l.b {
        public C0615a() {
            this.xC = "安装应用";
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
        public b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.xC = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.xD = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.xC = "基础奖励：观看视频";
            this.xD = "基础奖励：需再观看%ss视频";
        }
    }

    private void jA() {
        boolean z;
        if (this.xG.isCompleted() && this.xH.isCompleted() && this.xI.isCompleted()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            jq();
        } else {
            jr();
        }
    }

    private void jC() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markInstallUncompleted");
        this.xH.jr();
        jA();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        if (this.xH.isCompleted() && this.xI.isCompleted()) {
            return true;
        }
        return false;
    }

    public final void jB() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markInstallCompleted");
        this.xH.jq();
        jA();
    }

    public final void jD() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markUseAppCompleted");
        this.xI.jq();
        jA();
    }

    public final boolean jE() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "isInstallCompleted");
        return this.xH.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xG);
        arrayList.add(this.xI);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int jp() {
        int i = 0;
        for (com.kwad.components.ad.reward.l.c cVar : jo()) {
            if (!cVar.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void jy() {
        com.kwad.sdk.core.e.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.xG.jq();
        jA();
    }

    public final boolean jz() {
        return this.xG.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xG);
        t.a(jSONObject, "mInstallAppTask", this.xH);
        t.a(jSONObject, "mUseAppTask", this.xI);
        return jSONObject;
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ak.an(context, com.kwad.sdk.core.response.b.a.ay(e.dP(adTemplate)))) {
            aVar.jB();
        } else {
            aVar.jC();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xG.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xI.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }
}
