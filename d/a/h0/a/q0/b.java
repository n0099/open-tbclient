package d.a.h0.a.q0;

import android.text.TextUtils;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.p;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f43566a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43567b;

    /* renamed from: c  reason: collision with root package name */
    public String f43568c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f43569d;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a().putString("swan_guide_toast", b.this.f43569d.toString());
        }
    }

    public final boolean b() {
        if (d.e().j() == 0) {
            return d(this.f43569d, "bbasp_guide_");
        }
        if (d.e().j() == 1) {
            return d(this.f43569d, "bbaspg_guide_");
        }
        return false;
    }

    public final boolean c() {
        JSONArray optJSONArray = this.f43569d.optJSONArray("custom_guide_list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("appid", "");
                if (e.T() == null || TextUtils.equals(e.T(), optString)) {
                    return d(optJSONObject, "");
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(JSONObject jSONObject, String str) {
        boolean z;
        b.a L;
        boolean z2 = false;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(str + "count", "3");
        int intValue = !TextUtils.isEmpty(optString) ? Integer.valueOf(optString).intValue() : 0;
        String optString2 = jSONObject.optString(str + "interval", "72");
        long longValue = !TextUtils.isEmpty(optString2) ? Long.valueOf(optString2).longValue() : 0L;
        long optLong = jSONObject.optLong(str + "last_time", 0L);
        int optInt = jSONObject.optInt(str + "shown_count", 0);
        int optInt2 = jSONObject.optInt(str + "image_index", 0);
        boolean z3 = System.currentTimeMillis() - optLong > longValue * VideoCloudSetting.HOUR_MILLISECOND;
        if (e.h() != null && (L = e.h().L()) != null) {
            String S = L.S();
            if (!TextUtils.isEmpty(S) && !S.startsWith("120")) {
                z = false;
                if (optInt < intValue && z3 && !z) {
                    z2 = true;
                }
                if (z2) {
                    int h2 = h(jSONObject, optInt2, str + "images");
                    try {
                        jSONObject.put(str + "shown_count", optInt + 1);
                        jSONObject.put(str + "image_index", h2 + 1);
                        jSONObject.put(str + "last_time", System.currentTimeMillis());
                        p.k(new a(), "swanCloseGuideRunnable");
                    } catch (JSONException unused) {
                    }
                }
                return z2;
            }
        }
        z = true;
        if (optInt < intValue) {
            z2 = true;
        }
        if (z2) {
        }
        return z2;
    }

    public final JSONObject e() {
        String string = h.a().getString("swan_guide_toast", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String f() {
        if (this.f43566a) {
            return "special";
        }
        if (this.f43567b) {
            return "normal";
        }
        return null;
    }

    public String g() {
        return this.f43568c;
    }

    public final int h(JSONObject jSONObject, int i2, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || i2 < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return 0;
        }
        if (i2 >= optJSONArray.length()) {
            i2 = 0;
        }
        this.f43568c = optJSONArray.optString(i2);
        return i2;
    }

    public b i() {
        this.f43566a = false;
        this.f43567b = false;
        this.f43568c = null;
        JSONObject e2 = e();
        this.f43569d = e2;
        if (e2 == null) {
            return this;
        }
        boolean c2 = c();
        this.f43566a = c2;
        if (c2) {
            return this;
        }
        this.f43567b = b();
        return this;
    }

    public boolean j() {
        return this.f43567b || this.f43566a;
    }
}
