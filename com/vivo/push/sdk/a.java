package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.r;
import com.vivo.push.util.g;
import com.vivo.push.util.u;
/* loaded from: classes10.dex */
public final class a extends r {
    public static /* synthetic */ Interceptable $ic;
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

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
                return;
            }
        }
        this.d = "";
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
                aVar = c;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            if (intent != null && this.a != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                a(obtain);
                return;
            }
            u.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    @Override // com.vivo.push.r
    public final void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Intent intent = (Intent) message.obj;
            if (intent != null && this.a != null) {
                com.vivo.push.d.a.b bVar = new com.vivo.push.d.a.b(intent);
                try {
                    u.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
                    g.a().execute(new b(this, bVar));
                    return;
                } catch (Exception e) {
                    u.a("CommandWorker", "handle message err : " + e.getMessage());
                    return;
                }
            }
            u.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }
}
