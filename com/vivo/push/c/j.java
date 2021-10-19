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
    public final /* synthetic */ int f76918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f76919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f76920c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f76921d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f76922e;

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
        this.f76922e = hVar;
        this.f76918a = i2;
        this.f76919b = list;
        this.f76920c = list2;
        this.f76921d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h hVar = this.f76922e;
            PushMessageCallback pushMessageCallback = ((ab) hVar).f76897b;
            context = hVar.f77081a;
            pushMessageCallback.onDelAlias(context, this.f76918a, this.f76919b, this.f76920c, this.f76921d);
        }
    }
}
