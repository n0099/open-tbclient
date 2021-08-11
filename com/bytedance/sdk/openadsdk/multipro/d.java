package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes9.dex */
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
            if (q.a(context)) {
                a(context, packageName);
            }
        } catch (Throwable th) {
            try {
                WebView.setDataDirectorySuffix(packageName);
            } catch (Throwable unused) {
            }
            k.c(th.toString());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0074 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x004d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.io.RandomAccessFile */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    @RequiresApi(api = 24)
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
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != 0) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    return;
                }
            } catch (FileNotFoundException e3) {
                randomAccessFile = 0;
                e2 = e3;
            } catch (IOException unused3) {
            }
            try {
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    file.delete();
                    file.createNewFile();
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                e2.printStackTrace();
                if (randomAccessFile == 0) {
                    return;
                }
                randomAccessFile.close();
            } catch (IOException unused4) {
                randomAccessFile2 = randomAccessFile;
                file.delete();
                try {
                    file.createNewFile();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                    return;
                }
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th3) {
            randomAccessFile = randomAccessFile2;
            th = th3;
        }
    }
}
