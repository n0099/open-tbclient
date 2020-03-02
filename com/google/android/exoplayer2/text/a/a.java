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
    private final int mzc;
    private final int mzd;
    private List<com.google.android.exoplayer2.text.b> mzg;
    private List<com.google.android.exoplayer2.text.b> mzh;
    private int mzi;
    private int mzj;
    private boolean mzk;
    private byte mzl;
    private byte mzm;
    private static final int[] myV = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] myW = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] myX = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, BaseActivity.DIALOG_PROMPT, 9632};
    private static final int[] myY = {174, Opcodes.ARETURN, 189, 191, 8482, 162, Opcodes.IF_ICMPGT, 9834, 224, 32, 232, Constants.METHOD_MEDIA_NOTIFY, 234, 238, 244, 251};
    private static final int[] myZ = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, Opcodes.RET, 8480, 8226, 8220, 8221, 192, DownloadConstants.STATUS_WAITING_TO_RETRY, Opcodes.IFNONNULL, 200, 202, 203, 235, 206, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Opcodes.NEW};
    private static final int[] mza = {DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, BaseActivity.DIALOG_LOADING, 213, 245, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 92, 94, 95, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, Opcodes.IAND, 196, 228, 214, 246, SapiAccountManager.VERSION_CODE, Opcodes.IF_ACMPEQ, 164, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final l mzb = new l();
    private final LinkedList<C0684a> mze = new LinkedList<>();
    private C0684a mzf = new C0684a(0, 4);

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bx(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dxT() throws SubtitleDecoderException {
        return super.duA();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dxU() throws SubtitleDecoderException {
        return super.duz();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gv(long j) {
        super.gv(j);
    }

    public a(String str, int i) {
        this.mzc = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.mzd = 2;
                break;
            default:
                this.mzd = 1;
                break;
        }
        Ll(0);
        dxS();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.mzg = null;
        this.mzh = null;
        Ll(0);
        dxS();
        this.mzj = 4;
        this.mzk = false;
        this.mzl = (byte) 0;
        this.mzm = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dxP() {
        return this.mzg != this.mzh;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dxQ() {
        this.mzh = this.mzg;
        return new f(this.mzg);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.mzb.I(hVar.data.array(), hVar.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.mzb.dzt() >= this.mzc) {
            byte readUnsignedByte = this.mzc == 2 ? (byte) -4 : (byte) this.mzb.readUnsignedByte();
            byte readUnsignedByte2 = (byte) (this.mzb.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.mzb.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && (this.mzd != 1 || (readUnsignedByte & 1) == 0)) {
                if (this.mzd != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.mzf.append(h(readUnsignedByte3));
                            z2 = true;
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.mzf.dxV();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.mzf.append(i(readUnsignedByte3));
                                z2 = true;
                            } else {
                                this.mzf.append(j(readUnsignedByte3));
                                z2 = true;
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z = c(readUnsignedByte2, readUnsignedByte3);
                            z2 = true;
                        } else {
                            this.mzf.append(g(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.mzf.append(g(readUnsignedByte3));
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.mzk = false;
            }
            if (this.mzi == 1 || this.mzi == 3) {
                this.mzg = dxR();
            }
        }
    }

    private boolean c(byte b, byte b2) {
        boolean k = k(b);
        if (k) {
            if (this.mzk && this.mzl == b && this.mzm == b2) {
                this.mzk = false;
                return true;
            }
            this.mzk = true;
            this.mzl = b;
            this.mzm = b2;
        }
        if (e(b, b2)) {
            e(b2);
        } else if (f(b, b2)) {
            d(b, b2);
        } else if (g(b, b2)) {
            this.mzf.Ln(b2 - 32);
        } else if (h(b, b2)) {
            f(b2);
        }
        return k;
    }

    private void e(byte b) {
        this.mzf.vJ((b & 1) == 1);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.mzf.a(new StyleSpan(2), 2);
            this.mzf.a(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.mzf.a(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void d(byte b, byte b2) {
        int i = myV[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.mzf.getRow()) {
            if (this.mzi != 1 && !this.mzf.isEmpty()) {
                this.mzf = new C0684a(this.mzi, this.mzj);
                this.mze.add(this.mzf);
            }
            this.mzf.mz(i);
        }
        if ((b2 & 1) == 1) {
            this.mzf.a(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 <= 7) {
            if (i2 == 7) {
                this.mzf.a(new StyleSpan(2));
                this.mzf.a(new ForegroundColorSpan(-1));
                return;
            }
            this.mzf.a(new ForegroundColorSpan(COLORS[i2]));
            return;
        }
        this.mzf.Lm(myW[i2 & 7]);
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
                if (this.mzi != 0) {
                    switch (b) {
                        case 33:
                            this.mzf.dxV();
                            return;
                        case 44:
                            this.mzg = null;
                            if (this.mzi == 1 || this.mzi == 3) {
                                dxS();
                                return;
                            }
                            return;
                        case 45:
                            if (this.mzi == 1 && !this.mzf.isEmpty()) {
                                this.mzf.dxW();
                                return;
                            }
                            return;
                        case 46:
                            dxS();
                            return;
                        case 47:
                            this.mzg = dxR();
                            dxS();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 37:
                this.mzj = 2;
                Ll(1);
                return;
            case 38:
                this.mzj = 3;
                Ll(1);
                return;
            case 39:
                this.mzj = 4;
                Ll(1);
                return;
            case 41:
                Ll(3);
                return;
        }
    }

    private List<com.google.android.exoplayer2.text.b> dxR() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mze.size()) {
                com.google.android.exoplayer2.text.b dxY = this.mze.get(i2).dxY();
                if (dxY != null) {
                    arrayList.add(dxY);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private void Ll(int i) {
        if (this.mzi != i) {
            int i2 = this.mzi;
            this.mzi = i;
            dxS();
            if (i2 == 3 || i == 1 || i == 0) {
                this.mzg = null;
            }
        }
    }

    private void dxS() {
        this.mzf.dR(this.mzi, this.mzj);
        this.mze.clear();
        this.mze.add(this.mzf);
    }

    private static char g(byte b) {
        return (char) myX[(b & Byte.MAX_VALUE) - 32];
    }

    private static char h(byte b) {
        return (char) myY[b & 15];
    }

    private static char i(byte b) {
        return (char) myZ[b & 31];
    }

    private static char j(byte b) {
        return (char) mza[b & 31];
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
        private int mzi;
        private int mzj;
        private final List<CharacterStyle> mzn = new ArrayList();
        private final List<C0685a> mzo = new ArrayList();
        private final List<SpannableString> mzp = new LinkedList();
        private final SpannableStringBuilder mzq = new SpannableStringBuilder();
        private int mzr;
        private int mzs;
        private int mzt;
        private int row;

        public C0684a(int i, int i2) {
            dR(i, i2);
        }

        public void dR(int i, int i2) {
            this.mzn.clear();
            this.mzo.clear();
            this.mzp.clear();
            this.mzq.clear();
            this.row = 15;
            this.mzr = 0;
            this.mzs = 0;
            this.mzi = i;
            this.mzj = i2;
            this.mzt = -1;
        }

        public boolean isEmpty() {
            return this.mzn.isEmpty() && this.mzo.isEmpty() && this.mzp.isEmpty() && this.mzq.length() == 0;
        }

        public void dxV() {
            int length = this.mzq.length();
            if (length > 0) {
                this.mzq.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public void mz(int i) {
            this.row = i;
        }

        public void dxW() {
            this.mzp.add(dxX());
            this.mzq.clear();
            this.mzn.clear();
            this.mzo.clear();
            this.mzt = -1;
            int min = Math.min(this.mzj, this.row);
            while (this.mzp.size() >= min) {
                this.mzp.remove(0);
            }
        }

        public void Lm(int i) {
            this.mzr = i;
        }

        public void Ln(int i) {
            this.mzs = i;
        }

        public void a(CharacterStyle characterStyle) {
            this.mzn.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.mzo.add(new C0685a(characterStyle, this.mzq.length(), i));
        }

        public void vJ(boolean z) {
            if (z) {
                this.mzt = this.mzq.length();
            } else if (this.mzt != -1) {
                this.mzq.setSpan(new UnderlineSpan(), this.mzt, this.mzq.length(), 33);
                this.mzt = -1;
            }
        }

        public void append(char c) {
            this.mzq.append(c);
        }

        public SpannableString dxX() {
            int i = 0;
            int length = this.mzq.length();
            for (int i2 = 0; i2 < this.mzn.size(); i2++) {
                this.mzq.setSpan(this.mzn.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.mzo.size()) {
                    break;
                }
                C0685a c0685a = this.mzo.get(i3);
                this.mzq.setSpan(c0685a.mzu, c0685a.start, i3 < this.mzo.size() - c0685a.mzv ? this.mzo.get(c0685a.mzv + i3).start : length, 33);
                i = i3 + 1;
            }
            if (this.mzt != -1) {
                this.mzq.setSpan(new UnderlineSpan(), this.mzt, length, 33);
            }
            return new SpannableString(this.mzq);
        }

        public com.google.android.exoplayer2.text.b dxY() {
            int length;
            float f;
            int i;
            int i2;
            int i3 = 2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.mzp.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.mzp.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dxX());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.mzr + this.mzs;
            int length2 = i5 - ((32 - i5) - spannableStringBuilder.length());
            if (this.mzi == 2 && Math.abs(length2) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.mzi == 2 && length2 > 0) {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            } else {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            }
            if (this.mzi == 1 || this.row > 7) {
                i2 = (this.row - 15) - 2;
            } else {
                i3 = 0;
                i2 = this.row;
            }
            return new com.google.android.exoplayer2.text.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.mzq.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.text.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0685a {
            public final CharacterStyle mzu;
            public final int mzv;
            public final int start;

            public C0685a(CharacterStyle characterStyle, int i, int i2) {
                this.mzu = characterStyle;
                this.start = i;
                this.mzv = i2;
            }
        }
    }
}
