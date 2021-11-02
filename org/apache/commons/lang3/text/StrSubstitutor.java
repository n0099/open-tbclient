package org.apache.commons.lang3.text;

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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes3.dex */
public class StrSubstitutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX;
    public static final StrMatcher DEFAULT_SUFFIX;
    public static final StrMatcher DEFAULT_VALUE_DELIMITER;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean enableSubstitutionInVariables;
    public char escapeChar;
    public StrMatcher prefixMatcher;
    public boolean preserveEscapes;
    public StrMatcher suffixMatcher;
    public StrMatcher valueDelimiterMatcher;
    public StrLookup<?> variableResolver;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2098762249, "Lorg/apache/commons/lang3/text/StrSubstitutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2098762249, "Lorg/apache/commons/lang3/text/StrSubstitutor;");
                return;
            }
        }
        DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
        DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
        DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((StrLookup) objArr[0], (StrMatcher) objArr[1], (StrMatcher) objArr[2], ((Character) objArr[3]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, this, str, list) == null) && list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators(list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, map)) == null) ? new StrSubstitutor(map).replace(obj) : (String) invokeLL.objValue;
    }

    public static String replaceSystemProperties(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) ? new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj) : (String) invokeL.objValue;
    }

    public char getEscapeChar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.escapeChar : invokeV.charValue;
    }

    public StrMatcher getValueDelimiterMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.valueDelimiterMatcher : (StrMatcher) invokeV.objValue;
    }

    public StrMatcher getVariablePrefixMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.prefixMatcher : (StrMatcher) invokeV.objValue;
    }

    public StrLookup<?> getVariableResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.variableResolver : (StrLookup) invokeV.objValue;
    }

    public StrMatcher getVariableSuffixMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.suffixMatcher : (StrMatcher) invokeV.objValue;
    }

    public boolean isEnableSubstitutionInVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.enableSubstitutionInVariables : invokeV.booleanValue;
    }

    public boolean isPreserveEscapes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.preserveEscapes : invokeV.booleanValue;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, stringBuffer)) == null) {
            if (stringBuffer == null) {
                return false;
            }
            return replaceIn(stringBuffer, 0, stringBuffer.length());
        }
        return invokeL.booleanValue;
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048600, this, str, strBuilder, i2, i3)) == null) {
            StrLookup<?> variableResolver = getVariableResolver();
            if (variableResolver == null) {
                return null;
            }
            return variableResolver.lookup(str);
        }
        return (String) invokeLLII.objValue;
    }

    public void setEnableSubstitutionInVariables(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.enableSubstitutionInVariables = z;
        }
    }

    public void setEscapeChar(char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Character.valueOf(c2)}) == null) {
            this.escapeChar = c2;
        }
    }

    public void setPreserveEscapes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.preserveEscapes = z;
        }
    }

    public StrSubstitutor setValueDelimiter(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Character.valueOf(c2)})) == null) ? setValueDelimiterMatcher(StrMatcher.charMatcher(c2)) : (StrSubstitutor) invokeCommon.objValue;
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, strMatcher)) == null) {
            this.valueDelimiterMatcher = strMatcher;
            return this;
        }
        return (StrSubstitutor) invokeL.objValue;
    }

    public StrSubstitutor setVariablePrefix(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Character.valueOf(c2)})) == null) ? setVariablePrefixMatcher(StrMatcher.charMatcher(c2)) : (StrSubstitutor) invokeCommon.objValue;
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, strMatcher)) == null) {
            if (strMatcher != null) {
                this.prefixMatcher = strMatcher;
                return this;
            }
            throw new IllegalArgumentException("Variable prefix matcher must not be null!");
        }
        return (StrSubstitutor) invokeL.objValue;
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, strLookup) == null) {
            this.variableResolver = strLookup;
        }
    }

    public StrSubstitutor setVariableSuffix(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Character.valueOf(c2)})) == null) ? setVariableSuffixMatcher(StrMatcher.charMatcher(c2)) : (StrSubstitutor) invokeCommon.objValue;
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, strMatcher)) == null) {
            if (strMatcher != null) {
                this.suffixMatcher = strMatcher;
                return this;
            }
            throw new IllegalArgumentException("Variable suffix matcher must not be null!");
        }
        return (StrSubstitutor) invokeL.objValue;
    }

    public boolean substitute(StrBuilder strBuilder, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048614, this, strBuilder, i2, i3)) == null) ? substitute(strBuilder, i2, i3, null) > 0 : invokeLII.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((StrLookup) objArr2[0], (StrMatcher) objArr2[1], (StrMatcher) objArr2[2], ((Character) objArr2[3]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, obj, map, str, str2)) == null) ? new StrSubstitutor(map, str, str2).replace(obj) : (String) invokeLLLL.objValue;
    }

    private int substitute(StrBuilder strBuilder, int i2, int i3, List<String> list) {
        InterceptResult invokeCommon;
        StrMatcher strMatcher;
        StrMatcher strMatcher2;
        char c2;
        boolean z;
        String str;
        int isMatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{strBuilder, Integer.valueOf(i2), Integer.valueOf(i3), list})) == null) {
            StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
            StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
            char escapeChar = getEscapeChar();
            StrMatcher valueDelimiterMatcher = getValueDelimiterMatcher();
            boolean isEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
            boolean z2 = list == null;
            int i4 = i2;
            int i5 = i2 + i3;
            int i6 = 0;
            int i7 = 0;
            char[] cArr = strBuilder.buffer;
            List<String> list2 = list;
            while (i4 < i5) {
                int isMatch2 = variablePrefixMatcher.isMatch(cArr, i4, i2, i5);
                if (isMatch2 != 0) {
                    if (i4 > i2) {
                        int i8 = i4 - 1;
                        if (cArr[i8] == escapeChar) {
                            if (this.preserveEscapes) {
                                i4++;
                            } else {
                                strBuilder.deleteCharAt(i8);
                                i6--;
                                i5--;
                                strMatcher = variablePrefixMatcher;
                                strMatcher2 = variableSuffixMatcher;
                                c2 = escapeChar;
                                cArr = strBuilder.buffer;
                                z = z2;
                                i7 = 1;
                            }
                        }
                    }
                    int i9 = i4 + isMatch2;
                    int i10 = i9;
                    int i11 = 0;
                    while (true) {
                        if (i10 >= i5) {
                            strMatcher = variablePrefixMatcher;
                            strMatcher2 = variableSuffixMatcher;
                            c2 = escapeChar;
                            z = z2;
                            i4 = i10;
                            break;
                        } else if (!isEnableSubstitutionInVariables || (isMatch = variablePrefixMatcher.isMatch(cArr, i10, i2, i5)) == 0) {
                            int isMatch3 = variableSuffixMatcher.isMatch(cArr, i10, i2, i5);
                            if (isMatch3 == 0) {
                                i10++;
                            } else if (i11 == 0) {
                                strMatcher2 = variableSuffixMatcher;
                                c2 = escapeChar;
                                String str2 = new String(cArr, i9, (i10 - i4) - isMatch2);
                                if (isEnableSubstitutionInVariables) {
                                    StrBuilder strBuilder2 = new StrBuilder(str2);
                                    substitute(strBuilder2, 0, strBuilder2.length());
                                    str2 = strBuilder2.toString();
                                }
                                int i12 = i10 + isMatch3;
                                if (valueDelimiterMatcher != null) {
                                    char[] charArray = str2.toCharArray();
                                    z = z2;
                                    int i13 = 0;
                                    while (i13 < charArray.length && (isEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i13, i13, charArray.length) == 0)) {
                                        int isMatch4 = valueDelimiterMatcher.isMatch(charArray, i13);
                                        if (isMatch4 != 0) {
                                            strMatcher = variablePrefixMatcher;
                                            String substring = str2.substring(0, i13);
                                            str = str2.substring(i13 + isMatch4);
                                            str2 = substring;
                                            break;
                                        }
                                        i13++;
                                        variablePrefixMatcher = variablePrefixMatcher;
                                    }
                                    strMatcher = variablePrefixMatcher;
                                } else {
                                    strMatcher = variablePrefixMatcher;
                                    z = z2;
                                }
                                str = null;
                                if (list2 == null) {
                                    list2 = new ArrayList<>();
                                    list2.add(new String(cArr, i2, i3));
                                }
                                checkCyclicSubstitution(str2, list2);
                                list2.add(str2);
                                String resolveVariable = resolveVariable(str2, strBuilder, i4, i12);
                                if (resolveVariable != null) {
                                    str = resolveVariable;
                                }
                                if (str != null) {
                                    int length = str.length();
                                    strBuilder.replace(i4, i12, str);
                                    int substitute = (substitute(strBuilder, i4, length, list2) + length) - (i12 - i4);
                                    i5 += substitute;
                                    i6 += substitute;
                                    cArr = strBuilder.buffer;
                                    i4 = i12 + substitute;
                                    i7 = 1;
                                } else {
                                    i4 = i12;
                                }
                                list2.remove(list2.size() - 1);
                            } else {
                                i11--;
                                i10 += isMatch3;
                                escapeChar = escapeChar;
                                variablePrefixMatcher = variablePrefixMatcher;
                            }
                        } else {
                            i11++;
                            i10 += isMatch;
                        }
                    }
                } else {
                    i4++;
                    strMatcher = variablePrefixMatcher;
                    strMatcher2 = variableSuffixMatcher;
                    c2 = escapeChar;
                    z = z2;
                }
                variableSuffixMatcher = strMatcher2;
                escapeChar = c2;
                z2 = z;
                variablePrefixMatcher = strMatcher;
            }
            return z2 ? i7 : i6;
        }
        return invokeCommon.intValue;
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, stringBuffer, i2, i3)) == null) {
            if (stringBuffer == null) {
                return false;
            }
            StrBuilder append = new StrBuilder(i3).append(stringBuffer, i2, i3);
            if (substitute(append, 0, i3)) {
                stringBuffer.replace(i2, i3 + i2, append.toString());
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public StrSubstitutor setValueDelimiter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                setValueDelimiterMatcher(null);
                return this;
            }
            return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
        }
        return (StrSubstitutor) invokeL.objValue;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (str != null) {
                return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
            }
            throw new IllegalArgumentException("Variable prefix must not be null!");
        }
        return (StrSubstitutor) invokeL.objValue;
    }

    public StrSubstitutor setVariableSuffix(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            if (str != null) {
                return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
            }
            throw new IllegalArgumentException("Variable suffix must not be null!");
        }
        return (StrSubstitutor) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((StrLookup) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Character) objArr2[3]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public static String replace(Object obj, Properties properties) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, obj, properties)) == null) {
            if (properties == null) {
                return obj.toString();
            }
            HashMap hashMap = new HashMap();
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                hashMap.put(str, properties.getProperty(str));
            }
            return replace(obj, hashMap);
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c2) {
        this(StrLookup.mapLookup(map), str, str2, c2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, str, str2, Character.valueOf(c2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((StrLookup) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Character) objArr2[3]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c2, String str3) {
        this(StrLookup.mapLookup(map), str, str2, c2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, str, str2, Character.valueOf(c2), str3};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((StrLookup) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Character) objArr2[3]).charValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    public boolean replaceIn(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, sb)) == null) {
            if (sb == null) {
                return false;
            }
            return replaceIn(sb, 0, sb.length());
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strLookup};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((StrLookup) objArr2[0], (StrMatcher) objArr2[1], (StrMatcher) objArr2[2], ((Character) objArr2[3]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
    }

    public boolean replaceIn(StringBuilder sb, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, sb, i2, i3)) == null) {
            if (sb == null) {
                return false;
            }
            StrBuilder append = new StrBuilder(i3).append(sb, i2, i3);
            if (substitute(append, 0, i3)) {
                sb.replace(i2, i3 + i2, append.toString());
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strLookup, str, str2, Character.valueOf(c2)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c2);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, strBuilder)) == null) {
            if (strBuilder == null) {
                return false;
            }
            return substitute(strBuilder, 0, strBuilder.length());
        }
        return invokeL.booleanValue;
    }

    public boolean replaceIn(StrBuilder strBuilder, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048599, this, strBuilder, i2, i3)) == null) {
            if (strBuilder == null) {
                return false;
            }
            return substitute(strBuilder, i2, i3);
        }
        return invokeLII.booleanValue;
    }

    public String replace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str == null) {
                return null;
            }
            StrBuilder strBuilder = new StrBuilder(str);
            return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
        }
        return (String) invokeL.objValue;
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strLookup, str, str2, Character.valueOf(c2), str3};
            interceptable.invokeUnInit(65544, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c2);
        setValueDelimiter(str3);
    }

    public String replace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, str, i2, i3)) == null) {
            if (str == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(i3).append(str, i2, i3);
            if (!substitute(append, 0, i3)) {
                return str.substring(i2, i3 + i2);
            }
            return append.toString();
        }
        return (String) invokeLII.objValue;
    }

    public String replace(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cArr)) == null) {
            if (cArr == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(cArr.length).append(cArr);
            substitute(append, 0, cArr.length);
            return append.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c2) {
        this(strLookup, strMatcher, strMatcher2, c2, DEFAULT_VALUE_DELIMITER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strLookup, strMatcher, strMatcher2, Character.valueOf(c2)};
            interceptable.invokeUnInit(65545, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((StrLookup) objArr2[0], (StrMatcher) objArr2[1], (StrMatcher) objArr2[2], ((Character) objArr2[3]).charValue(), (StrMatcher) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65545, newInitContext);
                return;
            }
        }
    }

    public String replace(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, cArr, i2, i3)) == null) {
            if (cArr == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(i3).append(cArr, i2, i3);
            substitute(append, 0, i3);
            return append.toString();
        }
        return (String) invokeLII.objValue;
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c2, StrMatcher strMatcher3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strLookup, strMatcher, strMatcher2, Character.valueOf(c2), strMatcher3};
            interceptable.invokeUnInit(65546, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65546, newInitContext);
                return;
            }
        }
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c2);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(StringBuffer stringBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, stringBuffer)) == null) {
            if (stringBuffer == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
            substitute(append, 0, append.length());
            return append.toString();
        }
        return (String) invokeL.objValue;
    }

    public String replace(StringBuffer stringBuffer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048589, this, stringBuffer, i2, i3)) == null) {
            if (stringBuffer == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(i3).append(stringBuffer, i2, i3);
            substitute(append, 0, i3);
            return append.toString();
        }
        return (String) invokeLII.objValue;
    }

    public String replace(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            if (charSequence == null) {
                return null;
            }
            return replace(charSequence, 0, charSequence.length());
        }
        return (String) invokeL.objValue;
    }

    public String replace(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, i2, i3)) == null) {
            if (charSequence == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(i3).append(charSequence, i2, i3);
            substitute(append, 0, i3);
            return append.toString();
        }
        return (String) invokeLII.objValue;
    }

    public String replace(StrBuilder strBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, strBuilder)) == null) {
            if (strBuilder == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
            substitute(append, 0, append.length());
            return append.toString();
        }
        return (String) invokeL.objValue;
    }

    public String replace(StrBuilder strBuilder, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, strBuilder, i2, i3)) == null) {
            if (strBuilder == null) {
                return null;
            }
            StrBuilder append = new StrBuilder(i3).append(strBuilder, i2, i3);
            substitute(append, 0, i3);
            return append.toString();
        }
        return (String) invokeLII.objValue;
    }

    public String replace(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            StrBuilder append = new StrBuilder().append(obj);
            substitute(append, 0, append.length());
            return append.toString();
        }
        return (String) invokeL.objValue;
    }
}
