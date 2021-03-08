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
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    private static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private InputStream f5175a;
        private List<String> b;

        a(InputStream inputStream, List<String> list) {
            this.f5175a = inputStream;
            this.b = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i = 32768;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f5175a));
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
                        this.b.add(readLine);
                    }
                } catch (IOException e) {
                    return;
                } finally {
                    com.bytedance.tea.crash.g.f.a(bufferedReader);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Process f5176a;
        private long b;

        public b(Process process, long j) {
            this.f5176a = process;
            this.b = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.f5176a != null) {
                this.f5176a.destroy();
            }
        }
    }

    private static String a(int i) {
        String[] strArr = {"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"};
        return (i < 0 || i >= strArr.length) ? "*:V" : strArr[i];
    }
}
