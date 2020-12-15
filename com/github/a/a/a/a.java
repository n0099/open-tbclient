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
    public static String psF;
    public static int psG;
    public String model;
    public String network;
    public long nnn;
    public String processName;
    public String psH;
    public String psK;
    public String psL;
    public long psM;
    public String psN;
    public String psO;
    public boolean psP;
    public String psQ;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat psq = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String psE = com.github.a.a.c.exK().provideQualifier();
    public String psI = "";
    public int psJ = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> psR = new ArrayList<>();
    private StringBuilder psS = new StringBuilder();
    private StringBuilder psT = new StringBuilder();
    private StringBuilder psU = new StringBuilder();
    public StringBuilder psV = new StringBuilder();

    static {
        psF = "";
        psG = -1;
        psG = b.getNumCores();
        psF = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a exS() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.exK().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.psJ = psG;
        aVar.model = sModel;
        aVar.psI = psF;
        aVar.psH = psE;
        aVar.uid = com.github.a.a.c.exK().provideUid();
        aVar.processName = c.exU();
        aVar.network = com.github.a.a.c.exK().provideNetworkType();
        aVar.psK = String.valueOf(b.getFreeMemory());
        aVar.psL = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZA(String str) {
        this.psQ = str;
        return this;
    }

    public a bu(ArrayList<String> arrayList) {
        this.psR = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nnn = j2 - j;
        this.psM = j4 - j3;
        this.psN = Long.toString(j);
        this.psO = Long.toString(j2);
        return this;
    }

    public a exT() {
        this.psS.append("qua").append(" = ").append(this.psH).append("\r\n");
        this.psS.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.psS.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.psS.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.psS.append("network").append(" = ").append(this.network).append("\r\n");
        this.psS.append("model").append(" = ").append(this.model).append("\r\n");
        this.psS.append("api-level").append(" = ").append(this.psI).append("\r\n");
        this.psS.append("cpu-core").append(" = ").append(this.psJ).append("\r\n");
        this.psS.append("process").append(" = ").append(this.processName).append("\r\n");
        this.psS.append("freeMemory").append(" = ").append(this.psK).append("\r\n");
        this.psS.append("totalMemory").append(" = ").append(this.psL).append("\r\n");
        this.psU.append("time").append(" = ").append(this.nnn).append("\r\n");
        this.psU.append("thread-time").append(" = ").append(this.psM).append("\r\n");
        this.psU.append("time-start").append(" = ").append(this.psN).append("\r\n");
        this.psU.append("time-end").append(" = ").append(this.psO).append("\r\n");
        this.psT.append("cpu-busy").append(" = ").append(this.psP).append("\r\n");
        this.psT.append("cpu-rate").append(" = ").append(this.psQ).append("\r\n");
        if (this.psR != null && !this.psR.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.psR.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.psV.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.psS) + ((Object) this.psU) + ((Object) this.psT) + ((Object) this.psV);
    }
}
