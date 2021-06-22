package d.a.m0.a.v2;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes3.dex */
public class t0 implements d.a.m0.n.o.a {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final t0 f49263a = new t0();
    }

    public static t0 b() {
        return b.f49263a;
    }

    @Override // d.a.m0.n.o.a
    public boolean a(@NonNull String str, @NonNull int i2) {
        if (i2 == 0) {
            File file = new File(d.a.m0.a.a1.e.g(), str);
            return file.exists() && file.isDirectory();
        } else if (i2 != 1) {
            return false;
        } else {
            File file2 = new File(d.a.m0.a.c1.b.g().b(), str);
            return file2.exists() && file2.isDirectory();
        }
    }

    public t0() {
    }
}
