package com.kwad.sdk.contentalliance.tube.episode;

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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f35703a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f35704b;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f35704b == null) {
                synchronized (b.class) {
                    if (f35704b == null) {
                        f35704b = new b();
                    }
                }
            }
            return f35704b;
        }
        return (b) invokeV.objValue;
    }

    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
            if (list == null || list.isEmpty()) {
                return;
            }
            com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
            if (f35703a == null) {
                f35703a = new ArrayList();
            }
            f35703a.clear();
            f35703a.addAll(list);
        }
    }

    @Nullable
    public List<AdTemplate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f35703a : (List) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
            List<AdTemplate> list = f35703a;
            if (list != null) {
                list.clear();
            }
            f35703a = null;
        }
    }
}
