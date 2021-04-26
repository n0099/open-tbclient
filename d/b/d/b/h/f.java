package d.b.d.b.h;

import android.os.Build;
import d.b.d.b.l;
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
        public InputStream f65203e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f65204f;

        public a(InputStream inputStream, List<String> list) {
            this.f65203e = inputStream;
            this.f65204f = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f65203e));
            int i2 = 32768;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("---------")) {
                        i2 -= readLine.getBytes("UTF-8").length;
                        if (i2 < 0) {
                            break;
                        }
                        this.f65204f.add(readLine);
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
        public Process f65205e;

        /* renamed from: f  reason: collision with root package name */
        public long f65206f;

        public b(Process process, long j) {
            this.f65205e = process;
            this.f65206f = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.f65206f);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Process process = this.f65205e;
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static String a(int i2) {
        return (i2 < 0 || i2 >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i2];
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
    public static List<String> b(int i2, int i3) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i2), a(i3)};
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
