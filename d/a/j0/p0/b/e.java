package d.a.j0.p0.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class e {
    public static void a() {
        d.a.i0.r.d0.b.j().x(d.a.i0.r.d0.b.n("search_forum_history"), "");
    }

    public static void b(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String p = d.a.i0.r.d0.b.j().p(d.a.i0.r.d0.b.n("search_forum_history"), "");
        if (StringUtils.isNull(p)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(p);
            if (jSONArray.length() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object obj = jSONArray.get(i2);
                if (!str.equals(obj)) {
                    arrayList.add((String) obj);
                }
            }
            d.a.i0.r.d0.b.j().x(d.a.i0.r.d0.b.n("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<String> c() {
        String p = d.a.i0.r.d0.b.j().p(d.a.i0.r.d0.b.n("search_forum_history"), "");
        ArrayList<String> arrayList = null;
        if (StringUtils.isNull(p)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(p);
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    Object obj = jSONArray.get(i2);
                    if (obj instanceof String) {
                        arrayList2.add((String) obj);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public static void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String p = d.a.i0.r.d0.b.j().p(d.a.i0.r.d0.b.n("search_forum_history"), "");
        try {
            JSONArray jSONArray = StringUtils.isNull(p) ? new JSONArray() : new JSONArray(p);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            int i2 = 1;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object obj = jSONArray.get(i3);
                if ((obj instanceof String) && !str.equals(obj)) {
                    arrayList.add((String) obj);
                    i2++;
                }
                if (i2 == 6) {
                    break;
                }
            }
            d.a.i0.r.d0.b.j().x(d.a.i0.r.d0.b.n("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
