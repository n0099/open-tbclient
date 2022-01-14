package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes4.dex */
public final class ac implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f60660b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f60661c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60662d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f60663e;

    public ac(aa aaVar, int i2, List list, List list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aaVar, Integer.valueOf(i2), list, list2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60663e = aaVar;
        this.a = i2;
        this.f60660b = list;
        this.f60661c = list2;
        this.f60662d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aa aaVar = this.f60663e;
            PushMessageCallback pushMessageCallback = ((z) aaVar).f60684b;
            context = aaVar.a;
            pushMessageCallback.onSetAlias(context, this.a, this.f60660b, this.f60661c, this.f60662d);
        }
    }
}
