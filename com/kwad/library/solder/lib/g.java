package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import java.io.File;
/* loaded from: classes10.dex */
public class g extends com.kwad.library.solder.lib.a.a {
    public g(String str) {
        super(str);
    }

    public static void e(File file) {
        if (file.exists()) {
            if (!file.getAbsolutePath().trim().startsWith("/data/")) {
                new StringBuilder("Apk file seems to locate in external path (not executable), path = ").append(file.getAbsolutePath());
                return;
            }
            return;
        }
        throw new PluginError.LoadError("Apk file not exist.", 4001);
    }

    @Override // com.kwad.library.solder.lib.a.a
    public void g(Context context, String str) {
        new StringBuilder("start install plugin installPath: ").append(str);
        e(new File(str));
    }
}
