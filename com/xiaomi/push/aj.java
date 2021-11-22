package com.xiaomi.push;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
/* loaded from: classes2.dex */
public class aj extends ai.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ai f71578a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f115a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f116a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, ai.a aVar, boolean z, String str) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aiVar, aVar, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ai.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71578a = aiVar;
        this.f116a = z;
        this.f115a = str;
    }

    @Override // com.xiaomi.push.ai.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
        }
    }

    @Override // com.xiaomi.push.ai.b
    public void b() {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f116a) {
            return;
        }
        sharedPreferences = this.f71578a.f111a;
        sharedPreferences.edit().putLong(this.f115a, System.currentTimeMillis()).commit();
    }
}
