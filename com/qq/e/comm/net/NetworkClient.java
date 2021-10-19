package com.qq.e.comm.net;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public interface NetworkClient {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Priority {
        public static /* synthetic */ Interceptable $ic;
        public static final Priority High;
        public static final Priority Low;
        public static final Priority Mid;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ Priority[] f75743b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f75744a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1767792010, "Lcom/qq/e/comm/net/NetworkClient$Priority;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1767792010, "Lcom/qq/e/comm/net/NetworkClient$Priority;");
                    return;
                }
            }
            High = new Priority("High", 0, 1);
            Mid = new Priority("Mid", 1, 2);
            Priority priority = new Priority("Low", 2, 3);
            Low = priority;
            f75743b = new Priority[]{High, Mid, priority};
        }

        public Priority(String str, int i2, int i3) {
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
            this.f75744a = i3;
        }

        public static Priority valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Priority) Enum.valueOf(Priority.class, str) : (Priority) invokeL.objValue;
        }

        public static Priority[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Priority[]) f75743b.clone() : (Priority[]) invokeV.objValue;
        }

        public final int value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f75744a : invokeV.intValue;
        }
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, Priority priority);

    void submit(Request request, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack, Executor executor);
}
