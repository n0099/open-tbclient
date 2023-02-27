package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes8.dex */
public final class p extends com.vivo.push.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public byte[] c;
    public long d;
    public InsideNotificationItem e;
    public String f;
    public String g;
    public Uri h;
    public String i;
    public Bundle j;

    @Override // com.vivo.push.o
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "OnNotificationClickCommand" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p() {
        super(5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public final InsideNotificationItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (InsideNotificationItem) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final Uri j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return (Uri) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), insideNotificationItem};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.d = j;
        this.e = insideNotificationItem;
    }

    public static Uri e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Uri.parse(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Uri) invokeL.objValue;
    }

    public final void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uri) == null) {
            this.h = uri;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f = str;
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.g = str;
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = str;
        }
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            aVar.a("package_name", this.a);
            aVar.a(Constants.EXTRA_NOTIFY_ID, this.d);
            aVar.a("notification_v1", com.vivo.push.util.v.b(this.e));
            aVar.a("open_pkg_name", this.b);
            aVar.a("open_pkg_name_encode", this.c);
            aVar.a("notify_action", this.f);
            aVar.a("notify_componet_pkg", this.g);
            aVar.a("notify_componet_class_name", this.i);
            Uri uri = this.h;
            if (uri != null) {
                aVar.a("notify_uri_data", uri.toString());
            }
        }
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.a = aVar.a("package_name");
            this.d = aVar.b(Constants.EXTRA_NOTIFY_ID, -1L);
            this.b = aVar.a("open_pkg_name");
            this.c = aVar.b("open_pkg_name_encode");
            this.f = aVar.a("notify_action");
            this.g = aVar.a("notify_componet_pkg");
            this.i = aVar.a("notify_componet_class_name");
            String a = aVar.a("notification_v1");
            if (!TextUtils.isEmpty(a)) {
                this.e = com.vivo.push.util.v.a(a);
            }
            InsideNotificationItem insideNotificationItem = this.e;
            if (insideNotificationItem != null) {
                insideNotificationItem.setMsgId(this.d);
            }
            String a2 = aVar.a("notify_uri_data");
            if (!TextUtils.isEmpty(a2)) {
                this.h = e(a2);
            }
            this.j = aVar.b();
        }
    }

    public final Bundle k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.j == null) {
                return null;
            }
            Bundle bundle = new Bundle(this.j);
            try {
                bundle.remove("command_type");
                bundle.remove("security_avoid_pull");
                bundle.remove("security_avoid_pull_rsa");
                bundle.remove("security_avoid_rsa_public_key");
                bundle.remove("security_avoid_rsa_public_key");
                bundle.remove("notify_action");
                bundle.remove("notify_componet_pkg");
                bundle.remove("notify_componet_class_name");
                bundle.remove("notification_v1");
                bundle.remove("command");
                bundle.remove("package_name");
                bundle.remove("method");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }
}
