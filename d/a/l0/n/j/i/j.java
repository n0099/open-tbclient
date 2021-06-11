package d.a.l0.n.j.i;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f51824a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f51825b;

    public j(String str, Set<String> set) {
        this.f51824a = str;
        this.f51825b = set;
    }

    public static j a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || (optJSONArray = optJSONObject.optJSONArray("appkeys")) == null) {
            return null;
        }
        String optString = jSONObject.optString("version");
        HashSet hashSet = new HashSet();
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            String optString2 = optJSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString2)) {
                hashSet.add(optString2);
            }
        }
        return new j(optString, hashSet);
    }

    public Set<String> b() {
        return this.f51825b;
    }

    public String c() {
        return this.f51824a;
    }
}
