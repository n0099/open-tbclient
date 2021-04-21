package d.b.i0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public List<x> f51993a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f51993a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.b.i0.r.d0.b.j().x("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.b.i0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                x xVar = new x();
                x xVar2 = new x();
                xVar.b(jSONArray.getJSONObject(i));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    xVar2.b(jSONArray2.getJSONObject(i2));
                    if (xVar.f51996c != null && xVar.f51996c.equals(xVar2.f51996c)) {
                        if (!TextUtils.isEmpty(xVar2.f51997d) && xVar2.f51997d.equals(xVar.f51997d)) {
                            z = false;
                            xVar.f51998e = z;
                        }
                        z = true;
                        xVar.f51998e = z;
                    }
                }
                if (!xVar.a()) {
                    this.f51993a.add(xVar);
                }
            }
            d.b.i0.r.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
