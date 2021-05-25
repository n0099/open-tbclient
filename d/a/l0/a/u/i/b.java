package d.a.l0.a.u.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45244a = k.f43199a;

    @NonNull
    public static Pair<d.a.l0.a.u.h.b, JSONObject> a(String str) {
        return b("Api-Utils", str);
    }

    @NonNull
    public static Pair<d.a.l0.a.u.h.b, JSONObject> b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "Api-Utils";
        }
        if (TextUtils.isEmpty(str2)) {
            if (f45244a) {
                Log.e(str, "parseJson: json str is empty");
            }
            return new Pair<>(new d.a.l0.a.u.h.b(202, "parseJson: json str is empty"), new JSONObject());
        }
        try {
            return new Pair<>(new d.a.l0.a.u.h.b(0), new JSONObject(str2));
        } catch (JSONException e2) {
            if (f45244a) {
                e2.printStackTrace();
                Log.e(str, "parseJson: with exception ", e2);
            }
            return new Pair<>(new d.a.l0.a.u.h.b(202, "parseJson: with exception "), new JSONObject());
        }
    }
}
