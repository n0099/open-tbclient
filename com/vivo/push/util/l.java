package com.vivo.push.util;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.c.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;
/* loaded from: classes7.dex */
public final class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ List a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f43962b;

    public l(k kVar, List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43962b = kVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j2;
        int i;
        r.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            insideNotificationItem = this.f43962b.f43957b;
            if (insideNotificationItem != null) {
                x b2 = x.b();
                j = this.f43962b.f43958c;
                b2.a("com.vivo.push.notify_key", j);
                context = this.f43962b.a;
                List list = this.a;
                insideNotificationItem2 = this.f43962b.f43957b;
                j2 = this.f43962b.f43958c;
                i = this.f43962b.f43960e;
                aVar = this.f43962b.f43961f;
                NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, aVar);
            }
        }
    }
}
