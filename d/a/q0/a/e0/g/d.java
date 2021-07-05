package d.a.q0.a.e0.g;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import java.text.DecimalFormat;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityManager f47436b;

    /* renamed from: c  reason: collision with root package name */
    public static int f47437c;

    /* renamed from: d  reason: collision with root package name */
    public static int f47438d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f47439a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f47440a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(428562892, "Ld/a/q0/a/e0/g/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(428562892, "Ld/a/q0/a/e0/g/d$b;");
                    return;
                }
            }
            f47440a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1957093750, "Ld/a/q0/a/e0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1957093750, "Ld/a/q0/a/e0/g/d;");
                return;
            }
        }
        f47436b = (ActivityManager) d.a.q0.a.c1.a.b().getSystemService("activity");
        d.a.q0.a.c1.a.Z().getSwitch("swan_memory_sample", 0);
        f47437c = 0;
        f47438d = new Random().nextInt(100);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f47440a : (d) invokeV.objValue;
    }

    public final String a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? this.f47439a.format(f2) : (String) invokeF.objValue;
    }

    public String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (e()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    d.a.q0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo mainPid: " + i2);
                    Debug.MemoryInfo[] processMemoryInfo = f47436b.getProcessMemoryInfo(new int[]{Process.myPid(), i2});
                    if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                        Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                        if (memoryInfo != null) {
                            jSONObject.put("smart_app_used_mem", a(((float) Debug.getPss()) / 1024.0f));
                            jSONObject.put("total_rss", a((((memoryInfo.getTotalPrivateClean() + memoryInfo.getTotalPrivateDirty()) + memoryInfo.getTotalSharedClean()) + memoryInfo.getTotalSharedDirty()) / 1024.0f));
                            jSONObject.put("private_clean", a(memoryInfo.getTotalPrivateClean() / 1024.0f));
                            jSONObject.put("private_dirty", a(memoryInfo.getTotalPrivateDirty() / 1024.0f));
                            jSONObject.put("shared_clean", a(memoryInfo.getTotalSharedClean() / 1024.0f));
                            jSONObject.put("shared_dirty", a(memoryInfo.getTotalSharedDirty() / 1024.0f));
                        }
                        Debug.MemoryInfo memoryInfo2 = processMemoryInfo[1];
                        if (memoryInfo2 != null) {
                            jSONObject.put("host_used_mem", a((((memoryInfo2.getTotalPrivateClean() + memoryInfo2.getTotalPrivateDirty()) + memoryInfo2.getTotalSharedClean()) + memoryInfo2.getTotalSharedDirty()) / 1024.0f));
                        }
                    }
                    ActivityManager.MemoryInfo memoryInfo3 = new ActivityManager.MemoryInfo();
                    f47436b.getMemoryInfo(memoryInfo3);
                    jSONObject.put("sys_free_mem", a(((float) memoryInfo3.availMem) / 1048576.0f));
                    jSONObject.put("sys_low_mem", memoryInfo3.lowMemory ? "1" : "0");
                    jSONObject.put("native_heap", a(((float) Debug.getNativeHeapSize()) / 1048576.0f));
                    jSONObject.put("native_heap_alloc", a(((float) Debug.getNativeHeapAllocatedSize()) / 1048576.0f));
                    jSONObject.put("vm_max_mem", a(((float) Runtime.getRuntime().maxMemory()) / 1048576.0f));
                    jSONObject.put("vm_total_mem", a(((float) Runtime.getRuntime().totalMemory()) / 1048576.0f));
                    jSONObject.put("vm_free_mem", a(((float) Runtime.getRuntime().freeMemory()) / 1048576.0f));
                    jSONObject.put("thread_count", Thread.activeCount());
                } catch (Exception e2) {
                    d.a.q0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo: " + Log.getStackTraceString(e2));
                }
                d.a.q0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo result=" + jSONObject);
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (e()) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                f47436b.getMemoryInfo(memoryInfo);
                String a2 = a(((float) memoryInfo.totalMem) / 1048576.0f);
                d.a.q0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo sysTotalMemory=" + a2);
                return a2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.a.e0.d.h("SwanMemoryProperty", "getMemoryInfo mMemSample =" + f47437c + "; mRandomNum =" + f47438d);
            int i2 = f47437c;
            if (i2 <= 0) {
                return false;
            }
            return i2 >= 100 || f47438d <= i2;
        }
        return invokeV.booleanValue;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47439a = new DecimalFormat("#.###");
    }
}
