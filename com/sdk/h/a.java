package com.sdk.h;

import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593107760, "Lcom/sdk/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593107760, "Lcom/sdk/h/a;");
                return;
            }
        }
        a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};
        b = new byte[256];
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            b[i2] = -1;
        }
        while (true) {
            char[] cArr = a;
            if (i >= cArr.length) {
                return;
            }
            b[cArr[i]] = (byte) i;
            i++;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new byte[4];
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
    @Override // com.sdk.h.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, pushbackInputStream, outputStream, i) == null) {
            if (i < 2) {
                throw new b("BASE64Decoder: Not enough bytes for an atom.");
            }
            while (true) {
                int read = pushbackInputStream.read();
                byte b6 = -1;
                if (read != -1) {
                    if (read != 10 && read != 13) {
                        byte[] bArr = this.c;
                        bArr[0] = (byte) read;
                        int i5 = i - 1;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= i5) {
                                break;
                            }
                            int read2 = pushbackInputStream.read();
                            if (read2 == -1) {
                                if (i6 == 0) {
                                    i5 = -1;
                                } else {
                                    i5 = i6;
                                }
                            } else {
                                i6++;
                                bArr[i6] = (byte) read2;
                            }
                        }
                        if (i5 != -1) {
                            if (i > 3 && this.c[3] == 61) {
                                i = 3;
                            }
                            if (i > 2 && this.c[2] == 61) {
                                i = 2;
                            }
                            if (i != 2) {
                                if (i != 3) {
                                    if (i != 4) {
                                        b4 = -1;
                                        b5 = -1;
                                        b3 = -1;
                                        if (i == 2) {
                                            if (i != 3) {
                                                if (i == 4) {
                                                    outputStream.write((byte) (((b6 << 2) & GDiffPatcher.COPY_INT_UBYTE) | ((b3 >>> 4) & 3)));
                                                    outputStream.write((byte) (((b3 << 4) & 240) | ((b4 >>> 2) & 15)));
                                                    i3 = (b4 << 6) & 192;
                                                    i4 = b5 & 63;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                outputStream.write((byte) (((b6 << 2) & GDiffPatcher.COPY_INT_UBYTE) | (3 & (b3 >>> 4))));
                                                i3 = (b3 << 4) & 240;
                                                i4 = (b4 >>> 2) & 15;
                                            }
                                            i2 = i3 | i4;
                                        } else {
                                            i2 = ((b3 >>> 4) & 3) | ((b6 << 2) & GDiffPatcher.COPY_INT_UBYTE);
                                        }
                                        outputStream.write((byte) i2);
                                        return;
                                    }
                                    b6 = b[this.c[3] & 255];
                                }
                                b2 = b6;
                                b6 = b[this.c[2] & 255];
                            } else {
                                b2 = -1;
                            }
                            byte[] bArr2 = b;
                            byte[] bArr3 = this.c;
                            b3 = bArr2[bArr3[1] & 255];
                            byte b7 = b2;
                            b4 = b6;
                            b6 = bArr2[bArr3[0] & 255];
                            b5 = b7;
                            if (i == 2) {
                            }
                            outputStream.write((byte) i2);
                            return;
                        }
                        throw new c();
                    }
                } else {
                    throw new c();
                }
            }
        }
    }
}
