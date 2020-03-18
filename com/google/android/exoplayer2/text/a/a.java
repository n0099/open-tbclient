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
    private final int mAU;
    private final int mAV;
    private List<com.google.android.exoplayer2.text.b> mAY;
    private List<com.google.android.exoplayer2.text.b> mAZ;
    private int mBa;
    private int mBb;
    private boolean mBc;
    private byte mBd;
    private byte mBe;
    private static final int[] mAN = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] mAO = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] mAP = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, BaseActivity.DIALOG_PROMPT, 9632};
    private static final int[] mAQ = {174, Opcodes.ARETURN, 189, 191, 8482, 162, Opcodes.IF_ICMPGT, 9834, 224, 32, 232, Constants.METHOD_MEDIA_NOTIFY, 234, 238, 244, 251};
    private static final int[] mAR = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, Opcodes.RET, 8480, 8226, 8220, 8221, 192, DownloadConstants.STATUS_WAITING_TO_RETRY, Opcodes.IFNONNULL, 200, 202, 203, 235, 206, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Opcodes.NEW};
    private static final int[] mAS = {DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, BaseActivity.DIALOG_LOADING, 213, 245, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 92, 94, 95, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, Opcodes.IAND, 196, 228, 214, 246, SapiAccountManager.VERSION_CODE, Opcodes.IF_ACMPEQ, 164, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final l mAT = new l();
    private final LinkedList<C0685a> mAW = new LinkedList<>();
    private C0685a mAX = new C0685a(0, 4);

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dyr() throws SubtitleDecoderException {
        return super.duY();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dys() throws SubtitleDecoderException {
        return super.duX();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gw(long j) {
        super.gw(j);
    }

    public a(String str, int i) {
        this.mAU = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.mAV = 2;
                break;
            default:
                this.mAV = 1;
                break;
        }
        Lr(0);
        dyq();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mAY = null;
        this.mAZ = null;
        Lr(0);
        dyq();
        this.mBb = 4;
        this.mBc = false;
        this.mBd = (byte) 0;
        this.mBe = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dyn() {
        return this.mAY != this.mAZ;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dyo() {
        this.mAZ = this.mAY;
        return new f(this.mAY);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.mAT.I(hVar.data.array(), hVar.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.mAT.dzR() >= this.mAU) {
            byte readUnsignedByte = this.mAU == 2 ? (byte) -4 : (byte) this.mAT.readUnsignedByte();
            byte readUnsignedByte2 = (byte) (this.mAT.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.mAT.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && (this.mAV != 1 || (readUnsignedByte & 1) == 0)) {
                if (this.mAV != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.mAX.append(h(readUnsignedByte3));
                            z2 = true;
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.mAX.dyt();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.mAX.append(i(readUnsignedByte3));
                                z2 = true;
                            } else {
                                this.mAX.append(j(readUnsignedByte3));
                                z2 = true;
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z = c(readUnsignedByte2, readUnsignedByte3);
                            z2 = true;
                        } else {
                            this.mAX.append(g(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.mAX.append(g(readUnsignedByte3));
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.mBc = false;
            }
            if (this.mBa == 1 || this.mBa == 3) {
                this.mAY = dyp();
            }
        }
    }

    private boolean c(byte b, byte b2) {
        boolean k = k(b);
        if (k) {
            if (this.mBc && this.mBd == b && this.mBe == b2) {
                this.mBc = false;
                return true;
            }
            this.mBc = true;
            this.mBd = b;
            this.mBe = b2;
        }
        if (e(b, b2)) {
            e(b2);
        } else if (f(b, b2)) {
            d(b, b2);
        } else if (g(b, b2)) {
            this.mAX.Lt(b2 - 32);
        } else if (h(b, b2)) {
            f(b2);
        }
        return k;
    }

    private void e(byte b) {
        this.mAX.vQ((b & 1) == 1);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.mAX.a(new StyleSpan(2), 2);
            this.mAX.a(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.mAX.a(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void d(byte b, byte b2) {
        int i = mAN[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.mAX.getRow()) {
            if (this.mBa != 1 && !this.mAX.isEmpty()) {
                this.mAX = new C0685a(this.mBa, this.mBb);
                this.mAW.add(this.mAX);
            }
            this.mAX.mB(i);
        }
        if ((b2 & 1) == 1) {
            this.mAX.a(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 <= 7) {
            if (i2 == 7) {
                this.mAX.a(new StyleSpan(2));
                this.mAX.a(new ForegroundColorSpan(-1));
                return;
            }
            this.mAX.a(new ForegroundColorSpan(COLORS[i2]));
            return;
        }
        this.mAX.Ls(mAO[i2 & 7]);
    }

    private void f(byte b) {
        switch (b) {
            case 32:
                Lr(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                if (this.mBa != 0) {
                    switch (b) {
                        case 33:
                            this.mAX.dyt();
                            return;
                        case 44:
                            this.mAY = null;
                            if (this.mBa == 1 || this.mBa == 3) {
                                dyq();
                                return;
                            }
                            return;
                        case 45:
                            if (this.mBa == 1 && !this.mAX.isEmpty()) {
                                this.mAX.dyu();
                                return;
                            }
                            return;
                        case 46:
                            dyq();
                            return;
                        case 47:
                            this.mAY = dyp();
                            dyq();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 37:
                this.mBb = 2;
                Lr(1);
                return;
            case 38:
                this.mBb = 3;
                Lr(1);
                return;
            case 39:
                this.mBb = 4;
                Lr(1);
                return;
            case 41:
                Lr(3);
                return;
        }
    }

    private List<com.google.android.exoplayer2.text.b> dyp() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAW.size()) {
                com.google.android.exoplayer2.text.b dyw = this.mAW.get(i2).dyw();
                if (dyw != null) {
                    arrayList.add(dyw);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private void Lr(int i) {
        if (this.mBa != i) {
            int i2 = this.mBa;
            this.mBa = i;
            dyq();
            if (i2 == 3 || i == 1 || i == 0) {
                this.mAY = null;
            }
        }
    }

    private void dyq() {
        this.mAX.dS(this.mBa, this.mBb);
        this.mAW.clear();
        this.mAW.add(this.mAX);
    }

    private static char g(byte b) {
        return (char) mAP[(b & Byte.MAX_VALUE) - 32];
    }

    private static char h(byte b) {
        return (char) mAQ[b & 15];
    }

    private static char i(byte b) {
        return (char) mAR[b & 31];
    }

    private static char j(byte b) {
        return (char) mAS[b & 31];
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
    public static class C0685a {
        private int mBa;
        private int mBb;
        private final List<CharacterStyle> mBf = new ArrayList();
        private final List<C0686a> mBh = new ArrayList();
        private final List<SpannableString> mBi = new LinkedList();
        private final SpannableStringBuilder mBj = new SpannableStringBuilder();
        private int mBk;
        private int mBl;
        private int mBm;
        private int row;

        public C0685a(int i, int i2) {
            dS(i, i2);
        }

        public void dS(int i, int i2) {
            this.mBf.clear();
            this.mBh.clear();
            this.mBi.clear();
            this.mBj.clear();
            this.row = 15;
            this.mBk = 0;
            this.mBl = 0;
            this.mBa = i;
            this.mBb = i2;
            this.mBm = -1;
        }

        public boolean isEmpty() {
            return this.mBf.isEmpty() && this.mBh.isEmpty() && this.mBi.isEmpty() && this.mBj.length() == 0;
        }

        public void dyt() {
            int length = this.mBj.length();
            if (length > 0) {
                this.mBj.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public void mB(int i) {
            this.row = i;
        }

        public void dyu() {
            this.mBi.add(dyv());
            this.mBj.clear();
            this.mBf.clear();
            this.mBh.clear();
            this.mBm = -1;
            int min = Math.min(this.mBb, this.row);
            while (this.mBi.size() >= min) {
                this.mBi.remove(0);
            }
        }

        public void Ls(int i) {
            this.mBk = i;
        }

        public void Lt(int i) {
            this.mBl = i;
        }

        public void a(CharacterStyle characterStyle) {
            this.mBf.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.mBh.add(new C0686a(characterStyle, this.mBj.length(), i));
        }

        public void vQ(boolean z) {
            if (z) {
                this.mBm = this.mBj.length();
            } else if (this.mBm != -1) {
                this.mBj.setSpan(new UnderlineSpan(), this.mBm, this.mBj.length(), 33);
                this.mBm = -1;
            }
        }

        public void append(char c) {
            this.mBj.append(c);
        }

        public SpannableString dyv() {
            int i = 0;
            int length = this.mBj.length();
            for (int i2 = 0; i2 < this.mBf.size(); i2++) {
                this.mBj.setSpan(this.mBf.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.mBh.size()) {
                    break;
                }
                C0686a c0686a = this.mBh.get(i3);
                this.mBj.setSpan(c0686a.mBn, c0686a.start, i3 < this.mBh.size() - c0686a.mBo ? this.mBh.get(c0686a.mBo + i3).start : length, 33);
                i = i3 + 1;
            }
            if (this.mBm != -1) {
                this.mBj.setSpan(new UnderlineSpan(), this.mBm, length, 33);
            }
            return new SpannableString(this.mBj);
        }

        public com.google.android.exoplayer2.text.b dyw() {
            int length;
            float f;
            int i;
            int i2;
            int i3 = 2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.mBi.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.mBi.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dyv());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.mBk + this.mBl;
            int length2 = i5 - ((32 - i5) - spannableStringBuilder.length());
            if (this.mBa == 2 && Math.abs(length2) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.mBa == 2 && length2 > 0) {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            } else {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            }
            if (this.mBa == 1 || this.row > 7) {
                i2 = (this.row - 15) - 2;
            } else {
                i3 = 0;
                i2 = this.row;
            }
            return new com.google.android.exoplayer2.text.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.mBj.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.text.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0686a {
            public final CharacterStyle mBn;
            public final int mBo;
            public final int start;

            public C0686a(CharacterStyle characterStyle, int i, int i2) {
                this.mBn = characterStyle;
                this.start = i;
                this.mBo = i2;
            }
        }
    }
}
