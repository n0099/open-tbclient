package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class c {
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

    @Nullable
    @WorkerThread
    public static byte[] a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            return null;
        } finally {
            a(fileInputStream);
        }
    }

    @Nullable
    @WorkerThread
    public static String b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            try {
                byte[] a2 = a(file);
                if (a2 != null && a2.length != 0) {
                    return w.a(a2, 0, a2.length);
                }
            } catch (IOException | NoSuchAlgorithmException unused) {
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
