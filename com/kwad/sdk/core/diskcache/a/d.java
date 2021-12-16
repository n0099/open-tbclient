package com.kwad.sdk.core.diskcache.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(InputStream inputStream) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, inputStream)) != null) {
            return invokeL.objValue;
        }
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            try {
                try {
                    Object readObject = objectInputStream.readObject();
                    a((Closeable) objectInputStream);
                    return readObject;
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.a.a(e);
                    a((Closeable) objectInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream2 = objectInputStream;
                a((Closeable) objectInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) objectInputStream2);
            throw th;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                return String.valueOf(str.hashCode());
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str) == null) {
            if (obj == null) {
                throw new NullPointerException(str);
            }
            if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
                throw new NullPointerException(str);
            }
        }
    }

    public static boolean a(OutputStream outputStream, Object obj) {
        InterceptResult invokeLL;
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, outputStream, obj)) == null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(outputStream);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                a(objectOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                objectOutputStream2 = objectOutputStream;
                com.kwad.sdk.core.d.a.a(e);
                a(objectOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                a(objectOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
