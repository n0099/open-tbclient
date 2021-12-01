package com.kwad.sdk.g;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f58603b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1997933596, "Lcom/kwad/sdk/g/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1997933596, "Lcom/kwad/sdk/g/b;");
        }
    }

    public static void a(Context context, a aVar) {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) || context == null || f58603b) {
            return;
        }
        if (!a()) {
            f58603b = true;
        } else if (a) {
        } else {
            a = true;
            try {
                String str = "[OADIDSDKHelper26]:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener(System.currentTimeMillis(), aVar) { // from class: com.kwad.sdk.g.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f58604b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Long.valueOf(r6), aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = r6;
                        this.f58604b = aVar;
                    }
                });
            } catch (Throwable th) {
                String str2 = "[OADIDSDKHelper26]:oaid sdk not find " + th.getMessage();
                a = false;
                f58603b = true;
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                new IIdentifierListener() { // from class: com.kwad.sdk.g.b.2
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
                }.onSupport(null);
                return true;
            } catch (Throwable th) {
                String str = "[OADIDSDKHelper26]:oaid sdk not find " + th.getMessage();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
