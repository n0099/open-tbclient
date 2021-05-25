package com.ta.utdid2.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes7.dex */
public class a implements XmlSerializer {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f36134a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f2a;

    /* renamed from: a  reason: collision with other field name */
    public Writer f3a;

    /* renamed from: a  reason: collision with other field name */
    public CharsetEncoder f5a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36135b;
    public int mPos;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f6a = new char[8192];

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f4a = ByteBuffer.allocate(8192);

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i3 + i2;
            while (i2 < i4) {
                int i5 = i2 + 8192;
                a(str, i2, i5 < i4 ? 8192 : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.mPos;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.mPos;
        }
        str.getChars(i2, i2 + i3, this.f6a, i6);
        this.mPos = i6 + i3;
    }

    private void append(char c2) throws IOException {
        int i2 = this.mPos;
        if (i2 >= 8191) {
            flush();
            i2 = this.mPos;
        }
        this.f6a[i2] = c2;
        this.mPos = i2 + 1;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        append(' ');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        append("=\"");
        a(str3);
        append(Typography.quote);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f36135b) {
            append(" />\n");
        } else {
            append("</");
            if (str != null) {
                append(str);
                append(':');
            }
            append(str2);
            append(">\n");
        }
        this.f36135b = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i2 = this.mPos;
        if (i2 > 0) {
            if (this.f2a != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f6a, 0, i2);
                CoderResult encode = this.f5a.encode(wrap, this.f4a, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        a();
                        encode = this.f5a.encode(wrap, this.f4a, true);
                    } else {
                        a();
                        this.f2a.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f3a.write(this.f6a, 0, i2);
            this.f3a.flush();
            this.mPos = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f5a = Charset.forName(str).newEncoder();
                this.f2a = outputStream;
                return;
            } catch (IllegalCharsetNameException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            } catch (UnsupportedCharsetException e3) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e3));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        append(sb.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f36135b) {
            append(">\n");
        }
        append(Typography.less);
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        this.f36135b = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f36135b) {
            append(">");
            this.f36135b = false;
        }
        a(cArr, i2, i3);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f36135b) {
            append(">");
            this.f36135b = false;
        }
        a(str);
        return this;
    }

    private void append(char[] cArr, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i3 + i2;
            while (i2 < i4) {
                int i5 = i2 + 8192;
                append(cArr, i2, i5 < i4 ? 8192 : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.mPos;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.mPos;
        }
        System.arraycopy(cArr, i2, this.f6a, i6, i3);
        this.mPos = i6 + i3;
    }

    private void a(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f36134a;
        char length2 = (char) strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i3 < i2) {
                    a(str, i3, i2 - i3);
                }
                i3 = i2 + 1;
                append(str2);
            }
            i2++;
        }
        if (i3 < i2) {
            a(str, i3, i2 - i3);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f3a = writer;
    }

    private void append(String str) throws IOException {
        a(str, 0, str.length());
    }

    private void a(char[] cArr, int i2, int i3) throws IOException {
        String str;
        String[] strArr = f36134a;
        char length = (char) strArr.length;
        int i4 = i3 + i2;
        int i5 = i2;
        while (i2 < i4) {
            char c2 = cArr[i2];
            if (c2 < length && (str = strArr[c2]) != null) {
                if (i5 < i2) {
                    append(cArr, i5, i2 - i5);
                }
                i5 = i2 + 1;
                append(str);
            }
            i2++;
        }
        if (i5 < i2) {
            append(cArr, i5, i2 - i5);
        }
    }

    private void a() throws IOException {
        int position = this.f4a.position();
        if (position > 0) {
            this.f4a.flip();
            this.f2a.write(this.f4a.array(), 0, position);
            this.f4a.clear();
        }
    }
}
