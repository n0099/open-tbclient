package com.vivo.push.d.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes8.dex */
public final class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent a;
    public String b;
    public com.vivo.push.d.d.a.a c;
    public String d;

    public b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "";
        this.d = "";
        this.a = intent;
    }

    @Override // com.vivo.push.d.a.a
    public final String a() {
        InterceptResult invokeV;
        long j;
        Bundle extras;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Intent intent = this.a;
            if (intent != null && (extras = intent.getExtras()) != null) {
                j = extras.getLong(Constants.EXTRA_NOTIFY_ID, 0L);
            } else {
                j = 0;
            }
            if (j != 0) {
                return String.valueOf(j);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.a.a
    public final Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.vivo.push.d.a.a
    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = this.a.getStringExtra("req_id");
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.a.a
    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Intent intent = this.a;
            if (intent == null) {
                return 0L;
            }
            return intent.getLongExtra("ipc_start_time", 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.vivo.push.d.a.a
    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Intent intent = this.a;
            if (intent == null) {
                return false;
            }
            return intent.getBooleanExtra("core_support_monitor", false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.vivo.push.d.a.a
    public final boolean f() {
        InterceptResult invokeV;
        Bundle extras;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Intent intent = this.a;
            if (intent == null || (extras = intent.getExtras()) == null) {
                return false;
            }
            return extras.getBoolean("client_collect_node", false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.vivo.push.d.a.a
    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.vivo.push.d.d.a.a h = h();
            if (h != null && h.a() == 2018) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.vivo.push.d.a.a
    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = this.a.getStringExtra("content");
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.d.a.a
    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = this.a;
            if (intent == null) {
                return -1;
            }
            int intExtra = intent.getIntExtra("command", -1);
            if (intExtra < 0) {
                return this.a.getIntExtra("method", -1);
            }
            return intExtra;
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.d.a.a
    public final com.vivo.push.d.d.a.a h() {
        InterceptResult invokeV;
        String stringExtra;
        com.vivo.push.d.d.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.c == null && (stringExtra = this.a.getStringExtra("cf_content")) != null) {
                try {
                    aVar = new com.vivo.push.d.d.a.a.a(stringExtra);
                } catch (JSONException unused) {
                    aVar = null;
                }
                if (aVar != null) {
                    this.c = com.vivo.push.d.d.a.a.a.a(aVar);
                }
            }
            return this.c;
        }
        return (com.vivo.push.d.d.a.a) invokeV.objValue;
    }
}
