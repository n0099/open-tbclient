package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes10.dex */
public final class ad implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f76364a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f76365b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f76366c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f76367d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f76368e;

    public ad(ac acVar, int i2, List list, List list2, String str) {
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
        this.f76368e = acVar;
        this.f76364a = i2;
        this.f76365b = list;
        this.f76366c = list2;
        this.f76367d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f76368e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f76363b;
            context = acVar.f76547a;
            pushMessageCallback.onSetTags(context, this.f76364a, this.f76365b, this.f76366c, this.f76367d);
        }
    }
}
