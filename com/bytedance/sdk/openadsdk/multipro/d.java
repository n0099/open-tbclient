package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, context) == null) || context == null) {
            return;
        }
        String packageName = context.getPackageName();
        com.bytedance.sdk.openadsdk.multipro.d.a.a(context.getApplicationContext());
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            int myPid = Process.myPid();
            packageName = context.getPackageName() + myPid;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    packageName = runningAppProcessInfo.processName;
                }
            }
            WebView.setDataDirectorySuffix(packageName);
            if (o.a(context)) {
                a(context, packageName);
            }
        } catch (Throwable th) {
            try {
                WebView.setDataDirectorySuffix(packageName);
            } catch (Throwable unused) {
            }
            j.b(th.toString());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0056 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0035 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0050 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.io.RandomAccessFile */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    @RequiresApi(api = 24)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str) {
        String str2;
        Throwable th;
        FileNotFoundException e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65537, null, context, str) != null) {
            return;
        }
        if (str == null) {
            str2 = "webview";
        } else {
            str2 = "webview_" + str;
        }
        RandomAccessFile randomAccessFile = "webview_data.lock";
        File file = new File(context.getDir(str2, 0).getPath(), "webview_data.lock");
        if (!file.exists()) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            FileLock tryLock = randomAccessFile.getChannel().tryLock();
                            if (tryLock != null) {
                                tryLock.close();
                            } else {
                                file.delete();
                                file.createNewFile();
                            }
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (randomAccessFile == 0) {
                                return;
                            }
                            randomAccessFile.close();
                        } catch (IOException unused) {
                            randomAccessFile2 = randomAccessFile;
                            file.delete();
                            try {
                                file.createNewFile();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != 0) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                    return;
                }
            } catch (FileNotFoundException e5) {
                randomAccessFile = 0;
                e2 = e5;
            } catch (IOException unused4) {
            }
            randomAccessFile.close();
        } catch (Throwable th3) {
            randomAccessFile = randomAccessFile2;
            th = th3;
            if (randomAccessFile != 0) {
            }
            throw th;
        }
    }
}
