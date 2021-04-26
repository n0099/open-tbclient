package d.a.h0.a.t.c.m;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.l0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.h0.a.t.b.d {
    public c(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b q() {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ClipboardApi", "start get clipboard data");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence a2 = l0.b(h()).a();
            jSONObject.put("data", TextUtils.isEmpty(a2) ? "" : a2.toString());
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.i("Api-ClipboardApi", "getClipboardData:  " + jSONObject);
            }
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.a.h0.a.t.b.d.f44021c) {
                e2.printStackTrace();
            }
            return new d.a.h0.a.t.e.b(1001, "JSONException");
        }
    }

    public d.a.h0.a.t.e.b r(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-ClipboardApi", "start set clipboard data");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-ClipboardApi", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-ClipboardApi", "parse fail");
            }
            return bVar;
        }
        l0.b(h()).c(((JSONObject) a2.second).optString("data"));
        return new d.a.h0.a.t.e.b(0);
    }
}
