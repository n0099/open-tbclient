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
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes3.dex */
public class ExtendedMessageFormat extends MessageFormat {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DUMMY_PATTERN = "";
    public static final char END_FE = '}';
    public static final int HASH_SEED = 31;
    public static final char QUOTE = '\'';
    public static final char START_FE = '{';
    public static final char START_FMT = ',';
    public static final long serialVersionUID = -2362048321261811743L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ? extends FormatFactory> registry;
    public String toPattern;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2016070941, "Lorg/apache/commons/lang3/text/ExtendedMessageFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2016070941, "Lorg/apache/commons/lang3/text/ExtendedMessageFormat;");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Locale) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private StringBuilder appendQuotedString(String str, ParsePosition parsePosition, StringBuilder sb) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, str, parsePosition, sb)) == null) {
            if (sb != null) {
                sb.append(QUOTE);
            }
            next(parsePosition);
            int index = parsePosition.getIndex();
            char[] charArray = str.toCharArray();
            for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
                if (charArray[parsePosition.getIndex()] != '\'') {
                    next(parsePosition);
                } else {
                    next(parsePosition);
                    if (sb == null) {
                        return null;
                    }
                    sb.append(charArray, index, parsePosition.getIndex() - index);
                    return sb;
                }
            }
            throw new IllegalArgumentException("Unterminated quoted string at position " + index);
        }
        return (StringBuilder) invokeLLL.objValue;
    }

    private boolean containsElements(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, collection)) == null) {
            if (collection != null && !collection.isEmpty()) {
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private Format getFormat(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            if (this.registry != null) {
                int indexOf = str.indexOf(44);
                if (indexOf > 0) {
                    String trim = str.substring(0, indexOf).trim();
                    str2 = str.substring(indexOf + 1).trim();
                    str = trim;
                } else {
                    str2 = null;
                }
                FormatFactory formatFactory = this.registry.get(str);
                if (formatFactory != null) {
                    return formatFactory.getFormat(str, str2, getLocale());
                }
            }
            return null;
        }
        return (Format) invokeL.objValue;
    }

    private void getQuotedString(String str, ParsePosition parsePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, parsePosition) == null) {
            appendQuotedString(str, parsePosition, null);
        }
    }

    private String insertFormats(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, arrayList)) == null) {
            if (containsElements(arrayList)) {
                StringBuilder sb = new StringBuilder(str.length() * 2);
                int i2 = 0;
                ParsePosition parsePosition = new ParsePosition(0);
                int i3 = -1;
                while (parsePosition.getIndex() < str.length()) {
                    char charAt = str.charAt(parsePosition.getIndex());
                    if (charAt == '\'') {
                        appendQuotedString(str, parsePosition, sb);
                    } else if (charAt != '{') {
                        if (charAt == '}') {
                            i2--;
                        }
                        sb.append(charAt);
                        next(parsePosition);
                    } else {
                        i2++;
                        sb.append(START_FE);
                        sb.append(readArgumentIndex(str, next(parsePosition)));
                        if (i2 == 1 && (str2 = arrayList.get((i3 = i3 + 1))) != null) {
                            sb.append(',');
                            sb.append(str2);
                        }
                    }
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    private ParsePosition next(ParsePosition parsePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, parsePosition)) == null) {
            parsePosition.setIndex(parsePosition.getIndex() + 1);
            return parsePosition;
        }
        return (ParsePosition) invokeL.objValue;
    }

    private String parseFormatDescription(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, parsePosition)) == null) {
            int index = parsePosition.getIndex();
            seekNonWs(str, parsePosition);
            int index2 = parsePosition.getIndex();
            int i2 = 1;
            while (parsePosition.getIndex() < str.length()) {
                char charAt = str.charAt(parsePosition.getIndex());
                if (charAt == '\'') {
                    getQuotedString(str, parsePosition);
                } else if (charAt == '{') {
                    i2++;
                } else if (charAt == '}' && i2 - 1 == 0) {
                    return str.substring(index2, parsePosition.getIndex());
                }
                next(parsePosition);
            }
            throw new IllegalArgumentException("Unterminated format element at position " + index);
        }
        return (String) invokeLL.objValue;
    }

    private int readArgumentIndex(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, parsePosition)) == null) {
            int index = parsePosition.getIndex();
            seekNonWs(str, parsePosition);
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (!z && parsePosition.getIndex() < str.length()) {
                char charAt = str.charAt(parsePosition.getIndex());
                if (Character.isWhitespace(charAt)) {
                    seekNonWs(str, parsePosition);
                    charAt = str.charAt(parsePosition.getIndex());
                    if (charAt != ',' && charAt != '}') {
                        z = true;
                        next(parsePosition);
                    }
                }
                if ((charAt == ',' || charAt == '}') && sb.length() > 0) {
                    try {
                        return Integer.parseInt(sb.toString());
                    } catch (NumberFormatException unused) {
                    }
                }
                sb.append(charAt);
                z = !Character.isDigit(charAt);
                next(parsePosition);
            }
            if (z) {
                throw new IllegalArgumentException("Invalid format argument index at position " + index + ": " + str.substring(index, parsePosition.getIndex()));
            }
            throw new IllegalArgumentException("Unterminated format element at position " + index);
        }
        return invokeLL.intValue;
    }

    private void seekNonWs(String str, ParsePosition parsePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, str, parsePosition) == null) {
            char[] charArray = str.toCharArray();
            do {
                int isMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
                parsePosition.setIndex(parsePosition.getIndex() + isMatch);
                if (isMatch <= 0) {
                    return;
                }
            } while (parsePosition.getIndex() < str.length());
        }
    }

    @Override // java.text.MessageFormat
    public final void applyPattern(String str) {
        String str2;
        Format format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.registry == null) {
                super.applyPattern(str);
                this.toPattern = super.toPattern();
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<String> arrayList2 = new ArrayList<>();
            StringBuilder sb = new StringBuilder(str.length());
            int i2 = 0;
            ParsePosition parsePosition = new ParsePosition(0);
            char[] charArray = str.toCharArray();
            int i3 = 0;
            while (parsePosition.getIndex() < str.length()) {
                char c2 = charArray[parsePosition.getIndex()];
                if (c2 != '\'') {
                    if (c2 == '{') {
                        i3++;
                        seekNonWs(str, parsePosition);
                        int index = parsePosition.getIndex();
                        int readArgumentIndex = readArgumentIndex(str, next(parsePosition));
                        sb.append(START_FE);
                        sb.append(readArgumentIndex);
                        seekNonWs(str, parsePosition);
                        if (charArray[parsePosition.getIndex()] == ',') {
                            str2 = parseFormatDescription(str, next(parsePosition));
                            format = getFormat(str2);
                            if (format == null) {
                                sb.append(',');
                                sb.append(str2);
                            }
                        } else {
                            str2 = null;
                            format = null;
                        }
                        arrayList.add(format);
                        arrayList2.add(format != null ? str2 : null);
                        Validate.isTrue(arrayList.size() == i3);
                        Validate.isTrue(arrayList2.size() == i3);
                        if (charArray[parsePosition.getIndex()] != '}') {
                            throw new IllegalArgumentException("Unreadable format element at position " + index);
                        }
                    }
                    sb.append(charArray[parsePosition.getIndex()]);
                    next(parsePosition);
                } else {
                    appendQuotedString(str, parsePosition, sb);
                }
            }
            super.applyPattern(sb.toString());
            this.toPattern = insertFormats(super.toPattern(), arrayList2);
            if (containsElements(arrayList)) {
                Format[] formats = getFormats();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Format format2 = (Format) it.next();
                    if (format2 != null) {
                        formats[i2] = format2;
                    }
                    i2++;
                }
                super.setFormats(formats);
            }
        }
    }

    @Override // java.text.MessageFormat
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !super.equals(obj) || ObjectUtils.notEqual(ExtendedMessageFormat.class, obj.getClass())) {
                return false;
            }
            ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat) obj;
            return (ObjectUtils.notEqual(this.toPattern, extendedMessageFormat.toPattern) || ObjectUtils.notEqual(this.registry, extendedMessageFormat.registry)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.text.MessageFormat
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (((super.hashCode() * 31) + ObjectUtils.hashCode(this.registry)) * 31) + ObjectUtils.hashCode(this.toPattern) : invokeV.intValue;
    }

    @Override // java.text.MessageFormat
    public void setFormat(int i2, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, format) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.text.MessageFormat
    public void setFormatByArgumentIndex(int i2, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, format) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.text.MessageFormat
    public void setFormats(Format[] formatArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, formatArr) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.text.MessageFormat
    public void setFormatsByArgumentIndex(Format[] formatArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, formatArr) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.text.MessageFormat
    public String toPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.toPattern : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, locale};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Locale) objArr2[1], (Map) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedMessageFormat(String str, Map<String, ? extends FormatFactory> map) {
        this(str, Locale.getDefault(), map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Locale) objArr2[1], (Map) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedMessageFormat(String str, Locale locale, Map<String, ? extends FormatFactory> map) {
        super("");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, locale, map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setLocale(locale);
        this.registry = map;
        applyPattern(str);
    }
}
