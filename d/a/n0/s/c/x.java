package d.a.n0.s.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public List<y> f54326a;

    public void a(JSONArray jSONArray) {
        boolean z;
        this.f54326a = new ArrayList();
        try {
            if (jSONArray == null) {
                d.a.n0.r.d0.b.j().x("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(d.a.n0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                y yVar = new y();
                y yVar2 = new y();
                yVar.b(jSONArray.getJSONObject(i2));
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    yVar2.b(jSONArray2.getJSONObject(i3));
                    if (yVar.f54329c != null && yVar.f54329c.equals(yVar2.f54329c)) {
                        if (!TextUtils.isEmpty(yVar2.f54331e) && yVar2.f54331e.equals(yVar.f54331e)) {
                            z = false;
                            yVar.f54332f = z;
                        }
                        z = true;
                        yVar.f54332f = z;
                    }
                }
                if (!yVar.a()) {
                    this.f54326a.add(yVar);
                }
            }
            d.a.n0.r.d0.b.j().x("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
