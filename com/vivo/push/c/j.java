package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes10.dex */
public final class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f76564a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f76565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f76566c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f76567d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f76568e;

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
        this.f76568e = hVar;
        this.f76564a = i2;
        this.f76565b = list;
        this.f76566c = list2;
        this.f76567d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f76568e;
            PushMessageCallback pushMessageCallback = ((ab) hVar).f76543b;
            context = hVar.f76727a;
            pushMessageCallback.onDelAlias(context, this.f76564a, this.f76565b, this.f76566c, this.f76567d);
        }
    }
}
