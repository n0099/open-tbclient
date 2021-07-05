package com.kwad.sdk.contentalliance.trends;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.g;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<TrendInfo> f35531a;

    /* renamed from: b  reason: collision with root package name */
    public TrendInfo f35532b;

    /* renamed from: c  reason: collision with root package name */
    public KsScene f35533c;

    public c(@NonNull KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35533c = ksScene;
    }

    @NonNull
    public KsFragment a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g a2 = g.a(this.f35533c);
            Bundle arguments = a2.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("KEY_TREND_LIST_DATA", TrendInfo.toString(this.f35531a));
            arguments.putString("KEY_CURRENT_TREND", this.f35532b.toJson().toString());
            return a2;
        }
        return (KsFragment) invokeV.objValue;
    }

    public void a(@NonNull List<TrendInfo> list, @NonNull TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, trendInfo) == null) {
            this.f35531a = list;
            this.f35532b = trendInfo;
        }
    }
}
