package d.a.j0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49910a;

    /* renamed from: b  reason: collision with root package name */
    public String f49911b;

    /* renamed from: c  reason: collision with root package name */
    public String f49912c;

    /* renamed from: d  reason: collision with root package name */
    public float f49913d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f49914e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f49915f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f49916g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f49917a;

        /* renamed from: b  reason: collision with root package name */
        public String f49918b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f49917a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
            aVar.f49918b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f49919a;

        /* renamed from: b  reason: collision with root package name */
        public String f49920b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f49919a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
            bVar.f49920b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f49914e) && TextUtils.isEmpty(cVar.f49912c) && ((bVar = cVar.f49915f) == null || TextUtils.isEmpty(bVar.f49919a)) && ((aVar = cVar.f49916g) == null || TextUtils.isEmpty(aVar.f49917a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f49910a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f49911b = jSONObject.optString("app_name");
        cVar.f49912c = jSONObject.optString("developer_name");
        cVar.f49914e = jSONObject.optString("version");
        cVar.f49915f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f49916g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f49913d = parseFloat;
            } else {
                cVar.f49913d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f49913d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f49910a) {
            return (TextUtils.isEmpty(cVar.f49914e) || TextUtils.isEmpty(cVar.f49912c) || (bVar = cVar.f49915f) == null || TextUtils.isEmpty(bVar.f49920b) || (aVar = cVar.f49916g) == null || TextUtils.isEmpty(aVar.f49918b)) ? false : true;
        }
        return true;
    }
}
