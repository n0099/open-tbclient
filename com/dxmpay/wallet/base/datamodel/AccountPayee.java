package com.dxmpay.wallet.base.datamodel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class AccountPayee implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAYEE_TYPE_BAIFUBAO = "1";
    public static final String PAYEE_TYPE_NONE_OF_BAIFUBAO_AND_PASSID = "3";
    public static final String PAYEE_TYPE_PASSID = "2";
    public static final long serialVersionUID = 4652827659433616918L;
    public transient /* synthetic */ FieldHolder $fh;
    public String notify_payee_mobile;
    public String notify_payee_mobile_back;
    public String payee_email;
    public String payee_err_info;
    public String payee_head_image;
    public String payee_mobile;
    public String payee_recv_type;
    public String payee_true_name;
    public String payee_username;

    public AccountPayee() {
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
