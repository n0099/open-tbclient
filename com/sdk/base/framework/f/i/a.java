package com.sdk.base.framework.f.i;

import com.baidu.android.common.security.RSAUtil;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13149a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f13150b = Boolean.valueOf(f.f13118b);

    public static PublicKey a(String str) {
        try {
            com.sdk.base.framework.e.a aVar = new com.sdk.base.framework.e.a();
            byte[] bArr = new byte[str.length()];
            str.getBytes(0, str.length(), bArr, 0);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            aVar.a(byteArrayInputStream, byteArrayOutputStream);
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(byteArrayOutputStream.toByteArray()));
        } catch (Exception e) {
            c.b(f13149a, e.toString(), f13150b);
            return null;
        }
    }
}
