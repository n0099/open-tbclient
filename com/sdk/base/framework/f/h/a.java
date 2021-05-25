package com.sdk.base.framework.f.h;

import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35700a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f35701b = Boolean.valueOf(f.f35662b);

    public static PublicKey a(String str) {
        try {
            com.sdk.base.framework.e.a aVar = new com.sdk.base.framework.e.a();
            byte[] bArr = new byte[str.length()];
            str.getBytes(0, str.length(), bArr, 0);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            aVar.a(byteArrayInputStream, byteArrayOutputStream);
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(byteArrayOutputStream.toByteArray()));
        } catch (Exception e2) {
            c.b(f35700a, e2.toString(), f35701b);
            return null;
        }
    }
}
