package com.vivo.push.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.u;
/* loaded from: classes8.dex */
public final class e extends a<com.vivo.push.d.a.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.vivo.push.d.a.a aVar, h hVar) {
        super("ClientDispatchNode", aVar, hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], objArr2[1], (h) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static int a2(com.vivo.push.d.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            PushMessageCallback b = b(aVar);
            if (b == null) {
                return 2804;
            }
            if (aVar != null && aVar.g()) {
                com.vivo.push.d.d.d.a().a(aVar);
                return 0;
            }
            try {
                return com.vivo.push.e.a().a(aVar.b(), b);
            } catch (Exception unused) {
                return 2808;
            }
        }
        return invokeL.intValue;
    }

    public static PushMessageCallback b(com.vivo.push.d.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            try {
                return (PushMessageCallback) Class.forName(com.vivo.push.d.a.a().e().a(com.vivo.push.d.a.a().b(), aVar.b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                u.b("DispatchNode", "reflect e: ", e);
                return null;
            }
        }
        return (PushMessageCallback) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.vivo.push.d.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.d.a.a aVar) {
        return a2(aVar);
    }
}
