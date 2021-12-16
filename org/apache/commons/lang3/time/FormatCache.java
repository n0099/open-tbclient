package org.apache.commons.lang3.time;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes4.dex */
public abstract class FormatCache<F extends Format> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NONE = -1;
    public static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentMap<MultipartKey, F> cInstanceCache;

    /* loaded from: classes4.dex */
    public static class MultipartKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int hashCode;
        public final Object[] keys;

        public MultipartKey(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? Arrays.equals(this.keys, ((MultipartKey) obj).keys) : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Object[] objArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.hashCode == 0) {
                    int i2 = 0;
                    for (Object obj : this.keys) {
                        if (obj != null) {
                            i2 = (i2 * 7) + obj.hashCode();
                        }
                    }
                    this.hashCode = i2;
                }
                return this.hashCode;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-139690665, "Lorg/apache/commons/lang3/time/FormatCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-139690665, "Lorg/apache/commons/lang3/time/FormatCache;");
                return;
            }
        }
        cDateTimeInstanceCache = new ConcurrentHashMap(7);
    }

    public FormatCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cInstanceCache = new ConcurrentHashMap(7);
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, num, num2, timeZone, locale)) == null) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            return getInstance(getPatternForStyle(num, num2, locale), timeZone, locale);
        }
        return (F) invokeLLLL.objValue;
    }

    public static String getPatternForStyle(Integer num, Integer num2, Locale locale) {
        InterceptResult invokeLLL;
        DateFormat dateTimeInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, num, num2, locale)) == null) {
            MultipartKey multipartKey = new MultipartKey(num, num2, locale);
            String str = cDateTimeInstanceCache.get(multipartKey);
            if (str == null) {
                try {
                    if (num == null) {
                        dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
                    } else if (num2 == null) {
                        dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
                    } else {
                        dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
                    }
                    String pattern = ((SimpleDateFormat) dateTimeInstance).toPattern();
                    String putIfAbsent = cDateTimeInstanceCache.putIfAbsent(multipartKey, pattern);
                    return putIfAbsent != null ? putIfAbsent : pattern;
                } catch (ClassCastException unused) {
                    throw new IllegalArgumentException("No date time pattern for locale: " + locale);
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public abstract F createInstance(String str, TimeZone timeZone, Locale locale);

    public F getDateInstance(int i2, TimeZone timeZone, Locale locale) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, timeZone, locale)) == null) ? getDateTimeInstance(Integer.valueOf(i2), (Integer) null, timeZone, locale) : (F) invokeILL.objValue;
    }

    public F getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault()) : (F) invokeV.objValue;
    }

    public F getTimeInstance(int i2, TimeZone timeZone, Locale locale) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, timeZone, locale)) == null) ? getDateTimeInstance((Integer) null, Integer.valueOf(i2), timeZone, locale) : (F) invokeILL.objValue;
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, timeZone, locale)) == null) {
            if (str != null) {
                if (timeZone == null) {
                    timeZone = TimeZone.getDefault();
                }
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
                F f2 = this.cInstanceCache.get(multipartKey);
                if (f2 == null) {
                    F createInstance = createInstance(str, timeZone, locale);
                    F putIfAbsent = this.cInstanceCache.putIfAbsent(multipartKey, createInstance);
                    return putIfAbsent != null ? putIfAbsent : createInstance;
                }
                return f2;
            }
            throw new NullPointerException("pattern must not be null");
        }
        return (F) invokeLLL.objValue;
    }

    public F getDateTimeInstance(int i2, int i3, TimeZone timeZone, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), timeZone, locale})) == null) ? getDateTimeInstance(Integer.valueOf(i2), Integer.valueOf(i3), timeZone, locale) : (F) invokeCommon.objValue;
    }
}
