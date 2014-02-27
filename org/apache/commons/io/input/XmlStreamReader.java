package org.apache.commons.io.input;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocation;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.ByteOrderMark;
/* loaded from: classes.dex */
public class XmlStreamReader extends Reader {
    private static final int BUFFER_SIZE = 4096;
    private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
    private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
    private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
    private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
    private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
    private static final String US_ASCII = "US-ASCII";
    private static final String UTF_16 = "UTF-16";
    private static final String UTF_32 = "UTF-32";
    private final String defaultEncoding;
    private final String encoding;
    private final Reader reader;
    private static final ByteOrderMark[] BOMS = {ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE};
    private static final String UTF_8 = "UTF-8";
    private static final String UTF_16BE = "UTF-16BE";
    private static final String UTF_16LE = "UTF-16LE";
    private static final String UTF_32BE = "UTF-32BE";
    private static final String UTF_32LE = "UTF-32LE";
    private static final String EBCDIC = "CP1047";
    private static final ByteOrderMark[] XML_GUESS_BYTES = {new ByteOrderMark(UTF_8, 60, 63, SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE, 109), new ByteOrderMark(UTF_16BE, 0, 60, 0, 63), new ByteOrderMark(UTF_16LE, 60, 0, 63, 0), new ByteOrderMark(UTF_32BE, 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE, 0, 0, 0, 109), new ByteOrderMark(UTF_32LE, 60, 0, 0, 0, 63, 0, 0, 0, SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE, 0, 0, 0, 109, 0, 0, 0), new ByteOrderMark(EBCDIC, 76, SocialAPIErrorCodes.ERROR_EXPIRED_ACCESS_TOKEN, BDLocation.TypeServerError, 148)};
    private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
    public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);

    public String getDefaultEncoding() {
        return this.defaultEncoding;
    }

    public XmlStreamReader(File file) {
        this(new FileInputStream(file));
    }

    public XmlStreamReader(InputStream inputStream) {
        this(inputStream, true);
    }

    public XmlStreamReader(InputStream inputStream, boolean z) {
        this(inputStream, z, (String) null);
    }

    public XmlStreamReader(InputStream inputStream, boolean z, String str) {
        this.defaultEncoding = str;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        this.encoding = doRawStream(bOMInputStream, bOMInputStream2, z);
        this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
    }

    public XmlStreamReader(URL url) {
        this(url.openConnection(), (String) null);
    }

    public XmlStreamReader(URLConnection uRLConnection, String str) {
        this.defaultEncoding = str;
        String contentType = uRLConnection.getContentType();
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(uRLConnection.getInputStream(), 4096), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        if ((uRLConnection instanceof HttpURLConnection) || contentType != null) {
            this.encoding = doHttpStream(bOMInputStream, bOMInputStream2, contentType, true);
        } else {
            this.encoding = doRawStream(bOMInputStream, bOMInputStream2, true);
        }
        this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
    }

    public XmlStreamReader(InputStream inputStream, String str) {
        this(inputStream, str, true);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z, String str2) {
        this.defaultEncoding = str2;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        this.encoding = doHttpStream(bOMInputStream, bOMInputStream2, str, z);
        this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z) {
        this(inputStream, str, z, null);
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        return this.reader.read(cArr, i, i2);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.reader.close();
    }

    private String doRawStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, boolean z) {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateRawEncoding(bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2));
        } catch (XmlStreamReaderException e) {
            if (z) {
                return doLenientDetection(null, e);
            }
            throw e;
        }
    }

    private String doHttpStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, String str, boolean z) {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateHttpEncoding(str, bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2), z);
        } catch (XmlStreamReaderException e) {
            if (z) {
                return doLenientDetection(str, e);
            }
            throw e;
        }
    }

    private String doLenientDetection(String str, XmlStreamReaderException e) {
        if (str != null && str.startsWith("text/html")) {
            try {
                return calculateHttpEncoding("text/xml" + str.substring(9), e.getBomEncoding(), e.getXmlGuessEncoding(), e.getXmlEncoding(), true);
            } catch (XmlStreamReaderException e2) {
                e = e2;
            }
        }
        String xmlEncoding = e.getXmlEncoding();
        if (xmlEncoding == null) {
            xmlEncoding = e.getContentTypeEncoding();
        }
        if (xmlEncoding == null) {
            return this.defaultEncoding == null ? UTF_8 : this.defaultEncoding;
        }
        return xmlEncoding;
    }

    String calculateRawEncoding(String str, String str2, String str3) {
        if (str == null) {
            return (str2 == null || str3 == null) ? this.defaultEncoding == null ? UTF_8 : this.defaultEncoding : (str3.equals(UTF_16) && (str2.equals(UTF_16BE) || str2.equals(UTF_16LE))) ? str2 : str3;
        } else if (str.equals(UTF_8)) {
            if (str2 != null && !str2.equals(UTF_8)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(UTF_8)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            return str;
        } else if (str.equals(UTF_16BE) || str.equals(UTF_16LE)) {
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(UTF_16) && !str3.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            return str;
        } else if (str.equals(UTF_32BE) || str.equals(UTF_32LE)) {
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(UTF_32) && !str3.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            return str;
        } else {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_2, str, str2, str3), str, str2, str3);
        }
    }

    String calculateHttpEncoding(String str, String str2, String str3, String str4, boolean z) {
        if (!z || str4 == null) {
            String contentTypeMime = getContentTypeMime(str);
            String contentTypeEncoding = getContentTypeEncoding(str);
            boolean isAppXml = isAppXml(contentTypeMime);
            boolean isTextXml = isTextXml(contentTypeMime);
            if (!isAppXml && !isTextXml) {
                throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_3, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
            }
            if (contentTypeEncoding == null) {
                if (isAppXml) {
                    return calculateRawEncoding(str2, str3, str4);
                }
                return this.defaultEncoding == null ? US_ASCII : this.defaultEncoding;
            } else if (contentTypeEncoding.equals(UTF_16BE) || contentTypeEncoding.equals(UTF_16LE)) {
                if (str2 != null) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
                }
                return contentTypeEncoding;
            } else if (contentTypeEncoding.equals(UTF_16)) {
                if (str2 == null || !str2.startsWith(UTF_16)) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
                }
                return str2;
            } else if (contentTypeEncoding.equals(UTF_32BE) || contentTypeEncoding.equals(UTF_32LE)) {
                if (str2 != null) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
                }
                return contentTypeEncoding;
            } else if (contentTypeEncoding.equals(UTF_32)) {
                if (str2 == null || !str2.startsWith(UTF_32)) {
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
                }
                return str2;
            } else {
                return contentTypeEncoding;
            }
        }
        return str4;
    }

    static String getContentTypeMime(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(";");
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    static String getContentTypeEncoding(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(";")) < 0) {
            return null;
        }
        Matcher matcher = CHARSET_PATTERN.matcher(str.substring(indexOf + 1));
        String group = matcher.find() ? matcher.group(1) : null;
        if (group != null) {
            return group.toUpperCase(Locale.US);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r4 != (-1)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        throw new java.io.IOException("Unexpected end of XML stream");
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
        throw new java.io.IOException("XML prolog or ROOT element not found on first " + r7 + " bytes");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getXmlProlog(InputStream inputStream, String str) {
        String upperCase;
        if (str != null) {
            byte[] bArr = new byte[4096];
            inputStream.mark(4096);
            int i = -1;
            int read = inputStream.read(bArr, 0, 4096);
            int i2 = 4096;
            int i3 = 0;
            String str2 = null;
            while (read != -1 && i == -1 && i3 < 4096) {
                i3 += read;
                i2 -= read;
                read = inputStream.read(bArr, i3, i2);
                str2 = new String(bArr, 0, i3, str);
                i = str2.indexOf(62);
            }
            if (i3 > 0) {
                inputStream.reset();
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str2.substring(0, i + 1)));
                StringBuffer stringBuffer = new StringBuffer();
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                }
                Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer);
                if (matcher.find()) {
                    return matcher.group(1).toUpperCase().substring(1, upperCase.length() - 1);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    static boolean isAppXml(String str) {
        return str != null && (str.equals("application/xml") || str.equals("application/xml-dtd") || str.equals("application/xml-external-parsed-entity") || (str.startsWith("application/") && str.endsWith("+xml")));
    }

    static boolean isTextXml(String str) {
        return str != null && (str.equals("text/xml") || str.equals("text/xml-external-parsed-entity") || (str.startsWith("text/") && str.endsWith("+xml")));
    }
}
