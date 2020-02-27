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
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.sapi2.SapiAccountManager;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;
/* loaded from: classes6.dex */
public final class a extends d {
    private final int mza;
    private final int mzb;
    private List<com.google.android.exoplayer2.text.b> mze;
    private List<com.google.android.exoplayer2.text.b> mzf;
    private int mzg;
    private int mzh;
    private boolean mzi;
    private byte mzj;
    private byte mzk;
    private static final int[] myT = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] myU = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] myV = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, BaseActivity.DIALOG_PROMPT, 9632};
    private static final int[] myW = {174, Opcodes.ARETURN, 189, 191, 8482, 162, Opcodes.IF_ICMPGT, 9834, 224, 32, 232, Constants.METHOD_MEDIA_NOTIFY, 234, 238, 244, 251};
    private static final int[] myX = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, Opcodes.RET, 8480, 8226, 8220, 8221, 192, DownloadConstants.STATUS_WAITING_TO_RETRY, Opcodes.IFNONNULL, 200, 202, 203, 235, 206, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Opcodes.NEW};
    private static final int[] myY = {DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, BaseActivity.DIALOG_LOADING, 213, 245, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 92, 94, 95, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, Opcodes.IAND, 196, 228, 214, 246, SapiAccountManager.VERSION_CODE, Opcodes.IF_ACMPEQ, 164, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final l myZ = new l();
    private final LinkedList<C0684a> mzc = new LinkedList<>();
    private C0684a mzd = new C0684a(0, 4);

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dxR() throws SubtitleDecoderException {
        return super.duy();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dxS() throws SubtitleDecoderException {
        return super.dux();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gv(long j) {
        super.gv(j);
    }

    public a(String str, int i) {
        this.mza = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.mzb = 2;
                break;
            default:
                this.mzb = 1;
                break;
        }
        Ll(0);
        dxQ();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mze = null;
        this.mzf = null;
        Ll(0);
        dxQ();
        this.mzh = 4;
        this.mzi = false;
        this.mzj = (byte) 0;
        this.mzk = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dxN() {
        return this.mze != this.mzf;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dxO() {
        this.mzf = this.mze;
        return new f(this.mze);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.myZ.I(hVar.data.array(), hVar.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.myZ.dzr() >= this.mza) {
            byte readUnsignedByte = this.mza == 2 ? (byte) -4 : (byte) this.myZ.readUnsignedByte();
            byte readUnsignedByte2 = (byte) (this.myZ.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.myZ.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && (this.mzb != 1 || (readUnsignedByte & 1) == 0)) {
                if (this.mzb != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.mzd.append(h(readUnsignedByte3));
                            z2 = true;
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.mzd.dxT();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.mzd.append(i(readUnsignedByte3));
                                z2 = true;
                            } else {
                                this.mzd.append(j(readUnsignedByte3));
                                z2 = true;
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z = c(readUnsignedByte2, readUnsignedByte3);
                            z2 = true;
                        } else {
                            this.mzd.append(g(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.mzd.append(g(readUnsignedByte3));
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.mzi = false;
            }
            if (this.mzg == 1 || this.mzg == 3) {
                this.mze = dxP();
            }
        }
    }

    private boolean c(byte b, byte b2) {
        boolean k = k(b);
        if (k) {
            if (this.mzi && this.mzj == b && this.mzk == b2) {
                this.mzi = false;
                return true;
            }
            this.mzi = true;
            this.mzj = b;
            this.mzk = b2;
        }
        if (e(b, b2)) {
            e(b2);
        } else if (f(b, b2)) {
            d(b, b2);
        } else if (g(b, b2)) {
            this.mzd.Ln(b2 - 32);
        } else if (h(b, b2)) {
            f(b2);
        }
        return k;
    }

    private void e(byte b) {
        this.mzd.vJ((b & 1) == 1);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.mzd.a(new StyleSpan(2), 2);
            this.mzd.a(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.mzd.a(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void d(byte b, byte b2) {
        int i = myT[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.mzd.getRow()) {
            if (this.mzg != 1 && !this.mzd.isEmpty()) {
                this.mzd = new C0684a(this.mzg, this.mzh);
                this.mzc.add(this.mzd);
            }
            this.mzd.mz(i);
        }
        if ((b2 & 1) == 1) {
            this.mzd.a(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 <= 7) {
            if (i2 == 7) {
                this.mzd.a(new StyleSpan(2));
                this.mzd.a(new ForegroundColorSpan(-1));
                return;
            }
            this.mzd.a(new ForegroundColorSpan(COLORS[i2]));
            return;
        }
        this.mzd.Lm(myU[i2 & 7]);
    }

    private void f(byte b) {
        switch (b) {
            case 32:
                Ll(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                if (this.mzg != 0) {
                    switch (b) {
                        case 33:
                            this.mzd.dxT();
                            return;
                        case 44:
                            this.mze = null;
                            if (this.mzg == 1 || this.mzg == 3) {
                                dxQ();
                                return;
                            }
                            return;
                        case 45:
                            if (this.mzg == 1 && !this.mzd.isEmpty()) {
                                this.mzd.dxU();
                                return;
                            }
                            return;
                        case 46:
                            dxQ();
                            return;
                        case 47:
                            this.mze = dxP();
                            dxQ();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 37:
                this.mzh = 2;
                Ll(1);
                return;
            case 38:
                this.mzh = 3;
                Ll(1);
                return;
            case 39:
                this.mzh = 4;
                Ll(1);
                return;
            case 41:
                Ll(3);
                return;
        }
    }

    private List<com.google.android.exoplayer2.text.b> dxP() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mzc.size()) {
                com.google.android.exoplayer2.text.b dxW = this.mzc.get(i2).dxW();
                if (dxW != null) {
                    arrayList.add(dxW);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private void Ll(int i) {
        if (this.mzg != i) {
            int i2 = this.mzg;
            this.mzg = i;
            dxQ();
            if (i2 == 3 || i == 1 || i == 0) {
                this.mze = null;
            }
        }
    }

    private void dxQ() {
        this.mzd.dR(this.mzg, this.mzh);
        this.mzc.clear();
        this.mzc.add(this.mzd);
    }

    private static char g(byte b) {
        return (char) myV[(b & Byte.MAX_VALUE) - 32];
    }

    private static char h(byte b) {
        return (char) myW[b & 15];
    }

    private static char i(byte b) {
        return (char) myX[b & 31];
    }

    private static char j(byte b) {
        return (char) myY[b & 31];
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
    /* loaded from: classes6.dex */
    public static class C0684a {
        private int mzg;
        private int mzh;
        private final List<CharacterStyle> mzl = new ArrayList();
        private final List<C0685a> mzm = new ArrayList();
        private final List<SpannableString> mzn = new LinkedList();
        private final SpannableStringBuilder mzo = new SpannableStringBuilder();
        private int mzp;
        private int mzq;
        private int mzr;
        private int row;

        public C0684a(int i, int i2) {
            dR(i, i2);
        }

        public void dR(int i, int i2) {
            this.mzl.clear();
            this.mzm.clear();
            this.mzn.clear();
            this.mzo.clear();
            this.row = 15;
            this.mzp = 0;
            this.mzq = 0;
            this.mzg = i;
            this.mzh = i2;
            this.mzr = -1;
        }

        public boolean isEmpty() {
            return this.mzl.isEmpty() && this.mzm.isEmpty() && this.mzn.isEmpty() && this.mzo.length() == 0;
        }

        public void dxT() {
            int length = this.mzo.length();
            if (length > 0) {
                this.mzo.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public void mz(int i) {
            this.row = i;
        }

        public void dxU() {
            this.mzn.add(dxV());
            this.mzo.clear();
            this.mzl.clear();
            this.mzm.clear();
            this.mzr = -1;
            int min = Math.min(this.mzh, this.row);
            while (this.mzn.size() >= min) {
                this.mzn.remove(0);
            }
        }

        public void Lm(int i) {
            this.mzp = i;
        }

        public void Ln(int i) {
            this.mzq = i;
        }

        public void a(CharacterStyle characterStyle) {
            this.mzl.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.mzm.add(new C0685a(characterStyle, this.mzo.length(), i));
        }

        public void vJ(boolean z) {
            if (z) {
                this.mzr = this.mzo.length();
            } else if (this.mzr != -1) {
                this.mzo.setSpan(new UnderlineSpan(), this.mzr, this.mzo.length(), 33);
                this.mzr = -1;
            }
        }

        public void append(char c) {
            this.mzo.append(c);
        }

        public SpannableString dxV() {
            int i = 0;
            int length = this.mzo.length();
            for (int i2 = 0; i2 < this.mzl.size(); i2++) {
                this.mzo.setSpan(this.mzl.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.mzm.size()) {
                    break;
                }
                C0685a c0685a = this.mzm.get(i3);
                this.mzo.setSpan(c0685a.mzs, c0685a.start, i3 < this.mzm.size() - c0685a.mzt ? this.mzm.get(c0685a.mzt + i3).start : length, 33);
                i = i3 + 1;
            }
            if (this.mzr != -1) {
                this.mzo.setSpan(new UnderlineSpan(), this.mzr, length, 33);
            }
            return new SpannableString(this.mzo);
        }

        public com.google.android.exoplayer2.text.b dxW() {
            int length;
            float f;
            int i;
            int i2;
            int i3 = 2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.mzn.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.mzn.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dxV());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.mzp + this.mzq;
            int length2 = i5 - ((32 - i5) - spannableStringBuilder.length());
            if (this.mzg == 2 && Math.abs(length2) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.mzg == 2 && length2 > 0) {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            } else {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            }
            if (this.mzg == 1 || this.row > 7) {
                i2 = (this.row - 15) - 2;
            } else {
                i3 = 0;
                i2 = this.row;
            }
            return new com.google.android.exoplayer2.text.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.mzo.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.text.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0685a {
            public final CharacterStyle mzs;
            public final int mzt;
            public final int start;

            public C0685a(CharacterStyle characterStyle, int i, int i2) {
                this.mzs = characterStyle;
                this.start = i;
                this.mzt = i2;
            }
        }
    }
}
