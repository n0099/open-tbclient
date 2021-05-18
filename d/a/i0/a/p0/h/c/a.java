package d.a.i0.a.p0.h.c;

import android.text.TextUtils;
import d.a.i0.a.e0.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.p0.h.b<d.a.i0.a.p0.g.b.a> {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43927d;

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_extension_unzip_check", false);
        f43927d = false;
    }

    public a() {
        super(new d.a.i0.a.p0.g.b.a());
    }

    public static boolean r(String str) {
        d.h("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable extensionPath:" + str);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str, "extension.js");
        if (file.exists() && file.length() > 0) {
            z = true;
        }
        d.h("ExtCore-SwanAppPresetControl", "isExtensionFileAvailable: " + z);
        return z;
    }

    @Override // d.a.i0.a.p0.h.b
    public boolean k() {
        d.h("ExtCore-SwanAppPresetControl", "isNeedUpdate sExtensionUnzipCheck=" + f43927d);
        if (f43927d) {
            return !r(h().extensionCorePath) || super.k();
        }
        return super.k();
    }
}
