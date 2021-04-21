package d.b.i0.s.c;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class i {
    public static List<String> a() {
        String p = d.b.i0.r.d0.b.j().p("scheme_white_list", null);
        if (StringUtils.isNull(p)) {
            return null;
        }
        try {
            return b(new JSONArray(p));
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
            d.b.i0.r.d0.b.j().x("scheme_white_list", "");
        } else {
            d.b.i0.r.d0.b.j().x("scheme_white_list", jSONArray.toString());
        }
    }
}
