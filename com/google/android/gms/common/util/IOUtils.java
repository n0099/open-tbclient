package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
@ShowFirstParty
@KeepForSdk
@Deprecated
/* loaded from: classes7.dex */
public final class IOUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IOUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @KeepForSdk
    public static void closeQuietly(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, parcelFileDescriptor) == null) || parcelFileDescriptor == null) {
            return;
        }
        try {
            parcelFileDescriptor.close();
        } catch (IOException unused) {
        }
    }

    @KeepForSdk
    @Deprecated
    public static long copyStream(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, inputStream, outputStream)) == null) ? copyStream(inputStream, outputStream, false, 1024) : invokeLL.longValue;
    }

    @KeepForSdk
    public static boolean isGzipByteBuffer(@NonNull byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr.length > 1) {
                if ((((bArr[1] & 255) << 8) | (bArr[0] & 255)) == 35615) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static byte[] readInputStreamFully(@NonNull InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, inputStream)) == null) ? readInputStreamFully(inputStream, true) : (byte[]) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static byte[] toByteArray(@NonNull InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteArrayOutputStream);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @KeepForSdk
    public static void closeQuietly(@Nullable Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @KeepForSdk
    @Deprecated
    public static long copyStream(@NonNull InputStream inputStream, @NonNull OutputStream outputStream, boolean z, int i) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{inputStream, outputStream, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            long j = 0;
            while (true) {
                try {
                    int read = inputStream.read(bArr, 0, i);
                    if (read == -1) {
                        break;
                    }
                    j += read;
                    outputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    if (z) {
                        closeQuietly(inputStream);
                        closeQuietly(outputStream);
                    }
                    throw th;
                }
            }
            if (z) {
                closeQuietly(inputStream);
                closeQuietly(outputStream);
            }
            return j;
        }
        return invokeCommon.longValue;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static byte[] readInputStreamFully(@NonNull InputStream inputStream, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, inputStream, z)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            copyStream(inputStream, byteArrayOutputStream, z, 1024);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLZ.objValue;
    }
}
