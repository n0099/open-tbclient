package d.b.h0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.widget.DisplayInfoView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51131a;

    /* renamed from: b  reason: collision with root package name */
    public String f51132b;

    /* renamed from: c  reason: collision with root package name */
    public String f51133c;

    /* renamed from: d  reason: collision with root package name */
    public float f51134d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public String f51135e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f51136f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f51137g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f51138a;

        /* renamed from: b  reason: collision with root package name */
        public String f51139b;

        @Nullable
        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f51138a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
            aVar.f51139b = jSONObject.optString("url");
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f51140a;

        /* renamed from: b  reason: collision with root package name */
        public String f51141b;

        @Nullable
        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f51140a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
            bVar.f51141b = jSONObject.optString("url");
            return bVar;
        }
    }

    public static boolean a(c cVar) {
        b bVar;
        a aVar;
        if (cVar == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar.f51135e) && TextUtils.isEmpty(cVar.f51133c) && ((bVar = cVar.f51136f) == null || TextUtils.isEmpty(bVar.f51140a)) && ((aVar = cVar.f51137g) == null || TextUtils.isEmpty(aVar.f51138a))) ? false : true;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f51131a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
        jSONObject.optString("app_icon");
        cVar.f51132b = jSONObject.optString(DpStatConstants.KEY_APP_NAME);
        cVar.f51133c = jSONObject.optString("developer_name");
        cVar.f51135e = jSONObject.optString("version");
        cVar.f51136f = b.a(jSONObject.optJSONObject("privacy"));
        cVar.f51137g = a.a(jSONObject.optJSONObject("permission"));
        try {
            float parseFloat = Float.parseFloat(jSONObject.optString("score"));
            if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                cVar.f51134d = parseFloat;
            } else {
                cVar.f51134d = -1.0f;
            }
        } catch (NumberFormatException unused) {
            cVar.f51134d = -1.0f;
        }
        return cVar;
    }

    public static boolean c(c cVar) {
        b bVar;
        a aVar;
        if (cVar != null && cVar.f51131a) {
            return (TextUtils.isEmpty(cVar.f51135e) || TextUtils.isEmpty(cVar.f51133c) || (bVar = cVar.f51136f) == null || TextUtils.isEmpty(bVar.f51141b) || (aVar = cVar.f51137g) == null || TextUtils.isEmpty(aVar.f51139b)) ? false : true;
        }
        return true;
    }
}
