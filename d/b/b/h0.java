package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h0 extends z {
    public long m;
    public String n;
    public String o;
    public int p;

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f68977e = cursor.getLong(0);
        this.f68978f = cursor.getLong(1);
        this.f68979g = cursor.getString(2);
        this.f68980h = cursor.getString(3);
        this.o = cursor.getString(4);
        this.n = cursor.getString(5);
        this.m = cursor.getLong(6);
        this.p = cursor.getInt(7);
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f68977e));
        contentValues.put("tea_event_index", Long.valueOf(this.f68978f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68979g);
        contentValues.put("user_unique_id", this.f68980h);
        contentValues.put("page_key", this.o);
        contentValues.put("refer_page_key", this.n);
        contentValues.put("duration", Long.valueOf(this.m));
        contentValues.put("is_back", Integer.valueOf(this.p));
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("page_key", this.o);
        jSONObject.put("refer_page_key", this.n);
        jSONObject.put("duration", this.m);
        jSONObject.put("local_time_ms", this.f68977e);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68979g);
        jSONObject.put("tea_event_index", this.f68978f);
        jSONObject.put("is_back", this.p);
    }

    @Override // d.b.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer"};
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f68977e = jSONObject.optLong("local_time_ms", 0L);
        this.f68978f = jSONObject.optLong("tea_event_index", 0L);
        this.f68979g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.o = jSONObject.optString("page_key", null);
        this.n = jSONObject.optString("refer_page_key", null);
        this.m = jSONObject.optLong("duration", 0L);
        this.p = jSONObject.optInt("is_back", 0);
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", r());
        jSONObject.put("datetime", this.k);
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return "page";
    }

    @Override // d.b.b.z
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
