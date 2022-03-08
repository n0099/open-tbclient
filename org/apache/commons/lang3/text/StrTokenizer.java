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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes9.dex */
public class StrTokenizer implements ListIterator<String>, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final StrTokenizer CSV_TOKENIZER_PROTOTYPE;
    public static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public char[] chars;
    public StrMatcher delimMatcher;
    public boolean emptyAsNull;
    public boolean ignoreEmptyTokens;
    public StrMatcher ignoredMatcher;
    public StrMatcher quoteMatcher;
    public int tokenPos;
    public String[] tokens;
    public StrMatcher trimmerMatcher;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1438508338, "Lorg/apache/commons/lang3/text/StrTokenizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1438508338, "Lorg/apache/commons/lang3/text/StrTokenizer;");
                return;
            }
        }
        StrTokenizer strTokenizer = new StrTokenizer();
        CSV_TOKENIZER_PROTOTYPE = strTokenizer;
        strTokenizer.setDelimiterMatcher(StrMatcher.commaMatcher());
        CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
        CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
        CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
        CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
        StrTokenizer strTokenizer2 = new StrTokenizer();
        TSV_TOKENIZER_PROTOTYPE = strTokenizer2;
        strTokenizer2.setDelimiterMatcher(StrMatcher.tabMatcher());
        TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
        TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
        TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
        TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
    }

    public StrTokenizer() {
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
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    private void addToken(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, list, str) == null) {
            if (StringUtils.isEmpty(str)) {
                if (isIgnoreEmptyTokens()) {
                    return;
                }
                if (isEmptyTokenAsNull()) {
                    str = null;
                }
            }
            list.add(str);
        }
    }

    private void checkTokenized() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.tokens == null) {
            char[] cArr = this.chars;
            if (cArr == null) {
                List<String> list = tokenize(null, 0, 0);
                this.tokens = (String[]) list.toArray(new String[list.size()]);
                return;
            }
            List<String> list2 = tokenize(cArr, 0, cArr.length);
            this.tokens = (String[]) list2.toArray(new String[list2.size()]);
        }
    }

    public static StrTokenizer getCSVClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? (StrTokenizer) CSV_TOKENIZER_PROTOTYPE.clone() : (StrTokenizer) invokeV.objValue;
    }

    public static StrTokenizer getCSVInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? getCSVClone() : (StrTokenizer) invokeV.objValue;
    }

    public static StrTokenizer getTSVClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? (StrTokenizer) TSV_TOKENIZER_PROTOTYPE.clone() : (StrTokenizer) invokeV.objValue;
    }

    public static StrTokenizer getTSVInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? getTSVClone() : (StrTokenizer) invokeV.objValue;
    }

    private boolean isQuote(char[] cArr, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, this, new Object[]{cArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i2 + i6;
                if (i7 >= i3 || cArr[i7] != cArr[i4 + i6]) {
                    return false;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private int readNextToken(char[] cArr, int i2, int i3, StrBuilder strBuilder, List<String> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, this, new Object[]{cArr, Integer.valueOf(i2), Integer.valueOf(i3), strBuilder, list})) == null) {
            while (i2 < i3) {
                int max = Math.max(getIgnoredMatcher().isMatch(cArr, i2, i2, i3), getTrimmerMatcher().isMatch(cArr, i2, i2, i3));
                if (max == 0 || getDelimiterMatcher().isMatch(cArr, i2, i2, i3) > 0 || getQuoteMatcher().isMatch(cArr, i2, i2, i3) > 0) {
                    break;
                }
                i2 += max;
            }
            if (i2 >= i3) {
                addToken(list, "");
                return -1;
            }
            int isMatch = getDelimiterMatcher().isMatch(cArr, i2, i2, i3);
            if (isMatch > 0) {
                addToken(list, "");
                return i2 + isMatch;
            }
            int isMatch2 = getQuoteMatcher().isMatch(cArr, i2, i2, i3);
            if (isMatch2 > 0) {
                return readWithQuotes(cArr, i2 + isMatch2, i3, strBuilder, list, i2, isMatch2);
            }
            return readWithQuotes(cArr, i2, i3, strBuilder, list, 0, 0);
        }
        return invokeCommon.intValue;
    }

    private int readWithQuotes(char[] cArr, int i2, int i3, StrBuilder strBuilder, List<String> list, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, this, new Object[]{cArr, Integer.valueOf(i2), Integer.valueOf(i3), strBuilder, list, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            strBuilder.clear();
            boolean z = i5 > 0;
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                if (z) {
                    int i8 = i7;
                    int i9 = i6;
                    if (isQuote(cArr, i6, i3, i4, i5)) {
                        int i10 = i9 + i5;
                        if (isQuote(cArr, i10, i3, i4, i5)) {
                            strBuilder.append(cArr, i9, i5);
                            i6 = i9 + (i5 * 2);
                            i7 = strBuilder.size();
                        } else {
                            i7 = i8;
                            i6 = i10;
                            z = false;
                        }
                    } else {
                        i6 = i9 + 1;
                        strBuilder.append(cArr[i9]);
                        i7 = strBuilder.size();
                    }
                } else {
                    int i11 = i7;
                    int i12 = i6;
                    int isMatch = getDelimiterMatcher().isMatch(cArr, i12, i2, i3);
                    if (isMatch > 0) {
                        addToken(list, strBuilder.substring(0, i11));
                        return i12 + isMatch;
                    } else if (i5 <= 0 || !isQuote(cArr, i12, i3, i4, i5)) {
                        int isMatch2 = getIgnoredMatcher().isMatch(cArr, i12, i2, i3);
                        if (isMatch2 <= 0) {
                            isMatch2 = getTrimmerMatcher().isMatch(cArr, i12, i2, i3);
                            if (isMatch2 > 0) {
                                strBuilder.append(cArr, i12, isMatch2);
                            } else {
                                i6 = i12 + 1;
                                strBuilder.append(cArr[i12]);
                                i7 = strBuilder.size();
                            }
                        }
                        i6 = i12 + isMatch2;
                        i7 = i11;
                    } else {
                        i6 = i12 + i5;
                        i7 = i11;
                        z = true;
                    }
                }
            }
            addToken(list, strBuilder.substring(0, i7));
            return -1;
        }
        return invokeCommon.intValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return cloneReset();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    public Object cloneReset() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StrTokenizer strTokenizer = (StrTokenizer) super.clone();
            char[] cArr = strTokenizer.chars;
            if (cArr != null) {
                strTokenizer.chars = (char[]) cArr.clone();
            }
            strTokenizer.reset();
            return strTokenizer;
        }
        return invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.chars == null) {
                return null;
            }
            return new String(this.chars);
        }
        return (String) invokeV.objValue;
    }

    public StrMatcher getDelimiterMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delimMatcher : (StrMatcher) invokeV.objValue;
    }

    public StrMatcher getIgnoredMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.ignoredMatcher : (StrMatcher) invokeV.objValue;
    }

    public StrMatcher getQuoteMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.quoteMatcher : (StrMatcher) invokeV.objValue;
    }

    public String[] getTokenArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            checkTokenized();
            return (String[]) this.tokens.clone();
        }
        return (String[]) invokeV.objValue;
    }

    public List<String> getTokenList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            checkTokenized();
            ArrayList arrayList = new ArrayList(this.tokens.length);
            for (String str : this.tokens) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public StrMatcher getTrimmerMatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.trimmerMatcher : (StrMatcher) invokeV.objValue;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            checkTokenized();
            return this.tokenPos < this.tokens.length;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            checkTokenized();
            return this.tokenPos > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isEmptyTokenAsNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.emptyAsNull : invokeV.booleanValue;
    }

    public boolean isIgnoreEmptyTokens() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.ignoreEmptyTokens : invokeV.booleanValue;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.tokenPos : invokeV.intValue;
    }

    public String nextToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (hasNext()) {
                String[] strArr = this.tokens;
                int i2 = this.tokenPos;
                this.tokenPos = i2 + 1;
                return strArr[i2];
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.tokenPos - 1 : invokeV.intValue;
    }

    public String previousToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (hasPrevious()) {
                String[] strArr = this.tokens;
                int i2 = this.tokenPos - 1;
                this.tokenPos = i2;
                return strArr[i2];
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            throw new UnsupportedOperationException("remove() is unsupported");
        }
    }

    public StrTokenizer reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            this.tokenPos = 0;
            this.tokens = null;
            return this;
        }
        return (StrTokenizer) invokeV.objValue;
    }

    public StrTokenizer setDelimiterChar(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Character.valueOf(c2)})) == null) ? setDelimiterMatcher(StrMatcher.charMatcher(c2)) : (StrTokenizer) invokeCommon.objValue;
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, strMatcher)) == null) {
            if (strMatcher == null) {
                this.delimMatcher = StrMatcher.noneMatcher();
            } else {
                this.delimMatcher = strMatcher;
            }
            return this;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public StrTokenizer setDelimiterString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) ? setDelimiterMatcher(StrMatcher.stringMatcher(str)) : (StrTokenizer) invokeL.objValue;
    }

    public StrTokenizer setEmptyTokenAsNull(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
            this.emptyAsNull = z;
            return this;
        }
        return (StrTokenizer) invokeZ.objValue;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            this.ignoreEmptyTokens = z;
            return this;
        }
        return (StrTokenizer) invokeZ.objValue;
    }

    public StrTokenizer setIgnoredChar(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Character.valueOf(c2)})) == null) ? setIgnoredMatcher(StrMatcher.charMatcher(c2)) : (StrTokenizer) invokeCommon.objValue;
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, strMatcher)) == null) {
            if (strMatcher != null) {
                this.ignoredMatcher = strMatcher;
            }
            return this;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public StrTokenizer setQuoteChar(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Character.valueOf(c2)})) == null) ? setQuoteMatcher(StrMatcher.charMatcher(c2)) : (StrTokenizer) invokeCommon.objValue;
    }

    public StrTokenizer setQuoteMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, strMatcher)) == null) {
            if (strMatcher != null) {
                this.quoteMatcher = strMatcher;
            }
            return this;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, strMatcher)) == null) {
            if (strMatcher != null) {
                this.trimmerMatcher = strMatcher;
            }
            return this;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            checkTokenized();
            return this.tokens.length;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.tokens == null) {
                return "StrTokenizer[not tokenized yet]";
            }
            return "StrTokenizer" + getTokenList();
        }
        return (String) invokeV.objValue;
    }

    public List<String> tokenize(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048617, this, cArr, i2, i3)) == null) {
            if (cArr != null && i3 != 0) {
                StrBuilder strBuilder = new StrBuilder();
                ArrayList arrayList = new ArrayList();
                int i4 = i2;
                while (i4 >= 0 && i4 < i3) {
                    i4 = readNextToken(cArr, i4, i3, strBuilder, arrayList);
                    if (i4 >= i3) {
                        addToken(arrayList, "");
                    }
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeLII.objValue;
    }

    public static StrTokenizer getCSVInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            StrTokenizer cSVClone = getCSVClone();
            cSVClone.reset(str);
            return cSVClone;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public static StrTokenizer getTSVInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            StrTokenizer tSVClone = getTSVClone();
            tSVClone.reset(str);
            return tSVClone;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ListIterator
    public void add(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            throw new UnsupportedOperationException("add() is unsupported");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ListIterator, java.util.Iterator
    public String next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (hasNext()) {
                String[] strArr = this.tokens;
                int i2 = this.tokenPos;
                this.tokenPos = i2 + 1;
                return strArr[i2];
            }
            throw new NoSuchElementException();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ListIterator
    public String previous() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (hasPrevious()) {
                String[] strArr = this.tokens;
                int i2 = this.tokenPos - 1;
                this.tokenPos = i2;
                return strArr[i2];
            }
            throw new NoSuchElementException();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ListIterator
    public void set(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            throw new UnsupportedOperationException("set() is unsupported");
        }
    }

    public StrTokenizer reset(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            reset();
            if (str != null) {
                this.chars = str.toCharArray();
            } else {
                this.chars = null;
            }
            return this;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public static StrTokenizer getCSVInstance(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, cArr)) == null) {
            StrTokenizer cSVClone = getCSVClone();
            cSVClone.reset(cArr);
            return cSVClone;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public static StrTokenizer getTSVInstance(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, cArr)) == null) {
            StrTokenizer tSVClone = getTSVClone();
            tSVClone.reset(cArr);
            return tSVClone;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public StrTokenizer reset(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, cArr)) == null) {
            reset();
            this.chars = ArrayUtils.clone(cArr);
            return this;
        }
        return (StrTokenizer) invokeL.objValue;
    }

    public StrTokenizer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(String str, char c2) {
        this(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Character.valueOf(c2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setDelimiterChar(c2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(String str, String str2) {
        this(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        setDelimiterString(str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(String str, StrMatcher strMatcher) {
        this(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, strMatcher};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        setDelimiterMatcher(strMatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(String str, char c2, char c3) {
        this(str, c2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Character.valueOf(c2), Character.valueOf(c3)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Character) objArr2[1]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        setQuoteChar(c3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(String str, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(str, strMatcher);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, strMatcher, strMatcher2};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (StrMatcher) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        setQuoteMatcher(strMatcher2);
    }

    public StrTokenizer(char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr};
            interceptable.invokeUnInit(65544, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65544, newInitContext);
                return;
            }
        }
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = ArrayUtils.clone(cArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(char[] cArr, char c2) {
        this(cArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Character.valueOf(c2)};
            interceptable.invokeUnInit(65545, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((char[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65545, newInitContext);
                return;
            }
        }
        setDelimiterChar(c2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(char[] cArr, String str) {
        this(cArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, str};
            interceptable.invokeUnInit(65547, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((char[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65547, newInitContext);
                return;
            }
        }
        setDelimiterString(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(char[] cArr, StrMatcher strMatcher) {
        this(cArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, strMatcher};
            interceptable.invokeUnInit(65548, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((char[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65548, newInitContext);
                return;
            }
        }
        setDelimiterMatcher(strMatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(char[] cArr, char c2, char c3) {
        this(cArr, c2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Character.valueOf(c2), Character.valueOf(c3)};
            interceptable.invokeUnInit(65546, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((char[]) objArr2[0], ((Character) objArr2[1]).charValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65546, newInitContext);
                return;
            }
        }
        setQuoteChar(c3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrTokenizer(char[] cArr, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(cArr, strMatcher);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, strMatcher, strMatcher2};
            interceptable.invokeUnInit(65549, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((char[]) objArr2[0], (StrMatcher) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65549, newInitContext);
                return;
            }
        }
        setQuoteMatcher(strMatcher2);
    }
}
