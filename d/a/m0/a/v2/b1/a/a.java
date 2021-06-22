package d.a.m0.a.v2.b1.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import d.a.m0.a.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49141a = k.f46983a;

    public static List<JSONObject> a(String str) {
        String schemesDes = SchemeCollecter.getSchemesDes(str, 0);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(schemesDes);
            arrayList.add(jSONObject);
            int i2 = jSONObject.getInt("totalSlices");
            for (int i3 = 1; i3 < i2; i3++) {
                arrayList.add(new JSONObject(SchemeCollecter.getSchemesDes(str, i3)));
            }
            return arrayList;
        } catch (JSONException e2) {
            if (f49141a) {
                Log.e("SwanAppCompat", "getDescriptions", e2);
                return null;
            }
            return null;
        }
    }

    @Nullable
    public static List<JSONObject> b(@NonNull String str, @NonNull String str2) {
        List<JSONObject> a2 = a(str);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        d.a.m0.a.e1.a aVar = new d.a.m0.a.e1.a();
        boolean z = false;
        for (JSONObject jSONObject : a2) {
            JSONArray optJSONArray = jSONObject.optJSONArray("descriptions");
            if (optJSONArray != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null && TextUtils.equals(aVar.a(), str) && TextUtils.equals(aVar.c(), optJSONObject.optString("name"))) {
                        try {
                            aVar.b(optJSONObject);
                            optJSONArray.put(i2, optJSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    break;
                }
            }
        }
        return a2;
    }
}
