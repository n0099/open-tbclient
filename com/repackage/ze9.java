package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.impl.mmap.YaNativeLogger;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.webrtc.RtcCertificatePem;
/* loaded from: classes7.dex */
public class ze9 extends Logger {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile int c;
    public static String[] d;
    public static Object e;
    public static ExecutorService f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;
        public final /* synthetic */ ze9 g;

        public a(ze9 ze9Var, String str, int i, String str2, String str3, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ze9Var;
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = i2;
            this.f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.u(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;
        public final /* synthetic */ ze9 g;

        public b(ze9 ze9Var, String str, int i, String str2, String str3, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ze9Var;
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = i2;
            this.f = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.g.u(this.a, this.b, this.c, this.d, this.e, this.f);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze9 a;

        public c(ze9 ze9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ze9 ze9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ze9.z();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (ze9.e) {
                    String s = ze9.s();
                    boolean x = ze9.x(s);
                    ue9 c = ue9.c();
                    if (!c.m()) {
                        if (x && c.l()) {
                            ze9.p();
                        }
                        int unused = ze9.c = 2;
                        return;
                    }
                    YaNativeLogger.a();
                    YaNativeLogger.setBaseDir(ze9.n());
                    YaNativeLogger.setProcessName(ze9.r(s));
                    if (x) {
                        YaNativeLogger.setMainController(true);
                    } else {
                        YaNativeLogger.setMainController(false);
                    }
                    long h = c.h() * 1024 * 1024;
                    long min = h <= 0 ? 104857600L : Math.min(h, 1073741824L);
                    YaNativeLogger.setMaxSizeAllLogFile(min);
                    long d = c.d() * 1024 * 1024;
                    YaNativeLogger.setMaxSizePerLogFile(d <= 0 ? 1048576L : Math.min(d, min));
                    YaNativeLogger.setDefaultSpaceEnable(true);
                    YaNativeLogger.setDefaultLogIdEnable(true);
                    long f = c.f() * 1024 * 1024;
                    if (f <= 0) {
                        f = DownloadManager.MIN_LEFT_SIZE;
                    }
                    YaNativeLogger.setDefaultSpaceMaxSize(f);
                    List<xe9> e = c.e();
                    if (e != null && e.size() > 0) {
                        for (xe9 xe9Var : e) {
                            if (xe9Var != null && !TextUtils.isEmpty(xe9Var.b())) {
                                String b = xe9Var.b();
                                YaNativeLogger.setSpaceEnable(b, xe9Var.c());
                                long a = xe9Var.a() * 1024 * 1024;
                                if (a <= 0) {
                                    a = DownloadManager.MIN_LEFT_SIZE;
                                }
                                YaNativeLogger.setSpaceMaxSize(b, a);
                                long d2 = xe9Var.d() * 60 * 60 * 24;
                                if (d2 <= 0) {
                                    d2 = IMConstants.FANS_GROUP_INFO_EXPIRED_TIME;
                                }
                                YaNativeLogger.setMaxAliveTimeForSpace(b, d2);
                            }
                        }
                    }
                    long b2 = c.b() * 1024 * 1024;
                    if (b2 <= 0) {
                        b2 = DownloadManager.MIN_LEFT_SIZE;
                    }
                    YaNativeLogger.setDefaultLogIdMaxSize(b2);
                    Map<String, we9> a2 = c.a();
                    if (a2 != null && a2.size() > 0) {
                        for (String str : a2.keySet()) {
                            if (!TextUtils.isEmpty(str) && a2.get(str) != null) {
                                we9 we9Var = a2.get(str);
                                YaNativeLogger.setLogIdEnable(str, we9Var.b());
                                long a3 = we9Var.a() * 1024 * 1024;
                                if (a3 <= 0) {
                                    a3 = DownloadManager.MIN_LEFT_SIZE;
                                }
                                YaNativeLogger.setLogIdMaxSize(str, a3);
                            }
                        }
                    }
                    long g = c.g() * 24 * 60 * 60;
                    YaNativeLogger.setDefaultMaxAliveTimeForSpace(g <= 0 ? IMConstants.FANS_GROUP_INFO_EXPIRED_TIME : Math.min(g, (long) RtcCertificatePem.DEFAULT_EXPIRY));
                    YaNativeLogger.start();
                    int unused2 = ze9.c = 1;
                    ze9.e.notifyAll();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755114749, "Lcom/repackage/ze9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755114749, "Lcom/repackage/ze9;");
                return;
            }
        }
        b = AppConfig.isDebug();
        c = 0;
        d = new String[]{"L0", "L1", "V", "D", "I", "W", "E", "A"};
        e = new Object();
        f = Executors.newSingleThreadExecutor();
    }

    public ze9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        A();
        B();
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && c == 0) {
            new Thread(new e()).start();
        }
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == 0) {
                synchronized (e) {
                    while (c == 0) {
                        try {
                            e.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            return c == 1;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.ze9.e.run():void] */
    public static /* synthetic */ boolean m() {
        return b;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, ".yalog").getAbsolutePath() : (String) invokeV.objValue;
    }

    public static List<String> o(long j, long j2, String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) {
            ArrayList arrayList = new ArrayList();
            if (C()) {
                try {
                    YaNativeLogger.createLogSnapShot(j, j2, str, str2, z, z2, str3, arrayList);
                } catch (Throwable th) {
                    if (b) {
                        th.printStackTrace();
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            q(new File(n()));
        }
    }

    public static void q(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, file) == null) && file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        q(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static String r(String str) {
        InterceptResult invokeL;
        String replaceAll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "unknown";
            }
            if (x(str)) {
                return "main";
            }
            Context appContext = AppRuntime.getAppContext();
            String str2 = appContext.getApplicationInfo().packageName;
            if (TextUtils.isEmpty(str2)) {
                str2 = appContext.getPackageName();
            }
            String str3 = str2 + ":";
            if (str.startsWith(str3)) {
                String substring = str.substring(str3.length());
                if (TextUtils.equals("main", substring)) {
                    return "_main";
                }
                replaceAll = !TextUtils.isEmpty(substring) ? substring.replaceAll("[:/]", "_") : "";
            } else {
                replaceAll = str.replaceAll("[:/]", "_");
            }
            return !TextUtils.isEmpty(replaceAll) ? replaceAll : "unknown";
        }
        return (String) invokeL.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) appContext.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == Process.myPid()) {
                    str = next.processName;
                    break;
                }
            }
            return !TextUtils.isEmpty(str) ? str : appContext.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (str == null) {
                return true;
            }
            Context appContext = AppRuntime.getAppContext();
            String str2 = appContext.getApplicationInfo().processName;
            if (TextUtils.isEmpty(str2)) {
                str2 = appContext.getPackageName();
            }
            if (str.startsWith(str2)) {
                return str.length() == str2.length() || str.charAt(str2.length()) != ':';
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static List<String> y(long j, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2})) == null) {
            ArrayList arrayList = new ArrayList();
            if (C()) {
                try {
                    YaNativeLogger.queryLogFiles(j, j2, str, str2, arrayList);
                } catch (Throwable th) {
                    if (b) {
                        th.printStackTrace();
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, null) == null) && C()) {
            try {
                YaNativeLogger.requestCleanOverQuotaLog();
            } catch (Throwable th) {
                if (b) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new d(this), 30000L);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void executeRunnable(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            f.execute(runnable);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void flush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                t(true);
            } else {
                f.execute(new c(this));
            }
        }
    }

    @Override // com.baidu.yalog.Logger
    public void log(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, str, i, str2, str3) == null) {
            f.execute(new a(this, str, i, str2, str3, Process.myTid(), System.currentTimeMillis()));
        }
    }

    @Override // com.baidu.yalog.Logger
    public void logSync(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, str, i, str2, str3) == null) {
            try {
                f.submit(new b(this, str, i, str2, str3, Process.myTid(), System.currentTimeMillis())).get();
            } catch (Exception e2) {
                if (b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && C()) {
            try {
                YaNativeLogger.flush(this.a, z);
            } catch (Throwable th) {
                if (b) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void u(String str, int i, String str2, String str3, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)}) == null) && C()) {
            int myPid = Process.myPid();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("pid").value(myPid);
                jsonWriter.name("tid").value(i2);
                jsonWriter.name("time").value(simpleDateFormat.format(Long.valueOf(j)));
                if (!TextUtils.isEmpty(str)) {
                    jsonWriter.name("logid").value(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jsonWriter.name("tag").value(str2);
                }
                if (i >= 0 && i < d.length) {
                    jsonWriter.name("level").value(d[i]);
                } else {
                    JsonWriter name = jsonWriter.name("level");
                    name.value("L" + i);
                }
                jsonWriter.endObject();
            } catch (IOException unused) {
            }
            YaNativeLogger.b(this.a, "main", str, stringWriter.toString(), str3);
        }
    }
}
