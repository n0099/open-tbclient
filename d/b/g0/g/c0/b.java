package d.b.g0.g.c0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48017c;

    /* renamed from: a  reason: collision with root package name */
    public int f48018a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f48019b = new ArrayList<>(20);

    public static b c() {
        if (f48017c == null) {
            synchronized (b.class) {
                if (f48017c == null) {
                    f48017c = new b();
                }
            }
        }
        return f48017c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f48019b.size() < 20) {
            this.f48019b.add(aVar);
        } else {
            this.f48018a++;
        }
    }

    public synchronized void b() {
        this.f48019b.clear();
        this.f48018a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f48019b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f48018a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f48019b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f48019b.clear();
        return jSONObject;
    }
}
