package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.push.cx;
import com.xiaomi.push.ej;
import com.xiaomi.push.he;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes18.dex */
public class ad {

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f839a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: a  reason: collision with root package name */
    private static long f4815a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f838a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private static String a(String str) {
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
            com.xiaomi.push.y.a(bufferedReader);
        } catch (Exception e2) {
            com.xiaomi.push.y.a(bufferedReader);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.y.a(bufferedReader);
            throw th;
        }
        return str2;
    }

    public static void a() {
        ej.a m556a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f838a.getActiveCount() <= 0 || currentTimeMillis - f4815a >= 1800000) && he.m327a().m332a() && (m556a = be.a().m556a()) != null && m556a.e() > 0) {
            f4815a = currentTimeMillis;
            a(m556a.a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f838a.execute(new ae(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m47a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m47a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.m47a(a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.m47a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(cx.m206a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            com.xiaomi.channel.commonutils.logger.b.m47a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
