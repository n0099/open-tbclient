package com.bytedance.sdk.openadsdk.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, a> f69180a;

    /* renamed from: b  reason: collision with root package name */
    public static IListenerManager f69181b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98109355, "Lcom/bytedance/sdk/openadsdk/q/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98109355, "Lcom/bytedance/sdk/openadsdk/q/c;");
                return;
            }
        }
        f69180a = Collections.synchronizedMap(new HashMap());
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            TTDelegateActivity.a(context, str);
            com.bytedance.sdk.openadsdk.j.a.a().c(str);
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            a(str, 3);
        }
    }

    public static a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f69180a.remove(str);
        }
        return (a) invokeL.objValue;
    }

    public static void a(Context context, String str, String str2, String str3, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2, str3, aVar) == null) || TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3);
    }

    public static void b(com.bytedance.sdk.openadsdk.core.e.m mVar, Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, mVar, context, str) == null) || mVar == null || context == null || mVar.X() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(context, mVar, str);
        if (a2 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) a2).g(false);
        }
        a2.g();
    }

    public static void a(Context context, String str, String str2, a aVar, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, aVar, str3, str4, Boolean.valueOf(z)}) == null) || TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3, str4, z);
    }

    public static void a(Context context, String str, String str2, a aVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, aVar, str3, Boolean.valueOf(z)}) == null) || TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3, z);
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            a(str, 2);
        }
    }

    public static IListenerManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f69181b == null) {
                f69181b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(2));
            }
            return f69181b;
        }
        return (IListenerManager) invokeV.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            TTDelegateActivity.b(context, str);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.e.m mVar, Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, mVar, context, str) == null) || mVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        a(context, mVar.ak(), mVar.U(), new a(mVar, context, str) { // from class: com.bytedance.sdk.openadsdk.q.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f69182a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f69183b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f69184c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, context, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69182a = mVar;
                this.f69183b = context;
                this.f69184c = str;
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    c.b(this.f69182a, this.f69183b, this.f69184c);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(mVar), mVar.X() == 4);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, str2, str3, str4, str5, aVar}) == null) || TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        a(str, aVar);
        TTDelegateActivity.a(context, str, str2, str3, str4, str5);
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            a(str, 1);
        }
    }

    public static void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, aVar) == null) || TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.component.d.e.c(new com.bytedance.sdk.component.d.g("addDialogListener", str, aVar) { // from class: com.bytedance.sdk.openadsdk.q.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f69185a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f69186b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, str, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69185a = str;
                    this.f69186b = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            c.b().registerDialogListener(this.f69185a, new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(this.f69186b));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }, 5);
        } else {
            f69180a.put(str, aVar);
        }
    }

    public static void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, null, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.component.d.e.c(new com.bytedance.sdk.component.d.g("doHandler", str, i2) { // from class: com.bytedance.sdk.openadsdk.q.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f69187a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f69188b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, str, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69187a = str;
                    this.f69188b = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            c.b().broadcastDialogListener(this.f69187a, this.f69188b);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }, 5);
            return;
        }
        a d2 = d(str);
        if (d2 == null) {
            return;
        }
        if (i2 == 1) {
            d2.a();
        } else if (i2 == 2) {
            d2.b();
        } else if (i2 != 3) {
            d2.c();
        } else {
            d2.c();
        }
    }
}
