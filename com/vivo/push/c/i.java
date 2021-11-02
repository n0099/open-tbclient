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
    public final /* synthetic */ int f70262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f70263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f70264c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f70265d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f70266e;

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
        this.f70266e = hVar;
        this.f70262a = i2;
        this.f70263b = list;
        this.f70264c = list2;
        this.f70265d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f70266e;
            PushMessageCallback pushMessageCallback = ((ab) hVar).f70246b;
            context = hVar.f70428a;
            pushMessageCallback.onDelTags(context, this.f70262a, this.f70263b, this.f70264c, this.f70265d);
        }
    }
}
