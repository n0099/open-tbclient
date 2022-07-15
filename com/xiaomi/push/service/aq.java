package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fj;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public final class aq implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f1626a;

    public aq(List list, boolean z) {
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
        this.f1626a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b = ap.b("www.baidu.com:80");
            Iterator it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!b) {
                    b2 = ap.b(str);
                    if (!b2) {
                        b = false;
                        if (!b && !this.f1626a) {
                            break;
                        }
                    }
                }
                b = true;
                if (!b) {
                }
            }
            fj.a(b ? 1 : 2);
        }
    }
}
