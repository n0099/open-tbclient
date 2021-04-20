package d.a.a.w.k0;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonDataException;
import com.airbnb.lottie.parser.moshi.JsonEncodingException;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.http.message.BasicHeaderValueFormatter;
/* loaded from: classes.dex */
public final class b extends JsonReader {
    public static final ByteString r = ByteString.encodeUtf8("'\\");
    public static final ByteString s = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
    public static final ByteString t = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString u = ByteString.encodeUtf8("\n\r");
    public static final ByteString v = ByteString.encodeUtf8("*/");
    public final BufferedSource l;
    public final Buffer m;
    public int n = 0;
    public long o;
    public int p;
    @Nullable
    public String q;

    public b(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.l = bufferedSource;
            this.m = bufferedSource.buffer();
            C(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token B() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        switch (i) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int D(JsonReader.a aVar) throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return K(this.q, aVar);
        }
        int select = this.l.select(aVar.f1631b);
        if (select != -1) {
            this.n = 0;
            this.f1628g[this.f1626e - 1] = aVar.f1630a[select];
            return select;
        }
        String str = this.f1628g[this.f1626e - 1];
        String y = y();
        int K = K(y, aVar);
        if (K == -1) {
            this.n = 15;
            this.q = y;
            this.f1628g[this.f1626e - 1] = str;
        }
        return K;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void E() throws IOException {
        if (!this.j) {
            int i = this.n;
            if (i == 0) {
                i = J();
            }
            if (i == 14) {
                V();
            } else if (i == 13) {
                S(s);
            } else if (i == 12) {
                S(r);
            } else if (i != 15) {
                throw new JsonDataException("Expected a name but was " + B() + " at path " + s());
            }
            this.n = 0;
            this.f1628g[this.f1626e - 1] = StringUtil.NULL_STRING;
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + B() + " at " + s());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void F() throws IOException {
        if (!this.j) {
            int i = 0;
            do {
                int i2 = this.n;
                if (i2 == 0) {
                    i2 = J();
                }
                if (i2 == 3) {
                    C(1);
                } else if (i2 == 1) {
                    C(3);
                } else {
                    if (i2 == 4) {
                        i--;
                        if (i >= 0) {
                            this.f1626e--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + B() + " at path " + s());
                        }
                    } else if (i2 == 2) {
                        i--;
                        if (i >= 0) {
                            this.f1626e--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + B() + " at path " + s());
                        }
                    } else if (i2 == 14 || i2 == 10) {
                        V();
                    } else if (i2 == 9 || i2 == 13) {
                        S(s);
                    } else if (i2 == 8 || i2 == 12) {
                        S(r);
                    } else if (i2 == 17) {
                        this.m.skip(this.p);
                    } else if (i2 == 18) {
                        throw new JsonDataException("Expected a value but was " + B() + " at path " + s());
                    }
                    this.n = 0;
                }
                i++;
                this.n = 0;
            } while (i != 0);
            int[] iArr = this.f1629h;
            int i3 = this.f1626e;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f1628g[i3 - 1] = StringUtil.NULL_STRING;
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + B() + " at " + s());
    }

    public final void I() throws IOException {
        if (this.i) {
            return;
        }
        H("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final int J() throws IOException {
        int[] iArr = this.f1627f;
        int i = this.f1626e;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int M = M(true);
            this.m.readByte();
            if (M != 44) {
                if (M != 59) {
                    if (M == 93) {
                        this.n = 4;
                        return 4;
                    }
                    H("Unterminated array");
                    throw null;
                }
                I();
            }
        } else if (i2 == 3 || i2 == 5) {
            this.f1627f[this.f1626e - 1] = 4;
            if (i2 == 5) {
                int M2 = M(true);
                this.m.readByte();
                if (M2 != 44) {
                    if (M2 != 59) {
                        if (M2 == 125) {
                            this.n = 2;
                            return 2;
                        }
                        H("Unterminated object");
                        throw null;
                    }
                    I();
                }
            }
            int M3 = M(true);
            if (M3 == 34) {
                this.m.readByte();
                this.n = 13;
                return 13;
            } else if (M3 == 39) {
                this.m.readByte();
                I();
                this.n = 12;
                return 12;
            } else if (M3 != 125) {
                I();
                if (L((char) M3)) {
                    this.n = 14;
                    return 14;
                }
                H("Expected name");
                throw null;
            } else if (i2 != 5) {
                this.m.readByte();
                this.n = 2;
                return 2;
            } else {
                H("Expected name");
                throw null;
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int M4 = M(true);
            this.m.readByte();
            if (M4 != 58) {
                if (M4 == 61) {
                    I();
                    if (this.l.request(1L) && this.m.getByte(0L) == 62) {
                        this.m.readByte();
                    }
                } else {
                    H("Expected ':'");
                    throw null;
                }
            }
        } else if (i2 == 6) {
            iArr[i - 1] = 7;
        } else if (i2 == 7) {
            if (M(false) == -1) {
                this.n = 18;
                return 18;
            }
            I();
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int M5 = M(true);
        if (M5 == 34) {
            this.m.readByte();
            this.n = 9;
            return 9;
        } else if (M5 == 39) {
            I();
            this.m.readByte();
            this.n = 8;
            return 8;
        } else {
            if (M5 != 44 && M5 != 59) {
                if (M5 == 91) {
                    this.m.readByte();
                    this.n = 3;
                    return 3;
                } else if (M5 != 93) {
                    if (M5 != 123) {
                        int P = P();
                        if (P != 0) {
                            return P;
                        }
                        int Q = Q();
                        if (Q != 0) {
                            return Q;
                        }
                        if (L(this.m.getByte(0L))) {
                            I();
                            this.n = 10;
                            return 10;
                        }
                        H("Expected value");
                        throw null;
                    }
                    this.m.readByte();
                    this.n = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.m.readByte();
                    this.n = 4;
                    return 4;
                }
            }
            if (i2 != 1 && i2 != 2) {
                H("Unexpected value");
                throw null;
            }
            I();
            this.n = 7;
            return 7;
        }
    }

    public final int K(String str, JsonReader.a aVar) {
        int length = aVar.f1630a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.f1630a[i])) {
                this.n = 0;
                this.f1628g[this.f1626e - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean L(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        I();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.m.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.l.request(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        I();
        r3 = r6.m.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.m.readByte();
        r6.m.readByte();
        U();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.m.readByte();
        r6.m.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (T() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        H("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        I();
        U();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int M(boolean z) throws IOException {
        while (true) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (!this.l.request(i2)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte b2 = this.m.getByte(i);
                if (b2 != 10 && b2 != 32 && b2 != 13 && b2 != 9) {
                    break;
                }
                i = i2;
            }
        }
    }

    public final String N(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.l.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.m.getByte(indexOfElement) != 92) {
                    if (sb == null) {
                        String readUtf8 = this.m.readUtf8(indexOfElement);
                        this.m.readByte();
                        return readUtf8;
                    }
                    sb.append(this.m.readUtf8(indexOfElement));
                    this.m.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.m.readUtf8(indexOfElement));
                this.m.readByte();
                sb.append(R());
            } else {
                H("Unterminated string");
                throw null;
            }
        }
    }

    public final String O() throws IOException {
        long indexOfElement = this.l.indexOfElement(t);
        return indexOfElement != -1 ? this.m.readUtf8(indexOfElement) : this.m.readUtf8();
    }

    public final int P() throws IOException {
        int i;
        String str;
        String str2;
        byte b2 = this.m.getByte(0L);
        if (b2 == 116 || b2 == 84) {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (b2 != 110 && b2 != 78) {
            return 0;
        } else {
            i = 7;
            str = StringUtil.NULL_STRING;
            str2 = "NULL";
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.l.request(i3)) {
                return 0;
            }
            byte b3 = this.m.getByte(i2);
            if (b3 != str.charAt(i2) && b3 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.l.request(length + 1) && L(this.m.getByte(length))) {
            return 0;
        }
        this.m.skip(length);
        this.n = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
        if (L(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
        if (r8 != Long.MIN_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
        if (r8 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009f, code lost:
        r16.o = r8;
        r16.m.skip(r5);
        r16.n = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ac, code lost:
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b2, code lost:
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b5, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
        r16.p = r5;
        r16.n = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bd, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00be, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Q() throws IOException {
        char c2 = 1;
        int i = 0;
        long j = 0;
        int i2 = 0;
        char c3 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            int i3 = i2 + 1;
            if (!this.l.request(i3)) {
                break;
            }
            byte b2 = this.m.getByte(i2);
            if (b2 != 43) {
                if (b2 == 69 || b2 == 101) {
                    if (c3 != 2 && c3 != 4) {
                        return i;
                    }
                    c3 = 5;
                } else if (b2 != 45) {
                    if (b2 != 46) {
                        if (b2 < 48 || b2 > 57) {
                            break;
                        } else if (c3 == c2 || c3 == 0) {
                            j = -(b2 - 48);
                            i = 0;
                            c3 = 2;
                        } else {
                            if (c3 == 2) {
                                if (j == 0) {
                                    return i;
                                }
                                long j2 = (10 * j) - (b2 - 48);
                                int i4 = (j > JSONLexerBase.MULTMIN_RADIX_TEN ? 1 : (j == JSONLexerBase.MULTMIN_RADIX_TEN ? 0 : -1));
                                z &= i4 > 0 || (i4 == 0 && j2 < j);
                                j = j2;
                            } else if (c3 == 3) {
                                i = 0;
                                c3 = 4;
                            } else if (c3 == 5 || c3 == 6) {
                                i = 0;
                                c3 = 7;
                            }
                            i = 0;
                        }
                    } else if (c3 != 2) {
                        return i;
                    } else {
                        c3 = 3;
                    }
                } else if (c3 == 0) {
                    c3 = 1;
                    z2 = true;
                } else if (c3 != 5) {
                    return i;
                }
                i2 = i3;
                c2 = 1;
            } else if (c3 != 5) {
                return i;
            }
            c3 = 6;
            i2 = i3;
            c2 = 1;
        }
    }

    public final char R() throws IOException {
        int i;
        int i2;
        if (this.l.request(1L)) {
            byte readByte = this.m.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte != 98) {
                if (readByte != 102) {
                    if (readByte != 110) {
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.i) {
                                        return (char) readByte;
                                    }
                                    H("Invalid escape sequence: \\" + ((char) readByte));
                                    throw null;
                                } else if (this.l.request(4L)) {
                                    char c2 = 0;
                                    for (int i3 = 0; i3 < 4; i3++) {
                                        byte b2 = this.m.getByte(i3);
                                        char c3 = (char) (c2 << 4);
                                        if (b2 < 48 || b2 > 57) {
                                            if (b2 >= 97 && b2 <= 102) {
                                                i = b2 - 97;
                                            } else if (b2 < 65 || b2 > 70) {
                                                H("\\u" + this.m.readUtf8(4L));
                                                throw null;
                                            } else {
                                                i = b2 - 65;
                                            }
                                            i2 = i + 10;
                                        } else {
                                            i2 = b2 - 48;
                                        }
                                        c2 = (char) (c3 + i2);
                                    }
                                    this.m.skip(4L);
                                    return c2;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + s());
                                }
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
        H("Unterminated escape sequence");
        throw null;
    }

    public final void S(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.l.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.m.getByte(indexOfElement) == 92) {
                    this.m.skip(indexOfElement + 1);
                    R();
                } else {
                    this.m.skip(indexOfElement + 1);
                    return;
                }
            } else {
                H("Unterminated string");
                throw null;
            }
        }
    }

    public final boolean T() throws IOException {
        long indexOf = this.l.indexOf(v);
        boolean z = indexOf != -1;
        Buffer buffer = this.m;
        buffer.skip(z ? indexOf + v.size() : buffer.size());
        return z;
    }

    public final void U() throws IOException {
        long indexOfElement = this.l.indexOfElement(u);
        Buffer buffer = this.m;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    public final void V() throws IOException {
        long indexOfElement = this.l.indexOfElement(t);
        Buffer buffer = this.m;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n = 0;
        this.f1627f[0] = 8;
        this.f1626e = 1;
        this.m.clear();
        this.l.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void n() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 3) {
            C(1);
            this.f1629h[this.f1626e - 1] = 0;
            this.n = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + B() + " at path " + s());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void o() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 1) {
            C(3);
            this.n = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + B() + " at path " + s());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void q() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 4) {
            int i2 = this.f1626e - 1;
            this.f1626e = i2;
            int[] iArr = this.f1629h;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.n = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + B() + " at path " + s());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void r() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 2) {
            int i2 = this.f1626e - 1;
            this.f1626e = i2;
            this.f1628g[i2] = null;
            int[] iArr = this.f1629h;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.n = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + B() + " at path " + s());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean t() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    public String toString() {
        return "JsonReader(" + this.l + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean v() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 5) {
            this.n = 0;
            int[] iArr = this.f1629h;
            int i2 = this.f1626e - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.n = 0;
            int[] iArr2 = this.f1629h;
            int i3 = this.f1626e - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + B() + " at path " + s());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double w() throws IOException {
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 16) {
            this.n = 0;
            int[] iArr = this.f1629h;
            int i2 = this.f1626e - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.o;
        }
        if (i == 17) {
            this.q = this.m.readUtf8(this.p);
        } else if (i == 9) {
            this.q = N(s);
        } else if (i == 8) {
            this.q = N(r);
        } else if (i == 10) {
            this.q = O();
        } else if (i != 11) {
            throw new JsonDataException("Expected a double but was " + B() + " at path " + s());
        }
        this.n = 11;
        try {
            double parseDouble = Double.parseDouble(this.q);
            if (!this.i && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + s());
            }
            this.q = null;
            this.n = 0;
            int[] iArr2 = this.f1629h;
            int i3 = this.f1626e - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.q + " at path " + s());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int x() throws IOException {
        String N;
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 16) {
            long j = this.o;
            int i2 = (int) j;
            if (j == i2) {
                this.n = 0;
                int[] iArr = this.f1629h;
                int i3 = this.f1626e - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.o + " at path " + s());
        }
        if (i == 17) {
            this.q = this.m.readUtf8(this.p);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                N = N(s);
            } else {
                N = N(r);
            }
            this.q = N;
            try {
                int parseInt = Integer.parseInt(N);
                this.n = 0;
                int[] iArr2 = this.f1629h;
                int i4 = this.f1626e - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new JsonDataException("Expected an int but was " + B() + " at path " + s());
        }
        this.n = 11;
        try {
            double parseDouble = Double.parseDouble(this.q);
            int i5 = (int) parseDouble;
            if (i5 == parseDouble) {
                this.q = null;
                this.n = 0;
                int[] iArr3 = this.f1629h;
                int i6 = this.f1626e - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.q + " at path " + s());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.q + " at path " + s());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String y() throws IOException {
        String str;
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 14) {
            str = O();
        } else if (i == 13) {
            str = N(s);
        } else if (i == 12) {
            str = N(r);
        } else if (i == 15) {
            str = this.q;
        } else {
            throw new JsonDataException("Expected a name but was " + B() + " at path " + s());
        }
        this.n = 0;
        this.f1628g[this.f1626e - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String z() throws IOException {
        String readUtf8;
        int i = this.n;
        if (i == 0) {
            i = J();
        }
        if (i == 10) {
            readUtf8 = O();
        } else if (i == 9) {
            readUtf8 = N(s);
        } else if (i == 8) {
            readUtf8 = N(r);
        } else if (i == 11) {
            readUtf8 = this.q;
            this.q = null;
        } else if (i == 16) {
            readUtf8 = Long.toString(this.o);
        } else if (i == 17) {
            readUtf8 = this.m.readUtf8(this.p);
        } else {
            throw new JsonDataException("Expected a string but was " + B() + " at path " + s());
        }
        this.n = 0;
        int[] iArr = this.f1629h;
        int i2 = this.f1626e - 1;
        iArr[i2] = iArr[i2] + 1;
        return readUtf8;
    }
}
