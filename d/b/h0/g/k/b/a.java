package d.b.h0.g.k.b;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a implements d.b.h0.a.l0.h.c.a {
    @Override // d.b.h0.a.l0.h.c.a
    @NonNull
    public String b() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // d.b.h0.a.l0.h.c.a
    public int c() {
        return 1;
    }

    @Override // d.b.h0.a.l0.h.c.a
    @NonNull
    public String d() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // d.b.h0.a.l0.h.c.a
    @NonNull
    public File e() {
        return new File(d.b.h0.g.q.a.d(), "extension_core");
    }
}
