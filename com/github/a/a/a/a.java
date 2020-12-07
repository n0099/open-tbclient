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
/* loaded from: classes7.dex */
public class a {
    public static String psD;
    public static int psE;
    public String model;
    public String network;
    public long nnl;
    public String processName;
    public String psF;
    public String psI;
    public String psJ;
    public long psK;
    public String psL;
    public String psM;
    public boolean psN;
    public String psO;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pso = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String psC = com.github.a.a.c.exJ().provideQualifier();
    public String psG = "";
    public int psH = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> psP = new ArrayList<>();
    private StringBuilder psQ = new StringBuilder();
    private StringBuilder psR = new StringBuilder();
    private StringBuilder psS = new StringBuilder();
    public StringBuilder psT = new StringBuilder();

    static {
        psD = "";
        psE = -1;
        psE = b.getNumCores();
        psD = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a exR() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.exJ().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.psH = psE;
        aVar.model = sModel;
        aVar.psG = psD;
        aVar.psF = psC;
        aVar.uid = com.github.a.a.c.exJ().provideUid();
        aVar.processName = c.exT();
        aVar.network = com.github.a.a.c.exJ().provideNetworkType();
        aVar.psI = String.valueOf(b.getFreeMemory());
        aVar.psJ = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZA(String str) {
        this.psO = str;
        return this;
    }

    public a bu(ArrayList<String> arrayList) {
        this.psP = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nnl = j2 - j;
        this.psK = j4 - j3;
        this.psL = Long.toString(j);
        this.psM = Long.toString(j2);
        return this;
    }

    public a exS() {
        this.psQ.append("qua").append(" = ").append(this.psF).append("\r\n");
        this.psQ.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.psQ.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.psQ.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.psQ.append("network").append(" = ").append(this.network).append("\r\n");
        this.psQ.append("model").append(" = ").append(this.model).append("\r\n");
        this.psQ.append("api-level").append(" = ").append(this.psG).append("\r\n");
        this.psQ.append("cpu-core").append(" = ").append(this.psH).append("\r\n");
        this.psQ.append("process").append(" = ").append(this.processName).append("\r\n");
        this.psQ.append("freeMemory").append(" = ").append(this.psI).append("\r\n");
        this.psQ.append("totalMemory").append(" = ").append(this.psJ).append("\r\n");
        this.psS.append("time").append(" = ").append(this.nnl).append("\r\n");
        this.psS.append("thread-time").append(" = ").append(this.psK).append("\r\n");
        this.psS.append("time-start").append(" = ").append(this.psL).append("\r\n");
        this.psS.append("time-end").append(" = ").append(this.psM).append("\r\n");
        this.psR.append("cpu-busy").append(" = ").append(this.psN).append("\r\n");
        this.psR.append("cpu-rate").append(" = ").append(this.psO).append("\r\n");
        if (this.psP != null && !this.psP.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.psP.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.psT.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.psQ) + ((Object) this.psS) + ((Object) this.psR) + ((Object) this.psT);
    }
}
