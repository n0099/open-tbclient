package com.google.android.exoplayer2.text.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.g.e;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class g extends com.google.android.exoplayer2.text.c {
    private final f mxI;
    private final l mxJ;
    private final e.a mxK;
    private final a mxL;
    private final List<d> mxM;

    public g() {
        super("WebvttDecoder");
        this.mxI = new f();
        this.mxJ = new l();
        this.mxK = new e.a();
        this.mxL = new a();
        this.mxM = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: h */
    public i b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mxJ.G(bArr, i);
        this.mxK.reset();
        this.mxM.clear();
        h.ae(this.mxJ);
        do {
        } while (!TextUtils.isEmpty(this.mxJ.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int ac = ac(this.mxJ);
            if (ac != 0) {
                if (ac == 1) {
                    ad(this.mxJ);
                } else if (ac == 2) {
                    if (!arrayList.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.mxJ.readLine();
                    d W = this.mxL.W(this.mxJ);
                    if (W != null) {
                        this.mxM.add(W);
                    }
                } else if (ac == 3 && this.mxI.a(this.mxJ, this.mxK, this.mxM)) {
                    arrayList.add(this.mxK.dvV());
                    this.mxK.reset();
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
