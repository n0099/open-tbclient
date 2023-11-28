package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    public b xE = new b();
    public final C0614a xF = new C0614a(d.AW());

    /* renamed from: com.kwad.components.ad.reward.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0614a extends com.kwad.components.ad.reward.l.b {
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
        public C0614a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.xC = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.xD = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.xC = "基础奖励：观看视频";
            this.xD = "基础奖励：需再观看%ss视频";
        }
    }

    private void jA() {
        if (this.xF.isCompleted()) {
            jq();
        } else {
            jr();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.xF.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<c> jo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xE);
        arrayList.add(this.xF);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int jp() {
        int i = 0;
        for (c cVar : jo()) {
            if (!cVar.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void jy() {
        com.kwad.sdk.core.e.c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xE.jq();
        jA();
    }

    public final boolean jz() {
        return this.xE.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.e.c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xF.jq();
        jA();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xE);
        t.a(jSONObject, "mOpenNsTask", this.xF);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xE.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xF.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }
}
