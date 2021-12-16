package com.sdk.base.framework.a.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    public int f61477b;

    /* renamed from: c  reason: collision with root package name */
    public int f61478c;

    /* renamed from: d  reason: collision with root package name */
    public b<K, Long> f61479d;

    public c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f61478c = i2;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
        this.f61479d = new b<>(0, 0.75f);
    }

    public static int a(String str, String str2, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, bool)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            if (bool.booleanValue()) {
                return Log.i(str, str2);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static long a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            long j2 = 0;
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            int length = str.length();
            if (length < 100) {
                return str.getBytes(str2).length;
            }
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 100;
                j2 += new String(str.substring(i2, i3 < length ? i3 : length)).getBytes(str2).length;
                i2 = i3;
            }
            return j2;
        }
        return invokeLL.longValue;
    }

    public static Boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str)) ? Boolean.TRUE : Boolean.FALSE : (Boolean) invokeL.objValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            while (true) {
                synchronized (this) {
                    if (this.f61477b <= i2 || this.a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.a.remove(key);
                    this.f61479d.remove(key);
                    this.f61477b -= b(key, value);
                }
            }
        }
    }

    public static boolean a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, strArr)) == null) {
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                if ((str == null || str.length() <= 0) && a(str).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private int b(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, k2, v)) == null) {
            int a = a((c<K, V>) k2, (K) v);
            if (a <= 0) {
                this.f61477b = 0;
                for (Map.Entry<K, V> entry : this.a.entrySet()) {
                    this.f61477b += a((c<K, V>) entry.getKey(), (K) entry.getValue());
                }
            }
            return a;
        }
        return invokeLL.intValue;
    }

    public static int b(String str, String str2, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, bool)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            if (bool.booleanValue()) {
                return Log.e(str, str2);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static Boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE : (Boolean) invokeL.objValue;
    }

    private V b(K k2) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, k2)) == null) {
            if (k2 != null) {
                synchronized (this) {
                    remove = this.a.remove(k2);
                    this.f61479d.remove(k2);
                    if (remove != null) {
                        this.f61477b -= b(k2, remove);
                    }
                }
                return remove;
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public static int c(String str, String str2, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, str, str2, bool)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            if (bool.booleanValue()) {
                return Log.w(str, str2);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public int a(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k2, v)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    public final V a(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2)) == null) {
            if (k2 != null) {
                synchronized (this) {
                    if (!this.f61479d.containsKey(k2)) {
                        b((c<K, V>) k2);
                        return null;
                    }
                    V v = this.a.get(k2);
                    if (v != null) {
                        return v;
                    }
                    return null;
                }
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public final V a(K k2, V v, long j2) {
        InterceptResult invokeCommon;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{k2, v, Long.valueOf(j2)})) == null) {
            if (k2 == null || v == null) {
                throw new NullPointerException("key == null || value == null");
            }
            synchronized (this) {
                this.f61477b += b(k2, v);
                put = this.a.put(k2, v);
                this.f61479d.put(k2, Long.valueOf(j2));
                if (put != null) {
                    this.f61477b -= b(k2, put);
                }
            }
            a(this.f61478c);
            return put;
        }
        return (V) invokeCommon.objValue;
    }
}
