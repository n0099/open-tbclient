package d.a.k0.z;

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
    public Uri f63646a;

    /* renamed from: b  reason: collision with root package name */
    public String f63647b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f63648c;

    public e(String str) {
        g(str);
    }

    public Bundle a() {
        if (this.f63648c == null) {
            this.f63648c = new Bundle();
        }
        return this.f63648c;
    }

    public String b(String str) {
        return c(str, null);
    }

    public String c(String str, String str2) {
        Bundle bundle = this.f63648c;
        return bundle == null ? str2 : bundle.getString(str, str2);
    }

    public Uri d() {
        return this.f63646a;
    }

    public final boolean e() {
        try {
            this.f63646a.getScheme();
            this.f63646a.getHost();
            String path = this.f63646a.getPath();
            this.f63647b = path;
            if (!TextUtils.isEmpty(path) && this.f63647b.endsWith("/")) {
                this.f63647b = this.f63647b.substring(0, this.f63647b.length() - 1);
            }
            Set<String> queryParameterNames = this.f63646a.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.isEmpty()) {
                return true;
            }
            if (this.f63648c == null) {
                this.f63648c = new Bundle();
            }
            for (String str : queryParameterNames) {
                String queryParameter = this.f63646a.getQueryParameter(str);
                this.f63648c.putString(str, queryParameter);
                if (TextUtils.equals(str, "params") && !TextUtils.isEmpty(queryParameter)) {
                    try {
                        JSONObject jSONObject = new JSONObject(queryParameter);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f63648c.putString(next, jSONObject.optString(next, ""));
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
        this.f63646a = uri;
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
