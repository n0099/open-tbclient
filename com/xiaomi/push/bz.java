package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cg;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class bz implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<Context> f174a;

    public bz(String str, WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, weakReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f174a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        WeakReference<Context> weakReference;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakReference = this.f174a) == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cm.a(this.a) <= by.f172a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cc a = cc.a(this.a);
        cb a2 = cb.a(this.a);
        a.a(a2);
        a2.a(ca.a(context, this.a, 1000));
        cg.a(context).a((cg.a) a);
    }
}
