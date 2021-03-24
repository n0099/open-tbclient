package d.b.g0.a.t.c.m;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends d.b.g0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public int f46181d;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46183f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46184g;

        public a(String str, String str2, String str3) {
            this.f46182e = str;
            this.f46183f = str2;
            this.f46184g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                int b2 = hVar.b();
                i.this.c(this.f46182e, new d.b.g0.a.t.e.b(b2, d.b.g0.a.v1.c.c.f(b2)));
                return;
            }
            i.this.s(this.f46183f, this.f46184g);
            i.this.c(this.f46182e, new d.b.g0.a.t.e.b(0));
        }
    }

    public i(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void q() {
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47251b = "sms_panel";
        fVar.f47253d = String.valueOf(this.f46181d);
        fVar.a("appid", d.b.g0.a.r1.d.e().getAppId());
        d.b.g0.a.z1.h.u("1639", fVar);
    }

    public final String r(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        this.f46181d = jSONArray.length();
        for (int i = 0; i < this.f46181d; i++) {
            String optString = jSONArray.optString(i);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            sb.append(optString);
            if (i != this.f46181d - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public void s(@NonNull String str, @NonNull String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        h().startActivity(intent);
        q();
    }

    public d.b.g0.a.t.e.b t(String str) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-ShowSMSPanel", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.g0.a.c0.c.b("Api-ShowSMSPanel", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        d.b.g0.a.c0.c.a("Api-ShowSMSPanel", "params: ", jSONObject);
        String optString = jSONObject.optString("content");
        JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
        if (optJSONArray == null) {
            return new d.b.g0.a.t.e.b(202);
        }
        String r = r(optJSONArray);
        if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(optString)) {
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.b.g0.a.t.e.b(202);
            }
            d.b.g0.a.r1.d.e().s().R().g(h(), "scope_show_sms_panel", new a(optString2, r, optString));
            return new d.b.g0.a.t.e.b(0);
        }
        return new d.b.g0.a.t.e.b(202);
    }
}
