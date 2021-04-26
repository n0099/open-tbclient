package d.a.h0.a.t.c.m;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d.a.h0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public int f44290d;

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44292f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44293g;

        public a(String str, String str2, String str3) {
            this.f44291e = str;
            this.f44292f = str2;
            this.f44293g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                int b2 = hVar.b();
                i.this.c(this.f44291e, new d.a.h0.a.t.e.b(b2, d.a.h0.a.v1.c.c.f(b2)));
                return;
            }
            i.this.s(this.f44292f, this.f44293g);
            i.this.c(this.f44291e, new d.a.h0.a.t.e.b(0));
        }
    }

    public i(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void q() {
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45412b = "sms_panel";
        fVar.f45414d = String.valueOf(this.f44290d);
        fVar.a("appid", d.a.h0.a.r1.d.e().getAppId());
        d.a.h0.a.z1.h.u("1639", fVar);
    }

    public final String r(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        this.f44290d = jSONArray.length();
        for (int i2 = 0; i2 < this.f44290d; i2++) {
            String optString = jSONArray.optString(i2);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            sb.append(optString);
            if (i2 != this.f44290d - 1) {
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

    public d.a.h0.a.t.e.b t(String str) {
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-ShowSMSPanel", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            d.a.h0.a.c0.c.b("Api-ShowSMSPanel", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        d.a.h0.a.c0.c.a("Api-ShowSMSPanel", "params: ", jSONObject);
        String optString = jSONObject.optString("content");
        JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
        if (optJSONArray == null) {
            return new d.a.h0.a.t.e.b(202);
        }
        String r = r(optJSONArray);
        if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(optString)) {
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.h0.a.t.e.b(202);
            }
            d.a.h0.a.r1.d.e().p().R().g(h(), "scope_show_sms_panel", new a(optString2, r, optString));
            return new d.a.h0.a.t.e.b(0);
        }
        return new d.a.h0.a.t.e.b(202);
    }
}
