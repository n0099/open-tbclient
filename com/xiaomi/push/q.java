package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f78068a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f78069b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f78070c;

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
        this.f78068a = pVar;
        this.f832a = str;
        this.f78069b = str2;
        this.f78070c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = this.f78068a.f825a;
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f832a, 4).edit();
            edit.putString(this.f78069b, this.f78070c);
            edit.commit();
        }
    }
}
