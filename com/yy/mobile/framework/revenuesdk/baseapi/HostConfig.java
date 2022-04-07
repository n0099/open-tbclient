package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public class HostConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HOSTID_BAIDUAPP = "3";
    public static final String HOSTID_BAIJIAHAO = "6";
    public static final String HOSTID_HAOKAN = "2";
    public static final String HOSTID_QUANMIN = "4";
    public static final String HOSTID_TIEBA = "5";
    public static final String HOSTID_YY = "1";
    public transient /* synthetic */ FieldHolder $fh;

    public HostConfig() {
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
}
