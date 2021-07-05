package d.a.r0.m0;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f55478e = "tb_perfor_samllflow_time";

    /* renamed from: f  reason: collision with root package name */
    public static volatile k f55479f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55480a;

    /* renamed from: b  reason: collision with root package name */
    public long f55481b;

    /* renamed from: c  reason: collision with root package name */
    public long f55482c;

    /* renamed from: d  reason: collision with root package name */
    public long f55483d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1919354064, "Ld/a/r0/m0/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1919354064, "Ld/a/r0/m0/k;");
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55480a = false;
        this.f55482c = 86400L;
        this.f55483d = 0L;
        this.f55481b = d.a.r0.r.d0.b.j().l(f55478e, 0L);
        BdBaseApplication.getInst().setStartSmallFlowTime(this.f55481b);
        this.f55483d = this.f55482c;
        BdBaseApplication.getInst().setSmallFlowInterval(this.f55483d);
    }

    public static k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f55479f == null) {
                synchronized (k.class) {
                    if (f55479f == null) {
                        f55479f = new k();
                    }
                }
            }
            return f55479f;
        }
        return (k) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x009b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x006b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x0024 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        r3 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #5 {Exception -> 0x00b7, blocks: (B:59:0x00af, B:61:0x00b4), top: B:71:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        r1 = r4.replaceAll("\\s+", "_");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
        if (r3 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[Catch: Exception -> 0x006d, TRY_LEAVE, TryCatch #2 {Exception -> 0x006d, blocks: (B:36:0x0065, B:38:0x006a), top: B:49:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Process process;
        BufferedReader bufferedReader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (process != null) {
                                    process.destroy();
                                }
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedReader2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        process2 = process;
                        if (process2 != null) {
                            try {
                                process2.destroy();
                            } catch (Exception unused) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception e4) {
                e = e4;
                process = null;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (process2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            bufferedReader2.close();
            return str;
        }
        return (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
            } catch (Exception e2) {
                BdLog.e(e2);
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public j e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (g()) {
                switch (i2) {
                    case 1000:
                        m mVar = new m();
                        mVar.f55477a = "frs";
                        return mVar;
                    case 1001:
                        m mVar2 = new m();
                        mVar2.f55477a = "pb";
                        return mVar2;
                    case 1002:
                        i iVar = new i();
                        iVar.f55477a = "im";
                        return iVar;
                    case 1003:
                    case 1006:
                    case 1007:
                    default:
                        return null;
                    case 1004:
                        m mVar3 = new m();
                        mVar3.f55477a = "photo_live";
                        return mVar3;
                    case 1005:
                        e eVar = new e();
                        eVar.f55477a = "home_page";
                        return eVar;
                    case 1008:
                        m mVar4 = new m();
                        mVar4.f55477a = "user_center";
                        return mVar4;
                    case 1009:
                        m mVar5 = new m();
                        mVar5.f55477a = "sign_all";
                        return mVar5;
                    case 1010:
                        m mVar6 = new m();
                        mVar6.f55477a = "person_center";
                        return mVar6;
                    case 1011:
                        m mVar7 = new m();
                        mVar7.f55477a = "person_center_home";
                        return mVar7;
                    case 1012:
                        m mVar8 = new m();
                        mVar8.f55477a = "person_center_post";
                        return mVar8;
                    case 1013:
                        m mVar9 = new m();
                        mVar9.f55477a = "person_center_dynamic";
                        return mVar9;
                }
            }
            return null;
        }
        return (j) invokeI.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !d.a.c.e.p.j.z() ? "N" : d.a.c.e.p.j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : d.a.c.e.p.j.v() ? "4G" : d.a.c.e.p.j.u() ? com.baidu.apollon.statistics.g.f3983b : d.a.c.e.p.j.t() ? "2G" : "N" : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.f55480a || (System.currentTimeMillis() - this.f55481b) / 1000 <= this.f55483d) {
                return this.f55480a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                long j = this.f55481b;
                if (0 == j || currentTimeMillis - j >= this.f55483d) {
                    this.f55481b = currentTimeMillis;
                    BdBaseApplication.getInst().setStartSmallFlowTime(this.f55481b);
                    d.a.r0.r.d0.b.j().w(f55478e, this.f55481b);
                }
            } else {
                this.f55481b = 0L;
                BdBaseApplication.getInst().setStartSmallFlowTime(0L);
                d.a.r0.r.d0.b.j().w(f55478e, this.f55481b);
            }
            this.f55480a = z;
            BdBaseApplication.getInst().setIsSmallFlow(z);
            if (BdStatisticsManager.getInstance().isMainProcess()) {
                l.b().f();
            }
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || j <= 0) {
            return;
        }
        this.f55483d = j;
        BdBaseApplication.getInst().setSmallFlowInterval(j);
    }
}
