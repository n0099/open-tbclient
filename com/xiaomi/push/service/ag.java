package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
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
/* loaded from: classes7.dex */
public class ag {

    /* renamed from: a  reason: collision with other field name */
    public static final Pattern f883a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: a  reason: collision with root package name */
    public static long f40941a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f882a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
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
                    sb.append("\n");
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
        dt.a m597a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f882a.getActiveCount() <= 0 || currentTimeMillis - f40941a >= 1800000) && gx.m344a().m349a() && (m597a = bi.a().m597a()) != null && m597a.e() > 0) {
            f40941a = currentTimeMillis;
            a(m597a.a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f882a.execute(new ah(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m51a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m51a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m51a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.m51a(a3);
    }

    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.m51a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(cq.m207a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.xiaomi.channel.commonutils.logger.b.m51a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
