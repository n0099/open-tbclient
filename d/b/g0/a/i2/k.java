package d.b.g0.a.i2;

import androidx.annotation.Nullable;
import d.b.g0.a.i2.f0;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class k {
    @Nullable
    public static File a() {
        List<f0.a> d2 = d.b.g0.a.y0.c.a.d();
        if (d2 == null || d2.size() <= 0) {
            return null;
        }
        File file = new File(d2.get(0).f45078a, "/debug/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
