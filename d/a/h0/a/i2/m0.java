package d.a.h0.a.i2;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes3.dex */
public class m0 implements d.a.h0.l.r.a {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final m0 f42764a = new m0();
    }

    public static m0 b() {
        return b.f42764a;
    }

    @Override // d.a.h0.l.r.a
    public boolean a(@NonNull String str) {
        File file = new File(d.a.h0.a.u0.d.d(), str);
        return file.exists() && file.isDirectory();
    }

    public m0() {
    }
}
