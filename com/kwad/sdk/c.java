package com.kwad.sdk;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.glide.request.e<Drawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34255a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34256b;

    public c(String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34255a = str;
        this.f34256b = adTemplate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.e
    public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawable, obj, jVar, dataSource, Boolean.valueOf(z)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.e
    public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, jVar, Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder("KS_Glide:");
            if (glideException != null) {
                sb.append(glideException.getMessage());
            }
            com.kwad.sdk.core.report.e.c(this.f34256b, this.f34255a, sb.toString());
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
