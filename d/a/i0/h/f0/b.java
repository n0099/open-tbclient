package d.a.i0.h.f0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47194c;

    /* renamed from: a  reason: collision with root package name */
    public int f47195a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f47196b = new ArrayList<>(20);

    public static b c() {
        if (f47194c == null) {
            synchronized (b.class) {
                if (f47194c == null) {
                    f47194c = new b();
                }
            }
        }
        return f47194c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f47196b.size() < 20) {
            this.f47196b.add(aVar);
        } else {
            this.f47195a++;
        }
    }

    public synchronized void b() {
        this.f47196b.clear();
        this.f47195a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f47196b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f47195a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f47196b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f47196b.clear();
        return jSONObject;
    }
}
