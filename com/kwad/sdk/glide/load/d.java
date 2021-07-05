package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.j;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class d<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a<Object> f37922a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final T f37923b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f37924c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37925d;

    /* renamed from: e  reason: collision with root package name */
    public volatile byte[] f37926e;

    /* loaded from: classes7.dex */
    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-138458437, "Lcom/kwad/sdk/glide/load/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-138458437, "Lcom/kwad/sdk/glide/load/d;");
                return;
            }
        }
        f37922a = new a<Object>() { // from class: com.kwad.sdk.glide.load.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.glide.load.d.a
            public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bArr, obj, messageDigest) == null) {
                }
            }
        };
    }

    public d(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, t, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37925d = j.a(str);
        this.f37923b = t;
        this.f37924c = (a) j.a(aVar);
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new d<>(str, null, c()) : (d) invokeL.objValue;
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str, @NonNull T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, t)) == null) ? new d<>(str, t, c()) : (d) invokeLL.objValue;
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, str, t, aVar)) == null) ? new d<>(str, t, aVar) : (d) invokeLLL.objValue;
    }

    @NonNull
    private byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.f37926e == null) {
                this.f37926e = this.f37925d.getBytes(c.f37921a);
            }
            return this.f37926e;
        }
        return (byte[]) invokeV.objValue;
    }

    @NonNull
    public static <T> a<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (a<T>) f37922a : (a) invokeV.objValue;
    }

    @Nullable
    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37923b : (T) invokeV.objValue;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, messageDigest) == null) {
            this.f37924c.a(b(), t, messageDigest);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof d) {
                return this.f37925d.equals(((d) obj).f37925d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37925d.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "Option{key='" + this.f37925d + "'}";
        }
        return (String) invokeV.objValue;
    }
}
