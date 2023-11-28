package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public static final String TAG = "c";
    public final double aDX;
    public final boolean aEb;
    public final boolean aEc;
    public final com.kwad.sdk.crash.model.c aEf;
    public final com.kwad.sdk.crash.model.a aEg;
    public final h aEh;
    public final String[] aEi;
    public final String[] aEj;
    public final boolean aEk;
    public final f aEl;
    public final String aEm;
    public final String aEn;
    public final String aEo;
    public final String aEp;
    public final String aEq;
    public final String aEr;
    public final String aEs;
    public final String aEt;
    public final List<com.kwad.sdk.crash.a> aEu;
    public final String aym;
    public final String channel;
    public final Context context;
    public final boolean isExternal;
    public final String platform;
    public final String sdkVersion;

    /* loaded from: classes10.dex */
    public static class a {
        public String WA;
        public int WB;
        public f aEl;
        public String aEm;
        public String aEn;
        public String aEo;
        public String aEp;
        public String aEv;
        public h aEw;
        public String[] aEx;
        public String[] aEy;
        public String appId;
        public String appName;
        public String appPackageName;
        public String appVersion;
        public int awL;
        public String aym;
        public String channel;
        public Context context;
        public String platform;
        public int sdkType;
        public String sdkVersion;
        public boolean aEk = false;
        public boolean aEb = false;
        public boolean aEc = false;
        public boolean isExternal = false;
        public String aEq = "";
        public String aEr = "";
        public String aEs = "";
        public String aEt = "";
        public List<com.kwad.sdk.crash.a> aEu = new ArrayList();
        public double aDX = 1.0d;

        public final c Gk() {
            return new c(this, (byte) 0);
        }

        public final a bv(Context context) {
            this.context = context;
            return this;
        }

        public final a bw(boolean z) {
            this.aEb = z;
            return this;
        }

        public final a bx(boolean z) {
            this.aEc = z;
            return this;
        }

        public final a by(boolean z) {
            this.isExternal = z;
            return this;
        }

        public final a da(int i) {
            this.awL = i;
            return this;
        }

        public final a db(int i) {
            this.WB = i;
            return this;
        }

        public final a dc(int i) {
            this.sdkType = 1;
            return this;
        }

        public final a eD(String str) {
            this.aEq = str;
            return this;
        }

        public final a eE(String str) {
            this.aEr = str;
            return this;
        }

        public final a eF(String str) {
            this.platform = str;
            return this;
        }

        public final a eG(String str) {
            this.aEm = str;
            return this;
        }

        public final a eH(String str) {
            this.aym = str;
            return this;
        }

        public final a eI(String str) {
            this.channel = str;
            return this;
        }

        public final a eJ(String str) {
            this.aEp = str;
            return this;
        }

        public final a eK(String str) {
            this.aEv = str;
            return this;
        }

        public final a eL(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a eM(String str) {
            this.WA = str;
            return this;
        }

        public final a eN(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a eO(String str) {
            this.appId = str;
            return this;
        }

        public final a eP(String str) {
            this.appName = str;
            return this;
        }

        public final a eQ(String str) {
            this.appVersion = str;
            return this;
        }

        public final a eR(String str) {
            this.aEn = str;
            return this;
        }

        public final a eS(String str) {
            this.aEs = str;
            return this;
        }

        public final a eT(String str) {
            this.aEt = str;
            return this;
        }

        public final a C(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aEu.add(aVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.w(c.TAG, Log.getStackTraceString(e));
                    }
                }
            }
            return this;
        }

        public final a a(f fVar) {
            this.aEl = fVar;
            return this;
        }

        public final a d(String[] strArr) {
            this.aEx = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.aEy = strArr;
            return this;
        }

        public final a m(double d) {
            this.aDX = d;
            return this;
        }

        public final a a(h hVar) {
            this.aEw = hVar;
            return this;
        }
    }

    public c(a aVar) {
        this.aEf = new com.kwad.sdk.crash.model.c();
        this.aEg = new com.kwad.sdk.crash.model.a();
        this.aEu = new ArrayList();
        this.aEk = aVar.aEk;
        this.aEb = aVar.aEb;
        this.aEc = aVar.aEc;
        this.isExternal = aVar.isExternal;
        this.aEq = aVar.aEq;
        this.aEr = aVar.aEr;
        this.aEs = aVar.aEs;
        this.aEt = aVar.aEt;
        this.context = aVar.context;
        this.aEl = aVar.aEl;
        this.platform = aVar.platform;
        this.aEm = aVar.aEm;
        this.aEn = aVar.aEn;
        this.sdkVersion = aVar.sdkVersion;
        this.aym = aVar.aym;
        this.channel = aVar.channel;
        this.aEo = aVar.aEo;
        this.aEp = aVar.aEp;
        this.aEg.aEY = aVar.appId;
        this.aEg.mAppName = aVar.appName;
        this.aEg.aFa = aVar.appVersion;
        this.aEg.aEZ = aVar.appPackageName;
        this.aEf.aFj = aVar.WA;
        this.aEf.aFk = aVar.WB;
        this.aEf.mSdkVersion = aVar.sdkVersion;
        this.aEf.aFi = aVar.awL;
        this.aEf.aFh = aVar.aEv;
        this.aEf.aFl = aVar.sdkType;
        this.aEh = aVar.aEw;
        this.aEi = aVar.aEx;
        this.aEj = aVar.aEy;
        this.aEu.addAll(aVar.aEu);
        this.aDX = aVar.aDX;
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final f Gh() {
        return this.aEl;
    }

    public final boolean Gi() {
        return this.aEk;
    }
}
