package com.kwad.components.core.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.a.h;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
/* loaded from: classes5.dex */
public class a extends d implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public long c;
    public String d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            b.c("EncryptComponentsImpl", "初次获取Gid: initGId");
            KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback(this) { // from class: com.kwad.components.core.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
                public final void onFailed(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        b.e("EncryptComponentsImpl", "初次获取Gid: initGId onFailed errorCode:" + i + "errorMessage :" + str);
                    }
                }

                @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
                public final void onSuccess(String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                        b.a("SDKPrivateSafetyData", "deviceInfo：" + str2);
                        this.a.b(str2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || this.a == null || at.a(str) || at.a(f(), str)) {
            return;
        }
        this.d = str;
        as.j(this.a, str);
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String c = as.c(this.a);
            String e = av.e();
            if (TextUtils.isEmpty(c)) {
                as.e(this.a, e);
            } else if (TextUtils.equals(c, e)) {
            } else {
                this.b = "";
                this.c = 0L;
                this.d = "";
                as.d(this.a, "");
                as.a(this.a, this.c);
                as.j(this.a, this.d);
                as.e(this.a, e);
            }
        }
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = as.a(this.a);
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    private long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.c == 0) {
                this.c = as.b(this.a);
            }
            return this.c;
        }
        return invokeV.longValue;
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (TextUtils.isEmpty(this.d)) {
                this.d = as.d(this.a);
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.f
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (com.kwad.sdk.core.config.d.D() || System.currentTimeMillis() >= e() || TextUtils.isEmpty(d())) ? f() : "" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.f
    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.a == null || j <= 0 || j == e()) {
            return;
        }
        this.c = j;
        as.a(this.a, j);
    }

    @Override // com.kwad.sdk.components.f
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a == null || at.a(str) || at.a(d(), str)) {
            return;
        }
        try {
            this.b = str;
            as.d(this.a, str);
            KWEGIDDFP.instance().setEgid(this.a, str);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.f
    public final h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.kwad.sdk.core.a.a() : (h) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, sdkConfig) == null) {
            try {
                this.a = context;
                c();
                a(context);
            } catch (Throwable th) {
                b.e("EncryptComponentsImpl", "initGId error : " + th);
            }
        }
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return -200;
        }
        return invokeV.intValue;
    }
}
