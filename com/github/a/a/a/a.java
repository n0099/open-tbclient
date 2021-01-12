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
    public static String pGO;
    public static int pGP;
    public String model;
    public String network;
    public long nos;
    public String pGQ;
    public String pGT;
    public String pGU;
    public long pGV;
    public String pGW;
    public String pGX;
    public boolean pGY;
    public String pGZ;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pGz = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pGN = com.github.a.a.c.eyh().provideQualifier();
    public String pGR = "";
    public int pGS = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pHa = new ArrayList<>();
    private StringBuilder pHb = new StringBuilder();
    private StringBuilder pHc = new StringBuilder();
    private StringBuilder pHd = new StringBuilder();
    public StringBuilder pHe = new StringBuilder();

    static {
        pGO = "";
        pGP = -1;
        pGP = b.getNumCores();
        pGO = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
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
        aVar.pGS = pGP;
        aVar.model = sModel;
        aVar.pGR = pGO;
        aVar.pGQ = pGN;
        aVar.uid = com.github.a.a.c.eyh().provideUid();
        aVar.processName = c.eyr();
        aVar.network = com.github.a.a.c.eyh().provideNetworkType();
        aVar.pGT = String.valueOf(b.getFreeMemory());
        aVar.pGU = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a YD(String str) {
        this.pGZ = str;
        return this;
    }

    public a bp(ArrayList<String> arrayList) {
        this.pHa = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nos = j2 - j;
        this.pGV = j4 - j3;
        this.pGW = Long.toString(j);
        this.pGX = Long.toString(j2);
        return this;
    }

    public a eyq() {
        this.pHb.append("qua").append(" = ").append(this.pGQ).append("\r\n");
        this.pHb.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pHb.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pHb.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pHb.append("network").append(" = ").append(this.network).append("\r\n");
        this.pHb.append("model").append(" = ").append(this.model).append("\r\n");
        this.pHb.append("api-level").append(" = ").append(this.pGR).append("\r\n");
        this.pHb.append("cpu-core").append(" = ").append(this.pGS).append("\r\n");
        this.pHb.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pHb.append("freeMemory").append(" = ").append(this.pGT).append("\r\n");
        this.pHb.append("totalMemory").append(" = ").append(this.pGU).append("\r\n");
        this.pHd.append("time").append(" = ").append(this.nos).append("\r\n");
        this.pHd.append("thread-time").append(" = ").append(this.pGV).append("\r\n");
        this.pHd.append("time-start").append(" = ").append(this.pGW).append("\r\n");
        this.pHd.append("time-end").append(" = ").append(this.pGX).append("\r\n");
        this.pHc.append("cpu-busy").append(" = ").append(this.pGY).append("\r\n");
        this.pHc.append("cpu-rate").append(" = ").append(this.pGZ).append("\r\n");
        if (this.pHa != null && !this.pHa.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pHa.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pHe.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pHb) + ((Object) this.pHd) + ((Object) this.pHc) + ((Object) this.pHe);
    }
}
