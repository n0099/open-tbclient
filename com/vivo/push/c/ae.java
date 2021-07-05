package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f42101a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f42102b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f42103c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f42104d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f42105e;

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
        this.f42105e = acVar;
        this.f42101a = i2;
        this.f42102b = list;
        this.f42103c = list2;
        this.f42104d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f42105e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f42095b;
            context = acVar.f42277a;
            pushMessageCallback.onSetAlias(context, this.f42101a, this.f42102b, this.f42103c, this.f42104d);
        }
    }
}
