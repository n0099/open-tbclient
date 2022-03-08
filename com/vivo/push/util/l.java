package com.vivo.push.util;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.c.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;
/* loaded from: classes8.dex */
public final class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f59331b;

    public l(k kVar, List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59331b = kVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j2;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j3;
        int i2;
        r.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            insideNotificationItem = this.f59331b.f59326b;
            if (insideNotificationItem != null) {
                x b2 = x.b();
                j2 = this.f59331b.f59327c;
                b2.a("com.vivo.push.notify_key", j2);
                context = this.f59331b.a;
                List list = this.a;
                insideNotificationItem2 = this.f59331b.f59326b;
                j3 = this.f59331b.f59327c;
                i2 = this.f59331b.f59329e;
                aVar = this.f59331b.f59330f;
                NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j3, i2, aVar);
            }
        }
    }
}
