package com.dd.plist;

import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.ParseException;
import java.text.StringCharacterIterator;
import java.util.LinkedList;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class a {
    private static CharsetEncoder lFO;
    private byte[] data;
    private int index;

    public static i Y(byte[] bArr) throws ParseException {
        return new a(bArr).die();
    }

    protected a() {
    }

    private a(byte[] bArr) {
        this.data = bArr;
    }

    private boolean b(char... cArr) {
        for (int i = 0; i < cArr.length; i++) {
            if (this.data[this.index + i] != cArr[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean c(char... cArr) {
        boolean z = false;
        for (char c : cArr) {
            if (this.data[this.index] == c) {
                z = true;
            }
        }
        return z;
    }

    private boolean i(char c) {
        return this.data[this.index] == c;
    }

    private void d(char... cArr) throws ParseException {
        if (!c(cArr)) {
            String str = "Expected '" + cArr[0] + "'";
            for (int i = 1; i < cArr.length; i++) {
                str = str + " or '" + cArr[i] + "'";
            }
            throw new ParseException(str + " but found '" + ((char) this.data[this.index]) + "'", this.index);
        }
    }

    private void j(char c) throws ParseException {
        if (!i(c)) {
            throw new ParseException("Expected '" + c + "' but found '" + ((char) this.data[this.index]) + "'", this.index);
        }
    }

    private void k(char c) throws ParseException {
        j(c);
        this.index++;
    }

    private void skip() {
        this.index++;
    }

    private void Hf(int i) {
        this.index += i;
    }

    private void did() {
        boolean z;
        do {
            z = false;
            while (c('\r', '\n', ' ', '\t')) {
                skip();
            }
            if (b('/', '/')) {
                Hf(2);
                e('\r', '\n');
                z = true;
                continue;
            } else if (b('/', '*')) {
                Hf(2);
                while (!b('*', '/')) {
                    skip();
                }
                Hf(2);
                z = true;
                continue;
            } else {
                continue;
            }
        } while (z);
    }

    private String e(char... cArr) {
        String str = "";
        while (!c(cArr)) {
            str = str + ((char) this.data[this.index]);
            skip();
        }
        return str;
    }

    private String l(char c) {
        String str = "";
        while (!i(c)) {
            str = str + ((char) this.data[this.index]);
            skip();
        }
        return str;
    }

    public i die() throws ParseException {
        this.index = 0;
        if (this.data.length >= 3 && (this.data[0] & 255) == 239 && (this.data[1] & 255) == 187 && (this.data[2] & 255) == 191) {
            Hf(3);
        }
        did();
        d('{', '(', '/');
        try {
            return dif();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParseException("Reached end of input unexpectedly.", this.index);
        }
    }

    private i dif() throws ParseException {
        switch (this.data[this.index]) {
            case 34:
                String dil = dil();
                if (dil.length() == 20 && dil.charAt(4) == '-') {
                    try {
                        return new f(dil);
                    } catch (Exception e) {
                        return new k(dil);
                    }
                }
                return new k(dil);
            case 40:
                return dig();
            case 60:
                return dii();
            case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                return dih();
            default:
                if (this.data[this.index] > 47 && this.data[this.index] < 58) {
                    return dij();
                }
                return new k(dik());
        }
    }

    private d dig() throws ParseException {
        skip();
        did();
        LinkedList linkedList = new LinkedList();
        while (!i(')')) {
            linkedList.add(dif());
            did();
            if (!i(',')) {
                break;
            }
            skip();
            did();
        }
        k(')');
        return new d((i[]) linkedList.toArray(new i[linkedList.size()]));
    }

    private g dih() throws ParseException {
        String dik;
        skip();
        did();
        g gVar = new g();
        while (!i('}')) {
            if (i('\"')) {
                dik = dil();
            } else {
                dik = dik();
            }
            did();
            k('=');
            did();
            gVar.put(dik, dif());
            did();
            k(';');
            did();
        }
        skip();
        return gVar;
    }

    private i dii() throws ParseException {
        i iVar = null;
        skip();
        if (i('*')) {
            skip();
            d('B', 'D', 'I', 'R');
            if (i('B')) {
                skip();
                d('Y', 'N');
                if (i('Y')) {
                    iVar = new h(true);
                } else {
                    iVar = new h(false);
                }
                skip();
            } else if (i('D')) {
                skip();
                iVar = new f(l('>'));
            } else if (c('I', 'R')) {
                skip();
                iVar = new h(l('>'));
            }
            k('>');
            return iVar;
        }
        String replaceAll = l('>').replaceAll("\\s+", "");
        byte[] bArr = new byte[replaceAll.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(replaceAll.substring(i * 2, (i * 2) + 2), 16);
        }
        e eVar = new e(bArr);
        skip();
        return eVar;
    }

    private i dij() {
        String dik = dik();
        if (dik.length() > 4 && dik.charAt(4) == '-') {
            try {
                return new f(dik);
            } catch (Exception e) {
            }
        }
        return new k(dik);
    }

    private String dik() {
        return e(' ', '\t', '\n', '\r', ',', ';', '=', ')');
    }

    private String dil() throws ParseException {
        skip();
        String str = "";
        boolean z = true;
        while (true) {
            if (this.data[this.index] != 34 || (this.data[this.index - 1] == 92 && z)) {
                str = str + ((char) this.data[this.index]);
                if (i('\\')) {
                    z = (this.data[this.index + (-1)] == 92 && z) ? false : true;
                }
                skip();
            } else {
                try {
                    String Or = Or(str);
                    skip();
                    return Or;
                } catch (Exception e) {
                    throw new ParseException("The quoted string could not be parsed.", this.index);
                }
            }
        }
    }

    public static synchronized String Or(String str) throws UnsupportedEncodingException, CharacterCodingException {
        String str2;
        synchronized (a.class) {
            LinkedList<Byte> linkedList = new LinkedList();
            StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
            char current = stringCharacterIterator.current();
            while (stringCharacterIterator.getIndex() < stringCharacterIterator.getEndIndex()) {
                switch (current) {
                    case '\\':
                        for (byte b : a(stringCharacterIterator).getBytes("UTF-8")) {
                            linkedList.add(Byte.valueOf(b));
                        }
                        break;
                    default:
                        linkedList.add((byte) 0);
                        linkedList.add(Byte.valueOf((byte) current));
                        break;
                }
                current = stringCharacterIterator.next();
            }
            byte[] bArr = new byte[linkedList.size()];
            int i = 0;
            for (Byte b2 : linkedList) {
                bArr[i] = b2.byteValue();
                i++;
            }
            str2 = new String(bArr, "UTF-8");
            CharBuffer wrap = CharBuffer.wrap(str2);
            if (lFO == null) {
                lFO = Charset.forName(HTTP.ASCII).newEncoder();
            }
            if (lFO.canEncode(wrap)) {
                str2 = lFO.encode(wrap).asCharBuffer().toString();
            }
        }
        return str2;
    }

    private static String a(StringCharacterIterator stringCharacterIterator) throws UnsupportedEncodingException {
        char next = stringCharacterIterator.next();
        if (next == '\\') {
            return new String("\u0000\\".getBytes(), "UTF-8");
        }
        if (next == '\"') {
            return new String("\u0000\"".getBytes(), "UTF-8");
        }
        if (next == 'b') {
            return new String(new byte[]{0, 8}, "UTF-8");
        }
        if (next == 'n') {
            return new String(new byte[]{0, 10}, "UTF-8");
        }
        if (next == 'r') {
            return new String(new byte[]{0, 13}, "UTF-8");
        }
        if (next == 't') {
            return new String(new byte[]{0, 9}, "UTF-8");
        }
        if (next == 'U' || next == 'u') {
            return new String(new byte[]{(byte) Integer.parseInt(("" + stringCharacterIterator.next()) + stringCharacterIterator.next(), 16), (byte) Integer.parseInt(("" + stringCharacterIterator.next()) + stringCharacterIterator.next(), 16)}, "UTF-8");
        }
        return new String(new byte[]{0, (byte) Integer.parseInt((("" + next) + stringCharacterIterator.next()) + stringCharacterIterator.next(), 8)}, "UTF-8");
    }
}
