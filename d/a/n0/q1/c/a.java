package d.a.n0.q1.c;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f62010a;

    public void a(JSONArray jSONArray) {
        this.f62010a = new ArrayList();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            if (!StringUtils.isNull(optString)) {
                this.f62010a.add(optString);
            }
        }
    }
}
