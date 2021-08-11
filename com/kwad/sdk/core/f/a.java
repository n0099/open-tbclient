package com.kwad.sdk.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.kwad.sdk.core.f.b;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f71332a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f71333b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1890011704, "Lcom/kwad/sdk/core/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1890011704, "Lcom/kwad/sdk/core/f/a;");
        }
    }

    public static void a(Context context, b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) || context == null || f71333b || f71332a) {
            return;
        }
        f71332a = true;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener(currentTimeMillis, aVar) { // from class: com.kwad.sdk.core.f.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f71334a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b.a f71335b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Long.valueOf(currentTimeMillis), aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f71334a = currentTimeMillis;
                    this.f71335b = aVar;
                }

                public void OnSupport(boolean z, IdSupplier idSupplier) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, idSupplier) == null) {
                        long currentTimeMillis2 = System.currentTimeMillis() - this.f71334a;
                        if (idSupplier != null) {
                            String oaid = idSupplier.getOAID();
                            if (TextUtils.isEmpty(oaid)) {
                                boolean unused = a.f71333b = false;
                            } else {
                                com.kwad.sdk.core.d.a.a("OADIDSDKHelper", "oaid time=" + currentTimeMillis2 + "--OAID:" + oaid);
                                this.f71335b.a(oaid);
                            }
                        }
                        boolean unused2 = a.f71332a = false;
                    }
                }
            });
            com.kwad.sdk.core.d.a.a("OADIDSDKHelper", "MdidSdkHelper time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a("OADIDSDKHelper", "oaid sdk not found " + th.getMessage());
            f71332a = false;
        }
    }
}
