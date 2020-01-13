package com.google.android.exoplayer2.metadata.id3;

import android.util.Log;
import com.baidu.android.util.media.MimeType;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes5.dex */
public final class a implements com.google.android.exoplayer2.metadata.a {
    public static final int mlE = v.Qr("ID3");
    private final InterfaceC0670a mpH;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0670a {
        boolean h(int i, int i2, int i3, int i4, int i5);
    }

    public a() {
        this(null);
    }

    public a(InterfaceC0670a interfaceC0670a) {
        this.mpH = interfaceC0670a;
    }

    @Override // com.google.android.exoplayer2.metadata.a
    public Metadata a(c cVar) {
        ByteBuffer byteBuffer = cVar.data;
        return x(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata x(byte[] bArr, int i) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        l lVar = new l(bArr, i);
        b P = P(lVar);
        if (P == null) {
            return null;
        }
        int position = lVar.getPosition();
        int i2 = P.lFK == 2 ? 6 : 10;
        int i3 = P.mpJ;
        if (P.mpI) {
            i3 = q(lVar, P.mpJ);
        }
        lVar.setLimit(i3 + position);
        if (a(lVar, P.lFK, i2, false)) {
            z = false;
        } else if (P.lFK != 4 || !a(lVar, 4, i2, true)) {
            Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + P.lFK);
            return null;
        } else {
            z = true;
        }
        while (lVar.dyf() >= i2) {
            Id3Frame a = a(P.lFK, lVar, z, i2, this.mpH);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return new Metadata(arrayList);
    }

    private static b P(l lVar) {
        int i;
        if (lVar.dyf() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int dyj = lVar.dyj();
        if (dyj != mlE) {
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + dyj);
            return null;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        lVar.skipBytes(1);
        int readUnsignedByte2 = lVar.readUnsignedByte();
        int dyp = lVar.dyp();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
            i = dyp;
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = lVar.readInt();
                lVar.skipBytes(readInt);
                dyp -= readInt + 4;
            }
            i = dyp;
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                int dyp2 = lVar.dyp();
                lVar.skipBytes(dyp2 - 4);
                dyp -= dyp2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                dyp -= 10;
            }
            i = dyp;
        } else {
            Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        return new b(readUnsignedByte, readUnsignedByte < 4 && (readUnsignedByte2 & 128) != 0, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [259=6] */
    private static boolean a(l lVar, int i, int i2, boolean z) {
        int i3;
        int dyj;
        long dyj2;
        long j;
        boolean z2;
        boolean z3;
        int position = lVar.getPosition();
        while (lVar.dyf() >= i2) {
            try {
                if (i >= 3) {
                    int readInt = lVar.readInt();
                    long readUnsignedInt = lVar.readUnsignedInt();
                    i3 = lVar.readUnsignedShort();
                    dyj = readInt;
                    dyj2 = readUnsignedInt;
                } else {
                    i3 = 0;
                    dyj = lVar.dyj();
                    dyj2 = lVar.dyj();
                }
                if (dyj == 0 && dyj2 == 0 && i3 == 0) {
                    return true;
                }
                if (i != 4 || z) {
                    j = dyj2;
                } else if ((8421504 & dyj2) != 0) {
                    return false;
                } else {
                    j = (((dyj2 >> 24) & 255) << 21) | (255 & dyj2) | (((dyj2 >> 8) & 255) << 7) | (((dyj2 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    boolean z4 = (i3 & 64) != 0;
                    boolean z5 = (i3 & 1) != 0;
                    z2 = z4;
                    z3 = z5;
                } else if (i == 3) {
                    boolean z6 = (i3 & 32) != 0;
                    boolean z7 = (i3 & 128) != 0;
                    z2 = z6;
                    z3 = z7;
                } else {
                    z2 = false;
                    z3 = false;
                }
                int i4 = z2 ? 1 : 0;
                if (z3) {
                    i4 += 4;
                }
                if (j < i4) {
                    return false;
                } else if (lVar.dyf() < j) {
                    return false;
                } else {
                    lVar.skipBytes((int) j);
                }
            } finally {
                lVar.setPosition(position);
            }
        }
        return true;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, CONST]}, finally: {[INVOKE] complete} */
    private static Id3Frame a(int i, l lVar, boolean z, int i2, InterfaceC0670a interfaceC0670a) {
        int dyj;
        Id3Frame c;
        int readUnsignedByte = lVar.readUnsignedByte();
        int readUnsignedByte2 = lVar.readUnsignedByte();
        int readUnsignedByte3 = lVar.readUnsignedByte();
        int readUnsignedByte4 = i >= 3 ? lVar.readUnsignedByte() : 0;
        if (i == 4) {
            dyj = lVar.dyq();
            if (!z) {
                dyj = (dyj & 255) | (((dyj >> 8) & 255) << 7) | (((dyj >> 16) & 255) << 14) | (((dyj >> 24) & 255) << 21);
            }
        } else if (i == 3) {
            dyj = lVar.dyq();
        } else {
            dyj = lVar.dyj();
        }
        int readUnsignedShort = i >= 3 ? lVar.readUnsignedShort() : 0;
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && dyj == 0 && readUnsignedShort == 0) {
            lVar.setPosition(lVar.dyg());
            return null;
        }
        int position = lVar.getPosition() + dyj;
        if (position > lVar.dyg()) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            lVar.setPosition(lVar.dyg());
            return null;
        } else if (interfaceC0670a != null && !interfaceC0670a.h(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
            lVar.setPosition(position);
            return null;
        } else {
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            if (i == 3) {
                z5 = (readUnsignedShort & 128) != 0;
                z3 = (readUnsignedShort & 64) != 0;
                z6 = (readUnsignedShort & 32) != 0;
                z2 = z5;
            } else if (i == 4) {
                boolean z7 = (readUnsignedShort & 64) != 0;
                z2 = (readUnsignedShort & 8) != 0;
                z3 = (readUnsignedShort & 4) != 0;
                z4 = (readUnsignedShort & 2) != 0;
                boolean z8 = z7;
                z5 = (readUnsignedShort & 1) != 0;
                z6 = z8;
            }
            if (z2 || z3) {
                Log.w("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
                lVar.setPosition(position);
                return null;
            }
            if (z6) {
                dyj--;
                lVar.skipBytes(1);
            }
            if (z5) {
                dyj -= 4;
                lVar.skipBytes(4);
            }
            if (z4) {
                dyj = q(lVar, dyj);
            }
            try {
                if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    c = l(lVar, dyj);
                } else if (readUnsignedByte == 84) {
                    c = a(lVar, dyj, i(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    c = m(lVar, dyj);
                } else if (readUnsignedByte == 87) {
                    c = b(lVar, dyj, i(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    c = n(lVar, dyj);
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i == 2)) {
                    c = o(lVar, dyj);
                } else if (i != 2 ? !(readUnsignedByte != 65 || readUnsignedByte2 != 80 || readUnsignedByte3 != 73 || readUnsignedByte4 != 67) : !(readUnsignedByte != 80 || readUnsignedByte2 != 73 || readUnsignedByte3 != 67)) {
                    c = e(lVar, dyj, i);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i == 2)) {
                    c = p(lVar, dyj);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                    c = a(lVar, dyj, i, z, i2, interfaceC0670a);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                    c = b(lVar, dyj, i, z, i2, interfaceC0670a);
                } else {
                    c = c(lVar, dyj, i(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                }
                if (c == null) {
                    Log.w("Id3Decoder", "Failed to decode frame: id=" + i(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4) + ", frameSize=" + dyj);
                }
                return c;
            } catch (UnsupportedEncodingException e) {
                Log.w("Id3Decoder", "Unsupported character encoding");
                return null;
            } finally {
                lVar.setPosition(position);
            }
        }
    }

    private static TextInformationFrame l(l lVar, int i) throws UnsupportedEncodingException {
        String str;
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        String Kj = Kj(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        lVar.C(bArr, 0, i - 1);
        int u = u(bArr, 0, readUnsignedByte);
        String str2 = new String(bArr, 0, u, Kj);
        int Kk = u + Kk(readUnsignedByte);
        if (Kk < bArr.length) {
            str = new String(bArr, Kk, u(bArr, Kk, readUnsignedByte) - Kk, Kj);
        } else {
            str = "";
        }
        return new TextInformationFrame("TXXX", str2, str);
    }

    private static TextInformationFrame a(l lVar, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        String Kj = Kj(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        lVar.C(bArr, 0, i - 1);
        return new TextInformationFrame(str, null, new String(bArr, 0, u(bArr, 0, readUnsignedByte), Kj));
    }

    private static UrlLinkFrame m(l lVar, int i) throws UnsupportedEncodingException {
        String str;
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        String Kj = Kj(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        lVar.C(bArr, 0, i - 1);
        int u = u(bArr, 0, readUnsignedByte);
        String str2 = new String(bArr, 0, u, Kj);
        int Kk = u + Kk(readUnsignedByte);
        if (Kk < bArr.length) {
            str = new String(bArr, Kk, y(bArr, Kk) - Kk, "ISO-8859-1");
        } else {
            str = "";
        }
        return new UrlLinkFrame("WXXX", str2, str);
    }

    private static UrlLinkFrame b(l lVar, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        lVar.C(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, y(bArr, 0), "ISO-8859-1"));
    }

    private static PrivFrame n(l lVar, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        lVar.C(bArr, 0, i);
        int y = y(bArr, 0);
        return new PrivFrame(new String(bArr, 0, y, "ISO-8859-1"), v(bArr, y + 1, bArr.length));
    }

    private static GeobFrame o(l lVar, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = lVar.readUnsignedByte();
        String Kj = Kj(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        lVar.C(bArr, 0, i - 1);
        int y = y(bArr, 0);
        String str = new String(bArr, 0, y, "ISO-8859-1");
        int i2 = y + 1;
        int u = u(bArr, i2, readUnsignedByte);
        String str2 = new String(bArr, i2, u - i2, Kj);
        int Kk = Kk(readUnsignedByte) + u;
        int u2 = u(bArr, Kk, readUnsignedByte);
        return new GeobFrame(str, str2, new String(bArr, Kk, u2 - Kk, Kj), v(bArr, Kk(readUnsignedByte) + u2, bArr.length));
    }

    private static ApicFrame e(l lVar, int i, int i2) throws UnsupportedEncodingException {
        String Qo;
        int i3 = 2;
        int readUnsignedByte = lVar.readUnsignedByte();
        String Kj = Kj(readUnsignedByte);
        byte[] bArr = new byte[i - 1];
        lVar.C(bArr, 0, i - 1);
        if (i2 == 2) {
            Qo = "image/" + v.Qo(new String(bArr, 0, 3, "ISO-8859-1"));
            if (Qo.equals("image/jpg")) {
                Qo = MimeType.Image.JPEG;
            }
        } else {
            i3 = y(bArr, 0);
            Qo = v.Qo(new String(bArr, 0, i3, "ISO-8859-1"));
            if (Qo.indexOf(47) == -1) {
                Qo = "image/" + Qo;
            }
        }
        int i4 = i3 + 2;
        int u = u(bArr, i4, readUnsignedByte);
        return new ApicFrame(Qo, new String(bArr, i4, u - i4, Kj), bArr[i3 + 1] & 255, v(bArr, Kk(readUnsignedByte) + u, bArr.length));
    }

    private static CommentFrame p(l lVar, int i) throws UnsupportedEncodingException {
        String str;
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        String Kj = Kj(readUnsignedByte);
        byte[] bArr = new byte[3];
        lVar.C(bArr, 0, 3);
        String str2 = new String(bArr, 0, 3);
        byte[] bArr2 = new byte[i - 4];
        lVar.C(bArr2, 0, i - 4);
        int u = u(bArr2, 0, readUnsignedByte);
        String str3 = new String(bArr2, 0, u, Kj);
        int Kk = u + Kk(readUnsignedByte);
        if (Kk < bArr2.length) {
            str = new String(bArr2, Kk, u(bArr2, Kk, readUnsignedByte) - Kk, Kj);
        } else {
            str = "";
        }
        return new CommentFrame(str2, str3, str);
    }

    private static ChapterFrame a(l lVar, int i, int i2, boolean z, int i3, InterfaceC0670a interfaceC0670a) throws UnsupportedEncodingException {
        int position = lVar.getPosition();
        int y = y(lVar.data, position);
        String str = new String(lVar.data, position, y - position, "ISO-8859-1");
        lVar.setPosition(y + 1);
        int readInt = lVar.readInt();
        int readInt2 = lVar.readInt();
        long readUnsignedInt = lVar.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            readUnsignedInt = -1;
        }
        long readUnsignedInt2 = lVar.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            readUnsignedInt2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (lVar.getPosition() < i4) {
            Id3Frame a = a(i2, lVar, z, i3, interfaceC0670a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, readUnsignedInt, readUnsignedInt2, id3FrameArr);
    }

    private static ChapterTocFrame b(l lVar, int i, int i2, boolean z, int i3, InterfaceC0670a interfaceC0670a) throws UnsupportedEncodingException {
        int position = lVar.getPosition();
        int y = y(lVar.data, position);
        String str = new String(lVar.data, position, y - position, "ISO-8859-1");
        lVar.setPosition(y + 1);
        int readUnsignedByte = lVar.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = lVar.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = lVar.getPosition();
            int y2 = y(lVar.data, position2);
            strArr[i4] = new String(lVar.data, position2, y2 - position2, "ISO-8859-1");
            lVar.setPosition(y2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (lVar.getPosition() < i5) {
            Id3Frame a = a(i2, lVar, z, i3, interfaceC0670a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static BinaryFrame c(l lVar, int i, String str) {
        byte[] bArr = new byte[i];
        lVar.C(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static int q(l lVar, int i) {
        byte[] bArr = lVar.data;
        int i2 = i;
        for (int position = lVar.getPosition(); position + 1 < i2; position++) {
            if ((bArr[position] & 255) == 255 && bArr[position + 1] == 0) {
                System.arraycopy(bArr, position + 2, bArr, position + 1, (i2 - position) - 2);
                i2--;
            }
        }
        return i2;
    }

    private static String Kj(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return CharEncoding.UTF_16BE;
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    private static String i(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int u(byte[] bArr, int i, int i2) {
        int y = y(bArr, i);
        if (i2 != 0 && i2 != 3) {
            while (y < bArr.length - 1) {
                if (y % 2 != 0 || bArr[y + 1] != 0) {
                    y = y(bArr, y + 1);
                } else {
                    return y;
                }
            }
            return bArr.length;
        }
        return y;
    }

    private static int y(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] != 0) {
                i++;
            } else {
                return i;
            }
        }
        return bArr.length;
    }

    private static int Kk(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] v(byte[] bArr, int i, int i2) {
        return i2 <= i ? new byte[0] : Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {
        private final int lFK;
        private final boolean mpI;
        private final int mpJ;

        public b(int i, boolean z, int i2) {
            this.lFK = i;
            this.mpI = z;
            this.mpJ = i2;
        }
    }
}
