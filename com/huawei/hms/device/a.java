package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            String upperCase = str.toUpperCase(Locale.getDefault());
            int indexOf = upperCase.indexOf(str2 + "=");
            if (indexOf == -1) {
                return null;
            }
            int indexOf2 = str.indexOf(",", indexOf);
            if (indexOf2 != -1) {
                return str.substring(indexOf + str2.length() + 1, indexOf2);
            }
            return str.substring(indexOf + str2.length() + 1);
        }
        return (String) invokeLL.objValue;
    }

    public static X509Certificate a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return a(context, "052root");
        }
        return (X509Certificate) invokeL.objValue;
    }

    public static List<X509Certificate> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return b(c(str));
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0065 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    public static X509Certificate a(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        KeyStore keyStore;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            ?? r1 = 0;
            if (context != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            keyStore = KeyStore.getInstance("bks");
                            inputStream = context.getAssets().open("hmsrootcas.bks");
                            try {
                                keyStore.load(inputStream, "".toCharArray());
                            } catch (IOException e) {
                                e = e;
                                HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                                IOUtils.closeQuietly(inputStream);
                                return null;
                            } catch (KeyStoreException e2) {
                                e = e2;
                                HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                                IOUtils.closeQuietly(inputStream);
                                return null;
                            } catch (NoSuchAlgorithmException e3) {
                                e = e3;
                                HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                                IOUtils.closeQuietly(inputStream);
                                return null;
                            } catch (CertificateException e4) {
                                e = e4;
                                HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                                IOUtils.closeQuietly(inputStream);
                                return null;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            inputStream = null;
                            HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (KeyStoreException e6) {
                            e = e6;
                            inputStream = null;
                            HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (NoSuchAlgorithmException e7) {
                            e = e7;
                            inputStream = null;
                            HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (CertificateException e8) {
                            e = e8;
                            inputStream = null;
                            HMSLog.e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            IOUtils.closeQuietly((InputStream) r1);
                            throw th;
                        }
                        if (!keyStore.containsAlias(str)) {
                            HMSLog.e("X509CertUtil", "Not include alias " + str);
                            IOUtils.closeQuietly(inputStream);
                            return null;
                        }
                        Certificate certificate = keyStore.getCertificate(str);
                        if (certificate instanceof X509Certificate) {
                            X509Certificate x509Certificate = (X509Certificate) certificate;
                            x509Certificate.checkValidity();
                            IOUtils.closeQuietly(inputStream);
                            return x509Certificate;
                        }
                        IOUtils.closeQuietly(inputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r1 = context;
                }
            }
            HMSLog.e("X509CertUtil", "args are error");
            return null;
        }
        return (X509Certificate) invokeLL.objValue;
    }

    public static X509Certificate a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return a(Base64.decode(str));
            } catch (IllegalArgumentException e) {
                HMSLog.e("X509CertUtil", "getCert failed : " + e.getMessage());
                return null;
            }
        }
        return (X509Certificate) invokeL.objValue;
    }

    public static List<X509Certificate> b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                arrayList.add(a(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static X509Certificate a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            } catch (CertificateException e) {
                HMSLog.e("X509CertUtil", "Failed to get cert: " + e.getMessage());
                return null;
            }
        }
        return (X509Certificate) invokeL.objValue;
    }

    public static boolean a(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, x509Certificate)) == null) {
            if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
                return false;
            }
            boolean[] keyUsage = x509Certificate.getKeyUsage();
            if (5 >= keyUsage.length) {
                return false;
            }
            return keyUsage[5];
        }
        return invokeL.booleanValue;
    }

    public static boolean a(X509Certificate x509Certificate, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, x509Certificate, str)) == null) {
            return b(x509Certificate, "CN", str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(X509Certificate x509Certificate, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, x509Certificate, str)) == null) {
            return b(x509Certificate, "OU", str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(X509Certificate x509Certificate, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, x509Certificate, str, str2)) == null) {
            try {
                return a(x509Certificate, str.getBytes("UTF-8"), Base64.decode(str2));
            } catch (UnsupportedEncodingException | IllegalArgumentException e) {
                HMSLog.e("X509CertUtil", " plainText exception: " + e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(X509Certificate x509Certificate, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, x509Certificate, str, str2)) == null) {
            if (x509Certificate != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str2.equals(a(x509Certificate.getSubjectDN().getName(), str));
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(X509Certificate x509Certificate, List<X509Certificate> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, x509Certificate, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            if (x509Certificate == null) {
                HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
                return false;
            }
            PublicKey publicKey = x509Certificate.getPublicKey();
            for (X509Certificate x509Certificate2 : list) {
                if (x509Certificate2 != null) {
                    try {
                        x509Certificate2.checkValidity();
                        x509Certificate2.verify(publicKey);
                        publicKey = x509Certificate2.getPublicKey();
                    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                        HMSLog.e("X509CertUtil", "verify failed " + e.getMessage());
                    }
                }
                return false;
            }
            return a(list);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, x509Certificate, bArr, bArr2)) == null) {
            try {
                Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
                signature.initVerify(x509Certificate.getPublicKey());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
                HMSLog.e("X509CertUtil", "failed checkSignature : " + e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(List<X509Certificate> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (!a(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static List<String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 1) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                return arrayList;
            } catch (JSONException e) {
                HMSLog.e("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
                return Collections.emptyList();
            }
        }
        return (List) invokeL.objValue;
    }
}
