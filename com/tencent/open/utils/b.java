package com.tencent.open.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final m a;

    /* renamed from: b  reason: collision with root package name */
    public static final n f43783b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.open.utils.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036591048, "Lcom/tencent/open/utils/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036591048, "Lcom/tencent/open/utils/b;");
                return;
            }
        }
        a = new m(101010256L);
        f43783b = new n(38651);
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Properties a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f43784b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Properties();
        }

        public void a(byte[] bArr) throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) || bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = b.f43783b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (b.f43783b.equals(new n(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int b2 = new n(bArr3).b();
                if ((bArr.length - length) - 2 < b2) {
                    return;
                }
                byte[] bArr4 = new byte[b2];
                wrap.get(bArr4);
                this.a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - b2) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f43784b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + PreferencesUtil.RIGHT_MOUNT);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "ApkExternalInfo [p=" + this.a + ", otherData=" + Arrays.toString(this.f43784b) + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String a(File file, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, file, str)) != null) {
            return (String) invokeLL.objValue;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] a2 = a(randomAccessFile2);
                if (a2 == null) {
                    randomAccessFile2.close();
                    return null;
                }
                a aVar = new a(null);
                aVar.a(a2);
                String property = aVar.a.getProperty(str);
                randomAccessFile2.close();
                return property;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) ? a(file, "channelNo") : (String) invokeL.objValue;
    }

    public static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, randomAccessFile)) == null) {
            long length = randomAccessFile.length() - 22;
            randomAccessFile.seek(length);
            byte[] a2 = a.a();
            int read = randomAccessFile.read();
            while (true) {
                z = true;
                if (read == -1) {
                    z = false;
                    break;
                } else if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                    break;
                } else {
                    length--;
                    randomAccessFile.seek(length);
                    read = randomAccessFile.read();
                }
            }
            if (z) {
                randomAccessFile.seek(length + 16 + 4);
                byte[] bArr = new byte[2];
                randomAccessFile.readFully(bArr);
                int b2 = new n(bArr).b();
                if (b2 == 0) {
                    return null;
                }
                byte[] bArr2 = new byte[b2];
                randomAccessFile.read(bArr2);
                return bArr2;
            }
            throw new ZipException("archive is not a ZIP archive");
        }
        return (byte[]) invokeL.objValue;
    }
}
