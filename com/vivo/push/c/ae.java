package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes2.dex */
public final class ae implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f71171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f71172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f71173c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f71174d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f71175e;

    public ae(ac acVar, int i2, List list, List list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {acVar, Integer.valueOf(i2), list, list2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71175e = acVar;
        this.f71171a = i2;
        this.f71172b = list;
        this.f71173c = list2;
        this.f71174d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f71175e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f71165b;
            context = acVar.f71347a;
            pushMessageCallback.onSetAlias(context, this.f71171a, this.f71172b, this.f71173c, this.f71174d);
        }
    }
}
