package d.b.g0.l.m.i;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f49033a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f49034b;

    public f(String str, Set<String> set) {
        this.f49033a = str;
        this.f49034b = set;
    }

    public static f a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("appkeys");
                HashSet hashSet = new HashSet();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString2 = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString2)) {
                        hashSet.add(optString2);
                    }
                }
                return new f(optString, hashSet);
            }
            return null;
        }
        return null;
    }

    public Set<String> b() {
        return this.f49034b;
    }

    public String c() {
        return this.f49033a;
    }
}
