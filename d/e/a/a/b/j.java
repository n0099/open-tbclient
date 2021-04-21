package d.e.a.a.b;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f66925a;

    /* renamed from: b  reason: collision with root package name */
    public long f66926b;

    /* renamed from: c  reason: collision with root package name */
    public String f66927c;

    /* renamed from: d  reason: collision with root package name */
    public String f66928d;

    /* renamed from: e  reason: collision with root package name */
    public String f66929e;

    /* renamed from: f  reason: collision with root package name */
    public long f66930f;

    /* renamed from: g  reason: collision with root package name */
    public String f66931g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f66932h;

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        j jVar = new j();
        jVar.f66925a = str;
        jVar.f66926b = j;
        jVar.f66928d = str2;
        jVar.f66930f = j2;
        jVar.f66929e = str3;
        jVar.f66931g = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            jVar.f66927c = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            jVar.f66932h = map;
        }
        return jVar;
    }

    public JSONObject b() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f66925a);
            jSONObject.put("et", this.f66926b);
            jSONObject.put("nu", this.f66930f);
            if (!TextUtils.isEmpty(this.f66928d)) {
                jSONObject.put("eg", this.f66928d);
            }
            jSONObject.putOpt("lk", this.f66929e);
            if (this.f66927c != null) {
                jSONObject.put("ev", this.f66927c);
            }
            if (!TextUtils.isEmpty(this.f66931g)) {
                jSONObject.put("at", this.f66931g);
            }
            if (this.f66932h != null && !this.f66932h.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.f66932h.entrySet()) {
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
