package com.huawei.hms.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public abstract class SHA256 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SHA256() {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0039 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0006 */
    public static byte[] digest(File file) {
        InterceptResult invokeL;
        MessageDigest messageDigest;
        BufferedInputStream bufferedInputStream;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("SHA-256");
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException | NoSuchAlgorithmException unused) {
            }
            try {
                byte[] bArr = new byte[4096];
                i = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                    i += read;
                }
            } catch (IOException | NoSuchAlgorithmException unused2) {
                bufferedInputStream2 = bufferedInputStream;
                HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                bufferedInputStream2 = bufferedInputStream2;
                return new byte[0];
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                throw th;
            }
            if (i > 0) {
                byte[] digest = messageDigest.digest();
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                return digest;
            }
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            bufferedInputStream2 = i;
            return new byte[0];
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] digest(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            try {
                return MessageDigest.getInstance("SHA-256").digest(bArr);
            } catch (NoSuchAlgorithmException e) {
                HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
