package com.kwad.library.solder.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import java.io.File;
/* loaded from: classes10.dex */
public abstract class a {
    public File ajc;
    public String ajd;
    public String aje;
    public final String ajh;
    public com.kwad.library.solder.lib.c.b aji;
    public String mVersion;
    public final byte[] ajg = new byte[0];
    public boolean ajf = false;
    public com.kwad.library.solder.lib.ext.c aiI = i.wU().wO();

    public abstract void g(Context context, String str);

    public a(String str) {
        this.ajh = str;
        this.ajd = str;
    }

    public final a a(@NonNull com.kwad.library.solder.lib.c.b bVar) {
        this.aji = bVar;
        return this;
    }

    public final void bB(String str) {
        this.mVersion = str;
    }

    public final void bC(String str) {
        this.aje = str;
    }

    public final void bD(String str) {
        this.ajd = str;
    }

    private void wY() {
        if (this.ajf) {
            return;
        }
        synchronized (this.ajg) {
            this.ajf = true;
        }
    }

    public final String getId() {
        return this.aje;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z;
        if (this.ajf) {
            return true;
        }
        synchronized (this.ajg) {
            z = this.ajf;
        }
        return z;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.ajh + "'}";
    }

    public final String wZ() {
        return this.ajh;
    }

    public final String xa() {
        com.kwad.library.solder.lib.c.b bVar = this.aji;
        if (bVar != null) {
            return bVar.ajP;
        }
        return null;
    }

    public final void l(Context context, String str) {
        g(context, str);
        wY();
    }
}
