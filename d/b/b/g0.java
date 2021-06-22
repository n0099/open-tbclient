package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g0 extends z {
    public byte[] m;
    public int n;
    public int o;
    public JSONArray p;
    public JSONArray q;
    public f0 r;
    public JSONArray s;
    public j0 t;
    public JSONObject u;
    public JSONArray v;

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f68977e = cursor.getLong(0);
        this.m = cursor.getBlob(1);
        this.n = cursor.getInt(2);
        this.u = null;
        this.r = null;
        this.t = null;
        this.s = null;
        this.p = null;
        this.q = null;
        this.v = null;
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", a.u(m().toString()));
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        r0.b(null);
    }

    @Override // d.b.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "_data", "blob", "_fail", "integer", "_full", "integer"};
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        r0.b(null);
        return null;
    }

    @Override // d.b.b.z
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.u);
        jSONObject.put("time_sync", x.f68960b);
        if (this.r != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.r.m());
            jSONObject.put("launch", jSONArray);
        }
        j0 j0Var = this.t;
        if (j0Var != null) {
            JSONObject m = j0Var.m();
            JSONArray jSONArray2 = this.s;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i2 = 0; i2 < length; i2++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.s.optString(i2)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                m.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(m);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.p;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put("event", this.p);
        }
        JSONArray jSONArray7 = this.s;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        if (this.q == null) {
            this.q = this.s;
        } else if (length3 > 0) {
            for (int i3 = 0; i3 < length3; i3++) {
                this.q.put(this.s.get(i3));
            }
        }
        JSONArray jSONArray8 = this.q;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.q);
        }
        JSONArray jSONArray9 = this.v;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.v);
        }
        StringBuilder sb = new StringBuilder("wP {");
        Object obj = this.r;
        if (obj == null) {
            obj = "la";
        }
        sb.append(obj);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        Object obj2 = this.t;
        if (obj2 == null) {
            obj2 = "te";
        }
        sb.append(obj2);
        sb.append(", p: ");
        sb.append(length3);
        sb.append(", v1: ");
        sb.append(length2);
        sb.append(", v3: ");
        sb.append(length4);
        sb.append("}");
        sb.append(", m: ");
        sb.append(length5);
        sb.append("}");
        r0.e(sb.toString(), null);
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return "pack";
    }

    public void p(long j, JSONObject jSONObject, f0 f0Var, j0 j0Var, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.f68977e = j;
        this.u = jSONObject;
        this.r = f0Var;
        this.t = j0Var;
        this.s = jSONArray;
        this.p = jSONArray2;
        this.q = jSONArray3;
        this.v = jSONArray4;
    }
}
