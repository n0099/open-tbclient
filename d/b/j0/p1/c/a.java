package d.b.j0.p1.c;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f59344a;

    public void a(JSONArray jSONArray) {
        this.f59344a = new ArrayList();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!StringUtils.isNull(optString)) {
                this.f59344a.add(optString);
            }
        }
    }
}
