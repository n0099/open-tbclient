package okhttp3.internal.tls;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes8.dex */
public final class DistinguishedNameParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int beg;
    public char[] chars;
    public int cur;
    public final String dn;
    public int end;
    public final int length;
    public int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x500Principal};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String escapedAV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i = this.pos;
            this.beg = i;
            this.end = i;
            while (true) {
                int i2 = this.pos;
                if (i2 >= this.length) {
                    char[] cArr = this.chars;
                    int i3 = this.beg;
                    return new String(cArr, i3, this.end - i3);
                }
                char[] cArr2 = this.chars;
                char c2 = cArr2[i2];
                if (c2 == ' ') {
                    int i4 = this.end;
                    this.cur = i4;
                    this.pos = i2 + 1;
                    this.end = i4 + 1;
                    cArr2[i4] = WebvttCueParser.CHAR_SPACE;
                    while (true) {
                        int i5 = this.pos;
                        if (i5 >= this.length) {
                            break;
                        }
                        char[] cArr3 = this.chars;
                        if (cArr3[i5] != ' ') {
                            break;
                        }
                        int i6 = this.end;
                        this.end = i6 + 1;
                        cArr3[i6] = WebvttCueParser.CHAR_SPACE;
                        this.pos = i5 + 1;
                    }
                    int i7 = this.pos;
                    if (i7 == this.length) {
                        break;
                    }
                    char[] cArr4 = this.chars;
                    if (cArr4[i7] == ',' || cArr4[i7] == '+' || cArr4[i7] == ';') {
                        break;
                    }
                } else if (c2 == ';') {
                    break;
                } else if (c2 == '\\') {
                    int i8 = this.end;
                    this.end = i8 + 1;
                    cArr2[i8] = getEscaped();
                    this.pos++;
                } else if (c2 == '+' || c2 == ',') {
                    break;
                } else {
                    int i9 = this.end;
                    this.end = i9 + 1;
                    cArr2[i9] = cArr2[i2];
                    this.pos = i2 + 1;
                }
            }
            char[] cArr5 = this.chars;
            int i10 = this.beg;
            return new String(cArr5, i10, this.end - i10);
        }
        return (String) invokeV.objValue;
    }

    private int getByte(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            int i4 = i + 1;
            if (i4 < this.length) {
                char c2 = this.chars[i];
                if (c2 >= '0' && c2 <= '9') {
                    i2 = c2 - '0';
                } else if (c2 >= 'a' && c2 <= 'f') {
                    i2 = c2 - 'W';
                } else if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.dn);
                } else {
                    i2 = c2 - '7';
                }
                char c3 = this.chars[i4];
                if (c3 >= '0' && c3 <= '9') {
                    i3 = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i3 = c3 - 'W';
                } else if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.dn);
                } else {
                    i3 = c3 - '7';
                }
                return (i2 << 4) + i3;
            }
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        return invokeI.intValue;
    }

    private char getEscaped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = this.pos + 1;
            this.pos = i;
            if (i != this.length) {
                char c2 = this.chars[i];
                if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
                    switch (c2) {
                        case '*':
                        case '+':
                        case ',':
                            break;
                        default:
                            switch (c2) {
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    return getUTF8();
                            }
                    }
                }
                return this.chars[this.pos];
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        return invokeV.charValue;
    }

    private char getUTF8() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i3 = getByte(this.pos);
            this.pos++;
            if (i3 < 128) {
                return (char) i3;
            }
            if (i3 < 192 || i3 > 247) {
                return '?';
            }
            if (i3 <= 223) {
                i2 = i3 & 31;
                i = 1;
            } else if (i3 <= 239) {
                i = 2;
                i2 = i3 & 15;
            } else {
                i = 3;
                i2 = i3 & 7;
            }
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.pos + 1;
                this.pos = i5;
                if (i5 == this.length || this.chars[i5] != '\\') {
                    return '?';
                }
                int i6 = i5 + 1;
                this.pos = i6;
                int i7 = getByte(i6);
                this.pos++;
                if ((i7 & 192) != 128) {
                    return '?';
                }
                i2 = (i2 << 6) + (i7 & 63);
            }
            return (char) i2;
        }
        return invokeV.charValue;
    }

    private String hexAV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.pos;
            if (i + 4 < this.length) {
                this.beg = i;
                this.pos = i + 1;
                while (true) {
                    int i2 = this.pos;
                    if (i2 == this.length) {
                        break;
                    }
                    char[] cArr = this.chars;
                    if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                        break;
                    } else if (cArr[i2] == ' ') {
                        this.end = i2;
                        this.pos = i2 + 1;
                        while (true) {
                            int i3 = this.pos;
                            if (i3 >= this.length || this.chars[i3] != ' ') {
                                break;
                            }
                            this.pos = i3 + 1;
                        }
                    } else {
                        if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                            cArr[i2] = (char) (cArr[i2] + WebvttCueParser.CHAR_SPACE);
                        }
                        this.pos++;
                    }
                }
                this.end = this.pos;
                int i4 = this.end;
                int i5 = this.beg;
                int i6 = i4 - i5;
                if (i6 >= 5 && (i6 & 1) != 0) {
                    int i7 = i6 / 2;
                    byte[] bArr = new byte[i7];
                    int i8 = i5 + 1;
                    for (int i9 = 0; i9 < i7; i9++) {
                        bArr[i9] = (byte) getByte(i8);
                        i8 += 2;
                    }
                    return new String(this.chars, this.beg, i6);
                }
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        return (String) invokeV.objValue;
    }

    private String nextAT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            while (true) {
                int i = this.pos;
                if (i >= this.length || this.chars[i] != ' ') {
                    break;
                }
                this.pos = i + 1;
            }
            int i2 = this.pos;
            if (i2 == this.length) {
                return null;
            }
            this.beg = i2;
            this.pos = i2 + 1;
            while (true) {
                int i3 = this.pos;
                if (i3 >= this.length) {
                    break;
                }
                char[] cArr = this.chars;
                if (cArr[i3] == '=' || cArr[i3] == ' ') {
                    break;
                }
                this.pos = i3 + 1;
            }
            int i4 = this.pos;
            if (i4 < this.length) {
                this.end = i4;
                if (this.chars[i4] == ' ') {
                    while (true) {
                        int i5 = this.pos;
                        if (i5 >= this.length) {
                            break;
                        }
                        char[] cArr2 = this.chars;
                        if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                            break;
                        }
                        this.pos = i5 + 1;
                    }
                    char[] cArr3 = this.chars;
                    int i6 = this.pos;
                    if (cArr3[i6] != '=' || i6 == this.length) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
                    }
                }
                this.pos++;
                while (true) {
                    int i7 = this.pos;
                    if (i7 >= this.length || this.chars[i7] != ' ') {
                        break;
                    }
                    this.pos = i7 + 1;
                }
                int i8 = this.end;
                int i9 = this.beg;
                if (i8 - i9 > 4) {
                    char[] cArr4 = this.chars;
                    if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                        char[] cArr5 = this.chars;
                        int i10 = this.beg;
                        if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                            char[] cArr6 = this.chars;
                            int i11 = this.beg;
                            if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                                this.beg += 4;
                            }
                        }
                    }
                }
                char[] cArr7 = this.chars;
                int i12 = this.beg;
                return new String(cArr7, i12, this.end - i12);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        return (String) invokeV.objValue;
    }

    private String quotedAV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, this)) != null) {
            return (String) invokeV.objValue;
        }
        int i = this.pos + 1;
        this.pos = i;
        this.beg = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 != this.length) {
                char[] cArr = this.chars;
                if (cArr[i2] == '\"') {
                    this.pos = i2 + 1;
                    while (true) {
                        int i3 = this.pos;
                        if (i3 >= this.length || this.chars[i3] != ' ') {
                            break;
                        }
                        this.pos = i3 + 1;
                    }
                    char[] cArr2 = this.chars;
                    int i4 = this.beg;
                    return new String(cArr2, i4, this.end - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.end] = getEscaped();
                } else {
                    cArr[this.end] = cArr[i2];
                }
                this.pos++;
                this.end++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
    }

    public String findMostSpecific(String str) {
        InterceptResult invokeL;
        String quotedAV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.pos = 0;
            this.beg = 0;
            this.end = 0;
            this.cur = 0;
            this.chars = this.dn.toCharArray();
            String nextAT = nextAT();
            if (nextAT == null) {
                return null;
            }
            do {
                int i = this.pos;
                if (i == this.length) {
                    return null;
                }
                char c2 = this.chars[i];
                if (c2 == '\"') {
                    quotedAV = quotedAV();
                } else if (c2 != '#') {
                    quotedAV = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : escapedAV();
                } else {
                    quotedAV = hexAV();
                }
                if (str.equalsIgnoreCase(nextAT)) {
                    return quotedAV;
                }
                int i2 = this.pos;
                if (i2 >= this.length) {
                    return null;
                }
                char[] cArr = this.chars;
                if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                    throw new IllegalStateException("Malformed DN: " + this.dn);
                }
                this.pos++;
                nextAT = nextAT();
            } while (nextAT != null);
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        return (String) invokeL.objValue;
    }
}
