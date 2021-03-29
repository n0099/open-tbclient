package d.b.g0.g.c0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48018c;

    /* renamed from: a  reason: collision with root package name */
    public int f48019a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f48020b = new ArrayList<>(20);

    public static b c() {
        if (f48018c == null) {
            synchronized (b.class) {
                if (f48018c == null) {
                    f48018c = new b();
                }
            }
        }
        return f48018c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f48020b.size() < 20) {
            this.f48020b.add(aVar);
        } else {
            this.f48019a++;
        }
    }

    public synchronized void b() {
        this.f48020b.clear();
        this.f48019a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f48020b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f48019a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f48020b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f48020b.clear();
        return jSONObject;
    }
}
