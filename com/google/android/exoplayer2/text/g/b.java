package com.google.android.exoplayer2.text.g;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.g.e;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class b extends com.google.android.exoplayer2.text.c {
    private static final int mBm = v.Qr("payl");
    private static final int mBn = v.Qr("sttg");
    private static final int mBo = v.Qr("vttc");
    private final e.a mBp;
    private final l mlM;

    public b() {
        super("Mp4WebvttDecoder");
        this.mlM = new l();
        this.mBp = new e.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.c
    /* renamed from: g */
    public c b(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.mlM.G(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.mlM.dyh() > 0) {
            if (this.mlM.dyh() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int readInt = this.mlM.readInt();
            if (this.mlM.readInt() == mBo) {
                arrayList.add(a(this.mlM, this.mBp, readInt - 8));
            } else {
                this.mlM.skipBytes(readInt - 8);
            }
        }
        return new c(arrayList);
    }

    private static com.google.android.exoplayer2.text.b a(l lVar, e.a aVar, int i) throws SubtitleDecoderException {
        aVar.reset();
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int readInt = lVar.readInt();
            int readInt2 = lVar.readInt();
            int i2 = readInt - 8;
            String str = new String(lVar.data, lVar.getPosition(), i2);
            lVar.skipBytes(i2);
            i = (i - 8) - i2;
            if (readInt2 == mBn) {
                f.a(str, aVar);
            } else if (readInt2 == mBm) {
                f.a((String) null, str.trim(), aVar, Collections.emptyList());
            }
        }
        return aVar.dxi();
    }
}
