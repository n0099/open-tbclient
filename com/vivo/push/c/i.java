package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f43864b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f43865c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f43866d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f43867e;

    public i(h hVar, int i, List list, List list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Integer.valueOf(i), list, list2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43867e = hVar;
        this.a = i;
        this.f43864b = list;
        this.f43865c = list2;
        this.f43866d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f43867e;
            PushMessageCallback pushMessageCallback = ((z) hVar).f43881b;
            context = hVar.a;
            pushMessageCallback.onDelTags(context, this.a, this.f43864b, this.f43865c, this.f43866d);
        }
    }
}
