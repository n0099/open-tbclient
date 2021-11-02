package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f71361a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f833a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f71362b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f71363c;

    public q(p pVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pVar, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71361a = pVar;
        this.f833a = str;
        this.f71362b = str2;
        this.f71363c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = this.f71361a.f826a;
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f833a, 4).edit();
            edit.putString(this.f71362b, this.f71363c);
            edit.commit();
        }
    }
}
