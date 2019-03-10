package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class ae {
    private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long b = 0;
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a() {
        a.C0371a d;
        long currentTimeMillis = System.currentTimeMillis();
        if ((c.getActiveCount() <= 0 || currentTimeMillis - b >= 1800000) && com.xiaomi.stats.f.a().c() && (d = at.a().d()) != null && d.m() > 0) {
            b = currentTimeMillis;
            a(d.l(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        c.execute(new af(list, z));
    }

    public static void b() {
        String c2 = c("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(c2)) {
            com.xiaomi.channel.commonutils.logger.b.a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.a(c2);
        }
        String c3 = c("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(c3)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.a(c3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(Host.b(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            com.xiaomi.channel.commonutils.logger.b.a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append("\n");
                sb.append(readLine);
            }
            str2 = sb.toString();
            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
            throw th;
        }
        return str2;
    }
}
