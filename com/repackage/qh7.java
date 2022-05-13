package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qh7 implements YYPayService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements t85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayService.YYPayResultCallback a;

        public a(qh7 qh7Var, YYPayService.YYPayResultCallback yYPayResultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qh7Var, yYPayResultCallback};
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

        @Override // com.repackage.t85
        public void a(y85 y85Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y85Var) == null) {
                if (y85Var != null) {
                    YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                    yYPayResultMessage.setStatus(y85Var.g);
                    yYPayResultMessage.setAppid(y85Var.b);
                    yYPayResultMessage.setUid(y85Var.h.longValue());
                    yYPayResultMessage.setUsedChannel(y85Var.i);
                    yYPayResultMessage.setCurrencyType(y85Var.d);
                    yYPayResultMessage.setAmount(y85Var.a.longValue());
                    yYPayResultMessage.setCurrencyAmount(y85Var.c.longValue());
                    yYPayResultMessage.setOrderId(y85Var.f);
                    yYPayResultMessage.setExpand(y85Var.e);
                    this.a.onSuccess(yYPayResultMessage);
                    return;
                }
                this.a.onSuccess(null);
            }
        }

        @Override // com.repackage.t85
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.onFail(i, str);
            }
        }
    }

    public qh7() {
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
            MessageManager.getInstance().runTask(2921546, String.class, new x85(context, 1, str, l, new a(this, yYPayResultCallback)));
        }
    }
}
