package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f71100a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a extends DexClassLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, classLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (ClassLoader) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api") : invokeL.booleanValue;
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
                if (a(str)) {
                    return getParent().loadClass(str);
                }
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass != null) {
                    return findLoadedClass;
                }
                try {
                    findLoadedClass = findClass(str);
                } catch (ClassNotFoundException unused) {
                }
                return findLoadedClass != null ? findLoadedClass : super.loadClass(str, z);
            }
            return (Class) invokeLZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1711378653, "Lcom/kwad/sdk/api/loader/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1711378653, "Lcom/kwad/sdk/api/loader/d;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        f71100a = arrayList;
        arrayList.add("com.kwad.sdk");
        f71100a.add("com.ksad");
        f71100a.add("com.kwai");
        f71100a.add("kwad.support");
        f71100a.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, str2, str3)) == null) ? new a(str, str2, str3, context.getClassLoader()) : (ClassLoader) invokeLLLL.objValue;
    }
}
