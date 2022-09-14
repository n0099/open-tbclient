package com.google.android.gms.common.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes7.dex */
public final class GmsVersion {
    public static /* synthetic */ Interceptable $ic = null;
    @KeepForSdk
    public static final int VERSION_HALLOUMI = 4100000;
    @KeepForSdk
    public static final int VERSION_JARLSBERG = 4300000;
    @KeepForSdk
    public static final int VERSION_KENAFA = 4400000;
    @KeepForSdk
    public static final int VERSION_LONGHORN = 5000000;
    @KeepForSdk
    public static final int VERSION_MANCHEGO = 6000000;
    @KeepForSdk
    public static final int VERSION_ORLA = 7000000;
    @KeepForSdk
    public static final int VERSION_PARMESAN = 7200000;
    @KeepForSdk
    public static final int VERSION_QUESO = 7500000;
    @KeepForSdk
    public static final int VERSION_REBLOCHON = 7800000;
    @KeepForSdk
    public static final int VERSION_SAGA = 8000000;
    public transient /* synthetic */ FieldHolder $fh;

    public GmsVersion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @KeepForSdk
    public static boolean isAtLeastFenacho(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i >= 3200000 : invokeI.booleanValue;
    }
}
