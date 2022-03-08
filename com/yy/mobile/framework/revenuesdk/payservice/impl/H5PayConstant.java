package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class H5PayConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DxmKjLocalPageType = 2;
    public static final String EXTRA_APP_ID = "EXTRA_APP_ID";
    public static final int EXTRA_INVALID_ID = -1;
    public static final String EXTRA_LOCAL_PAGE_TYPE = "EXTRA_LOCAL_PAGE_TYPE";
    public static final String EXTRA_PAY_FLOW_TYPE_ID = "EXTRA_PAY_FLOW_TYPE_ID";
    public static final String EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME = "EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME";
    public static final String EXTRA_RIGHT = "EXTRA_RIGHT";
    public static final String EXTRA_RIGHT_URL = "EXTRA_RIGHT_URL";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_USER_CHANNEL = "EXTRA_USER_CHANNEL";
    public static final int MockTestPageType = 3;
    public static final int UnionPayPageType = 4;
    public static final int WalletLocalPageType = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public H5PayConstant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
