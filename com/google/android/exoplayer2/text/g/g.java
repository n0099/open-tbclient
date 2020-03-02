package com.google.android.exoplayer2.text.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.g.e;
import com.google.android.exoplayer2.util.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class g extends com.google.android.exoplayer2.text.c {
    private final f mCk;
    private final l mCl;
    private final e.a mCm;
    private final a mCn;
    private final List<d> mCo;

    public g() {
        super("WebvttDecoder");
        this.mCk = new f();
        this.mCl = new l();
        this.mCm = new e.a();
        this.mCn = new a();
        this.mCo = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: h */
    public i b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mCl.I(bArr, i);
        this.mCm.reset();
        this.mCo.clear();
        h.ae(this.mCl);
        do {
        } while (!TextUtils.isEmpty(this.mCl.readLine()));
        ArrayList arrayList = new ArrayList();
        while (true) {
            int ac = ac(this.mCl);
            if (ac != 0) {
                if (ac == 1) {
                    ad(this.mCl);
                } else if (ac == 2) {
                    if (!arrayList.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.mCl.readLine();
                    d W = this.mCn.W(this.mCl);
                    if (W != null) {
                        this.mCo.add(W);
                    }
                } else if (ac == 3 && this.mCk.a(this.mCl, this.mCm, this.mCo)) {
                    arrayList.add(this.mCm.dyu());
                    this.mCm.reset();
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
