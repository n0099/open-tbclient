package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d0 extends z {
    public String m;
    public boolean n;
    public String o;

    public d0(String str, boolean z, String str2) {
        this.o = str;
        this.n = z;
        this.m = str2;
    }

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f68977e = cursor.getLong(0);
        this.f68978f = cursor.getLong(1);
        this.f68979g = cursor.getString(2);
        this.f68980h = cursor.getString(3);
        this.o = cursor.getString(4);
        this.m = cursor.getString(5);
        this.n = cursor.getInt(6) == 1;
        this.f68981i = cursor.getString(7);
        this.j = cursor.getString(8);
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f68977e));
        contentValues.put("tea_event_index", Long.valueOf(this.f68978f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68979g);
        contentValues.put("user_unique_id", this.f68980h);
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
        contentValues.put("ab_version", this.f68981i);
        contentValues.put("ab_sdk_version", this.j);
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f68977e);
        jSONObject.put("tea_event_index", this.f68978f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68979g);
        jSONObject.put("user_unique_id", this.f68980h);
        jSONObject.put("event", this.o);
        if (this.n && this.m == null) {
            p();
        }
        jSONObject.put("params", this.m);
        jSONObject.put("is_bav", this.n);
        jSONObject.put("ab_version", this.f68981i);
        jSONObject.put("ab_sdk_version", this.j);
    }

    @Override // d.b.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "event", "varchar", "params", "varchar", "is_bav", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f68977e = jSONObject.optLong("local_time_ms", 0L);
        this.f68978f = jSONObject.optLong("tea_event_index", 0L);
        this.f68979g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.f68980h = jSONObject.optString("user_unique_id", null);
        this.o = jSONObject.optString("event", null);
        this.m = jSONObject.optString("params", null);
        this.n = jSONObject.optBoolean("is_bav", false);
        this.f68981i = jSONObject.optString("ab_version", null);
        this.j = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // d.b.b.z
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f68977e);
        jSONObject.put("tea_event_index", this.f68978f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68979g);
        if (!TextUtils.isEmpty(this.f68980h)) {
            jSONObject.put("user_unique_id", this.f68980h);
        }
        jSONObject.put("event", this.o);
        if (this.n) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("params", new JSONObject(this.m));
        }
        jSONObject.put("datetime", this.k);
        if (!TextUtils.isEmpty(this.f68981i)) {
            jSONObject.put("ab_version", this.f68981i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return "eventv3";
    }

    @Override // d.b.b.z
    public String o() {
        return this.o;
    }

    public void p() {
    }

    public String q() {
        return this.o;
    }
}
