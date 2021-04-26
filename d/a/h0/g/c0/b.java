package d.a.h0.g.c0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46206c;

    /* renamed from: a  reason: collision with root package name */
    public int f46207a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f46208b = new ArrayList<>(20);

    public static b c() {
        if (f46206c == null) {
            synchronized (b.class) {
                if (f46206c == null) {
                    f46206c = new b();
                }
            }
        }
        return f46206c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f46208b.size() < 20) {
            this.f46208b.add(aVar);
        } else {
            this.f46207a++;
        }
    }

    public synchronized void b() {
        this.f46208b.clear();
        this.f46207a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f46208b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f46207a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f46208b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f46208b.clear();
        return jSONObject;
    }
}
