package d.c.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d0 extends z {
    public String m;
    public boolean n;
    public String o;

    public d0(String str, boolean z, String str2) {
        this.o = str;
        this.n = z;
        this.m = str2;
    }

    @Override // d.c.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f65112e = cursor.getLong(0);
        this.f65113f = cursor.getLong(1);
        this.f65114g = cursor.getString(2);
        this.f65115h = cursor.getString(3);
        this.o = cursor.getString(4);
        this.m = cursor.getString(5);
        this.n = cursor.getInt(6) == 1;
        this.i = cursor.getString(7);
        this.j = cursor.getString(8);
        return this;
    }

    @Override // d.c.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f65112e));
        contentValues.put("tea_event_index", Long.valueOf(this.f65113f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        contentValues.put("user_unique_id", this.f65115h);
        contentValues.put("event", this.o);
        if (this.n && this.m == null) {
            try {
                p();
            } catch (JSONException e2) {
                r0.b(e2);
            }
        }
        contentValues.put("params", this.m);
        contentValues.put("is_bav", Integer.valueOf(this.n ? 1 : 0));
        contentValues.put("ab_version", this.i);
        contentValues.put("ab_sdk_version", this.j);
    }

    @Override // d.c.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f65112e);
        jSONObject.put("tea_event_index", this.f65113f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        jSONObject.put("user_unique_id", this.f65115h);
        jSONObject.put("event", this.o);
        if (this.n && this.m == null) {
            p();
        }
        jSONObject.put("params", this.m);
        jSONObject.put("is_bav", this.n);
        jSONObject.put("ab_version", this.i);
        jSONObject.put("ab_sdk_version", this.j);
    }

    @Override // d.c.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "event", "varchar", "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // d.c.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f65112e = jSONObject.optLong("local_time_ms", 0L);
        this.f65113f = jSONObject.optLong("tea_event_index", 0L);
        this.f65114g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.f65115h = jSONObject.optString("user_unique_id", null);
        this.o = jSONObject.optString("event", null);
        this.m = jSONObject.optString("params", null);
        this.n = jSONObject.optBoolean("is_bav", false);
        this.i = jSONObject.optString("ab_version", null);
        this.j = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // d.c.b.z
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f65112e);
        jSONObject.put("tea_event_index", this.f65113f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        if (!TextUtils.isEmpty(this.f65115h)) {
            jSONObject.put("user_unique_id", this.f65115h);
        }
        jSONObject.put("event", this.o);
        if (this.n) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("params", new JSONObject(this.m));
        }
        jSONObject.put("datetime", this.k);
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("ab_version", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        return jSONObject;
    }

    @Override // d.c.b.z
    @NonNull
    public String k() {
        return "eventv3";
    }

    @Override // d.c.b.z
    public String o() {
        return this.o;
    }

    public void p() {
    }

    public String q() {
        return this.o;
    }
}
