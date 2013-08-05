package com.google.gson.stream;

import com.baidu.location.BDLocation;
import com.baidu.zeus.WebChromeClient;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* loaded from: classes.dex */
public class JsonReader implements Closeable {
    private static final String FALSE = "false";
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final String TRUE = "true";
    private final Reader in;
    private String name;
    private boolean skipping;
    private JsonToken token;
    private String value;
    private int valueLength;
    private int valuePos;
    private final StringPool stringPool = new StringPool();
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int bufferStartLine = 1;
    private int bufferStartColumn = 1;
    private JsonScope[] stack = new JsonScope[32];
    private int stackSize = 0;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                jsonReader.peek();
                if (jsonReader.token == JsonToken.NAME) {
                    jsonReader.value = jsonReader.name;
                    jsonReader.name = null;
                    jsonReader.token = JsonToken.STRING;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + "  at line " + jsonReader.getLineNumber() + " column " + jsonReader.getColumnNumber());
            }
        };
    }

    public JsonReader(Reader reader) {
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void endArray() {
        expect(JsonToken.END_ARRAY);
    }

    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
    }

    public void endObject() {
        expect(JsonToken.END_OBJECT);
    }

    private void expect(JsonToken jsonToken) {
        peek();
        if (this.token != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
    }

    public boolean hasNext() {
        peek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() {
        if (this.token != null) {
            return this.token;
        }
        switch (this.stack[this.stackSize + (-1)]) {
            case EMPTY_DOCUMENT:
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken nextValue = nextValue();
                if (!this.lenient && this.token != JsonToken.BEGIN_ARRAY && this.token != JsonToken.BEGIN_OBJECT) {
                    throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
                return nextValue;
            case EMPTY_ARRAY:
                return nextInArray(true);
            case NONEMPTY_ARRAY:
                return nextInArray(false);
            case EMPTY_OBJECT:
                return nextInObject(true);
            case DANGLING_NAME:
                return objectValue();
            case NONEMPTY_OBJECT:
                return nextInObject(false);
            case NONEMPTY_DOCUMENT:
                if (nextNonWhitespace(false) == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                this.pos--;
                if (!this.lenient) {
                    throw syntaxError("Expected EOF");
                }
                return nextValue();
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void consumeNonExecutePrefix() {
        nextNonWhitespace(true);
        this.pos--;
        if (this.pos + NON_EXECUTE_PREFIX.length <= this.limit || fillBuffer(NON_EXECUTE_PREFIX.length)) {
            for (int i = 0; i < NON_EXECUTE_PREFIX.length; i++) {
                if (this.buffer[this.pos + i] != NON_EXECUTE_PREFIX[i]) {
                    return;
                }
            }
            this.pos += NON_EXECUTE_PREFIX.length;
        }
    }

    private JsonToken advance() {
        peek();
        JsonToken jsonToken = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return jsonToken;
    }

    public String nextName() {
        peek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        String str = this.name;
        advance();
        return str;
    }

    public String nextString() {
        peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        String str = this.value;
        advance();
        return str;
    }

    public boolean nextBoolean() {
        peek();
        if (this.token != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        boolean z = this.value == TRUE;
        advance();
        return z;
    }

    public void nextNull() {
        peek();
        if (this.token != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
    }

    public double nextDouble() {
        peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        double parseDouble = Double.parseDouble(this.value);
        if (parseDouble >= 1.0d && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
        return parseDouble;
    }

    public long nextLong() {
        long j;
        peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a long but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        try {
            j = Long.parseLong(this.value);
        } catch (NumberFormatException e) {
            double parseDouble = Double.parseDouble(this.value);
            j = (long) parseDouble;
            if (j != parseDouble) {
                throw new NumberFormatException("Expected a long but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            }
        }
        if (j >= 1 && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
        return j;
    }

    public int nextInt() {
        int i;
        peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected an int but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        try {
            i = Integer.parseInt(this.value);
        } catch (NumberFormatException e) {
            double parseDouble = Double.parseDouble(this.value);
            i = (int) parseDouble;
            if (i != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            }
        }
        if (i >= 1 && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
        return i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.value = null;
        this.token = null;
        this.stack[0] = JsonScope.CLOSED;
        this.stackSize = 1;
        this.in.close();
    }

    public void skipValue() {
        this.skipping = true;
        int i = 0;
        do {
            try {
                JsonToken advance = advance();
                if (advance == JsonToken.BEGIN_ARRAY || advance == JsonToken.BEGIN_OBJECT) {
                    i++;
                    continue;
                } else if (advance == JsonToken.END_ARRAY || advance == JsonToken.END_OBJECT) {
                    i--;
                    continue;
                }
            } finally {
                this.skipping = false;
            }
        } while (i != 0);
    }

    private void push(JsonScope jsonScope) {
        if (this.stackSize == this.stack.length) {
            JsonScope[] jsonScopeArr = new JsonScope[this.stackSize * 2];
            System.arraycopy(this.stack, 0, jsonScopeArr, 0, this.stackSize);
            this.stack = jsonScopeArr;
        }
        JsonScope[] jsonScopeArr2 = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        jsonScopeArr2[i] = jsonScope;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JsonToken nextInArray(boolean z) {
        if (z) {
            this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            switch (nextNonWhitespace(true)) {
                case 44:
                    break;
                case 59:
                    checkLenient();
                    break;
                case 93:
                    this.stackSize--;
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    throw syntaxError("Unterminated array");
            }
        }
        switch (nextNonWhitespace(true)) {
            case 44:
            case 59:
                break;
            default:
                this.pos--;
                return nextValue();
            case 93:
                if (z) {
                    this.stackSize--;
                    JsonToken jsonToken2 = JsonToken.END_ARRAY;
                    this.token = jsonToken2;
                    return jsonToken2;
                }
                break;
        }
        checkLenient();
        this.pos--;
        this.value = "null";
        JsonToken jsonToken3 = JsonToken.NULL;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken nextInObject(boolean z) {
        if (z) {
            switch (nextNonWhitespace(true)) {
                case 125:
                    this.stackSize--;
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    this.pos--;
                    break;
            }
        } else {
            switch (nextNonWhitespace(true)) {
                case 44:
                case 59:
                    break;
                case 125:
                    this.stackSize--;
                    JsonToken jsonToken2 = JsonToken.END_OBJECT;
                    this.token = jsonToken2;
                    return jsonToken2;
                default:
                    throw syntaxError("Unterminated object");
            }
        }
        int nextNonWhitespace = nextNonWhitespace(true);
        switch (nextNonWhitespace) {
            case 39:
                checkLenient();
            case 34:
                this.name = nextString((char) nextNonWhitespace);
                break;
            default:
                checkLenient();
                this.pos--;
                this.name = nextLiteral(false);
                if (this.name.length() == 0) {
                    throw syntaxError("Expected name");
                }
                break;
        }
        this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
        JsonToken jsonToken3 = JsonToken.NAME;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken objectValue() {
        switch (nextNonWhitespace(true)) {
            case 58:
                break;
            case 59:
            case 60:
            default:
                throw syntaxError("Expected ':'");
            case BDLocation.TypeGpsLocation /* 61 */:
                checkLenient();
                if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>') {
                    this.pos++;
                    break;
                }
                break;
        }
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
        return nextValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JsonToken nextValue() {
        int nextNonWhitespace = nextNonWhitespace(true);
        switch (nextNonWhitespace) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            case 91:
                push(JsonScope.EMPTY_ARRAY);
                JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
                this.token = jsonToken;
                return jsonToken;
            case 123:
                push(JsonScope.EMPTY_OBJECT);
                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                this.token = jsonToken2;
                return jsonToken2;
            default:
                this.pos--;
                return readLiteral();
        }
        this.value = nextString((char) nextNonWhitespace);
        JsonToken jsonToken3 = JsonToken.STRING;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private boolean fillBuffer(int i) {
        char[] cArr = this.buffer;
        int i2 = this.bufferStartLine;
        int i3 = this.bufferStartColumn;
        int i4 = this.pos;
        for (int i5 = 0; i5 < i4; i5++) {
            if (cArr[i5] == '\n') {
                i2++;
                i3 = 1;
            } else {
                i3++;
            }
        }
        this.bufferStartLine = i2;
        this.bufferStartColumn = i3;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.bufferStartLine == 1 && this.bufferStartColumn == 1 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.bufferStartColumn--;
            }
        } while (this.limit < i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLineNumber() {
        int i = this.bufferStartLine;
        for (int i2 = 0; i2 < this.pos; i2++) {
            if (this.buffer[i2] == '\n') {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColumnNumber() {
        int i = this.bufferStartColumn;
        for (int i2 = 0; i2 < this.pos; i2++) {
            if (this.buffer[i2] == '\n') {
                i = 1;
            } else {
                i++;
            }
        }
        return i;
    }

    private int nextNonWhitespace(boolean z) {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (z) {
                    throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
                } else {
                    return -1;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\t':
                case '\n':
                case '\r':
                case ' ':
                    i = i3;
                    break;
                case '#':
                    this.pos = i3;
                    checkLenient();
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                    break;
                case '/':
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos--;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c;
                        }
                    }
                    checkLenient();
                    switch (cArr[this.pos]) {
                        case '*':
                            this.pos++;
                            if (!skipTo("*/")) {
                                throw syntaxError("Unterminated comment");
                            }
                            i = this.pos + 2;
                            i2 = this.limit;
                            continue;
                        case '/':
                            this.pos++;
                            skipToEndOfLine();
                            i = this.pos;
                            i2 = this.limit;
                            continue;
                        default:
                            return c;
                    }
                default:
                    this.pos = i3;
                    return c;
            }
        }
    }

    private void checkLenient() {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\r') {
                    return;
                }
            } else {
                return;
            }
        } while (c != '\n');
    }

    private boolean skipTo(String str) {
        while (true) {
            if (this.pos + str.length() <= this.limit || fillBuffer(str.length())) {
                for (int i = 0; i < str.length(); i++) {
                    if (this.buffer[this.pos + i] != str.charAt(i)) {
                        break;
                    }
                }
                return true;
            }
            return false;
            this.pos++;
        }
    }

    private String nextString(char c) {
        int i;
        int i2;
        StringBuilder sb;
        int i3;
        char[] cArr = this.buffer;
        StringBuilder sb2 = null;
        do {
            int i4 = this.pos;
            int i5 = this.limit;
            int i6 = i4;
            while (i6 < i5) {
                int i7 = i6 + 1;
                char c2 = cArr[i6];
                if (c2 == c) {
                    this.pos = i7;
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (sb2 == null) {
                        return this.stringPool.get(cArr, i4, (i7 - i4) - 1);
                    }
                    sb2.append(cArr, i4, (i7 - i4) - 1);
                    return sb2.toString();
                }
                if (c2 == '\\') {
                    this.pos = i7;
                    if (sb2 == null) {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(cArr, i4, (i7 - i4) - 1);
                    sb2.append(readEscapeCharacter());
                    int i8 = this.pos;
                    sb = sb2;
                    i3 = i8;
                    i = this.limit;
                    i2 = i8;
                } else {
                    int i9 = i4;
                    i = i5;
                    i2 = i7;
                    sb = sb2;
                    i3 = i9;
                }
                i6 = i2;
                i5 = i;
                i4 = i3;
                sb2 = sb;
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(cArr, i4, i6 - i4);
            this.pos = i6;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private String nextLiteral(boolean z) {
        String str = null;
        this.valuePos = -1;
        this.valueLength = 0;
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.buffer[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case BDLocation.TypeGpsLocation /* 61 */:
                    case '\\':
                        checkLenient();
                        break;
                    default:
                        i++;
                }
            } else if (i < this.buffer.length) {
                if (!fillBuffer(i + 1)) {
                    this.buffer[this.limit] = 0;
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.buffer, this.pos, i);
                this.valueLength += i;
                this.pos = i + this.pos;
                if (fillBuffer(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            }
        }
        if (z && sb == null) {
            this.valuePos = this.pos;
        } else if (this.skipping) {
            str = "skipped!";
        } else if (sb == null) {
            str = this.stringPool.get(this.buffer, this.pos, i);
        } else {
            sb.append(this.buffer, this.pos, i);
            str = sb.toString();
        }
        this.valueLength += i;
        this.pos += i;
        return str;
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
    }

    private char readEscapeCharacter() {
        int i;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i2 = this.pos;
        this.pos = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case 'b':
                return '\b';
            case WebChromeClient.STRING_DLG_TITLE_WEEK /* 102 */:
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                if (this.pos + 4 > this.limit && !fillBuffer(4)) {
                    throw syntaxError("Unterminated escape sequence");
                }
                int i3 = this.pos;
                int i4 = i3 + 4;
                char c2 = 0;
                for (int i5 = i3; i5 < i4; i5++) {
                    char c3 = this.buffer[i5];
                    char c4 = (char) (c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        i = c3 - '0';
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        i = (c3 - 'a') + 10;
                    } else if (c3 >= 'A' && c3 <= 'F') {
                        i = (c3 - 'A') + 10;
                    } else {
                        throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                    }
                    c2 = (char) (c4 + i);
                }
                this.pos += 4;
                return c2;
            default:
                return c;
        }
    }

    private JsonToken readLiteral() {
        this.value = nextLiteral(true);
        if (this.valueLength == 0) {
            throw syntaxError("Expected literal value");
        }
        this.token = decodeLiteral();
        if (this.token == JsonToken.STRING) {
            checkLenient();
        }
        return this.token;
    }

    private JsonToken decodeLiteral() {
        if (this.valuePos == -1) {
            return JsonToken.STRING;
        }
        if (this.valueLength == 4 && (('n' == this.buffer[this.valuePos] || 'N' == this.buffer[this.valuePos]) && (('u' == this.buffer[this.valuePos + 1] || 'U' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && ('l' == this.buffer[this.valuePos + 3] || 'L' == this.buffer[this.valuePos + 3]))))) {
            this.value = "null";
            return JsonToken.NULL;
        } else if (this.valueLength == 4 && (('t' == this.buffer[this.valuePos] || 'T' == this.buffer[this.valuePos]) && (('r' == this.buffer[this.valuePos + 1] || 'R' == this.buffer[this.valuePos + 1]) && (('u' == this.buffer[this.valuePos + 2] || 'U' == this.buffer[this.valuePos + 2]) && ('e' == this.buffer[this.valuePos + 3] || 'E' == this.buffer[this.valuePos + 3]))))) {
            this.value = TRUE;
            return JsonToken.BOOLEAN;
        } else if (this.valueLength == 5 && (('f' == this.buffer[this.valuePos] || 'F' == this.buffer[this.valuePos]) && (('a' == this.buffer[this.valuePos + 1] || 'A' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && (('s' == this.buffer[this.valuePos + 3] || 'S' == this.buffer[this.valuePos + 3]) && ('e' == this.buffer[this.valuePos + 4] || 'E' == this.buffer[this.valuePos + 4])))))) {
            this.value = FALSE;
            return JsonToken.BOOLEAN;
        } else {
            this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
            return decodeNumber(this.buffer, this.valuePos, this.valueLength);
        }
    }

    private JsonToken decodeNumber(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        char c;
        char c2 = cArr[i];
        if (c2 == '-') {
            i3 = i + 1;
            c2 = cArr[i3];
        } else {
            i3 = i;
        }
        if (c2 == '0') {
            i4 = i3 + 1;
            c = cArr[i4];
        } else if (c2 >= '1' && c2 <= '9') {
            i4 = i3 + 1;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        } else {
            return JsonToken.STRING;
        }
        if (c == '.') {
            i4++;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        }
        char c3 = c;
        int i5 = i4;
        if (c3 == 'e' || c3 == 'E') {
            int i6 = i5 + 1;
            char c4 = cArr[i6];
            if (c4 == '+' || c4 == '-') {
                i6++;
                c4 = cArr[i6];
            }
            if (c4 >= '0' && c4 <= '9') {
                int i7 = i6 + 1;
                i5 = i7;
                char c5 = cArr[i7];
                while (c5 >= '0' && c5 <= '9') {
                    int i8 = i5 + 1;
                    i5 = i8;
                    c5 = cArr[i8];
                }
            } else {
                return JsonToken.STRING;
            }
        }
        if (i5 == i + i2) {
            return JsonToken.NUMBER;
        }
        return JsonToken.STRING;
    }

    private IOException syntaxError(String str) {
        throw new MalformedJsonException(str + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
}
