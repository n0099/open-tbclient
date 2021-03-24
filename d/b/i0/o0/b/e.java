package d.b.i0.o0.b;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class e {
    public static void a() {
        d.b.h0.r.d0.b.i().w(d.b.h0.r.d0.b.m("search_forum_history"), "");
    }

    public static void b(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String o = d.b.h0.r.d0.b.i().o(d.b.h0.r.d0.b.m("search_forum_history"), "");
        if (StringUtils.isNull(o)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(o);
            if (jSONArray.length() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (!str.equals(obj)) {
                    arrayList.add((String) obj);
                }
            }
            d.b.h0.r.d0.b.i().w(d.b.h0.r.d0.b.m("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<String> c() {
        String o = d.b.h0.r.d0.b.i().o(d.b.h0.r.d0.b.m("search_forum_history"), "");
        ArrayList<String> arrayList = null;
        if (StringUtils.isNull(o)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(o);
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    Object obj = jSONArray.get(i);
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
        String o = d.b.h0.r.d0.b.i().o(d.b.h0.r.d0.b.m("search_forum_history"), "");
        try {
            JSONArray jSONArray = StringUtils.isNull(o) ? new JSONArray() : new JSONArray(o);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            int i = 1;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object obj = jSONArray.get(i2);
                if ((obj instanceof String) && !str.equals(obj)) {
                    arrayList.add((String) obj);
                    i++;
                }
                if (i == 6) {
                    break;
                }
            }
            d.b.h0.r.d0.b.i().w(d.b.h0.r.d0.b.m("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
