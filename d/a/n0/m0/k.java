package d.a.n0.m0;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: e  reason: collision with root package name */
    public static String f53342e = "tb_perfor_samllflow_time";

    /* renamed from: f  reason: collision with root package name */
    public static volatile k f53343f;

    /* renamed from: d  reason: collision with root package name */
    public long f53347d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53344a = false;

    /* renamed from: c  reason: collision with root package name */
    public long f53346c = 86400;

    /* renamed from: b  reason: collision with root package name */
    public long f53345b = d.a.n0.r.d0.b.j().l(f53342e, 0);

    public k() {
        this.f53347d = 0L;
        BdBaseApplication.getInst().setStartSmallFlowTime(this.f53345b);
        this.f53347d = this.f53346c;
        BdBaseApplication.getInst().setSmallFlowInterval(this.f53347d);
    }

    public static k d() {
        if (f53343f == null) {
            synchronized (k.class) {
                if (f53343f == null) {
                    f53343f = new k();
                }
            }
        }
        return f53343f;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0020 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0020 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0020 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        r3 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b0 A[Catch: Exception -> 0x00b3, TRY_LEAVE, TryCatch #9 {Exception -> 0x00b3, blocks: (B:57:0x00ab, B:59:0x00b0), top: B:69:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a() {
        BufferedReader bufferedReader;
        String str;
        String str2;
        int myPid = Process.myPid();
        Process process = 0;
        try {
            Process exec = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.trim().startsWith(String.valueOf(myPid))) {
                            String[] split = readLine.split("\\s+");
                            if (split.length > 2 && split[2] != null && split[2].contains("%")) {
                                break;
                            }
                            int length = split.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    String str3 = split[i2];
                                    if (str3 != null && str3.contains("%")) {
                                        process = str3.trim();
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = process;
                        process = exec;
                        try {
                            e.printStackTrace();
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception unused) {
                                    str2 = str;
                                    if (str2 != null) {
                                    }
                                    return d.a.c.e.m.b.d(str2, -1);
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            str2 = str;
                            if (str2 != null) {
                            }
                            return d.a.c.e.m.b.d(str2, -1);
                        } catch (Throwable th) {
                            th = th;
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception unused2) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        process = exec;
                        if (process != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                if (exec != null) {
                    try {
                        exec.destroy();
                    } catch (Exception unused3) {
                        str2 = process;
                    }
                }
                bufferedReader.close();
                str2 = process;
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                process = exec;
                str = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            e = e4;
            str = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        if (str2 != null) {
            String[] split2 = str2.split("%");
            if (split2.length > 0) {
                str2 = split2[0];
            }
        }
        return d.a.c.e.m.b.d(str2, -1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = r4.replaceAll("\\s+", "_");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
        if (r3 != null) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #3 {Exception -> 0x0069, blocks: (B:34:0x0061, B:36:0x0066), top: B:42:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b() {
        BufferedReader bufferedReader;
        Process process;
        BufferedReader bufferedReader2;
        int myPid = Process.myPid();
        String str = null;
        str = null;
        str = null;
        str = null;
        Process process2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                process = Runtime.getRuntime().exec("top -n 1");
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            e = e2;
            process = null;
            bufferedReader2 = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (process2 != null) {
                try {
                    process2.destroy();
                } catch (Exception unused2) {
                    throw th;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (readLine.trim().contains(String.valueOf(myPid))) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
            if (process != null) {
                process.destroy();
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            process2 = process;
            if (process2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        bufferedReader2.close();
        return str;
    }

    public long c() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        } catch (Exception e2) {
            BdLog.e(e2);
            return -1L;
        }
    }

    public j e(int i2) {
        if (g()) {
            switch (i2) {
                case 1000:
                    m mVar = new m();
                    mVar.f53341a = "frs";
                    return mVar;
                case 1001:
                    m mVar2 = new m();
                    mVar2.f53341a = "pb";
                    return mVar2;
                case 1002:
                    i iVar = new i();
                    iVar.f53341a = "im";
                    return iVar;
                case 1003:
                case 1006:
                case 1007:
                default:
                    return null;
                case 1004:
                    m mVar3 = new m();
                    mVar3.f53341a = "photo_live";
                    return mVar3;
                case 1005:
                    e eVar = new e();
                    eVar.f53341a = "home_page";
                    return eVar;
                case 1008:
                    m mVar4 = new m();
                    mVar4.f53341a = "user_center";
                    return mVar4;
                case 1009:
                    m mVar5 = new m();
                    mVar5.f53341a = "sign_all";
                    return mVar5;
                case 1010:
                    m mVar6 = new m();
                    mVar6.f53341a = "person_center";
                    return mVar6;
                case 1011:
                    m mVar7 = new m();
                    mVar7.f53341a = "person_center_home";
                    return mVar7;
                case 1012:
                    m mVar8 = new m();
                    mVar8.f53341a = "person_center_post";
                    return mVar8;
                case 1013:
                    m mVar9 = new m();
                    mVar9.f53341a = "person_center_dynamic";
                    return mVar9;
            }
        }
        return null;
    }

    public String f() {
        return !d.a.c.e.p.j.z() ? "N" : d.a.c.e.p.j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : d.a.c.e.p.j.v() ? "4G" : d.a.c.e.p.j.u() ? com.baidu.apollon.statistics.g.f3985b : d.a.c.e.p.j.t() ? "2G" : "N";
    }

    public boolean g() {
        if (!this.f53344a || (System.currentTimeMillis() - this.f53345b) / 1000 <= this.f53347d) {
            return this.f53344a;
        }
        return false;
    }

    public void h(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            long j = this.f53345b;
            if (0 == j || currentTimeMillis - j >= this.f53347d) {
                this.f53345b = currentTimeMillis;
                BdBaseApplication.getInst().setStartSmallFlowTime(this.f53345b);
                d.a.n0.r.d0.b.j().w(f53342e, this.f53345b);
            }
        } else {
            this.f53345b = 0L;
            BdBaseApplication.getInst().setStartSmallFlowTime(0L);
            d.a.n0.r.d0.b.j().w(f53342e, this.f53345b);
        }
        this.f53344a = z;
        BdBaseApplication.getInst().setIsSmallFlow(z);
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            l.b().f();
        }
    }

    public void i(long j) {
        if (j > 0) {
            this.f53347d = j;
            BdBaseApplication.getInst().setSmallFlowInterval(j);
        }
    }
}
