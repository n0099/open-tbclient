package com.bytedance.tea.crash.e;

import android.os.Build;
import com.baidu.android.imsdk.internal.IMConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {
    public static List<String> a(int i, int i2) {
        Process process = null;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"logcat", "-t", String.valueOf(i), a(i2)});
            new a(exec.getInputStream(), copyOnWriteArrayList).start();
            new a(exec.getErrorStream(), copyOnWriteArrayList).start();
            new b(exec, IMConnection.RETRY_DELAY_TIMES).start();
            if (Build.VERSION.SDK_INT >= 26) {
                exec.waitFor(IMConnection.RETRY_DELAY_TIMES, TimeUnit.MILLISECONDS);
            } else {
                exec.waitFor();
            }
            if (exec != null) {
                exec.destroy();
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (0 != 0) {
                    process.destroy();
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    process.destroy();
                }
                throw th2;
            }
        }
        return copyOnWriteArrayList;
    }

    /* loaded from: classes4.dex */
    private static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private InputStream f7944a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f7945b;

        a(InputStream inputStream, List<String> list) {
            this.f7944a = inputStream;
            this.f7945b = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i = 32768;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f7944a));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("---------")) {
                        i -= readLine.getBytes("UTF-8").length;
                        if (i < 0) {
                            break;
                        }
                        this.f7945b.add(readLine);
                    }
                } catch (IOException e) {
                    return;
                } finally {
                    com.bytedance.tea.crash.g.f.a(bufferedReader);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Process f7946a;

        /* renamed from: b  reason: collision with root package name */
        private long f7947b;

        public b(Process process, long j) {
            this.f7946a = process;
            this.f7947b = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.f7947b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.f7946a != null) {
                this.f7946a.destroy();
            }
        }
    }

    private static String a(int i) {
        String[] strArr = {"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"};
        return (i < 0 || i >= strArr.length) ? "*:V" : strArr[i];
    }
}
