package com.tachikoma.core.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.channels.Selector;
import java.util.zip.ZipFile;
/* loaded from: classes8.dex */
public class CloseableUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CloseableUtil() {
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

    public static void close(URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, uRLConnection) == null) && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, inputStream) == null) {
            closeQuietly((Closeable) inputStream);
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, outputStream) == null) {
            closeQuietly((Closeable) outputStream);
        }
    }

    public static void closeQuietly(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, reader) == null) {
            closeQuietly((Closeable) reader);
        }
    }

    public static void closeQuietly(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, writer) == null) {
            closeQuietly((Closeable) writer);
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, serverSocket) == null) || serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(Socket socket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, socket) == null) || socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(Selector selector) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, selector) == null) || selector == null) {
            return;
        }
        try {
            selector.close();
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(ZipFile zipFile) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, zipFile) == null) || zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }

    public static void closeSocket(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, socket) == null) {
            closeSocketInput(socket);
            closeSocketOutput(socket);
            closeQuietly(socket);
        }
    }

    public static void closeSocketInput(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, socket) == null) {
            try {
                if (socket.isInputShutdown()) {
                    return;
                }
                socket.shutdownInput();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void closeSocketOutput(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, socket) == null) {
            try {
                if (socket.isOutputShutdown()) {
                    return;
                }
                socket.shutdownOutput();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
