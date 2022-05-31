package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e78;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class ii5 implements e78 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern d;
    public static ii5 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e78.a> a;
    public final ConcurrentHashMap<String, e78.b> b;
    public e78.c c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e78.a a;
        public final /* synthetic */ ii5 b;

        public a(ii5 ii5Var, e78.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii5Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ii5Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.f(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755617476, "Lcom/repackage/ii5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755617476, "Lcom/repackage/ii5;");
                return;
            }
        }
        d = Pattern.compile(UrlManager.patternText, 2);
        e = new ii5();
    }

    public ii5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.b = new ConcurrentHashMap<>();
        this.c = null;
    }

    public static ii5 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? e : (ii5) invokeV.objValue;
    }

    @Override // com.repackage.e78
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(str) && d.matcher(str).find() : invokeL.booleanValue;
    }

    @Override // com.repackage.e78
    public void b(Context context, String[] strArr, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, strArr, Boolean.valueOf(z), bundle}) == null) {
            h(context, strArr, false, null, z, bundle);
        }
    }

    @Override // com.repackage.e78
    public boolean c(Context context, String[] strArr, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, strArr, bundle)) == null) ? h(context, strArr, false, null, false, bundle) : invokeLLL.booleanValue;
    }

    public void e(e78.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (li.C()) {
                f(aVar);
            } else {
                mg.a().post(new a(this, aVar));
            }
        }
    }

    public final void f(e78.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || this.a.contains(aVar)) {
            return;
        }
        this.a.add(aVar);
    }

    public boolean g(Context context, String str, String[] strArr, boolean z, e78.d dVar, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{context, str, strArr, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) {
            if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
                return false;
            }
            String str2 = strArr[0];
            e78.b bVar = this.b.get(m(str2));
            if (bVar != null) {
                bVar.a(context, j(k(str2)));
                return true;
            }
            Iterator<e78.a> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                e78.a next = it.next();
                if (next != null && next.a(context, strArr) != 3) {
                    z3 = true;
                    break;
                }
            }
            if (!z3 && this.c != null) {
                if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                    return true;
                }
                n(context, str, strArr[0], z, dVar, z2, bundle);
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean h(Context context, String[] strArr, boolean z, e78.d dVar, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, strArr, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle})) == null) ? g(context, "", strArr, z, dVar, z2, bundle) : invokeCommon.booleanValue;
    }

    public int i(Context context, String[] strArr) {
        InterceptResult invokeLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, strArr)) == null) {
            if (strArr != null && strArr.length != 0) {
                for (e78.a aVar : this.a) {
                    if (aVar != null && (a2 = aVar.a(context, strArr)) != 3) {
                        return a2;
                    }
                }
            }
            return 3;
        }
        return invokeLL.intValue;
    }

    public final Map<String, String> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            String[] split = str.split("[&]");
            if (split == null) {
                hashMap.put(UrlManager.DEFAULT_PARAM, str);
                return hashMap;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!StringUtils.isNull(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
                return str.substring(lastIndexOf + 1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return str.contains(":") ? str.substring(0, str.lastIndexOf(":")) : str;
        }
        return (String) invokeL.objValue;
    }

    public final void n(Context context, String str, String str2, boolean z, e78.d dVar, boolean z2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, str, str2, Boolean.valueOf(z), dVar, Boolean.valueOf(z2), bundle}) == null) && d.matcher(str2).find()) {
            this.c.a(context, str, str2, z, dVar, z2, bundle);
        }
    }

    public void o(e78.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.c = cVar;
        }
    }
}
