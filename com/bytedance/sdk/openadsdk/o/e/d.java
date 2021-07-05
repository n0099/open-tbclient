package com.bytedance.sdk.openadsdk.o.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.j;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import java.io.IOException;
/* loaded from: classes6.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IHttpStack f31607a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        IHttpStack a2 = com.bytedance.sdk.openadsdk.l.e.a();
        this.f31607a = a2;
        if (a2 == null) {
            this.f31607a = new j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.o.e.b
    public a a(f fVar) throws IOException, VAdError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            e eVar = new e(fVar.f31608a, fVar.f31609b);
            if (fVar.f31610c != -1) {
                eVar.setRetryPolicy(new com.bytedance.sdk.component.adnet.core.e().a((int) fVar.f31610c));
            }
            return new g(this.f31607a.performRequest(eVar, fVar.f31612e), fVar);
        }
        return (a) invokeL.objValue;
    }
}
