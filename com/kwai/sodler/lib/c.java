package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements com.kwai.sodler.lib.a.c {

    /* renamed from: a  reason: collision with root package name */
    private final File f7252a;
    private final File b;
    private final Context c;
    private final com.kwai.sodler.lib.ext.c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.kwai.sodler.lib.ext.c cVar) {
        this.c = context.getApplicationContext();
        this.d = cVar;
        this.f7252a = this.c.getDir(this.d.b(), 0);
        this.b = this.c.getCacheDir();
    }

    @Nullable
    public String a(com.kwai.sodler.lib.a.a aVar) {
        return b(aVar.c(), aVar.a());
    }

    @Override // com.kwai.sodler.lib.a.c
    public void a() {
        if (this.f7252a.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    public void a(String str, String str2) {
        com.kwai.sodler.lib.c.a.a(b(str, str2));
    }

    public boolean a(String str) {
        a.b("Sodler.installer", "Check plugin's validation.");
        if (com.kwai.sodler.lib.c.a.b(str)) {
            a.a("Sodler.installer", "Check plugin's signatures success, path = " + str);
            return true;
        }
        a.e("Sodler.installer", "Plugin not found, path = " + str);
        return false;
    }

    public boolean a(String str, String str2, boolean z) {
        if (a(b(str, str2))) {
            return true;
        }
        if (z) {
            a(str, str2);
        }
        return false;
    }

    public boolean a(String str, boolean z) {
        if (a(str)) {
            return true;
        }
        if (z) {
            b(str);
        }
        return false;
    }

    public String b() {
        return this.f7252a.getAbsolutePath();
    }

    @Override // com.kwai.sodler.lib.a.c
    public String b(com.kwai.sodler.lib.a.a aVar) {
        String e = aVar.e();
        a.c("Sodler.installer", "Install plugin, path = " + e);
        File file = new File(e);
        if (!file.exists()) {
            a.e("Sodler.installer", "Plugin path not exist");
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        a.a("Sodler.installer", "Check plugin's signatures.");
        if (!a(e, true)) {
            a.e("Sodler.installer", "Check plugin's signatures fail.");
            throw new PluginError.InstallError("Check plugin's signatures fail.", 3003);
        }
        String a2 = a(aVar);
        if (TextUtils.isEmpty(a2)) {
            throw new PluginError.InstallError("Can not get install path.", (int) PluginError.ERROR_INS_INSTALL_PATH);
        }
        a.a("Sodler.installer", "Install path = " + a2);
        File file2 = new File(a2);
        if (file2.exists()) {
            if (!this.d.g() && a(file2.getAbsolutePath(), true)) {
                a.b("Sodler.installer", "Plugin has been already installed.");
                return a2;
            }
            a.b("Sodler.installer", "Ignore installed plugin.");
        }
        a.b("Sodler.installer", "Install plugin, from = " + e + ", to = " + a2);
        if (file.renameTo(file2)) {
            a.b("Sodler.installer", "Rename success.");
        } else {
            try {
                a();
                try {
                    a.b("Sodler.installer", "Rename fail, try copy file.");
                    com.kwai.sodler.lib.c.a.a(file, file2);
                } catch (Throwable th) {
                    a.a("Sodler.installer", th);
                    throw new PluginError.InstallError(th, 3004);
                }
            } catch (Throwable th2) {
                a.a("Sodler.installer", th2);
                throw new PluginError.InstallError(th2, (int) PluginError.ERROR_INS_CAPACITY);
            }
        }
        return a2;
    }

    @Override // com.kwai.sodler.lib.a.c
    public String b(String str, String str2) {
        return b() + File.separator + str + File.separator + str2 + File.separator + this.d.f();
    }

    public void b(String str) {
        com.kwai.sodler.lib.c.a.a(str);
    }

    @Override // com.kwai.sodler.lib.a.c
    public void c(String str) {
        File file = new File(e(str));
        if (file.exists()) {
            com.kwai.sodler.lib.c.a.a(file);
        } else {
            a.e("Sodler.installer", "Delete fail, dir not found, path = " + file.getAbsolutePath());
        }
    }

    @Override // com.kwai.sodler.lib.a.c
    public boolean c(String str, String str2) {
        if (this.d.g()) {
            return false;
        }
        return a(str, str2, true);
    }

    @Override // com.kwai.sodler.lib.a.c
    public File d(String str) {
        return File.createTempFile(str + System.currentTimeMillis(), this.d.e(), this.b);
    }

    @Override // com.kwai.sodler.lib.a.c
    public String e(@NonNull String str) {
        return b() + File.separator + str;
    }
}
