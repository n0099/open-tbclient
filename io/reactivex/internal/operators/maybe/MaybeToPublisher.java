package io.reactivex.internal.operators.maybe;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    public static final /* synthetic */ MaybeToPublisher[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MaybeToPublisher INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-39662730, "Lio/reactivex/internal/operators/maybe/MaybeToPublisher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-39662730, "Lio/reactivex/internal/operators/maybe/MaybeToPublisher;");
                return;
            }
        }
        MaybeToPublisher maybeToPublisher = new MaybeToPublisher("INSTANCE", 0);
        INSTANCE = maybeToPublisher;
        $VALUES = new MaybeToPublisher[]{maybeToPublisher};
    }

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return INSTANCE;
        }
        return (Function) invokeV.objValue;
    }

    public static MaybeToPublisher[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (MaybeToPublisher[]) $VALUES.clone();
        }
        return (MaybeToPublisher[]) invokeV.objValue;
    }

    public MaybeToPublisher(String str, int i) {
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

    public static MaybeToPublisher valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (MaybeToPublisher) Enum.valueOf(MaybeToPublisher.class, str);
        }
        return (MaybeToPublisher) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.functions.Function
    public Publisher<Object> apply(MaybeSource<Object> maybeSource) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, maybeSource)) == null) {
            return new MaybeToFlowable(maybeSource);
        }
        return (Publisher) invokeL.objValue;
    }
}
