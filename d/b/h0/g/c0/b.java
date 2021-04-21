package d.b.h0.g.c0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48739c;

    /* renamed from: a  reason: collision with root package name */
    public int f48740a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f48741b = new ArrayList<>(20);

    public static b c() {
        if (f48739c == null) {
            synchronized (b.class) {
                if (f48739c == null) {
                    f48739c = new b();
                }
            }
        }
        return f48739c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f48741b.size() < 20) {
            this.f48741b.add(aVar);
        } else {
            this.f48740a++;
        }
    }

    public synchronized void b() {
        this.f48741b.clear();
        this.f48740a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f48741b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f48740a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f48741b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f48741b.clear();
        return jSONObject;
    }
}
