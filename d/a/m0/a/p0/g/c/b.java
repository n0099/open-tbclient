package d.a.m0.a.p0.g.c;

import androidx.annotation.NonNull;
import d.a.m0.a.a1.e;
import java.io.File;
/* loaded from: classes3.dex */
public abstract class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f47874a = e.g() + File.separator + "extension_core";

    @Override // d.a.m0.a.p0.g.c.a
    @NonNull
    public String a() {
        return "aiapps/extcore/extension-core.zip";
    }

    @Override // d.a.m0.a.p0.g.c.a
    public int c() {
        return 0;
    }

    @Override // d.a.m0.a.p0.g.c.a
    @NonNull
    public String d() {
        return "aiapps/extcore/extension-config.json";
    }

    @Override // d.a.m0.a.p0.g.c.a
    @NonNull
    public File f() {
        return new File(f47874a);
    }
}
