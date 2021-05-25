package d.a.l0.a.u.e.o;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.e2.c.j.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends d.a.l0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public int f45170d;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45172f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45173g;

        public a(String str, String str2, String str3) {
            this.f45171e = str;
            this.f45172f = str2;
            this.f45173g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                int b2 = iVar.b();
                j.this.d(this.f45171e, new d.a.l0.a.u.h.b(b2, d.a.l0.a.e2.c.d.f(b2)));
                return;
            }
            j.this.t(this.f45172f, this.f45173g);
            j.this.d(this.f45171e, new d.a.l0.a.u.h.b(0));
        }
    }

    public j(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void r() {
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43186b = "sms_panel";
        fVar.f43189e = String.valueOf(this.f45170d);
        fVar.a("appid", d.a.l0.a.a2.d.g().getAppId());
        d.a.l0.a.j2.k.u("1639", fVar);
    }

    public final String s(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        this.f45170d = jSONArray.length();
        for (int i2 = 0; i2 < this.f45170d; i2++) {
            String optString = jSONArray.optString(i2);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            sb.append(optString);
            if (i2 != this.f45170d - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public void t(@NonNull String str, @NonNull String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        i().startActivity(intent);
        r();
    }

    public d.a.l0.a.u.h.b u(String str) {
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-ShowSMSPanel", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            d.a.l0.a.e0.d.b("Api-ShowSMSPanel", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        d.a.l0.a.e0.d.a("Api-ShowSMSPanel", "params: ", jSONObject);
        String optString = jSONObject.optString("content");
        JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
        if (optJSONArray == null) {
            return new d.a.l0.a.u.h.b(202);
        }
        String s = s(optJSONArray);
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(optString)) {
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.l0.a.u.h.b(202);
            }
            d.a.l0.a.a2.d.g().r().T().g(i(), "scope_show_sms_panel", new a(optString2, s, optString));
            return new d.a.l0.a.u.h.b(0);
        }
        return new d.a.l0.a.u.h.b(202);
    }
}
