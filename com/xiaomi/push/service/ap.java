package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.dw;
import com.xiaomi.push.fh;
import com.yy.hiidostatis.inner.FlushManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class ap {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f928a;

    /* renamed from: a  reason: collision with other field name */
    public static final Pattern f929a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162519, "Lcom/xiaomi/push/service/ap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162519, "Lcom/xiaomi/push/service/ap;");
                return;
            }
        }
        f929a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        a = 0L;
        f928a = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static String a(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String sb2 = sb.toString();
                        com.xiaomi.push.ab.a(bufferedReader);
                        return sb2;
                    }
                    sb.append("\n");
                    sb.append(readLine);
                }
            } catch (Exception unused) {
                com.xiaomi.push.ab.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.ab.a(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static void a() {
        dw.a m662a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((f928a.getActiveCount() <= 0 || currentTimeMillis - a >= FlushManager.ReportTimer.DEFAULT_INTERVAL) && fh.m338a().m343a() && (m662a = bv.a().m662a()) != null && m662a.e() > 0) {
                a = currentTimeMillis;
                a(m662a.a(), true);
            }
        }
    }

    public static void a(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, list, z) == null) {
            f928a.execute(new aq(list, z));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            String a2 = a("/proc/self/net/tcp");
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m99a("dump tcp for uid = " + Process.myUid());
                com.xiaomi.channel.commonutils.logger.b.m99a(a2);
            }
            String a3 = a("/proc/self/net/tcp6");
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("dump tcp6 for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m99a(a3);
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.xiaomi.channel.commonutils.logger.b.m99a("ConnectivityTest: begin to connect to " + str);
                Socket socket = new Socket();
                socket.connect(com.xiaomi.push.ct.m259a(str, 5222), 5000);
                socket.setTcpNoDelay(true);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m99a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
                socket.close();
                return true;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
