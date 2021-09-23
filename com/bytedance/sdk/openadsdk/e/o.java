package com.bytedance.sdk.openadsdk.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.e.g;
import com.bytedance.sdk.openadsdk.j.c.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class o extends g<c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.bytedance.sdk.openadsdk.core.p<a> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, String str2, e eVar, com.bytedance.sdk.openadsdk.core.p pVar, g.b bVar, g.a aVar) {
        super(str, str2, eVar, pVar, bVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, eVar, pVar, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (e) objArr2[2], (com.bytedance.sdk.openadsdk.core.p) objArr2[3], (g.b) objArr2[4], (g.a) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = com.bytedance.sdk.openadsdk.core.o.f();
        this.l = true;
    }

    @Override // com.bytedance.sdk.openadsdk.e.g
    public h a(List<c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (this.m == null) {
                this.m = com.bytedance.sdk.openadsdk.core.o.f();
            }
            if (list == null || list.size() == 0 || !com.bytedance.sdk.openadsdk.core.j.g.a()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                for (c.a aVar : list) {
                    jSONArray.put(aVar.f68271b);
                }
                jSONObject.put("stats_list", jSONArray);
            } catch (Exception unused) {
            }
            return this.m.a(jSONObject);
        }
        return (h) invokeL.objValue;
    }
}
