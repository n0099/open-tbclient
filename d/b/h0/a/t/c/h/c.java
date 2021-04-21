package d.b.h0.a.t.c.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.common.internal.Sets;
import d.b.h0.a.i2.b0;
import d.b.h0.a.k;
import d.b.h0.a.r1.d;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46827a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f46828b = Sets.newHashSet("localhost", "127.0.0.1");

    public static String a(String str) {
        return str + "_" + System.currentTimeMillis();
    }

    public static boolean b(@Nullable HttpUrl httpUrl) {
        boolean i = d.b.h0.a.s1.a.b.i();
        if (!d.b.h0.a.w0.a.N().z()) {
            i = false;
        }
        if (httpUrl != null) {
            return (!i || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !f46828b.contains(httpUrl.host().toLowerCase());
        }
        return false;
    }

    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("cancelTag", str);
            }
        } catch (JSONException e2) {
            if (f46827a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static String d() {
        return b0.b();
    }

    public static HttpUrl e(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.e().n() == null) {
            if (b(parse)) {
                return parse;
            }
            return null;
        } else if (d.b.h0.a.m1.a.a.m() || b(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public static JSONObject f(Headers headers) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str)) {
                List<String> values = headers.values(str);
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i = 0; i < size; i++) {
                    sb.append(values.get(i));
                    if (i == size - 1) {
                        break;
                    }
                    sb.append(",");
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }
}
