package com.google.android.exoplayer2.text.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.nio.charset.Charset;
import java.util.List;
/* loaded from: classes6.dex */
public final class a extends c {
    private static final int mBS = v.QF("styl");
    private static final int mBT = v.QF("tbox");
    private final l mBU;
    private boolean mBV;
    private int mBW;
    private int mBX;
    private String mBY;
    private float mBZ;
    private int mCa;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.mBU = new l();
        fk(list);
    }

    private void fk(List<byte[]> list) {
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.mBW = bArr[24];
            this.mBX = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.mBY = "Serif".equals(new String(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
            this.mCa = bArr[25] * 20;
            this.mBV = (bArr[0] & 32) != 0;
            if (this.mBV) {
                this.mBZ = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.mCa;
                this.mBZ = v.g(this.mBZ, 0.0f, 0.95f);
                return;
            }
            this.mBZ = 0.85f;
            return;
        }
        this.mBW = 0;
        this.mBX = -1;
        this.mBY = "sans-serif";
        this.mBV = false;
        this.mBZ = 0.85f;
    }

    @Override // com.google.android.exoplayer2.text.c
    protected e b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mBU.I(bArr, i);
        String V = V(this.mBU);
        if (V.isEmpty()) {
            return b.mCb;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(V);
        a(spannableStringBuilder, this.mBW, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.mBX, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.mBY, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f = this.mBZ;
        while (this.mBU.dzu() >= 8) {
            int position = this.mBU.getPosition();
            int readInt = this.mBU.readInt();
            int readInt2 = this.mBU.readInt();
            if (readInt2 == mBS) {
                vO(this.mBU.dzu() >= 2);
                int readUnsignedShort = this.mBU.readUnsignedShort();
                for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                    a(this.mBU, spannableStringBuilder);
                }
            } else if (readInt2 == mBT && this.mBV) {
                vO(this.mBU.dzu() >= 2);
                f = v.g(this.mBU.readUnsignedShort() / this.mCa, 0.0f, 0.95f);
            }
            this.mBU.setPosition(position + readInt);
        }
        return new b(new com.google.android.exoplayer2.text.b(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static String V(l lVar) throws SubtitleDecoderException {
        char dzw;
        vO(lVar.dzu() >= 2);
        int readUnsignedShort = lVar.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (lVar.dzu() >= 2 && ((dzw = lVar.dzw()) == 65279 || dzw == 65534)) {
            return lVar.a(readUnsignedShort, Charset.forName("UTF-16"));
        }
        return lVar.a(readUnsignedShort, Charset.forName("UTF-8"));
    }

    private void a(l lVar, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        vO(lVar.dzu() >= 12);
        int readUnsignedShort = lVar.readUnsignedShort();
        int readUnsignedShort2 = lVar.readUnsignedShort();
        lVar.skipBytes(2);
        int readUnsignedByte = lVar.readUnsignedByte();
        lVar.skipBytes(1);
        int readInt = lVar.readInt();
        a(spannableStringBuilder, readUnsignedByte, this.mBW, readUnsignedShort, readUnsignedShort2, 0);
        b(spannableStringBuilder, readInt, this.mBX, readUnsignedShort, readUnsignedShort2, 0);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z3 && !z && !z2) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & 255) << 24) | (i >>> 8)), i3, i4, i5 | 33);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private static void vO(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
