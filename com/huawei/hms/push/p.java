package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class p extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public k b;

    public p(Context context, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = kVar;
    }

    public static Intent a(Context context, k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, kVar)) == null) {
            if (kVar == null) {
                return null;
            }
            Intent b = q.b(context, kVar.d());
            if (kVar.n() != null) {
                try {
                    Intent parseUri = Intent.parseUri(kVar.n(), 0);
                    parseUri.setSelector(null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Intent.parseUri(msg.intentUri, 0), action:");
                    sb.append(parseUri.getAction());
                    HMSLog.d("PushSelfShowLog", sb.toString());
                    if (q.a(context, kVar.d(), parseUri).booleanValue()) {
                        return parseUri;
                    }
                    return b;
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
                    return b;
                }
            }
            if (kVar.a() != null) {
                Intent intent = new Intent(kVar.a());
                if (q.a(context, kVar.d(), intent).booleanValue()) {
                    b = intent;
                }
            }
            b.setPackage(kVar.d());
            return b;
        }
        return (Intent) invokeLL.objValue;
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return q.c(context, this.b.d());
        }
        return invokeL.booleanValue;
    }

    public final boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if ("cosa".equals(this.b.i())) {
                return a(context);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean b(Context context, k kVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, kVar)) == null) {
            if ("cosa".equals(kVar.i()) && a(context, kVar) == null) {
                HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HMSLog.i("PushSelfShowLog", "enter run()");
            try {
                if (!b(this.a) || b(this.a, this.b)) {
                    return;
                }
                o.a(this.a, this.b);
            } catch (Exception e) {
                HMSLog.e("PushSelfShowLog", e.toString());
            }
        }
    }
}
