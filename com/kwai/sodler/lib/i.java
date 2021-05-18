package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class i extends g {
    public i(String str) {
        super(str);
    }

    private void a(Set<File> set) {
        com.kwai.sodler.lib.b.b bVar = this.f34480f;
        if (bVar == null || bVar.f34504h.size() <= 0 || set == null) {
            return;
        }
        HashMap<String, String> hashMap = this.f34480f.f34504h;
        for (File file : set) {
            String f2 = com.kwai.sodler.lib.c.a.f(file);
            String str = hashMap.get(file.getName());
            if (str != null && !TextUtils.equals(f2, str)) {
                b(set);
                throw new PluginError.LoadError(new Exception(file.getName() + "Md5 check error,find " + f2 + ",except " + str), 4008);
            }
        }
    }

    private void b(Set<File> set) {
        for (File file : set) {
            com.kwai.sodler.lib.c.a.a(file);
        }
    }

    public Set<File> a(Context context, File file, File file2) {
        a.b("Sodler.simple.SoLib", "Install plugin so libs, destDir = " + file2);
        HashSet hashSet = new HashSet();
        if (!file2.exists() || file2.list().length <= 0) {
            File file3 = new File(file2.getParentFile(), this.f34477c.d());
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
            File b2 = b(file);
            this.f34475a = b2;
            try {
                a(a(context, file, b2));
                synchronized (Runtime.getRuntime()) {
                    com.kwai.sodler.lib.ext.d.a(getClass().getClassLoader(), this.f34475a);
                }
                super.a(context, str);
            } catch (IOException e2) {
                throw new PluginError.LoadError(e2, 4004);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4003);
        }
    }

    public File b(File file) {
        File file2 = new File(file.getParentFile(), this.f34477c.c());
        com.kwai.sodler.lib.c.a.e(file2);
        return file2;
    }
}
