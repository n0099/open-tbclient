package com.vivo.push.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class aa extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.b.t tVar = (com.vivo.push.b.t) oVar;
            ArrayList<String> d2 = tVar.d();
            List<String> e2 = tVar.e();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int h2 = tVar.h();
            String g2 = tVar.g();
            if (d2 != null) {
                for (String str : d2) {
                    if (str.startsWith("ali/")) {
                        arrayList2.add(str.replace("ali/", ""));
                    } else if (str.startsWith("tag/")) {
                        arrayList.add(str.replace("tag/", ""));
                    }
                }
            }
            if (e2 != null) {
                for (String str2 : e2) {
                    if (str2.startsWith("ali/")) {
                        arrayList4.add(str2.replace("ali/", ""));
                    } else if (str2.startsWith("tag/")) {
                        arrayList3.add(str2.replace("tag/", ""));
                    }
                }
            }
            if (arrayList.size() > 0 || arrayList3.size() > 0) {
                if (arrayList.size() > 0) {
                    com.vivo.push.e.a().a(arrayList);
                }
                com.vivo.push.e.a().a(tVar.g(), arrayList3.size() > 0 ? 10000 : h2);
                com.vivo.push.m.b(new ab(this, h2, arrayList, arrayList3, g2));
            }
            if (arrayList2.size() > 0 || arrayList4.size() > 0) {
                if (arrayList2.size() > 0) {
                    com.vivo.push.e.a().b((String) arrayList2.get(0));
                }
                com.vivo.push.e.a().a(tVar.g(), h2);
                com.vivo.push.m.b(new ac(this, h2, arrayList2, arrayList4, g2));
            }
        }
    }
}
