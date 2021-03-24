package d.b.g0.a.t1.k.r0;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d extends d.b.g0.a.a0.b.b {
    public String n;
    public String o;
    public String p;
    public boolean q;
    public List<String> r;

    static {
        boolean z = k.f45050a;
    }

    public d() {
        super("webView", "viewId");
        this.q = true;
    }

    public static d h(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String str = unitedSchemeEntity.getParams().get("params");
        d dVar = new d();
        try {
            dVar.a(new JSONObject(str));
            return dVar;
        } catch (JSONException e2) {
            d.b.g0.a.c0.c.c(WebView.LOGTAG, "parsing params occurs exception", e2);
            return null;
        }
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.n = jSONObject.optString(UserAccountActionItem.KEY_SRC);
        this.o = jSONObject.optString("userAgent");
        this.p = jSONObject.optString("type");
        JSONArray optJSONArray = jSONObject.optJSONArray("targetUrls");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.r = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            this.r.add(optJSONArray.optString(i));
        }
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f43113g);
    }
}
