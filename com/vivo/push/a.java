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
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;
    public String b;
    public String c;

    public a(String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
        this.c = str2;
        this.a = bundle;
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

    public final int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            Bundle bundle = this.a;
            return bundle == null ? i : bundle.getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public final ArrayList<String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Bundle bundle = this.a;
            if (bundle == null) {
                return null;
            }
            return bundle.getStringArrayList(str);
        }
        return (ArrayList) invokeL.objValue;
    }

    public final Serializable d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Bundle bundle = this.a;
            if (bundle == null) {
                return null;
            }
            return bundle.getSerializable(str);
        }
        return (Serializable) invokeL.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Bundle bundle = this.a;
            if (bundle == null) {
                return false;
            }
            return bundle.getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public final byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Bundle bundle = this.a;
            if (bundle == null) {
                return null;
            }
            return bundle.getByteArray(str);
        }
        return (byte[]) invokeL.objValue;
    }

    public final long b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            Bundle bundle = this.a;
            return bundle == null ? j : bundle.getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public final Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (Bundle) invokeV.objValue;
    }

    public final void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putInt(str, i);
        }
    }

    public final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putLong(str, j);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putString(str, str2);
        }
    }

    public final void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bArr) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putByteArray(str, bArr);
        }
    }

    public final void a(String str, Serializable serializable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, serializable) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putSerializable(str, serializable);
        }
    }

    public final void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putBoolean(str, z);
        }
    }

    public final void a(String str, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, arrayList) == null) {
            if (this.a == null) {
                this.a = new Bundle();
            }
            this.a.putStringArrayList(str, arrayList);
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Bundle bundle = this.a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
    }
}
