package d.b.g0.a.a2;

import android.net.Uri;
import android.text.TextUtils;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43229a = k.f45050a;

    public static boolean a() {
        String V;
        String queryParameter;
        e O = e.O();
        if (O == null || (V = O.J().V()) == null || (queryParameter = Uri.parse(V).getQueryParameter("params")) == null) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            if (f43229a) {
                e2.printStackTrace();
            }
        }
        return TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), "homepage");
    }
}
