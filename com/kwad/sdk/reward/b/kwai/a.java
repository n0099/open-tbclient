package com.kwad.sdk.reward.b.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.reward.b.a {

    /* renamed from: b  reason: collision with root package name */
    public b f40754b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final C1990a f40755c = new C1990a(com.kwad.sdk.core.config.b.aA());

    /* renamed from: com.kwad.sdk.reward.b.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1990a extends com.kwad.sdk.reward.b.a {
        public C1990a(int i) {
            this.a = String.format("浏览详情页%s秒", i + "");
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public b() {
            this.a = "观看视频";
        }
    }

    private void k() {
        if (this.f40754b.d() && this.f40755c.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.f40754b.d() && this.f40755c.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markWatchVideoCompleted");
        this.f40754b.a();
        k();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markOpenNsCompleted");
        this.f40755c.a();
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
        arrayList.add(this.f40754b);
        arrayList.add(this.f40755c);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f40754b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f40755c.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.f40754b);
        t.a(jSONObject, "mOpenNsTask", this.f40755c);
        return jSONObject;
    }
}
