package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes4.dex */
public final class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f63044b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f63045c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f63046d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f63047e;

    public i(h hVar, int i2, List list, List list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i2), list, list2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63047e = hVar;
        this.a = i2;
        this.f63044b = list;
        this.f63045c = list2;
        this.f63046d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f63047e;
            PushMessageCallback pushMessageCallback = ((z) hVar).f63061b;
            context = hVar.a;
            pushMessageCallback.onDelTags(context, this.a, this.f63044b, this.f63045c, this.f63046d);
        }
    }
}
