package d.a.m0.a.v2;

import androidx.annotation.Nullable;
import d.a.m0.a.v2.k0;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class l {
    @Nullable
    public static File a() {
        List<k0.a> d2 = d.a.m0.a.f1.c.a.d();
        if (d2 == null || d2.size() <= 0) {
            return null;
        }
        File file = new File(d2.get(0).f49205a, "/debug/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String b() {
        return new File(d.a.m0.a.f1.c.a.d().get(0).f49205a, "/debug/").getAbsolutePath();
    }
}
