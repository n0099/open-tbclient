package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ac implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f43857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f43858c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f43859d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f43860e;

    public ac(aa aaVar, int i, List list, List list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aaVar, Integer.valueOf(i), list, list2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43860e = aaVar;
        this.a = i;
        this.f43857b = list;
        this.f43858c = list2;
        this.f43859d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aa aaVar = this.f43860e;
            PushMessageCallback pushMessageCallback = ((z) aaVar).f43881b;
            context = aaVar.a;
            pushMessageCallback.onSetAlias(context, this.a, this.f43857b, this.f43858c, this.f43859d);
        }
    }
}
