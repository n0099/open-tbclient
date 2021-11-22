package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes2.dex */
public final class i implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f71181a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f71182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f71183c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f71184d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f71185e;

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
        this.f71185e = hVar;
        this.f71181a = i2;
        this.f71182b = list;
        this.f71183c = list2;
        this.f71184d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f71185e;
            PushMessageCallback pushMessageCallback = ((ab) hVar).f71165b;
            context = hVar.f71347a;
            pushMessageCallback.onDelTags(context, this.f71181a, this.f71182b, this.f71183c, this.f71184d);
        }
    }
}
