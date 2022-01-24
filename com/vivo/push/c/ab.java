package com.vivo.push.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes4.dex */
public final class ab implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f60701b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f60702c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60703d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ aa f60704e;

    public ab(aa aaVar, int i2, List list, List list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aaVar, Integer.valueOf(i2), list, list2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60704e = aaVar;
        this.a = i2;
        this.f60701b = list;
        this.f60702c = list2;
        this.f60703d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aa aaVar = this.f60704e;
            PushMessageCallback pushMessageCallback = ((z) aaVar).f60729b;
            context = aaVar.a;
            pushMessageCallback.onSetTags(context, this.a, this.f60701b, this.f60702c, this.f60703d);
        }
    }
}
