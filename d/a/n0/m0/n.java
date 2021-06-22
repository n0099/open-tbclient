package d.a.n0.m0;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public long f53356a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f53357b = -1;

    public void a() {
        this.f53356a = SystemClock.elapsedRealtime();
        Process.getElapsedCpuTime();
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b1: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:42:0x00b1 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        BufferedReader bufferedReader;
        NumberFormatException e2;
        IOException e3;
        FileNotFoundException e4;
        Closeable closeable;
        long j;
        l.b().d();
        Closeable closeable2 = null;
        long j2 = -1;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                try {
                    String[] split = bufferedReader.readLine().split(" ");
                    if (split.length > 21 && split[0].equals(String.valueOf(Process.myPid()))) {
                        String str = split[21];
                        try {
                            SoLoader.load(AppRuntime.getAppContext(), "launch_native");
                            j = LaunchNativeUtils.getClkTck();
                        } catch (UnsatisfiedLinkError e5) {
                            Log.e("ZygoteSpeedStats", "load so failed, UnsatisfiedLinkError", e5);
                            j = 0;
                        }
                        Log.d("ZygoteSpeedStats", "_SC_CLK_TCK " + j);
                        if (j <= 0) {
                            j = 100;
                        }
                        j2 = (Long.parseLong(str) * 1000) / j;
                    }
                } catch (FileNotFoundException e6) {
                    e4 = e6;
                    Log.e("ZygoteSpeedStats", "can't read process status file", e4);
                    Closeables.closeSafely(bufferedReader);
                    if (j2 <= 0) {
                    }
                } catch (IOException e7) {
                    e3 = e7;
                    Log.e("ZygoteSpeedStats", "read process status failed", e3);
                    Closeables.closeSafely(bufferedReader);
                    if (j2 <= 0) {
                    }
                } catch (NumberFormatException e8) {
                    e2 = e8;
                    Log.e("ZygoteSpeedStats", "parse status file failed", e2);
                    Closeables.closeSafely(bufferedReader);
                    if (j2 <= 0) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                Closeables.closeSafely(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e9) {
            bufferedReader = null;
            e4 = e9;
        } catch (IOException e10) {
            bufferedReader = null;
            e3 = e10;
        } catch (NumberFormatException e11) {
            bufferedReader = null;
            e2 = e11;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(closeable2);
            throw th;
        }
        Closeables.closeSafely(bufferedReader);
        if (j2 <= 0) {
            this.f53357b = this.f53356a - j2;
        }
    }

    public long c() {
        if (this.f53357b == -1) {
            b();
        }
        return this.f53357b;
    }
}
