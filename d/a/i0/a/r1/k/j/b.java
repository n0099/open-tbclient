package d.a.i0.a.r1.k.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements c {
    @Override // d.a.i0.a.r1.k.j.c
    public List<d.a.i0.a.r1.k.a> a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        ArrayList arrayList = new ArrayList();
        String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
        c("api-name " + optString);
        if (TextUtils.isEmpty(optString)) {
            return arrayList;
        }
        int optInt = jSONObject.optInt("count");
        c("api-count " + optInt);
        if (optInt > 0 && (optJSONObject = jSONObject.optJSONObject("caller")) != null) {
            b(optString, optJSONObject.optJSONObject("swan"), arrayList, 0);
            b(optString, optJSONObject.optJSONObject("boxjs"), arrayList, 1);
            return arrayList;
        }
        return arrayList;
    }

    public final void b(String str, @Nullable JSONObject jSONObject, @NonNull List<d.a.i0.a.r1.k.a> list, int i2) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("startTime");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("endTime");
        if (optJSONArray == null || optJSONArray2 == null) {
            return;
        }
        int min = Math.min(optJSONArray.length(), optJSONArray2.length());
        for (int i3 = 0; i3 < min; i3++) {
            d.a.i0.a.r1.k.a aVar = new d.a.i0.a.r1.k.a();
            aVar.g(i2);
            aVar.f(str);
            aVar.i(optJSONArray.optLong(i3));
            aVar.h(optJSONArray2.optLong(i3));
            list.add(aVar);
        }
    }

    public final void c(String str) {
        if (c.f44339a) {
            Log.d("Api-Parser", str);
        }
    }
}
