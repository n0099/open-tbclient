package d.a.m0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49954a;

    /* renamed from: b  reason: collision with root package name */
    public String f49955b;

    /* renamed from: c  reason: collision with root package name */
    public String f49956c;

    /* renamed from: d  reason: collision with root package name */
    public float f49957d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f49958e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f49959f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f49960g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49961a;

        /* renamed from: b  reason: collision with root package name */
        public String f49962b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f49961a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
            aVar.f49962b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f49963a;

        /* renamed from: b  reason: collision with root package name */
        public String f49964b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f49963a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
            bVar.f49964b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f49958e) && TextUtils.isEmpty(cVar.f49956c) && ((bVar = cVar.f49959f) == null || TextUtils.isEmpty(bVar.f49963a)) && ((aVar = cVar.f49960g) == null || TextUtils.isEmpty(aVar.f49961a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f49954a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f49955b = jSONObject.optString("app_name");
        cVar.f49956c = jSONObject.optString("developer_name");
        cVar.f49958e = jSONObject.optString("version");
        cVar.f49959f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f49960g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f49957d = parseFloat;
            } else {
                cVar.f49957d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f49957d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f49954a) {
            return (TextUtils.isEmpty(cVar.f49958e) || TextUtils.isEmpty(cVar.f49956c) || (bVar = cVar.f49959f) == null || TextUtils.isEmpty(bVar.f49964b) || (aVar = cVar.f49960g) == null || TextUtils.isEmpty(aVar.f49962b)) ? false : true;
        }
        return true;
    }
}
