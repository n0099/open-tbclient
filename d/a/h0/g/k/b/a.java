package d.a.h0.g.k.b;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a implements d.a.h0.a.l0.h.c.a {
    @Override // d.a.h0.a.l0.h.c.a
    @NonNull
    public String a() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // d.a.h0.a.l0.h.c.a
    public int b() {
        return 1;
    }

    @Override // d.a.h0.a.l0.h.c.a
    @NonNull
    public String c() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // d.a.h0.a.l0.h.c.a
    @NonNull
    public File e() {
        return new File(d.a.h0.g.q.a.d(), "extension_core");
    }
}
