package com.google.android.exoplayer2.text.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.g.e;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class g extends com.google.android.exoplayer2.text.c {
    private final f mBC;
    private final l mBD;
    private final e.a mBE;
    private final a mBF;
    private final List<d> mBG;

    public g() {
        super("WebvttDecoder");
        this.mBC = new f();
        this.mBD = new l();
        this.mBE = new e.a();
        this.mBF = new a();
        this.mBG = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: h */
    public i b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mBD.G(bArr, i);
        this.mBE.reset();
        this.mBG.clear();
        h.ae(this.mBD);
        do {
        } while (!TextUtils.isEmpty(this.mBD.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int ac = ac(this.mBD);
            if (ac != 0) {
                if (ac == 1) {
                    ad(this.mBD);
                } else if (ac == 2) {
                    if (!arrayList.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.mBD.readLine();
                    d W = this.mBF.W(this.mBD);
                    if (W != null) {
                        this.mBG.add(W);
                    }
                } else if (ac == 3 && this.mBC.a(this.mBD, this.mBE, this.mBG)) {
                    arrayList.add(this.mBE.dxi());
                    this.mBE.reset();
                }
            } else {
                return new i(arrayList);
            }
        }
    }

    private static int ac(l lVar) {
        int i;
        int i2 = 0;
        int i3 = -1;
        while (i3 == -1) {
            int position = lVar.getPosition();
            String readLine = lVar.readLine();
            if (readLine == null) {
                i = 0;
            } else if ("STYLE".equals(readLine)) {
                i = 2;
            } else if ("NOTE".startsWith(readLine)) {
                i = 1;
            } else {
                i = 3;
            }
            i3 = i;
            i2 = position;
        }
        lVar.setPosition(i2);
        return i3;
    }

    private static void ad(l lVar) {
        do {
        } while (!TextUtils.isEmpty(lVar.readLine()));
    }
}
