package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.zzj;
/* loaded from: classes5.dex */
public abstract class bk9<T extends IInterface> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final Handler b;
    @Nullable
    public volatile zzj c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755823967, "Lcom/repackage/bk9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755823967, "Lcom/repackage/bk9;");
        }
    }

    public static /* bridge */ /* synthetic */ void c(bk9 bk9Var, zzj zzjVar) {
        bk9Var.c = zzjVar;
        if (bk9Var.b()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.zzd;
            ek9.a().b(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza());
        }
    }

    public void a(int i, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), iBinder, bundle, Integer.valueOf(i2)}) == null) {
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage(1, i2, -1, new mk9(this, i, iBinder, bundle)));
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (Context) invokeV.objValue;
    }
}
