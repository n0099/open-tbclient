package rx.internal.operators;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class OnSubscribeDetach$TerminatedProducer implements f {
    public static final /* synthetic */ OnSubscribeDetach$TerminatedProducer[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OnSubscribeDetach$TerminatedProducer INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188003979, "Lrx/internal/operators/OnSubscribeDetach$TerminatedProducer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(188003979, "Lrx/internal/operators/OnSubscribeDetach$TerminatedProducer;");
                return;
            }
        }
        OnSubscribeDetach$TerminatedProducer onSubscribeDetach$TerminatedProducer = new OnSubscribeDetach$TerminatedProducer("INSTANCE", 0);
        INSTANCE = onSubscribeDetach$TerminatedProducer;
        $VALUES = new OnSubscribeDetach$TerminatedProducer[]{onSubscribeDetach$TerminatedProducer};
    }

    public OnSubscribeDetach$TerminatedProducer(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static OnSubscribeDetach$TerminatedProducer valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OnSubscribeDetach$TerminatedProducer) Enum.valueOf(OnSubscribeDetach$TerminatedProducer.class, str) : (OnSubscribeDetach$TerminatedProducer) invokeL.objValue;
    }

    public static OnSubscribeDetach$TerminatedProducer[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OnSubscribeDetach$TerminatedProducer[]) $VALUES.clone() : (OnSubscribeDetach$TerminatedProducer[]) invokeV.objValue;
    }

    @Override // h.f
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
        }
    }
}
