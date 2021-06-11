package d.d.a.a.b;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f69795a;

    /* renamed from: b  reason: collision with root package name */
    public long f69796b;

    /* renamed from: c  reason: collision with root package name */
    public String f69797c;

    /* renamed from: d  reason: collision with root package name */
    public String f69798d;

    /* renamed from: e  reason: collision with root package name */
    public String f69799e;

    /* renamed from: f  reason: collision with root package name */
    public long f69800f;

    /* renamed from: g  reason: collision with root package name */
    public String f69801g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, Object> f69802h;

    public static j a(String str, long j, String str2, long j2, String str3, Collection<String> collection, Map<String, Object> map, String str4) {
        j jVar = new j();
        jVar.f69795a = str;
        jVar.f69796b = j;
        jVar.f69798d = str2;
        jVar.f69800f = j2;
        jVar.f69799e = str3;
        jVar.f69801g = str4;
        if (collection != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            jVar.f69797c = jSONArray.toString();
        }
        if (map != null && !map.isEmpty()) {
            jVar.f69802h = map;
        }
        return jVar;
    }

    public JSONObject b() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f69795a);
            jSONObject.put("et", this.f69796b);
            jSONObject.put("nu", this.f69800f);
            if (!TextUtils.isEmpty(this.f69798d)) {
                jSONObject.put("eg", this.f69798d);
            }
            jSONObject.putOpt("lk", this.f69799e);
            if (this.f69797c != null) {
                jSONObject.put("ev", this.f69797c);
            }
            if (!TextUtils.isEmpty(this.f69801g)) {
                jSONObject.put("at", this.f69801g);
            }
            if (this.f69802h != null && !this.f69802h.isEmpty()) {
                for (Map.Entry<String, Object> entry : this.f69802h.entrySet()) {
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
