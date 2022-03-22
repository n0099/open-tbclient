package com.kwad.sdk.reward.b.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.reward.b.a {

    /* renamed from: b  reason: collision with root package name */
    public c f40751b = new c();

    /* renamed from: c  reason: collision with root package name */
    public C1988a f40752c = new C1988a();

    /* renamed from: d  reason: collision with root package name */
    public final b f40753d = new b(com.kwad.sdk.core.config.b.az());

    /* renamed from: com.kwad.sdk.reward.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1988a extends com.kwad.sdk.reward.b.a {
        public C1988a() {
            this.a = "安装应用";
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public b(int i) {
            this.a = String.format("体验应用%s秒", i + "");
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends com.kwad.sdk.reward.b.a {
        public c() {
            this.a = "观看视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ag.a(context, com.kwad.sdk.core.response.a.a.v(d.j(adTemplate)))) {
            aVar.h();
        } else {
            aVar.i();
        }
    }

    private void n() {
        if (this.f40751b.d() && this.f40752c.d() && this.f40753d.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.f40751b.d() && this.f40752c.d() && this.f40753d.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markWatchVideoCompleted");
        this.f40751b.a();
        n();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markInstallCompleted");
        this.f40752c.a();
        n();
    }

    public void i() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markInstallUncompleted");
        this.f40752c.b();
        n();
    }

    public void j() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markUseAppCompleted");
        this.f40753d.a();
        n();
    }

    public boolean k() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "isInstallCompleted");
        return this.f40752c.d();
    }

    public int l() {
        int i = 0;
        for (com.kwad.sdk.reward.b.b bVar : m()) {
            if (!bVar.d()) {
                i++;
            }
        }
        return i;
    }

    public List<com.kwad.sdk.reward.b.b> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f40751b);
        arrayList.add(this.f40752c);
        arrayList.add(this.f40753d);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f40751b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f40752c.parseJson(jSONObject.optJSONObject("mInstallAppTask"));
            this.f40753d.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.f40751b);
        t.a(jSONObject, "mInstallAppTask", this.f40752c);
        t.a(jSONObject, "mUseAppTask", this.f40753d);
        return jSONObject;
    }
}
