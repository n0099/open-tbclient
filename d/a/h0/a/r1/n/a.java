package d.a.h0.a.r1.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import d.a.h0.a.u0.d;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43851b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, c> f43852a = null;

    public static String c(String str, String str2) {
        String str3;
        if (str.endsWith(File.separator)) {
            str3 = str + str2 + ".json";
        } else {
            str3 = str + File.separator + str2 + ".json";
        }
        File file = new File(str3);
        if (f43851b) {
            Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + file.exists());
        }
        if (file.exists()) {
            return d.h(file);
        }
        return null;
    }

    public c a(String str, @NonNull String str2, @NonNull c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        c d2 = d(str, str2, cVar);
        this.f43852a.put(str2, d2);
        return d2;
    }

    public c b(String str, String str2, @NonNull c cVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        if (this.f43852a == null) {
            this.f43852a = new TreeMap();
        }
        c cVar2 = this.f43852a.get(str2);
        if (cVar2 != null) {
            return cVar2;
        }
        c d2 = d(str, str2, cVar);
        this.f43852a.put(str2, d2);
        return d2;
    }

    public final c d(String str, String str2, @NonNull c cVar) {
        String c2 = c(str, str2);
        return TextUtils.isEmpty(c2) ? cVar : c.b(c2, cVar);
    }
}
