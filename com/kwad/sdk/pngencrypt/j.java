package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes10.dex */
public final class j extends DeflatedChunksSet {
    public final e ajN;
    public byte[] akH;
    public byte[] akI;
    public final k akJ;
    public final p akK;
    public int[] akL;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] akM;

        static {
            int[] iArr = new int[FilterType.values().length];
            akM = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                akM[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                akM[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                akM[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                akM[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    public j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.ys() : kVar.akV) + 1, kVar.akV + 1, null, null);
        this.akL = new int[5];
        this.akJ = kVar;
        this.ajN = eVar;
        this.akK = new p(kVar, eVar);
        com.kwad.sdk.core.e.b.d("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void bl(int i) {
        byte[] bArr = this.akH;
        if (bArr == null || bArr.length < this.akg.length) {
            byte[] bArr2 = this.akg;
            this.akH = new byte[bArr2.length];
            this.akI = new byte[bArr2.length];
        }
        if (this.akK.alo == 0) {
            Arrays.fill(this.akH, (byte) 0);
        }
        byte[] bArr3 = this.akH;
        this.akH = this.akI;
        this.akI = bArr3;
        byte b = this.akg[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.akL;
        iArr[b] = iArr[b] + 1;
        this.akH[0] = this.akg[0];
        int i2 = AnonymousClass1.akM[byVal.ordinal()];
        if (i2 == 1) {
            bn(i);
        } else if (i2 == 2) {
            bp(i);
        } else if (i2 == 3) {
            bq(i);
        } else if (i2 == 4) {
            bm(i);
        } else if (i2 == 5) {
            bo(i);
        } else {
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    private void bm(int i) {
        int i2 = 1;
        int i3 = 1 - this.akJ.akU;
        while (i2 <= i) {
            this.akH[i2] = (byte) (this.akg[i2] + (((i3 > 0 ? this.akH[i3] & 255 : 0) + (this.akI[i2] & 255)) / 2));
            i2++;
            i3++;
        }
    }

    private void bn(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.akH[i2] = this.akg[i2];
        }
    }

    private void bo(int i) {
        int i2 = 1;
        int i3 = 1 - this.akJ.akU;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.akH[i3] & 255 : 0;
            if (i3 > 0) {
                i4 = this.akI[i3] & 255;
            }
            this.akH[i2] = (byte) (this.akg[i2] + n.b(i5, this.akI[i2] & 255, i4));
            i2++;
            i3++;
        }
    }

    private void bp(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.akJ.akU;
            if (i3 > i2) {
                break;
            }
            this.akH[i3] = this.akg[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.akH;
            bArr[i4] = (byte) (this.akg[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void bq(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.akH[i2] = (byte) (this.akg[i2] + this.akI[i2]);
        }
    }

    private void yt() {
        bl(this.akK.alr);
    }

    private int yu() {
        int ys;
        e eVar = this.ajN;
        int i = 0;
        if (eVar == null) {
            int yk = yk();
            k kVar = this.akJ;
            if (yk < kVar.aku - 1) {
                ys = kVar.akV;
                i = ys + 1;
            }
        } else if (eVar.yl()) {
            ys = this.ajN.ys();
            i = ys + 1;
        }
        if (!this.ajQ) {
            bh(i);
        }
        return i;
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.akH = null;
        this.akI = null;
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void yh() {
        super.yh();
        this.akK.update(yk());
        yt();
        p pVar = this.akK;
        pVar.h(this.akH, pVar.alr + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int yi() {
        return yu();
    }
}
