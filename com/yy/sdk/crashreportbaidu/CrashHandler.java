package com.yy.sdk.crashreportbaidu;

import android.os.Process;
import com.baidu.tieba.afb;
import com.baidu.tieba.reb;
import com.baidu.tieba.seb;
import com.baidu.tieba.ueb;
import com.baidu.tieba.web;
import com.baidu.tieba.xeb;
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
        ueb.d("CrashHandler", "threadSize:" + afb.d());
        ueb.d("CrashHandler", afb.c());
        ueb.d("CrashHandler", afb.b());
    }

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("threadSize", String.valueOf(afb.d()));
            seb.g(hashMap);
            afb.g(xeb.s() + File.separator + "maps.txt");
        }
    }

    public CrashHandler(b bVar) {
        b = bVar;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void a(int i) {
        if (!web.f()) {
            return;
        }
        xeb.R(i);
        ueb.d("CrashHandler", "java crashFilterCallback!");
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
        if (!web.f()) {
            return;
        }
        a(Process.myTid());
        b(0, d(th));
    }

    public static void b(int i, String str) {
        if (!web.f() || d.get()) {
            return;
        }
        d.set(true);
        e.execute(new a());
        ueb.d("CrashHandler", "java crashGenFinishCallback!");
        if (b != null) {
            b.b(i, str, c());
        }
    }

    public static String c() {
        try {
            reb.e("CrashHandler", "\nCURRENT_LOGCAT:\n", false);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v threadtime -t 5000 -d *:I").getInputStream()), 1024);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                reb.e("CrashHandler", readLine, false);
            }
            bufferedReader.close();
            reb.a();
        } catch (Exception e2) {
            ueb.c("CrashHandler", "generateCrashLog", e2);
        }
        return reb.b();
    }

    public static String d(Throwable th) {
        String str = xeb.s() + File.separator + xeb.n() + ".dmp";
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            String C = xeb.C(th);
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
            e.execute(new Runnable() { // from class: com.baidu.tieba.peb
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
            xeb.T(th);
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
