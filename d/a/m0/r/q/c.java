package d.a.m0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53630a;

    /* renamed from: b  reason: collision with root package name */
    public String f53631b;

    /* renamed from: c  reason: collision with root package name */
    public String f53632c;

    /* renamed from: d  reason: collision with root package name */
    public float f53633d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f53634e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f53635f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f53636g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f53637a;

        /* renamed from: b  reason: collision with root package name */
        public String f53638b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f53637a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
            aVar.f53638b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f53639a;

        /* renamed from: b  reason: collision with root package name */
        public String f53640b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f53639a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
            bVar.f53640b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f53634e) && TextUtils.isEmpty(cVar.f53632c) && ((bVar = cVar.f53635f) == null || TextUtils.isEmpty(bVar.f53639a)) && ((aVar = cVar.f53636g) == null || TextUtils.isEmpty(aVar.f53637a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f53630a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f53631b = jSONObject.optString("app_name");
        cVar.f53632c = jSONObject.optString("developer_name");
        cVar.f53634e = jSONObject.optString("version");
        cVar.f53635f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f53636g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f53633d = parseFloat;
            } else {
                cVar.f53633d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f53633d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f53630a) {
            return (TextUtils.isEmpty(cVar.f53634e) || TextUtils.isEmpty(cVar.f53632c) || (bVar = cVar.f53635f) == null || TextUtils.isEmpty(bVar.f53640b) || (aVar = cVar.f53636g) == null || TextUtils.isEmpty(aVar.f53638b)) ? false : true;
        }
        return true;
    }
}
