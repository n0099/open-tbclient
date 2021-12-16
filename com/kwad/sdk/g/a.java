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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f59182b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2104a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1997933565, "Lcom/kwad/sdk/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1997933565, "Lcom/kwad/sdk/g/a;");
        }
    }

    public static void a(Context context, InterfaceC2104a interfaceC2104a) {
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, interfaceC2104a) == null) || context == null || f59182b) {
            return;
        }
        if (!a()) {
            f59182b = true;
        } else if (a) {
        } else {
            a = true;
            try {
                String str = "[OADIDSDKHelper25]:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener(System.currentTimeMillis(), interfaceC2104a) { // from class: com.kwad.sdk.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ InterfaceC2104a f59183b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Long.valueOf(r6), interfaceC2104a};
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
                        this.f59183b = interfaceC2104a;
                    }
                });
            } catch (Throwable th) {
                String str2 = "[OADIDSDKHelper25]:oaid sdk not find " + th.getMessage();
                a = false;
                f59182b = true;
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                new IIdentifierListener() { // from class: com.kwad.sdk.g.a.2
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
                }.OnSupport(true, null);
                return true;
            } catch (Throwable th) {
                String str = "[OADIDSDKHelper25]:oaid sdk not find " + th.getMessage();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
