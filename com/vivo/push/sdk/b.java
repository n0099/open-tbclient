package com.vivo.push.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.p;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Method a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f62528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f62529c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f62530d;

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
        this.f62530d = aVar;
        this.a = method;
        this.f62528b = obj;
        this.f62529c = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.a.invoke(this.f62528b, this.f62529c);
            } catch (Exception e2) {
                p.b("CommandWorker", "reflect e: ", e2);
            }
        }
    }
}
