package d.d.a.a.b;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f66021a;

    /* renamed from: b  reason: collision with root package name */
    public long f66022b;

    /* renamed from: c  reason: collision with root package name */
    public String f66023c;

    /* renamed from: d  reason: collision with root package name */
    public String f66024d;

    /* renamed from: e  reason: collision with root package name */
    public String f66025e;

    /* renamed from: f  reason: collision with root package name */
    public long f66026f;

    /* renamed from: g  reason: collision with root package name */
    public String f66027g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f66028h;

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        j jVar = new j();
        jVar.f66021a = str;
        jVar.f66022b = j;
        jVar.f66024d = str2;
        jVar.f66026f = j2;
        jVar.f66025e = str3;
        jVar.f66027g = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            jVar.f66023c = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            jVar.f66028h = map;
        }
        return jVar;
    }

    public JSONObject b() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f66021a);
            jSONObject.put("et", this.f66022b);
            jSONObject.put("nu", this.f66026f);
            if (!TextUtils.isEmpty(this.f66024d)) {
                jSONObject.put("eg", this.f66024d);
            }
            jSONObject.putOpt("lk", this.f66025e);
            if (this.f66023c != null) {
                jSONObject.put("ev", this.f66023c);
            }
            if (!TextUtils.isEmpty(this.f66027g)) {
                jSONObject.put("at", this.f66027g);
            }
            if (this.f66028h != null && !this.f66028h.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.f66028h.entrySet()) {
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
