package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f57007b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57008c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f57009d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f57010e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f57011f;

    public j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f57007b = str2;
        this.f57008c = str3;
    }

    public static synchronized j a(Context context, String str) {
        InterceptResult invokeLL;
        j a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            synchronized (j.class) {
                try {
                    a = a(context, g.d(context, str), g.e(context, str), g.f(context, str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return a;
        }
        return (j) invokeLL.objValue;
    }

    public static j a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("mApk is null");
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                j jVar = new j(str, str2, str3);
                jVar.a(context);
                return jVar;
            }
            throw new RuntimeException("mApk not a file");
        }
        return (j) invokeLLLL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            d();
            Resources a = o.a(context, context.getResources(), this.a);
            ClassLoader a2 = d.a(context, this.a, this.f57007b, this.f57008c);
            IKsAdSDK a3 = Loader.a(a2);
            this.f57009d = a;
            this.f57010e = a2;
            this.f57011f = a3;
            int sDKType = a3.getSDKType();
            if (sDKType == 1) {
                return;
            }
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (TextUtils.isEmpty(this.a)) {
                throw new RuntimeException("mApk is null");
            }
            File file = new File(this.a);
            if (!file.isFile() || !file.exists()) {
                throw new RuntimeException("mApk not a file");
            }
        }
    }

    public Resources a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57009d : (Resources) invokeV.objValue;
    }

    public ClassLoader b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57010e : (ClassLoader) invokeV.objValue;
    }

    public IKsAdSDK c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57011f : (IKsAdSDK) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ExternalPackage{mApk='" + this.a + ExtendedMessageFormat.QUOTE + ", mDexDir='" + this.f57007b + ExtendedMessageFormat.QUOTE + ", mNativeLibDir='" + this.f57008c + ExtendedMessageFormat.QUOTE + ", mResource=" + this.f57009d + ", mClassLoader=" + this.f57010e + ", mKsSdk=" + this.f57011f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
