package d.a.i0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49091a;

    /* renamed from: b  reason: collision with root package name */
    public String f49092b;

    /* renamed from: c  reason: collision with root package name */
    public String f49093c;

    /* renamed from: d  reason: collision with root package name */
    public float f49094d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f49095e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f49096f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f49097g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49098a;

        /* renamed from: b  reason: collision with root package name */
        public String f49099b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f49098a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
            aVar.f49099b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f49100a;

        /* renamed from: b  reason: collision with root package name */
        public String f49101b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f49100a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
            bVar.f49101b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f49095e) && TextUtils.isEmpty(cVar.f49093c) && ((bVar = cVar.f49096f) == null || TextUtils.isEmpty(bVar.f49100a)) && ((aVar = cVar.f49097g) == null || TextUtils.isEmpty(aVar.f49098a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f49091a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f49092b = jSONObject.optString(DpStatConstants.KEY_APP_NAME);
        cVar.f49093c = jSONObject.optString("developer_name");
        cVar.f49095e = jSONObject.optString("version");
        cVar.f49096f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f49097g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f49094d = parseFloat;
            } else {
                cVar.f49094d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f49094d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f49091a) {
            return (TextUtils.isEmpty(cVar.f49095e) || TextUtils.isEmpty(cVar.f49093c) || (bVar = cVar.f49096f) == null || TextUtils.isEmpty(bVar.f49101b) || (aVar = cVar.f49097g) == null || TextUtils.isEmpty(aVar.f49099b)) ? false : true;
        }
        return true;
    }
}
