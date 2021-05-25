package d.a.l0.a.u.e.j;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.common.internal.Sets;
import d.a.l0.a.k;
import d.a.l0.a.v2.d0;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45073a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f45074b = Sets.newHashSet("localhost", "127.0.0.1");

    public static String a(String str) {
        return str + "_" + System.currentTimeMillis();
    }

    public static boolean b(@Nullable HttpUrl httpUrl) {
        boolean i2 = d.a.l0.a.b2.a.b.i();
        if (!d.a.l0.a.c1.a.Z().F()) {
            i2 = false;
        }
        if (httpUrl != null) {
            return (!i2 || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !f45074b.contains(httpUrl.host().toLowerCase());
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
            if (f45073a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static String d() {
        return d0.b();
    }

    @Nullable
    public static String e(@Nullable String str) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.host();
    }

    public static HttpUrl f(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.a.l0.a.a2.d.g().x() == null) {
            if (b(parse)) {
                return parse;
            }
            return null;
        } else if (d.a.l0.a.u1.a.a.o() || b(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public static JSONObject g(Headers headers) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str)) {
                List<String> values = headers.values(str);
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(values.get(i2));
                    if (i2 == size - 1) {
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
