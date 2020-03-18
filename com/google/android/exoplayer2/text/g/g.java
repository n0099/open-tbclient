package com.google.android.exoplayer2.text.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.g.e;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class g extends com.google.android.exoplayer2.text.c {
    private final f mEf;
    private final l mEg;
    private final e.a mEh;
    private final a mEi;
    private final List<d> mEj;

    public g() {
        super("WebvttDecoder");
        this.mEf = new f();
        this.mEg = new l();
        this.mEh = new e.a();
        this.mEi = new a();
        this.mEj = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: h */
    public i b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mEg.I(bArr, i);
        this.mEh.reset();
        this.mEj.clear();
        h.ae(this.mEg);
        do {
        } while (!TextUtils.isEmpty(this.mEg.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int ac = ac(this.mEg);
            if (ac != 0) {
                if (ac == 1) {
                    ad(this.mEg);
                } else if (ac == 2) {
                    if (!arrayList.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.mEg.readLine();
                    d W = this.mEi.W(this.mEg);
                    if (W != null) {
                        this.mEj.add(W);
                    }
                } else if (ac == 3 && this.mEf.a(this.mEg, this.mEh, this.mEj)) {
                    arrayList.add(this.mEh.dyS());
                    this.mEh.reset();
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
