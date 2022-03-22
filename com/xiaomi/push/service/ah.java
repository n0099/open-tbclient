package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gz;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class ah implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f868a;

    public ah(List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.f868a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b2;
        boolean b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b2 = ag.b("www.baidu.com:80");
            Iterator it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!b2) {
                    b3 = ag.b(str);
                    if (!b3) {
                        b2 = false;
                        if (!b2 && !this.f868a) {
                            break;
                        }
                    }
                }
                b2 = true;
                if (!b2) {
                }
            }
            gz.a(b2 ? 1 : 2);
        }
    }
}
