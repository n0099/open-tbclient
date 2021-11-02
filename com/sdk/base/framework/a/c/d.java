package com.sdk.base.framework.a.c;

import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class d extends h<Params, Result> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ c f68118b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super((byte) 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Byte) newInitContext.callArgs[0]).byteValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68118b = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, Result] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public final Result call() {
        InterceptResult invokeV;
        AtomicBoolean atomicBoolean;
        ?? a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            atomicBoolean = this.f68118b.f68116g;
            atomicBoolean.set(true);
            Process.setThreadPriority(10);
            c cVar = this.f68118b;
            a2 = cVar.a((c) cVar.b(this.f68122a));
            return a2;
        }
        return invokeV.objValue;
    }
}
