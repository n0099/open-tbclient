package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes8.dex */
public final class ab implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f59218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f59219c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f59220d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f59221e;

    public ab(aa aaVar, int i2, List list, List list2, String str) {
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
        this.f59221e = aaVar;
        this.a = i2;
        this.f59218b = list;
        this.f59219c = list2;
        this.f59220d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aa aaVar = this.f59221e;
            PushMessageCallback pushMessageCallback = ((z) aaVar).f59246b;
            context = aaVar.a;
            pushMessageCallback.onSetTags(context, this.a, this.f59218b, this.f59219c, this.f59220d);
        }
    }
}
