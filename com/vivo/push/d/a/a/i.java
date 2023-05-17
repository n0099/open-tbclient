package com.vivo.push.d.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.u;
/* loaded from: classes10.dex */
public final class i implements h<com.vivo.push.d.a.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public m b;
    public j c;
    public com.vivo.push.d.c.a d;

    public i(m mVar, j jVar, com.vivo.push.d.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar, jVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = mVar;
        this.c = jVar;
        this.d = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vivo.push.d.a.a.a, java.lang.Object, int] */
    @Override // com.vivo.push.d.a.a.h
    public final /* synthetic */ void a(a aVar, com.vivo.push.d.a.a aVar2, int i) {
        com.vivo.push.d.a.a aVar3 = aVar2;
        if (aVar3 == null) {
            u.a("onNodeError() receivedMsg is null ");
            return;
        }
        u.a("onNodeError() , msgID = " + aVar3.a() + ", nodeName = " + aVar.b());
        com.vivo.push.d.c.a aVar4 = this.d;
        if (aVar4 != null) {
            aVar4.a(i, aVar3.a());
        }
        a2(aVar3);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(com.vivo.push.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, aVar) != null) || aVar == null) {
            return;
        }
        if (!aVar.e()) {
            u.a("core is not support monitor report");
            return;
        }
        u.a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + aVar.f());
        if (aVar.f()) {
            m mVar = this.b;
            if (mVar != null) {
                mVar.a(aVar, this.a);
            }
            j jVar = this.c;
            if (jVar != null) {
                jVar.a(aVar, this.a.c().toString());
                u.a("reportNodeMonitorInfo() , report client NodeInfo！！！");
                return;
            }
            u.a("onNodeError , mReporter is null， can not report");
        }
    }

    @Override // com.vivo.push.d.a.a.h
    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.a = aVar;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.vivo.push.d.a.a.h
    public final /* bridge */ /* synthetic */ void a(com.vivo.push.d.a.a aVar) {
        com.vivo.push.d.a.a aVar2 = aVar;
        if (aVar2 == null) {
            u.a("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.a == null) {
            u.a("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(aVar2);
        }
    }
}
