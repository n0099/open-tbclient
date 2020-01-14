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
/* loaded from: classes5.dex */
public final class a extends d {
    private int myA;
    private int myB;
    private boolean myC;
    private byte myD;
    private byte myE;
    private final int myu;
    private final int myv;
    private List<com.google.android.exoplayer2.text.b> myy;
    private List<com.google.android.exoplayer2.text.b> myz;
    private static final int[] myn = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] myo = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] myp = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, BaseActivity.DIALOG_PROMPT, 9632};
    private static final int[] myq = {174, 176, 189, 191, 8482, BDLocation.TypeServerDecryptError, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] myr = {193, 201, 211, 218, 220, 252, 8216, BDLocation.TypeNetWorkLocation, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, DownloadConstants.STATUS_RUNNING, DownloadConstants.STATUS_WAITING_TO_RETRY, 199, 200, 202, 203, 235, 206, HttpStatus.SC_MULTI_STATUS, 239, 212, 217, 249, 219, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 187};
    private static final int[] mys = {DownloadConstants.STATUS_WAITING_FOR_NETWORK, 227, 205, 204, 236, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, BaseActivity.DIALOG_LOADING, 213, 245, Constants.METHOD_IM_FRIEND_GROUP_QUERY, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 92, 94, 95, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 126, 196, 228, 214, 246, SapiAccountManager.VERSION_CODE, 165, 164, 9474, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final l myt = new l();
    private final LinkedList<C0676a> myw = new LinkedList<>();
    private C0676a myx = new C0676a(0, 4);

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ void c(h hVar) throws SubtitleDecoderException {
        super.bv(hVar);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ i dwH() throws SubtitleDecoderException {
        return super.dtn();
    }

    @Override // com.google.android.exoplayer2.text.a.d
    public /* bridge */ /* synthetic */ h dwI() throws SubtitleDecoderException {
        return super.dtm();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.text.f
    public /* bridge */ /* synthetic */ void gx(long j) {
        super.gx(j);
    }

    public a(String str, int i) {
        this.myu = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.myv = 2;
                break;
            default:
                this.myv = 1;
                break;
        }
        Lg(0);
        dwG();
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void flush() {
        super.flush();
        this.myy = null;
        this.myz = null;
        Lg(0);
        dwG();
        this.myB = 4;
        this.myC = false;
        this.myD = (byte) 0;
        this.myE = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.a.d, com.google.android.exoplayer2.a.c
    public void release() {
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected boolean dwD() {
        return this.myy != this.myz;
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected com.google.android.exoplayer2.text.e dwE() {
        this.myz = this.myy;
        return new f(this.myy);
    }

    @Override // com.google.android.exoplayer2.text.a.d
    protected void b(h hVar) {
        this.myt.G(hVar.data.array(), hVar.data.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.myt.dyh() >= this.myu) {
            byte readUnsignedByte = this.myu == 2 ? (byte) -4 : (byte) this.myt.readUnsignedByte();
            byte readUnsignedByte2 = (byte) (this.myt.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.myt.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && (this.myv != 1 || (readUnsignedByte & 1) == 0)) {
                if (this.myv != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.myx.append(h(readUnsignedByte3));
                            z2 = true;
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.myx.dwJ();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.myx.append(i(readUnsignedByte3));
                                z2 = true;
                            } else {
                                this.myx.append(j(readUnsignedByte3));
                                z2 = true;
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z = c(readUnsignedByte2, readUnsignedByte3);
                            z2 = true;
                        } else {
                            this.myx.append(g(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.myx.append(g(readUnsignedByte3));
                            }
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.myC = false;
            }
            if (this.myA == 1 || this.myA == 3) {
                this.myy = dwF();
            }
        }
    }

    private boolean c(byte b, byte b2) {
        boolean k = k(b);
        if (k) {
            if (this.myC && this.myD == b && this.myE == b2) {
                this.myC = false;
                return true;
            }
            this.myC = true;
            this.myD = b;
            this.myE = b2;
        }
        if (e(b, b2)) {
            e(b2);
        } else if (f(b, b2)) {
            d(b, b2);
        } else if (g(b, b2)) {
            this.myx.Li(b2 - 32);
        } else if (h(b, b2)) {
            f(b2);
        }
        return k;
    }

    private void e(byte b) {
        this.myx.vF((b & 1) == 1);
        int i = (b >> 1) & 15;
        if (i == 7) {
            this.myx.a(new StyleSpan(2), 2);
            this.myx.a(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.myx.a(new ForegroundColorSpan(COLORS[i]), 1);
    }

    private void d(byte b, byte b2) {
        int i = myn[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.myx.getRow()) {
            if (this.myA != 1 && !this.myx.isEmpty()) {
                this.myx = new C0676a(this.myA, this.myB);
                this.myw.add(this.myx);
            }
            this.myx.mh(i);
        }
        if ((b2 & 1) == 1) {
            this.myx.a(new UnderlineSpan());
        }
        int i2 = (b2 >> 1) & 15;
        if (i2 <= 7) {
            if (i2 == 7) {
                this.myx.a(new StyleSpan(2));
                this.myx.a(new ForegroundColorSpan(-1));
                return;
            }
            this.myx.a(new ForegroundColorSpan(COLORS[i2]));
            return;
        }
        this.myx.Lh(myo[i2 & 7]);
    }

    private void f(byte b) {
        switch (b) {
            case 32:
                Lg(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                if (this.myA != 0) {
                    switch (b) {
                        case 33:
                            this.myx.dwJ();
                            return;
                        case 44:
                            this.myy = null;
                            if (this.myA == 1 || this.myA == 3) {
                                dwG();
                                return;
                            }
                            return;
                        case 45:
                            if (this.myA == 1 && !this.myx.isEmpty()) {
                                this.myx.dwK();
                                return;
                            }
                            return;
                        case 46:
                            dwG();
                            return;
                        case 47:
                            this.myy = dwF();
                            dwG();
                            return;
                        default:
                            return;
                    }
                }
                return;
            case 37:
                this.myB = 2;
                Lg(1);
                return;
            case 38:
                this.myB = 3;
                Lg(1);
                return;
            case 39:
                this.myB = 4;
                Lg(1);
                return;
            case 41:
                Lg(3);
                return;
        }
    }

    private List<com.google.android.exoplayer2.text.b> dwF() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.myw.size()) {
                com.google.android.exoplayer2.text.b dwM = this.myw.get(i2).dwM();
                if (dwM != null) {
                    arrayList.add(dwM);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    private void Lg(int i) {
        if (this.myA != i) {
            int i2 = this.myA;
            this.myA = i;
            dwG();
            if (i2 == 3 || i == 1 || i == 0) {
                this.myy = null;
            }
        }
    }

    private void dwG() {
        this.myx.dO(this.myA, this.myB);
        this.myw.clear();
        this.myw.add(this.myx);
    }

    private static char g(byte b) {
        return (char) myp[(b & Byte.MAX_VALUE) - 32];
    }

    private static char h(byte b) {
        return (char) myq[b & 15];
    }

    private static char i(byte b) {
        return (char) myr[b & 31];
    }

    private static char j(byte b) {
        return (char) mys[b & 31];
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
    /* loaded from: classes5.dex */
    public static class C0676a {
        private int myA;
        private int myB;
        private final List<CharacterStyle> myF = new ArrayList();
        private final List<C0677a> myG = new ArrayList();
        private final List<SpannableString> myH = new LinkedList();
        private final SpannableStringBuilder myI = new SpannableStringBuilder();
        private int myJ;
        private int myK;
        private int myL;
        private int row;

        public C0676a(int i, int i2) {
            dO(i, i2);
        }

        public void dO(int i, int i2) {
            this.myF.clear();
            this.myG.clear();
            this.myH.clear();
            this.myI.clear();
            this.row = 15;
            this.myJ = 0;
            this.myK = 0;
            this.myA = i;
            this.myB = i2;
            this.myL = -1;
        }

        public boolean isEmpty() {
            return this.myF.isEmpty() && this.myG.isEmpty() && this.myH.isEmpty() && this.myI.length() == 0;
        }

        public void dwJ() {
            int length = this.myI.length();
            if (length > 0) {
                this.myI.delete(length - 1, length);
            }
        }

        public int getRow() {
            return this.row;
        }

        public void mh(int i) {
            this.row = i;
        }

        public void dwK() {
            this.myH.add(dwL());
            this.myI.clear();
            this.myF.clear();
            this.myG.clear();
            this.myL = -1;
            int min = Math.min(this.myB, this.row);
            while (this.myH.size() >= min) {
                this.myH.remove(0);
            }
        }

        public void Lh(int i) {
            this.myJ = i;
        }

        public void Li(int i) {
            this.myK = i;
        }

        public void a(CharacterStyle characterStyle) {
            this.myF.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.myG.add(new C0677a(characterStyle, this.myI.length(), i));
        }

        public void vF(boolean z) {
            if (z) {
                this.myL = this.myI.length();
            } else if (this.myL != -1) {
                this.myI.setSpan(new UnderlineSpan(), this.myL, this.myI.length(), 33);
                this.myL = -1;
            }
        }

        public void append(char c) {
            this.myI.append(c);
        }

        public SpannableString dwL() {
            int i = 0;
            int length = this.myI.length();
            for (int i2 = 0; i2 < this.myF.size(); i2++) {
                this.myI.setSpan(this.myF.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.myG.size()) {
                    break;
                }
                C0677a c0677a = this.myG.get(i3);
                this.myI.setSpan(c0677a.myM, c0677a.start, i3 < this.myG.size() - c0677a.myN ? this.myG.get(c0677a.myN + i3).start : length, 33);
                i = i3 + 1;
            }
            if (this.myL != -1) {
                this.myI.setSpan(new UnderlineSpan(), this.myL, length, 33);
            }
            return new SpannableString(this.myI);
        }

        public com.google.android.exoplayer2.text.b dwM() {
            int length;
            float f;
            int i;
            int i2;
            int i3 = 2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.myH.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.myH.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) dwL());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.myJ + this.myK;
            int length2 = i5 - ((32 - i5) - spannableStringBuilder.length());
            if (this.myA == 2 && Math.abs(length2) < 3) {
                f = 0.5f;
                i = 1;
            } else if (this.myA == 2 && length2 > 0) {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            } else {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            }
            if (this.myA == 1 || this.row > 7) {
                i2 = (this.row - 15) - 2;
            } else {
                i3 = 0;
                i2 = this.row;
            }
            return new com.google.android.exoplayer2.text.b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.myI.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.exoplayer2.text.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0677a {
            public final CharacterStyle myM;
            public final int myN;
            public final int start;

            public C0677a(CharacterStyle characterStyle, int i, int i2) {
                this.myM = characterStyle;
                this.start = i;
                this.myN = i2;
            }
        }
    }
}
