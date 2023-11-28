package com.kwad.library.solder.lib.ext;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public final class c {
    public final String ajA;
    public final String ajB;
    public final String ajC;
    public final String ajD;
    public final String ajE;
    public final boolean ajF;
    public final boolean ajG;
    public final boolean ajH;
    public ExecutorService ajI;
    public String ajJ;
    public byte[] ajK;
    public boolean ajL;
    public final int ajk;
    public final String ajy;
    public final String ajz;

    /* loaded from: classes10.dex */
    public static class a {
        public String ajE;
        public boolean ajH;
        public ExecutorService ajI;
        public String ajJ;
        public byte[] ajK;
        public boolean ajL;
        public int ajk = 3;
        public String ajy = "sodler";
        public String ajz = "code-cache";
        public String ajA = "lib";
        public String ajB = SevenZipUtils.FILE_NAME_TEMP;
        public String ajD = "base-1.apk";
        public String ajC = ".tmp";
        public boolean ajG = false;
        public boolean ajF = false;

        public final c xy() {
            return new c(this.ajF, this.ajG, this.ajE, this.ajy, this.ajz, this.ajA, this.ajB, this.ajC, this.ajD, this.ajk, this.ajJ, this.ajK, this.ajL, this.ajH, this.ajI, (byte) 0);
        }

        public final a a(ExecutorService executorService) {
            this.ajI = executorService;
            return this;
        }

        public final a bI(@NonNull String str) {
            this.ajy = str;
            return this;
        }

        public final a bK(int i) {
            if (i > 0) {
                this.ajk = i;
            }
            return this;
        }

        public final a bg(boolean z) {
            this.ajL = false;
            return this;
        }

        public final a bh(boolean z) {
            this.ajH = z;
            return this;
        }
    }

    public c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService) {
        this.ajk = i;
        this.ajy = str2;
        this.ajz = str3;
        this.ajA = str4;
        this.ajB = str5;
        this.ajC = str6;
        this.ajD = str7;
        this.ajE = str;
        this.ajF = z;
        this.ajG = z2;
        this.ajJ = str8;
        this.ajK = bArr;
        this.ajL = z3;
        this.ajH = z4;
        this.ajI = executorService;
    }

    public /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4, executorService);
    }

    public final int getRetryCount() {
        return this.ajk;
    }

    public final String xp() {
        return this.ajy;
    }

    public final String xq() {
        return this.ajz;
    }

    public final String xr() {
        return this.ajA;
    }

    public final String xs() {
        return this.ajB;
    }

    public final String xt() {
        return this.ajC;
    }

    public final String xu() {
        return this.ajD;
    }

    public final boolean xv() {
        return this.ajG;
    }

    public final boolean xw() {
        return this.ajH;
    }

    public final ExecutorService xx() {
        return this.ajI;
    }
}
