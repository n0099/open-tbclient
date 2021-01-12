package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class i extends g {
    public i(String str) {
        super(str);
    }

    private void a(Set<File> set) {
        if (this.f == null || this.f.h.size() <= 0 || set == null) {
            return;
        }
        HashMap<String, String> hashMap = this.f.h;
        for (File file : set) {
            String f = com.kwai.sodler.lib.c.a.f(file);
            String str = hashMap.get(file.getName());
            if (str != null && !TextUtils.equals(f, str)) {
                b(set);
                throw new PluginError.LoadError(new Exception(file.getName() + "Md5 check error,find " + f + ",except " + str), (int) PluginError.ERROR_LOA_SO_MD5_CHECK);
            }
        }
    }

    private void b(Set<File> set) {
        for (File file : set) {
            com.kwai.sodler.lib.c.a.a(file);
        }
    }

    protected Set<File> a(Context context, File file, File file2) {
        a.b("Sodler.simple.SoLib", "Install plugin so libs, destDir = " + file2);
        HashSet hashSet = new HashSet();
        if (!file2.exists() || file2.list().length <= 0) {
            File file3 = new File(file2.getParentFile(), this.c.d());
            com.kwai.sodler.lib.c.a.e(file3);
            Set<String> a2 = com.kwai.sodler.lib.c.c.a(file, file3);
            if (a2 != null) {
                for (String str : a2) {
                    File a3 = com.kwai.sodler.lib.c.c.a(context, file3, str, file2);
                    if (a3 != null) {
                        hashSet.add(a3);
                    }
                }
                com.kwai.sodler.lib.c.a.a(file3);
            }
            return hashSet;
        }
        return hashSet;
    }

    @Override // com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public void a(Context context, String str) {
        a.b("Sodler.simple.SoLib", "Install plugin so libs.");
        File file = new File(str);
        a(file);
        try {
            this.f10996a = b(file);
            try {
                a(a(context, file, this.f10996a));
                synchronized (Runtime.getRuntime()) {
                    com.kwai.sodler.lib.ext.d.a(getClass().getClassLoader(), this.f10996a);
                }
                super.a(context, str);
            } catch (IOException e) {
                throw new PluginError.LoadError(e, 4004);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4003);
        }
    }

    public File b(File file) {
        File file2 = new File(file.getParentFile(), this.c.c());
        com.kwai.sodler.lib.c.a.e(file2);
        return file2;
    }
}
