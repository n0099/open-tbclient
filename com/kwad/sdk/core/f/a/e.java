package com.kwad.sdk.core.f.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64553a;

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64553a = context;
    }

    public String a() {
        InterceptResult invokeV;
        String str;
        Bundle call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            str = "";
            try {
                Uri parse = Uri.parse("content://cn.nubia.identity/identity");
                if (Build.VERSION.SDK_INT > 17) {
                    ContentProviderClient acquireContentProviderClient = this.f64553a.getContentResolver().acquireContentProviderClient(parse);
                    call = acquireContentProviderClient.call("getOAID", null, null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    call = this.f64553a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
                }
                if (call != null) {
                    str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                    String string = call.getString("message");
                    com.kwad.sdk.core.d.a.c("NubiaDeviceIDHelper", "getOAID oaid:" + str + "faledMsg:" + string);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.c("NubiaDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.a.b(e2);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
