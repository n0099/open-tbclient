package d.a.n0.b1.c.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.s.c.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f51425a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final List<y> f51426b = new ArrayList();

    public a() {
        List<y> c2 = c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        this.f51426b.addAll(c2);
    }

    public int a() {
        return this.f51425a;
    }

    public List<y> b() {
        return this.f51426b;
    }

    public final List<y> c() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(d.a.m0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                y yVar = new y();
                yVar.b(jSONArray.getJSONObject(i2));
                if (!yVar.a()) {
                    arrayList.add(yVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
