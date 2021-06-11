package d.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j0 extends z {
    public long m;
    public long n;

    @Override // d.b.b.z
    @NonNull
    public z a(@NonNull Cursor cursor) {
        r0.b(null);
        return this;
    }

    @Override // d.b.b.z
    public void d(@NonNull ContentValues contentValues) {
        r0.b(null);
    }

    @Override // d.b.b.z
    public void e(@NonNull JSONObject jSONObject) {
        r0.b(null);
    }

    @Override // d.b.b.z
    public String[] f() {
        return null;
    }

    @Override // d.b.b.z
    public z h(@NonNull JSONObject jSONObject) {
        r0.b(null);
        return this;
    }

    @Override // d.b.b.z
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f68873e);
        jSONObject.put("tea_event_index", this.f68874f);
        jSONObject.put(ETAG.KEY_STATISTICS_SEESIONID, this.f68875g);
        jSONObject.put("stop_timestamp", this.n);
        jSONObject.put("duration", this.m / 1000);
        jSONObject.put("datetime", this.k);
        if (!TextUtils.isEmpty(this.f68877i)) {
            jSONObject.put("ab_version", this.f68877i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("ab_sdk_version", this.j);
        }
        return jSONObject;
    }

    @Override // d.b.b.z
    @NonNull
    public String k() {
        return "terminate";
    }

    @Override // d.b.b.z
    public String o() {
        return super.o() + " duration:" + this.m;
    }
}
