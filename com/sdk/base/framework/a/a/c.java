package com.sdk.base.framework.a.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f68090a;

    /* renamed from: b  reason: collision with root package name */
    public int f68091b;

    /* renamed from: c  reason: collision with root package name */
    public int f68092c;

    /* renamed from: d  reason: collision with root package name */
    public b<K, Long> f68093d;

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
        this.f68092c = i2;
        this.f68090a = new LinkedHashMap<>(0, 0.75f, true);
        this.f68093d = new b<>(0, 0.75f);
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
            long j = 0;
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
                j += new String(str.substring(i2, i3 < length ? i3 : length)).getBytes(str2).length;
                i2 = i3;
            }
            return j;
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
                    if (this.f68091b <= i2 || this.f68090a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f68090a.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.f68090a.remove(key);
                    this.f68093d.remove(key);
                    this.f68091b -= b(key, value);
                }
            }
        }
    }

    public static boolean a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, strArr)) == null) {
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

    private int b(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, k, v)) == null) {
            int a2 = a((c<K, V>) k, (K) v);
            if (a2 <= 0) {
                this.f68091b = 0;
                for (Map.Entry<K, V> entry : this.f68090a.entrySet()) {
                    this.f68091b += a((c<K, V>) entry.getKey(), (K) entry.getValue());
                }
            }
            return a2;
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

    private V b(K k) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    remove = this.f68090a.remove(k);
                    this.f68093d.remove(k);
                    if (remove != null) {
                        this.f68091b -= b(k, remove);
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

    public int a(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k, v)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    public final V a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    if (!this.f68093d.containsKey(k)) {
                        b((c<K, V>) k);
                        return null;
                    }
                    V v = this.f68090a.get(k);
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

    public final V a(K k, V v, long j) {
        InterceptResult invokeCommon;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{k, v, Long.valueOf(j)})) == null) {
            if (k == null || v == null) {
                throw new NullPointerException("key == null || value == null");
            }
            synchronized (this) {
                this.f68091b += b(k, v);
                put = this.f68090a.put(k, v);
                this.f68093d.put(k, Long.valueOf(j));
                if (put != null) {
                    this.f68091b -= b(k, put);
                }
            }
            a(this.f68092c);
            return put;
        }
        return (V) invokeCommon.objValue;
    }
}
