package org.apache.commons.lang3.text;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.Builder;
/* loaded from: classes4.dex */
public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAPACITY = 32;
    public static final long serialVersionUID = 7628716375283629643L;
    public transient /* synthetic */ FieldHolder $fh;
    public char[] buffer;
    public String newLine;
    public String nullText;
    public int size;

    /* loaded from: classes4.dex */
    public class StrBuilderTokenizer extends StrTokenizer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrBuilder this$0;

        public StrBuilderTokenizer(StrBuilder strBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = strBuilder;
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String content = super.getContent();
                return content == null ? this.this$0.toString() : content;
            }
            return (String) invokeV.objValue;
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public List<String> tokenize(char[] cArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cArr, i2, i3)) == null) {
                if (cArr == null) {
                    StrBuilder strBuilder = this.this$0;
                    return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
                }
                return super.tokenize(cArr, i2, i3);
            }
            return (List) invokeLII.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class StrBuilderWriter extends Writer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrBuilder this$0;

        public StrBuilderWriter(StrBuilder strBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = strBuilder;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // java.io.Writer
        public void write(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.this$0.append((char) i2);
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cArr) == null) {
                this.this$0.append(cArr);
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, cArr, i2, i3) == null) {
                this.this$0.append(cArr, i2, i3);
            }
        }

        @Override // java.io.Writer
        public void write(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.this$0.append(str);
            }
        }

        @Override // java.io.Writer
        public void write(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048580, this, str, i2, i3) == null) {
                this.this$0.append(str, i2, i3);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StrBuilder() {
        this(32);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void deleteImpl(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65539, this, i2, i3, i4) == null) {
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i3, cArr, i2, this.size - i3);
            this.size -= i4;
        }
    }

    private void replaceImpl(int i2, int i3, int i4, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5)}) == null) {
            int i6 = (this.size - i4) + i5;
            if (i5 != i4) {
                ensureCapacity(i6);
                char[] cArr = this.buffer;
                System.arraycopy(cArr, i3, cArr, i2 + i5, this.size - i3);
                this.size = i6;
            }
            if (i5 > 0) {
                str.getChars(0, i5, this.buffer, i2);
            }
        }
    }

    public <T> StrBuilder appendAll(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, tArr)) == null) {
            if (tArr != null && tArr.length > 0) {
                for (T t : tArr) {
                    append(t);
                }
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{obj, Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (i2 > 0) {
                ensureCapacity(this.size + i2);
                String nullText = obj == null ? getNullText() : obj.toString();
                if (nullText == null) {
                    nullText = "";
                }
                int length = nullText.length();
                if (length >= i2) {
                    nullText.getChars(length - i2, length, this.buffer, this.size);
                } else {
                    int i3 = i2 - length;
                    for (int i4 = 0; i4 < i3; i4++) {
                        this.buffer[this.size + i4] = c2;
                    }
                    nullText.getChars(0, length, this.buffer, this.size + i3);
                }
                this.size += i2;
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{obj, Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (i2 > 0) {
                ensureCapacity(this.size + i2);
                String nullText = obj == null ? getNullText() : obj.toString();
                if (nullText == null) {
                    nullText = "";
                }
                int length = nullText.length();
                if (length >= i2) {
                    nullText.getChars(0, i2, this.buffer, this.size);
                } else {
                    int i3 = i2 - length;
                    nullText.getChars(0, length, this.buffer, this.size);
                    for (int i4 = 0; i4 < i3; i4++) {
                        this.buffer[this.size + length + i4] = c2;
                    }
                }
                this.size += i2;
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendNewLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            String str = this.newLine;
            if (str == null) {
                append(SystemUtils.LINE_SEPARATOR);
                return this;
            }
            return append(str);
        }
        return (StrBuilder) invokeV.objValue;
    }

    public StrBuilder appendNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            String str = this.nullText;
            return str == null ? this : append(str);
        }
        return (StrBuilder) invokeV.objValue;
    }

    public StrBuilder appendPadding(int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (i2 >= 0) {
                ensureCapacity(this.size + i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    char[] cArr = this.buffer;
                    int i4 = this.size;
                    this.size = i4 + 1;
                    cArr[i4] = c2;
                }
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendSeparator(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) ? appendSeparator(str, (String) null) : (StrBuilder) invokeL.objValue;
    }

    public void appendTo(Appendable appendable) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, appendable) == null) {
            if (appendable instanceof Writer) {
                ((Writer) appendable).write(this.buffer, 0, this.size);
            } else if (appendable instanceof StringBuilder) {
                ((StringBuilder) appendable).append(this.buffer, 0, this.size);
            } else if (appendable instanceof StringBuffer) {
                ((StringBuffer) appendable).append(this.buffer, 0, this.size);
            } else if (appendable instanceof CharBuffer) {
                ((CharBuffer) appendable).put(this.buffer, 0, this.size);
            } else {
                appendable.append(this);
            }
        }
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, objArr, str)) == null) {
            if (objArr != null && objArr.length > 0) {
                String objectUtils = ObjectUtils.toString(str);
                append(objArr[0]);
                for (int i2 = 1; i2 < objArr.length; i2++) {
                    append(objectUtils);
                    append(objArr[i2]);
                }
            }
            return this;
        }
        return (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendln(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, obj)) == null) ? append(obj).appendNewLine() : (StrBuilder) invokeL.objValue;
    }

    public Reader asReader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? new StrBuilderReader(this) : (Reader) invokeV.objValue;
    }

    public StrTokenizer asTokenizer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? new StrBuilderTokenizer(this) : (StrTokenizer) invokeV.objValue;
    }

    public Writer asWriter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? new StrBuilderWriter(this) : (Writer) invokeV.objValue;
    }

    public int capacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.buffer.length : invokeV.intValue;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i2)) == null) {
            if (i2 >= 0 && i2 < length()) {
                return this.buffer[i2];
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return invokeI.charValue;
    }

    public StrBuilder clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            this.size = 0;
            return this;
        }
        return (StrBuilder) invokeV.objValue;
    }

    public boolean contains(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Character.valueOf(c2)})) == null) {
            char[] cArr = this.buffer;
            for (int i2 = 0; i2 < this.size; i2++) {
                if (cArr[i2] == c2) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public StrBuilder delete(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048650, this, i2, i3)) == null) {
            int validateRange = validateRange(i2, i3);
            int i4 = validateRange - i2;
            if (i4 > 0) {
                deleteImpl(i2, validateRange, i4);
            }
            return this;
        }
        return (StrBuilder) invokeII.objValue;
    }

    public StrBuilder deleteAll(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048651, this, new Object[]{Character.valueOf(c2)})) == null) {
            int i2 = 0;
            while (i2 < this.size) {
                if (this.buffer[i2] == c2) {
                    int i3 = i2;
                    do {
                        i3++;
                        if (i3 >= this.size) {
                            break;
                        }
                    } while (this.buffer[i3] == c2);
                    int i4 = i3 - i2;
                    deleteImpl(i2, i3, i4);
                    i2 = i3 - i4;
                }
                i2++;
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder deleteCharAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i2)) == null) {
            if (i2 >= 0 && i2 < this.size) {
                deleteImpl(i2, i2 + 1, 1);
                return this;
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return (StrBuilder) invokeI.objValue;
    }

    public StrBuilder deleteFirst(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{Character.valueOf(c2)})) == null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.size) {
                    break;
                } else if (this.buffer[i2] == c2) {
                    deleteImpl(i2, i2 + 1, 1);
                    break;
                } else {
                    i2++;
                }
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public boolean endsWith(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, str)) == null) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0) {
                return true;
            }
            int i2 = this.size;
            if (length > i2) {
                return false;
            }
            int i3 = i2 - length;
            int i4 = 0;
            while (i4 < length) {
                if (this.buffer[i3] != str.charAt(i4)) {
                    return false;
                }
                i4++;
                i3++;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public StrBuilder ensureCapacity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048659, this, i2)) == null) {
            char[] cArr = this.buffer;
            if (i2 > cArr.length) {
                char[] cArr2 = new char[i2 * 2];
                this.buffer = cArr2;
                System.arraycopy(cArr, 0, cArr2, 0, this.size);
            }
            return this;
        }
        return (StrBuilder) invokeI.objValue;
    }

    public boolean equals(StrBuilder strBuilder) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, strBuilder)) == null) {
            if (this == strBuilder) {
                return true;
            }
            if (strBuilder != null && (i2 = this.size) == strBuilder.size) {
                char[] cArr = this.buffer;
                char[] cArr2 = strBuilder.buffer;
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    if (cArr[i3] != cArr2[i3]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, strBuilder)) == null) {
            if (this == strBuilder) {
                return true;
            }
            int i2 = this.size;
            if (i2 != strBuilder.size) {
                return false;
            }
            char[] cArr = this.buffer;
            char[] cArr2 = strBuilder.buffer;
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                char c2 = cArr[i3];
                char c3 = cArr2[i3];
                if (c2 != c3 && Character.toUpperCase(c2) != Character.toUpperCase(c3)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public char[] getChars(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, cArr)) == null) {
            int length = length();
            if (cArr == null || cArr.length < length) {
                cArr = new char[length];
            }
            System.arraycopy(this.buffer, 0, cArr, 0, length);
            return cArr;
        }
        return (char[]) invokeL.objValue;
    }

    public String getNewLineText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.newLine : (String) invokeV.objValue;
    }

    public String getNullText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.nullText : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            char[] cArr = this.buffer;
            int i2 = 0;
            for (int i3 = this.size - 1; i3 >= 0; i3--) {
                i2 = (i2 * 31) + cArr[i3];
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int indexOf(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048668, this, new Object[]{Character.valueOf(c2)})) == null) ? indexOf(c2, 0) : invokeCommon.intValue;
    }

    public StrBuilder insert(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048679, this, i2, obj)) == null) {
            if (obj == null) {
                return insert(i2, this.nullText);
            }
            return insert(i2, obj.toString());
        }
        return (StrBuilder) invokeIL.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.size == 0 : invokeV.booleanValue;
    }

    public int lastIndexOf(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048685, this, new Object[]{Character.valueOf(c2)})) == null) ? lastIndexOf(c2, this.size - 1) : invokeCommon.intValue;
    }

    public String leftString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048691, this, i2)) == null) {
            if (i2 <= 0) {
                return "";
            }
            if (i2 >= this.size) {
                return new String(this.buffer, 0, this.size);
            }
            return new String(this.buffer, 0, i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // java.lang.CharSequence
    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.size : invokeV.intValue;
    }

    public String midString(int i2, int i3) {
        InterceptResult invokeII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048693, this, i2, i3)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 <= 0 || i2 >= (i4 = this.size)) {
                return "";
            }
            if (i4 <= i2 + i3) {
                return new String(this.buffer, i2, this.size - i2);
            }
            return new String(this.buffer, i2, i3);
        }
        return (String) invokeII.objValue;
    }

    public StrBuilder minimizeCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (this.buffer.length > length()) {
                char[] cArr = this.buffer;
                char[] cArr2 = new char[length()];
                this.buffer = cArr2;
                System.arraycopy(cArr, 0, cArr2, 0, this.size);
            }
            return this;
        }
        return (StrBuilder) invokeV.objValue;
    }

    public int readFrom(Readable readable) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, readable)) == null) {
            int i2 = this.size;
            if (readable instanceof Reader) {
                Reader reader = (Reader) readable;
                ensureCapacity(i2 + 1);
                while (true) {
                    char[] cArr = this.buffer;
                    int i3 = this.size;
                    int read = reader.read(cArr, i3, cArr.length - i3);
                    if (read == -1) {
                        break;
                    }
                    int i4 = this.size + read;
                    this.size = i4;
                    ensureCapacity(i4 + 1);
                }
            } else if (readable instanceof CharBuffer) {
                CharBuffer charBuffer = (CharBuffer) readable;
                int remaining = charBuffer.remaining();
                ensureCapacity(this.size + remaining);
                charBuffer.get(this.buffer, this.size, remaining);
                this.size += remaining;
            } else {
                while (true) {
                    ensureCapacity(this.size + 1);
                    char[] cArr2 = this.buffer;
                    int i5 = this.size;
                    int read2 = readable.read(CharBuffer.wrap(cArr2, i5, cArr2.length - i5));
                    if (read2 == -1) {
                        break;
                    }
                    this.size += read2;
                }
            }
            return this.size - i2;
        }
        return invokeL.intValue;
    }

    public StrBuilder replace(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048696, this, i2, i3, str)) == null) {
            int validateRange = validateRange(i2, i3);
            replaceImpl(i2, validateRange, validateRange - i2, str, str == null ? 0 : str.length());
            return this;
        }
        return (StrBuilder) invokeIIL.objValue;
    }

    public StrBuilder replaceAll(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (c2 != c3) {
                for (int i2 = 0; i2 < this.size; i2++) {
                    char[] cArr = this.buffer;
                    if (cArr[i2] == c2) {
                        cArr[i2] = c3;
                    }
                }
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder replaceFirst(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048701, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (c2 != c3) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.size) {
                        break;
                    }
                    char[] cArr = this.buffer;
                    if (cArr[i2] == c2) {
                        cArr[i2] = c3;
                        break;
                    }
                    i2++;
                }
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            int i2 = this.size;
            if (i2 == 0) {
                return this;
            }
            int i3 = i2 / 2;
            char[] cArr = this.buffer;
            int i4 = 0;
            int i5 = i2 - 1;
            while (i4 < i3) {
                char c2 = cArr[i4];
                cArr[i4] = cArr[i5];
                cArr[i5] = c2;
                i4++;
                i5--;
            }
            return this;
        }
        return (StrBuilder) invokeV.objValue;
    }

    public String rightString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048705, this, i2)) == null) {
            if (i2 <= 0) {
                return "";
            }
            if (i2 >= this.size) {
                return new String(this.buffer, 0, this.size);
            }
            return new String(this.buffer, this.size - i2, i2);
        }
        return (String) invokeI.objValue;
    }

    public StrBuilder setCharAt(int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048706, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            if (i2 >= 0 && i2 < length()) {
                this.buffer[i2] = c2;
                return this;
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder setLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048707, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = this.size;
                if (i2 < i3) {
                    this.size = i2;
                } else if (i2 > i3) {
                    ensureCapacity(i2);
                    this.size = i2;
                    for (int i4 = this.size; i4 < i2; i4++) {
                        this.buffer[i4] = 0;
                    }
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return (StrBuilder) invokeI.objValue;
    }

    public StrBuilder setNewLineText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, str)) == null) {
            this.newLine = str;
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder setNullText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048709, this, str)) == null) {
            if (str != null && str.isEmpty()) {
                str = null;
            }
            this.nullText = str;
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.size : invokeV.intValue;
    }

    public boolean startsWith(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048711, this, str)) == null) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0) {
                return true;
            }
            if (length > this.size) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (this.buffer[i2] != str.charAt(i2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048712, this, i2, i3)) == null) {
            if (i2 >= 0) {
                if (i3 <= this.size) {
                    if (i2 <= i3) {
                        return substring(i2, i3);
                    }
                    throw new StringIndexOutOfBoundsException(i3 - i2);
                }
                throw new StringIndexOutOfBoundsException(i3);
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return (CharSequence) invokeII.objValue;
    }

    public String substring(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048713, this, i2)) == null) ? substring(i2, this.size) : (String) invokeI.objValue;
    }

    public char[] toCharArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            int i2 = this.size;
            if (i2 == 0) {
                return ArrayUtils.EMPTY_CHAR_ARRAY;
            }
            char[] cArr = new char[i2];
            System.arraycopy(this.buffer, 0, cArr, 0, i2);
            return cArr;
        }
        return (char[]) invokeV.objValue;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? new String(this.buffer, 0, this.size) : (String) invokeV.objValue;
    }

    public StringBuffer toStringBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer(this.size);
            stringBuffer.append(this.buffer, 0, this.size);
            return stringBuffer;
        }
        return (StringBuffer) invokeV.objValue;
    }

    public StringBuilder toStringBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            StringBuilder sb = new StringBuilder(this.size);
            sb.append(this.buffer, 0, this.size);
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public StrBuilder trim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            int i2 = this.size;
            if (i2 == 0) {
                return this;
            }
            char[] cArr = this.buffer;
            int i3 = 0;
            while (i3 < i2 && cArr[i3] <= ' ') {
                i3++;
            }
            while (i3 < i2 && cArr[i2 - 1] <= ' ') {
                i2--;
            }
            int i4 = this.size;
            if (i2 < i4) {
                delete(i2, i4);
            }
            if (i3 > 0) {
                delete(0, i3);
            }
            return this;
        }
        return (StrBuilder) invokeV.objValue;
    }

    public void validateIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i2) == null) {
            if (i2 < 0 || i2 > this.size) {
                throw new StringIndexOutOfBoundsException(i2);
            }
        }
    }

    public int validateRange(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048722, this, i2, i3)) == null) {
            if (i2 >= 0) {
                int i4 = this.size;
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i2 <= i3) {
                    return i3;
                }
                throw new StringIndexOutOfBoundsException("end < start");
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
        return invokeII.intValue;
    }

    /* loaded from: classes4.dex */
    public class StrBuilderReader extends Reader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mark;
        public int pos;
        public final /* synthetic */ StrBuilder this$0;

        public StrBuilderReader(StrBuilder strBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = strBuilder;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // java.io.Reader
        public void mark(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.mark = this.pos;
            }
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.io.Reader
        public int read() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (ready()) {
                    StrBuilder strBuilder = this.this$0;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    return strBuilder.charAt(i2);
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // java.io.Reader
        public boolean ready() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pos < this.this$0.size() : invokeV.booleanValue;
        }

        @Override // java.io.Reader
        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.pos = this.mark;
            }
        }

        @Override // java.io.Reader
        public long skip(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                if (this.pos + j2 > this.this$0.size()) {
                    j2 = this.this$0.size() - this.pos;
                }
                if (j2 < 0) {
                    return 0L;
                }
                this.pos = (int) (this.pos + j2);
                return j2;
            }
            return invokeJ.longValue;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) {
            InterceptResult invokeLII;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, cArr, i2, i3)) == null) {
                if (i2 < 0 || i3 < 0 || i2 > cArr.length || (i4 = i2 + i3) > cArr.length || i4 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (i3 == 0) {
                    return 0;
                }
                if (this.pos >= this.this$0.size()) {
                    return -1;
                }
                if (this.pos + i3 > this.this$0.size()) {
                    i3 = this.this$0.size() - this.pos;
                }
                StrBuilder strBuilder = this.this$0;
                int i5 = this.pos;
                strBuilder.getChars(i5, i5 + i3, cArr, i2);
                this.pos += i3;
                return i3;
            }
            return invokeLII.intValue;
        }
    }

    public StrBuilder(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.buffer = new char[i2 <= 0 ? 32 : i2];
    }

    public StrBuilder appendSeparator(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, str, str2)) == null) {
            if (isEmpty()) {
                str = str2;
            }
            if (str != null) {
                append(str);
            }
            return this;
        }
        return (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendln(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) ? append(str).appendNewLine() : (StrBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.builder.Builder
    public String build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? toString() : (String) invokeV.objValue;
    }

    public int indexOf(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048669, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= this.size) {
                return -1;
            }
            char[] cArr = this.buffer;
            while (i2 < this.size) {
                if (cArr[i2] == c2) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public int lastIndexOf(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048686, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            int i3 = this.size;
            if (i2 >= i3) {
                i2 = i3 - 1;
            }
            if (i2 < 0) {
                return -1;
            }
            while (i2 >= 0) {
                if (this.buffer[i2] == c2) {
                    return i2;
                }
                i2--;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public String substring(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048714, this, i2, i3)) == null) ? new String(this.buffer, i2, validateRange(i2, i3) - i2) : (String) invokeII.objValue;
    }

    public StrBuilder appendln(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048628, this, str, i2, i3)) == null) ? append(str, i2, i3).appendNewLine() : (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder insert(int i2, String str) {
        InterceptResult invokeIL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048680, this, i2, str)) == null) {
            validateIndex(i2);
            if (str == null) {
                str = this.nullText;
            }
            if (str != null && (length = str.length()) > 0) {
                int i3 = this.size + length;
                ensureCapacity(i3);
                char[] cArr = this.buffer;
                System.arraycopy(cArr, i2, cArr, i2 + length, this.size - i2);
                this.size = i3;
                str.getChars(0, length, this.buffer, i2);
            }
            return this;
        }
        return (StrBuilder) invokeIL.objValue;
    }

    public StrBuilder(String str) {
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
        if (str == null) {
            this.buffer = new char[32];
            return;
        }
        this.buffer = new char[str.length() + 32];
        append(str);
    }

    public StrBuilder append(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (obj == null) {
                return appendNull();
            }
            if (obj instanceof CharSequence) {
                return append((CharSequence) obj);
            }
            return append(obj.toString());
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, iterable)) == null) {
            if (iterable != null) {
                Iterator<?> it = iterable.iterator();
                while (it.hasNext()) {
                    append(it.next());
                }
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder appendSeparator(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Character.valueOf(c2)})) == null) {
            if (size() > 0) {
                append(c2);
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendln(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048629, this, str, objArr)) == null) ? append(str, objArr).appendNewLine() : (StrBuilder) invokeLL.objValue;
    }

    public boolean contains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, str)) == null) ? indexOf(str, 0) >= 0 : invokeL.booleanValue;
    }

    public StrBuilder deleteFirst(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, str)) == null) {
            int length = str == null ? 0 : str.length();
            if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public int lastIndexOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, str)) == null) ? lastIndexOf(str, this.size - 1) : invokeL.intValue;
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048697, this, new Object[]{strMatcher, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? replaceImpl(strMatcher, str, i2, validateRange(i2, i3), i4) : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder replaceAll(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048699, this, str, str2)) == null) {
            int length = str == null ? 0 : str.length();
            if (length > 0) {
                int length2 = str2 == null ? 0 : str2.length();
                int indexOf = indexOf(str, 0);
                while (indexOf >= 0) {
                    replaceImpl(indexOf, indexOf + length, length, str2, length2);
                    indexOf = indexOf(str, indexOf + length2);
                }
            }
            return this;
        }
        return (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048702, this, str, str2)) == null) {
            int length = str == null ? 0 : str.length();
            if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
                replaceImpl(indexOf, indexOf + length, length, str2, str2 == null ? 0 : str2.length());
            }
            return this;
        }
        return (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, stringBuffer)) == null) ? append(stringBuffer).appendNewLine() : (StrBuilder) invokeL.objValue;
    }

    public boolean contains(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, strMatcher)) == null) ? indexOf(strMatcher, 0) >= 0 : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, obj)) == null) ? (obj instanceof StrBuilder) && equals((StrBuilder) obj) : invokeL.booleanValue;
    }

    public void getChars(int i2, int i3, char[] cArr, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), cArr, Integer.valueOf(i4)}) == null) {
            if (i2 >= 0) {
                if (i3 < 0 || i3 > length()) {
                    throw new StringIndexOutOfBoundsException(i3);
                }
                if (i2 <= i3) {
                    System.arraycopy(this.buffer, i2, cArr, i4, i3 - i2);
                    return;
                }
                throw new StringIndexOutOfBoundsException("end < start");
            }
            throw new StringIndexOutOfBoundsException(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
        r9 = r9 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int lastIndexOf(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048688, this, str, i2)) == null) {
            int i3 = this.size;
            if (i2 >= i3) {
                i2 = i3 - 1;
            }
            if (str != null && i2 >= 0) {
                int length = str.length();
                if (length > 0 && length <= this.size) {
                    if (length == 1) {
                        return lastIndexOf(str.charAt(0), i2);
                    }
                    int i4 = (i2 - length) + 1;
                    while (i4 >= 0) {
                        for (int i5 = 0; i5 < length; i5++) {
                            if (str.charAt(i5) != this.buffer[i4 + i5]) {
                                break;
                            }
                        }
                        return i4;
                    }
                } else if (length == 0) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public char[] toCharArray(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048716, this, i2, i3)) == null) {
            int validateRange = validateRange(i2, i3) - i2;
            if (validateRange == 0) {
                return ArrayUtils.EMPTY_CHAR_ARRAY;
            }
            char[] cArr = new char[validateRange];
            System.arraycopy(this.buffer, i2, cArr, 0, validateRange);
            return cArr;
        }
        return (char[]) invokeII.objValue;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{strMatcher, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (strMatcher != null && this.size != 0) {
                int length = str == null ? 0 : str.length();
                char[] cArr = this.buffer;
                int i5 = i2;
                while (i5 < i3 && i4 != 0) {
                    int isMatch = strMatcher.isMatch(cArr, i5, i2, i3);
                    if (isMatch > 0) {
                        replaceImpl(i5, i5 + isMatch, isMatch, str, length);
                        i3 = (i3 - isMatch) + length;
                        i5 = (i5 + length) - 1;
                        if (i4 > 0) {
                            i4--;
                        }
                    }
                    i5++;
                }
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendAll(Iterator<?> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, it)) == null) {
            if (it != null) {
                while (it.hasNext()) {
                    append(it.next());
                }
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder appendSeparator(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (size() > 0) {
                append(c2);
            } else {
                append(c3);
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendln(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, sb)) == null) ? append(sb).appendNewLine() : (StrBuilder) invokeL.objValue;
    }

    public StrBuilder deleteAll(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, str)) == null) {
            int length = str == null ? 0 : str.length();
            if (length > 0) {
                int indexOf = indexOf(str, 0);
                while (indexOf >= 0) {
                    deleteImpl(indexOf, indexOf + length, length);
                    indexOf = indexOf(str, indexOf);
                }
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public int indexOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, str)) == null) ? indexOf(str, 0) : invokeL.intValue;
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, iterable, str)) == null) {
            if (iterable != null) {
                String objectUtils = ObjectUtils.toString(str);
                Iterator<?> it = iterable.iterator();
                while (it.hasNext()) {
                    append(it.next());
                    if (it.hasNext()) {
                        append(objectUtils);
                    }
                }
            }
            return this;
        }
        return (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendln(StringBuilder sb, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048633, this, sb, i2, i3)) == null) ? append(sb, i2, i3).appendNewLine() : (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, strMatcher)) == null) ? replace(strMatcher, null, 0, this.size, 1) : (StrBuilder) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int indexOf(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048671, this, str, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (str != null && i2 < this.size) {
                int length = str.length();
                if (length == 1) {
                    return indexOf(str.charAt(0), i2);
                }
                if (length == 0) {
                    return i2;
                }
                int i3 = this.size;
                if (length > i3) {
                    return -1;
                }
                char[] cArr = this.buffer;
                int i4 = (i3 - length) + 1;
                while (i2 < i4) {
                    for (int i5 = 0; i5 < length; i5++) {
                        if (str.charAt(i5) != cArr[i2 + i5]) {
                            break;
                        }
                    }
                    return i2;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) {
            if (charSequence == null) {
                return appendNull();
            }
            if (charSequence instanceof StrBuilder) {
                return append((StrBuilder) charSequence);
            }
            if (charSequence instanceof StringBuilder) {
                return append((StringBuilder) charSequence);
            }
            if (charSequence instanceof StringBuffer) {
                return append((StringBuffer) charSequence);
            }
            if (charSequence instanceof CharBuffer) {
                return append((CharBuffer) charSequence);
            }
            return append(charSequence.toString());
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder appendFixedWidthPadLeft(int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) ? appendFixedWidthPadLeft(String.valueOf(i2), i3, c2) : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendFixedWidthPadRight(int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) ? appendFixedWidthPadRight(String.valueOf(i2), i3, c2) : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048631, this, stringBuffer, i2, i3)) == null) ? append(stringBuffer, i2, i3).appendNewLine() : (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048703, this, strMatcher, str)) == null) ? replace(strMatcher, str, 0, this.size, 1) : (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendSeparator(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048615, this, str, i2)) == null) {
            if (str != null && i2 > 0) {
                append(str);
            }
            return this;
        }
        return (StrBuilder) invokeLI.objValue;
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, strBuilder)) == null) ? append(strBuilder).appendNewLine() : (StrBuilder) invokeL.objValue;
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048700, this, strMatcher, str)) == null) ? replace(strMatcher, str, 0, this.size, -1) : (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendSeparator(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) {
            if (i2 > 0) {
                append(c2);
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048635, this, strBuilder, i2, i3)) == null) ? append(strBuilder, i2, i3).appendNewLine() : (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, strMatcher)) == null) ? replace(strMatcher, null, 0, this.size, -1) : (StrBuilder) invokeL.objValue;
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, strMatcher)) == null) ? lastIndexOf(strMatcher, this.size) : invokeL.intValue;
    }

    public StrBuilder appendln(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, cArr)) == null) ? append(cArr).appendNewLine() : (StrBuilder) invokeL.objValue;
    }

    public StrBuilder insert(int i2, char[] cArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048682, this, i2, cArr)) == null) {
            validateIndex(i2);
            if (cArr == null) {
                return insert(i2, this.nullText);
            }
            int length = cArr.length;
            if (length > 0) {
                ensureCapacity(this.size + length);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i2, cArr2, i2 + length, this.size - i2);
                System.arraycopy(cArr, 0, this.buffer, i2, length);
                this.size += length;
            }
            return this;
        }
        return (StrBuilder) invokeIL.objValue;
    }

    public int lastIndexOf(StrMatcher strMatcher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048690, this, strMatcher, i2)) == null) {
            int i3 = this.size;
            if (i2 >= i3) {
                i2 = i3 - 1;
            }
            if (strMatcher != null && i2 >= 0) {
                char[] cArr = this.buffer;
                int i4 = i2 + 1;
                while (i2 >= 0) {
                    if (strMatcher.isMatch(cArr, i2, 0, i4) > 0) {
                        return i2;
                    }
                    i2--;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public StrBuilder appendln(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048638, this, cArr, i2, i3)) == null) ? append(cArr, i2, i3).appendNewLine() : (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder appendWithSeparators(Iterator<?> it, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, it, str)) == null) {
            if (it != null) {
                String objectUtils = ObjectUtils.toString(str);
                while (it.hasNext()) {
                    append(it.next());
                    if (it.hasNext()) {
                        append(objectUtils);
                    }
                }
            }
            return this;
        }
        return (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder appendln(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048636, this, z)) == null) ? append(z).appendNewLine() : (StrBuilder) invokeZ.objValue;
    }

    public int indexOf(StrMatcher strMatcher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, strMatcher)) == null) ? indexOf(strMatcher, 0) : invokeL.intValue;
    }

    public StrBuilder appendln(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{Character.valueOf(c2)})) == null) ? append(c2).appendNewLine() : (StrBuilder) invokeCommon.objValue;
    }

    public int indexOf(StrMatcher strMatcher, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048673, this, strMatcher, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (strMatcher != null && i2 < (i3 = this.size)) {
                char[] cArr = this.buffer;
                for (int i4 = i2; i4 < i3; i4++) {
                    if (strMatcher.isMatch(cArr, i4, i2, i3) > 0) {
                        return i4;
                    }
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public StrBuilder appendln(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) ? append(i2).appendNewLine() : (StrBuilder) invokeI.objValue;
    }

    public StrBuilder appendln(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048625, this, j2)) == null) ? append(j2).appendNewLine() : (StrBuilder) invokeJ.objValue;
    }

    public StrBuilder appendln(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048623, this, f2)) == null) ? append(f2).appendNewLine() : (StrBuilder) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, charSequence, i2, i3)) == null) {
            if (charSequence == null) {
                return appendNull();
            }
            return append(charSequence.toString(), i2, i3);
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder appendln(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Double.valueOf(d2)})) == null) ? append(d2).appendNewLine() : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder insert(int i2, char[] cArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i2), cArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            validateIndex(i2);
            if (cArr == null) {
                return insert(i2, this.nullText);
            }
            if (i3 >= 0 && i3 <= cArr.length) {
                if (i4 < 0 || i3 + i4 > cArr.length) {
                    throw new StringIndexOutOfBoundsException("Invalid length: " + i4);
                }
                if (i4 > 0) {
                    ensureCapacity(this.size + i4);
                    char[] cArr2 = this.buffer;
                    System.arraycopy(cArr2, i2, cArr2, i2 + i4, this.size - i2);
                    System.arraycopy(cArr, i3, this.buffer, i2, i4);
                    this.size += i4;
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException("Invalid offset: " + i3);
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder append(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (str == null) {
                return appendNull();
            }
            int length = str.length();
            if (length > 0) {
                int length2 = length();
                ensureCapacity(length2 + length);
                str.getChars(0, length, this.buffer, length2);
                this.size += length;
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder append(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, str, i2, i3)) == null) {
            if (str == null) {
                return appendNull();
            }
            if (i2 >= 0 && i2 <= str.length()) {
                if (i3 < 0 || (i4 = i2 + i3) > str.length()) {
                    throw new StringIndexOutOfBoundsException("length must be valid");
                }
                if (i3 > 0) {
                    int length = length();
                    ensureCapacity(length + i3);
                    str.getChars(i2, i4, this.buffer, length);
                    this.size += i3;
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder insert(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048681, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            validateIndex(i2);
            if (z) {
                ensureCapacity(this.size + 4);
                char[] cArr = this.buffer;
                System.arraycopy(cArr, i2, cArr, i2 + 4, this.size - i2);
                char[] cArr2 = this.buffer;
                int i3 = i2 + 1;
                cArr2[i2] = 't';
                int i4 = i3 + 1;
                cArr2[i3] = 'r';
                cArr2[i4] = 'u';
                cArr2[i4 + 1] = 'e';
                this.size += 4;
            } else {
                ensureCapacity(this.size + 5);
                char[] cArr3 = this.buffer;
                System.arraycopy(cArr3, i2, cArr3, i2 + 5, this.size - i2);
                char[] cArr4 = this.buffer;
                int i5 = i2 + 1;
                cArr4[i2] = 'f';
                int i6 = i5 + 1;
                cArr4[i5] = 'a';
                int i7 = i6 + 1;
                cArr4[i6] = 'l';
                cArr4[i7] = 's';
                cArr4[i7 + 1] = 'e';
                this.size += 5;
            }
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder append(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, objArr)) == null) ? append(String.format(str, objArr)) : (StrBuilder) invokeLL.objValue;
    }

    public StrBuilder append(CharBuffer charBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charBuffer)) == null) {
            if (charBuffer == null) {
                return appendNull();
            }
            if (charBuffer.hasArray()) {
                int remaining = charBuffer.remaining();
                int length = length();
                ensureCapacity(length + remaining);
                System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position(), this.buffer, length, remaining);
                this.size += remaining;
            } else {
                append(charBuffer.toString());
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder append(CharBuffer charBuffer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, charBuffer, i2, i3)) == null) {
            if (charBuffer == null) {
                return appendNull();
            }
            if (charBuffer.hasArray()) {
                int remaining = charBuffer.remaining();
                if (i2 < 0 || i2 > remaining) {
                    throw new StringIndexOutOfBoundsException("startIndex must be valid");
                }
                if (i3 >= 0 && i2 + i3 <= remaining) {
                    int length = length();
                    ensureCapacity(length + i3);
                    System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i2, this.buffer, length, i3);
                    this.size += i3;
                } else {
                    throw new StringIndexOutOfBoundsException("length must be valid");
                }
            } else {
                append(charBuffer.toString(), i2, i3);
            }
            return this;
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder insert(int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048674, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            validateIndex(i2);
            ensureCapacity(this.size + 1);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i2 + 1, this.size - i2);
            this.buffer[i2] = c2;
            this.size++;
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder insert(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048677, this, i2, i3)) == null) ? insert(i2, String.valueOf(i3)) : (StrBuilder) invokeII.objValue;
    }

    public StrBuilder insert(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048678, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? insert(i2, String.valueOf(j2)) : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder insert(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048676, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? insert(i2, String.valueOf(f2)) : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder insert(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) ? insert(i2, String.valueOf(d2)) : (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, stringBuffer)) == null) {
            if (stringBuffer == null) {
                return appendNull();
            }
            int length = stringBuffer.length();
            if (length > 0) {
                int length2 = length();
                ensureCapacity(length2 + length);
                stringBuffer.getChars(0, length, this.buffer, length2);
                this.size += length;
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder append(StringBuffer stringBuffer, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, stringBuffer, i2, i3)) == null) {
            if (stringBuffer == null) {
                return appendNull();
            }
            if (i2 >= 0 && i2 <= stringBuffer.length()) {
                if (i3 < 0 || (i4 = i2 + i3) > stringBuffer.length()) {
                    throw new StringIndexOutOfBoundsException("length must be valid");
                }
                if (i3 > 0) {
                    int length = length();
                    ensureCapacity(length + i3);
                    stringBuffer.getChars(i2, i4, this.buffer, length);
                    this.size += i3;
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder append(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, sb)) == null) {
            if (sb == null) {
                return appendNull();
            }
            int length = sb.length();
            if (length > 0) {
                int length2 = length();
                ensureCapacity(length2 + length);
                sb.getChars(0, length, this.buffer, length2);
                this.size += length;
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder append(StringBuilder sb, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, sb, i2, i3)) == null) {
            if (sb == null) {
                return appendNull();
            }
            if (i2 >= 0 && i2 <= sb.length()) {
                if (i3 < 0 || (i4 = i2 + i3) > sb.length()) {
                    throw new StringIndexOutOfBoundsException("length must be valid");
                }
                if (i3 > 0) {
                    int length = length();
                    ensureCapacity(length + i3);
                    sb.getChars(i2, i4, this.buffer, length);
                    this.size += i3;
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder append(StrBuilder strBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, strBuilder)) == null) {
            if (strBuilder == null) {
                return appendNull();
            }
            int length = strBuilder.length();
            if (length > 0) {
                int length2 = length();
                ensureCapacity(length2 + length);
                System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
                this.size += length;
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder append(StrBuilder strBuilder, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, strBuilder, i2, i3)) == null) {
            if (strBuilder == null) {
                return appendNull();
            }
            if (i2 >= 0 && i2 <= strBuilder.length()) {
                if (i3 < 0 || (i4 = i2 + i3) > strBuilder.length()) {
                    throw new StringIndexOutOfBoundsException("length must be valid");
                }
                if (i3 > 0) {
                    int length = length();
                    ensureCapacity(length + i3);
                    strBuilder.getChars(i2, i4, this.buffer, length);
                    this.size += i3;
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder append(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, cArr)) == null) {
            if (cArr == null) {
                return appendNull();
            }
            int length = cArr.length;
            if (length > 0) {
                int length2 = length();
                ensureCapacity(length2 + length);
                System.arraycopy(cArr, 0, this.buffer, length2, length);
                this.size += length;
            }
            return this;
        }
        return (StrBuilder) invokeL.objValue;
    }

    public StrBuilder append(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048600, this, cArr, i2, i3)) == null) {
            if (cArr == null) {
                return appendNull();
            }
            if (i2 >= 0 && i2 <= cArr.length) {
                if (i3 < 0 || i2 + i3 > cArr.length) {
                    throw new StringIndexOutOfBoundsException("Invalid length: " + i3);
                }
                if (i3 > 0) {
                    int length = length();
                    ensureCapacity(length + i3);
                    System.arraycopy(cArr, i2, this.buffer, length, i3);
                    this.size += i3;
                }
                return this;
            }
            throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i3);
        }
        return (StrBuilder) invokeLII.objValue;
    }

    public StrBuilder append(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            if (z) {
                ensureCapacity(this.size + 4);
                char[] cArr = this.buffer;
                int i2 = this.size;
                int i3 = i2 + 1;
                this.size = i3;
                cArr[i2] = 't';
                int i4 = i3 + 1;
                this.size = i4;
                cArr[i3] = 'r';
                int i5 = i4 + 1;
                this.size = i5;
                cArr[i4] = 'u';
                this.size = i5 + 1;
                cArr[i5] = 'e';
            } else {
                ensureCapacity(this.size + 5);
                char[] cArr2 = this.buffer;
                int i6 = this.size;
                int i7 = i6 + 1;
                this.size = i7;
                cArr2[i6] = 'f';
                int i8 = i7 + 1;
                this.size = i8;
                cArr2[i7] = 'a';
                int i9 = i8 + 1;
                this.size = i9;
                cArr2[i8] = 'l';
                int i10 = i9 + 1;
                this.size = i10;
                cArr2[i9] = 's';
                this.size = i10 + 1;
                cArr2[i10] = 'e';
            }
            return this;
        }
        return (StrBuilder) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Appendable
    public StrBuilder append(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Character.valueOf(c2)})) == null) {
            ensureCapacity(length() + 1);
            char[] cArr = this.buffer;
            int i2 = this.size;
            this.size = i2 + 1;
            cArr[i2] = c2;
            return this;
        }
        return (StrBuilder) invokeCommon.objValue;
    }

    public StrBuilder append(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? append(String.valueOf(i2)) : (StrBuilder) invokeI.objValue;
    }

    public StrBuilder append(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? append(String.valueOf(j2)) : (StrBuilder) invokeJ.objValue;
    }

    public StrBuilder append(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) ? append(String.valueOf(f2)) : (StrBuilder) invokeF.objValue;
    }

    public StrBuilder append(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)})) == null) ? append(String.valueOf(d2)) : (StrBuilder) invokeCommon.objValue;
    }
}
