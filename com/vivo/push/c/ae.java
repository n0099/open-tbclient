package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes6.dex */
public final class ae implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39336a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39337b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39338c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39339d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39340e;

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
        this.f39340e = acVar;
        this.f39336a = i2;
        this.f39337b = list;
        this.f39338c = list2;
        this.f39339d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f39340e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f39330b;
            context = acVar.f39512a;
            pushMessageCallback.onSetAlias(context, this.f39336a, this.f39337b, this.f39338c, this.f39339d);
        }
    }
}
