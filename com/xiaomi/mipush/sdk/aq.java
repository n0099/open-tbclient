package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.bg;
import com.xiaomi.push.service.bc;
/* loaded from: classes8.dex */
public class aq extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f42768a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(an anVar, Handler handler) {
        super(handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {anVar, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42768a = anVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            an anVar = this.f42768a;
            context = anVar.f67a;
            anVar.f71a = Integer.valueOf(bc.a(context).a());
            num = this.f42768a.f71a;
            if (num.intValue() != 0) {
                context2 = this.f42768a.f67a;
                context2.getContentResolver().unregisterContentObserver(this);
                context3 = this.f42768a.f67a;
                if (bg.b(context3)) {
                    this.f42768a.m108c();
                }
            }
        }
    }
}
