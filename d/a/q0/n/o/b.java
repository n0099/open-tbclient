package d.a.q0.n.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public static String b(File file, boolean z) {
        InterceptResult invokeLZ;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65537, null, file, z)) != null) {
            return (String) invokeLZ.objValue;
        }
        ?? r0 = 0;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String a2 = a(messageDigest.digest(), "", z);
                            d.a.q0.t.d.d(fileInputStream);
                            return a2;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (d.a.q0.n.c.f53910a) {
                        e.printStackTrace();
                    }
                    d.a.q0.t.d.d(fileInputStream);
                    return null;
                } catch (IOException e3) {
                    e = e3;
                    if (d.a.q0.n.c.f53910a) {
                        e.printStackTrace();
                    }
                    d.a.q0.t.d.d(fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    if (d.a.q0.n.c.f53910a) {
                        e.printStackTrace();
                    }
                    d.a.q0.t.d.d(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = interceptable;
                d.a.q0.t.d.d(r0);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream = null;
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.q0.t.d.d(r0);
            throw th;
        }
    }
}
