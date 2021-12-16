package com.dxmpay.apollon.utils.support;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes2.dex */
public class Base64 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f55783b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f55784c;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f55785d;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f55786e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f55787f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ boolean f55788g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class InputStream extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f55789e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f55790f;

        /* renamed from: g  reason: collision with root package name */
        public final int f55791g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f55792h;

        /* renamed from: i  reason: collision with root package name */
        public final int f55793i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f55794j;

        /* renamed from: k  reason: collision with root package name */
        public int f55795k;
        public int l;
        public int m;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((java.io.InputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            int read;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f55795k < 0) {
                    if (this.f55789e) {
                        byte[] bArr = new byte[3];
                        int i2 = 0;
                        for (int i3 = 0; i3 < 3; i3++) {
                            int read2 = ((FilterInputStream) this).in.read();
                            if (read2 < 0) {
                                break;
                            }
                            bArr[i3] = (byte) read2;
                            i2++;
                        }
                        if (i2 <= 0) {
                            return -1;
                        }
                        Base64.g(bArr, 0, i2, this.f55790f, 0, this.f55793i);
                        this.f55795k = 0;
                        this.l = 4;
                    } else {
                        byte[] bArr2 = new byte[4];
                        int i4 = 0;
                        while (i4 < 4) {
                            do {
                                read = ((FilterInputStream) this).in.read();
                                if (read < 0) {
                                    break;
                                }
                            } while (this.f55794j[read & 127] <= -5);
                            if (read < 0) {
                                break;
                            }
                            bArr2[i4] = (byte) read;
                            i4++;
                        }
                        if (i4 != 4) {
                            if (i4 == 0) {
                                return -1;
                            }
                            throw new IOException("Improperly padded Base64 input.");
                        }
                        this.l = Base64.e(bArr2, 0, this.f55790f, 0, this.f55793i);
                        this.f55795k = 0;
                    }
                }
                int i5 = this.f55795k;
                if (i5 >= 0) {
                    if (i5 >= this.l) {
                        return -1;
                    }
                    if (this.f55789e && this.f55792h && this.m >= 76) {
                        this.m = 0;
                        return 10;
                    }
                    this.m++;
                    byte[] bArr3 = this.f55790f;
                    int i6 = this.f55795k;
                    int i7 = i6 + 1;
                    this.f55795k = i7;
                    byte b2 = bArr3[i6];
                    if (i7 >= this.f55791g) {
                        this.f55795k = -1;
                    }
                    return b2 & 255;
                }
                throw new IOException("Error in Base64 code reading stream.");
            }
            return invokeV.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((java.io.InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f55793i = i2;
            this.f55792h = (i2 & 8) > 0;
            boolean z = (i2 & 1) > 0;
            this.f55789e = z;
            int i5 = z ? 4 : 3;
            this.f55791g = i5;
            this.f55790f = new byte[i5];
            this.f55795k = -1;
            this.m = 0;
            this.f55794j = Base64.i(i2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        break;
                    }
                    int read = read();
                    if (read >= 0) {
                        bArr[i2 + i4] = (byte) read;
                        i4++;
                    } else if (i4 == 0) {
                        return -1;
                    }
                }
                return i4;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class OutputStream extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f55796e;

        /* renamed from: f  reason: collision with root package name */
        public final int f55797f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f55798g;

        /* renamed from: h  reason: collision with root package name */
        public final byte[] f55799h;

        /* renamed from: i  reason: collision with root package name */
        public final int f55800i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f55801j;

        /* renamed from: k  reason: collision with root package name */
        public int f55802k;
        public byte[] l;
        public int m;
        public boolean n;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((java.io.OutputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                flushBase64();
                super.close();
                this.l = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        public void flushBase64() throws IOException {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i2 = this.f55802k) <= 0) {
                return;
            }
            if (this.f55796e) {
                java.io.OutputStream outputStream = ((FilterOutputStream) this).out;
                byte[] bArr = this.f55799h;
                Base64.h(bArr, this.l, i2, this.f55800i);
                outputStream.write(bArr);
                this.f55802k = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void resumeEncoding() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.n = false;
            }
        }

        public void suspendEncoding() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                flushBase64();
                this.n = true;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (this.n) {
                    ((FilterOutputStream) this).out.write(i2);
                } else if (this.f55796e) {
                    byte[] bArr = this.l;
                    int i3 = this.f55802k;
                    int i4 = i3 + 1;
                    this.f55802k = i4;
                    bArr[i3] = (byte) i2;
                    int i5 = this.f55797f;
                    if (i4 >= i5) {
                        java.io.OutputStream outputStream = ((FilterOutputStream) this).out;
                        byte[] bArr2 = this.f55799h;
                        Base64.h(bArr2, bArr, i5, this.f55800i);
                        outputStream.write(bArr2);
                        int i6 = this.m + 4;
                        this.m = i6;
                        if (this.f55798g && i6 >= 76) {
                            ((FilterOutputStream) this).out.write(10);
                            this.m = 0;
                        }
                        this.f55802k = 0;
                    }
                } else {
                    byte[] bArr3 = this.f55801j;
                    int i7 = i2 & 127;
                    if (bArr3[i7] > -5) {
                        byte[] bArr4 = this.l;
                        int i8 = this.f55802k;
                        int i9 = i8 + 1;
                        this.f55802k = i9;
                        bArr4[i8] = (byte) i2;
                        if (i9 >= this.f55797f) {
                            ((FilterOutputStream) this).out.write(this.f55799h, 0, Base64.e(bArr4, 0, this.f55799h, 0, this.f55800i));
                            this.f55802k = 0;
                        }
                    } else if (bArr3[i7] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((java.io.OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f55798g = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.f55796e = z;
            int i5 = z ? 3 : 4;
            this.f55797f = i5;
            this.l = new byte[i5];
            this.f55802k = 0;
            this.m = 0;
            this.n = false;
            this.f55799h = new byte[4];
            this.f55800i = i2;
            this.f55801j = Base64.i(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
                if (this.n) {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    return;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    write(bArr[i2 + i4]);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends ObjectInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ClassLoader f55803e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(java.io.InputStream inputStream, ClassLoader classLoader) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, classLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((java.io.InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55803e = classLoader;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objectStreamClass)) == null) {
                Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.f55803e);
                return cls == null ? super.resolveClass(objectStreamClass) : cls;
            }
            return (Class) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(294569528, "Lcom/dxmpay/apollon/utils/support/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(294569528, "Lcom/dxmpay/apollon/utils/support/Base64;");
                return;
            }
        }
        f55788g = !Base64.class.desiredAssertionStatus();
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f55783b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f55784c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        f55785d = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f55786e = new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
        f55787f = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public Base64() {
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

    public static byte[] decode(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) ? decode(bArr, 0, bArr.length, 0) : (byte[]) invokeL.objValue;
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            byte[] decodeFromFile = decodeFromFile(str);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedOutputStream.write(decodeFromFile);
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65547, null, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.length() <= 2147483647L) {
                    byte[] bArr = new byte[(int) file.length()];
                    InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                    int i2 = 0;
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr, i2, 4096);
                            if (read < 0) {
                                break;
                            }
                            i2 += read;
                        } catch (IOException e2) {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    }
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    try {
                        inputStream2.close();
                    } catch (Exception unused2) {
                    }
                    return bArr2;
                }
                throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            OutputStream outputStream2 = null;
            try {
                try {
                    outputStream = new OutputStream(new FileOutputStream(str2), 0);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream.write(str.getBytes("US-ASCII"));
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th2) {
                    th = th2;
                    outputStream2 = outputStream;
                    try {
                        outputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? decodeToObject(str, 0, null) : invokeL.objValue;
    }

    public static int e(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
                        if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
                            byte[] i7 = i(i4);
                            int i8 = i2 + 2;
                            if (bArr[i8] == 61) {
                                bArr2[i3] = (byte) ((((i7[bArr[i2 + 1]] & 255) << 12) | ((i7[bArr[i2]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i5] == 61) {
                                int i9 = ((i7[bArr[i8]] & 255) << 6) | ((i7[bArr[i2 + 1]] & 255) << 12) | ((i7[bArr[i2]] & 255) << 18);
                                bArr2[i3] = (byte) (i9 >>> 16);
                                bArr2[i3 + 1] = (byte) (i9 >>> 8);
                                return 2;
                            } else {
                                int i10 = (i7[bArr[i5]] & 255) | ((i7[bArr[i2 + 1]] & 255) << 12) | ((i7[bArr[i2]] & 255) << 18) | ((i7[bArr[i8]] & 255) << 6);
                                bArr2[i3] = (byte) (i10 >> 16);
                                bArr2[i3 + 1] = (byte) (i10 >> 8);
                                bArr2[i6] = (byte) i10;
                                return 3;
                            }
                        }
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
                    }
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
                }
                throw new NullPointerException("Destination array was null.");
            }
            throw new NullPointerException("Source array was null.");
        }
        return invokeCommon.intValue;
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, byteBuffer, byteBuffer2) == null) {
            byte[] bArr = new byte[3];
            byte[] bArr2 = new byte[4];
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(3, byteBuffer.remaining());
                byteBuffer.get(bArr, 0, min);
                h(bArr2, bArr, min, 0);
                byteBuffer2.put(bArr2);
            }
        }
    }

    public static String encodeBytes(byte[] bArr) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bArr)) == null) {
            try {
                str = encodeBytes(bArr, 0, bArr.length, 0);
            } catch (IOException e2) {
                if (!f55788g) {
                    throw new AssertionError(e2.getMessage());
                }
                str = null;
            }
            if (f55788g || str != null) {
                return str;
            }
            throw new AssertionError();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bArr)) == null) {
            try {
                return encodeBytesToBytes(bArr, 0, bArr.length, 0);
            } catch (IOException e2) {
                if (f55788g) {
                    return null;
                }
                throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static void encodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, str, str2) == null) {
            String encodeFromFile = encodeFromFile(str);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65561, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
                int i2 = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i2, "US-ASCII");
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, serializable)) == null) ? encodeObject(serializable, 0) : (String) invokeL.objValue;
    }

    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, bArr, str) == null) {
            if (bArr != null) {
                OutputStream outputStream2 = null;
                try {
                    try {
                        outputStream = new OutputStream(new FileOutputStream(str), 1);
                    } catch (IOException e2) {
                        throw e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream.write(bArr);
                    try {
                        outputStream.close();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream2 = outputStream;
                    try {
                        outputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            }
            throw new NullPointerException("Data to encode was null.");
        }
    }

    public static final byte[] f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65565, null, i2)) == null) {
            if ((i2 & 16) == 16) {
                return f55784c;
            }
            if ((i2 & 32) == 32) {
                return f55786e;
            }
            return a;
        }
        return (byte[]) invokeI.objValue;
    }

    public static byte[] g(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            byte[] f2 = f(i5);
            int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
            if (i3 == 1) {
                bArr2[i4] = f2[i6 >>> 18];
                bArr2[i4 + 1] = f2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = 61;
                bArr2[i4 + 3] = 61;
                return bArr2;
            } else if (i3 == 2) {
                bArr2[i4] = f2[i6 >>> 18];
                bArr2[i4 + 1] = f2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = f2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = 61;
                return bArr2;
            } else if (i3 != 3) {
                return bArr2;
            } else {
                bArr2[i4] = f2[i6 >>> 18];
                bArr2[i4 + 1] = f2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = f2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = f2[i6 & 63];
                return bArr2;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65567, null, bArr, bArr2, i2, i3)) == null) {
            g(bArr2, 0, i2, bArr, 0, i3);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static final byte[] i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i2)) == null) {
            if ((i2 & 16) == 16) {
                return f55785d;
            }
            if ((i2 & 32) == 32) {
                return f55787f;
            }
            return f55783b;
        }
        return (byte[]) invokeI.objValue;
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65545, null, bArr, i2, i3, i4)) == null) {
            if (bArr != null) {
                if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
                }
                if (i3 == 0) {
                    return new byte[0];
                }
                if (i3 >= 4) {
                    byte[] i6 = i(i4);
                    byte[] bArr2 = new byte[(i3 * 3) / 4];
                    byte[] bArr3 = new byte[4];
                    int i7 = 0;
                    int i8 = 0;
                    while (i2 < i5) {
                        byte b2 = i6[bArr[i2] & 255];
                        if (b2 < -5) {
                            throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
                        }
                        if (b2 >= -1) {
                            int i9 = i7 + 1;
                            bArr3[i7] = bArr[i2];
                            if (i9 > 3) {
                                i8 += e(bArr3, 0, bArr2, i8, i4);
                                if (bArr[i2] == 61) {
                                    break;
                                }
                                i7 = 0;
                            } else {
                                i7 = i9;
                            }
                        }
                        i2++;
                    }
                    byte[] bArr4 = new byte[i8];
                    System.arraycopy(bArr2, 0, bArr4, 0, i8);
                    return bArr4;
                }
                throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
            }
            throw new NullPointerException("Cannot decode null source array.");
        }
        return (byte[]) invokeLIII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static Object decodeToObject(String str, int i2, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        InterceptResult invokeLIL;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65550, null, str, i2, classLoader)) == null) {
            byte[] decode = decode(str, i2);
            ByteArrayInputStream byteArrayInputStream2 = null;
            r5 = null;
            r5 = null;
            ObjectInputStream objectInputStream = null;
            byteArrayInputStream2 = null;
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(decode);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (ClassNotFoundException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                classLoader = 0;
            }
            try {
                if (classLoader == 0) {
                    aVar = new ObjectInputStream(byteArrayInputStream);
                } else {
                    aVar = new a(byteArrayInputStream, classLoader);
                }
                objectInputStream = aVar;
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused2) {
                }
                return readObject;
            } catch (IOException e4) {
                e = e4;
                throw e;
            } catch (ClassNotFoundException e5) {
                e = e5;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                classLoader = objectInputStream;
                byteArrayInputStream2 = byteArrayInputStream;
                try {
                    byteArrayInputStream2.close();
                } catch (Exception unused3) {
                }
                try {
                    classLoader.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
        return invokeLIL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0023 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static String encodeObject(Serializable serializable, int i2) throws IOException {
        InterceptResult invokeLI;
        ?? r6;
        ?? r1;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65563, null, serializable, i2)) != null) {
            return (String) invokeLI.objValue;
        }
        if (serializable != null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                r1 = new ByteArrayOutputStream();
                try {
                    outputStream = new OutputStream(r1, i2 | 1);
                    try {
                        if ((i2 & 2) != 0) {
                            r6 = new GZIPOutputStream(outputStream);
                            try {
                                objectOutputStream2 = new ObjectOutputStream(r6);
                                r6 = r6;
                            } catch (IOException e2) {
                                e = e2;
                                objectOutputStream = objectOutputStream2;
                                objectOutputStream2 = r1;
                                r6 = r6;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                    r1 = objectOutputStream2;
                                    objectOutputStream2 = objectOutputStream3;
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        r6.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                    try {
                                        r1.close();
                                    } catch (Exception unused4) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2.close();
                                r6.close();
                                outputStream.close();
                                r1.close();
                                throw th;
                            }
                        } else {
                            objectOutputStream2 = new ObjectOutputStream(outputStream);
                            r6 = 0;
                        }
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            r6.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            r1.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            return new String(r1.toByteArray(), "US-ASCII");
                        } catch (UnsupportedEncodingException unused9) {
                            return new String(r1.toByteArray());
                        }
                    } catch (IOException e3) {
                        e = e3;
                        ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                        objectOutputStream2 = r1;
                        objectOutputStream = objectOutputStream4;
                        r6 = objectOutputStream4;
                    } catch (Throwable th3) {
                        th = th3;
                        r6 = objectOutputStream2;
                    }
                } catch (IOException e4) {
                    e = e4;
                    r6 = 0;
                    outputStream = null;
                    objectOutputStream2 = r1;
                    objectOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    r6 = 0;
                    outputStream = null;
                }
            } catch (IOException e5) {
                e = e5;
                r6 = 0;
                objectOutputStream = null;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                r6 = 0;
                r1 = 0;
                outputStream = null;
            }
        } else {
            throw new NullPointerException("Cannot serialize a null object.");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0044 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] encodeBytesToBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIII = interceptable.invokeLIII(65559, null, bArr, i2, i3, i4)) != null) {
            return (byte[]) invokeLIII.objValue;
        }
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        } else if (i3 >= 0) {
            if (i2 + i3 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            }
            if ((i4 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        outputStream = new OutputStream(byteArrayOutputStream, i4 | 1);
                        try {
                            gZIPOutputStream = new GZIPOutputStream(outputStream);
                            try {
                                gZIPOutputStream.write(bArr, i2, i3);
                                gZIPOutputStream.close();
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused3) {
                                }
                                return byteArrayOutputStream.toByteArray();
                            } catch (IOException e2) {
                                e = e2;
                                gZIPOutputStream2 = byteArrayOutputStream;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = gZIPOutputStream2;
                                    gZIPOutputStream2 = gZIPOutputStream;
                                    try {
                                        gZIPOutputStream2.close();
                                    } catch (Exception unused4) {
                                    }
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused5) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused6) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                gZIPOutputStream2 = gZIPOutputStream;
                                gZIPOutputStream2.close();
                                outputStream.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            gZIPOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPOutputStream2.close();
                            outputStream.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        outputStream = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    outputStream = null;
                    gZIPOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = 0;
                    outputStream = null;
                }
            } else {
                boolean z = (i4 & 8) != 0;
                int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                if (z) {
                    i5 += i5 / 76;
                }
                int i6 = i5;
                byte[] bArr2 = new byte[i6];
                int i7 = i3 - 2;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i7) {
                    int i11 = i8;
                    g(bArr, i8 + i2, 3, bArr2, i9, i4);
                    int i12 = i10 + 4;
                    if (!z || i12 < 76) {
                        i10 = i12;
                    } else {
                        bArr2[i9 + 4] = 10;
                        i9++;
                        i10 = 0;
                    }
                    i8 = i11 + 3;
                    i9 += 4;
                }
                int i13 = i8;
                if (i13 < i3) {
                    g(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
                    i9 += 4;
                }
                int i14 = i9;
                if (i14 <= i6 - 1) {
                    byte[] bArr3 = new byte[i14];
                    System.arraycopy(bArr2, 0, bArr3, 0, i14);
                    return bArr3;
                }
                return bArr2;
            }
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
    }

    public static String encodeBytes(byte[] bArr, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, bArr, i2)) == null) ? encodeBytes(bArr, 0, bArr.length, i2) : (String) invokeLI.objValue;
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, byteBuffer, charBuffer) == null) {
            byte[] bArr = new byte[3];
            byte[] bArr2 = new byte[4];
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(3, byteBuffer.remaining());
                byteBuffer.get(bArr, 0, min);
                h(bArr2, bArr, min, 0);
                for (int i2 = 0; i2 < 4; i2++) {
                    charBuffer.put((char) (bArr2[i2] & 255));
                }
            }
        }
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, bArr, i2, i3)) == null) {
            try {
                str = encodeBytes(bArr, i2, i3, 0);
            } catch (IOException e2) {
                if (!f55788g) {
                    throw new AssertionError(e2.getMessage());
                }
                str = null;
            }
            if (f55788g || str != null) {
                return str;
            }
            throw new AssertionError();
        }
        return (String) invokeLII.objValue;
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65557, null, bArr, i2, i3, i4)) == null) {
            byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i2, i3, i4);
            try {
                return new String(encodeBytesToBytes, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(encodeBytesToBytes);
            }
        }
        return (String) invokeLIII.objValue;
    }

    public static byte[] decode(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? decode(str, 0) : (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x005d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x005d -> B:81:0x005d). Please submit an issue!!! */
    public static byte[] decode(String str, int i2) throws IOException {
        GZIPInputStream gZIPInputStream;
        byte[] bytes;
        ?? length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            gZIPInputStream = null;
            InterceptResult invokeLI = interceptable.invokeLI(65543, null, str, i2);
            if (invokeLI != null) {
                return (byte[]) invokeLI.objValue;
            }
        }
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] decode = decode(bytes, 0, bytes.length, i2);
            boolean z = (i2 & 4) != 0;
            if (decode != null && (length = decode.length) >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(decode);
                            try {
                                gZIPInputStream = new GZIPInputStream(length);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e2) {
                                        e = e2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        length = length;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            length.close();
                                            return decode;
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                length.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        length.close();
                                        throw th;
                                    }
                                }
                                decode = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            length = 0;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            length = 0;
                            gZIPInputStream = null;
                        }
                    } catch (Exception unused5) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    length = 0;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    length = 0;
                    gZIPInputStream = null;
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    length.close();
                } catch (Exception unused7) {
                }
            }
            return decode;
        }
        throw new NullPointerException("Input string was null.");
    }
}
