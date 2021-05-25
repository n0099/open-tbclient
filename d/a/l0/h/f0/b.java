package d.a.l0.h.f0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47370c;

    /* renamed from: a  reason: collision with root package name */
    public int f47371a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f47372b = new ArrayList<>(20);

    public static b c() {
        if (f47370c == null) {
            synchronized (b.class) {
                if (f47370c == null) {
                    f47370c = new b();
                }
            }
        }
        return f47370c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f47372b.size() < 20) {
            this.f47372b.add(aVar);
        } else {
            this.f47371a++;
        }
    }

    public synchronized void b() {
        this.f47372b.clear();
        this.f47371a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f47372b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f47371a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f47372b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f47372b.clear();
        return jSONObject;
    }
}
