package d.a.i0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public List<x> f49648a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f49648a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.a.i0.r.d0.b.j().x("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.a.i0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                x xVar = new x();
                x xVar2 = new x();
                xVar.b(jSONArray.getJSONObject(i2));
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    xVar2.b(jSONArray2.getJSONObject(i3));
                    if (xVar.f49651c != null && xVar.f49651c.equals(xVar2.f49651c)) {
                        if (!TextUtils.isEmpty(xVar2.f49652d) && xVar2.f49652d.equals(xVar.f49652d)) {
                            z = false;
                            xVar.f49653e = z;
                        }
                        z = true;
                        xVar.f49653e = z;
                    }
                }
                if (!xVar.a()) {
                    this.f49648a.add(xVar);
                }
            }
            d.a.i0.r.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
