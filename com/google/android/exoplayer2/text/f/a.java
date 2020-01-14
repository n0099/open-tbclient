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
/* loaded from: classes5.dex */
public final class a extends c {
    private static final int mAY = v.Qr("styl");
    private static final int mAZ = v.Qr("tbox");
    private final l mBa;
    private boolean mBb;
    private int mBc;
    private int mBd;
    private String mBe;
    private float mBf;
    private int mBh;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.mBa = new l();
        fp(list);
    }

    private void fp(List<byte[]> list) {
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.mBc = bArr[24];
            this.mBd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.mBe = "Serif".equals(new String(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
            this.mBh = bArr[25] * 20;
            this.mBb = (bArr[0] & 32) != 0;
            if (this.mBb) {
                this.mBf = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.mBh;
                this.mBf = v.g(this.mBf, 0.0f, 0.95f);
                return;
            }
            this.mBf = 0.85f;
            return;
        }
        this.mBc = 0;
        this.mBd = -1;
        this.mBe = "sans-serif";
        this.mBb = false;
        this.mBf = 0.85f;
    }

    @Override // com.google.android.exoplayer2.text.c
    protected e b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mBa.G(bArr, i);
        String V = V(this.mBa);
        if (V.isEmpty()) {
            return b.mBi;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(V);
        a(spannableStringBuilder, this.mBc, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.mBd, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.mBe, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f = this.mBf;
        while (this.mBa.dyh() >= 8) {
            int position = this.mBa.getPosition();
            int readInt = this.mBa.readInt();
            int readInt2 = this.mBa.readInt();
            if (readInt2 == mAY) {
                vK(this.mBa.dyh() >= 2);
                int readUnsignedShort = this.mBa.readUnsignedShort();
                for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                    a(this.mBa, spannableStringBuilder);
                }
            } else if (readInt2 == mAZ && this.mBb) {
                vK(this.mBa.dyh() >= 2);
                f = v.g(this.mBa.readUnsignedShort() / this.mBh, 0.0f, 0.95f);
            }
            this.mBa.setPosition(position + readInt);
        }
        return new b(new com.google.android.exoplayer2.text.b(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static String V(l lVar) throws SubtitleDecoderException {
        char dyj;
        vK(lVar.dyh() >= 2);
        int readUnsignedShort = lVar.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (lVar.dyh() >= 2 && ((dyj = lVar.dyj()) == 65279 || dyj == 65534)) {
            return lVar.a(readUnsignedShort, Charset.forName("UTF-16"));
        }
        return lVar.a(readUnsignedShort, Charset.forName("UTF-8"));
    }

    private void a(l lVar, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        vK(lVar.dyh() >= 12);
        int readUnsignedShort = lVar.readUnsignedShort();
        int readUnsignedShort2 = lVar.readUnsignedShort();
        lVar.skipBytes(2);
        int readUnsignedByte = lVar.readUnsignedByte();
        lVar.skipBytes(1);
        int readInt = lVar.readInt();
        a(spannableStringBuilder, readUnsignedByte, this.mBc, readUnsignedShort, readUnsignedShort2, 0);
        b(spannableStringBuilder, readInt, this.mBd, readUnsignedShort, readUnsignedShort2, 0);
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

    private static void vK(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
