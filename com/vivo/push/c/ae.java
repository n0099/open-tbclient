package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes10.dex */
public final class ae implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f76549a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f76550b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f76551c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f76552d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f76553e;

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
        this.f76553e = acVar;
        this.f76549a = i2;
        this.f76550b = list;
        this.f76551c = list2;
        this.f76552d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f76553e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f76543b;
            context = acVar.f76727a;
            pushMessageCallback.onSetAlias(context, this.f76549a, this.f76550b, this.f76551c, this.f76552d);
        }
    }
}
