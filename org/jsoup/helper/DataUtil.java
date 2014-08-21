package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
/* loaded from: classes.dex */
public class DataUtil {
    private static final int bufferSize = 131072;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
    static final String defaultCharset = "UTF-8";

    private DataUtil() {
    }

    public static Document load(File file, String str, String str2) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Document parseByteData = parseByteData(readToByteBuffer(fileInputStream), str, str2, Parser.htmlParser());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return parseByteData;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static Document load(InputStream inputStream, String str, String str2) {
        return parseByteData(readToByteBuffer(inputStream), str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) {
        return parseByteData(readToByteBuffer(inputStream), str, str2, parser);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Document parseByteData(ByteBuffer byteBuffer, String str, String str2, Parser parser) {
        String charBuffer;
        Document document;
        String str3;
        String attr;
        Document document2 = null;
        if (str == null) {
            String charBuffer2 = Charset.forName(defaultCharset).decode(byteBuffer).toString();
            Document parseInput = parser.parseInput(charBuffer2, str2);
            Element first = parseInput.select("meta[http-equiv=content-type], meta[charset]").first();
            if (first != null) {
                if (first.hasAttr("http-equiv")) {
                    attr = getCharsetFromContentType(first.attr("content"));
                    if (attr == null && first.hasAttr("charset")) {
                        try {
                            if (Charset.isSupported(first.attr("charset"))) {
                                attr = first.attr("charset");
                            }
                        } catch (IllegalCharsetNameException e) {
                            attr = null;
                        }
                    }
                } else {
                    attr = first.attr("charset");
                }
                if (attr != null && attr.length() != 0 && !attr.equals(defaultCharset)) {
                    str = attr.trim().replaceAll("[\"']", "");
                    byteBuffer.rewind();
                    str3 = Charset.forName(str).decode(byteBuffer).toString();
                    document = null;
                    Document document3 = document;
                    charBuffer = str3;
                    document2 = document3;
                }
            }
            document = parseInput;
            str3 = charBuffer2;
            Document document32 = document;
            charBuffer = str3;
            document2 = document32;
        } else {
            Validate.notEmpty(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            charBuffer = Charset.forName(str).decode(byteBuffer).toString();
        }
        if (document2 == null) {
            if (charBuffer.length() > 0 && charBuffer.charAt(0) == 65279) {
                charBuffer = charBuffer.substring(1);
            }
            Document parseInput2 = parser.parseInput(charBuffer, str2);
            parseInput2.outputSettings().charset(str);
            return parseInput2;
        }
        return document2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z = i > 0;
        byte[] bArr = new byte[131072];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(131072);
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read > i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    static ByteBuffer readToByteBuffer(InputStream inputStream) {
        return readToByteBuffer(inputStream, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            String replace = matcher.group(1).trim().replace("charset=", "");
            if (replace.isEmpty()) {
                return null;
            }
            try {
                if (Charset.isSupported(replace)) {
                    return replace;
                }
                String upperCase = replace.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
                return null;
            } catch (IllegalCharsetNameException e) {
                return null;
            }
        }
        return null;
    }
}
