package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
public final class ad implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f62453c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62454d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f62455e;

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
        this.f62455e = acVar;
        this.a = i2;
        this.f62452b = list;
        this.f62453c = list2;
        this.f62454d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f62455e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f62451b;
            context = acVar.a;
            pushMessageCallback.onSetTags(context, this.a, this.f62452b, this.f62453c, this.f62454d);
        }
    }
}
