package com.bytedance.sdk.openadsdk.preload.falconx.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.f.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f68988a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f68989b;

    public a(Context context, String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68989b = new AtomicBoolean(false);
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("access key empty");
            }
            if (file != null) {
                this.f68988a = new b(context, str, file);
                return;
            }
            throw new RuntimeException("resRootDir == null");
        }
        throw new RuntimeException("context == null");
    }

    public InputStream a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.f68989b.get()) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("WebOffline-falcon", "GeckoResLoader ready to load, file:", str);
                return this.f68988a.a(str);
            }
            throw new RuntimeException("released!");
        }
        return (InputStream) invokeL.objValue;
    }

    public boolean b(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!this.f68989b.get()) {
                return this.f68988a.b(str);
            }
            throw new RuntimeException("released!");
        }
        return invokeL.booleanValue;
    }

    public void a() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f68989b.getAndSet(true)) {
            return;
        }
        this.f68988a.a();
    }
}
