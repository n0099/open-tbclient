package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i0 extends z {
    public static String s = "succEvent";
    public String m;
    public int n;
    public int o;
    public String p;
    public int q;
    public long r;

    public i0() {
    }

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f65142e = cursor.getLong(0);
        this.f65143f = cursor.getLong(1);
        this.f65144g = cursor.getString(2);
        this.f65145h = cursor.getString(3);
        this.m = cursor.getString(4);
        this.n = cursor.getInt(5);
        this.o = cursor.getInt(6);
        this.p = cursor.getString(7);
        this.q = cursor.getInt(8);
        this.r = cursor.getLong(9);
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f65142e));
        contentValues.put("tea_event_index", Long.valueOf(this.f65143f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65144g);
        contentValues.put("user_unique_id", this.f65145h);
        contentValues.put("event_name", this.m);
        contentValues.put("is_monitor", Integer.valueOf(this.n));
        contentValues.put("bav_monitor_rate", Integer.valueOf(this.o));
        contentValues.put("monitor_status", this.p);
        contentValues.put("monitor_num", Integer.valueOf(this.q));
        contentValues.put("date", Long.valueOf(this.r));
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f65142e);
        jSONObject.put("tea_event_index", this.f65143f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65144g);
        jSONObject.put("user_unique_id", this.f65145h);
        jSONObject.put("event_name", this.m);
        jSONObject.put("is_monitor", this.n);
        jSONObject.put("bav_monitor_rate", this.o);
        jSONObject.put("monitor_status", this.p);
        jSONObject.put("monitor_num", this.q);
        jSONObject.put("date", this.r);
    }

    @Override // d.b.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "event_name", "varchar", "is_monitor", "integer", "bav_monitor_rate", "integer", "monitor_status", "varchar", "monitor_num", "integer", "date", "integer"};
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f65142e = jSONObject.optLong("local_time_ms", 0L);
        this.f65143f = jSONObject.optLong("tea_event_index", 0L);
        this.f65144g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.f65145h = jSONObject.optString("user_unique_id", null);
        this.m = jSONObject.optString("event_name", null);
        this.n = jSONObject.optInt("is_monitor", 0);
        this.o = jSONObject.optInt("bav_monitor_rate", 0);
        this.p = jSONObject.optString("monitor_status", null);
        this.q = jSONObject.optInt("monitor_num", 0);
        this.r = jSONObject.optLong("date", 0L);
        return this;
    }

    @Override // d.b.b.z
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_name", this.m);
        jSONObject.put("is_monitor", this.n);
        jSONObject.put("bav_monitor_rate", this.o);
        jSONObject.put("monitor_status", this.p);
        jSONObject.put("monitor_num", this.q);
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return s;
    }

    public i0(String str, String str2, int i2) {
        this.n = 1;
        this.o = a.m();
        this.m = str;
        this.p = str2;
        this.q = i2;
        this.r = q0.a();
    }
}
