package d.a.m0.t;

import android.text.TextUtils;
import com.google.zxing.client.result.ResultParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class h {
    public static byte[] a(InputStream inputStream) {
        int i2;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i2 = inputStream.read(bArr, 0, 1024);
            } catch (IOException unused) {
                i2 = 0;
            }
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                d.d(byteArrayOutputStream);
                return byteArray;
            }
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String c(InputStream inputStream) {
        try {
            byte[] a2 = a(inputStream);
            if (a2 != null) {
                String str = new String(a2);
                if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                    str = str.substring(1);
                }
                d.d(inputStream);
                return str;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            d.d(inputStream);
            throw th;
        }
        d.d(inputStream);
        return null;
    }
}
