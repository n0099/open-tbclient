package com.google.android.exoplayer2.text.a;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.location.BDLocation;
import com.baidu.sapi2.SapiAccountManager;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes4.dex */
public final class a extends d {
    private final int muC;
    private final int muD;
    private List<com.google.android.exoplayer2.text.b> muG;
    private List<com.google.android.exoplayer2.text.b> muH;
    private int muI;
    private int muJ;
    private boolean muK;
    private byte muL;
    private byte muM;
    private static final int[] muv = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] muw = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] mux = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, BaseActivity.DIALOG_PROMPT, 9632};
    private static final int[] muy = {174, 176, 189, 191, 8482, BDLocation.TypeServerDecryptError, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] muz = {193, 201, 211, 218, 220, 252, 8216, BDLocation.TypeNetWorkLocation, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, DownloadConstants.STATUS_RUNNING, DownloadConstants.STATUS_WAITING_TO_RETRY, 199, 200, 202, 203, 235, 206, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 187};
    private static final int[] muA = {DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, BaseActivity.DIALOG_LOADING, 213, 245, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 92, 94, 95, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 126, 196, 228, 214, 246, SapiAccountManager.VERSION_CODE, 165, 164, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final l muB = new l();
    private final LinkedList<C0670a> muE = new LinkedList<>();
    private C0670a muF = new C0670a(0, 4);

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bu(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dvu() throws SubtitleDecoderException {
        return super.drZ();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dvv() throws SubtitleDecoderException {
        return super.drY();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gs(long j) {
        super.gs(j);
    }

    public a(String str, int i) {
        this.muC = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.muD = 2;
                break;
            default:
                this.muD = 1;
                break;
        }
        KX(0);
        dvt();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.muG = null;
        this.muH = null;
        KX(0);
        dvt();
        this.muJ = 4;
        this.muK = false;
        this.muL = (byte) 0;
        this.muM = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dvq() {
        return this.muG != this.muH;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dvr() {
        this.muH = this.muG;
        return new f(this.muG);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.muB.G(hVar.data.array(), hVar.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.muB.dwV() >= this.muC) {
            byte readUnsignedByte = this.muC == 2 ? (byte) -4 : (byte) this.muB.readUnsignedByte();
            byte readUnsignedByte2 = (byte) (this.muB.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.muB.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && (this.muD != 1 || (readUnsignedByte & 1) == 0)) {
                if (this.muD != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.muF.append(h(readUnsignedByte3));
                            z2 = true;
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.muF.dvw();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.muF.append(i(readUnsignedByte3));
                                z2 = true;
                            } else {
                                this.muF.append(j(readUnsignedByte3));
                                z2 = true;
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z = c(readUnsignedByte2, readUnsignedByte3);
                            z2 = true;
                        } else {
                            this.muF.append(g(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.muF.append(g(readUnsignedByte3));
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.muK = false;
            }
            if (this.muI == 1 || this.muI == 3) {
                this.muG = dvs();
            }
        }
    }

    private boolean c(byte b, byte b2) {
        boolean k = k(b);
        if (k) {
            if (this.muK && this.muL == b && this.muM == b2) {
                this.muK = false;
                return true;
            }
            this.muK = true;
            this.muL = b;
            this.muM = b2;
        }
        if (e(b, b2)) {
            e(b2);
        } else if (f(b, b2)) {
            d(b, b2);
        } else if (g(b, b2)) {
            this.muF.KZ(b2 - 32);
        } else if (h(b, b2)) {
            f(b2);
        }
        return k;
    }

    private void e(byte b) {
        this.muF.vt((b & 1) == 1);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.muF.a(new StyleSpan(2), 2);
            this.muF.a(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.muF.a(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void d(byte b, byte b2) {
        int i = muv[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.muF.getRow()) {
            if (this.muI != 1 && !this.muF.isEmpty()) {
                this.muF = new C0670a(this.muI, this.muJ);
                this.muE.add(this.muF);
            }
            this.muF.mh(i);
        }
        if ((b2 & 1) == 1) {
            this.muF.a(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 <= 7) {
            if (i2 == 7) {
                this.muF.a(new StyleSpan(2));
                this.muF.a(new ForegroundColorSpan(-1));
                return;
            }
            this.muF.a(new ForegroundColorSpan(COLORS[i2]));
            return;
        }
        this.muF.KY(muw[i2 & 7]);
    }

    private void f(byte b) {
        switch (b) {
            case 32:
                KX(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                if (this.muI != 0) {
                    switch (b) {
                        case 33:
                            this.muF.dvw();
                            return;
                        case 44:
                            this.muG = null;
                            if (this.muI == 1 || this.muI == 3) {
                                dvt();
                                return;
                            }
                            return;
                        case 45:
                            if (this.muI == 1 && !this.muF.isEmpty()) {
                                this.muF.dvx();
                                return;
                            }
                            return;
                        case 46:
                            dvt();
                            return;
                        case 47:
                            this.muG = dvs();
                            dvt();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 37:
                this.muJ = 2;
                KX(1);
                return;
            case 38:
                this.muJ = 3;
                KX(1);
                return;
            case 39:
                this.muJ = 4;
                KX(1);
                return;
            case 41:
                KX(3);
                return;
        }
    }

    private List<com.google.android.exoplayer2.text.b> dvs() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.muE.size()) {
                com.google.android.exoplayer2.text.b dvz = this.muE.get(i2).dvz();
                if (dvz != null) {
                    arrayList.add(dvz);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private void KX(int i) {
        if (this.muI != i) {
            int i2 = this.muI;
            this.muI = i;
            dvt();
            if (i2 == 3 || i == 1 || i == 0) {
                this.muG = null;
            }
        }
    }

    private void dvt() {
        this.muF.dQ(this.muI, this.muJ);
        this.muE.clear();
        this.muE.add(this.muF);
    }

    private static char g(byte b) {
        return (char) mux[(b & Byte.MAX_VALUE) - 32];
    }

    private static char h(byte b) {
        return (char) muy[b & 15];
    }

    private static char i(byte b) {
        return (char) muz[b & 31];
    }

    private static char j(byte b) {
        return (char) muA[b & 31];
    }

    private static boolean e(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    private static boolean f(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    private static boolean g(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    private static boolean h(byte b, byte b2) {
        return (b & 247) == 20 && (b2 & 240) == 32;
    }

    private static boolean k(byte b) {
        return (b & 240) == 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0670a {
        private int muI;
        private int muJ;
        private final List<CharacterStyle> muN = new ArrayList();
        private final List<C0671a> muO = new ArrayList();
        private final List<SpannableString> muP = new LinkedList();
        private final SpannableStringBuilder muQ = new SpannableStringBuilder();
        private int muR;
        private int muS;
        private int muT;
        private int row;

        public C0670a(int i, int i2) {
            dQ(i, i2);
        }

        public void dQ(int i, int i2) {
            this.muN.clear();
            this.muO.clear();
            this.muP.clear();
            this.muQ.clear();
            this.row = 15;
            this.muR = 0;
            this.muS = 0;
            this.muI = i;
            this.muJ = i2;
            this.muT = -1;
        }

        public boolean isEmpty() {
            return this.muN.isEmpty() && this.muO.isEmpty() && this.muP.isEmpty() && this.muQ.length() == 0;
        }

        public void dvw() {
            int length = this.muQ.length();
            if (length > 0) {
                this.muQ.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public void mh(int i) {
            this.row = i;
        }

        public void dvx() {
            this.muP.add(dvy());
            this.muQ.clear();
            this.muN.clear();
            this.muO.clear();
            this.muT = -1;
            int min = Math.min(this.muJ, this.row);
            while (this.muP.size() >= min) {
                this.muP.remove(0);
            }
        }

        public void KY(int i) {
            this.muR = i;
        }

        public void KZ(int i) {
            this.muS = i;
        }

        public void a(CharacterStyle characterStyle) {
            this.muN.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.muO.add(new C0671a(characterStyle, this.muQ.length(), i));
        }

        public void vt(boolean z) {
            if (z) {
                this.muT = this.muQ.length();
            } else if (this.muT != -1) {
                this.muQ.setSpan(new UnderlineSpan(), this.muT, this.muQ.length(), 33);
                this.muT = -1;
            }
        }

        public void append(char c) {
            this.muQ.append(c);
        }

        public SpannableString dvy() {
            int i = 0;
            int length = this.muQ.length();
            for (int i2 = 0; i2 < this.muN.size(); i2++) {
                this.muQ.setSpan(this.muN.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.muO.size()) {
                    break;
                }
                C0671a c0671a = this.muO.get(i3);
                this.muQ.setSpan(c0671a.muU, c0671a.start, i3 < this.muO.size() - c0671a.muV ? this.muO.get(c0671a.muV + i3).start : length, 33);
                i = i3 + 1;
            }
            if (this.muT != -1) {
                this.muQ.setSpan(new UnderlineSpan(), this.muT, length, 33);
            }
            return new SpannableString(this.muQ);
        }

        public com.google.android.exoplayer2.text.b dvz() {
            int length;
            float f;
            int i;
            int i2;
            int i3 = 2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.muP.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.muP.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dvy());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.muR + this.muS;
            int length2 = i5 - ((32 - i5) - spannableStringBuilder.length());
            if (this.muI == 2 && Math.abs(length2) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.muI == 2 && length2 > 0) {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            } else {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            }
            if (this.muI == 1 || this.row > 7) {
                i2 = (this.row - 15) - 2;
            } else {
                i3 = 0;
                i2 = this.row;
            }
            return new com.google.android.exoplayer2.text.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.muQ.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.text.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0671a {
            public final CharacterStyle muU;
            public final int muV;
            public final int start;

            public C0671a(CharacterStyle characterStyle, int i, int i2) {
                this.muU = characterStyle;
                this.start = i;
                this.muV = i2;
            }
        }
    }
}
