package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f42096a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f42097b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f42098c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f42099d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f42100e;

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
        this.f42100e = acVar;
        this.f42096a = i2;
        this.f42097b = list;
        this.f42098c = list2;
        this.f42099d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac acVar = this.f42100e;
            PushMessageCallback pushMessageCallback = ((ab) acVar).f42095b;
            context = acVar.f42277a;
            pushMessageCallback.onSetTags(context, this.f42096a, this.f42097b, this.f42098c, this.f42099d);
        }
    }
}
