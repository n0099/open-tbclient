package com.kwad.sdk.glide.f;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.c;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Object f37711b;

    public b(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37711b = j.a(obj);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageDigest) == null) {
            messageDigest.update(this.f37711b.toString().getBytes(c.f37921a));
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof b) {
                return this.f37711b.equals(((b) obj).f37711b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37711b.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ObjectKey{object=" + this.f37711b + '}';
        }
        return (String) invokeV.objValue;
    }
}
