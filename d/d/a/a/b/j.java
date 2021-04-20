package d.d.a.a.b;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f66778a;

    /* renamed from: b  reason: collision with root package name */
    public long f66779b;

    /* renamed from: c  reason: collision with root package name */
    public String f66780c;

    /* renamed from: d  reason: collision with root package name */
    public String f66781d;

    /* renamed from: e  reason: collision with root package name */
    public String f66782e;

    /* renamed from: f  reason: collision with root package name */
    public long f66783f;

    /* renamed from: g  reason: collision with root package name */
    public String f66784g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f66785h;

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        j jVar = new j();
        jVar.f66778a = str;
        jVar.f66779b = j;
        jVar.f66781d = str2;
        jVar.f66783f = j2;
        jVar.f66782e = str3;
        jVar.f66784g = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            jVar.f66780c = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            jVar.f66785h = map;
        }
        return jVar;
    }

    public JSONObject b() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f66778a);
            jSONObject.put("et", this.f66779b);
            jSONObject.put("nu", this.f66783f);
            if (!TextUtils.isEmpty(this.f66781d)) {
                jSONObject.put("eg", this.f66781d);
            }
            jSONObject.putOpt("lk", this.f66782e);
            if (this.f66780c != null) {
                jSONObject.put("ev", this.f66780c);
            }
            if (!TextUtils.isEmpty(this.f66784g)) {
                jSONObject.put("at", this.f66784g);
            }
            if (this.f66785h != null && !this.f66785h.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.f66785h.entrySet()) {
                    if (entry.getValue() instanceof Integer) {
                        jSONObject.put(entry.getKey(), ((Integer) entry.getValue()).intValue());
                    } else if (entry.getValue() instanceof Long) {
                        jSONObject.put(entry.getKey(), ((Long) entry.getValue()).longValue());
                    } else if (entry.getValue() instanceof Double) {
                        jSONObject.put(entry.getKey(), ((Double) entry.getValue()).doubleValue());
                    } else if (entry.getValue() instanceof Short) {
                        jSONObject.put(entry.getKey(), (int) ((Short) entry.getValue()).shortValue());
                    } else if (entry.getValue() instanceof Float) {
                        jSONObject.put(entry.getKey(), ((Float) entry.getValue()).floatValue());
                    } else if (entry.getValue() instanceof Byte) {
                        jSONObject.put(entry.getKey(), (int) ((Byte) entry.getValue()).byteValue());
                    } else if (entry.getValue() instanceof String) {
                        jSONObject.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        throw null;
    }
}
