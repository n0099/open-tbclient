package org.msgpack.type;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class d extends e implements RawValue {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2940a = "0123456789ABCDEF".toCharArray();

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public boolean isRawValue() {
        return true;
    }

    @Override // org.msgpack.type.e, org.msgpack.type.r
    public RawValue asRawValue() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.isRawValue()) {
                return Arrays.equals(b(), rVar.asRawValue().b());
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(b());
    }

    public String toString() {
        return toString(new StringBuilder()).toString();
    }

    @Override // org.msgpack.type.r
    public StringBuilder toString(StringBuilder sb) {
        String str;
        if (getClass() == p.class) {
            str = c();
        } else {
            try {
                str = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.IGNORE).onUnmappableCharacter(CodingErrorAction.IGNORE).decode(ByteBuffer.wrap(b())).toString();
            } catch (CharacterCodingException e) {
                str = new String(b());
            }
        }
        sb.append("\"");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ') {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                    case '\n':
                        sb.append("\\n");
                        continue;
                    case 11:
                    default:
                        a(sb, charAt);
                        continue;
                    case '\f':
                        sb.append("\\f");
                        continue;
                    case '\r':
                        sb.append("\\r");
                        continue;
                }
            } else if (charAt <= 127) {
                switch (charAt) {
                    case '\"':
                        sb.append("\\\"");
                        continue;
                    case '\\':
                        sb.append("\\\\");
                        continue;
                    default:
                        sb.append(charAt);
                        continue;
                }
            } else if (charAt >= 55296 && charAt <= 57343) {
                a(sb, charAt);
            } else {
                sb.append(charAt);
            }
        }
        sb.append("\"");
        return sb;
    }

    private void a(StringBuilder sb, int i) {
        sb.append("\\u");
        sb.append(f2940a[(i >> 12) & 15]);
        sb.append(f2940a[(i >> 8) & 15]);
        sb.append(f2940a[(i >> 4) & 15]);
        sb.append(f2940a[i & 15]);
    }
}
