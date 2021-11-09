package com.dxmpay.apollon.restnet;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes11.dex */
public class RestMultipartEntity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final char[] f62140g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ByteArrayOutputStream f62141a;

    /* renamed from: b  reason: collision with root package name */
    public String f62142b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62143c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62144d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f62145e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressListener f62146f;

    /* loaded from: classes11.dex */
    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1209077532, "Lcom/dxmpay/apollon/restnet/RestMultipartEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1209077532, "Lcom/dxmpay/apollon/restnet/RestMultipartEntity;");
                return;
            }
        }
        f62140g = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public RestMultipartEntity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62141a = new ByteArrayOutputStream();
        this.f62143c = false;
        this.f62144d = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i4 = 0; i4 < 30; i4++) {
            char[] cArr = f62140g;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f62142b = sb.toString();
        this.f62145e = ("\r\n--" + this.f62142b + Part.CRLF).getBytes();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62142b : (String) invokeV.objValue;
    }

    public void addPart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            c(str, str2, false);
        }
    }

    public void b(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, outputStream) == null) {
            f();
            a aVar = new a(d(), outputStream, this.f62146f);
            aVar.write(this.f62141a.toByteArray());
            aVar.close();
        }
    }

    public void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, str2, z) == null) {
            try {
                e();
                ByteArrayOutputStream byteArrayOutputStream = this.f62141a;
                byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
                this.f62141a.write(str2.getBytes());
                if (z) {
                    f();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (byteArrayOutputStream = this.f62141a) == null) {
            return;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            f();
            return this.f62141a.toByteArray().length;
        }
        return invokeV.longValue;
    }

    public final void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.f62143c) {
                this.f62143c = true;
                ByteArrayOutputStream byteArrayOutputStream = this.f62141a;
                byteArrayOutputStream.write(("--" + this.f62142b + Part.CRLF).getBytes());
                return;
            }
            this.f62141a.write(this.f62145e);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f62144d) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.f62141a;
            byteArrayOutputStream.write(("\r\n--" + this.f62142b + "--\r\n").getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f62144d = true;
    }

    public void setProgressListener(ProgressListener progressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, progressListener) == null) {
            this.f62146f = progressListener;
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, inputStream, str3, Boolean.valueOf(z)}) == null) {
            try {
                try {
                    try {
                        e();
                        ByteArrayOutputStream byteArrayOutputStream = this.f62141a;
                        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                        if (str3 != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = this.f62141a;
                            byteArrayOutputStream2.write((Part.CONTENT_TYPE + str3 + "\r\n\r\n").getBytes());
                        } else {
                            this.f62141a.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                        }
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            this.f62141a.write(bArr, 0, read);
                        }
                        if (z) {
                            f();
                        }
                        this.f62141a.flush();
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                inputStream.close();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ProgressListener f62147e;

        /* renamed from: f  reason: collision with root package name */
        public final long f62148f;

        /* renamed from: g  reason: collision with root package name */
        public long f62149g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), outputStream, progressListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62148f = j;
            this.f62149g = 0L;
            this.f62147e = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                long j = this.f62149g + i3;
                this.f62149g = j;
                ProgressListener progressListener = this.f62147e;
                if (progressListener != null) {
                    progressListener.transferred(j, this.f62148f);
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                ((FilterOutputStream) this).out.write(i2);
                long j = this.f62149g + 1;
                this.f62149g = j;
                ProgressListener progressListener = this.f62147e;
                if (progressListener != null) {
                    progressListener.transferred(j, this.f62148f);
                }
            }
        }
    }
}
