package d.b.h0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50723a;

    /* renamed from: b  reason: collision with root package name */
    public String f50724b;

    /* renamed from: c  reason: collision with root package name */
    public String f50725c;

    /* renamed from: d  reason: collision with root package name */
    public float f50726d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f50727e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f50728f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f50729g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f50730a;

        /* renamed from: b  reason: collision with root package name */
        public String f50731b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f50730a = jSONObject.optString("desc", "权限");
            aVar.f50731b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f50732a;

        /* renamed from: b  reason: collision with root package name */
        public String f50733b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f50732a = jSONObject.optString("desc", "隐私");
            bVar.f50733b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f50727e) && TextUtils.isEmpty(cVar.f50725c) && ((bVar = cVar.f50728f) == null || TextUtils.isEmpty(bVar.f50732a)) && ((aVar = cVar.f50729g) == null || TextUtils.isEmpty(aVar.f50730a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f50723a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f50724b = jSONObject.optString(DpStatConstants.KEY_APP_NAME);
        cVar.f50725c = jSONObject.optString("developer_name");
        cVar.f50727e = jSONObject.optString("version");
        cVar.f50728f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f50729g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f50726d = parseFloat;
            } else {
                cVar.f50726d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f50726d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f50723a) {
            return (TextUtils.isEmpty(cVar.f50727e) || TextUtils.isEmpty(cVar.f50725c) || (bVar = cVar.f50728f) == null || TextUtils.isEmpty(bVar.f50733b) || (aVar = cVar.f50729g) == null || TextUtils.isEmpty(aVar.f50731b)) ? false : true;
        }
        return true;
    }
}
