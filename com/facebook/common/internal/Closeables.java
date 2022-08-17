package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
@Nullsafe(Nullsafe.Mode.STRICT)
/* loaded from: classes4.dex */
public final class Closeables {
    public static /* synthetic */ Interceptable $ic;
    @VisibleForTesting
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2091056765, "Lcom/facebook/common/internal/Closeables;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2091056765, "Lcom/facebook/common/internal/Closeables;");
                return;
            }
        }
        logger = Logger.getLogger(Closeables.class.getName());
    }

    public Closeables() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void close(@Nullable Closeable closeable, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, closeable, z) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (z) {
                logger.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
                return;
            }
            throw e;
        }
    }

    public static void closeQuietly(@Nullable InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, inputStream) == null) {
            try {
                close(inputStream, true);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static void closeQuietly(@Nullable Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, reader) == null) {
            try {
                close(reader, true);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }
}
