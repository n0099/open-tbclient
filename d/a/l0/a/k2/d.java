package d.a.l0.a.k2;

import android.net.Uri;
import android.text.TextUtils;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46911a = k.f46875a;

    public static boolean a() {
        String W;
        String queryParameter;
        e Q = e.Q();
        if (Q == null || (W = Q.L().W()) == null || (queryParameter = Uri.parse(W).getQueryParameter("params")) == null) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            if (f46911a) {
                e2.printStackTrace();
            }
        }
        return TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), "homepage");
    }
}
