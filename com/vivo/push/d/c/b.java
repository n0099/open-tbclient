package com.vivo.push.d.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.b.x;
import com.vivo.push.e;
import com.vivo.push.util.u;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.vivo.push.d.b.a a;

    public b(com.vivo.push.d.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    @Override // com.vivo.push.d.c.a
    public final void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            u.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i);
            if (i > 0 && !TextUtils.isEmpty(str)) {
                x xVar = new x(i);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", str);
                com.vivo.push.d.b.a aVar = this.a;
                if (aVar != null) {
                    String a = aVar.a();
                    if (!TextUtils.isEmpty(a)) {
                        hashMap.put("remoteAppId", a);
                    }
                }
                xVar.a(hashMap);
                e.a().a(xVar);
            }
        }
    }
}
