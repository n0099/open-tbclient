package d.a.m0.h.o0.d.a;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import d.a.m0.a.a2.d;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import d.a.m0.h.s.a;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    static {
        boolean z = k.f46983a;
    }

    public static PathType a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PathType.ERROR;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return PathType.RELATIVE;
        }
        return PathType.NETWORK;
    }

    public static String b() {
        File h2;
        e r = d.g().r();
        if (r.e() && r.Z() != null && (h2 = a.d.h(r.getAppId(), r.Z())) != null && h2.exists()) {
            return "file://" + h2.getAbsolutePath();
        }
        return null;
    }
}
