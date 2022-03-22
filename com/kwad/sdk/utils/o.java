package com.kwad.sdk.utils;

import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes7.dex */
public class o {
    @RequiresApi(api = 19)
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        return bArr2;
    }
}
