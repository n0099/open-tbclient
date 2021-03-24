package d.b.h0.s.c;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class g {
    public static List<String> a() {
        String o = d.b.h0.r.d0.b.i().o("scheme_white_list", null);
        if (StringUtils.isNull(o)) {
            return null;
        }
        try {
            return b(new JSONArray(o));
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            if (!StringUtils.isNull(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    public static void c(JSONArray jSONArray) {
        if (jSONArray == null) {
            d.b.h0.r.d0.b.i().w("scheme_white_list", "");
        } else {
            d.b.h0.r.d0.b.i().w("scheme_white_list", jSONArray.toString());
        }
    }
}
