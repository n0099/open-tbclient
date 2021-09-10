package com.vivo.push;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class v implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76727a;

    /* renamed from: b  reason: collision with root package name */
    public int f76728b;

    /* renamed from: c  reason: collision with root package name */
    public y f76729c;

    public v(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76728b = -1;
        this.f76729c = yVar;
        int b2 = yVar.b();
        this.f76728b = b2;
        if (b2 >= 0) {
            this.f76727a = p.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76728b : invokeV.intValue;
    }

    public abstract void a(y yVar);

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = this.f76727a;
            if (context != null && !(this.f76729c instanceof com.vivo.push.b.p)) {
                com.vivo.push.util.p.a(context, "[执行指令]" + this.f76729c);
            }
            a(this.f76729c);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(StringUtil.ARRAY_START);
            y yVar = this.f76729c;
            sb.append(yVar == null ? "[null]" : yVar.toString());
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
