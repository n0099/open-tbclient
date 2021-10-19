package com.vivo.push;

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
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f76834a;

    /* renamed from: b  reason: collision with root package name */
    public String f76835b;

    /* renamed from: c  reason: collision with root package name */
    public String f76836c;

    public a(String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76835b = str;
        this.f76836c = str2;
        this.f76834a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Intent intent) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null) {
                com.vivo.push.util.p.a("BundleWapper", "create error : intent is null");
                return null;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                str = extras.getString("client_pkgname");
            }
            str = null;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.b("BundleWapper", "create warning: pkgName is null");
            }
            String str2 = intent.getPackage();
            if (TextUtils.isEmpty(str2)) {
                String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
                if (TextUtils.isEmpty(packageName)) {
                    com.vivo.push.util.p.b("BundleWapper", "create warning: targetPkgName is null");
                }
                str2 = packageName;
            }
            return new a(str, str2, extras);
        }
        return (a) invokeL.objValue;
    }

    public final int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            Bundle bundle = this.f76834a;
            return bundle == null ? i2 : bundle.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public final Serializable c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Bundle bundle = this.f76834a;
            if (bundle == null) {
                return null;
            }
            return bundle.getSerializable(str);
        }
        return (Serializable) invokeL.objValue;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Bundle bundle = this.f76834a;
            if (bundle == null) {
                return false;
            }
            return bundle.getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public final ArrayList<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            Bundle bundle = this.f76834a;
            if (bundle == null) {
                return null;
            }
            return bundle.getStringArrayList(str);
        }
        return (ArrayList) invokeL.objValue;
    }

    public final long b(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) {
            Bundle bundle = this.f76834a;
            return bundle == null ? j2 : bundle.getLong(str, j2);
        }
        return invokeLJ.longValue;
    }

    public final Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f76834a : (Bundle) invokeV.objValue;
    }

    public final void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            if (this.f76834a == null) {
                this.f76834a = new Bundle();
            }
            this.f76834a.putInt(str, i2);
        }
    }

    public final void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j2) == null) {
            if (this.f76834a == null) {
                this.f76834a = new Bundle();
            }
            this.f76834a.putLong(str, j2);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            if (this.f76834a == null) {
                this.f76834a = new Bundle();
            }
            this.f76834a.putString(str, str2);
        }
    }

    public final void a(String str, Serializable serializable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, serializable) == null) {
            if (this.f76834a == null) {
                this.f76834a = new Bundle();
            }
            this.f76834a.putSerializable(str, serializable);
        }
    }

    public final void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            if (this.f76834a == null) {
                this.f76834a = new Bundle();
            }
            this.f76834a.putBoolean(str, z);
        }
    }

    public final void a(String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, arrayList) == null) {
            if (this.f76834a == null) {
                this.f76834a = new Bundle();
            }
            this.f76834a.putStringArrayList(str, arrayList);
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Bundle bundle = this.f76834a;
            if (bundle == null) {
                return null;
            }
            return bundle.getString(str);
        }
        return (String) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76835b : (String) invokeV.objValue;
    }
}
