package d.b.h0.g.w.f;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
import d.b.h0.g.e.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49332b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public List<c> f49333a = new ArrayList();

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (f49332b) {
            Log.d("SwanGamePreloadConfig", "jsonArray:" + jSONArray);
        }
        int length = jSONArray.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
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
                    if (c2 == 1 && i2 < 10) {
                        this.f49333a.add(a(optJSONObject));
                        i2++;
                    }
                } else if (i < 3) {
                    this.f49333a.add(b(optJSONObject));
                    i++;
                }
            }
        }
    }

    public final c a(@NonNull JSONObject jSONObject) {
        c cVar = new c();
        cVar.G("type", jSONObject.optString("type"));
        cVar.G("url", jSONObject.optString("url"));
        cVar.G("filePath", jSONObject.optString("filePath"));
        cVar.G("header", c(jSONObject.optJSONObject("header")));
        return cVar;
    }

    public final c b(@NonNull JSONObject jSONObject) {
        c cVar = new c();
        cVar.G("type", jSONObject.optString("type"));
        cVar.G("url", jSONObject.optString("url"));
        cVar.G("responseType", jSONObject.optString("responseType"));
        cVar.G("header", c(jSONObject.optJSONObject("header")));
        return cVar;
    }

    public final c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            cVar.G(next, jSONObject.optString(next));
        }
        return cVar;
    }
}
