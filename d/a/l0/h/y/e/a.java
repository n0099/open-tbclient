package d.a.l0.h.y.e;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51420b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.l0.a.y.b.a> f51421a = new ArrayList();

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (f51420b) {
            Log.d("SwanGamePreloadConfig", "jsonArray:" + jSONArray);
        }
        int length = jSONArray.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("type");
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 1095692943) {
                    if (hashCode == 1427818632 && optString.equals("download")) {
                        c2 = 1;
                    }
                } else if (optString.equals("request")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 == 1 && i3 < 10) {
                        this.f51421a.add(a(optJSONObject));
                        i3++;
                    }
                } else if (i2 < 3) {
                    this.f51421a.add(b(optJSONObject));
                    i2++;
                }
            }
        }
    }

    public final d.a.l0.a.y.b.a a(@NonNull JSONObject jSONObject) {
        d.a.l0.a.y.b.a aVar = new d.a.l0.a.y.b.a();
        aVar.H("type", jSONObject.optString("type"));
        aVar.H("url", jSONObject.optString("url"));
        aVar.H("filePath", jSONObject.optString("filePath"));
        aVar.H("header", c(jSONObject.optJSONObject("header")));
        return aVar;
    }

    public final d.a.l0.a.y.b.a b(@NonNull JSONObject jSONObject) {
        d.a.l0.a.y.b.a aVar = new d.a.l0.a.y.b.a();
        aVar.H("type", jSONObject.optString("type"));
        aVar.H("url", jSONObject.optString("url"));
        aVar.H("responseType", jSONObject.optString("responseType"));
        aVar.H("header", c(jSONObject.optJSONObject("header")));
        return aVar;
    }

    public final d.a.l0.a.y.b.a c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.a.y.b.a aVar = new d.a.l0.a.y.b.a();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            aVar.H(next, jSONObject.optString(next));
        }
        return aVar;
    }
}
