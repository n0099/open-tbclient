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
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.reward.b.a {

    /* renamed from: b  reason: collision with root package name */
    public c f55775b = new c();

    /* renamed from: c  reason: collision with root package name */
    public C2127a f55776c = new C2127a();

    /* renamed from: d  reason: collision with root package name */
    public final b f55777d = new b(com.kwad.sdk.core.config.b.az());

    /* renamed from: com.kwad.sdk.reward.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2127a extends com.kwad.sdk.reward.b.a {
        public C2127a() {
            this.a = "安装应用";
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public b(int i2) {
            this.a = String.format("体验应用%s秒", i2 + "");
        }
    }

    /* loaded from: classes8.dex */
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
        if (this.f55775b.d() && this.f55776c.d() && this.f55777d.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.f55775b.d() && this.f55776c.d() && this.f55777d.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markWatchVideoCompleted");
        this.f55775b.a();
        n();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markInstallCompleted");
        this.f55776c.a();
        n();
    }

    public void i() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markInstallUncompleted");
        this.f55776c.b();
        n();
    }

    public void j() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "markUseAppCompleted");
        this.f55777d.a();
        n();
    }

    public boolean k() {
        com.kwad.sdk.core.d.a.a("LaunchAppTask", "isInstallCompleted");
        return this.f55776c.d();
    }

    public int l() {
        int i2 = 0;
        for (com.kwad.sdk.reward.b.b bVar : m()) {
            if (!bVar.d()) {
                i2++;
            }
        }
        return i2;
    }

    public List<com.kwad.sdk.reward.b.b> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f55775b);
        arrayList.add(this.f55776c);
        arrayList.add(this.f55777d);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f55775b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f55776c.parseJson(jSONObject.optJSONObject("mInstallAppTask"));
            this.f55777d.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.f55775b);
        t.a(jSONObject, "mInstallAppTask", this.f55776c);
        t.a(jSONObject, "mUseAppTask", this.f55777d);
        return jSONObject;
    }
}
