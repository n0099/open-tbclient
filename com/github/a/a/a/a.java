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
    public static String pLp;
    public static int pLq;
    public String model;
    public String network;
    public long nsZ;
    public String pLA;
    public String pLr;
    public String pLu;
    public String pLv;
    public long pLw;
    public String pLx;
    public String pLy;
    public boolean pLz;
    public String processName;
    public String uid;
    public int versionCode;
    public static final SimpleDateFormat pLa = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sModel = Build.MODEL;
    public static String pLo = com.github.a.a.c.eBZ().provideQualifier();
    public String pLs = "";
    public int pLt = -1;
    public String versionName = "";
    public String duration = "-1";
    public ArrayList<String> pLB = new ArrayList<>();
    private StringBuilder pLC = new StringBuilder();
    private StringBuilder pLD = new StringBuilder();
    private StringBuilder pLE = new StringBuilder();
    public StringBuilder pLF = new StringBuilder();

    static {
        pLp = "";
        pLq = -1;
        pLq = b.getNumCores();
        pLp = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a eCh() {
        a aVar = new a();
        Context provideContext = com.github.a.a.c.eBZ().provideContext();
        if (aVar.versionName == null || aVar.versionName.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.versionCode = packageInfo.versionCode;
                aVar.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.pLt = pLq;
        aVar.model = sModel;
        aVar.pLs = pLp;
        aVar.pLr = pLo;
        aVar.uid = com.github.a.a.c.eBZ().provideUid();
        aVar.processName = c.eCj();
        aVar.network = com.github.a.a.c.eBZ().provideNetworkType();
        aVar.pLu = String.valueOf(b.getFreeMemory());
        aVar.pLv = String.valueOf(b.getTotalMemory());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.duration = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a ZL(String str) {
        this.pLA = str;
        return this;
    }

    public a bu(ArrayList<String> arrayList) {
        this.pLB = arrayList;
        return this;
    }

    public a e(long j, long j2, long j3, long j4) {
        this.nsZ = j2 - j;
        this.pLw = j4 - j3;
        this.pLx = Long.toString(j);
        this.pLy = Long.toString(j2);
        return this;
    }

    public a eCi() {
        this.pLC.append("qua").append(" = ").append(this.pLr).append("\r\n");
        this.pLC.append("versionName").append(" = ").append(this.versionName).append("\r\n");
        this.pLC.append("versionCode").append(" = ").append(this.versionCode).append("\r\n");
        this.pLC.append("uid").append(" = ").append(this.uid).append("\r\n");
        this.pLC.append("network").append(" = ").append(this.network).append("\r\n");
        this.pLC.append("model").append(" = ").append(this.model).append("\r\n");
        this.pLC.append("api-level").append(" = ").append(this.pLs).append("\r\n");
        this.pLC.append("cpu-core").append(" = ").append(this.pLt).append("\r\n");
        this.pLC.append("process").append(" = ").append(this.processName).append("\r\n");
        this.pLC.append("freeMemory").append(" = ").append(this.pLu).append("\r\n");
        this.pLC.append("totalMemory").append(" = ").append(this.pLv).append("\r\n");
        this.pLE.append("time").append(" = ").append(this.nsZ).append("\r\n");
        this.pLE.append("thread-time").append(" = ").append(this.pLw).append("\r\n");
        this.pLE.append("time-start").append(" = ").append(this.pLx).append("\r\n");
        this.pLE.append("time-end").append(" = ").append(this.pLy).append("\r\n");
        this.pLD.append("cpu-busy").append(" = ").append(this.pLz).append("\r\n");
        this.pLD.append("cpu-rate").append(" = ").append(this.pLA).append("\r\n");
        if (this.pLB != null && !this.pLB.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.pLB.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            this.pLF.append("stack").append(" = ").append(sb.toString()).append("\r\n");
        }
        return this;
    }

    public String toString() {
        return String.valueOf(this.pLC) + ((Object) this.pLE) + ((Object) this.pLD) + ((Object) this.pLF);
    }
}
