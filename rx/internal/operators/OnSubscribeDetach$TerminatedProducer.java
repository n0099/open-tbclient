package rx.internal.operators;

import com.baidu.tieba.e3a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class OnSubscribeDetach$TerminatedProducer implements e3a {
    public static final /* synthetic */ OnSubscribeDetach$TerminatedProducer[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OnSubscribeDetach$TerminatedProducer INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.e3a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
        }
    }

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

    public static OnSubscribeDetach$TerminatedProducer[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (OnSubscribeDetach$TerminatedProducer[]) $VALUES.clone();
        }
        return (OnSubscribeDetach$TerminatedProducer[]) invokeV.objValue;
    }

    public OnSubscribeDetach$TerminatedProducer(String str, int i) {
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

    public static OnSubscribeDetach$TerminatedProducer valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (OnSubscribeDetach$TerminatedProducer) Enum.valueOf(OnSubscribeDetach$TerminatedProducer.class, str);
        }
        return (OnSubscribeDetach$TerminatedProducer) invokeL.objValue;
    }
}
