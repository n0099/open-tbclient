package com.kwad.sdk.live.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.live.audience.api.KSLiveRequest;
import com.kuaishou.live.audience.api.KSLiveRequestHelper;
import com.kwad.sdk.utils.aa;
import java.util.Map;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KSLiveRequest f38636b;

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
                return;
            }
        }
        this.f38636b = KSLiveRequestHelper.buildGetFeedListRequest();
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38636b = KSLiveRequestHelper.buildGetFeedMoreRequest(str);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? aa.a(this.f38636b.mUrl, this.f38636b.mUrlParam) : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KSLiveRequest kSLiveRequest = this.f38636b;
            if (kSLiveRequest == null || kSLiveRequest.mHeaderParam == null || this.f38636b.mHeaderParam.size() <= 0) {
                return super.b();
            }
            for (String str : this.f38636b.mHeaderParam.keySet()) {
                if (!TextUtils.isEmpty((CharSequence) this.f38636b.mHeaderParam.get(str))) {
                    a(str, (String) this.f38636b.mHeaderParam.get(str));
                }
            }
            return super.b();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            KSLiveRequest kSLiveRequest = this.f38636b;
            if (kSLiveRequest != null) {
                return kSLiveRequest.mBodyParam;
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
