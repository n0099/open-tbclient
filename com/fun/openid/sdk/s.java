package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class s extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69872a;

    /* renamed from: b  reason: collision with root package name */
    public int f69873b;

    /* renamed from: c  reason: collision with root package name */
    public q f69874c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, int i2, String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qVar, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69874c = qVar;
        this.f69873b = i2;
        this.f69872a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (qVar = this.f69874c) == null) {
            return;
        }
        qVar.a(this.f69873b, this.f69872a);
    }
}
