package com.bytedance.sdk.openadsdk.q;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.util.Properties;
/* loaded from: classes9.dex */
public class o implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f69217a;

    /* renamed from: b  reason: collision with root package name */
    public String f69218b;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69217a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    public static o a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new o() : (o) invokeV.objValue;
    }

    private void b() {
        Context a2;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (a2 = com.bytedance.sdk.openadsdk.core.o.a()) == null) {
            return;
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = a2.getExternalFilesDir("TTCache")) != null) {
                externalFilesDir.mkdirs();
                this.f69218b = externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.f69218b)) {
                File file = new File(a2.getFilesDir(), "TTCache");
                file.mkdirs();
                this.f69218b = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                Method a2 = v.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
                if (a2 != null) {
                    a2.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
                }
            } catch (Throwable unused) {
            }
            try {
                Method a3 = v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
                if (a3 != null) {
                    a3.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
                }
            } catch (Throwable unused2) {
            }
            try {
                com.bytedance.sdk.openadsdk.core.j.f.c();
            } catch (Throwable unused3) {
            }
            try {
                com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
            } catch (Throwable unused4) {
            }
            try {
                String b2 = com.bytedance.sdk.component.adnet.a.b(com.bytedance.sdk.openadsdk.core.o.a());
                if (!TextUtils.isEmpty(b2)) {
                    File file = new File(b2);
                    if (file.exists()) {
                        com.bytedance.sdk.component.utils.f.c(file);
                    }
                }
            } catch (Throwable unused5) {
            }
            try {
                com.bytedance.sdk.openadsdk.downloadnew.a.g.e();
            } catch (Throwable unused6) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) {
            boolean z = false;
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2 != null) {
                    z = stringWriter2.contains(AdSlot.class.getPackage().getName());
                }
            } catch (Throwable unused) {
            }
            if (z) {
                a(thread, th);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f69217a;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
                return;
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IF, IF, IF, NOP, INVOKE, IF, NOP] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00d0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0107 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0117 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65538, this, thread, th) != null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.f69218b)) {
                b();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        if (TextUtils.isEmpty(this.f69218b)) {
            return;
        }
        File file = new File(this.f69218b, "tt_crash_count.properties");
        boolean z2 = true;
        if (file.exists() && file.isFile() && file.canRead()) {
            ?? properties = new Properties();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                properties.load(fileInputStream2);
                String property = properties.getProperty("crash_count", "0");
                String property2 = properties.getProperty("crash_last_time", "0");
                int intValue = Integer.valueOf(property).intValue();
                long longValue = Long.valueOf(property2).longValue();
                int i3 = 0;
                if (System.currentTimeMillis() - longValue < 300000) {
                    i2 = intValue + 1;
                    z = false;
                } else {
                    i2 = 1;
                    z = true;
                }
                if (i2 < 3) {
                    z2 = false;
                }
                if (!z2) {
                    i3 = i2;
                }
                com.bytedance.sdk.component.utils.k.f("TTCrashHandler", "==" + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + z2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + z);
                if (z2) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                } else {
                    properties.setProperty("crash_count", String.valueOf(i3));
                    if (z) {
                        properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        properties.store(fileOutputStream, "tt_crash_info");
                        fileInputStream = fileOutputStream;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        com.bytedance.sdk.component.utils.k.c("TTCrashHandler", "crash count error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    }
                }
                if (z2) {
                    c();
                }
                fileOutputStream = fileInputStream;
                fileInputStream = fileInputStream2;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = fileInputStream;
            }
        } else {
            Properties properties2 = new Properties();
            properties2.setProperty("crash_count", String.valueOf(1));
            properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
            fileOutputStream = new FileOutputStream(file);
            try {
                properties2.store(fileOutputStream, "tt_crash_info");
                com.bytedance.sdk.component.utils.k.f("TTCrashHandler", "==first");
                fileOutputStream = fileOutputStream;
            } catch (Throwable th5) {
                th = th5;
                try {
                    com.bytedance.sdk.component.utils.k.c("TTCrashHandler", "crash count error", th);
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                    fileOutputStream.close();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        }
        if (fileOutputStream == null) {
            return;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused5) {
        }
    }
}
