package d.b.h0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public List<v> f51231a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f51231a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.b.h0.r.d0.b.i().w("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.b.h0.r.d0.b.i().o("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                v vVar = new v();
                v vVar2 = new v();
                vVar.b(jSONArray.getJSONObject(i));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    vVar2.b(jSONArray2.getJSONObject(i2));
                    if (vVar.f51234c != null && vVar.f51234c.equals(vVar2.f51234c)) {
                        if (!TextUtils.isEmpty(vVar2.f51235d) && vVar2.f51235d.equals(vVar.f51235d)) {
                            z = false;
                            vVar.f51236e = z;
                        }
                        z = true;
                        vVar.f51236e = z;
                    }
                }
                if (!vVar.a()) {
                    this.f51231a.add(vVar);
                }
            }
            d.b.h0.r.d0.b.i().w("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
