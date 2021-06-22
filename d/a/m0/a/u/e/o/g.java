package d.a.m0.a.u.e.o;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends d.a.m0.a.u.c.d {
    public g(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b r(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-PhoneCallApi", "start make phone call");
        }
        if (l()) {
            d.a.m0.a.e0.d.b("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
            return new d.a.m0.a.u.h.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-PhoneCallApi", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            d.a.m0.a.e0.d.b("Api-PhoneCallApi", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        if (jSONObject != null) {
            String optString = jSONObject.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.fromParts("tel", optString, null));
            }
        }
        if (d.a.m0.a.v2.f.g(i(), intent)) {
            return new d.a.m0.a.u.h.b(0);
        }
        return new d.a.m0.a.u.h.b(1001);
    }
}
