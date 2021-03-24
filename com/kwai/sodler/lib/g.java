package com.kwai.sodler.lib;

import android.content.Context;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
/* loaded from: classes6.dex */
public class g extends com.kwai.sodler.lib.a.a {
    public g(String str) {
        super(str);
    }

    @Override // com.kwai.sodler.lib.a.a
    public void a(Context context, String str) {
        a.b("Sodler.simple.package", "Create plugin package entity.");
        a(new File(str));
        d();
    }

    public void a(File file) {
        if (file == null || !file.exists()) {
            a.e("Sodler.simple.package", "Apk file not exist.");
            throw new PluginError.LoadError("Apk file not exist.", 4001);
        } else if (file.getAbsolutePath().trim().startsWith("/data/")) {
        } else {
            a.e("Sodler.simple.package", "Apk file seems to locate in external path (not executable), path = " + file.getAbsolutePath());
        }
    }
}
