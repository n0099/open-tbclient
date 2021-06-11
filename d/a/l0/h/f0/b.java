package d.a.l0.h.f0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f51044c;

    /* renamed from: a  reason: collision with root package name */
    public int f51045a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f51046b = new ArrayList<>(20);

    public static b c() {
        if (f51044c == null) {
            synchronized (b.class) {
                if (f51044c == null) {
                    f51044c = new b();
                }
            }
        }
        return f51044c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f51046b.size() < 20) {
            this.f51046b.add(aVar);
        } else {
            this.f51045a++;
        }
    }

    public synchronized void b() {
        this.f51046b.clear();
        this.f51045a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f51046b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f51045a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f51046b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f51046b.clear();
        return jSONObject;
    }
}
