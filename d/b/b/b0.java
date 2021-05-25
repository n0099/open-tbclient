package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b0 extends z {
    public String m;
    public String n;
    public String o;
    public String p;
    public long q;
    public long r;

    public b0(String str, String str2, String str3, long j, long j2, String str4) {
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.q = j;
        this.r = j2;
        this.p = str4;
    }

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f65142e = cursor.getLong(0);
        this.f65143f = cursor.getLong(1);
        this.f65144g = cursor.getString(2);
        this.f65145h = cursor.getString(3);
        this.m = cursor.getString(4);
        this.n = cursor.getString(5);
        this.q = cursor.getInt(6);
        this.r = cursor.getInt(7);
        this.p = cursor.getString(8);
        this.o = cursor.getString(9);
        this.f65146i = cursor.getString(10);
        this.j = cursor.getString(11);
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f65142e));
        contentValues.put("tea_event_index", Long.valueOf(this.f65143f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65144g);
        contentValues.put("user_unique_id", this.f65145h);
        contentValues.put("category", this.m);
        contentValues.put("tag", this.n);
        contentValues.put("value", Long.valueOf(this.q));
        contentValues.put("ext_value", Long.valueOf(this.r));
        contentValues.put("params", this.p);
        contentValues.put(NotificationCompatJellybean.KEY_LABEL, this.o);
        contentValues.put("ab_version", this.f65146i);
        contentValues.put("ab_sdk_version", this.j);
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f65142e);
        jSONObject.put("tea_event_index", this.f65143f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65144g);
        jSONObject.put("user_unique_id", this.f65145h);
        jSONObject.put("category", this.m);
        jSONObject.put("tag", this.n);
        jSONObject.put("value", this.q);
        jSONObject.put("ext_value", this.r);
        jSONObject.put("params", this.p);
        jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.o);
        jSONObject.put("ab_version", this.f65146i);
        jSONObject.put("ab_sdk_version", this.j);
    }

    @Override // d.b.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "category", "varchar", "tag", "varchar", "value", "integer", "ext_value", "integer", "params", "varchar", NotificationCompatJellybean.KEY_LABEL, "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f65142e = jSONObject.optLong("local_time_ms", 0L);
        this.f65143f = jSONObject.optLong("tea_event_index", 0L);
        this.f65144g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.f65145h = jSONObject.optString("user_unique_id", null);
        this.m = jSONObject.optString("category", null);
        this.n = jSONObject.optString("tag", null);
        this.q = jSONObject.optLong("value", 0L);
        this.r = jSONObject.optLong("ext_value", 0L);
        this.p = jSONObject.optString("params", null);
        this.o = jSONObject.optString(NotificationCompatJellybean.KEY_LABEL, null);
        this.f65146i = jSONObject.optString("ab_version", null);
        this.j = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    @Override // d.b.b.z
    public JSONObject i() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.p) ? new JSONObject(this.p) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.f65142e);
        jSONObject.put("tea_event_index", this.f65143f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65144g);
        if (!TextUtils.isEmpty(this.f65145h)) {
            jSONObject.put("user_unique_id", this.f65145h);
        }
        jSONObject.put("category", this.m);
        jSONObject.put("tag", this.n);
        jSONObject.put("value", this.q);
        jSONObject.put("ext_value", this.r);
        jSONObject.put(NotificationCompatJellybean.KEY_LABEL, this.o);
        jSONObject.put("datetime", this.k);
        if (!TextUtils.isEmpty(this.f65146i)) {
            jSONObject.put("ab_version", this.f65146i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return "event";
    }

    @Override // d.b.b.z
    public String o() {
        return "" + this.n + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.o;
    }

    public String p() {
        return this.n;
    }

    public String q() {
        return this.o;
    }

    public b0() {
    }
}
