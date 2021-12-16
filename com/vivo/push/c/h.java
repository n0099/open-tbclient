package com.vivo.push.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class h extends ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(com.vivo.push.y yVar) {
        super(yVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.y) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            com.vivo.push.b.v vVar = (com.vivo.push.b.v) yVar;
            ArrayList<String> d2 = vVar.d();
            List<String> e2 = vVar.e();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int h2 = vVar.h();
            String g2 = vVar.g();
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
                    com.vivo.push.p.a().b(arrayList);
                }
                com.vivo.push.p.a().a(vVar.g(), arrayList3.size() > 0 ? 10000 : h2);
                com.vivo.push.w.b(new i(this, h2, arrayList, arrayList3, g2));
            }
            if (arrayList2.size() > 0 || arrayList4.size() > 0) {
                if (arrayList2.size() > 0) {
                    com.vivo.push.p.a().c(arrayList2);
                }
                com.vivo.push.p.a().a(vVar.g(), h2);
                com.vivo.push.w.b(new j(this, h2, arrayList2, arrayList4, g2));
            }
        }
    }
}
