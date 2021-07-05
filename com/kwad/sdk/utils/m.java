package com.kwad.sdk.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            com.kwad.sdk.core.d.a.a("GlideUtils", "preloadImage imageUrl=" + str);
            try {
                com.kwad.sdk.glide.c.b(context).a(str).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.utils.m.1
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

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(Drawable drawable, Object obj, com.kwad.sdk.glide.request.a.j<Drawable> jVar, DataSource dataSource, boolean z) {
                        InterceptResult invokeCommon;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{drawable, obj, jVar, dataSource, Boolean.valueOf(z)})) == null) {
                            return false;
                        }
                        return invokeCommon.booleanValue;
                    }

                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(@Nullable GlideException glideException, Object obj, com.kwad.sdk.glide.request.a.j<Drawable> jVar, boolean z) {
                        InterceptResult invokeCommon;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, jVar, Boolean.valueOf(z)})) == null) {
                            return false;
                        }
                        return invokeCommon.booleanValue;
                    }
                }).b();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }
}
