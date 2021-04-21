package d.b.j0.z;

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
    public Uri f64639a;

    /* renamed from: b  reason: collision with root package name */
    public String f64640b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f64641c;

    public e(String str) {
        g(str);
    }

    public Bundle a() {
        if (this.f64641c == null) {
            this.f64641c = new Bundle();
        }
        return this.f64641c;
    }

    public String b(String str) {
        return c(str, null);
    }

    public String c(String str, String str2) {
        Bundle bundle = this.f64641c;
        return bundle == null ? str2 : bundle.getString(str, str2);
    }

    public Uri d() {
        return this.f64639a;
    }

    public final boolean e() {
        try {
            this.f64639a.getScheme();
            this.f64639a.getHost();
            String path = this.f64639a.getPath();
            this.f64640b = path;
            if (!TextUtils.isEmpty(path) && this.f64640b.endsWith("/")) {
                this.f64640b = this.f64640b.substring(0, this.f64640b.length() - 1);
            }
            Set<String> queryParameterNames = this.f64639a.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.isEmpty()) {
                return true;
            }
            if (this.f64641c == null) {
                this.f64641c = new Bundle();
            }
            for (String str : queryParameterNames) {
                String queryParameter = this.f64639a.getQueryParameter(str);
                this.f64641c.putString(str, queryParameter);
                if (TextUtils.equals(str, "params") && !TextUtils.isEmpty(queryParameter)) {
                    try {
                        JSONObject jSONObject = new JSONObject(queryParameter);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f64641c.putString(next, jSONObject.optString(next, ""));
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
        this.f64639a = uri;
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
