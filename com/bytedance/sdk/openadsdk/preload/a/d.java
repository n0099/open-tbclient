package com.bytedance.sdk.openadsdk.preload.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public abstract class d implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d f68359a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f68360b;

    /* renamed from: c  reason: collision with root package name */
    public static final d f68361c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f68362d;

    /* renamed from: e  reason: collision with root package name */
    public static final d f68363e;

    /* renamed from: f  reason: collision with root package name */
    public static final d f68364f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ d[] f68365g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(45358368, "Lcom/bytedance/sdk/openadsdk/preload/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(45358368, "Lcom/bytedance/sdk/openadsdk/preload/a/d;");
                return;
            }
        }
        f68359a = new d("IDENTITY", 0) { // from class: com.bytedance.sdk.openadsdk.preload.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.e
            public String a(Field field) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, field)) == null) ? field.getName() : (String) invokeL.objValue;
            }
        };
        f68360b = new d("UPPER_CAMEL_CASE", 1) { // from class: com.bytedance.sdk.openadsdk.preload.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.e
            public String a(Field field) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, field)) == null) ? d.a(field.getName()) : (String) invokeL.objValue;
            }
        };
        f68361c = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.bytedance.sdk.openadsdk.preload.a.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.e
            public String a(Field field) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, field)) == null) ? d.a(d.a(field.getName(), " ")) : (String) invokeL.objValue;
            }
        };
        f68362d = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.bytedance.sdk.openadsdk.preload.a.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.e
            public String a(Field field) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, field)) == null) ? d.a(field.getName(), "_").toLowerCase(Locale.ENGLISH) : (String) invokeL.objValue;
            }
        };
        f68363e = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: com.bytedance.sdk.openadsdk.preload.a.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.e
            public String a(Field field) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, field)) == null) ? d.a(field.getName(), "-").toLowerCase(Locale.ENGLISH) : (String) invokeL.objValue;
            }
        };
        d dVar = new d("LOWER_CASE_WITH_DOTS", 5) { // from class: com.bytedance.sdk.openadsdk.preload.a.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.e
            public String a(Field field) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, field)) == null) ? d.a(field.getName(), ".").toLowerCase(Locale.ENGLISH) : (String) invokeL.objValue;
            }
        };
        f68364f = dVar;
        f68365g = new d[]{f68359a, f68360b, f68361c, f68362d, f68363e, dVar};
    }

    public d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt) && sb.length() != 0) {
                    sb.append(str2);
                }
                sb.append(charAt);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static d valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (d) Enum.valueOf(d.class, str) : (d) invokeL.objValue;
    }

    public static d[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (d[]) f68365g.clone() : (d[]) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int length = str.length() - 1;
            int i2 = 0;
            while (!Character.isLetter(str.charAt(i2)) && i2 < length) {
                i2++;
            }
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                return str;
            }
            char upperCase = Character.toUpperCase(charAt);
            if (i2 == 0) {
                return upperCase + str.substring(1);
            }
            return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
        }
        return (String) invokeL.objValue;
    }
}
