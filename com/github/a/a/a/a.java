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
/* loaded from: classes6.dex */
public class a {
    public static String pQU;
    public static int pQV;
    public String model;
    public String network;
    public long nye;
    public String pQW;
    public String pQZ;
    public String pRa;
    public long pRb;
    public String pRc;
    public String pRd;
    public boolean pRe;
    public String pRf;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pQF = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pQT = com.github.a.a.c.eAz().provideQualifier();
    public String pQX = "";
    public int pQY = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pRg = new ArrayList<>();
    private StringBuilder pRh = new StringBuilder();
    private StringBuilder pRi = new StringBuilder();
    private StringBuilder pRj = new StringBuilder();
    public StringBuilder pRk = new StringBuilder();

    static {
        pQU = "";
        pQV = -1;
        pQV = b.getNumCores();
        pQU = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a eAH() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.eAz().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.pQY = pQV;
        aVar.model = sModel;
        aVar.pQX = pQU;
        aVar.pQW = pQT;
        aVar.uid = com.github.a.a.c.eAz().provideUid();
        aVar.processName = c.eAJ();
        aVar.network = com.github.a.a.c.eAz().provideNetworkType();
        aVar.pQZ = String.valueOf(b.getFreeMemory());
        aVar.pRa = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZF(String str) {
        this.pRf = str;
        return this;
    }

    public a bo(ArrayList<String> arrayList) {
        this.pRg = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nye = j2 - j;
        this.pRb = j4 - j3;
        this.pRc = Long.toString(j);
        this.pRd = Long.toString(j2);
        return this;
    }

    public a eAI() {
        this.pRh.append("qua").append(" = ").append(this.pQW).append("\r\n");
        this.pRh.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pRh.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pRh.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pRh.append("network").append(" = ").append(this.network).append("\r\n");
        this.pRh.append("model").append(" = ").append(this.model).append("\r\n");
        this.pRh.append("api-level").append(" = ").append(this.pQX).append("\r\n");
        this.pRh.append("cpu-core").append(" = ").append(this.pQY).append("\r\n");
        this.pRh.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pRh.append("freeMemory").append(" = ").append(this.pQZ).append("\r\n");
        this.pRh.append("totalMemory").append(" = ").append(this.pRa).append("\r\n");
        this.pRj.append("time").append(" = ").append(this.nye).append("\r\n");
        this.pRj.append("thread-time").append(" = ").append(this.pRb).append("\r\n");
        this.pRj.append("time-start").append(" = ").append(this.pRc).append("\r\n");
        this.pRj.append("time-end").append(" = ").append(this.pRd).append("\r\n");
        this.pRi.append("cpu-busy").append(" = ").append(this.pRe).append("\r\n");
        this.pRi.append("cpu-rate").append(" = ").append(this.pRf).append("\r\n");
        if (this.pRg != null && !this.pRg.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pRg.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pRk.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pRh) + ((Object) this.pRj) + ((Object) this.pRi) + ((Object) this.pRk);
    }
}
