package d.a.r.a.e;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes2.dex */
public final class b {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    gZIPOutputStream.close();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return bArr2;
                }
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return bArr2;
            }
        }
        return null;
    }
}
