package d.b.h0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public List<x> f51657a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f51657a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.b.h0.r.d0.b.j().x("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.b.h0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                x xVar = new x();
                x xVar2 = new x();
                xVar.b(jSONArray.getJSONObject(i));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    xVar2.b(jSONArray2.getJSONObject(i2));
                    if (xVar.f51660c != null && xVar.f51660c.equals(xVar2.f51660c)) {
                        if (!TextUtils.isEmpty(xVar2.f51661d) && xVar2.f51661d.equals(xVar.f51661d)) {
                            z = false;
                            xVar.f51662e = z;
                        }
                        z = true;
                        xVar.f51662e = z;
                    }
                }
                if (!xVar.a()) {
                    this.f51657a.add(xVar);
                }
            }
            d.b.h0.r.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
