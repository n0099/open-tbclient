package com.vivo.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public o c;

    public l(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.c = oVar;
        int b = oVar.b();
        this.b = b;
        if (b >= 0) {
            this.a = e.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
    }

    public abstract void a(o oVar);

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = this.a;
            if (context != null && !(this.c instanceof com.vivo.push.b.n)) {
                com.vivo.push.util.p.a(context, "[执行指令]" + this.c);
            }
            a(this.c);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("{");
            o oVar = this.c;
            sb.append(oVar == null ? "[null]" : oVar.toString());
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
