package d.d.a.a.b;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f65933a;

    /* renamed from: b  reason: collision with root package name */
    public long f65934b;

    /* renamed from: c  reason: collision with root package name */
    public String f65935c;

    /* renamed from: d  reason: collision with root package name */
    public String f65936d;

    /* renamed from: e  reason: collision with root package name */
    public String f65937e;

    /* renamed from: f  reason: collision with root package name */
    public long f65938f;

    /* renamed from: g  reason: collision with root package name */
    public String f65939g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f65940h;

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        j jVar = new j();
        jVar.f65933a = str;
        jVar.f65934b = j;
        jVar.f65936d = str2;
        jVar.f65938f = j2;
        jVar.f65937e = str3;
        jVar.f65939g = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            jVar.f65935c = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            jVar.f65940h = map;
        }
        return jVar;
    }

    public JSONObject b() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f65933a);
            jSONObject.put("et", this.f65934b);
            jSONObject.put("nu", this.f65938f);
            if (!TextUtils.isEmpty(this.f65936d)) {
                jSONObject.put("eg", this.f65936d);
            }
            jSONObject.putOpt("lk", this.f65937e);
            if (this.f65935c != null) {
                jSONObject.put("ev", this.f65935c);
            }
            if (!TextUtils.isEmpty(this.f65939g)) {
                jSONObject.put("at", this.f65939g);
            }
            if (this.f65940h != null && !this.f65940h.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.f65940h.entrySet()) {
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
