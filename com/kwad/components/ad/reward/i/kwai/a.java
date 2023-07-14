package com.kwad.components.ad.reward.i.kwai;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.i.a {
    public b ua = new b();
    public final C0623a ub = new C0623a(d.sf());

    /* renamed from: com.kwad.components.ad.reward.i.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0623a extends com.kwad.components.ad.reward.i.b {
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
        public C0623a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.tY = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.tZ = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends com.kwad.components.ad.reward.i.b {
        public b() {
            this.tY = "基础奖励：观看视频";
            this.tZ = "基础奖励：需再观看%ss视频";
        }
    }

    private void iE() {
        if (this.ub.isCompleted()) {
            it();
        } else {
            iu();
        }
    }

    public final void iB() {
        com.kwad.sdk.core.e.b.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.ua.it();
        iE();
    }

    public final boolean iC() {
        return this.ua.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<c> ir() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ua);
        arrayList.add(this.ub);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int is() {
        int i = 0;
        for (c cVar : ir()) {
            if (!cVar.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.ub.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.e.b.d("LandPageOpenTask", "markOpenNsCompleted");
        this.ub.it();
        iE();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.ua.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.ub.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "mWatchVideoTask", this.ua);
        r.a(jSONObject, "mOpenNsTask", this.ub);
        return jSONObject;
    }
}
