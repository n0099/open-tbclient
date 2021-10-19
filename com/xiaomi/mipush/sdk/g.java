package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hk;
import com.xiaomi.push.service.aq;
/* loaded from: classes10.dex */
public class g extends aq.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f77664a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i2, String str) {
        super(i2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77664a = fVar;
    }

    @Override // com.xiaomi.push.service.aq.a
    public void onCallback() {
        Context context;
        boolean z;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = this.f77664a.f93a;
            boolean a2 = com.xiaomi.push.service.aq.a(context).a(hk.ao.a(), true);
            z = this.f77664a.f96a;
            if (z != a2) {
                this.f77664a.f96a = a2;
                context2 = this.f77664a.f93a;
                i.b(context2);
            }
        }
    }
}
