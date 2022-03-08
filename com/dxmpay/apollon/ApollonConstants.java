package com.dxmpay.apollon;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class ApollonConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APOLLON_PUBLIC_SHARE_PREF = "apollon_share";
    public static final String APOLLON_REST_TAG = "dxmpay_apollon_rest";
    public static final int AUTHLEVEL_CLIENT = 1;
    public static final int AUTHLEVEL_PUBLIC = 0;
    public static final int AUTHLEVEL_USER = 2;
    public static boolean DEBUG = false;
    public static final String ENCODE_GBK = "gbk";
    public static final String ENCODE_UTF_8 = "UTF-8";
    public static final String HTTP_REQUEST_TYPE_IMAGE_LOAD = "dxmpay image load http request";
    public static final String HTTP_REQUEST_TYPE_PAY_BEAN = "pay bean http request";
    public static final String HTTP_REQUEST_TYPE_STASTICS_BEAN = "sensor stastics bean http request";
    public static final boolean IS_WALLETAPP_PLUGIN = false;
    public static final int METHOD_HTTP_GET = 0;
    public static final int METHOD_HTTP_POST = 1;
    public static boolean RES_PARTITION_DEBUG = false;
    public static boolean WALLET_SPECIFIC = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-895498827, "Lcom/dxmpay/apollon/ApollonConstants;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-895498827, "Lcom/dxmpay/apollon/ApollonConstants;");
        }
    }

    public ApollonConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
