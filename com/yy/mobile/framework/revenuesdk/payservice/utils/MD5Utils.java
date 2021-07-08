package com.yy.mobile.framework.revenuesdk.payservice.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class MD5Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MD5Utils";
    public transient /* synthetic */ FieldHolder $fh;

    public MD5Utils() {
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

    public static String bufferToHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return bufferToHex(bArr, 0, bArr.length);
        }
        return (String) invokeL.objValue;
    }

    public static String fileMd5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return getFileMd5String(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x005b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x000b */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
        if (r5 != 0) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.security.DigestInputStream] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.security.DigestInputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.security.DigestInputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileMD5String(File file) throws IOException {
        Interceptable interceptable;
        InterceptResult invokeL;
        Interceptable interceptable2 = $ic;
        if (interceptable2 == null || (invokeL = (interceptable = interceptable2).invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            String str = null;
            if (file != 0) {
                try {
                    if (file.exists()) {
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            interceptable = new FileInputStream((File) file);
                            try {
                                file = new DigestInputStream(interceptable, messageDigest);
                                try {
                                    while (file.read(new byte[4096]) > 0) {
                                    }
                                    str = bufferToHex(file.getMessageDigest().digest());
                                    interceptable.close();
                                } catch (NoSuchAlgorithmException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    if (interceptable != 0) {
                                        interceptable.close();
                                    }
                                }
                            } catch (NoSuchAlgorithmException e3) {
                                e = e3;
                                file = 0;
                            } catch (Throwable th) {
                                th = th;
                                file = 0;
                                if (interceptable != 0) {
                                    interceptable.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                throw th;
                            }
                        } catch (NoSuchAlgorithmException e4) {
                            e = e4;
                            file = 0;
                            interceptable = 0;
                        } catch (Throwable th2) {
                            interceptable = 0;
                            th = th2;
                            file = 0;
                        }
                        file.close();
                        return str;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getFileMd5String(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return getFileMD5String(new File(str));
        }
        return (String) invokeL.objValue;
    }

    public static String getMD5String(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return getMD5String(str.getBytes());
        }
        return (String) invokeL.objValue;
    }

    public static String bufferToHex(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i2, i3)) == null) {
            if (bArr == null || i2 < 0 || i3 < 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder(i3 * 2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                String hexString = Integer.toHexString(bArr[i2] & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static String getMD5String(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return bufferToHex(messageDigest.digest());
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String fileMd5(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file == null) {
                return "";
            }
            try {
                return getFileMD5String(file);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
