package d.c.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h0 extends z {
    public long m;
    public String n;
    public String o;
    public int p;

    @Override // d.c.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f65112e = cursor.getLong(0);
        this.f65113f = cursor.getLong(1);
        this.f65114g = cursor.getString(2);
        this.f65115h = cursor.getString(3);
        this.o = cursor.getString(4);
        this.n = cursor.getString(5);
        this.m = cursor.getLong(6);
        this.p = cursor.getInt(7);
        return this;
    }

    @Override // d.c.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f65112e));
        contentValues.put("tea_event_index", Long.valueOf(this.f65113f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        contentValues.put("user_unique_id", this.f65115h);
        contentValues.put("page_key", this.o);
        contentValues.put("refer_page_key", this.n);
        contentValues.put("duration", Long.valueOf(this.m));
        contentValues.put("is_back", Integer.valueOf(this.p));
    }

    @Override // d.c.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("page_key", this.o);
        jSONObject.put("refer_page_key", this.n);
        jSONObject.put("duration", this.m);
        jSONObject.put("local_time_ms", this.f65112e);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f65114g);
        jSONObject.put("tea_event_index", this.f65113f);
        jSONObject.put("is_back", this.p);
    }

    @Override // d.c.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer"};
    }

    @Override // d.c.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f65112e = jSONObject.optLong("local_time_ms", 0L);
        this.f65113f = jSONObject.optLong("tea_event_index", 0L);
        this.f65114g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.o = jSONObject.optString("page_key", null);
        this.n = jSONObject.optString("refer_page_key", null);
        this.m = jSONObject.optLong("duration", 0L);
        this.p = jSONObject.optInt("is_back", 0);
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", r());
        jSONObject.put("datetime", this.k);
        return jSONObject;
    }

    @Override // d.c.b.z
    @NonNull
    public String k() {
        return "page";
    }

    @Override // d.c.b.z
    public String o() {
        return super.o() + " name:" + this.o + " duration:" + this.m;
    }

    public boolean p() {
        return this.m == -1;
    }

    public boolean q() {
        return this.o.contains(":");
    }

    public final JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.o);
        jSONObject.put("refer_page_key", this.n);
        jSONObject.put("is_back", this.p);
        return jSONObject;
    }
}
