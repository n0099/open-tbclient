package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized String a(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningAppProcessInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(a)) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        a = Application.getProcessName();
                        return a;
                    }
                    int myPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            try {
                                next = it.next();
                            } catch (Exception unused) {
                            }
                            if (next.pid == myPid) {
                                a = next.processName;
                                return a;
                            }
                            continue;
                        }
                    }
                    return null;
                }
                return a;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, File file, File file2) throws Throwable {
        InputStream inputStream;
        Throwable th;
        String str;
        InputStream inputStream2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65538, null, context, file, file2) != null) {
            return;
        }
        AssetManager assets = context.getAssets();
        FileOutputStream fileOutputStream = null;
        try {
            h.a();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str2 = "Asset Error " + str;
                    GDTLogger.e(str2);
                    throw new Exception(str2);
                }
                str = "no asset";
                String str22 = "Asset Error " + str;
                GDTLogger.e(str22);
                throw new Exception(str22);
            }
            String str3 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str4 = Sig.ASSET_PLUGIN_SIG;
            if (str4 == null) {
                str4 = "";
            }
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z = h.a(assets.open(str3), file);
                inputStream2 = null;
            } else {
                InputStream inputStream3 = assets.open(str3);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                        byte[] bArr = new byte[1024];
                        int length = bytes.length;
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            int read = inputStream3.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            int i3 = 0;
                            while (i3 < read) {
                                int i4 = i2 + 1;
                                if (i2 >= 64) {
                                    bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                    i++;
                                }
                                i3++;
                                i2 = i4;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        inputStream2 = inputStream3;
                        fileOutputStream = fileOutputStream2;
                        z = true;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            GDTLogger.e("插件加载失败", th);
                            throw th;
                        } finally {
                            a(inputStream3);
                            a(fileOutputStream);
                        }
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream3;
                    th = th3;
                    InputStream inputStream4 = inputStream;
                    th = th;
                    inputStream3 = inputStream4;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (!z) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static synchronized String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                String str3 = a;
                if (!TextUtils.isEmpty(str3)) {
                    boolean endsWith = str3.endsWith("_");
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (endsWith) {
                        str2 = "";
                    } else {
                        str2 = "_";
                    }
                    sb.append(str2);
                    String str4 = null;
                    try {
                        String str5 = new String(str3);
                        try {
                            str4 = d.a(MessageDigest.getInstance("MD5").digest(str5.getBytes("UTF-8")));
                        } catch (Exception unused) {
                            str4 = str5;
                        }
                    } catch (Exception unused2) {
                    }
                    sb.append(str4);
                    return sb.toString();
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
