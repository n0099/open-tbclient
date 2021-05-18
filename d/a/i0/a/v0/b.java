package d.a.i0.a.v0;

import android.text.TextUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k2.g.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f45083a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45084b;

    /* renamed from: c  reason: collision with root package name */
    public String f45085c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f45086d;

    public final boolean a() {
        if (d.a.i0.a.a2.d.g().l() == 0) {
            return c(this.f45086d, "bbasp_guide_");
        }
        if (d.a.i0.a.a2.d.g().l() == 1) {
            return c(this.f45086d, "bbaspg_guide_");
        }
        return false;
    }

    public final boolean b() {
        JSONArray optJSONArray = this.f45086d.optJSONArray("custom_guide_list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("appid", "");
                if (e.V() == null || TextUtils.equals(e.V(), optString)) {
                    return c(optJSONObject, "");
                }
            }
        }
        return false;
    }

    public final boolean c(JSONObject jSONObject, String str) {
        boolean i2;
        boolean z = false;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(str + "count", "3");
        try {
            int intValue = !TextUtils.isEmpty(optString) ? Integer.valueOf(optString).intValue() : 0;
            String optString2 = jSONObject.optString(str + "interval", "72");
            long longValue = !TextUtils.isEmpty(optString2) ? Long.valueOf(optString2).longValue() : 0L;
            long optLong = jSONObject.optLong(str + "last_time", 0L);
            int optInt = jSONObject.optInt(str + "shown_count", 0);
            int optInt2 = jSONObject.optInt(str + "image_index", 0);
            boolean z2 = System.currentTimeMillis() - optLong > longValue * VideoCloudSetting.HOUR_MILLISECOND;
            if (d.a.i0.a.a2.d.g().l() == 1) {
                i2 = j();
            } else {
                i2 = i(jSONObject.optJSONArray("scenes"));
            }
            if (optInt < intValue && z2 && i2) {
                z = true;
            }
            if (z) {
                g(jSONObject, optInt2, str + "images");
            }
        } catch (NumberFormatException unused) {
        }
        return z;
    }

    public final JSONObject d() {
        String string = h.a().getString("swan_guide_toast", "");
        if (d.a.i0.a.a2.d.g() != null && d.a.i0.a.a2.d.g().l() == 1) {
            string = h.a().getString("swan_game_guide_toast", "");
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String e() {
        if (this.f45083a) {
            return "special";
        }
        if (this.f45084b) {
            return "normal";
        }
        return null;
    }

    public String f() {
        return this.f45085c;
    }

    public final int g(JSONObject jSONObject, int i2, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || i2 < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return 0;
        }
        if (i2 >= optJSONArray.length()) {
            i2 = 0;
        }
        this.f45085c = optJSONArray.optString(i2);
        return i2;
    }

    public b h() {
        this.f45083a = false;
        this.f45084b = false;
        this.f45085c = null;
        JSONObject d2 = d();
        this.f45086d = d2;
        if (d2 != null && d2.length() != 0) {
            boolean b2 = b();
            this.f45083a = b2;
            if (b2) {
                return this;
            }
            this.f45084b = a();
        }
        return this;
    }

    public final boolean i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return true;
        }
        String T = d.a.i0.a.a2.d.g().r().L().T();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (TextUtils.equals(T, jSONArray.optString(i2))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
        if (r0.startsWith("120") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j() {
        b.a L = d.a.i0.a.a2.d.g().r().L();
        String T = L.T();
        boolean z = false;
        boolean z2 = TextUtils.isEmpty(T) || T.startsWith("120");
        String string = L.P().getString(UBCCloudControlProcessor.UBC_KEY);
        if (!TextUtils.isEmpty(string)) {
            try {
                String optString = new JSONObject(string).optString("pre_source");
                if (!TextUtils.isEmpty(optString)) {
                }
                z = z2;
                z2 = z;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return !z2;
    }

    public boolean k() {
        return this.f45084b || this.f45083a;
    }
}
