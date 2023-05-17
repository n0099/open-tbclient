package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes9.dex */
public final class b {
    public final String acw;
    public final boolean agB;
    public final boolean agC;
    public final com.kwad.sdk.crash.model.b agF;
    public final com.kwad.sdk.crash.model.a agG;
    public final g agH;
    public final String[] agI;
    public final String[] agJ;
    public final boolean agK;
    public final e agL;
    public final String agM;
    public final String agN;
    public final String agO;
    public final String agP;
    public final String agQ;
    public final Context context;
    public final boolean isExternal;
    public final String platform;
    public final String version;

    /* loaded from: classes9.dex */
    public static class a {
        public String LH;
        public int LI;
        public int LJ;
        public int abn;
        public String acw;
        public e agL;
        public String agM;
        public String agN;
        public String agO;
        public String agR;
        public g agS;
        public String[] agT;
        public String[] agU;
        public String appId;
        public String appName;
        public String appPackageName;
        public String appVersion;
        public Context context;
        public String platform;
        public String sdkVersion;
        public String version;
        public boolean agK = false;
        public boolean agB = false;
        public boolean agC = false;
        public boolean isExternal = false;
        public String agP = "";
        public String agQ = "";

        public final a a(e eVar) {
            this.agL = eVar;
            return this;
        }

        public final a a(g gVar) {
            this.agS = gVar;
            return this;
        }

        public final a aR(boolean z) {
            this.agB = z;
            return this;
        }

        public final a aS(boolean z) {
            this.agC = z;
            return this;
        }

        public final a aT(boolean z) {
            this.isExternal = z;
            return this;
        }

        public final a bI(Context context) {
            this.context = context;
            return this;
        }

        public final a bc(int i) {
            this.abn = i;
            return this;
        }

        public final a bd(int i) {
            this.LI = i;
            return this;
        }

        public final a be(int i) {
            this.LJ = 1;
            return this;
        }

        public final a cL(String str) {
            this.agP = str;
            return this;
        }

        public final a cM(String str) {
            this.agQ = str;
            return this;
        }

        public final a cN(String str) {
            this.platform = str;
            return this;
        }

        public final a cO(String str) {
            this.acw = str;
            return this;
        }

        public final a cP(String str) {
            this.agM = str;
            return this;
        }

        public final a cQ(String str) {
            this.agO = str;
            return this;
        }

        public final a cR(String str) {
            this.agR = str;
            return this;
        }

        public final a cS(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a cT(String str) {
            this.LH = str;
            return this;
        }

        public final a cU(String str) {
            this.appId = str;
            return this;
        }

        public final a cV(String str) {
            this.appName = str;
            return this;
        }

        public final a cW(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a cX(String str) {
            this.appVersion = str;
            return this;
        }

        public final a d(String[] strArr) {
            this.agT = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.agU = strArr;
            return this;
        }

        public final b wy() {
            return new b(this, (byte) 0);
        }
    }

    public b(a aVar) {
        this.agF = new com.kwad.sdk.crash.model.b();
        this.agG = new com.kwad.sdk.crash.model.a();
        this.agK = aVar.agK;
        this.agB = aVar.agB;
        this.agC = aVar.agC;
        this.isExternal = aVar.isExternal;
        this.agP = aVar.agP;
        this.agQ = aVar.agQ;
        this.context = aVar.context;
        this.agL = aVar.agL;
        this.platform = aVar.platform;
        this.version = aVar.version;
        this.acw = aVar.acw;
        this.agM = aVar.agM;
        this.agN = aVar.agN;
        this.agO = aVar.agO;
        this.agG.mAppId = aVar.appId;
        this.agG.mAppName = aVar.appName;
        this.agG.ahu = aVar.appVersion;
        this.agG.aht = aVar.appPackageName;
        this.agF.ahx = aVar.LH;
        this.agF.ahy = aVar.LI;
        this.agF.mSdkVersion = aVar.sdkVersion;
        this.agF.ahw = aVar.abn;
        this.agF.ahv = aVar.agR;
        this.agF.ahz = aVar.LJ;
        this.agH = aVar.agS;
        this.agI = aVar.agT;
        this.agJ = aVar.agU;
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    public final e ww() {
        return this.agL;
    }

    public final boolean wx() {
        return this.agK;
    }
}
