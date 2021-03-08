package com.github.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a {
    public static String pSj;
    public static int pSk;
    public String model;
    public long nAJ;
    public String network;
    public String pSl;
    public String pSo;
    public String pSp;
    public long pSq;
    public String pSr;
    public String pSs;
    public boolean pSt;
    public String pSu;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pRU = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pSi = com.github.a.a.c.eAN().provideQualifier();
    public String pSm = "";
    public int pSn = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pSv = new ArrayList<>();
    private StringBuilder pSw = new StringBuilder();
    private StringBuilder pSx = new StringBuilder();
    private StringBuilder pSy = new StringBuilder();
    public StringBuilder pSz = new StringBuilder();

    static {
        pSj = "";
        pSk = -1;
        pSk = b.getNumCores();
        pSj = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a eAV() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.eAN().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.pSn = pSk;
        aVar.model = sModel;
        aVar.pSm = pSj;
        aVar.pSl = pSi;
        aVar.uid = com.github.a.a.c.eAN().provideUid();
        aVar.processName = c.eAX();
        aVar.network = com.github.a.a.c.eAN().provideNetworkType();
        aVar.pSo = String.valueOf(b.getFreeMemory());
        aVar.pSp = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZW(String str) {
        this.pSu = str;
        return this;
    }

    public a bo(ArrayList<String> arrayList) {
        this.pSv = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nAJ = j2 - j;
        this.pSq = j4 - j3;
        this.pSr = Long.toString(j);
        this.pSs = Long.toString(j2);
        return this;
    }

    public a eAW() {
        this.pSw.append("qua").append(" = ").append(this.pSl).append("\r\n");
        this.pSw.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pSw.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pSw.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pSw.append("network").append(" = ").append(this.network).append("\r\n");
        this.pSw.append("model").append(" = ").append(this.model).append("\r\n");
        this.pSw.append("api-level").append(" = ").append(this.pSm).append("\r\n");
        this.pSw.append("cpu-core").append(" = ").append(this.pSn).append("\r\n");
        this.pSw.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pSw.append("freeMemory").append(" = ").append(this.pSo).append("\r\n");
        this.pSw.append("totalMemory").append(" = ").append(this.pSp).append("\r\n");
        this.pSy.append("time").append(" = ").append(this.nAJ).append("\r\n");
        this.pSy.append("thread-time").append(" = ").append(this.pSq).append("\r\n");
        this.pSy.append("time-start").append(" = ").append(this.pSr).append("\r\n");
        this.pSy.append("time-end").append(" = ").append(this.pSs).append("\r\n");
        this.pSx.append("cpu-busy").append(" = ").append(this.pSt).append("\r\n");
        this.pSx.append("cpu-rate").append(" = ").append(this.pSu).append("\r\n");
        if (this.pSv != null && !this.pSv.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pSv.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pSz.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pSw) + ((Object) this.pSy) + ((Object) this.pSx) + ((Object) this.pSz);
    }
}
