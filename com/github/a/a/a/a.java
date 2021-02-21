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
    public static String pRu;
    public static int pRv;
    public String model;
    public String network;
    public long nyE;
    public String pRA;
    public long pRB;
    public String pRC;
    public String pRD;
    public boolean pRE;
    public String pRF;
    public String pRw;
    public String pRz;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pRf = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pRt = com.github.a.a.c.eAH().provideQualifier();
    public String pRx = "";
    public int pRy = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pRG = new ArrayList<>();
    private StringBuilder pRH = new StringBuilder();
    private StringBuilder pRI = new StringBuilder();
    private StringBuilder pRJ = new StringBuilder();
    public StringBuilder pRK = new StringBuilder();

    static {
        pRu = "";
        pRv = -1;
        pRv = b.getNumCores();
        pRu = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a eAP() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.eAH().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.pRy = pRv;
        aVar.model = sModel;
        aVar.pRx = pRu;
        aVar.pRw = pRt;
        aVar.uid = com.github.a.a.c.eAH().provideUid();
        aVar.processName = c.eAR();
        aVar.network = com.github.a.a.c.eAH().provideNetworkType();
        aVar.pRz = String.valueOf(b.getFreeMemory());
        aVar.pRA = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZR(String str) {
        this.pRF = str;
        return this;
    }

    public a bo(ArrayList<String> arrayList) {
        this.pRG = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nyE = j2 - j;
        this.pRB = j4 - j3;
        this.pRC = Long.toString(j);
        this.pRD = Long.toString(j2);
        return this;
    }

    public a eAQ() {
        this.pRH.append("qua").append(" = ").append(this.pRw).append("\r\n");
        this.pRH.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pRH.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pRH.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pRH.append("network").append(" = ").append(this.network).append("\r\n");
        this.pRH.append("model").append(" = ").append(this.model).append("\r\n");
        this.pRH.append("api-level").append(" = ").append(this.pRx).append("\r\n");
        this.pRH.append("cpu-core").append(" = ").append(this.pRy).append("\r\n");
        this.pRH.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pRH.append("freeMemory").append(" = ").append(this.pRz).append("\r\n");
        this.pRH.append("totalMemory").append(" = ").append(this.pRA).append("\r\n");
        this.pRJ.append("time").append(" = ").append(this.nyE).append("\r\n");
        this.pRJ.append("thread-time").append(" = ").append(this.pRB).append("\r\n");
        this.pRJ.append("time-start").append(" = ").append(this.pRC).append("\r\n");
        this.pRJ.append("time-end").append(" = ").append(this.pRD).append("\r\n");
        this.pRI.append("cpu-busy").append(" = ").append(this.pRE).append("\r\n");
        this.pRI.append("cpu-rate").append(" = ").append(this.pRF).append("\r\n");
        if (this.pRG != null && !this.pRG.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pRG.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pRK.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pRH) + ((Object) this.pRJ) + ((Object) this.pRI) + ((Object) this.pRK);
    }
}
