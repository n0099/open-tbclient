package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.cq;
import com.xiaomi.push.dt;
import com.xiaomi.push.gx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public class ag {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f71404a;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f890a;

    /* renamed from: a  reason: collision with other field name */
    public static final Pattern f891a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162240, "Lcom/xiaomi/push/service/ag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162240, "Lcom/xiaomi/push/service/ag;");
                return;
            }
        }
        f891a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        f71404a = 0L;
        f890a = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
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
                        com.xiaomi.push.y.a(bufferedReader);
                        return sb2;
                    }
                    sb.append(StringUtils.LF);
                    sb.append(readLine);
                }
            } catch (Exception unused) {
                com.xiaomi.push.y.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.y.a(bufferedReader);
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
        dt.a m619a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((f890a.getActiveCount() <= 0 || currentTimeMillis - f71404a >= 1800000) && gx.m366a().m371a() && (m619a = bi.a().m619a()) != null && m619a.e() > 0) {
                f71404a = currentTimeMillis;
                a(m619a.a(), true);
            }
        }
    }

    public static void a(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, list, z) == null) {
            f890a.execute(new ah(list, z));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            String a2 = a("/proc/self/net/tcp");
            if (!TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m73a("dump tcp for uid = " + Process.myUid());
                com.xiaomi.channel.commonutils.logger.b.m73a(a2);
            }
            String a3 = a("/proc/self/net/tcp6");
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("dump tcp6 for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m73a(a3);
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.xiaomi.channel.commonutils.logger.b.m73a("ConnectivityTest: begin to connect to " + str);
                Socket socket = new Socket();
                socket.connect(cq.m229a(str, 5222), 5000);
                socket.setTcpNoDelay(true);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m73a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
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
