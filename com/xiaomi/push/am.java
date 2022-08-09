package com.xiaomi.push;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
/* loaded from: classes8.dex */
public class am extends al.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ al a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f100a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f101a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, al.a aVar, boolean z, String str) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alVar, aVar, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((al.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = alVar;
        this.f101a = z;
        this.f100a = str;
    }

    @Override // com.xiaomi.push.al.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
        }
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f101a) {
            return;
        }
        sharedPreferences = this.a.f96a;
        sharedPreferences.edit().putLong(this.f100a, System.currentTimeMillis()).commit();
    }
}
