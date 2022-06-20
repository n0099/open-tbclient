package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cj;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class cc implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<Context> f153a;

    public cc(String str, WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, weakReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f153a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        WeakReference<Context> weakReference;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakReference = this.f153a) == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cp.a(this.a) <= cb.f151a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cf a = cf.a(this.a);
        ce a2 = ce.a(this.a);
        a.a(a2);
        a2.a(cd.a(context, this.a, 1000));
        cj.a(context).a((cj.a) a);
    }
}
