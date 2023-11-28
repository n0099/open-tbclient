package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class c implements com.kwad.library.solder.lib.a.b {
    public final File aiG;
    public final File aiH;
    public final com.kwad.library.solder.lib.ext.c aiI;
    public final Context mContext;

    public c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.aiI = cVar;
        this.aiG = applicationContext.getDir(cVar.xp(), 0);
        this.aiH = this.mContext.getCacheDir();
    }

    private String B(String str, String str2) {
        return wN() + File.separator + str + File.separator + str2;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void A(String str, String str2) {
        File file = new File(B(str, str2));
        if (!file.exists()) {
            return;
        }
        q.R(file);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String C(String str, String str2) {
        return wN() + File.separator + str + File.separator + str2 + File.separator + this.aiI.xu();
    }

    @Nullable
    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return C(aVar.getId(), aVar.getVersion());
    }

    public static void delete(String str) {
        q.delete(str);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bx(String str) {
        File file = new File(by(str));
        if (!file.exists()) {
            return;
        }
        q.R(file);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String by(@NonNull String str) {
        return wN() + File.separator + str;
    }

    private boolean i(String str, String str2, boolean z) {
        if (!q.fL(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, ad.fR(str))) {
            return true;
        }
        StringBuilder sb = new StringBuilder("checkSafety md5 fail fileMd5: ");
        sb.append(str2);
        sb.append(", filePath = ");
        sb.append(str);
        delete(str);
        return false;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.aiI.xv()) {
            return false;
        }
        return i(C(str, str2), str3, true);
    }

    private String wN() {
        return this.aiG.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void wM() {
        if (this.aiG.getFreeSpace() >= 10000000) {
            return;
        }
        throw new IOException("No enough capacity.");
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) {
        String a = a(aVar);
        if (!TextUtils.isEmpty(a)) {
            StringBuilder sb = new StringBuilder("install pluginId ");
            sb.append(aVar.getId());
            sb.append(", install path:");
            sb.append(a);
            File file = new File(a);
            if (file.exists() && !this.aiI.xv() && i(file.getAbsolutePath(), aVar.xa(), true)) {
                return a;
            }
            String wZ = aVar.wZ();
            StringBuilder sb2 = new StringBuilder("install pluginId ");
            sb2.append(aVar.getId());
            sb2.append(", source path:");
            sb2.append(wZ);
            File file2 = new File(wZ);
            if (file2.exists()) {
                new StringBuilder("check plugin md5 pluginId: ").append(aVar.getId());
                if (i(wZ, aVar.xa(), true)) {
                    if (file2.renameTo(file)) {
                        new StringBuilder("install plugin success pluginId: ").append(aVar.getId());
                        return a;
                    }
                    try {
                        wM();
                        try {
                            q.f(file2, file);
                            q.R(file2);
                            return a;
                        } catch (Throwable th) {
                            a.e("PluginInstallerImpl", th);
                            throw new PluginError.InstallError(th, 3004);
                        }
                    } catch (Throwable th2) {
                        a.e("PluginInstallerImpl", th2);
                        throw new PluginError.InstallError(th2, 3005);
                    }
                }
                throw new PluginError.InstallError("check plugin md5 fail", 3003);
            }
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        throw new PluginError.InstallError("Can not get install path.", 3006);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.aiI.xt() != null) {
                sb.append(this.aiI.xt());
            }
            File file = new File(this.aiH, sb.toString());
            if (!file.exists() && !file.createNewFile()) {
                return null;
            }
            return file;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.aiI.xt(), this.aiH);
    }
}
