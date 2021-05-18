package d.a.k0.i0.e.a;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f55672a = new ArrayList<>();

    public void a(b bVar) {
        if (bVar != null) {
            this.f55672a.add(bVar);
        }
    }

    public boolean b(String str, JsPromptResult jsPromptResult) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("interfaceName");
            String optString2 = jSONObject.optString("methodName");
            String optString3 = jSONObject.optString("param");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                return c(optString, optString2, optString3, jsPromptResult);
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public final boolean c(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.f55672a.size() > 0) {
            Iterator<b> it = this.f55672a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
