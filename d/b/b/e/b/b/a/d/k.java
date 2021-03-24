package d.b.b.e.b.b.a.d;

import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k implements h {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f41647a;

    public k(JSONObject jSONObject) {
        this.f41647a = jSONObject;
    }

    @Override // d.b.b.e.b.b.a.d.h
    public Object a(d.b.b.e.b.b.a.e.c cVar) {
        Class<?> a2 = cVar.a();
        Type[] b2 = cVar.b();
        if (d.b.b.e.b.a.a.g(a2, Map.class)) {
            Map<String, Object> b3 = d.b.b.e.b.b.a.e.a.b(cVar, this.f41647a.length());
            if (b3 != null) {
                Iterator<String> keys = this.f41647a.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next instanceof String) {
                        String str = next;
                        Object a3 = d.b.b.e.b.b.a.e.g.a(this.f41647a.opt(str)).a(new d.b.b.e.b.b.a.e.c(b2[1]));
                        if (a3 != null) {
                            b3.put(str, a3);
                        }
                    }
                }
            }
            return b3;
        } else if (a2 == SparseArray.class) {
            SparseArray sparseArray = new SparseArray(this.f41647a.length());
            Iterator<String> keys2 = this.f41647a.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (next2 instanceof String) {
                    String str2 = next2;
                    try {
                        int parseInt = Integer.parseInt(str2);
                        Object a4 = d.b.b.e.b.b.a.e.g.a(this.f41647a.opt(String.valueOf(str2))).a(new d.b.b.e.b.b.a.e.c(b2[0]));
                        if (a4 != null) {
                            sparseArray.put(parseInt, a4);
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return sparseArray;
        } else if (d.b.b.e.b.a.a.g(a2, d.b.b.e.b.b.a.a.a.class)) {
            return OrmObject.objectWithJson(this.f41647a, a2);
        } else {
            return null;
        }
    }
}
