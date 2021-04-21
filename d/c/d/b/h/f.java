package d.c.d.b.h;

import android.os.Build;
import d.c.d.b.l;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class f {

    /* loaded from: classes5.dex */
    public static class a extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public InputStream f66798e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f66799f;

        public a(InputStream inputStream, List<String> list) {
            this.f66798e = inputStream;
            this.f66799f = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f66798e));
            int i = 32768;
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
                        this.f66799f.add(readLine);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    l.g.a(bufferedReader);
                    throw th;
                }
            }
            l.g.a(bufferedReader);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public Process f66800e;

        /* renamed from: f  reason: collision with root package name */
        public long f66801f;

        public b(Process process, long j) {
            this.f66800e = process;
            this.f66801f = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.f66801f);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Process process = this.f66800e;
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static String a(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x005a, code lost:
        if (r4 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> b(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i), a(i2)};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(strArr);
            new a(process.getInputStream(), copyOnWriteArrayList).start();
            new a(process.getErrorStream(), copyOnWriteArrayList).start();
            new b(process, 3000L).start();
            if (Build.VERSION.SDK_INT >= 26) {
                process.waitFor(3000L, TimeUnit.MILLISECONDS);
            } else {
                process.waitFor();
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                if (0 != 0) {
                    process.destroy();
                }
            }
        }
    }
}
