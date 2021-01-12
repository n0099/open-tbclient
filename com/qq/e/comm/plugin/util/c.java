package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12581a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12582b = String.format("AES/%s/PKCS7Padding", "ECB");
    private static final String c = GDTADManager.getInstance().getSM().getString("cgiAesKeyVer");

    static {
        f12581a = m.a(c) ? "1" : c;
    }

    private static String a() {
        return (String) gdtadv.getobjresult(212, 1, new Object[0]);
    }

    public static String a(String str) {
        return (String) gdtadv.getobjresult(213, 1, str);
    }

    private static byte[] a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return (byte[]) gdtadv.getobjresult(214, 1, bArr);
    }

    public static String b(String str) {
        return (String) gdtadv.getobjresult(215, 1, str);
    }

    private static byte[] b(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return (byte[]) gdtadv.getobjresult(216, 1, bArr);
    }
}
