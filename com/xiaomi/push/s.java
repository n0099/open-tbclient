package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class s implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ r a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f1549a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public s(r rVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rVar;
        this.f1549a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = this.a.f1546a;
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f1549a, 4).edit();
            edit.putString(this.b, this.c);
            edit.commit();
        }
    }
}
