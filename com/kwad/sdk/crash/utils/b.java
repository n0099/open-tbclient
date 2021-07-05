package com.kwad.sdk.crash.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void a(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, inputStream) == null) {
            a((Closeable) inputStream);
        }
    }

    public static void a(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, outputStream) == null) {
            a((Closeable) outputStream);
        }
    }

    public static void a(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, reader) == null) {
            a((Closeable) reader);
        }
    }

    public static void a(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, writer) == null) {
            a((Closeable) writer);
        }
    }
}
