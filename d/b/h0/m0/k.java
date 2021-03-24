package d.b.h0.m0;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class k {

    /* renamed from: e  reason: collision with root package name */
    public static String f50341e = "tb_perfor_samllflow_time";

    /* renamed from: f  reason: collision with root package name */
    public static volatile k f50342f;

    /* renamed from: d  reason: collision with root package name */
    public long f50346d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50343a = false;

    /* renamed from: c  reason: collision with root package name */
    public long f50345c = 86400;

    /* renamed from: b  reason: collision with root package name */
    public long f50344b = d.b.h0.r.d0.b.i().k(f50341e, 0);

    public k() {
        this.f50346d = 0L;
        BdBaseApplication.getInst().setStartSmallFlowTime(this.f50344b);
        this.f50346d = this.f50345c;
        BdBaseApplication.getInst().setSmallFlowInterval(this.f50346d);
    }

    public static k d() {
        if (f50342f == null) {
            synchronized (k.class) {
                if (f50342f == null) {
                    f50342f = new k();
                }
            }
        }
        return f50342f;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0098 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x0021 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0068 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x0021 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x0021 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
        r3 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1 A[Catch: Exception -> 0x00b4, TRY_LEAVE, TryCatch #9 {Exception -> 0x00b4, blocks: (B:57:0x00ac, B:59:0x00b1), top: B:71:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                            int i = 0;
                            while (true) {
                                if (i < length) {
                                    String str3 = split[i];
                                    if (str3 != null && str3.contains("%")) {
                                        process = str3.trim();
                                        break;
                                    }
                                    i++;
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
                                    return d.b.b.e.m.b.d(str2, -1);
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            str2 = str;
                            if (str2 != null) {
                            }
                            return d.b.b.e.m.b.d(str2, -1);
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
        return d.b.b.e.m.b.d(str2, -1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
        r1 = r4.replaceAll("\\s+", "_");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
        if (r3 != null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067 A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #2 {Exception -> 0x006a, blocks: (B:34:0x0062, B:36:0x0067), top: B:44:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b() {
        BufferedReader bufferedReader;
        Process process;
        int myPid = Process.myPid();
        String str = null;
        str = null;
        str = null;
        str = null;
        Process process2 = null;
        try {
            try {
                process = Runtime.getRuntime().exec("top -n 1");
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            e = e2;
            process = null;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            if (process2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
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
                } catch (Throwable th2) {
                    th = th2;
                    process2 = process;
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
            }
            if (process != null) {
                process.destroy();
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
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
        bufferedReader.close();
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

    public j e(int i) {
        if (g()) {
            switch (i) {
                case 1000:
                    m mVar = new m();
                    mVar.f50340a = "frs";
                    return mVar;
                case 1001:
                    m mVar2 = new m();
                    mVar2.f50340a = "pb";
                    return mVar2;
                case 1002:
                    i iVar = new i();
                    iVar.f50340a = "im";
                    return iVar;
                case 1003:
                case 1006:
                case 1007:
                default:
                    return null;
                case 1004:
                    m mVar3 = new m();
                    mVar3.f50340a = "photo_live";
                    return mVar3;
                case 1005:
                    e eVar = new e();
                    eVar.f50340a = "home_page";
                    return eVar;
                case 1008:
                    m mVar4 = new m();
                    mVar4.f50340a = "user_center";
                    return mVar4;
                case 1009:
                    m mVar5 = new m();
                    mVar5.f50340a = "sign_all";
                    return mVar5;
                case 1010:
                    m mVar6 = new m();
                    mVar6.f50340a = "person_center";
                    return mVar6;
                case 1011:
                    m mVar7 = new m();
                    mVar7.f50340a = "person_center_home";
                    return mVar7;
                case 1012:
                    m mVar8 = new m();
                    mVar8.f50340a = "person_center_post";
                    return mVar8;
                case 1013:
                    m mVar9 = new m();
                    mVar9.f50340a = "person_center_dynamic";
                    return mVar9;
            }
        }
        return null;
    }

    public String f() {
        return !d.b.b.e.p.j.z() ? "N" : d.b.b.e.p.j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : d.b.b.e.p.j.v() ? "4G" : d.b.b.e.p.j.u() ? com.baidu.apollon.statistics.g.f3873b : d.b.b.e.p.j.t() ? "2G" : "N";
    }

    public boolean g() {
        if (!this.f50343a || (System.currentTimeMillis() - this.f50344b) / 1000 <= this.f50346d) {
            return this.f50343a;
        }
        return false;
    }

    public void h(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            long j = this.f50344b;
            if (0 == j || currentTimeMillis - j >= this.f50346d) {
                this.f50344b = currentTimeMillis;
                BdBaseApplication.getInst().setStartSmallFlowTime(this.f50344b);
                d.b.h0.r.d0.b.i().v(f50341e, this.f50344b);
            }
        } else {
            this.f50344b = 0L;
            BdBaseApplication.getInst().setStartSmallFlowTime(0L);
            d.b.h0.r.d0.b.i().v(f50341e, this.f50344b);
        }
        this.f50343a = z;
        BdBaseApplication.getInst().setIsSmallFlow(z);
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            l.b().f();
        }
    }

    public void i(long j) {
        if (j > 0) {
            this.f50346d = j;
            BdBaseApplication.getInst().setSmallFlowInterval(j);
        }
    }
}
