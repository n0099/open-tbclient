package d.a.m0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public List<y> f54219a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f54219a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.a.m0.r.d0.b.j().x("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.a.m0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                y yVar = new y();
                y yVar2 = new y();
                yVar.b(jSONArray.getJSONObject(i2));
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    yVar2.b(jSONArray2.getJSONObject(i3));
                    if (yVar.f54222c != null && yVar.f54222c.equals(yVar2.f54222c)) {
                        if (!TextUtils.isEmpty(yVar2.f54224e) && yVar2.f54224e.equals(yVar.f54224e)) {
                            z = false;
                            yVar.f54225f = z;
                        }
                        z = true;
                        yVar.f54225f = z;
                    }
                }
                if (!yVar.a()) {
                    this.f54219a.add(yVar);
                }
            }
            d.a.m0.r.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
