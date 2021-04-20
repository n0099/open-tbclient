package d.b.i0.a1.c.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.s.c.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f52445a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final List<x> f52446b = new ArrayList();

    public a() {
        List<x> c2 = c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        this.f52446b.addAll(c2);
    }

    public int a() {
        return this.f52445a;
    }

    public List<x> b() {
        return this.f52446b;
    }

    public final List<x> c() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(d.b.h0.r.d0.b.j().p("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                x xVar = new x();
                xVar.b(jSONArray.getJSONObject(i));
                if (!xVar.a()) {
                    arrayList.add(xVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
