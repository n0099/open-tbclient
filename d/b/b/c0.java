package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c0 extends z {
    @NonNull
    public String m;
    @NonNull
    public String n;

    public c0(@NonNull String str, @NonNull JSONObject jSONObject) {
        this.n = str;
        this.m = jSONObject.toString();
    }

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        this.f68873e = cursor.getLong(0);
        this.f68874f = cursor.getLong(1);
        this.f68875g = cursor.getString(2);
        this.f68876h = cursor.getString(3);
        this.m = cursor.getString(4);
        this.n = cursor.getString(5);
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f68873e));
        contentValues.put("tea_event_index", Long.valueOf(this.f68874f));
        contentValues.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68875g);
        contentValues.put("user_unique_id", this.f68876h);
        contentValues.put("params", this.m);
        contentValues.put("log_type", this.n);
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f68873e);
        jSONObject.put("tea_event_index", this.f68874f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68875g);
        jSONObject.put("user_unique_id", this.f68876h);
        jSONObject.put("params", this.m);
        jSONObject.put("log_type", this.n);
    }

    @Override // d.b.b.z
    public String[] f() {
        return new String[]{"local_time_ms", "integer", "tea_event_index", "integer", ETAG.KEY_STATISTICS_SEESIONID, "varchar", "user_unique_id", "varchar", "params", "varchar", "log_type", "varchar"};
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        this.f68873e = jSONObject.optLong("local_time_ms", 0L);
        this.f68874f = jSONObject.optLong("tea_event_index", 0L);
        this.f68875g = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID, null);
        this.f68876h = jSONObject.optString("user_unique_id", null);
        this.m = jSONObject.optString("params", null);
        this.n = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // d.b.b.z
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f68873e);
        jSONObject.put("tea_event_index", this.f68874f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68875g);
        if (!TextUtils.isEmpty(this.f68876h)) {
            jSONObject.put("user_unique_id", this.f68876h);
        }
        jSONObject.put("log_type", this.n);
        try {
            JSONObject jSONObject2 = new JSONObject(this.m);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    r0.c("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e2) {
            r0.d("解析 event misc 失败", e2);
        }
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return "event_misc";
    }

    @Override // d.b.b.z
    public String o() {
        return "param:" + this.m + " logType:" + this.n;
    }
}
