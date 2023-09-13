package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.d.c;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public static void a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, intent, iDataMessageCallBackService) == null) {
            if (context == null) {
                d.e("context is null , please check param of parseIntent()");
            } else if (intent == null) {
                d.e("intent is null , please check param of parseIntent()");
            } else if (iDataMessageCallBackService == null) {
                d.e("callback is null , please check param of parseIntent()");
            } else if (Utils.isSupportPushByClient(context)) {
                f.a(new Runnable(context, intent, iDataMessageCallBackService) { // from class: com.heytap.mcssdk.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;
                    public final /* synthetic */ Intent b;
                    public final /* synthetic */ IDataMessageCallBackService c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, intent, iDataMessageCallBackService};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = context;
                        this.b = intent;
                        this.c = iDataMessageCallBackService;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        List<BaseMode> a;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (a = c.a(this.a, this.b)) == null) {
                            return;
                        }
                        for (BaseMode baseMode : a) {
                            if (baseMode != null) {
                                for (com.heytap.mcssdk.e.c cVar : PushService.getInstance().getProcessors()) {
                                    if (cVar != null) {
                                        cVar.a(this.a, baseMode, this.c);
                                    }
                                }
                            }
                        }
                    }
                });
            } else {
                d.e("push is null ,please check system has push");
            }
        }
    }
}
