package d.c.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f0 extends z {
    public int m;
    public String n;
    public boolean o;
    public volatile boolean p;

    @Override // d.c.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f65112e = cursor.getLong(0);
        this.f65113f = cursor.getLong(1);
        this.f65114g = cursor.getString(2);
        this.n = cursor.getString(3);
        this.m = cursor.getInt(4);
        this.i = cursor.getString(5);
        this.j = cursor.getString(6);
        return this;
    }

    @Override // d.c.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f65112e));
        contentValues.put("tea_event_index", Long.valueOf(this.f65113f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        contentValues.put("ver_name", this.n);
        contentValues.put("ver_code", Integer.valueOf(this.m));
        contentValues.put("ab_version", this.i);
        contentValues.put("ab_sdk_version", this.j);
    }

    @Override // d.c.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f65112e);
        jSONObject.put("tea_event_index", this.f65113f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        jSONObject.put("ab_version", this.i);
        jSONObject.put("ab_sdk_version", this.j);
    }

    @Override // d.c.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "ver_name", "varchar", "ver_code", "integer", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    @Override // d.c.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f65112e = jSONObject.optLong("local_time_ms", 0L);
        this.f65113f = jSONObject.optLong("tea_event_index", 0L);
        this.f65114g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
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
        boolean z = this.o;
        if (z) {
            jSONObject.put("is_background", z);
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
        return Config.LAUNCH;
    }
}
