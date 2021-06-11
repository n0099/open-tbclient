package d.a.n0.b0;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Uri f54932a;

    /* renamed from: b  reason: collision with root package name */
    public String f54933b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f54934c;

    public e(String str) {
        g(str);
    }

    public Bundle a() {
        if (this.f54934c == null) {
            this.f54934c = new Bundle();
        }
        return this.f54934c;
    }

    public String b(String str) {
        return c(str, null);
    }

    public String c(String str, String str2) {
        Bundle bundle = this.f54934c;
        return bundle == null ? str2 : bundle.getString(str, str2);
    }

    public Uri d() {
        return this.f54932a;
    }

    public final boolean e() {
        try {
            this.f54932a.getScheme();
            this.f54932a.getHost();
            String path = this.f54932a.getPath();
            this.f54933b = path;
            if (!TextUtils.isEmpty(path) && this.f54933b.endsWith("/")) {
                this.f54933b = this.f54933b.substring(0, this.f54933b.length() - 1);
            }
            Set<String> queryParameterNames = this.f54932a.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.isEmpty()) {
                return true;
            }
            if (this.f54934c == null) {
                this.f54934c = new Bundle();
            }
            for (String str : queryParameterNames) {
                String queryParameter = this.f54932a.getQueryParameter(str);
                this.f54934c.putString(str, queryParameter);
                if (TextUtils.equals(str, "params") && !TextUtils.isEmpty(queryParameter)) {
                    try {
                        JSONObject jSONObject = new JSONObject(queryParameter);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f54934c.putString(next, jSONObject.optString(next, ""));
                        }
                    } catch (Exception e2) {
                        if (BdLog.isDebugMode()) {
                            BdLog.e("builder parseUri e = " + e2.toString());
                        }
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e("builder parseUri te = " + th.toString());
            }
            return false;
        }
    }

    public e f(Uri uri) {
        this.f54932a = uri;
        if (uri != null) {
            if (BdLog.isDebugMode()) {
                BdLog.i("builder uri = " + uri);
            }
            e();
        } else if (BdLog.isDebugMode()) {
            BdLog.i("builder uri = null");
        }
        return this;
    }

    public e g(String str) {
        Uri uri = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                uri = Uri.parse(str);
            }
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e("builder uri e = " + th.toString());
            }
        }
        f(uri);
        return this;
    }
}
