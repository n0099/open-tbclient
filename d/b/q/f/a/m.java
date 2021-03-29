package d.b.q.f.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {

    /* loaded from: classes2.dex */
    public static class a implements Comparator<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64377e;

        public a(String str) {
            this.f64377e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            return jSONObject.optString(this.f64377e, "").compareTo(jSONObject2.optString(this.f64377e, ""));
        }
    }

    public static JSONArray a(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(optJSONObject);
            }
        }
        Collections.sort(arrayList, new a(str));
        return new JSONArray((Collection) arrayList);
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String optString = jSONObject.optString(str);
        String optString2 = jSONObject2.optString(str);
        return TextUtils.isEmpty(optString) ? !TextUtils.isEmpty(optString2) : !optString.equals(optString2);
    }

    public static boolean c(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject.optLong(str, -1L) != jSONObject2.optLong(str, -1L);
    }
}
