package d.a.l0.h.m.c;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class a implements d.a.l0.a.p0.g.c.a {
    @Override // d.a.l0.a.p0.g.c.a
    @NonNull
    public String a() {
        return "aigames/extcore/game-extension-core.zip";
    }

    @Override // d.a.l0.a.p0.g.c.a
    public int c() {
        return 1;
    }

    @Override // d.a.l0.a.p0.g.c.a
    @NonNull
    public String d() {
        return "aigames/extcore/game-extension-config.json";
    }

    @Override // d.a.l0.a.p0.g.c.a
    @NonNull
    public File f() {
        return new File(d.a.l0.h.s.a.d(), "extension_core");
    }
}
