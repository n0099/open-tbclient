package d.d.a.a.b;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f65932a;

    /* renamed from: b  reason: collision with root package name */
    public long f65933b;

    /* renamed from: c  reason: collision with root package name */
    public String f65934c;

    /* renamed from: d  reason: collision with root package name */
    public String f65935d;

    /* renamed from: e  reason: collision with root package name */
    public String f65936e;

    /* renamed from: f  reason: collision with root package name */
    public long f65937f;

    /* renamed from: g  reason: collision with root package name */
    public String f65938g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f65939h;

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        j jVar = new j();
        jVar.f65932a = str;
        jVar.f65933b = j;
        jVar.f65935d = str2;
        jVar.f65937f = j2;
        jVar.f65936e = str3;
        jVar.f65938g = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            jVar.f65934c = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            jVar.f65939h = map;
        }
        return jVar;
    }

    public JSONObject b() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f65932a);
            jSONObject.put("et", this.f65933b);
            jSONObject.put("nu", this.f65937f);
            if (!TextUtils.isEmpty(this.f65935d)) {
                jSONObject.put("eg", this.f65935d);
            }
            jSONObject.putOpt("lk", this.f65936e);
            if (this.f65934c != null) {
                jSONObject.put("ev", this.f65934c);
            }
            if (!TextUtils.isEmpty(this.f65938g)) {
                jSONObject.put("at", this.f65938g);
            }
            if (this.f65939h != null && !this.f65939h.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.f65939h.entrySet()) {
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
