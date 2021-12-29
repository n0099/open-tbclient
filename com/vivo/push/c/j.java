package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes4.dex */
public final class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f63048b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f63049c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f63050d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f63051e;

    public j(h hVar, int i2, List list, List list2, String str) {
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
        this.f63051e = hVar;
        this.a = i2;
        this.f63048b = list;
        this.f63049c = list2;
        this.f63050d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f63051e;
            PushMessageCallback pushMessageCallback = ((z) hVar).f63061b;
            context = hVar.a;
            pushMessageCallback.onDelAlias(context, this.a, this.f63048b, this.f63049c, this.f63050d);
        }
    }
}
