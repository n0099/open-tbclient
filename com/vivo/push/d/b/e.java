package com.vivo.push.d.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class e implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.vivo.push.util.o
    public final List<String> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            k.a("findAllCoreClientPush");
            List<ResolveInfo> list = null;
            if (!com.vivo.push.d.a.a().e().m()) {
                u.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), 576);
            } catch (Exception unused) {
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ResolveInfo resolveInfo = list.get(i);
                    if (resolveInfo != null) {
                        String str = resolveInfo.serviceInfo.packageName;
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            if (arrayList.size() <= 0) {
                u.d("PushSystemRelyImpl", "get all push packages is null");
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
