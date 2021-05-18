package d.a.i0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40606b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, g> f40607a = null;

    public static String c(String str, String str2) {
        String str3;
        if (str.endsWith(File.separator)) {
            str3 = str + str2 + ".json";
        } else {
            str3 = str + File.separator + str2 + ".json";
        }
        File file = new File(str3);
        if (f40606b) {
            Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + file.exists());
        }
        if (file.exists()) {
            return d.a.i0.a.a1.e.m(file);
        }
        return null;
    }

    public g a(String str, @NonNull String str2, @NonNull g gVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return gVar;
        }
        g d2 = d(str, str2, gVar);
        this.f40607a.put(str2, d2);
        return d2;
    }

    public g b(String str, String str2, @NonNull g gVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return gVar;
        }
        if (this.f40607a == null) {
            this.f40607a = new TreeMap();
        }
        g gVar2 = this.f40607a.get(str2);
        if (gVar2 != null) {
            return gVar2;
        }
        g d2 = d(str, str2, gVar);
        this.f40607a.put(str2, d2);
        return d2;
    }

    public final g d(String str, String str2, @NonNull g gVar) {
        String c2 = c(str, str2);
        return TextUtils.isEmpty(c2) ? gVar : g.b(c2, gVar);
    }
}
