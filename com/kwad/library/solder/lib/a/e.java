package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class e<P extends a> {
    public String aiC;
    public d aiS;
    public int ajk;
    public String ajm;
    public String ajn;
    public boolean ajo;
    public P ajp;
    public com.kwad.library.solder.lib.ext.b ajq;
    public Throwable ajr;
    public String ajs;
    public boolean ajt;
    public long aju;
    public String ajv;
    public List<com.kwad.library.solder.lib.c.a> ajw;
    public com.kwad.library.solder.lib.c.b ajx;
    public String mDownloadUrl;
    public String mVersion;
    public int mState = -1;
    public int ajj = 0;
    public final byte[] ajg = new byte[0];
    public StringBuffer ajl = new StringBuffer(String.valueOf(-1));

    public abstract P bH(String str);

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.ajx = bVar;
        this.aiC = bVar.ajM;
        this.mVersion = bVar.version;
        this.ajv = bVar.ajP;
        this.ajt = bVar.ajt;
        this.ajs = bVar.ajs;
        this.aju = bVar.ajO;
        this.mDownloadUrl = bVar.ajN;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.aiS.wR().by(str));
            if (!file.exists()) {
                return arrayList;
            }
            String[] list = file.list();
            if (list != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.aiS.wR().a(str, str4, str3)) {
                            com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                            aVar.ajM = str;
                            aVar.version = str4;
                            aVar.qr = true;
                            arrayList.add(aVar);
                        } else {
                            this.aiS.wR().A(str, str4);
                        }
                    } else {
                        this.aiS.wR().A(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final e a(d dVar) {
        this.aiS = dVar;
        return this;
    }

    public final void bB(String str) {
        this.mVersion = str;
    }

    public final e bE(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.ajl;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public final void bF(String str) {
        this.ajm = str;
    }

    public final void bG(String str) {
        this.ajn = str;
    }

    public final e bI(int i) {
        synchronized (this.ajg) {
            this.mState = i;
        }
        return bE(String.valueOf(i));
    }

    public final void bJ(int i) {
        if (i > 0) {
            this.ajk = i;
        }
    }

    public final void c(P p) {
        this.ajp = p;
    }

    public final e k(@NonNull Throwable th) {
        this.ajr = th;
        return bE(th.getLocalizedMessage());
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.ajq = bVar;
    }

    public final void cancel() {
        synchronized (this.ajg) {
            bI(0);
        }
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final int getState() {
        int i;
        synchronized (this.ajg) {
            i = this.mState;
        }
        return i;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        if (this.mState == 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "PluginRequest{mId='" + this.aiC + "'}";
    }

    public final d xb() {
        return this.aiS;
    }

    public final String xc() {
        return this.ajl.toString();
    }

    @Nullable
    public final Throwable xd() {
        return this.ajr;
    }

    public final boolean xe() {
        bI(-1);
        this.ajw = null;
        int i = this.ajj + 1;
        this.ajj = i;
        if (i <= this.ajk) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String xf() {
        return this.aiC;
    }

    public final boolean xg() {
        return this.ajo;
    }

    public final int xh() {
        return this.ajj;
    }

    @Nullable
    public final String xi() {
        if (!TextUtils.isEmpty(this.ajm)) {
            return this.ajm;
        }
        return this.ajn;
    }

    @Nullable
    public final com.kwad.library.solder.lib.ext.b xj() {
        return this.ajq;
    }

    public final boolean xk() {
        return this.ajt;
    }

    public final String xl() {
        return this.ajs;
    }

    public final String xm() {
        return this.ajv;
    }

    public final com.kwad.library.solder.lib.c.b xn() {
        return this.ajx;
    }

    public final List<com.kwad.library.solder.lib.c.a> xo() {
        String xf = xf();
        if (!TextUtils.isEmpty(xf) && this.ajw == null) {
            this.ajw = b(xf, getVersion(), xm());
        }
        return this.ajw;
    }
}
