package d.b.g0.a.l0.h.c;

import androidx.annotation.NonNull;
import d.b.g0.a.u0.d;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class b implements a {
    static {
        String str = d.d() + File.separator + "extension_core";
    }

    @Override // d.b.g0.a.l0.h.c.a
    @NonNull
    public String b() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // d.b.g0.a.l0.h.c.a
    public int c() {
        return 0;
    }

    @Override // d.b.g0.a.l0.h.c.a
    @NonNull
    public String d() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // d.b.g0.a.l0.h.c.a
    @NonNull
    public File e() {
        return new File(d.d(), "extension_core");
    }
}
