package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class q implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f43526a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f828a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f43527b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f43528c;

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
        this.f43526a = pVar;
        this.f828a = str;
        this.f43527b = str2;
        this.f43528c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            context = this.f43526a.f821a;
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f828a, 4).edit();
            edit.putString(this.f43527b, this.f43528c);
            edit.commit();
        }
    }
}
