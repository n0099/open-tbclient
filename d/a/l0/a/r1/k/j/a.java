package d.a.l0.a.r1.k.j;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f48187b = "boxjs.";

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f48188c = Sets.newHashSet("getAppInfoSync", "performpanel", "statisticEvent", "ubcReport", "getSlaveIdSync", "ubcFlowJar");

    @Override // d.a.l0.a.r1.k.j.c
    public List<d.a.l0.a.r1.k.a> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
        c("api-name " + optString);
        if (TextUtils.isEmpty(optString)) {
            return arrayList;
        }
        int optInt = jSONObject.optInt("count");
        c("api-count " + optInt);
        if (optInt <= 0) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("startTime");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("endTime");
        if (optJSONArray != null && optJSONArray2 != null) {
            int min = Math.min(optJSONArray.length(), optJSONArray2.length());
            if (min <= 0) {
                return arrayList;
            }
            for (int i2 = 0; i2 < min; i2++) {
                d.a.l0.a.r1.k.a aVar = new d.a.l0.a.r1.k.a();
                aVar.f(optString);
                aVar.g(b(aVar));
                aVar.i(optJSONArray.optLong(i2));
                aVar.h(optJSONArray2.optLong(i2));
                arrayList.add(aVar);
                if (c.f48189a) {
                    c(aVar.toString());
                }
            }
            return arrayList;
        }
        c("startTimes or endTimes is empty");
        return arrayList;
    }

    public final int b(d.a.l0.a.r1.k.a aVar) {
        String a2 = aVar.a();
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        return (a2.startsWith(this.f48187b) || this.f48188c.contains(a2)) ? 1 : 0;
    }

    public final void c(String str) {
        if (c.f48189a) {
            Log.d("Api-Parser", str);
        }
    }
}
