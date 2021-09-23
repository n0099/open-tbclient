package com.bytedance.sdk.openadsdk.preload.a.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.b.a.e;
import com.bytedance.sdk.openadsdk.preload.a.b.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68857a;

    /* renamed from: b  reason: collision with root package name */
    public final Reader f68858b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68859c;

    /* renamed from: d  reason: collision with root package name */
    public final char[] f68860d;

    /* renamed from: e  reason: collision with root package name */
    public int f68861e;

    /* renamed from: f  reason: collision with root package name */
    public int f68862f;

    /* renamed from: g  reason: collision with root package name */
    public int f68863g;

    /* renamed from: h  reason: collision with root package name */
    public int f68864h;

    /* renamed from: i  reason: collision with root package name */
    public long f68865i;

    /* renamed from: j  reason: collision with root package name */
    public int f68866j;
    public String k;
    public int[] l;
    public int m;
    public String[] n;
    public int[] o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639710222, "Lcom/bytedance/sdk/openadsdk/preload/a/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639710222, "Lcom/bytedance/sdk/openadsdk/preload/a/d/a;");
                return;
            }
        }
        f.f68811a = new f() { // from class: com.bytedance.sdk.openadsdk.preload.a.d.a.1
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

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.f
            public void a(a aVar) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    if (aVar instanceof e) {
                        ((e) aVar).o();
                        return;
                    }
                    int i2 = aVar.f68857a;
                    if (i2 == 0) {
                        i2 = aVar.r();
                    }
                    if (i2 == 13) {
                        aVar.f68857a = 9;
                    } else if (i2 == 12) {
                        aVar.f68857a = 8;
                    } else if (i2 == 14) {
                        aVar.f68857a = 10;
                    } else {
                        throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
                    }
                }
            }
        };
    }

    public a(Reader reader) {
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
        this.f68859c = false;
        this.f68860d = new char[1024];
        this.f68861e = 0;
        this.f68862f = 0;
        this.f68863g = 0;
        this.f68864h = 0;
        this.f68857a = 0;
        int[] iArr = new int[32];
        this.l = iArr;
        this.m = 0;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader != null) {
            this.f68858b = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private int o() throws IOException {
        InterceptResult invokeV;
        int i2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            char c2 = this.f68860d[this.f68861e];
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
                if (this.f68861e + i3 >= this.f68862f && !b(i3 + 1)) {
                    return 0;
                }
                char c3 = this.f68860d[this.f68861e + i3];
                if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                    return 0;
                }
            }
            if ((this.f68861e + length < this.f68862f || b(length + 1)) && a(this.f68860d[this.f68861e + length])) {
                return 0;
            }
            this.f68861e += length;
            this.f68857a = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (a(r14) != false) goto L78;
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
        r18.f68865i = r11;
        r18.f68861e += r8;
        r18.f68857a = 15;
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
        r18.f68866j = r8;
        r18.f68857a = 16;
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
    private int t() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65547, this)) != null) {
            return invokeV.intValue;
        }
        char[] cArr = this.f68860d;
        int i2 = this.f68861e;
        int i3 = this.f68862f;
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
                if (!b(i5 + 1)) {
                    break;
                }
                i2 = this.f68861e;
                i3 = this.f68862f;
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

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004e, code lost:
        w();
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String u() throws IOException {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            int i2 = 0;
            StringBuilder sb2 = null;
            do {
                int i3 = 0;
                while (true) {
                    int i4 = this.f68861e;
                    if (i4 + i3 < this.f68862f) {
                        char c2 = this.f68860d[i4 + i3];
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
                    } else if (i3 < this.f68860d.length) {
                        if (b(i3 + 1)) {
                        }
                    } else {
                        if (sb2 == null) {
                            sb2 = new StringBuilder(Math.max(i3, 16));
                        }
                        sb2.append(this.f68860d, this.f68861e, i3);
                        this.f68861e += i3;
                    }
                }
                i2 = i3;
                if (sb2 != null) {
                    sb = new String(this.f68860d, this.f68861e, i2);
                } else {
                    sb2.append(this.f68860d, this.f68861e, i2);
                    sb = sb2.toString();
                }
                this.f68861e += i2;
                return sb;
            } while (b(1));
            if (sb2 != null) {
            }
            this.f68861e += i2;
            return sb;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
        w();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            do {
                int i2 = 0;
                while (true) {
                    int i3 = this.f68861e;
                    if (i3 + i2 < this.f68862f) {
                        char c2 = this.f68860d[i3 + i2];
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
                        this.f68861e = i3 + i2;
                    }
                }
                this.f68861e += i2;
                return;
            } while (b(1));
        }
    }

    private void w() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && !this.f68859c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            do {
                if (this.f68861e >= this.f68862f && !b(1)) {
                    return;
                }
                char[] cArr = this.f68860d;
                int i2 = this.f68861e;
                int i3 = i2 + 1;
                this.f68861e = i3;
                c2 = cArr[i2];
                if (c2 == '\n') {
                    this.f68863g++;
                    this.f68864h = i3;
                    return;
                }
            } while (c2 != '\r');
        }
    }

    private char y() throws IOException {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.f68861e == this.f68862f && !b(1)) {
                throw b("Unterminated escape sequence");
            }
            char[] cArr = this.f68860d;
            int i4 = this.f68861e;
            int i5 = i4 + 1;
            this.f68861e = i5;
            char c2 = cArr[i4];
            if (c2 == '\n') {
                this.f68863g++;
                this.f68864h = i5;
            } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
                if (c2 != 'b') {
                    if (c2 != 'f') {
                        if (c2 != 'n') {
                            if (c2 != 'r') {
                                if (c2 != 't') {
                                    if (c2 == 'u') {
                                        if (i5 + 4 > this.f68862f && !b(4)) {
                                            throw b("Unterminated escape sequence");
                                        }
                                        char c3 = 0;
                                        int i6 = this.f68861e;
                                        int i7 = i6 + 4;
                                        while (i6 < i7) {
                                            char c4 = this.f68860d[i6];
                                            char c5 = (char) (c3 << 4);
                                            if (c4 < '0' || c4 > '9') {
                                                if (c4 >= 'a' && c4 <= 'f') {
                                                    i2 = c4 - 'a';
                                                } else if (c4 < 'A' || c4 > 'F') {
                                                    throw new NumberFormatException("\\u" + new String(this.f68860d, this.f68861e, 4));
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
                                        this.f68861e += 4;
                                        return c3;
                                    }
                                    throw b("Invalid escape sequence");
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

    private void z() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            b(true);
            int i2 = this.f68861e - 1;
            this.f68861e = i2;
            if (i2 + 5 <= this.f68862f || b(5)) {
                char[] cArr = this.f68860d;
                if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                    this.f68861e += 5;
                }
            }
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f68859c = z;
        }
    }

    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 4) {
                int i3 = this.m - 1;
                this.m = i3;
                int[] iArr = this.o;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
                this.f68857a = 0;
                return;
            }
            throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
        }
    }

    public void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 1) {
                a(3);
                this.f68857a = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f68857a = 0;
            this.l[0] = 8;
            this.m = 1;
            this.f68858b.close();
        }
    }

    public void d() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 2) {
                int i3 = this.m - 1;
                this.m = i3;
                this.n[i3] = null;
                int[] iArr = this.o;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
                this.f68857a = 0;
                return;
            }
            throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
        }
    }

    public boolean e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            return (i2 == 2 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public b f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            switch (i2) {
                case 1:
                    return b.f68869c;
                case 2:
                    return b.f68870d;
                case 3:
                    return b.f68867a;
                case 4:
                    return b.f68868b;
                case 5:
                case 6:
                    return b.f68874h;
                case 7:
                    return b.f68875i;
                case 8:
                case 9:
                case 10:
                case 11:
                    return b.f68872f;
                case 12:
                case 13:
                case 14:
                    return b.f68871e;
                case 15:
                case 16:
                    return b.f68873g;
                case 17:
                    return b.f68876j;
                default:
                    throw new AssertionError();
            }
        }
        return (b) invokeV.objValue;
    }

    public String g() throws IOException {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 14) {
                b2 = u();
            } else if (i2 == 12) {
                b2 = b(ExtendedMessageFormat.QUOTE);
            } else if (i2 == 13) {
                b2 = b('\"');
            } else {
                throw new IllegalStateException("Expected a name but was " + f() + s());
            }
            this.f68857a = 0;
            this.n[this.m - 1] = b2;
            return b2;
        }
        return (String) invokeV.objValue;
    }

    public String h() throws IOException {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 10) {
                str = u();
            } else if (i2 == 8) {
                str = b(ExtendedMessageFormat.QUOTE);
            } else if (i2 == 9) {
                str = b('\"');
            } else if (i2 == 11) {
                str = this.k;
                this.k = null;
            } else if (i2 == 15) {
                str = Long.toString(this.f68865i);
            } else if (i2 == 16) {
                str = new String(this.f68860d, this.f68861e, this.f68866j);
                this.f68861e += this.f68866j;
            } else {
                throw new IllegalStateException("Expected a string but was " + f() + s());
            }
            this.f68857a = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 5) {
                this.f68857a = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return true;
            } else if (i2 == 6) {
                this.f68857a = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return false;
            } else {
                throw new IllegalStateException("Expected a boolean but was " + f() + s());
            }
        }
        return invokeV.booleanValue;
    }

    public void j() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 7) {
                this.f68857a = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return;
            }
            throw new IllegalStateException("Expected null but was " + f() + s());
        }
    }

    public double k() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 15) {
                this.f68857a = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return this.f68865i;
            }
            if (i2 == 16) {
                this.k = new String(this.f68860d, this.f68861e, this.f68866j);
                this.f68861e += this.f68866j;
            } else if (i2 == 8 || i2 == 9) {
                this.k = b(i2 == 8 ? ExtendedMessageFormat.QUOTE : '\"');
            } else if (i2 == 10) {
                this.k = u();
            } else if (i2 != 11) {
                throw new IllegalStateException("Expected a double but was " + f() + s());
            }
            this.f68857a = 11;
            double parseDouble = Double.parseDouble(this.k);
            if (!this.f68859c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new d("JSON forbids NaN and infinities: " + parseDouble + s());
            }
            this.k = null;
            this.f68857a = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        return invokeV.doubleValue;
    }

    public long l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 15) {
                this.f68857a = 0;
                int[] iArr = this.o;
                int i3 = this.m - 1;
                iArr[i3] = iArr[i3] + 1;
                return this.f68865i;
            }
            if (i2 == 16) {
                this.k = new String(this.f68860d, this.f68861e, this.f68866j);
                this.f68861e += this.f68866j;
            } else if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + f() + s());
            } else {
                if (i2 == 10) {
                    this.k = u();
                } else {
                    this.k = b(i2 == 8 ? ExtendedMessageFormat.QUOTE : '\"');
                }
                try {
                    long parseLong = Long.parseLong(this.k);
                    this.f68857a = 0;
                    int[] iArr2 = this.o;
                    int i4 = this.m - 1;
                    iArr2[i4] = iArr2[i4] + 1;
                    return parseLong;
                } catch (NumberFormatException unused) {
                }
            }
            this.f68857a = 11;
            double parseDouble = Double.parseDouble(this.k);
            long j2 = (long) parseDouble;
            if (j2 == parseDouble) {
                this.k = null;
                this.f68857a = 0;
                int[] iArr3 = this.o;
                int i5 = this.m - 1;
                iArr3[i5] = iArr3[i5] + 1;
                return j2;
            }
            throw new NumberFormatException("Expected a long but was " + this.k + s());
        }
        return invokeV.longValue;
    }

    public int m() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 15) {
                long j2 = this.f68865i;
                int i3 = (int) j2;
                if (j2 == i3) {
                    this.f68857a = 0;
                    int[] iArr = this.o;
                    int i4 = this.m - 1;
                    iArr[i4] = iArr[i4] + 1;
                    return i3;
                }
                throw new NumberFormatException("Expected an int but was " + this.f68865i + s());
            }
            if (i2 == 16) {
                this.k = new String(this.f68860d, this.f68861e, this.f68866j);
                this.f68861e += this.f68866j;
            } else if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + f() + s());
            } else {
                if (i2 == 10) {
                    this.k = u();
                } else {
                    this.k = b(i2 == 8 ? ExtendedMessageFormat.QUOTE : '\"');
                }
                try {
                    int parseInt = Integer.parseInt(this.k);
                    this.f68857a = 0;
                    int[] iArr2 = this.o;
                    int i5 = this.m - 1;
                    iArr2[i5] = iArr2[i5] + 1;
                    return parseInt;
                } catch (NumberFormatException unused) {
                }
            }
            this.f68857a = 11;
            double parseDouble = Double.parseDouble(this.k);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.k = null;
                this.f68857a = 0;
                int[] iArr3 = this.o;
                int i7 = this.m - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new NumberFormatException("Expected an int but was " + this.k + s());
        }
        return invokeV.intValue;
    }

    public void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = 0;
            do {
                int i3 = this.f68857a;
                if (i3 == 0) {
                    i3 = r();
                }
                if (i3 == 3) {
                    a(1);
                } else if (i3 == 1) {
                    a(3);
                } else {
                    if (i3 == 4) {
                        this.m--;
                    } else if (i3 == 2) {
                        this.m--;
                    } else {
                        if (i3 == 14 || i3 == 10) {
                            v();
                        } else if (i3 == 8 || i3 == 12) {
                            c(ExtendedMessageFormat.QUOTE);
                        } else if (i3 == 9 || i3 == 13) {
                            c('\"');
                        } else if (i3 == 16) {
                            this.f68861e += this.f68866j;
                        }
                        this.f68857a = 0;
                    }
                    i2--;
                    this.f68857a = 0;
                }
                i2++;
                this.f68857a = 0;
            } while (i2 != 0);
            int[] iArr = this.o;
            int i4 = this.m;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.n[i4 - 1] = StringUtil.NULL_STRING;
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            int i2 = this.m;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.l[i3];
                if (i4 == 1 || i4 == 2) {
                    sb.append('[');
                    sb.append(this.o[i3]);
                    sb.append(']');
                } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                    sb.append('.');
                    String[] strArr = this.n;
                    if (strArr[i3] != null) {
                        sb.append(strArr[i3]);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f68859c : invokeV.booleanValue;
    }

    public int r() throws IOException {
        InterceptResult invokeV;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int[] iArr = this.l;
            int i2 = this.m;
            int i3 = iArr[i2 - 1];
            if (i3 == 1) {
                iArr[i2 - 1] = 2;
            } else if (i3 == 2) {
                int b3 = b(true);
                if (b3 != 44) {
                    if (b3 != 59) {
                        if (b3 == 93) {
                            this.f68857a = 4;
                            return 4;
                        }
                        throw b("Unterminated array");
                    }
                    w();
                }
            } else if (i3 == 3 || i3 == 5) {
                this.l[this.m - 1] = 4;
                if (i3 == 5 && (b2 = b(true)) != 44) {
                    if (b2 != 59) {
                        if (b2 == 125) {
                            this.f68857a = 2;
                            return 2;
                        }
                        throw b("Unterminated object");
                    }
                    w();
                }
                int b4 = b(true);
                if (b4 == 34) {
                    this.f68857a = 13;
                    return 13;
                } else if (b4 == 39) {
                    w();
                    this.f68857a = 12;
                    return 12;
                } else if (b4 == 125) {
                    if (i3 != 5) {
                        this.f68857a = 2;
                        return 2;
                    }
                    throw b("Expected name");
                } else {
                    w();
                    this.f68861e--;
                    if (a((char) b4)) {
                        this.f68857a = 14;
                        return 14;
                    }
                    throw b("Expected name");
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int b5 = b(true);
                if (b5 != 58) {
                    if (b5 == 61) {
                        w();
                        if (this.f68861e < this.f68862f || b(1)) {
                            char[] cArr = this.f68860d;
                            int i4 = this.f68861e;
                            if (cArr[i4] == '>') {
                                this.f68861e = i4 + 1;
                            }
                        }
                    } else {
                        throw b("Expected ':'");
                    }
                }
            } else if (i3 == 6) {
                if (this.f68859c) {
                    z();
                }
                this.l[this.m - 1] = 7;
            } else if (i3 == 7) {
                if (b(false) == -1) {
                    this.f68857a = 17;
                    return 17;
                }
                w();
                this.f68861e--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            int b6 = b(true);
            if (b6 == 34) {
                this.f68857a = 9;
                return 9;
            } else if (b6 == 39) {
                w();
                this.f68857a = 8;
                return 8;
            } else {
                if (b6 != 44 && b6 != 59) {
                    if (b6 == 91) {
                        this.f68857a = 3;
                        return 3;
                    } else if (b6 != 93) {
                        if (b6 != 123) {
                            this.f68861e--;
                            int o = o();
                            if (o != 0) {
                                return o;
                            }
                            int t = t();
                            if (t != 0) {
                                return t;
                            }
                            if (a(this.f68860d[this.f68861e])) {
                                w();
                                this.f68857a = 10;
                                return 10;
                            }
                            throw b("Expected value");
                        }
                        this.f68857a = 1;
                        return 1;
                    } else if (i3 == 1) {
                        this.f68857a = 4;
                        return 4;
                    }
                }
                if (i3 != 1 && i3 != 2) {
                    throw b("Unexpected value");
                }
                w();
                this.f68861e--;
                this.f68857a = 7;
                return 7;
            }
        }
        return invokeV.intValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return " at line " + (this.f68863g + 1) + " column " + ((this.f68861e - this.f68864h) + 1) + " path " + p();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return getClass().getSimpleName() + s();
        }
        return (String) invokeV.objValue;
    }

    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f68857a;
            if (i2 == 0) {
                i2 = r();
            }
            if (i2 == 3) {
                a(1);
                this.o[this.m - 1] = 0;
                this.f68857a = 0;
                return;
            }
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
        }
    }

    private void c(char c2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Character.valueOf(c2)}) == null) {
            char[] cArr = this.f68860d;
            do {
                int i2 = this.f68861e;
                int i3 = this.f68862f;
                while (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f68861e = i4;
                        return;
                    } else if (c3 == '\\') {
                        this.f68861e = i4;
                        y();
                        i2 = this.f68861e;
                        i3 = this.f68862f;
                    } else {
                        if (c3 == '\n') {
                            this.f68863g++;
                            this.f68864h = i4;
                        }
                        i2 = i4;
                    }
                }
                this.f68861e = i2;
            } while (b(1));
            throw b("Unterminated string");
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
        r9.f68861e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(char c2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Character.valueOf(c2)})) == null) {
            char[] cArr = this.f68860d;
            StringBuilder sb = null;
            do {
                int i2 = this.f68861e;
                int i3 = this.f68862f;
                while (true) {
                    int i4 = i3;
                    int i5 = i2;
                    while (i2 < i4) {
                        int i6 = i2 + 1;
                        char c3 = cArr[i2];
                        if (c3 == c2) {
                            this.f68861e = i6;
                            int i7 = (i6 - i5) - 1;
                            if (sb == null) {
                                return new String(cArr, i5, i7);
                            }
                            sb.append(cArr, i5, i7);
                            return sb.toString();
                        } else if (c3 == '\\') {
                            this.f68861e = i6;
                            int i8 = (i6 - i5) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                            }
                            sb.append(cArr, i5, i8);
                            sb.append(y());
                            i2 = this.f68861e;
                            i3 = this.f68862f;
                        } else {
                            if (c3 == '\n') {
                                this.f68863g++;
                                this.f68864h = i6;
                            }
                            i2 = i6;
                        }
                    }
                    break;
                }
            } while (b(1));
            throw b("Unterminated string");
        }
        return (String) invokeCommon.objValue;
    }

    private boolean a(char c2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Character.valueOf(c2)})) == null) {
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
            w();
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            int i3 = this.m;
            int[] iArr = this.l;
            if (i3 == iArr.length) {
                int i4 = i3 * 2;
                this.l = Arrays.copyOf(iArr, i4);
                this.o = Arrays.copyOf(this.o, i4);
                this.n = (String[]) Arrays.copyOf(this.n, i4);
            }
            int[] iArr2 = this.l;
            int i5 = this.m;
            this.m = i5 + 1;
            iArr2[i5] = i2;
        }
    }

    private boolean a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) != null) {
            return invokeL.booleanValue;
        }
        int length = str.length();
        while (true) {
            if (this.f68861e + length > this.f68862f && !b(length)) {
                return false;
            }
            char[] cArr = this.f68860d;
            int i2 = this.f68861e;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f68860d[this.f68861e + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f68863g++;
            this.f68864h = i2 + 1;
            this.f68861e++;
        }
    }

    private boolean b(int i2) throws IOException {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            char[] cArr = this.f68860d;
            int i4 = this.f68864h;
            int i5 = this.f68861e;
            this.f68864h = i4 - i5;
            int i6 = this.f68862f;
            if (i6 != i5) {
                int i7 = i6 - i5;
                this.f68862f = i7;
                System.arraycopy(cArr, i5, cArr, 0, i7);
            } else {
                this.f68862f = 0;
            }
            this.f68861e = 0;
            do {
                Reader reader = this.f68858b;
                int i8 = this.f68862f;
                int read = reader.read(cArr, i8, cArr.length - i8);
                if (read == -1) {
                    return false;
                }
                int i9 = this.f68862f + read;
                this.f68862f = i9;
                if (this.f68863g == 0 && (i3 = this.f68864h) == 0 && i9 > 0 && cArr[0] == 65279) {
                    this.f68861e++;
                    this.f68864h = i3 + 1;
                    i2++;
                }
            } while (this.f68862f < i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    private int b(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z)) != null) {
            return invokeZ.intValue;
        }
        char[] cArr = this.f68860d;
        int i2 = this.f68861e;
        int i3 = this.f68862f;
        while (true) {
            if (i2 == i3) {
                this.f68861e = i2;
                if (!b(1)) {
                    if (z) {
                        throw new EOFException("End of input" + s());
                    }
                    return -1;
                }
                i2 = this.f68861e;
                i3 = this.f68862f;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f68863g++;
                this.f68864h = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f68861e = i4;
                    if (i4 == i3) {
                        this.f68861e = i4 - 1;
                        boolean b2 = b(2);
                        this.f68861e++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    w();
                    int i5 = this.f68861e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f68861e = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f68861e + 2;
                            i3 = this.f68862f;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f68861e = i5 + 1;
                        x();
                        i2 = this.f68861e;
                        i3 = this.f68862f;
                    }
                } else if (c2 == '#') {
                    this.f68861e = i4;
                    w();
                    x();
                    i2 = this.f68861e;
                    i3 = this.f68862f;
                } else {
                    this.f68861e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private IOException b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            throw new d(str + s());
        }
        return (IOException) invokeL.objValue;
    }
}
