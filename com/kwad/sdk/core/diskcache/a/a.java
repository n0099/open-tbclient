package com.kwad.sdk.core.diskcache.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.utils.am;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class a {
    public static a WD;
    public com.kwad.sdk.core.diskcache.kwai.a WE;
    public Context WF;

    @Nullable
    private File bB(String str) {
        if (sT() || TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a(this.WE, str);
    }

    public static a sS() {
        if (WD == null) {
            synchronized (a.class) {
                if (WD == null) {
                    WD = new a();
                }
            }
        }
        return WD;
    }

    private boolean sT() {
        return this.WE == null;
    }

    @SuppressLint({"MissingPermission"})
    public final void a(b bVar) {
        if (this.WE != null) {
            return;
        }
        try {
            this.WF = bVar.WF;
            if (!bVar.Wa.exists()) {
                bVar.Wa.mkdirs();
            }
            this.WE = com.kwad.sdk.core.diskcache.kwai.a.a(bVar.Wa, bVar.We, 1, bVar.maxSize * 1024 * 1024);
        } catch (Throwable unused) {
        }
    }

    public final boolean a(String str, c.a aVar) {
        File bB;
        if (!sT() && !TextUtils.isEmpty(str)) {
            String bC = d.bC(str);
            if (c.a(this.WE, str, bC, aVar) && (bB = bB(bC)) != null && bB.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File ad(String str) {
        if (sT() || TextUtils.isEmpty(str)) {
            return null;
        }
        return bB(d.bC(str));
    }

    public final boolean b(String str, @NonNull String str2, c.a aVar) {
        File bB;
        if (!sT() && !TextUtils.isEmpty(str)) {
            String bC = d.bC(str2);
            if (c.a(this.WE, str, bC, aVar) && (bB = bB(bC)) != null && bB.exists()) {
                return true;
            }
        }
        return false;
    }

    public final void bA(String str) {
        if (sT() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.WE, str, d.bC(str));
    }

    public final void delete() {
        if (sT()) {
            return;
        }
        try {
            this.WE.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (sT()) {
            return false;
        }
        try {
            am.T(str, "cacheKey is not allowed empty");
            return this.WE.remove(d.bC(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
