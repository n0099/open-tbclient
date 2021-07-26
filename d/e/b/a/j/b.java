package d.e.b.a.j;

import android.app.ActivityManager;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f69639a;

    /* renamed from: b  reason: collision with root package name */
    public static long f69640b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? Pattern.matches("cpu[0-9]", file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-493438374, "Ld/e/b/a/j/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-493438374, "Ld/e/b/a/j/b;");
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) d.e.b.a.c.d().provideContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f69639a == 0) {
                try {
                    f69639a = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
                } catch (Exception e2) {
                    Log.e("PerformanceUtils", "getNumCores exception", e2);
                    f69639a = 1;
                }
            }
            return f69639a;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0058 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0015 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v15, resolved type: java.lang.Integer */
    /* JADX WARN: Multi-variable type inference failed */
    public static long c() {
        InterceptResult invokeV;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f69640b == 0) {
                long j = -1;
                FileReader fileReader2 = null;
                try {
                    try {
                        try {
                            fileReader = new FileReader("/proc/meminfo");
                        } catch (IOException e2) {
                            Log.e("PerformanceUtils", "close localFileReader exception = ", e2);
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                    String readLine = bufferedReader.readLine();
                    String str = readLine;
                    if (readLine != null) {
                        Integer valueOf = Integer.valueOf(readLine.split("\\s+")[1]);
                        j = valueOf.intValue();
                        str = valueOf;
                    }
                    bufferedReader.close();
                    fileReader.close();
                    fileReader2 = str;
                } catch (IOException e4) {
                    e = e4;
                    fileReader2 = fileReader;
                    Log.e("PerformanceUtils", "getTotalMemory exception = ", e);
                    if (fileReader2 != null) {
                        fileReader2.close();
                        fileReader2 = fileReader2;
                    }
                    f69640b = j;
                    return f69640b;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException e5) {
                            Log.e("PerformanceUtils", "close localFileReader exception = ", e5);
                        }
                    }
                    throw th;
                }
                f69640b = j;
            }
            return f69640b;
        }
        return invokeV.longValue;
    }
}
