package org.apache.commons.lang3.text;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes9.dex */
public abstract class StrMatcher {
    public static /* synthetic */ Interceptable $ic;
    public static final StrMatcher COMMA_MATCHER;
    public static final StrMatcher DOUBLE_QUOTE_MATCHER;
    public static final StrMatcher NONE_MATCHER;
    public static final StrMatcher QUOTE_MATCHER;
    public static final StrMatcher SINGLE_QUOTE_MATCHER;
    public static final StrMatcher SPACE_MATCHER;
    public static final StrMatcher SPLIT_MATCHER;
    public static final StrMatcher TAB_MATCHER;
    public static final StrMatcher TRIM_MATCHER;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class CharMatcher extends StrMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final char ch;

        public CharMatcher(char c2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Character.valueOf(c2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ch = c2;
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            InterceptResult invokeLIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, cArr, i2, i3, i4)) == null) ? this.ch == cArr[i2] ? 1 : 0 : invokeLIII.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class CharSetMatcher extends StrMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final char[] chars;

        public CharSetMatcher(char[] cArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            InterceptResult invokeLIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, cArr, i2, i3, i4)) == null) ? Arrays.binarySearch(this.chars, cArr[i2]) >= 0 ? 1 : 0 : invokeLIII.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class NoMatcher extends StrMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NoMatcher() {
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

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            InterceptResult invokeLIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, cArr, i2, i3, i4)) == null) {
                return 0;
            }
            return invokeLIII.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class StringMatcher extends StrMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final char[] chars;

        public StringMatcher(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.chars = str.toCharArray();
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            InterceptResult invokeLIII;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLIII = interceptable.invokeLIII(1048576, this, cArr, i2, i3, i4)) != null) {
                return invokeLIII.intValue;
            }
            int length = this.chars.length;
            if (i2 + length > i4) {
                return 0;
            }
            int i5 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i5 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i5] != cArr[i2]) {
                    return 0;
                }
                i5++;
                i2++;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return super.toString() + WebvttCueParser.CHAR_SPACE + Arrays.toString(this.chars);
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class TrimMatcher extends StrMatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TrimMatcher() {
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

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i2, int i3, int i4) {
            InterceptResult invokeLIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, cArr, i2, i3, i4)) == null) ? cArr[i2] <= ' ' ? 1 : 0 : invokeLIII.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1175083373, "Lorg/apache/commons/lang3/text/StrMatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1175083373, "Lorg/apache/commons/lang3/text/StrMatcher;");
                return;
            }
        }
        COMMA_MATCHER = new CharMatcher(',');
        TAB_MATCHER = new CharMatcher('\t');
        SPACE_MATCHER = new CharMatcher(WebvttCueParser.CHAR_SPACE);
        SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
        TRIM_MATCHER = new TrimMatcher();
        SINGLE_QUOTE_MATCHER = new CharMatcher(ExtendedMessageFormat.QUOTE);
        DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
        QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
        NONE_MATCHER = new NoMatcher();
    }

    public StrMatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static StrMatcher charMatcher(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) ? new CharMatcher(c2) : (StrMatcher) invokeCommon.objValue;
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cArr)) == null) {
            if (cArr != null && cArr.length != 0) {
                if (cArr.length == 1) {
                    return new CharMatcher(cArr[0]);
                }
                return new CharSetMatcher(cArr);
            }
            return NONE_MATCHER;
        }
        return (StrMatcher) invokeL.objValue;
    }

    public static StrMatcher commaMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? COMMA_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher doubleQuoteMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? DOUBLE_QUOTE_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher noneMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? NONE_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher quoteMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? QUOTE_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher singleQuoteMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? SINGLE_QUOTE_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher spaceMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? SPACE_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher splitMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? SPLIT_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher stringMatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return NONE_MATCHER;
            }
            return new StringMatcher(str);
        }
        return (StrMatcher) invokeL.objValue;
    }

    public static StrMatcher tabMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? TAB_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public static StrMatcher trimMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? TRIM_MATCHER : (StrMatcher) invokeV.objValue;
    }

    public int isMatch(char[] cArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, cArr, i2)) == null) ? isMatch(cArr, i2, 0, cArr.length) : invokeLI.intValue;
    }

    public abstract int isMatch(char[] cArr, int i2, int i3, int i4);

    public static StrMatcher charSetMatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return NONE_MATCHER;
            }
            if (str.length() == 1) {
                return new CharMatcher(str.charAt(0));
            }
            return new CharSetMatcher(str.toCharArray());
        }
        return (StrMatcher) invokeL.objValue;
    }
}
