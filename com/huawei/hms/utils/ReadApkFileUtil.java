package com.huawei.hms.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
/* loaded from: classes9.dex */
public class ReadApkFileUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";
    public static final String a = "ReadApkFileUtil";
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    public ReadApkFileUtil() {
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

    public static boolean checkSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (d != null) {
                return c();
            }
            if (c != null) {
                return b();
            }
            if (b != null) {
                return a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String a(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bufferedReader)) == null) {
            if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
                return null;
            }
            StringBuilder sb = new StringBuilder(10);
            while (read != -1) {
                char c2 = (char) read;
                if (c2 == '\n') {
                    break;
                } else if (sb.length() < 4096) {
                    sb.append(c2);
                    read = bufferedReader.read();
                } else {
                    throw new IOException("cert line is too long!");
                }
            }
            String sb2 = sb.toString();
            if (!sb2.isEmpty() && sb2.endsWith("\r")) {
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new byte[0];
            }
            int length = str.length();
            if (length % 2 == 0) {
                i = length / 2;
            } else {
                i = (length / 2) + 1;
            }
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = i2 + 1;
                if (i3 < length) {
                    bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i3), 16));
                } else {
                    bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2), 16) << 4);
                }
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String bytesToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            char[] cArr = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                cArr2[i3] = cArr[i2 >>> 4];
                cArr2[i3 + 1] = cArr[i2 & 15];
            }
            return String.valueOf(cArr2);
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return "";
            }
            return Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        }
        return (String) invokeL.objValue;
    }

    public static String getHmsPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e(a, "HMS is not found!");
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(19)
    public static ArrayList<String> a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                HMSLog.e(a, "manifest is null！");
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                if (!a(bufferedReader, arrayList)) {
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                }
                bufferedReader.close();
                byteArrayInputStream.close();
                return arrayList;
            } catch (IOException unused) {
                HMSLog.e(a, "getManifestLinesArrary IOException!");
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f, "SHA-256"), b(b), "SHA256withRSA")) {
                    HMSLog.i(a, "verifyMDMSignatureV1 verify successful!");
                    return true;
                }
                HMSLog.i(a, "verifyMDMSignatureV1 verify failure!");
                return false;
            } catch (Exception e2) {
                String str = a;
                HMSLog.i(str, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
            } catch (Exception e2) {
                String str = a;
                HMSLog.i(str, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
            }
            if (a(Base64.decode(EMUI10_PK, 0), a(f, "SHA-256"), b(c), "SHA256withRSA")) {
                HMSLog.i(a, "verifyMDMSignatureV2 verify successful!");
                return true;
            }
            HMSLog.i(a, "verifyMDMSignatureV2 verify failure!");
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
            } catch (Exception e2) {
                String str = a;
                HMSLog.i(str, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
            }
            if (a(Base64.decode(EMUI11_PK, 0), a(f, "SHA-384"), b(d), "SHA384withRSA")) {
                HMSLog.i(a, "verifyMDMSignatureV3 verify successful!");
                return true;
            }
            HMSLog.i(a, "verifyMDMSignatureV3 verify failure!");
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bufferedReader, arrayList)) == null) {
            String a2 = a(bufferedReader);
            boolean z = false;
            while (a2 != null) {
                if (a2.equals("Name: META-INF/HUAWEI.CER")) {
                    z = true;
                    String a3 = a(bufferedReader);
                    while (true) {
                        if (a3 == null) {
                            break;
                        } else if (a3.startsWith("Name:")) {
                            a2 = a3;
                            break;
                        } else {
                            a3 = a(bufferedReader);
                        }
                    }
                }
                if (a2.length() != 0) {
                    arrayList.add(a2);
                }
                a2 = a(bufferedReader);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, bArr, bArr2, bArr3, str)) == null) {
            Signature signature = Signature.getInstance(str);
            signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
            signature.update(bArr2);
            return signature.verify(bArr3);
        }
        return invokeLLLL.booleanValue;
    }

    @TargetApi(19)
    public static byte[] a(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
            return messageDigest.digest();
        }
        return (byte[]) invokeLL.objValue;
    }

    @TargetApi(19)
    public static byte[] a(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, arrayList)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
            try {
                try {
                    Collections.sort(arrayList);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        String str = arrayList.get(i);
                        bufferedWriter.write(str, 0, str.length());
                        bufferedWriter.write("\r\n", 0, 2);
                    }
                    bufferedWriter.flush();
                } catch (Exception e2) {
                    String str2 = a;
                    HMSLog.i(str2, "getManifestBytesbySorted Exception!" + e2.getMessage());
                }
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((Writer) bufferedWriter);
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((Writer) bufferedWriter);
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(ZipFile zipFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, zipFile)) == null) {
            return a(zipFile, "META-INF/MANIFEST.MF");
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0062 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.zip.ZipFile, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStream] */
    public static byte[] a(ZipFile zipFile, String str) {
        InterceptResult invokeLL;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        Exception e2;
        Object obj;
        ?? r4;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, zipFile, str)) == null) {
            ?? entry = zipFile.getEntry(str);
            ?? r0 = 0;
            r0 = 0;
            r0 = 0;
            try {
                if (entry == 0) {
                    return null;
                }
                try {
                    zipFile = zipFile.getInputStream(entry);
                    if (zipFile == 0) {
                        IOUtils.closeQuietly((InputStream) zipFile);
                        IOUtils.closeQuietly((InputStream) null);
                        IOUtils.closeQuietly((OutputStream) null);
                        IOUtils.closeQuietly((OutputStream) null);
                        return null;
                    }
                    try {
                        entry = new BufferedInputStream(zipFile);
                        try {
                            bArr = new byte[4096];
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Exception e3) {
                            e2 = e3;
                            byteArrayOutputStream = null;
                            zipFile = zipFile;
                            entry = entry;
                            r4 = byteArrayOutputStream;
                            HMSLog.i(a, "getManifestBytes Exception!" + e2.getMessage());
                            IOUtils.closeQuietly((InputStream) zipFile);
                            IOUtils.closeQuietly((InputStream) entry);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly((OutputStream) r4);
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        obj = zipFile;
                        entry = 0;
                        byteArrayOutputStream = null;
                        zipFile = obj;
                        r4 = byteArrayOutputStream;
                        HMSLog.i(a, "getManifestBytes Exception!" + e2.getMessage());
                        IOUtils.closeQuietly((InputStream) zipFile);
                        IOUtils.closeQuietly((InputStream) entry);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((OutputStream) r4);
                        return null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        th = th2;
                        entry = 0;
                        byteArrayOutputStream = null;
                        IOUtils.closeQuietly((InputStream) zipFile);
                        IOUtils.closeQuietly((InputStream) entry);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((OutputStream) r0);
                        throw th;
                    }
                    try {
                        r4 = new BufferedOutputStream(byteArrayOutputStream);
                        try {
                            for (int read = entry.read(bArr, 0, 4096); read > 0; read = entry.read(bArr, 0, 4096)) {
                                r4.write(bArr, 0, read);
                            }
                            r4.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            IOUtils.closeQuietly((InputStream) zipFile);
                            IOUtils.closeQuietly((InputStream) entry);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly((OutputStream) r4);
                            return byteArray;
                        } catch (Exception e5) {
                            e2 = e5;
                            HMSLog.i(a, "getManifestBytes Exception!" + e2.getMessage());
                            IOUtils.closeQuietly((InputStream) zipFile);
                            IOUtils.closeQuietly((InputStream) entry);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly((OutputStream) r4);
                            return null;
                        }
                    } catch (Exception e6) {
                        e2 = e6;
                        r4 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        IOUtils.closeQuietly((InputStream) zipFile);
                        IOUtils.closeQuietly((InputStream) entry);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((OutputStream) r0);
                        throw th;
                    }
                } catch (Exception e7) {
                    e2 = e7;
                    obj = null;
                } catch (Throwable th6) {
                    th2 = th6;
                    zipFile = 0;
                }
            } catch (Throwable th7) {
                th = th7;
                r0 = interceptable;
            }
        } else {
            return (byte[]) invokeLL.objValue;
        }
    }

    @TargetApi(19)
    public static void b(byte[] bArr) {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, bArr) == null) {
            if (bArr == null) {
                HMSLog.e(a, "manifest is null！");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader2 = null;
            b = null;
            c = null;
            d = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                    try {
                        String a2 = a(bufferedReader);
                        while (a2 != null) {
                            if (a2.length() != 0) {
                                if (a2.startsWith("ApkHash:")) {
                                    e = a(a2.substring(a2.indexOf(":") + 1));
                                }
                                if (a2.startsWith(KEY_SIGNATURE)) {
                                    b = a(a2.substring(a2.indexOf(":") + 1));
                                    a2 = a(bufferedReader);
                                } else if (a2.startsWith(KEY_SIGNATURE2)) {
                                    c = a(a2.substring(a2.indexOf(":") + 1));
                                    a2 = a(bufferedReader);
                                } else if (a2.startsWith(KEY_SIGNATURE3)) {
                                    d = a(a2.substring(a2.indexOf(":") + 1));
                                    a2 = a(bufferedReader);
                                } else {
                                    stringBuffer.append(a2);
                                    stringBuffer.append("\r\n");
                                }
                            }
                            a2 = a(bufferedReader);
                        }
                        f = stringBuffer.toString();
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader;
                        try {
                            HMSLog.e(a, "loadApkCert Exception!");
                            bufferedReader = bufferedReader2;
                            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                            IOUtils.closeQuietly((Reader) bufferedReader2);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception unused3) {
                byteArrayInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
            }
            IOUtils.closeQuietly((InputStream) byteArrayInputStream);
            IOUtils.closeQuietly((Reader) bufferedReader);
        }
    }

    public static boolean verifyApkHash(String str) {
        InterceptResult invokeL;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            ZipFile zipFile2 = null;
            try {
                try {
                    zipFile = new ZipFile(str);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] a2 = a(zipFile);
                ArrayList<String> a3 = a(a2);
                if (a3 != null) {
                    a2 = a(a3);
                }
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(a2);
                String bytesToString = bytesToString(messageDigest.digest());
                if (e != null) {
                    if (e.equals(bytesToString)) {
                        try {
                            zipFile.close();
                        } catch (Exception e3) {
                            String str2 = a;
                            HMSLog.i(str2, "close stream Exception!" + e3.getMessage());
                        }
                        return true;
                    }
                }
                try {
                    zipFile.close();
                    return false;
                } catch (Exception e4) {
                    String str3 = a;
                    HMSLog.i(str3, "close stream Exception!" + e4.getMessage());
                    return false;
                }
            } catch (Exception e5) {
                e = e5;
                zipFile2 = zipFile;
                String str4 = a;
                HMSLog.i(str4, "verifyApkHash Exception!" + e.getMessage());
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                        return false;
                    } catch (Exception e6) {
                        String str5 = a;
                        HMSLog.i(str5, "close stream Exception!" + e6.getMessage());
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (Exception e7) {
                        String str6 = a;
                        HMSLog.i(str6, "close stream Exception!" + e7.getMessage());
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0046 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.StringBuilder] */
    @TargetApi(19)
    public static boolean isCertFound(String str) {
        InterceptResult invokeL;
        ZipFile zipFile;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            ZipFile zipFile2 = 0;
            ZipFile zipFile3 = null;
            try {
                try {
                    zipFile = new ZipFile(str);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                if (zipFile.getEntry("META-INF/HUAWEI.CER") != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    b(a(zipFile, "META-INF/HUAWEI.CER"));
                }
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    String str2 = a;
                    HMSLog.e(str2, "zipFile.close Exception!" + e3.getMessage());
                }
                return z;
            } catch (Exception e4) {
                e = e4;
                zipFile3 = zipFile;
                String str3 = a;
                HMSLog.e(str3, "isCertFound Exception!" + e.getMessage());
                if (zipFile3 == null) {
                    return false;
                }
                try {
                    zipFile3.close();
                    return false;
                } catch (IOException e5) {
                    String str4 = a;
                    zipFile2 = new StringBuilder();
                    zipFile2.append("zipFile.close Exception!");
                    zipFile2.append(e5.getMessage());
                    HMSLog.e(str4, zipFile2.toString());
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                if (zipFile2 != 0) {
                    try {
                        zipFile2.close();
                    } catch (IOException e6) {
                        String str5 = a;
                        HMSLog.e(str5, "zipFile.close Exception!" + e6.getMessage());
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }
}
