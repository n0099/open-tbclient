package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    public static void d(Set<File> set) {
        for (File file : set) {
            q.R(file);
        }
    }

    private File f(File file) {
        File file2 = new File(file.getParentFile(), this.aiI.xr());
        q.X(file2);
        return file2;
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        new StringBuilder("install plugin so libs, destDir = ").append(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.aiI.xs());
        q.X(file3);
        for (String str2 : com.kwad.library.solder.lib.d.c.b(file, file3)) {
            new StringBuilder("extractSoLib, soName = ").append(str2);
            File a = com.kwad.library.solder.lib.d.c.a(file3, str2, file2);
            if (a != null) {
                hashSet.add(a);
            }
        }
        q.R(file3);
        return hashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r3 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
        throw new com.kwad.library.solder.lib.ext.PluginError.LoadError(new java.lang.Exception(r2 + " not found"), 4001);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(Set<File> set) {
        com.kwad.library.solder.lib.c.b bVar = this.aji;
        if (bVar != null && bVar.ajS.size() > 0 && set != null) {
            for (Map.Entry<String, String> entry : this.aji.ajS.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    boolean z = false;
                    Iterator<File> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File next = it.next();
                        String ab = ad.ab(next);
                        if (next.getName().equals(key)) {
                            z = true;
                            if (!TextUtils.equals(ab, value)) {
                                d(set);
                                throw new PluginError.LoadError(new Exception(next.getName() + " Md5 check error,find " + ab + ",except " + value), 4008);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void g(Context context, String str) {
        ClassLoader classLoader;
        super.g(context, str);
        new StringBuilder("start install so plugin so pluginId:").append(getId());
        File file = new File(str);
        try {
            File f = f(file);
            this.ajc = f;
            try {
                try {
                    c(a(context, file, f));
                    com.kwad.library.solder.lib.c.b bVar = this.aji;
                    if (bVar == null || (classLoader = bVar.ajV) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        com.kwad.library.solder.lib.ext.d.c(classLoader, this.ajc);
                    }
                } catch (PluginError.LoadError e) {
                    q.R(file);
                    throw e;
                }
            } catch (IOException e2) {
                throw new PluginError.LoadError(e2, 4004);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4003);
        }
    }
}
