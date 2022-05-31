package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface kx0 {
    public static final ServiceReference a = new ServiceReference("nad.core", ShareLoginStat.GetShareListStat.VALUE_FROM_SP);
    public static final kx0 b = new a();

    /* loaded from: classes6.dex */
    public static class a implements kx0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.kx0
        public lx0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new mx0() : (lx0) invokeV.objValue;
        }

        @Override // com.repackage.kx0
        public lx0 b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new mx0(str) : (lx0) invokeL.objValue;
        }
    }

    lx0 a();

    lx0 b(String str);
}
