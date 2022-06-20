package rx.internal.schedulers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ez9;
import com.repackage.ov9;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class GenericScheduledExecutorServiceFactory {
    public static final /* synthetic */ GenericScheduledExecutorServiceFactory[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final RxThreadFactory THREAD_FACTORY;
    public static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-903418117, "Lrx/internal/schedulers/GenericScheduledExecutorServiceFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-903418117, "Lrx/internal/schedulers/GenericScheduledExecutorServiceFactory;");
                return;
            }
        }
        $VALUES = new GenericScheduledExecutorServiceFactory[0];
        THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);
    }

    public GenericScheduledExecutorServiceFactory(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ScheduledExecutorService create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ov9<? extends ScheduledExecutorService> a = ez9.a();
            if (a == null) {
                return createDefault();
            }
            return a.call();
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public static ScheduledExecutorService createDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Executors.newScheduledThreadPool(1, threadFactory()) : (ScheduledExecutorService) invokeV.objValue;
    }

    public static ThreadFactory threadFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? THREAD_FACTORY : (ThreadFactory) invokeV.objValue;
    }

    public static GenericScheduledExecutorServiceFactory valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (GenericScheduledExecutorServiceFactory) Enum.valueOf(GenericScheduledExecutorServiceFactory.class, str) : (GenericScheduledExecutorServiceFactory) invokeL.objValue;
    }

    public static GenericScheduledExecutorServiceFactory[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? (GenericScheduledExecutorServiceFactory[]) $VALUES.clone() : (GenericScheduledExecutorServiceFactory[]) invokeV.objValue;
    }
}
