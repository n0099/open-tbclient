package com.vivo.push.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f39443a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f39444b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f39445c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f39446d;

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
        this.f39446d = aVar;
        this.f39443a = method;
        this.f39444b = obj;
        this.f39445c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.f39443a.invoke(this.f39444b, this.f39445c);
            } catch (Exception e2) {
                p.b("CommandWorker", "reflect e: ", e2);
            }
        }
    }
}
