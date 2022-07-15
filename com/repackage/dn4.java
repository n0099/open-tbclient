package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class dn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dn4() {
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

    public String a(String str, String str2) throws CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
            JSONArray jSONArray = new JSONArray();
            byte[] bytes = str2.getBytes("UTF-8");
            if (bytes.length % 116 == 0) {
                length = bytes.length / 116;
            } else {
                length = (bytes.length / 116) + 1;
            }
            for (int i = 0; i < length; i++) {
                if (1 == length) {
                    jSONArray.put(gi.j(b(publicKey, bytes)));
                } else if (i != length - 1) {
                    byte[] bArr = new byte[116];
                    System.arraycopy(bytes, i * 116, bArr, 0, 116);
                    jSONArray.put(gi.j(b(publicKey, bArr)));
                } else {
                    int i2 = i * 116;
                    int length2 = bytes.length - i2;
                    byte[] bArr2 = new byte[length2];
                    System.arraycopy(bytes, i2, bArr2, 0, length2);
                    jSONArray.put(gi.j(b(publicKey, bArr2)));
                }
            }
            return gi.j(jSONArray.toString().getBytes("UTF-8"));
        }
        return (String) invokeLL.objValue;
    }

    public final byte[] b(Key key, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key, bArr)) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, key);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
