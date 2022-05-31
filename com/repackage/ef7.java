package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ef7 implements YYPayService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements n75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayService.YYPayResultCallback a;

        public a(ef7 ef7Var, YYPayService.YYPayResultCallback yYPayResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef7Var, yYPayResultCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayResultCallback;
        }

        @Override // com.repackage.n75
        public void a(s75 s75Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s75Var) == null) {
                if (s75Var != null) {
                    YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                    yYPayResultMessage.setStatus(s75Var.g);
                    yYPayResultMessage.setAppid(s75Var.b);
                    yYPayResultMessage.setUid(s75Var.h.longValue());
                    yYPayResultMessage.setUsedChannel(s75Var.i);
                    yYPayResultMessage.setCurrencyType(s75Var.d);
                    yYPayResultMessage.setAmount(s75Var.a.longValue());
                    yYPayResultMessage.setCurrencyAmount(s75Var.c.longValue());
                    yYPayResultMessage.setOrderId(s75Var.f);
                    yYPayResultMessage.setExpand(s75Var.e);
                    this.a.onSuccess(yYPayResultMessage);
                    return;
                }
                this.a.onSuccess(null);
            }
        }

        @Override // com.repackage.n75
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.onFail(i, str);
            }
        }
    }

    public ef7() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, yYPayResultCallback) == null) {
            startPayment(context, null, yYPayResultCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, yYPayResultCallback) == null) {
            startPayment(context, str, 0L, yYPayResultCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, Long l, YYPayService.YYPayResultCallback yYPayResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, l, yYPayResultCallback) == null) {
            MessageManager.getInstance().runTask(2921546, String.class, new r75(context, 1, str, l, new a(this, yYPayResultCallback)));
        }
    }
}
