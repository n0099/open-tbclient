package d.b.h0.p;

import android.text.TextUtils;
import com.google.zxing.client.result.ResultParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class g {
    public static byte[] a(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i = inputStream.read(bArr, 0, 1024);
            } catch (IOException unused) {
                i = 0;
            }
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                d.a(byteArrayOutputStream);
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
                d.a(inputStream);
                return str;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            d.a(inputStream);
            throw th;
        }
        d.a(inputStream);
        return null;
    }
}
