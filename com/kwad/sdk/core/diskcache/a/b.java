package com.kwad.sdk.core.diskcache.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes10.dex */
public class b implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f71384a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f71385b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f71386c;

    /* renamed from: d  reason: collision with root package name */
    public int f71387d;

    /* renamed from: e  reason: collision with root package name */
    public int f71388e;

    public b(InputStream inputStream, int i2, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), charset};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f71390a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f71384a = inputStream;
        this.f71385b = charset;
        this.f71386c = new byte[i2];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, charset};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), (Charset) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            InputStream inputStream = this.f71384a;
            byte[] bArr = this.f71386c;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read == -1) {
                throw new EOFException();
            }
            this.f71387d = 0;
            this.f71388e = read;
        }
    }

    public String a() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.f71384a) {
                if (this.f71386c != null) {
                    if (this.f71387d >= this.f71388e) {
                        c();
                    }
                    for (int i4 = this.f71387d; i4 != this.f71388e; i4++) {
                        if (this.f71386c[i4] == 10) {
                            if (i4 != this.f71387d) {
                                i3 = i4 - 1;
                                if (this.f71386c[i3] == 13) {
                                    String str = new String(this.f71386c, this.f71387d, i3 - this.f71387d, this.f71385b.name());
                                    this.f71387d = i4 + 1;
                                    return str;
                                }
                            }
                            i3 = i4;
                            String str2 = new String(this.f71386c, this.f71387d, i3 - this.f71387d, this.f71385b.name());
                            this.f71387d = i4 + 1;
                            return str2;
                        }
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this, (this.f71388e - this.f71387d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f71389a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r8)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f71389a = this;
                        }

                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                                int i5 = ((ByteArrayOutputStream) this).count;
                                try {
                                    return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, this.f71389a.f71385b.name());
                                } catch (UnsupportedEncodingException e2) {
                                    throw new AssertionError(e2);
                                }
                            }
                            return (String) invokeV2.objValue;
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream.write(this.f71386c, this.f71387d, this.f71388e - this.f71387d);
                        this.f71388e = -1;
                        c();
                        i2 = this.f71387d;
                        while (i2 != this.f71388e) {
                            if (this.f71386c[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                    if (i2 != this.f71387d) {
                        byteArrayOutputStream.write(this.f71386c, this.f71387d, i2 - this.f71387d);
                    }
                    this.f71387d = i2 + 1;
                    return byteArrayOutputStream.toString();
                }
                throw new IOException("LineReader is closed");
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71388e == -1 : invokeV.booleanValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f71384a) {
                if (this.f71386c != null) {
                    this.f71386c = null;
                    this.f71384a.close();
                }
            }
        }
    }
}
