package com.bytedance.sdk.openadsdk.preload.geckox.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.p;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
/* loaded from: classes9.dex */
public class a extends v<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.c.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68715a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1869019486, "Lcom/bytedance/sdk/openadsdk/preload/geckox/c/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1869019486, "Lcom/bytedance/sdk/openadsdk/preload/geckox/c/a$1;");
                    return;
                }
            }
            int[] iArr = new int[com.bytedance.sdk.openadsdk.preload.a.d.b.values().length];
            f68715a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.preload.a.d.b.f68563h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68715a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68564i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68715a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68562g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, Boolean bool) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, bool) == null) {
            if (bool == null) {
                cVar.f();
            } else {
                cVar.a(bool);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    /* renamed from: a */
    public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
            int i2 = AnonymousClass1.f68715a[f2.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    aVar.j();
                    return null;
                } else if (i2 == 3) {
                    return Boolean.valueOf(aVar.m() != 0);
                } else {
                    throw new p("Expected BOOLEAN or NUMBER but was " + f2);
                }
            }
            return Boolean.valueOf(aVar.i());
        }
        return (Boolean) invokeL.objValue;
    }
}
