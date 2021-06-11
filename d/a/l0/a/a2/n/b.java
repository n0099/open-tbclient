package d.a.l0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44456b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, g> f44457a = null;

    public static String c(String str, String str2) {
        String str3;
        if (str.endsWith(File.separator)) {
            str3 = str + str2 + ".json";
        } else {
            str3 = str + File.separator + str2 + ".json";
        }
        File file = new File(str3);
        if (f44456b) {
            Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + file.exists());
        }
        if (file.exists()) {
            return d.a.l0.a.a1.e.m(file);
        }
        return null;
    }

    public g a(String str, @NonNull String str2, @NonNull g gVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return gVar;
        }
        g d2 = d(str, str2, gVar);
        this.f44457a.put(str2, d2);
        return d2;
    }

    public g b(String str, String str2, @NonNull g gVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return gVar;
        }
        if (this.f44457a == null) {
            this.f44457a = new TreeMap();
        }
        g gVar2 = this.f44457a.get(str2);
        if (gVar2 != null) {
            return gVar2;
        }
        g d2 = d(str, str2, gVar);
        this.f44457a.put(str2, d2);
        return d2;
    }

    public final g d(String str, String str2, @NonNull g gVar) {
        String c2 = c(str, str2);
        return TextUtils.isEmpty(c2) ? gVar : g.b(c2, gVar);
    }
}
