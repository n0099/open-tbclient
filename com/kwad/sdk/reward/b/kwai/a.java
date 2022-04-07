package com.kwad.sdk.reward.b.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.reward.b.a {
    public b b = new b();
    public final C0330a c = new C0330a(com.kwad.sdk.core.config.b.aA());

    /* renamed from: com.kwad.sdk.reward.b.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0330a extends com.kwad.sdk.reward.b.a {
        public C0330a(int i) {
            this.a = String.format("浏览详情页%s秒", i + "");
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public b() {
            this.a = "观看视频";
        }
    }

    private void k() {
        if (this.b.d() && this.c.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.b.d() && this.c.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markWatchVideoCompleted");
        this.b.a();
        k();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markOpenNsCompleted");
        this.c.a();
        k();
    }

    public int i() {
        int i = 0;
        for (com.kwad.sdk.reward.b.b bVar : j()) {
            if (!bVar.d()) {
                i++;
            }
        }
        return i;
    }

    public List<com.kwad.sdk.reward.b.b> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.b);
        arrayList.add(this.c);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.c.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.b);
        t.a(jSONObject, "mOpenNsTask", this.c);
        return jSONObject;
    }
}
