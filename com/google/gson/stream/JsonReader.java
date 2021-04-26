package com.google.gson.stream;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.gson.Gson;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;
/* loaded from: classes6.dex */
public class JsonReader implements Closeable {
    public static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    public static final char[] NON_EXECUTE_PREFIX = Gson.JSON_NON_EXECUTABLE_PREFIX.toCharArray();
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
    public final Reader in;
    public int[] pathIndices;
    public String[] pathNames;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int[] stack;
    public int stackSize;
    public boolean lenient = false;
    public final char[] buffer = new char[1024];
    public int pos = 0;
    public int limit = 0;
    public int lineNumber = 0;
    public int lineStart = 0;
    public int peeked = 0;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
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
        };
    }

    public JsonReader(Reader reader) {
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
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
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
        int i3;
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

    private boolean isLiteral(char c2) throws IOException {
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

    private int nextNonWhitespace(boolean z) throws IOException {
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

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextQuotedValue(char c2) throws IOException {
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextUnquotedValue() throws IOException {
        String sb;
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

    private int peekKeyword() throws IOException {
        int i2;
        String str;
        String str2;
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

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (isLiteral(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
        r18.peekedLong = r11;
        r18.pos += r8;
        r18.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bb, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00be, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c6, code lost:
        r18.peekedNumberLength = r8;
        r18.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cc, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() throws IOException {
        char[] cArr = this.buffer;
        int i2 = this.pos;
        int i3 = this.limit;
        int i4 = 0;
        int i5 = 0;
        char c2 = 0;
        boolean z = true;
        long j = 0;
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
                    j = -(c3 - '0');
                    i4 = 0;
                    c2 = 2;
                } else {
                    if (c2 == 2) {
                        if (j == 0) {
                            return 0;
                        }
                        long j2 = (10 * j) - (c3 - '0');
                        int i6 = (j > (-922337203685477580L) ? 1 : (j == (-922337203685477580L) ? 0 : -1));
                        z &= i6 > 0 || (i6 == 0 && j2 < j);
                        j = j2;
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

    private char readEscapeCharacter() throws IOException {
        int i2;
        int i3;
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
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c2;
    }

    private void skipQuotedValue(char c2) throws IOException {
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

    private boolean skipTo(String str) throws IOException {
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void skipUnquotedValue() throws IOException {
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

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
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

    public void beginObject() throws IOException {
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() throws IOException {
        int nextNonWhitespace;
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

    public void endArray() throws IOException {
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

    public void endObject() throws IOException {
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

    public String getPath() {
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
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                String[] strArr = this.pathNames;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
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

    public double nextDouble() throws IOException {
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
            this.peekedString = nextQuotedValue(i2 == 8 ? '\'' : Typography.quote);
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

    public int nextInt() throws IOException {
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 15) {
            long j = this.peekedLong;
            int i3 = (int) j;
            if (j == i3) {
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
                this.peekedString = nextQuotedValue(i2 == 8 ? '\'' : Typography.quote);
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

    public long nextLong() throws IOException {
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
                this.peekedString = nextQuotedValue(i2 == 8 ? '\'' : Typography.quote);
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
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String nextQuotedValue;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else if (i2 == 12) {
            nextQuotedValue = nextQuotedValue('\'');
        } else if (i2 == 13) {
            nextQuotedValue = nextQuotedValue(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
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

    public String nextString() throws IOException {
        String str;
        int i2 = this.peeked;
        if (i2 == 0) {
            i2 = doPeek();
        }
        if (i2 == 10) {
            str = nextUnquotedValue();
        } else if (i2 == 8) {
            str = nextQuotedValue('\'');
        } else if (i2 == 9) {
            str = nextQuotedValue(Typography.quote);
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

    public JsonToken peek() throws IOException {
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

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public void skipValue() throws IOException {
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
                        skipQuotedValue('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        skipQuotedValue(Typography.quote);
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

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
