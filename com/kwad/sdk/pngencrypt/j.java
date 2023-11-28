package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes10.dex */
public final class j extends DeflatedChunksSet {
    public final e aID;
    public final p aJA;
    public int[] aJB;
    public byte[] aJx;
    public byte[] aJy;
    public final k aJz;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] aJC;

        static {
            int[] iArr = new int[FilterType.values().length];
            aJC = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aJC[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aJC[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aJC[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aJC[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, r12 + 1, kVar.aJL + 1, null, null);
        int i;
        if (eVar != null) {
            i = eVar.Iv();
        } else {
            i = kVar.aJL;
        }
        this.aJB = new int[5];
        this.aJz = kVar;
        this.aID = eVar;
        this.aJA = new p(kVar, eVar);
        com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void Iw() {
        dk(this.aJA.aKh);
    }

    private int Ix() {
        int Iv;
        e eVar = this.aID;
        int i = 0;
        if (eVar == null) {
            int In = In();
            k kVar = this.aJz;
            if (In < kVar.aJk - 1) {
                Iv = kVar.aJL;
                i = Iv + 1;
            }
        } else if (eVar.Io()) {
            Iv = this.aID.Iv();
            i = Iv + 1;
        }
        if (!this.aIG) {
            dg(i);
        }
        return i;
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void Ik() {
        super.Ik();
        this.aJA.update(In());
        Iw();
        p pVar = this.aJA;
        pVar.h(this.aJx, pVar.aKh + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int Il() {
        return Ix();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aJx = null;
        this.aJy = null;
    }

    private void dk(int i) {
        byte[] bArr = this.aJx;
        if (bArr == null || bArr.length < this.aIW.length) {
            byte[] bArr2 = this.aIW;
            this.aJx = new byte[bArr2.length];
            this.aJy = new byte[bArr2.length];
        }
        if (this.aJA.aKe == 0) {
            Arrays.fill(this.aJx, (byte) 0);
        }
        byte[] bArr3 = this.aJx;
        this.aJx = this.aJy;
        this.aJy = bArr3;
        byte b = this.aIW[0];
        if (FilterType.isValidStandard(b)) {
            FilterType byVal = FilterType.getByVal(b);
            int[] iArr = this.aJB;
            iArr[b] = iArr[b] + 1;
            this.aJx[0] = this.aIW[0];
            int i2 = AnonymousClass1.aJC[byVal.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                dn(i);
                                return;
                            }
                            throw new PngjException("Filter type " + ((int) b) + " not implemented");
                        }
                        dl(i);
                        return;
                    }
                    dp(i);
                    return;
                }
                m187do(i);
                return;
            }
            dm(i);
            return;
        }
        throw new PngjException("Filter type " + ((int) b) + " invalid");
    }

    private void dl(int i) {
        int i2;
        int i3 = 1;
        int i4 = 1 - this.aJz.aJK;
        while (i3 <= i) {
            if (i4 > 0) {
                i2 = this.aJx[i4] & 255;
            } else {
                i2 = 0;
            }
            this.aJx[i3] = (byte) (this.aIW[i3] + ((i2 + (this.aJy[i3] & 255)) / 2));
            i3++;
            i4++;
        }
    }

    private void dm(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aJx[i2] = this.aIW[i2];
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m187do(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.aJz.aJK;
            if (i3 > i2) {
                break;
            }
            this.aJx[i3] = this.aIW[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.aJx;
            bArr[i4] = (byte) (this.aIW[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void dp(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aJx[i2] = (byte) (this.aIW[i2] + this.aJy[i2]);
        }
    }

    private void dn(int i) {
        int i2;
        int i3 = 1;
        int i4 = 1 - this.aJz.aJK;
        while (i3 <= i) {
            int i5 = 0;
            if (i4 > 0) {
                i2 = this.aJx[i4] & 255;
            } else {
                i2 = 0;
            }
            if (i4 > 0) {
                i5 = this.aJy[i4] & 255;
            }
            this.aJx[i3] = (byte) (this.aIW[i3] + n.b(i2, this.aJy[i3] & 255, i5));
            i3++;
            i4++;
        }
    }
}
