package com.kwad.sdk.core.imageloader.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.d.a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public final class IoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final int DEFAULT_IMAGE_TOTAL_SIZE = 512000;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface CopyListener {
        boolean onBytesCopied(int i2, int i3);
    }

    public IoUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void closeSilently(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, inputStream, outputStream, copyListener)) == null) ? copyStream(inputStream, outputStream, copyListener, 32768) : invokeLLL.booleanValue;
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, inputStream, outputStream, copyListener, i2)) == null) {
            int available = inputStream.available();
            if (available <= 0) {
                available = 512000;
            }
            byte[] bArr = new byte[i2];
            if (shouldStopLoading(copyListener, 0, available)) {
                return false;
            }
            int i3 = 0;
            do {
                int read = inputStream.read(bArr, 0, i2);
                if (read == -1) {
                    outputStream.flush();
                    return true;
                }
                outputStream.write(bArr, 0, read);
                i3 += read;
            } while (!shouldStopLoading(copyListener, i3, available));
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String inputStreamToString(InputStream inputStream) {
        InterceptResult invokeL;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        Closeable closeable = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                while (true) {
                    try {
                        int read = inputStreamReader.read(cArr, 0, 1024);
                        if (read < 0) {
                            closeSilently(inputStreamReader);
                            return sb.toString();
                        }
                        sb.append(cArr, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        a.a(e);
                        if (inputStreamReader != null) {
                            closeSilently(inputStreamReader);
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable = 65540;
                if (closeable != null) {
                    closeSilently(closeable);
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (closeable != null) {
            }
            throw th;
        }
    }

    public static void readAndCloseStream(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, inputStream) == null) {
            do {
                try {
                } catch (IOException unused) {
                } catch (Throwable th) {
                    closeSilently(inputStream);
                    throw th;
                }
            } while (inputStream.read(new byte[32768], 0, 32768) != -1);
            closeSilently(inputStream);
        }
    }

    public static boolean shouldStopLoading(CopyListener copyListener, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, copyListener, i2, i3)) == null) ? (copyListener == null || copyListener.onBytesCopied(i2, i3) || (i2 * 100) / i3 >= 75) ? false : true : invokeLII.booleanValue;
    }
}
