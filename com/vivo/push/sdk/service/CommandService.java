package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.d.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.u;
/* loaded from: classes10.dex */
public class CommandService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommandService() {
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

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return "com.vivo.pushservice.action.RECEIVE".equals(str);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            u.c("CommandService", "onBind initSuc: ");
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
            return super.onUnbind(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
            super.onCreate();
            Context context = ContextDelegate.getContext(getApplicationContext());
            a.a().a(context);
            com.vivo.push.sdk.a.a().a(context);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, intent, i, i2)) == null) {
            u.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
            if (intent == null) {
                stopSelf();
                return 2;
            } else if (!a(intent.getAction())) {
                u.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
                stopSelf();
                return 2;
            } else {
                try {
                    com.vivo.push.sdk.a.a().a(getClass().getName());
                    com.vivo.push.sdk.a.a().a(intent);
                } catch (Exception e) {
                    u.a("CommandService", "onStartCommand -- error", e);
                }
                stopSelf();
                return 2;
            }
        }
        return invokeLII.intValue;
    }
}
