package org.apache.commons.lang3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class CharSet implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final CharSet ASCII_ALPHA;
    public static final CharSet ASCII_ALPHA_LOWER;
    public static final CharSet ASCII_ALPHA_UPPER;
    public static final CharSet ASCII_NUMERIC;
    public static final Map<String, CharSet> COMMON;
    public static final CharSet EMPTY;
    public static final long serialVersionUID = 5947847346149275958L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<CharRange> set;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1755609686, "Lorg/apache/commons/lang3/CharSet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1755609686, "Lorg/apache/commons/lang3/CharSet;");
                return;
            }
        }
        EMPTY = new CharSet(null);
        ASCII_ALPHA = new CharSet(TbPatternsCompat.TLD_CHAR);
        ASCII_ALPHA_LOWER = new CharSet("a-z");
        ASCII_ALPHA_UPPER = new CharSet("A-Z");
        ASCII_NUMERIC = new CharSet("0-9");
        Map<String, CharSet> synchronizedMap = Collections.synchronizedMap(new HashMap());
        COMMON = synchronizedMap;
        synchronizedMap.put(null, EMPTY);
        COMMON.put("", EMPTY);
        COMMON.put(TbPatternsCompat.TLD_CHAR, ASCII_ALPHA);
        COMMON.put("A-Za-z", ASCII_ALPHA);
        COMMON.put("a-z", ASCII_ALPHA_LOWER);
        COMMON.put("A-Z", ASCII_ALPHA_UPPER);
        COMMON.put("0-9", ASCII_NUMERIC);
    }

    public CharSet(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.set = Collections.synchronizedSet(new HashSet());
        for (String str : strArr) {
            add(str);
        }
    }

    public static CharSet getInstance(String... strArr) {
        InterceptResult invokeL;
        CharSet charSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, strArr)) == null) {
            if (strArr == null) {
                return null;
            }
            return (strArr.length != 1 || (charSet = COMMON.get(strArr[0])) == null) ? new CharSet(strArr) : charSet;
        }
        return (CharSet) invokeL.objValue;
    }

    public void add(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null) {
            return;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = length - i2;
            if (i3 >= 4 && str.charAt(i2) == '^' && str.charAt(i2 + 2) == '-') {
                this.set.add(CharRange.isNotIn(str.charAt(i2 + 1), str.charAt(i2 + 3)));
                i2 += 4;
            } else if (i3 >= 3 && str.charAt(i2 + 1) == '-') {
                this.set.add(CharRange.isIn(str.charAt(i2), str.charAt(i2 + 2)));
                i2 += 3;
            } else if (i3 >= 2 && str.charAt(i2) == '^') {
                this.set.add(CharRange.isNot(str.charAt(i2 + 1)));
                i2 += 2;
            } else {
                this.set.add(CharRange.is(str.charAt(i2)));
                i2++;
            }
        }
    }

    public boolean contains(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2)})) == null) {
            for (CharRange charRange : this.set) {
                if (charRange.contains(c2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CharSet) {
                return this.set.equals(((CharSet) obj).set);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public CharRange[] getCharRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Set<CharRange> set = this.set;
            return (CharRange[]) set.toArray(new CharRange[set.size()]);
        }
        return (CharRange[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.set.hashCode() + 89 : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.set.toString() : (String) invokeV.objValue;
    }
}
