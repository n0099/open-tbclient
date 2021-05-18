package d.a.i0.a.o0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f43738c;

    public b(@NonNull String str) {
        this(str, null);
    }

    @Override // d.a.i0.a.o0.d.a
    public String f(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f43738c.entrySet()) {
            sb.append(d.a.i0.a.o0.a.c(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f43738c.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            if (a.f43730b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public b(@NonNull String str, @Nullable Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.f43738c = hashMap;
        this.f43731a = str;
        if (map != null) {
            hashMap.putAll(map);
        }
    }
}
