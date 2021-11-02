package com.kwad.sdk.core.imageloader.core.assist;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FailReason {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Throwable cause;
    public final FailType type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class FailType {
        public static final /* synthetic */ FailType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FailType DECODING_ERROR;
        public static final FailType IO_ERROR;
        public static final FailType NETWORK_DENIED;
        public static final FailType OUT_OF_MEMORY;
        public static final FailType UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889082829, "Lcom/kwad/sdk/core/imageloader/core/assist/FailReason$FailType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1889082829, "Lcom/kwad/sdk/core/imageloader/core/assist/FailReason$FailType;");
                    return;
                }
            }
            IO_ERROR = new FailType("IO_ERROR", 0);
            DECODING_ERROR = new FailType("DECODING_ERROR", 1);
            NETWORK_DENIED = new FailType("NETWORK_DENIED", 2);
            OUT_OF_MEMORY = new FailType("OUT_OF_MEMORY", 3);
            FailType failType = new FailType(RomUtils.UNKNOWN, 4);
            UNKNOWN = failType;
            $VALUES = new FailType[]{IO_ERROR, DECODING_ERROR, NETWORK_DENIED, OUT_OF_MEMORY, failType};
        }

        public FailType(String str, int i2) {
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

        public static FailType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FailType) Enum.valueOf(FailType.class, str) : (FailType) invokeL.objValue;
        }

        public static FailType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FailType[]) $VALUES.clone() : (FailType[]) invokeV.objValue;
        }
    }

    public FailReason(FailType failType, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {failType, th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = failType;
        this.cause = th;
    }

    public Throwable getCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cause : (Throwable) invokeV.objValue;
    }

    public FailType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : (FailType) invokeV.objValue;
    }
}
