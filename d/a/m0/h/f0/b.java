package d.a.m0.h.f0;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f51152c;

    /* renamed from: a  reason: collision with root package name */
    public int f51153a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f51154b = new ArrayList<>(20);

    public static b c() {
        if (f51152c == null) {
            synchronized (b.class) {
                if (f51152c == null) {
                    f51152c = new b();
                }
            }
        }
        return f51152c;
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f51154b.size() < 20) {
            this.f51154b.add(aVar);
        } else {
            this.f51153a++;
        }
    }

    public synchronized void b() {
        this.f51154b.clear();
        this.f51153a = 0;
    }

    public synchronized JSONObject d() {
        int size = this.f51154b.size();
        if (size == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dropcnt", this.f51153a);
            jSONObject.put("errorcnt", size);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("errors", jSONArray);
            Iterator<a> it = this.f51154b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
        } catch (JSONException unused) {
        }
        this.f51154b.clear();
        return jSONObject;
    }
}
