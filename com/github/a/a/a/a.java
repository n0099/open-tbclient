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
    public static String pGP;
    public static int pGQ;
    public String model;
    public String network;
    public long nou;
    public String pGR;
    public String pGU;
    public String pGV;
    public long pGW;
    public String pGX;
    public String pGY;
    public boolean pGZ;
    public String pHa;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pGA = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pGO = com.github.a.a.c.eyh().provideQualifier();
    public String pGS = "";
    public int pGT = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pHb = new ArrayList<>();
    private StringBuilder pHc = new StringBuilder();
    private StringBuilder pHd = new StringBuilder();
    private StringBuilder pHe = new StringBuilder();
    public StringBuilder pHf = new StringBuilder();

    static {
        pGP = "";
        pGQ = -1;
        pGQ = b.getNumCores();
        pGP = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a eyp() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.eyh().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.pGT = pGQ;
        aVar.model = sModel;
        aVar.pGS = pGP;
        aVar.pGR = pGO;
        aVar.uid = com.github.a.a.c.eyh().provideUid();
        aVar.processName = c.eyr();
        aVar.network = com.github.a.a.c.eyh().provideNetworkType();
        aVar.pGU = String.valueOf(b.getFreeMemory());
        aVar.pGV = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a YE(String str) {
        this.pHa = str;
        return this;
    }

    public a bp(ArrayList<String> arrayList) {
        this.pHb = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nou = j2 - j;
        this.pGW = j4 - j3;
        this.pGX = Long.toString(j);
        this.pGY = Long.toString(j2);
        return this;
    }

    public a eyq() {
        this.pHc.append("qua").append(" = ").append(this.pGR).append("\r\n");
        this.pHc.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pHc.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pHc.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pHc.append("network").append(" = ").append(this.network).append("\r\n");
        this.pHc.append("model").append(" = ").append(this.model).append("\r\n");
        this.pHc.append("api-level").append(" = ").append(this.pGS).append("\r\n");
        this.pHc.append("cpu-core").append(" = ").append(this.pGT).append("\r\n");
        this.pHc.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pHc.append("freeMemory").append(" = ").append(this.pGU).append("\r\n");
        this.pHc.append("totalMemory").append(" = ").append(this.pGV).append("\r\n");
        this.pHe.append("time").append(" = ").append(this.nou).append("\r\n");
        this.pHe.append("thread-time").append(" = ").append(this.pGW).append("\r\n");
        this.pHe.append("time-start").append(" = ").append(this.pGX).append("\r\n");
        this.pHe.append("time-end").append(" = ").append(this.pGY).append("\r\n");
        this.pHd.append("cpu-busy").append(" = ").append(this.pGZ).append("\r\n");
        this.pHd.append("cpu-rate").append(" = ").append(this.pHa).append("\r\n");
        if (this.pHb != null && !this.pHb.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pHb.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pHf.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pHc) + ((Object) this.pHe) + ((Object) this.pHd) + ((Object) this.pHf);
    }
}
