package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.apache.commons.lang3.text.translate.NumericEntityEscaper;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.apache.commons.lang3.text.translate.OctalUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnescaper;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;
/* loaded from: classes5.dex */
public class StringEscapeUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final CharSequenceTranslator ESCAPE_CSV;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator ESCAPE_HTML3;
    public static final CharSequenceTranslator ESCAPE_HTML4;
    public static final CharSequenceTranslator ESCAPE_JAVA;
    public static final CharSequenceTranslator ESCAPE_JSON;
    @Deprecated
    public static final CharSequenceTranslator ESCAPE_XML;
    public static final CharSequenceTranslator ESCAPE_XML10;
    public static final CharSequenceTranslator ESCAPE_XML11;
    public static final CharSequenceTranslator UNESCAPE_CSV;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator UNESCAPE_HTML3;
    public static final CharSequenceTranslator UNESCAPE_HTML4;
    public static final CharSequenceTranslator UNESCAPE_JAVA;
    public static final CharSequenceTranslator UNESCAPE_JSON;
    public static final CharSequenceTranslator UNESCAPE_XML;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class CsvEscaper extends CharSequenceTranslator {
        public static /* synthetic */ Interceptable $ic = null;
        public static final char CSV_DELIMITER = ',';
        public static final char CSV_QUOTE = '\"';
        public static final String CSV_QUOTE_STR;
        public static final char[] CSV_SEARCH_CHARS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216747216, "Lorg/apache/commons/lang3/StringEscapeUtils$CsvEscaper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1216747216, "Lorg/apache/commons/lang3/StringEscapeUtils$CsvEscaper;");
                    return;
                }
            }
            CSV_QUOTE_STR = String.valueOf('\"');
            CSV_SEARCH_CHARS = new char[]{',', '\"', CharUtils.CR, '\n'};
        }

        public CsvEscaper() {
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

        @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
        public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, charSequence, i2, writer)) == null) {
                if (i2 == 0) {
                    if (StringUtils.containsNone(charSequence.toString(), CSV_SEARCH_CHARS)) {
                        writer.write(charSequence.toString());
                    } else {
                        writer.write(34);
                        String charSequence2 = charSequence.toString();
                        String str = CSV_QUOTE_STR;
                        writer.write(StringUtils.replace(charSequence2, str, CSV_QUOTE_STR + CSV_QUOTE_STR));
                        writer.write(34);
                    }
                    return Character.codePointCount(charSequence, 0, charSequence.length());
                }
                throw new IllegalStateException("CsvEscaper should never reach the [1] index");
            }
            return invokeLIL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class CsvUnescaper extends CharSequenceTranslator {
        public static /* synthetic */ Interceptable $ic = null;
        public static final char CSV_DELIMITER = ',';
        public static final char CSV_QUOTE = '\"';
        public static final String CSV_QUOTE_STR;
        public static final char[] CSV_SEARCH_CHARS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(271020777, "Lorg/apache/commons/lang3/StringEscapeUtils$CsvUnescaper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(271020777, "Lorg/apache/commons/lang3/StringEscapeUtils$CsvUnescaper;");
                    return;
                }
            }
            CSV_QUOTE_STR = String.valueOf('\"');
            CSV_SEARCH_CHARS = new char[]{',', '\"', CharUtils.CR, '\n'};
        }

        public CsvUnescaper() {
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

        @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
        public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, charSequence, i2, writer)) == null) {
                if (i2 == 0) {
                    if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                        String charSequence2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                        if (StringUtils.containsAny(charSequence2, CSV_SEARCH_CHARS)) {
                            writer.write(StringUtils.replace(charSequence2, CSV_QUOTE_STR + CSV_QUOTE_STR, CSV_QUOTE_STR));
                        } else {
                            writer.write(charSequence.toString());
                        }
                        return Character.codePointCount(charSequence, 0, charSequence.length());
                    }
                    writer.write(charSequence.toString());
                    return Character.codePointCount(charSequence, 0, charSequence.length());
                }
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            }
            return invokeLIL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1552372631, "Lorg/apache/commons/lang3/StringEscapeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1552372631, "Lorg/apache/commons/lang3/StringEscapeUtils;");
                return;
            }
        }
        ESCAPE_JAVA = new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\"}).with(new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())).with(JavaUnicodeEscaper.outsideOf(32, 127));
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new LookupTranslator(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\"}, new String[]{"/", "\\/"}), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), JavaUnicodeEscaper.outsideOf(32, 127));
        ESCAPE_JSON = new AggregateTranslator(new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\"}, new String[]{"/", "\\/"}), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()), JavaUnicodeEscaper.outsideOf(32, 127));
        ESCAPE_XML = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()));
        ESCAPE_XML10 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        ESCAPE_XML11 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.APOS_ESCAPE()), new LookupTranslator(new String[]{"\u0000", ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        ESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE()));
        ESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE()));
        ESCAPE_CSV = new CsvEscaper();
        AggregateTranslator aggregateTranslator = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()), new LookupTranslator(new String[]{"\\\\", IStringUtil.WINDOWS_FOLDER_SEPARATOR}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{IStringUtil.WINDOWS_FOLDER_SEPARATOR, ""}));
        UNESCAPE_JAVA = aggregateTranslator;
        UNESCAPE_ECMASCRIPT = aggregateTranslator;
        UNESCAPE_JSON = aggregateTranslator;
        UNESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE()), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_XML = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()), new LookupTranslator(EntityArrays.APOS_UNESCAPE()), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_CSV = new CsvUnescaper();
    }

    public StringEscapeUtils() {
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

    public static final String escapeCsv(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? ESCAPE_CSV.translate(str) : (String) invokeL.objValue;
    }

    public static final String escapeEcmaScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? ESCAPE_ECMASCRIPT.translate(str) : (String) invokeL.objValue;
    }

    public static final String escapeHtml3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? ESCAPE_HTML3.translate(str) : (String) invokeL.objValue;
    }

    public static final String escapeHtml4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? ESCAPE_HTML4.translate(str) : (String) invokeL.objValue;
    }

    public static final String escapeJava(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? ESCAPE_JAVA.translate(str) : (String) invokeL.objValue;
    }

    public static final String escapeJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? ESCAPE_JSON.translate(str) : (String) invokeL.objValue;
    }

    @Deprecated
    public static final String escapeXml(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? ESCAPE_XML.translate(str) : (String) invokeL.objValue;
    }

    public static String escapeXml10(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? ESCAPE_XML10.translate(str) : (String) invokeL.objValue;
    }

    public static String escapeXml11(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? ESCAPE_XML11.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeCsv(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? UNESCAPE_CSV.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeEcmaScript(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? UNESCAPE_ECMASCRIPT.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeHtml3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? UNESCAPE_HTML3.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeHtml4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? UNESCAPE_HTML4.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeJava(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? UNESCAPE_JAVA.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? UNESCAPE_JSON.translate(str) : (String) invokeL.objValue;
    }

    public static final String unescapeXml(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? UNESCAPE_XML.translate(str) : (String) invokeL.objValue;
    }
}
