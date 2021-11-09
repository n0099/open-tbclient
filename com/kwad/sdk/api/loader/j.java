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

    /* renamed from: a  reason: collision with root package name */
    public final String f63952a;

    /* renamed from: b  reason: collision with root package name */
    public final String f63953b;

    /* renamed from: c  reason: collision with root package name */
    public final String f63954c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f63955d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f63956e;

    /* renamed from: f  reason: collision with root package name */
    public IKsAdSDK f63957f;

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
        this.f63952a = str;
        this.f63953b = str2;
        this.f63954c = str3;
    }

    public static synchronized j a(Context context, String str) {
        InterceptResult invokeLL;
        j a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            synchronized (j.class) {
                try {
                    a2 = a(context, g.d(context, str), g.e(context, str), g.f(context, str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return a2;
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
            Resources a2 = o.a(context, context.getResources(), this.f63952a);
            ClassLoader a3 = d.a(context, this.f63952a, this.f63953b, this.f63954c);
            IKsAdSDK a4 = Loader.a(a3);
            this.f63955d = a2;
            this.f63956e = a3;
            this.f63957f = a4;
            int sDKType = a4.getSDKType();
            int i2 = com.kwad.sdk.api.a.f63893a;
            if (sDKType == i2) {
                return;
            }
            throw new RuntimeException("sdkType error apiType: " + i2 + " , sdkType:" + sDKType);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (TextUtils.isEmpty(this.f63952a)) {
                throw new RuntimeException("mApk is null");
            }
            File file = new File(this.f63952a);
            if (!file.isFile() || !file.exists()) {
                throw new RuntimeException("mApk not a file");
            }
        }
    }

    public Resources a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63955d : (Resources) invokeV.objValue;
    }

    public ClassLoader b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63956e : (ClassLoader) invokeV.objValue;
    }

    public IKsAdSDK c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63957f : (IKsAdSDK) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ExternalPackage{mApk='" + this.f63952a + ExtendedMessageFormat.QUOTE + ", mDexDir='" + this.f63953b + ExtendedMessageFormat.QUOTE + ", mNativeLibDir='" + this.f63954c + ExtendedMessageFormat.QUOTE + ", mResource=" + this.f63955d + ", mClassLoader=" + this.f63956e + ", mKsSdk=" + this.f63957f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
