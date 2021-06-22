package d.a.n0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53737a;

    /* renamed from: b  reason: collision with root package name */
    public String f53738b;

    /* renamed from: c  reason: collision with root package name */
    public String f53739c;

    /* renamed from: d  reason: collision with root package name */
    public float f53740d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f53741e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f53742f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f53743g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f53744a;

        /* renamed from: b  reason: collision with root package name */
        public String f53745b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f53744a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
            aVar.f53745b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f53746a;

        /* renamed from: b  reason: collision with root package name */
        public String f53747b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f53746a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
            bVar.f53747b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f53741e) && TextUtils.isEmpty(cVar.f53739c) && ((bVar = cVar.f53742f) == null || TextUtils.isEmpty(bVar.f53746a)) && ((aVar = cVar.f53743g) == null || TextUtils.isEmpty(aVar.f53744a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f53737a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f53738b = jSONObject.optString("app_name");
        cVar.f53739c = jSONObject.optString("developer_name");
        cVar.f53741e = jSONObject.optString("version");
        cVar.f53742f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f53743g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f53740d = parseFloat;
            } else {
                cVar.f53740d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f53740d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f53737a) {
            return (TextUtils.isEmpty(cVar.f53741e) || TextUtils.isEmpty(cVar.f53739c) || (bVar = cVar.f53742f) == null || TextUtils.isEmpty(bVar.f53747b) || (aVar = cVar.f53743g) == null || TextUtils.isEmpty(aVar.f53745b)) ? false : true;
        }
        return true;
    }
}
