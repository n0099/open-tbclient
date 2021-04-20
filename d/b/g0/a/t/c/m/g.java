package d.b.g0.a.t.c.m;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends d.b.g0.a.t.b.d {
    public g(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b q(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-PhoneCallApi", "start make phone call");
        }
        if (k()) {
            d.b.g0.a.c0.c.b("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
            return new d.b.g0.a.t.e.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-PhoneCallApi", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            d.b.g0.a.c0.c.b("Api-PhoneCallApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        if (jSONObject != null) {
            String optString = jSONObject.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse("tel:" + optString));
            }
        }
        if (d.b.g0.a.i2.e.f(h(), intent)) {
            return new d.b.g0.a.t.e.b(0);
        }
        return new d.b.g0.a.t.e.b(1001);
    }
}
