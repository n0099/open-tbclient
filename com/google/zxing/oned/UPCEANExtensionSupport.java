package com.google.zxing.oned;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
/* loaded from: classes7.dex */
public final class UPCEANExtensionSupport {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] EXTENSION_START_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;
    public final UPCEANExtension5Support fiveSupport;
    public final UPCEANExtension2Support twoSupport;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1587391145, "Lcom/google/zxing/oned/UPCEANExtensionSupport;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1587391145, "Lcom/google/zxing/oned/UPCEANExtensionSupport;");
                return;
            }
        }
        EXTENSION_START_PATTERN = new int[]{1, 1, 2};
    }

    public UPCEANExtensionSupport() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.twoSupport = new UPCEANExtension2Support();
        this.fiveSupport = new UPCEANExtension5Support();
    }

    public Result decodeRow(int i, BitArray bitArray, int i2) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), bitArray, Integer.valueOf(i2)})) == null) {
            int[] findGuardPattern = UPCEANReader.findGuardPattern(bitArray, i2, false, EXTENSION_START_PATTERN);
            try {
                return this.fiveSupport.decodeRow(i, bitArray, findGuardPattern);
            } catch (ReaderException unused) {
                return this.twoSupport.decodeRow(i, bitArray, findGuardPattern);
            }
        }
        return (Result) invokeCommon.objValue;
    }
}
