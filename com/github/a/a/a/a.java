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
/* loaded from: classes15.dex */
public class a {
    public static String pJH;
    public static int pJI;
    public String model;
    public String network;
    public long nta;
    public String pJJ;
    public String pJM;
    public String pJN;
    public long pJO;
    public String pJP;
    public String pJQ;
    public boolean pJR;
    public String pJS;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pJs = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pJG = com.github.a.a.c.eBv().provideQualifier();
    public String pJK = "";
    public int pJL = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pJT = new ArrayList<>();
    private StringBuilder pJU = new StringBuilder();
    private StringBuilder pJV = new StringBuilder();
    private StringBuilder pJW = new StringBuilder();
    public StringBuilder pJX = new StringBuilder();

    static {
        pJH = "";
        pJI = -1;
        pJI = b.getNumCores();
        pJH = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a eBD() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.eBv().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.pJL = pJI;
        aVar.model = sModel;
        aVar.pJK = pJH;
        aVar.pJJ = pJG;
        aVar.uid = com.github.a.a.c.eBv().provideUid();
        aVar.processName = c.eBF();
        aVar.network = com.github.a.a.c.eBv().provideNetworkType();
        aVar.pJM = String.valueOf(b.getFreeMemory());
        aVar.pJN = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZK(String str) {
        this.pJS = str;
        return this;
    }

    public a bu(ArrayList<String> arrayList) {
        this.pJT = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nta = j2 - j;
        this.pJO = j4 - j3;
        this.pJP = Long.toString(j);
        this.pJQ = Long.toString(j2);
        return this;
    }

    public a eBE() {
        this.pJU.append("qua").append(" = ").append(this.pJJ).append("\r\n");
        this.pJU.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pJU.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pJU.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pJU.append("network").append(" = ").append(this.network).append("\r\n");
        this.pJU.append("model").append(" = ").append(this.model).append("\r\n");
        this.pJU.append("api-level").append(" = ").append(this.pJK).append("\r\n");
        this.pJU.append("cpu-core").append(" = ").append(this.pJL).append("\r\n");
        this.pJU.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pJU.append("freeMemory").append(" = ").append(this.pJM).append("\r\n");
        this.pJU.append("totalMemory").append(" = ").append(this.pJN).append("\r\n");
        this.pJW.append("time").append(" = ").append(this.nta).append("\r\n");
        this.pJW.append("thread-time").append(" = ").append(this.pJO).append("\r\n");
        this.pJW.append("time-start").append(" = ").append(this.pJP).append("\r\n");
        this.pJW.append("time-end").append(" = ").append(this.pJQ).append("\r\n");
        this.pJV.append("cpu-busy").append(" = ").append(this.pJR).append("\r\n");
        this.pJV.append("cpu-rate").append(" = ").append(this.pJS).append("\r\n");
        if (this.pJT != null && !this.pJT.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pJT.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pJX.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pJU) + ((Object) this.pJW) + ((Object) this.pJV) + ((Object) this.pJX);
    }
}
