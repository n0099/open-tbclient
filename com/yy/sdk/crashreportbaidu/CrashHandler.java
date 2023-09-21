package com.yy.sdk.crashreportbaidu;

import android.os.Process;
import com.baidu.tieba.n4c;
import com.baidu.tieba.o4c;
import com.baidu.tieba.q4c;
import com.baidu.tieba.s4c;
import com.baidu.tieba.t4c;
import com.baidu.tieba.w4c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.sdk.crashreportbaidu.CrashHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static b b;
    public static CrashHandler c;
    public static AtomicBoolean d = new AtomicBoolean(false);
    public static Executor e = null;
    public Thread.UncaughtExceptionHandler a;

    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void b(int i, String str, String str2);
    }

    public static native void initNativeHandler(String str);

    public static native void testNativeCrash();

    public static native void uninitNativeHandler();

    public static /* synthetic */ void f() {
        q4c.d("CrashHandler", "threadSize:" + w4c.d());
        q4c.d("CrashHandler", w4c.c());
        q4c.d("CrashHandler", w4c.b());
    }

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("threadSize", String.valueOf(w4c.d()));
            o4c.g(hashMap);
            w4c.g(t4c.s() + File.separator + "maps.txt");
        }
    }

    public CrashHandler(b bVar) {
        b = bVar;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void a(int i) {
        if (!s4c.f()) {
            return;
        }
        t4c.R(i);
        q4c.d("CrashHandler", "java crashFilterCallback!");
        Thread.setDefaultUncaughtExceptionHandler(c.a);
        b bVar = b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static void e(b bVar) {
        if (c != null) {
            return;
        }
        c = new CrashHandler(bVar);
        e = Executors.newFixedThreadPool(2);
    }

    public void g(Throwable th) {
        if (!s4c.f()) {
            return;
        }
        a(Process.myTid());
        b(0, d(th));
    }

    public static void b(int i, String str) {
        if (!s4c.f() || d.get()) {
            return;
        }
        d.set(true);
        e.execute(new a());
        q4c.d("CrashHandler", "java crashGenFinishCallback!");
        if (b != null) {
            b.b(i, str, c());
        }
    }

    public static String c() {
        try {
            n4c.e("CrashHandler", "\nCURRENT_LOGCAT:\n", false);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v threadtime -t 5000 -d *:I").getInputStream()), 1024);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                n4c.e("CrashHandler", readLine, false);
            }
            bufferedReader.close();
            n4c.a();
        } catch (Exception e2) {
            q4c.c("CrashHandler", "generateCrashLog", e2);
        }
        return n4c.b();
    }

    public static String d(Throwable th) {
        String str = t4c.s() + File.separator + t4c.n() + ".dmp";
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            String C = t4c.C(th);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(C.getBytes());
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            e.execute(new Runnable() { // from class: com.baidu.tieba.l4c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        CrashHandler.f();
                    }
                }
            });
            t4c.T(th);
            g(th);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
