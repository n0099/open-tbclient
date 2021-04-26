package d.a.h0.a.l0.h.c;

import androidx.annotation.NonNull;
import d.a.h0.a.u0.d;
import java.io.File;
/* loaded from: classes2.dex */
public abstract class b implements a {
    static {
        String str = d.d() + File.separator + "extension_core";
    }

    @Override // d.a.h0.a.l0.h.c.a
    @NonNull
    public String a() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // d.a.h0.a.l0.h.c.a
    public int b() {
        return 0;
    }

    @Override // d.a.h0.a.l0.h.c.a
    @NonNull
    public String c() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // d.a.h0.a.l0.h.c.a
    @NonNull
    public File e() {
        return new File(d.d(), "extension_core");
    }
}
