package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import java.util.Map;
/* loaded from: classes8.dex */
public class ak extends ai.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ai a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ai aiVar, ai.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aiVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ai.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aiVar;
    }

    @Override // com.xiaomi.push.ai.b
    public void b() {
        Object obj;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            obj = this.a.f88a;
            synchronized (obj) {
                map = this.a.f89a;
                map.remove(super.a.mo222a());
            }
        }
    }
}
