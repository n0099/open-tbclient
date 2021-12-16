package com.google.gson.stream;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class JsonReader implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    public static final char[] NON_EXECUTE_PREFIX;
    public static final int NUMBER_CHAR_DECIMAL = 3;
    public static final int NUMBER_CHAR_DIGIT = 2;
    public static final int NUMBER_CHAR_EXP_DIGIT = 7;
    public static final int NUMBER_CHAR_EXP_E = 5;
    public static final int NUMBER_CHAR_EXP_SIGN = 6;
    public static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    public static final int NUMBER_CHAR_NONE = 0;
    public static final int NUMBER_CHAR_SIGN = 1;
    public static final int PEEKED_BEGIN_ARRAY = 3;
    public static final int PEEKED_BEGIN_OBJECT = 1;
    public static final int PEEKED_BUFFERED = 11;
    public static final int PEEKED_DOUBLE_QUOTED = 9;
    public static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    public static final int PEEKED_END_ARRAY = 4;
    public static final int PEEKED_END_OBJECT = 2;
    public static final int PEEKED_EOF = 17;
    public static final int PEEKED_FALSE = 6;
    public static final int PEEKED_LONG = 15;
    public static final int PEEKED_NONE = 0;
    public static final int PEEKED_NULL = 7;
    public static final int PEEKED_NUMBER = 16;
    public static final int PEEKED_SINGLE_QUOTED = 8;
    public static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    public static final int PEEKED_TRUE = 5;
    public static final int PEEKED_UNQUOTED = 10;
    public static final int PEEKED_UNQUOTED_NAME = 14;
    public transient /* synthetic */ FieldHolder $fh;
    public final char[] buffer;
    public final Reader in;
    public boolean lenient;
    public int limit;
    public int lineNumber;
    public int lineStart;
    public int[] pathIndices;
    public String[] pathNames;
    public int peeked;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int pos;
    public int[] stack;
    public int stackSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413181993, "Lcom/google/gson/stream/JsonReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413181993, "Lcom/google/gson/stream/JsonReader;");
                return;
            }
        }
        NON_EXECUTE_PREFIX = Gson.JSON_NON_EXECUTABLE_PREFIX.toCharArray();
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, jsonReader) == null) {
                    if (jsonReader instanceof JsonTreeReader) {
                        ((JsonTreeReader) jsonReader).promoteNameToValue();
                        return;
                    }
                    int i2 = jsonReader.peeked;
                    if (i2 == 0) {
                        i2 = jsonReader.doPeek();
                    }
                    if (i2 == 13) {
                        jsonReader.peeked = 9;
                    } else if (i2 == 12) {
                        jsonReader.peeked = 8;
                    } else if (i2 == 14) {
                        jsonReader.peeked = 10;
                    } else {
                        throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                    }
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void checkLenient() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && !this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        nextNonWhitespace(true);
        int i2 = this.pos - 1;
        this.pos = i2;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i2 + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = NON_EXECUTE_PREFIX;
            if (i3 < cArr2.length) {
                if (this.buffer[this.pos + i3] != cArr2[i3]) {
                    return;
                }
                i3++;
            } else {
                this.pos += cArr2.length;
                return;
            }
        }
    }

    private boolean fillBuffer(int i2) throws IOException {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            char[] cArr = this.buffer;
            int i4 = this.lineStart;
            int i5 = this.pos;
            this.lineStart = i4 - i5;
            int i6 = this.limit;
            if (i6 != i5) {
                int i7 = i6 - i5;
                this.limit = i7;
                System.arraycopy(cArr, i5, cArr, 0, i7);
            } else {
                this.limit = 0;
            }
            this.pos = 0;
            do {
                Reader reader = this.in;
                int i8 = this.limit;
                int read = reader.read(cArr, i8, cArr.length - i8);
                if (read == -1) {
                    return false;
                }
                int i9 = this.limit + read;
                this.limit = i9;
                if (this.lineNumber == 0 && (i3 = this.lineStart) == 0 && i9 > 0 && cArr[0] == 65279) {
                    this.pos++;
                    this.lineStart = i3 + 1;
                    i2++;
                }
            } while (this.limit < i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    private boolean isLiteral(char c2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                return false;
            }
            if (c2 != '#') {
                if (c2 == ',') {
                    return false;
                }
                if (c2 != '/' && c2 != '=') {
                    if (c2 == '{' || c2 == '}' || c2 == ':') {
                        return false;
                    }
                    if (c2 != ';') {
                        switch (c2) {
                            case '[':
                            case ']':
                                return false;
                            case '\\':
                                break;
                            default:
                                return true;
                        }
                    }
                }
            }
            checkLenient();
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private int nextNonWhitespace(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(65542, this, z)) != null) {
            return invokeZ.intValue;
        }
        char[] cArr = this.buffer;
        int i2 = this.pos;
        int i3 = this.limit;
        while (true) {
            if (i2 == i3) {
                this.pos = i2;
                if (!fillBuffer(1)) {
                    if (z) {
                        throw new EOFException("End of input" + locationString());
                    }
                    return -1;
                }
                i2 = this.pos;
                i3 = this.limit;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.lineNumber++;
                this.lineStart = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.pos = i4;
                    if (i4 == i3) {
                        this.pos = i4 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c2;
                        }
                    }
                    checkLenient();
                    int i5 = this.pos;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.pos = i5 + 1;
                        if (skipTo("*/")) {
                            i2 = this.pos + 2;
                            i3 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.pos = i5 + 1;
                        skipToEndOfLine();
                        i2 = this.pos;
                        i3 = this.limit;
                    }
                } else if (c2 == '#') {
                    this.pos = i4;
                    checkLenient();
                    skipToEndOfLine();
                    i2 = this.pos;
                    i3 = this.limit;
                } else {
                    this.pos = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        if (r1 != null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextQuotedValue(char c2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Character.valueOf(c2)})) == null) {
            char[] cArr = this.buffer;
            StringBuilder sb = null;
            do {
                int i2 = this.pos;
                int i3 = this.limit;
                while (true) {
                    int i4 = i3;
                    int i5 = i2;
                    while (i2 < i4) {
                        int i6 = i2 + 1;
                        char c3 = cArr[i2];
                        if (c3 == c2) {
                            this.pos = i6;
                            int i7 = (i6 - i5) - 1;
                            if (sb == null) {
                                return new String(cArr, i5, i7);
                            }
                            sb.append(cArr, i5, i7);
                            return sb.toString();
                        } else if (c3 == '\\') {
                            this.pos = i6;
                            int i8 = (i6 - i5) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                            }
                            sb.append(cArr, i5, i8);
                            sb.append(readEscapeCharacter());
                            i2 = this.pos;
                            i3 = this.limit;
                        } else {
                            if (c3 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i6;
                            }
                            i2 = i6;
                        }
                    }
                    break;
                }
            } while (fillBuffer(1));
            throw syntaxError("Unterminated string");
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004e, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextUnquotedValue() throws IOException {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i2 = 0;
            StringBuilder sb2 = null;
            do {
                int i3 = 0;
                while (true) {
                    int i4 = this.pos;
                    if (i4 + i3 < this.limit) {
                        char c2 = this.buffer[i4 + i3];
                        if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                            if (c2 != '#') {
                                if (c2 != ',') {
                                    if (c2 != '/' && c2 != '=') {
                                        if (c2 != '{' && c2 != '}' && c2 != ':') {
                                            if (c2 != ';') {
                                                switch (c2) {
                                                    case '[':
                                                    case ']':
                                                        break;
                                                    case '\\':
                                                        break;
                                                    default:
                                                        i3++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (i3 < this.buffer.length) {
                        if (fillBuffer(i3 + 1)) {
                        }
                    } else {
                        if (sb2 == null) {
                            sb2 = new StringBuilder(Math.max(i3, 16));
                        }
                        sb2.append(this.buffer, this.pos, i3);
                        this.pos += i3;
                    }
                }
                i2 = i3;
                if (sb2 != null) {
                    sb = new String(this.buffer, this.pos, i2);
                } else {
                    sb2.append(this.buffer, this.pos, i2);
                    sb = sb2.toString();
                }
                this.pos += i2;
                return sb;
            } while (fillBuffer(1));
            if (sb2 != null) {
            }
            this.pos += i2;
            return sb;
        }
        return (String) invokeV.objValue;
    }

    private int peekKeyword() throws IOException {
        InterceptResult invokeV;
        int i2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            char c2 = this.buffer[this.pos];
            if (c2 == 't' || c2 == 'T') {
                i2 = 5;
                str = "true";
                str2 = "TRUE";
            } else if (c2 == 'f' || c2 == 'F') {
                i2 = 6;
                str = "false";
                str2 = "FALSE";
            } else if (c2 != 'n' && c2 != 'N') {
                return 0;
            } else {
                i2 = 7;
                str = StringUtil.NULL_STRING;
                str2 = "NULL";
            }
            int length = str.length();
            for (int i3 = 1; i3 < length; i3++) {
                if (this.pos + i3 >= this.limit && !fillBuffer(i3 + 1)) {
                    return 0;
                }
                char c3 = this.buffer[this.pos + i3];
                if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                    return 0;
                }
            }
            if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
                return 0;
            }
            this.pos += length;
            this.peeked = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (isLiteral(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
        if (r9 != 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
        if (r10 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
        if (r11 != Long.MIN_VALUE) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
        if (r13 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r11 != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
        if (r13 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00af, code lost:
        if (r13 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b2, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b3, code lost:
        r18.peekedLong = r11;
        r18.pos += r8;
        r18.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00be, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bf, code lost:
        if (r9 == 2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c2, code lost:
        if (r9 == 4) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c5, code lost:
        if (r9 != 7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ca, code lost:
        r18.peekedNumberLength = r8;
        r18.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00d0, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00d1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65546, this)) != null) {
            return invokeV.intValue;
        }
        char[] cArr = this.buffer;
        int i2 = this.pos;
        int i3 = this.limit;
        int i4 = 0;
        int i5 = 0;
        char c2 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i3) {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!fillBuffer(i5 + 1)) {
                    break;
                }
                i2 = this.pos;
                i3 = this.limit;
            }
            char c3 = cArr[i2 + i5];
            if (c3 != '+') {
                if (c3 == 'E' || c3 == 'e') {
                    i4 = 0;
                    if (c2 != 2 && c2 != 4) {
                        return 0;
                    }
                    c2 = 5;
                } else if (c3 == '-') {
                    i4 = 0;
                    if (c2 == 0) {
                        c2 = 1;
                        z2 = true;
                    } else if (c2 != 5) {
                        return 0;
                    }
                } else if (c3 == '.') {
                    i4 = 0;
                    if (c2 != 2) {
                        return 0;
                    }
                    c2 = 3;
                } else if (c3 < '0' || c3 > '9') {
                    break;
                } else if (c2 == 1 || c2 == 0) {
                    j2 = -(c3 - '0');
                    i4 = 0;
                    c2 = 2;
                } else {
                    if (c2 == 2) {
                        if (j2 == 0) {
                            return 0;
                        }
                        long j3 = (10 * j2) - (c3 - '0');
                        int i6 = (j2 > (-922337203685477580L) ? 1 : (j2 == (-922337203685477580L) ? 0 : -1));
                        z &= i6 > 0 || (i6 == 0 && j3 < j2);
                        j2 = j3;
                    } else if (c2 == 3) {
                        i4 = 0;
                        c2 = 4;
                    } else if (c2 == 5 || c2 == 6) {
                        i4 = 0;
                        c2 = 7;
                    }
                    i4 = 0;
                }
                i5++;
            } else {
                i4 = 0;
                if (c2 != 5) {
                    return 0;
                }
            }
            c2 = 6;
            i5++;
        }
    }

    private void push(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            int i3 = this.stackSize;
            int[] iArr = this.stack;
            if (i3 == iArr.length) {
                int[] iArr2 = new int[i3 * 2];
                int[] iArr3 = new int[i3 * 2];
                String[] strArr = new String[i3 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
                System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
                this.stack = iArr2;
                this.pathIndices = iArr3;
                this.pathNames = strArr;
            }
            int[] iArr4 = this.stack;
            int i4 = this.stackSize;
            this.stackSize = i4 + 1;
            iArr4[i4] = i2;
        }
    }

    private char readEscapeCharacter() throws IOException {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.pos == this.limit && !fillBuffer(1)) {
                throw syntaxError("Unterminated escape sequence");
            }
            char[] cArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 + 1;
            this.pos = i5;
            char c2 = cArr[i4];
            if (c2 == '\n') {
                this.lineNumber++;
                this.lineStart = i5;
            } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
                if (c2 != 'b') {
                    if (c2 != 'f') {
                        if (c2 != 'n') {
                            if (c2 != 'r') {
                                if (c2 != 't') {
                                    if (c2 == 'u') {
                                        if (i5 + 4 > this.limit && !fillBuffer(4)) {
                                            throw syntaxError("Unterminated escape sequence");
                                        }
                                        char c3 = 0;
                                        int i6 = this.pos;
                                        int i7 = i6 + 4;
                                        while (i6 < i7) {
                                            char c4 = this.buffer[i6];
                                            char c5 = (char) (c3 << 4);
                                            if (c4 < '0' || c4 > '9') {
                                                if (c4 >= 'a' && c4 <= 'f') {
                                                    i2 = c4 - 'a';
                                                } else if (c4 < 'A' || c4 > 'F') {
                                                    throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                                                } else {
                                                    i2 = c4 - 'A';
                                                }
                                                i3 = i2 + 10;
                                            } else {
                                                i3 = c4 - '0';
                                            }
                                            c3 = (char) (c5 + i3);
                                            i6++;
                                        }
                                        this.pos += 4;
                                        return c3;
                                    }
                                    throw syntaxError("Invalid escape sequence");
                                }
                                return '\t';
                            }
                            return CharUtils.CR;
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            return c2;
        }
        return invokeV.charValue;
    }

    private void skipQuotedValue(char c2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Character.valueOf(c2)}) == null) {
            char[] cArr = this.buffer;
            do {
                int i2 = this.pos;
                int i3 = this.limit;
                while (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.pos = i4;
                        return;
                    } else if (c3 == '\\') {
                        this.pos = i4;
                        readEscapeCharacter();
                        i2 = this.pos;
                        i3 = this.limit;
                    } else {
                        if (c3 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i4;
                        }
                        i2 = i4;
                    }
                }
                this.pos = i2;
            } while (fillBuffer(1));
            throw syntaxError("Unterminated string");
        }
    }

    private boolean skipTo(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65550, this, str)) != null) {
            return invokeL.booleanValue;
        }
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i2 = this.pos;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.buffer[this.pos + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i2 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            do {
                if (this.pos >= this.limit && !fillBuffer(1)) {
                    return;
                }
                char[] cArr = this.buffer;
                int i2 = this.pos;
                int i3 = i2 + 1;
                this.pos = i3;
                c2 = cArr[i2];
                if (c2 == '\n') {
                    this.lineNumber++;
                    this.lineStart = i3;
                    return;
                }
            } while (c2 != '\r');
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void skipUnquotedValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            do {
                int i2 = 0;
                while (true) {
                    int i3 = this.pos;
                    if (i3 + i2 < this.limit) {
                        char c2 = this.buffer[i3 + i2];
                        if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                            if (c2 != '#') {
                                if (c2 != ',') {
                                    if (c2 != '/' && c2 != '=') {
                                        if (c2 != '{' && c2 != '}' && c2 != ':') {
                                            if (c2 != ';') {
                                                switch (c2) {
                                                    case '[':
                                                    case ']':
                                                        break;
                                                    case '\\':
                                                        break;
                                                    default:
                                                        i2++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        this.pos = i3 + i2;
                    }
                }
                this.pos += i2;
                return;
            } while (fillBuffer(1));
        }
    }

    private IOException syntaxError(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            throw new MalformedJsonException(str + locationString());
        }
        return (IOException) invokeL.objValue;
    }

    public void beginArray() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                push(1);
                this.pathIndices[this.stackSize - 1] = 0;
                this.peeked = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 1) {
                push(3);
                this.peeked = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.peeked = 0;
            this.stack[0] = 8;
            this.stackSize = 1;
            this.in.close();
        }
    }

    public int doPeek() throws IOException {
        InterceptResult invokeV;
        int nextNonWhitespace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = this.stack;
            int i2 = this.stackSize;
            int i3 = iArr[i2 - 1];
            if (i3 == 1) {
                iArr[i2 - 1] = 2;
            } else if (i3 == 2) {
                int nextNonWhitespace2 = nextNonWhitespace(true);
                if (nextNonWhitespace2 != 44) {
                    if (nextNonWhitespace2 != 59) {
                        if (nextNonWhitespace2 == 93) {
                            this.peeked = 4;
                            return 4;
                        }
                        throw syntaxError("Unterminated array");
                    }
                    checkLenient();
                }
            } else if (i3 == 3 || i3 == 5) {
                this.stack[this.stackSize - 1] = 4;
                if (i3 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (nextNonWhitespace != 59) {
                        if (nextNonWhitespace == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        throw syntaxError("Unterminated object");
                    }
                    checkLenient();
                }
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 == 34) {
                    this.peeked = 13;
                    return 13;
                } else if (nextNonWhitespace3 == 39) {
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                } else if (nextNonWhitespace3 == 125) {
                    if (i3 != 5) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Expected name");
                } else {
                    checkLenient();
                    this.pos--;
                    if (isLiteral((char) nextNonWhitespace3)) {
                        this.peeked = 14;
                        return 14;
                    }
                    throw syntaxError("Expected name");
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int nextNonWhitespace4 = nextNonWhitespace(true);
                if (nextNonWhitespace4 != 58) {
                    if (nextNonWhitespace4 == 61) {
                        checkLenient();
                        if (this.pos < this.limit || fillBuffer(1)) {
                            char[] cArr = this.buffer;
                            int i4 = this.pos;
                            if (cArr[i4] == '>') {
                                this.pos = i4 + 1;
                            }
                        }
                    } else {
                        throw syntaxError("Expected ':'");
                    }
                }
            } else if (i3 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i3 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            int nextNonWhitespace5 = nextNonWhitespace(true);
            if (nextNonWhitespace5 == 34) {
                this.peeked = 9;
                return 9;
            } else if (nextNonWhitespace5 == 39) {
                checkLenient();
                this.peeked = 8;
                return 8;
            } else {
                if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                    if (nextNonWhitespace5 == 91) {
                        this.peeked = 3;
                        return 3;
                    } else if (nextNonWhitespace5 != 93) {
                        if (nextNonWhitespace5 != 123) {
                            this.pos--;
                            int peekKeyword = peekKeyword();
                            if (peekKeyword != 0) {
                                return peekKeyword;
                            }
                            int peekNumber = peekNumber();
                            if (peekNumber != 0) {
                                return peekNumber;
                            }
                            if (isLiteral(this.buffer[this.pos])) {
                                checkLenient();
                                this.peeked = 10;
                                return 10;
                            }
                            throw syntaxError("Expected value");
                        }
                        this.peeked = 1;
                        return 1;
                    } else if (i3 == 1) {
                        this.peeked = 4;
                        return 4;
                    }
                }
                if (i3 != 1 && i3 != 2) {
                    throw syntaxError("Unexpected value");
                }
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
        }
        return invokeV.intValue;
    }

    public void endArray() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 4) {
                int i3 = this.stackSize - 1;
                this.stackSize = i3;
                int[] iArr = this.pathIndices;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
                this.peeked = 0;
                return;
            }
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
    }

    public void endObject() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 2) {
                int i3 = this.stackSize - 1;
                this.stackSize = i3;
                this.pathNames[i3] = null;
                int[] iArr = this.pathIndices;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
                this.peeked = 0;
                return;
            }
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            int i2 = this.stackSize;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.stack[i3];
                if (i4 == 1 || i4 == 2) {
                    sb.append('[');
                    sb.append(this.pathIndices[i3]);
                    sb.append(']');
                } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                    sb.append('.');
                    String[] strArr = this.pathNames;
                    if (strArr[i3] != null) {
                        sb.append(strArr[i3]);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean hasNext() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            return (i2 == 2 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isLenient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.lenient : invokeV.booleanValue;
    }

    public String locationString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
        }
        return (String) invokeV.objValue;
    }

    public boolean nextBoolean() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 5) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return true;
            } else if (i2 == 6) {
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return false;
            } else {
                throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
            }
        }
        return invokeV.booleanValue;
    }

    public double nextDouble() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 15) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return this.peekedLong;
            }
            if (i2 == 16) {
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else if (i2 == 8 || i2 == 9) {
                this.peekedString = nextQuotedValue(i2 == 8 ? ExtendedMessageFormat.QUOTE : '\"');
            } else if (i2 == 10) {
                this.peekedString = nextUnquotedValue();
            } else if (i2 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
            this.peeked = 11;
            double parseDouble = Double.parseDouble(this.peekedString);
            if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        return invokeV.doubleValue;
    }

    public int nextInt() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 15) {
                long j2 = this.peekedLong;
                int i3 = (int) j2;
                if (j2 == i3) {
                    this.peeked = 0;
                    int[] iArr = this.pathIndices;
                    int i4 = this.stackSize - 1;
                    iArr[i4] = iArr[i4] + 1;
                    return i3;
                }
                throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
            }
            if (i2 == 16) {
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            } else {
                if (i2 == 10) {
                    this.peekedString = nextUnquotedValue();
                } else {
                    this.peekedString = nextQuotedValue(i2 == 8 ? ExtendedMessageFormat.QUOTE : '\"');
                }
                try {
                    int parseInt = Integer.parseInt(this.peekedString);
                    this.peeked = 0;
                    int[] iArr2 = this.pathIndices;
                    int i5 = this.stackSize - 1;
                    iArr2[i5] = iArr2[i5] + 1;
                    return parseInt;
                } catch (NumberFormatException unused) {
                }
            }
            this.peeked = 11;
            double parseDouble = Double.parseDouble(this.peekedString);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr3 = this.pathIndices;
                int i7 = this.stackSize - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        return invokeV.intValue;
    }

    public long nextLong() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 15) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return this.peekedLong;
            }
            if (i2 == 16) {
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            } else {
                if (i2 == 10) {
                    this.peekedString = nextUnquotedValue();
                } else {
                    this.peekedString = nextQuotedValue(i2 == 8 ? ExtendedMessageFormat.QUOTE : '\"');
                }
                try {
                    long parseLong = Long.parseLong(this.peekedString);
                    this.peeked = 0;
                    int[] iArr2 = this.pathIndices;
                    int i4 = this.stackSize - 1;
                    iArr2[i4] = iArr2[i4] + 1;
                    return parseLong;
                } catch (NumberFormatException unused) {
                }
            }
            this.peeked = 11;
            double parseDouble = Double.parseDouble(this.peekedString);
            long j2 = (long) parseDouble;
            if (j2 == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr3 = this.pathIndices;
                int i5 = this.stackSize - 1;
                iArr3[i5] = iArr3[i5] + 1;
                return j2;
            }
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        return invokeV.longValue;
    }

    public String nextName() throws IOException {
        InterceptResult invokeV;
        String nextQuotedValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 14) {
                nextQuotedValue = nextUnquotedValue();
            } else if (i2 == 12) {
                nextQuotedValue = nextQuotedValue(ExtendedMessageFormat.QUOTE);
            } else if (i2 == 13) {
                nextQuotedValue = nextQuotedValue('\"');
            } else {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = nextQuotedValue;
            return nextQuotedValue;
        }
        return (String) invokeV.objValue;
    }

    public void nextNull() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 7) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return;
            }
            throw new IllegalStateException("Expected null but was " + peek() + locationString());
        }
    }

    public String nextString() throws IOException {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 10) {
                str = nextUnquotedValue();
            } else if (i2 == 8) {
                str = nextQuotedValue(ExtendedMessageFormat.QUOTE);
            } else if (i2 == 9) {
                str = nextQuotedValue('\"');
            } else if (i2 == 11) {
                str = this.peekedString;
                this.peekedString = null;
            } else if (i2 == 15) {
                str = Long.toString(this.peekedLong);
            } else if (i2 == 16) {
                str = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public JsonToken peek() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            switch (i2) {
                case 1:
                    return JsonToken.BEGIN_OBJECT;
                case 2:
                    return JsonToken.END_OBJECT;
                case 3:
                    return JsonToken.BEGIN_ARRAY;
                case 4:
                    return JsonToken.END_ARRAY;
                case 5:
                case 6:
                    return JsonToken.BOOLEAN;
                case 7:
                    return JsonToken.NULL;
                case 8:
                case 9:
                case 10:
                case 11:
                    return JsonToken.STRING;
                case 12:
                case 13:
                case 14:
                    return JsonToken.NAME;
                case 15:
                case 16:
                    return JsonToken.NUMBER;
                case 17:
                    return JsonToken.END_DOCUMENT;
                default:
                    throw new AssertionError();
            }
        }
        return (JsonToken) invokeV.objValue;
    }

    public final void setLenient(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.lenient = z;
        }
    }

    public void skipValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i2 = 0;
            do {
                int i3 = this.peeked;
                if (i3 == 0) {
                    i3 = doPeek();
                }
                if (i3 == 3) {
                    push(1);
                } else if (i3 == 1) {
                    push(3);
                } else {
                    if (i3 == 4) {
                        this.stackSize--;
                    } else if (i3 == 2) {
                        this.stackSize--;
                    } else {
                        if (i3 == 14 || i3 == 10) {
                            skipUnquotedValue();
                        } else if (i3 == 8 || i3 == 12) {
                            skipQuotedValue(ExtendedMessageFormat.QUOTE);
                        } else if (i3 == 9 || i3 == 13) {
                            skipQuotedValue('\"');
                        } else if (i3 == 16) {
                            this.pos += this.peekedNumberLength;
                        }
                        this.peeked = 0;
                    }
                    i2--;
                    this.peeked = 0;
                }
                i2++;
                this.peeked = 0;
            } while (i2 != 0);
            int[] iArr = this.pathIndices;
            int i4 = this.stackSize;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.pathNames[i4 - 1] = StringUtil.NULL_STRING;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return getClass().getSimpleName() + locationString();
        }
        return (String) invokeV.objValue;
    }
}
