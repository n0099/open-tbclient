package com.vivo.push.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f42208a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f42209b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f42210c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f42211d;

    public b(a aVar, Method method, Object obj, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {aVar, method, obj, objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42211d = aVar;
        this.f42208a = method;
        this.f42209b = obj;
        this.f42210c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.f42208a.invoke(this.f42209b, this.f42210c);
            } catch (Exception e2) {
                p.b("CommandWorker", "reflect e: ", e2);
            }
        }
    }
}
