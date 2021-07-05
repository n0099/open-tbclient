package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f34916c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f34917a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f34918b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34916c == null) {
                synchronized (a.class) {
                    if (f34916c == null) {
                        f34916c = new a();
                    }
                }
            }
            return f34916c;
        }
        return (a) invokeV.objValue;
    }

    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        if (this.f34917a == null) {
            this.f34917a = new ArrayList();
        }
        this.f34917a.clear();
        this.f34917a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34917a : (List) invokeV.objValue;
    }

    public void b(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        if (this.f34918b == null) {
            this.f34918b = new ArrayList();
        }
        this.f34918b.clear();
        this.f34918b.addAll(list);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<AdTemplate> list = this.f34917a;
            if (list != null) {
                list.clear();
            }
            this.f34917a = null;
        }
    }

    @Nullable
    public List<AdTemplate> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34918b : (List) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<AdTemplate> list = this.f34918b;
            if (list != null) {
                list.clear();
            }
            this.f34918b = null;
        }
    }
}
