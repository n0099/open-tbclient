package d.c.b;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f65858a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65859b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f65860c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f65861d;

    /* renamed from: e  reason: collision with root package name */
    public final Long f65862e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f65863f;

    /* renamed from: g  reason: collision with root package name */
    public final Long f65864g;

    public i1(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.f65858a = str;
        this.f65859b = str2;
        this.f65860c = bool;
        this.f65861d = l;
        this.f65862e = l2;
        this.f65863f = num;
        this.f65864g = l3;
    }

    @Nullable
    @AnyThread
    public static i1 a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new i1(jSONObject.optString("id", null), jSONObject.optString(IAdRequestParam.REQ_ID, null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @NonNull
    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        f1.h(hashMap, "id", this.f65858a);
        f1.h(hashMap, IAdRequestParam.REQ_ID, this.f65859b);
        f1.h(hashMap, "is_track_limited", String.valueOf(this.f65860c));
        f1.h(hashMap, "take_ms", String.valueOf(this.f65861d));
        f1.h(hashMap, "time", String.valueOf(this.f65862e));
        f1.h(hashMap, "query_times", String.valueOf(this.f65863f));
        f1.h(hashMap, "hw_id_version_code", String.valueOf(this.f65864g));
        return hashMap;
    }

    @NonNull
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        f1.i(jSONObject, "id", this.f65858a);
        f1.i(jSONObject, IAdRequestParam.REQ_ID, this.f65859b);
        f1.i(jSONObject, "is_track_limited", this.f65860c);
        f1.i(jSONObject, "take_ms", this.f65861d);
        f1.i(jSONObject, "time", this.f65862e);
        f1.i(jSONObject, "query_times", this.f65863f);
        f1.i(jSONObject, "hw_id_version_code", this.f65864g);
        return jSONObject;
    }

    public String toString() {
        return c().toString();
    }
}
