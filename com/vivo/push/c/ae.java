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
    public final /* synthetic */ int f76369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f76370b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f76371c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f76372d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f76373e;

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
        this.f76373e = acVar;
        this.f76369a = i2;
        this.f76370b = list;
        this.f76371c = list2;
        this.f76372d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f76373e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f76363b;
            context = acVar.f76547a;
            pushMessageCallback.onSetAlias(context, this.f76369a, this.f76370b, this.f76371c, this.f76372d);
        }
    }
}
