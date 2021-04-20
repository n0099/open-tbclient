package org.json.alipay;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f69137a;

    /* renamed from: b  reason: collision with root package name */
    public Reader f69138b;

    /* renamed from: c  reason: collision with root package name */
    public char f69139c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69140d;

    public c(Reader reader) {
        this.f69138b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f69140d = false;
        this.f69137a = 0;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    private String a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.f69140d) {
            this.f69140d = false;
            cArr[0] = this.f69139c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.f69138b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (IOException e2) {
                throw new JSONException(e2);
            }
        }
        this.f69137a += i2;
        if (i2 >= i) {
            this.f69139c = cArr[i - 1];
            return new String(cArr);
        }
        throw a("Substring bounds error");
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i;
        if (this.f69140d || (i = this.f69137a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f69137a = i - 1;
        this.f69140d = true;
    }

    public final char b() {
        if (this.f69140d) {
            this.f69140d = false;
            if (this.f69139c != 0) {
                this.f69137a++;
            }
            return this.f69139c;
        }
        try {
            int read = this.f69138b.read();
            if (read <= 0) {
                this.f69139c = (char) 0;
                return (char) 0;
            }
            this.f69137a++;
            char c2 = (char) read;
            this.f69139c = c2;
            return c2;
        } catch (IOException e2) {
            throw new JSONException(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final char c() {
        char b2;
        char b3;
        while (true) {
            char b4 = b();
            if (b4 == '/') {
                char b5 = b();
                if (b5 == '*') {
                    while (true) {
                        char b6 = b();
                        if (b6 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (b6 == '*') {
                            if (b() != '/') {
                                a();
                            }
                        }
                    }
                } else if (b5 != '/') {
                    a();
                    return '/';
                } else {
                    do {
                        b2 = b();
                        if (b2 != '\n' && b2 != '\r') {
                        }
                    } while (b2 != 0);
                }
            } else if (b4 == '#') {
                do {
                    b3 = b();
                    if (b3 != '\n' && b3 != '\r') {
                    }
                } while (b3 != 0);
            } else if (b4 == 0 || b4 > ' ') {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0146, code lost:
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d() {
        String a2;
        char c2 = c();
        if (c2 != '\"') {
            if (c2 != '[') {
                if (c2 == '{') {
                    a();
                    return new b(this);
                } else if (c2 != '\'') {
                    if (c2 != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c3 = c2;
                        while (c3 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c3) < 0) {
                            stringBuffer.append(c3);
                            c3 = b();
                        }
                        a();
                        String trim = stringBuffer.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        }
                        if (trim.equalsIgnoreCase("true")) {
                            return Boolean.TRUE;
                        }
                        if (trim.equalsIgnoreCase("false")) {
                            return Boolean.FALSE;
                        }
                        if (trim.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                            return b.f69135a;
                        }
                        if ((c2 >= '0' && c2 <= '9') || c2 == '.' || c2 == '-' || c2 == '+') {
                            if (c2 == '0') {
                                try {
                                    return (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) ? new Integer(Integer.parseInt(trim, 8)) : new Integer(Integer.parseInt(trim.substring(2), 16));
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                try {
                                    try {
                                        return new Integer(trim);
                                    } catch (Exception unused2) {
                                        return new Double(trim);
                                    }
                                } catch (Exception unused3) {
                                    return new Long(trim);
                                }
                            } catch (Exception unused4) {
                                return trim;
                            }
                        }
                        return trim;
                    }
                }
            }
            a();
            return new a(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char b2 = b();
            if (b2 == 0 || b2 == '\n' || b2 == '\r') {
                break;
            }
            if (b2 == '\\') {
                b2 = b();
                if (b2 == 'b') {
                    stringBuffer2.append('\b');
                } else if (b2 == 'f') {
                    b2 = '\f';
                } else if (b2 == 'n') {
                    stringBuffer2.append('\n');
                } else if (b2 != 'r') {
                    if (b2 == 'x') {
                        a2 = a(2);
                    } else if (b2 == 't') {
                        b2 = '\t';
                    } else if (b2 == 'u') {
                        a2 = a(4);
                    }
                    b2 = (char) Integer.parseInt(a2, 16);
                } else {
                    stringBuffer2.append('\r');
                }
            } else if (b2 == c2) {
                return stringBuffer2.toString();
            }
            stringBuffer2.append(b2);
        }
    }

    public final String toString() {
        return " at character " + this.f69137a;
    }
}
