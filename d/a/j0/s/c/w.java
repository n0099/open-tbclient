package d.a.j0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public List<x> f50467a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f50467a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.a.j0.r.d0.b.j().x("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.a.j0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                x xVar = new x();
                x xVar2 = new x();
                xVar.b(jSONArray.getJSONObject(i2));
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    xVar2.b(jSONArray2.getJSONObject(i3));
                    if (xVar.f50470c != null && xVar.f50470c.equals(xVar2.f50470c)) {
                        if (!TextUtils.isEmpty(xVar2.f50471d) && xVar2.f50471d.equals(xVar.f50471d)) {
                            z = false;
                            xVar.f50472e = z;
                        }
                        z = true;
                        xVar.f50472e = z;
                    }
                }
                if (!xVar.a()) {
                    this.f50467a.add(xVar);
                }
            }
            d.a.j0.r.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
