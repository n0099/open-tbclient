package com.xiaomi.push;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cg;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class bz implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f70736a;

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
        this.f70736a = str;
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
        if (cm.a(this.f70736a) <= by.f172a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cc a2 = cc.a(this.f70736a);
        cb a3 = cb.a(this.f70736a);
        a2.a(a3);
        a3.a(ca.a(context, this.f70736a, 1000));
        cg.a(context).a((cg.a) a2);
    }
}
