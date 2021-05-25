package d.a.l0.a.w1.j;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.r0.n;
import d.a.l0.a.v2.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45614a = k.f43199a;

    public static JSONObject a(List<String> list, float f2) {
        if (f45614a) {
            Log.d("PublisherCompress", "start compress");
        }
        ArrayList arrayList = new ArrayList();
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            return null;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                File k = u.k(file.getName());
                if (u.b(file, k, (int) (100.0f * f2))) {
                    arrayList.add(k);
                }
            }
        }
        return b(arrayList, i2);
    }

    public static JSONObject b(ArrayList<File> arrayList, d.a.l0.a.a2.e eVar) {
        String J;
        JSONObject jSONObject = new JSONObject();
        boolean m0 = eVar.m0();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next != null) {
                    if (m0) {
                        J = n.V(next.getAbsolutePath());
                    } else {
                        J = d.a.l0.a.k2.b.J(next.getAbsolutePath(), eVar.f40749f);
                    }
                    if (f45614a) {
                        Log.d("PublisherCompress", "isSwanGame: " + m0 + "; path: " + J);
                    }
                    jSONArray.put(J);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", J);
                    jSONObject2.put("size", next.length());
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("tempFilePaths", jSONArray);
            jSONObject.put("tempFiles", jSONArray2);
        } catch (JSONException e2) {
            if (f45614a) {
                Log.e("PublisherCompress", "wrapParams failed");
                e2.printStackTrace();
            }
        }
        if (f45614a) {
            Log.e("PublisherCompress", jSONObject.toString());
        }
        return jSONObject;
    }
}
