package com.kwad.sdk.crash.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class SystemUtil {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f35358a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Boolean f35359b;

    /* renamed from: c  reason: collision with root package name */
    public static long f35360c;

    /* renamed from: d  reason: collision with root package name */
    public static long f35361d;

    /* renamed from: e  reason: collision with root package name */
    public static int f35362e;

    /* renamed from: f  reason: collision with root package name */
    public static LEVEL f35363f;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class LEVEL {
        public static final /* synthetic */ LEVEL[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LEVEL BAD;
        public static final LEVEL BEST;
        public static final LEVEL HIGH;
        public static final LEVEL LOW;
        public static final LEVEL MIDDLE;
        public static final LEVEL UN_KNOW;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1228590377, "Lcom/kwad/sdk/crash/utils/SystemUtil$LEVEL;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1228590377, "Lcom/kwad/sdk/crash/utils/SystemUtil$LEVEL;");
                    return;
                }
            }
            BEST = new LEVEL("BEST", 0, 5);
            HIGH = new LEVEL("HIGH", 1, 4);
            MIDDLE = new LEVEL("MIDDLE", 2, 3);
            LOW = new LEVEL("LOW", 3, 2);
            BAD = new LEVEL("BAD", 4, 1);
            LEVEL level = new LEVEL("UN_KNOW", 5, -1);
            UN_KNOW = level;
            $VALUES = new LEVEL[]{BEST, HIGH, MIDDLE, LOW, BAD, level};
        }

        public LEVEL(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static LEVEL valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LEVEL) Enum.valueOf(LEVEL.class, str) : (LEVEL) invokeL.objValue;
        }

        public static LEVEL[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LEVEL[]) $VALUES.clone() : (LEVEL[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f35364a;

        /* renamed from: b  reason: collision with root package name */
        public long f35365b;

        /* renamed from: c  reason: collision with root package name */
        public long f35366c;

        /* renamed from: d  reason: collision with root package name */
        public long f35367d;

        /* renamed from: e  reason: collision with root package name */
        public long f35368e;

        /* renamed from: f  reason: collision with root package name */
        public int f35369f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1643001495, "Lcom/kwad/sdk/crash/utils/SystemUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1643001495, "Lcom/kwad/sdk/crash/utils/SystemUtil;");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x005b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static long a() {
        ?? r2;
        BufferedReader bufferedReader;
        Exception e2;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65537;
            InterceptResult invokeV = interceptable.invokeV(65537, null);
            if (invokeV != null) {
                return invokeV.longValue;
            }
        }
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            } catch (IOException e3) {
                com.kwad.sdk.core.d.a.b(e3);
                return 0L;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e2 = e4;
        } catch (Throwable th2) {
            r2 = 0;
            th = th2;
            if (r2 != 0) {
                try {
                    r2.close();
                } catch (IOException e5) {
                    com.kwad.sdk.core.d.a.b(e5);
                }
            }
            throw th;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Exception e6) {
                e2 = e6;
                com.kwad.sdk.core.d.a.b(e2);
                if (bufferedReader != null) {
                    bufferedReader.close();
                    return 0L;
                }
                return 0L;
            }
            if (readLine == null) {
                bufferedReader.close();
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
        try {
            bufferedReader.close();
        } catch (IOException e7) {
            com.kwad.sdk.core.d.a.b(e7);
        }
        return longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x008a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x000f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x0040 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        com.kwad.sdk.crash.utils.SystemUtil.f35358a = r1.processName;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ?? isEmpty = TextUtils.isEmpty(f35358a);
            if (isEmpty == 0) {
                return f35358a;
            }
            try {
                isEmpty = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == isEmpty) {
                            break;
                        }
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.b(e3);
            }
            if (TextUtils.isEmpty(f35358a)) {
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ProcessUtils.CMD_LINE_NAME)));
                    } catch (Throwable th2) {
                        th = th2;
                        b.a((Reader) isEmpty);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    bufferedReader = null;
                    e2 = e4;
                } catch (IOException e5) {
                    bufferedReader = null;
                    e2 = e5;
                } catch (Throwable th3) {
                    isEmpty = 0;
                    th = th3;
                    b.a((Reader) isEmpty);
                    throw th;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = bufferedReader.read();
                        if (read <= 0) {
                            break;
                        }
                        sb.append((char) read);
                    }
                    f35358a = sb.toString();
                } catch (FileNotFoundException e6) {
                    e2 = e6;
                    com.kwad.sdk.core.d.a.b(e2);
                    b.a((Reader) bufferedReader);
                    return f35358a;
                } catch (IOException e7) {
                    e2 = e7;
                    com.kwad.sdk.core.d.a.b(e2);
                    b.a((Reader) bufferedReader);
                    return f35358a;
                }
                b.a((Reader) bufferedReader);
            }
            return f35358a;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            int length = str2.length();
            int i2 = -1;
            while (true) {
                if (length >= str.length()) {
                    length = -1;
                    break;
                }
                char charAt = str.charAt(length);
                if (charAt < '0' || charAt > '9') {
                    if (i2 != -1) {
                        break;
                    }
                } else if (i2 == -1) {
                    i2 = length;
                }
                length++;
            }
            if (i2 == -1) {
                return null;
            }
            return length == -1 ? str.substring(i2) : str.substring(i2, length);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? b() >= i2 : invokeI.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f35359b == null) {
                String a2 = a(context);
                f35359b = Boolean.valueOf(!TextUtils.isEmpty(a2) && a2.equals(context.getPackageName()));
            }
            return f35359b.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static long c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0085 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0010 */
    public static a c() {
        InterceptResult invokeV;
        String readLine;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            a aVar = new a();
            RandomAccessFile randomAccessFile = null;
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", r.f7762a);
                    while (true) {
                        try {
                            readLine = randomAccessFile2.readLine();
                            if (readLine == null) {
                                break;
                            } else if (!TextUtils.isEmpty(readLine)) {
                                if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                                    String a3 = a(readLine, "VmSize");
                                    if (a3 != null) {
                                        aVar.f35365b = Long.valueOf(a3).longValue();
                                    }
                                } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                                    String a4 = a(readLine, "VmRSS:");
                                    if (a4 != null) {
                                        aVar.f35366c = Long.valueOf(a4).longValue();
                                    }
                                } else if (readLine.startsWith("Threads:") && (a2 = a(readLine, "Threads:")) != null) {
                                    aVar.f35369f = Integer.valueOf(a2).intValue();
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            randomAccessFile = randomAccessFile2;
                            com.kwad.sdk.core.d.a.b(e);
                            b.a(randomAccessFile);
                            randomAccessFile = randomAccessFile;
                            return aVar;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile2;
                            b.a(randomAccessFile);
                            throw th;
                        }
                    }
                    b.a(randomAccessFile2);
                    randomAccessFile = readLine;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                applicationInfo = context.getApplicationInfo();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            ApplicationInfo applicationInfo2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo2 != null) {
                return applicationInfo2.targetSdkVersion;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
