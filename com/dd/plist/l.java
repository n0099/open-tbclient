package com.dd.plist;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/* loaded from: classes7.dex */
public class l {
    private static int OG(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return 10;
        }
        if (trim.startsWith("bplist")) {
            return 1;
        }
        if (trim.startsWith("(") || trim.startsWith("{") || trim.startsWith("/")) {
            return 2;
        }
        if (trim.startsWith("<")) {
            return 0;
        }
        return 11;
    }

    private static int aj(byte[] bArr) {
        int i = 3;
        if (bArr.length < 3 || (bArr[0] & 255) != 239 || (bArr[1] & 255) != 187 || (bArr[2] & 255) != 191) {
            i = 0;
        }
        while (true) {
            if ((i < bArr.length && bArr[i] == 32) || bArr[i] == 9 || bArr[i] == 13 || bArr[i] == 10 || bArr[i] == 12) {
                i++;
            } else {
                return OG(new String(bArr, i, Math.min(8, bArr.length - i)));
            }
        }
    }

    protected static byte[] p(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[512];
        int i = 512;
        while (i == 512) {
            i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static i ad(byte[] bArr) throws IOException, PropertyListFormatException, ParseException, ParserConfigurationException, SAXException {
        switch (aj(bArr)) {
            case 0:
                return n.ad(bArr);
            case 1:
                return c.ad(bArr);
            case 2:
                return a.ad(bArr);
            default:
                throw new PropertyListFormatException("The given data is not a property list of a supported format.");
        }
    }

    public static i q(InputStream inputStream) throws IOException, PropertyListFormatException, ParseException, ParserConfigurationException, SAXException {
        return ad(p(inputStream));
    }
}
